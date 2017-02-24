package es.novasoft.sitae.perfiles.adminGlobal.visualizarFestivo.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.visualizarFestivo.forms.VisualizarFestivoForm;

public class VisualizarFestivoFrontAction extends ActionBase {

	static private String ANIO="anio";
	
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			
			
			Calendar fechaActual=new GregorianCalendar();
			if (request.getSession().getAttribute(ANIO) == null) {
				
				request.getSession().setAttribute(ANIO,  fechaActual.get(Calendar.YEAR));
			}
			
			VisualizarFestivoForm formulario = (VisualizarFestivoForm) form;
			
			if(request.getParameter("actualizaAnio")!=null && request.getParameter("actualizaAnio").equalsIgnoreCase("si")){
				request.getSession().setAttribute(ANIO,  formulario.getAnio());
			}
			

			

			formulario = rellenaFormulario(formulario, ciudadano, request);

			request.setAttribute("VisualizarFestivoForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarFestivoForm rellenaFormulario(
			VisualizarFestivoForm formulario, UsuarioAutentificado usuario,
			HttpServletRequest request) throws Exception {

		// RELLENAMOS EL FORMULARIO CON EL LISTADO DE CENTROS
		String cif = (String) request.getSession().getAttribute("cif");
		
		
		Integer anio=(Integer)request.getSession().getAttribute(ANIO);

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		FestivoService festivoService = (FestivoService) Factory
				.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);

		Organismo organismo = (Organismo) organismoService.findByCif(cif).get(
				Constantes.CERO_INT);
		
		//List<Festivo> listaFestivosLocales = festivoService.findByOrgAnio(organismo, anio);
		List<Festivo> listaFestivosNacionales = festivoService.findByOrgAnio(null, anio);
		
		//formulario.setDiasFestivosLocales(listaFestivosLocales);
		formulario.setDiasFestivosNacionales(listaFestivosNacionales);
		formulario.setAnio(anio);
		Calendar fechaActual=new GregorianCalendar();
		ArrayList<LabelValueBean> listaAnio=new ArrayList<LabelValueBean>();
		String anioAnterior=Integer.toString((fechaActual.get(Calendar.YEAR)-1));
		String anioActual=Integer.toString(new Integer(fechaActual.get(Calendar.YEAR)));
		String anioPosterior=Integer.toString(new Integer(fechaActual.get(Calendar.YEAR)+1));
		
		LabelValueBean parAux = new LabelValueBean(anioAnterior,anioAnterior);
		listaAnio.add(parAux);
	    parAux = new LabelValueBean(anioActual,anioActual);
		listaAnio.add(parAux);
		parAux = new LabelValueBean(anioPosterior,anioPosterior);
		listaAnio.add(parAux);
		formulario.setListadoAnios(listaAnio);
		

		return formulario;

	}

}
