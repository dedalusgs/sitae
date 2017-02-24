/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: VisualizarEdictoPublicadorFrontAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
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
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.publicador.visualizarEdicto.forms.VisualizarEdictoPublicadorForm;

public class VisualizarEdictoPublicadorFrontAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

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

			VisualizarEdictoPublicadorForm formulario = (VisualizarEdictoPublicadorForm) form;

			String cif = (String) request.getSession().getAttribute("cif");
			String numDocumento = (String) request.getSession().getAttribute(
					"nif");

			boolean esAdministrador = false;
			List listaRelacionAdministrador = relacionUsuOrgCentroPerfService
					.findByOrgUsuPerf(cif, numDocumento, String
							.valueOf(Constantes.ADMIN_LOCAL));
			if (!listaRelacionAdministrador.isEmpty()) {
				esAdministrador = true;
			}

			// Se tienen que mostrar los edictos del organismo del publicador

			if (request.getParameter("filtrar") == null) {
				formulario = rellenaFormulario(formulario, cif, request,
						esAdministrador, lenguaje);
			} else {
				formulario = filtrar(formulario, cif, request, esAdministrador,
						lenguaje);
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

			request.setAttribute("VisualizarEdictoForm", formulario);
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

	public VisualizarEdictoPublicadorForm rellenaFormulario(
			VisualizarEdictoPublicadorForm formulario, String cif,
			HttpServletRequest request, boolean esAdministrador, String lenguaje)
			throws Exception {

		// Para los campos del filtro

		String numDocumento = (String) request.getSession().getAttribute("nif");

		List listaTiposEdictos = RellenaFormularioActionUtil
				.RellenaTiposEdictos(cif);

		List listaOrganismosExternos = RellenaFormularioActionUtil
				.RellenaOrganismosExternos();

		List listaCentros = new ArrayList();

		if (esAdministrador) {
			listaCentros = RellenaFormularioActionUtil
					.RellenaCentrosProcedencia(cif);
		} else {
			listaCentros = RellenaFormularioActionUtil
					.RellenaCentrosProcedenciaPorUsuario(cif, numDocumento);
		}

		List listaEstados = RellenaFormularioActionUtil
				.RellenaEstadosSinIniciadoYSinRetiradoPenVal();

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
		List listaEdictos = new ArrayList();

		if (esAdministrador) {

			// Contar el total de elementos
			int totalEdictos = edictoService
					.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(
							usuario.getIdUsuario(), null, organismo);

			// Incorporar el total de elementos a la request para poder
			// recuperarlo en la JSP
			request.setAttribute("totalTablaEdictos", totalEdictos);
			request.setAttribute("listaParcial", "true");

			// Obtener el listado de elementos de BBDD específicos para la
			// página;
			if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null) {
				request.setAttribute("listaParcial", "false");
				listaEdictos = edictoService
						.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(
								usuario.getIdUsuario(), null, 1, totalEdictos,
								organismo);
			} else {
				listaEdictos = edictoService
						.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(
								usuario.getIdUsuario(), null, paginaActual, 10,
								organismo);
			}
		} else {

			// Contar el total de elementos
			int totalEdictos = edictoService
					.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(
							usuario.getIdUsuario(), listaCentros, organismo);
			// Incorporar el total de elementos a la request para poder
			// recuperarlo en la JSP
			request.setAttribute("totalTablaEdictos", totalEdictos);
			request.setAttribute("listaParcial", "true");

			// Obtener el listado de elementos de BBDD específicos para la
			// página;
			if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null) {
				request.setAttribute("listaParcial", "false");
				listaEdictos = edictoService
						.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(
								usuario.getIdUsuario(), listaCentros, 1,
								totalEdictos, organismo);
			} else {
				listaEdictos = edictoService
						.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(
								usuario.getIdUsuario(), listaCentros,
								paginaActual, 10, organismo);
			}
		}

		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();

		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {

			Edicto edicto = (Edicto) it.next();

			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
			if (lenguaje.equals("va")) {
				objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
				objetoEdictoVisualizar
						.setDescripcion(edicto.getDescripcionVa());
			} else {
				objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
			}
			if (edicto.getOrganismoExterno() != null
					&& edicto.getOrganismoExterno().getNombre() != null) {
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
			if (edicto.getPublicador() != null
					&& edicto.getPublicador().getIdUsuario().equals(
							usuario.getIdUsuario())) {
				objetoEdictoVisualizar.setPublicadorAsignado(true);
			} else {
				objetoEdictoVisualizar.setPublicadorAsignado(false);
			}

			listaPublicados.add(objetoEdictoVisualizar);

		}

		formulario.setListaEstados(listaEstados);
		formulario.setListaPublicados(listaPublicados);
		formulario.setListaCentros(listaCentros);
		formulario.setListaTiposEdictos(listaTiposEdictos);
		formulario.setListaEdictos(listaEdictos);
		formulario.setListaOrganismosExternos(listaOrganismosExternos);

		return formulario;

	}

	/**
	 * Filtrar.
	 * 
	 * @param formulario
	 *            the formulario
	 * @param cif
	 *            the cif
	 * @param request
	 *            the request
	 * @param esAdministrador
	 *            the es administrador
	 * @param lenguaje
	 *            the lenguaje
	 * @return the visualizar edicto publicador form
	 * @throws Exception
	 *             the exception
	 */
	public VisualizarEdictoPublicadorForm filtrar(
			VisualizarEdictoPublicadorForm formulario, String cif,
			HttpServletRequest request, boolean esAdministrador, String lenguaje)
			throws Exception {

		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);

		String numDocumento = (String) request.getSession().getAttribute("nif");

		List listaCentros = new ArrayList();

		if (esAdministrador) {
			listaCentros = RellenaFormularioActionUtil
					.RellenaCentrosProcedencia(cif);
		} else {
			listaCentros = RellenaFormularioActionUtil
					.RellenaCentrosProcedenciaPorUsuario(cif, numDocumento);
		}

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

		List listaEdictos = new ArrayList();

		if (esAdministrador) {
			// Contar el total de elementos
			int totalEdictos = edictoService
					.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(
							formulario.getFechaRedaccion(), organismo
									.getIdOrg(), formulario.getOpcionCentro(),
							formulario.getOpcionOrganismoExterno(), formulario
									.getOpcionEstado(), formulario
									.getOpcionTipoEdicto(), usuario
									.getIdUsuario(),
							Constantes.USUARIO_PUBLICADOR, null, formulario
									.getTitulo(), formulario
									.getNumeroExpediente(),formulario.getCodigoEdicto(), lenguaje);

			// Incorporar el total de elementos a la request para poder
			// recuperarlo
			// en la JSP
			request.setAttribute("totalTablaEdictos", totalEdictos);
			request.setAttribute("listaParcial", "true");

			// Obtener el listado de elementos de BBDD específicos para la
			// página;

			if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null) {
				request.setAttribute("listaParcial", "false");
				listaEdictos = edictoService
						.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(
								formulario.getFechaRedaccion(), organismo
										.getIdOrg(), formulario
										.getOpcionCentro(), formulario
										.getOpcionOrganismoExterno(),
								formulario.getOpcionEstado(), formulario
										.getOpcionTipoEdicto(), usuario
										.getIdUsuario(),
								Constantes.USUARIO_PUBLICADOR, null, formulario
										.getTitulo(), formulario
										.getNumeroExpediente(), formulario.getCodigoEdicto(),lenguaje, 1,
								totalEdictos);
			} else {
				listaEdictos = edictoService
						.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(
								formulario.getFechaRedaccion(), organismo
										.getIdOrg(), formulario
										.getOpcionCentro(), formulario
										.getOpcionOrganismoExterno(),
								formulario.getOpcionEstado(), formulario
										.getOpcionTipoEdicto(), usuario
										.getIdUsuario(),
								Constantes.USUARIO_PUBLICADOR, null, formulario
										.getTitulo(), formulario
										.getNumeroExpediente(),formulario.getCodigoEdicto(), lenguaje,
								paginaActual, 10);
			}
		} else {
			// Contar el total de elementos
			int totalEdictos = edictoService
					.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(
							formulario.getFechaRedaccion(), organismo
									.getIdOrg(), formulario.getOpcionCentro(),
							formulario.getOpcionOrganismoExterno(), formulario
									.getOpcionEstado(), formulario
									.getOpcionTipoEdicto(), usuario
									.getIdUsuario(),
							Constantes.USUARIO_PUBLICADOR, listaCentros,
							formulario.getTitulo(), formulario
									.getNumeroExpediente(),formulario.getCodigoEdicto(), lenguaje);

			// Incorporar el total de elementos a la request para poder
			// recuperarlo
			// en la JSP
			request.setAttribute("totalTablaEdictos", totalEdictos);
			request.setAttribute("listaParcial", "true");
			// Obtener el listado de elementos de BBDD específicos para la
			// página;
			if (request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null) {
				request.setAttribute("listaParcial", "false");
				listaEdictos = edictoService
						.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(
								formulario.getFechaRedaccion(), organismo
										.getIdOrg(), formulario
										.getOpcionCentro(), formulario
										.getOpcionOrganismoExterno(),
								formulario.getOpcionEstado(), formulario
										.getOpcionTipoEdicto(), usuario
										.getIdUsuario(),
								Constantes.USUARIO_PUBLICADOR, listaCentros,
								formulario.getTitulo(), formulario
										.getNumeroExpediente(), formulario.getCodigoEdicto(),lenguaje, 1,
								totalEdictos);
			} else {
				listaEdictos = edictoService
						.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(
								formulario.getFechaRedaccion(), organismo
										.getIdOrg(), formulario
										.getOpcionCentro(), formulario
										.getOpcionOrganismoExterno(),
								formulario.getOpcionEstado(), formulario
										.getOpcionTipoEdicto(), usuario
										.getIdUsuario(),
								Constantes.USUARIO_PUBLICADOR, listaCentros,
								formulario.getTitulo(), formulario
										.getNumeroExpediente(),formulario.getCodigoEdicto(), lenguaje,
								paginaActual, 10);
			}
		}
		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();

		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {

			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
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

			if (edicto.getPublicador()!=null && edicto.getPublicador().getIdUsuario().equals(
					usuario.getIdUsuario())) {
				objetoEdictoVisualizar.setPublicadorAsignado(true);
			} else {
				objetoEdictoVisualizar.setPublicadorAsignado(false);
			}
			listaPublicados.add(objetoEdictoVisualizar);

		}

		formulario.setListaPublicados(listaPublicados);

		return formulario;

	}

}
