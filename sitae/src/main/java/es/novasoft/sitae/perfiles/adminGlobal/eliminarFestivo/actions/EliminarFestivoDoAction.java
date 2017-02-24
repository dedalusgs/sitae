package es.novasoft.sitae.perfiles.adminGlobal.eliminarFestivo.actions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;

public class EliminarFestivoDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	FestivoService festivoService = (FestivoService) Factory
			.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Festivo festivo = new Festivo();

		try {

			String idFestivo = (String) request
					.getParameter("idFestivoSeleccionado");

			if (idFestivo != null && !idFestivo.equals("")) {

				festivo = festivoService.findById(Integer.valueOf(idFestivo));

				Organismo organismo = festivo.getOrganismo();
				Calendar fecha=new GregorianCalendar();
				fecha.setTime(festivo.getFecha());
				
				Integer anioFestivo= fecha.get(Calendar.YEAR);
				
				
				Integer anioActual=(Integer)request.getSession().getAttribute("anio");
				
				if (anioFestivo.equals(anioActual)  && organismo==null){		
					festivoService.delete(festivo);
				}else {
					return forward(request, mapping, ActionBase.ERROR_KEY);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaFestivoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
