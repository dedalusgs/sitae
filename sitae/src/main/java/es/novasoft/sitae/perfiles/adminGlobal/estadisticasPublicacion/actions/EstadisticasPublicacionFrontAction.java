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
import es.novasoft.sitae.business.dao.impl.EdictoDAOImpl;
import es.novasoft.sitae.business.dao.interfaz.EdictoDAO;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.estadisticasPublicacion.forms.EstadisticasPublicacionForm;
import es.novasoft.sitae.perfiles.adminGlobal.visualizarAdmLocales.forms.VisualizarAdmLocalForm;

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
			
			List listaOrganismos = organismoService.findAll();
			EstadisticasPublicacionForm formulario = (EstadisticasPublicacionForm) form;
			Iterator<Organismo> iterador =listaOrganismos.iterator();
			ArrayList<LabelValueBean> listaOrgLabelValue= new ArrayList<LabelValueBean>();
			while (iterador.hasNext()){
				Organismo org= iterador.next();
				LabelValueBean label= new LabelValueBean();
				label.setLabel(org.getNombre());
				label.setValue(org.getIdOrg().toString());
				listaOrgLabelValue.add(label); 
				
			}
					
			
			int anioActual=new GregorianCalendar().get(Calendar.YEAR);
			GregorianCalendar fechaInicio= new GregorianCalendar();
			fechaInicio.set(anioActual, Calendar.JANUARY, 1);
			GregorianCalendar fechaFin= new GregorianCalendar();
			fechaFin.set(anioActual, Calendar.DECEMBER, 31);
			
			
			formulario.setListaOrganismos(listaOrgLabelValue);
			formulario.setFechaInicio(FechasUtil.convertDateToString(fechaInicio.getTime(),FechasUtil.typeSdfDate));
			formulario.setFechaFin(FechasUtil.convertDateToString(fechaFin.getTime(),FechasUtil.typeSdfDate));
			formulario.setUrlImageChart(null);
			formulario.setOpcionOrganismo("");
			

			request.setAttribute("EstadisticasPublicacionForm", formulario);
			

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en EstadisticasPublicacionFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	

}
