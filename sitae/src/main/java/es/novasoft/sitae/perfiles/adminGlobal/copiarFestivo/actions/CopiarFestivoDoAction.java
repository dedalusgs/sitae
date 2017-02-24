package es.novasoft.sitae.perfiles.adminGlobal.copiarFestivo.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
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
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;

public class CopiarFestivoDoAction extends ActionBase {

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
            
					
			String cif = (String) request.getSession().getAttribute("cif");
			
			List busqueda=organismoService.findByCif(cif);
			if (busqueda.isEmpty()){
				return forward(request, mapping, ActionBase.ERROR_KEY);
				
			}
			Integer anioActual=(Integer)request.getSession().getAttribute("anio");
			Integer anioAnterior =anioActual-1;
			Organismo organismo=null;
			List<Festivo> listaFestivosLocales = festivoService.findByOrgAnio(organismo, anioAnterior);	
			if (listaFestivosLocales.isEmpty()){
				return forward(request, mapping, ActionBase.ERROR_KEY_2);
				
			}
			Iterator<Festivo> iterador=listaFestivosLocales.iterator();
			while (iterador.hasNext()){
				Festivo festivoAnt=iterador.next();
				Festivo festivoNu=new Festivo();
				festivoNu.setNombre(festivoAnt.getNombre());
				Date fechaNuev=FechasUtil.addYearZeroHour(festivoAnt.getFecha(), 1);
				festivoNu.setFecha(fechaNuev);
				festivoNu.setOrganismo(organismo);
				festivoService.save(festivoNu);
			
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaFestivoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
