package es.novasoft.sitae.perfiles.adminGlobal.estadisticasPublicacion.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.ibm.icu.util.Calendar;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoUsuarioOrganismo;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.UtilImageChart;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.estadisticasPublicacion.forms.EstadisticasPublicacionForm;
import es.novasoft.sitae.perfiles.adminGlobal.visualizarAdmLocales.forms.VisualizarAdmLocalForm;

public class EstadisticasPublicacionDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			
			
			EstadisticasPublicacionForm formulario = (EstadisticasPublicacionForm) form;
			
				String organismoString=formulario.getOpcionOrganismo();
				StringBuffer url=new StringBuffer( UtilImageChart.generarURLEstadisticasPublicacion(organismoString, formulario.getFechaInicio(),formulario.getFechaFin(),false));
				String urlOrgExt= UtilImageChart.generarURLEstadisticasPublicacionOrgExter(organismoString, formulario.getFechaInicio(),formulario.getFechaFin(),false);
				
				formulario.setUrlImageChart(url.toString());
				formulario.setUrlImageChartExtern(urlOrgExt);
			request.setAttribute("EstadisticasPublicacionForm", formulario);	

		} catch (Exception e) {
			
			LOGGER.error("Error en EstadisticasPublicacionFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	

}
