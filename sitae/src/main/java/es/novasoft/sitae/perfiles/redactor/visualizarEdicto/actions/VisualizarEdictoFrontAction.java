package es.novasoft.sitae.perfiles.redactor.visualizarEdicto.actions;

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
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.redactor.visualizarEdicto.forms.VisualizarEdictoForm;

public class VisualizarEdictoFrontAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			VisualizarEdictoForm formulario = (VisualizarEdictoForm) form;

			// Reseteamos el formulario si retrocedemos al listado
			if (request.getParameter("volver") != null) {
				ResetForm.removeBean(mapping, request);
			}

			Locale locale = (Locale) request.getSession().getAttribute(
					Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}

			// Se tienen que mostrar los edictos solo del organismo al que
			// pertenece el redactor

			String cif = (String) request.getSession().getAttribute("cif");
			if (request.getParameter("filtrar") == null) {
				formulario = rellenaFormulario(formulario, cif, request,
						lenguaje);
			} else {
				formulario = filtrar(formulario, cif, request, lenguaje);
			}

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

			request.getSession().setAttribute("VisualizarEdictoForm",
					formulario);
			request.getSession().setAttribute("listaEstados",
					formulario.getListaEstados());
			request.getSession().setAttribute("listaPublicados",
					formulario.getListaPublicados());
			request.getSession().setAttribute("listaCentros",
					formulario.getListaCentros());
			request.getSession().setAttribute("listaOrganismosExternos",
					formulario.getListaOrganismosExternos());
			request.getSession().setAttribute("listaTiposEdictos",
					formulario.getListaTiposEdictos());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarEdictoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarEdictoForm rellenaFormulario(
			VisualizarEdictoForm formulario, String cif,
			HttpServletRequest request, String lenguaje) throws Exception {

		List listaTiposEdictos = RellenaFormularioActionUtil
				.RellenaTiposEdictos(cif);
		List listaCentros = RellenaFormularioActionUtil
				.RellenaCentrosProcedencia(cif);
		List listaEstados = RellenaFormularioActionUtil
				.RellenaEstadosSinRetirado();
		List listaOrganismosExternos = RellenaFormularioActionUtil
				.RellenaOrganismosExternos();

		String numDocumento = (String) request.getSession().getAttribute("nif");

		Usuario usuario = (Usuario) usuarioService.findByNumeroDocumento(
				numDocumento).get(0);
		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);

		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder(
				"nuevaListaPublicados")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		}
		
		// Contar el total de elementos
		int totalEdictos = edictoService
				.findByOrganismoRedactorSinEstadoHistoricoCount(organismo
						.getIdOrg(), usuario.getIdUsuario());
		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		List listaEdictos = null;
		if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null){
		listaEdictos = edictoService
			.findByOrganismoRedactorSinEstadoHistorico(
					organismo.getIdOrg(), usuario.getIdUsuario(),
					1, totalEdictos);
		} else {
		// Obtener el listado de elementos de BBDD específicos para la página;
		listaEdictos = edictoService
				.findByOrganismoRedactorSinEstadoHistorico(
						organismo.getIdOrg(), usuario.getIdUsuario(),
						paginaActual, 10);
		}
		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();

		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {

			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			if (lenguaje.equals("va")) {
				objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
				objetoEdictoVisualizar
						.setDescripcion(edicto.getDescripcionVa());
			} else {
				objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
			}
			if (edicto.getOrganismoExterno() != null) {
				objetoEdictoVisualizar.setNombreCentro(edicto
						.getOrganismoExterno().getNombre());
			} else {
				objetoEdictoVisualizar.setNombreCentro(edicto.getCentro()
						.getNombre());
			}
			objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto()
					.getNombre());
			objetoEdictoVisualizar.setFechaPublicacion(FechasUtil
					.convertDateToString(edicto.getFechaPublicacion(), 0));
			objetoEdictoVisualizar.setFechaRedaccion(FechasUtil
					.convertDateToString(edicto.getFechaRedaccion(), 0));
			objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
			objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado()
					.toString());
			objetoEdictoVisualizar.setUrl(edicto.getUrl());
			if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO) {
				objetoEdictoVisualizar.setPublicado(true);
			} else {
				objetoEdictoVisualizar.setPublicado(false);
			}

			listaPublicados.add(objetoEdictoVisualizar);

		}

		formulario.setListaEstados(listaEstados);
		formulario.setListaPublicados(listaPublicados);
		formulario.setListaCentros(listaCentros);
		formulario.setListaTiposEdictos(listaTiposEdictos);
		formulario.setListaOrganismosExternos(listaOrganismosExternos);
		
		return formulario;

	}

	public VisualizarEdictoForm filtrar(VisualizarEdictoForm formulario,
			String cif, HttpServletRequest request, String lenguaje)
			throws Exception {

		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);
		String numDocumento = (String) request.getSession().getAttribute("nif");

		Usuario usuario = (Usuario) usuarioService.findByNumeroDocumento(
				numDocumento).get(0);

		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder(
				"nuevaListaPublicados")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		} else {
			String historico = (String) request.getParameter("historico");

			if (historico == null) {
				request.getSession().setAttribute("consultaHistorico", "N");
			} else {
				request.getSession().setAttribute("consultaHistorico", "S");
			}
		}

		// Si marcamos la opcion historico, le decimos que haga un filtro por
		// aquellos que estan retirados

		String consultaHistorico = (String) request.getSession().getAttribute(
				"consultaHistorico");

		if (consultaHistorico != null && consultaHistorico.equals("S")) {
			formulario.setOpcionEstado(Constantes.RETIRADO);
			formulario.setHistorico(true);
		} else {
			formulario.setHistorico(false);
		}

		// Contar el total de elementos
		int totalEdictos = edictoService.findByFiltroSinEstadoRetiradoCount(
				formulario.getFechaRedaccion(), organismo.getIdOrg(),
				formulario.getOpcionCentro(), formulario.getOpcionOrganismoExterno(), formulario.getOpcionEstado(),
				formulario.getOpcionTipoEdicto(), usuario.getIdUsuario(),
				Constantes.USUARIO_REDACTOR, formulario.getTitulo(), formulario
						.getNumeroExpediente(), lenguaje);
		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		
		List listaEdictos = null;
		
		if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null){
			listaEdictos = edictoService.findByFiltroSinEstadoRetirado(
					formulario.getFechaRedaccion(), organismo.getIdOrg(),
					formulario.getOpcionCentro(), formulario.getOpcionOrganismoExterno(), formulario.getOpcionEstado(),
					formulario.getOpcionTipoEdicto(), usuario.getIdUsuario(),
					Constantes.USUARIO_REDACTOR, formulario.getTitulo(), formulario
							.getNumeroExpediente(), lenguaje, 1, totalEdictos);
		} else {
		// Obtener el listado de elementos de BBDD específicos para la página;

		listaEdictos = edictoService.findByFiltroSinEstadoRetirado(
				formulario.getFechaRedaccion(), organismo.getIdOrg(),
				formulario.getOpcionCentro(), formulario.getOpcionOrganismoExterno(), formulario.getOpcionEstado(),
				formulario.getOpcionTipoEdicto(), usuario.getIdUsuario(),
				Constantes.USUARIO_REDACTOR, formulario.getTitulo(), formulario
						.getNumeroExpediente(), lenguaje, paginaActual, 10);
		}
		
		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();

		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {

			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			if (lenguaje.equals("va")) {
				objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
				objetoEdictoVisualizar
						.setDescripcion(edicto.getDescripcionVa());
			} else {
				objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
			}
			if (edicto.getOrganismoExterno() != null) {
				objetoEdictoVisualizar.setNombreCentro(edicto
						.getOrganismoExterno().getNombre());
			} else {
				objetoEdictoVisualizar.setNombreCentro(edicto.getCentro()
						.getNombre());
			}
			objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto()
					.getNombre());
			objetoEdictoVisualizar.setFechaPublicacion(FechasUtil
					.convertDateToString(edicto.getFechaPublicacion(), 0));
			objetoEdictoVisualizar.setFechaRedaccion(FechasUtil
					.convertDateToString(edicto.getFechaRedaccion(), 0));
			objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
			objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado()
					.toString());
			if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO) {
				objetoEdictoVisualizar.setPublicado(true);
			} else {
				objetoEdictoVisualizar.setPublicado(false);
			}

			listaPublicados.add(objetoEdictoVisualizar);

		}

		formulario.setListaPublicados(listaPublicados);

		return formulario;

	}

}
