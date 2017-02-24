package es.novasoft.sitae.perfiles.adminLocal.estadisticasPublicacion.actions;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.icu.util.Calendar;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.adminLocal.estadisticasPublicacion.forms.EstadisticasPublicacionForm;

public class EstadisticasPublicacionFrontAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			
		
			EstadisticasPublicacionForm formulario = (EstadisticasPublicacionForm) form;
							
			
			int anioActual=new GregorianCalendar().get(Calendar.YEAR);
			GregorianCalendar fechaInicio= new GregorianCalendar();
			fechaInicio.set(anioActual, Calendar.JANUARY, 1);
			GregorianCalendar fechaFin= new GregorianCalendar();
			fechaFin.set(anioActual, Calendar.DECEMBER, 31);
			
			
			
			formulario.setFechaInicio(FechasUtil.convertDateToString(fechaInicio.getTime(),FechasUtil.typeSdfDate));
			formulario.setFechaFin(FechasUtil.convertDateToString(fechaFin.getTime(),FechasUtil.typeSdfDate));
			formulario.setUrlImageChart(null);
			String cif = (String) request.getSession().getAttribute("cif");
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			Organismo organismo = (Organismo) organismoService.findByCif(cif)
					.get(Constantes.CERO_INT);
			
			formulario.setOpcionOrganismo(organismo.getIdOrg().toString());
			

			request.setAttribute("EstadisticasPublicacionForm", formulario);
			

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en EstadisticasPublicacionFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	

}
