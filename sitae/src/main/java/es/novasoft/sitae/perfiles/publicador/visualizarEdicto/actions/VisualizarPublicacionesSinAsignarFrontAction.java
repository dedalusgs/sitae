package es.novasoft.sitae.perfiles.publicador.visualizarEdicto.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.publicador.visualizarEdicto.forms.VisualizarPublicacionesSinAsignarForm;

public class VisualizarPublicacionesSinAsignarFrontAction extends ActionBase {
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			// Reseteamos el formulario si retrocedemos al listado
			if (request.getParameter("volver") != null) {
				ResetForm.removeBean(mapping, request);
			}
			
			VisualizarPublicacionesSinAsignarForm formulario = (VisualizarPublicacionesSinAsignarForm) form;
			
			// Se tienen que mostrar los edictos del organismo del publicador
			
			/*
			 * String cif = (String) request.getSession().getAttribute("cif");
			 * if(request.getParameter("filtrar")==null){ formulario =
			 * rellenaFormulario(formulario, cif, request); }else{ formulario =
			 * filtrar(formulario, cif, request); }
			 */
			
			String cif = (String) request.getSession().getAttribute("cif");
			
			Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
			
			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}
			
			formulario = rellenaFormulario(formulario, cif, request, lenguaje);
			
			// Elimino de la session los valores del crearEdicto cuando pinchas
			// en volver
			
			if (request.getSession().getAttribute("fechaPublicacion") != null) {
				request.getSession().setAttribute("fechaPublicacion", null);
			}
			if (request.getSession().getAttribute("diasPublicacion") != null) {
				request.getSession().setAttribute("diasPublicacion", null);
			}
			if (request.getSession().getAttribute("fechaRetirada") != null) {
				request.getSession().setAttribute("fechaRetirada", null);
			}
			
			request.setAttribute("VisualizarEdictoForm", formulario);
			// request.getSession().setAttribute("listaEstados",formulario.getListaEstados());
			request.getSession().setAttribute("listaPublicados", formulario.getListaPublicados());
			// request.getSession().setAttribute("listaCentros",formulario.getListaCentros());
			// request.getSession().setAttribute("listaTiposEdictos",formulario.getListaTiposEdictos());
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarEdictoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
	
	public VisualizarPublicacionesSinAsignarForm rellenaFormulario(VisualizarPublicacionesSinAsignarForm formulario, String cif, HttpServletRequest request, String lenguaje)
	        throws Exception {
		
		String numDocumento = (String) request.getSession().getAttribute("nif");
		
		boolean esAdministrador = false;
		List listaRelacionAdministrador = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, numDocumento, String.valueOf(Constantes.ADMIN_LOCAL));
		if (!listaRelacionAdministrador.isEmpty()) {
			esAdministrador = true;
		}
		List listaCentros = new ArrayList<CentroProcedencia>();
		if (esAdministrador) {
			Organismo organismo = (Organismo) organismoService.findByCif(cif).get(0);
			listaCentros = centroProcedenciaService.findAll();
		} else {
			Integer idPerfil = Constantes.PUBLICADOR;
			List listaRelacion = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, numDocumento, idPerfil.toString());
			Iterator it = listaRelacion.iterator();
			while (it.hasNext()) {
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
				listaCentros.add(relacionUsuOrgCentroPerf.getCentroProcedencia());
			}
			
		}
		
		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder("nuevaListaPublicados").encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		}
		
		int totalEdictos = edictoService.findEdictosPendientesValidacionPorCentroCont(listaCentros);
		
		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		
		List listaEdictos = new ArrayList<Edicto>();
		
		if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null) {
			listaEdictos = edictoService.findEdictosPendientesValidacionPorCentro(listaCentros, 1, totalEdictos);
		} else {
			listaEdictos = edictoService.findEdictosPendientesValidacionPorCentro(listaCentros, paginaActual, 10);
		}
		
		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();
		
		Iterator iterator = listaEdictos.iterator();
		
		while (iterator.hasNext()) {
			
			Edicto edicto = (Edicto) iterator.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			if (lenguaje.equals("va")) {
				objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcionVa());
			} else {
				objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
			}
			objetoEdictoVisualizar.setNombreCentro(edicto.getCentro().getNombre());
			objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto().getNombre());
			objetoEdictoVisualizar.setFechaPublicacion(FechasUtil.convertDateToString(edicto.getFechaPublicacion(), 0));
			objetoEdictoVisualizar.setFechaRedaccion(FechasUtil.convertDateToString(edicto.getFechaRedaccion(), 0));
			objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
			objetoEdictoVisualizar.setUrl(edicto.getUrl());
			listaPublicados.add(objetoEdictoVisualizar);
		}
		formulario.setListaPublicados(listaPublicados);
		
		return formulario;
		
	}
}
