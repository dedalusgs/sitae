package es.novasoft.sitae.perfiles.publicador.relacionarPublicaciones.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;
import es.novasoft.sitae.perfiles.publicador.relacionarPublicaciones.forms.RelacionarPublicacionesForm;
import es.novasoft.sitae.perfiles.redactor.crearEdicto.forms.CrearEdictoForm;

public class RelacionarPublicacionesFrontAction extends ActionBase {

	protected Log log = LogFactory
			.getLog(RelacionarPublicacionesFrontAction.class);

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory
			.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);

	String idEdicto = null;

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			RelacionarPublicacionesForm formulario = (RelacionarPublicacionesForm) form;

			Locale locale = (Locale) request.getSession().getAttribute(
					Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}

			if (request.getParameter("idEdicto") != null) {
				formulario.reset(mapping, request);
				idEdicto = request.getParameter("idEdicto");
				request.getSession().setAttribute("idEdictoRelacionado",
						idEdicto);
				String origen = request.getParameter("origen");
				request.getSession().setAttribute("origenRelacion", origen);
				formulario.setAccion(origen);
				if (origen.equals("crearMisRedacciones")) {
					CrearEdictoMisRedaccionesForm formularioRet = (CrearEdictoMisRedaccionesForm) request
							.getSession().getAttribute(
									"CrearEdictoMisRedaccionesForm");
					if (formularioRet.getEdictoSust() == null) {
						formulario.setIdEdictoSust(null);
					} else {
						formulario.setIdEdictoSust(formularioRet
								.getEdictoSust().getIdEdicto());
					}
					formulario.setListaRelacionados(formularioRet
							.getListaEdictosRelacionados());
				}
				if (origen.equals("crear")) {
					CrearEdictoForm formularioRet = (CrearEdictoForm) request
							.getSession().getAttribute("CrearEdictoForm");
					formulario.setListaRelacionados(formularioRet
							.getListaEdictosRelacionados());
				}
				if (origen.equals("publicador")) {
					formulario.setListaRelacionados(extraerRelaciones(idEdicto,
							lenguaje, formulario));
				}
				if (formulario.getListaRelacionados() != null) {
					request.getSession().setAttribute("listaRelacionados",
							formulario.getListaRelacionados());
				} else {
					request.getSession().setAttribute("listaRelacionados",
							extraerRelaciones(idEdicto, lenguaje, formulario));
				}
			}

			idEdicto = (String) request.getSession().getAttribute(
					"idEdictoRelacionado");
			formulario
					.setListaRelacionados((List<ObjetoEdictoVisualizar>) request
							.getSession().getAttribute("listaRelacionados"));

			String accion = request.getParameter("accion");

			if (accion != null && !accion.equals("")
					&& !accion.equals("busquedaAvanzada")) {
				Edicto edictoAccion = edictoService.findById(Integer
						.parseInt(request.getParameter("id")));
				if (edictoAccion != null)
					if (accion.equals("alta")) {
						formulario.getListaRelacionados().add(
								transformarEdicto(formulario, lenguaje,
										edictoAccion));
						formulario.setHistorico(false);
					} else if (accion.equals("baja")) {
						List<ObjetoEdictoVisualizar> listaRel = new ArrayList<ObjetoEdictoVisualizar>();

						Iterator it = formulario.getListaRelacionados()
								.iterator();
						while (it.hasNext()) {
							ObjetoEdictoVisualizar edictoAux = (ObjetoEdictoVisualizar) it
									.next();
							if (edictoAux.getId().intValue() != edictoAccion
									.getIdEdicto().intValue()) {
								listaRel.add(edictoAux);
							}
						}
						formulario.setListaRelacionados(listaRel);
					}
			}

			request.getSession().setAttribute("accionPublico",
					"busquedaAvanzada");

			String cifOrganismo = null;

			cifOrganismo = (String) request.getSession().getAttribute("cif");

			if (request.getParameter("filtrar") == null) {
				formulario = rellenaFormulario(formulario, cifOrganismo,
						request, lenguaje);
			} else {
				formulario = filtrar(formulario, cifOrganismo, request,
						lenguaje);
			}

			request.getSession().setAttribute("RelacionarPublicacionesForm",
					formulario);
			request.getSession().setAttribute("listaRelacionados",
					formulario.getListaRelacionados());
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
			LOGGER.error("Error en RelacionarPublicacionesFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public RelacionarPublicacionesForm rellenaFormulario(
			RelacionarPublicacionesForm formulario, String cif,
			HttpServletRequest request, String lenguaje) throws Exception {

		List listaTiposEdictos = RellenaFormularioActionUtil
				.RellenaTiposEdictos(cif);
		List listaCentros = RellenaFormularioActionUtil
				.RellenaCentrosProcedencia(cif);
		List listaOrganismosExternos = RellenaFormularioActionUtil
				.RellenaOrganismosExternos();
		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);

		List<Integer> listaIdRelacionados = new ArrayList<Integer>();

		Edicto edictoSust = edictoService.findById(Integer.parseInt(idEdicto));

		if (edictoSust != null && edictoSust.getSustituyeA() != null) {
			listaIdRelacionados.add(edictoSust.getSustituyeA().getIdEdicto());
		}
		if (edictoSust != null && edictoSust.getSustituidoPor() != null) {
			listaIdRelacionados
					.add(edictoSust.getSustituidoPor().getIdEdicto());
		}
		if (formulario.getIdEdictoSust() != null) {
			listaIdRelacionados
					.add(formulario.getIdEdictoSust());
		}
		for (ObjetoEdictoVisualizar edicto : formulario.getListaRelacionados()) {
			listaIdRelacionados.add(edicto.getId());
		}
		listaIdRelacionados.add(Integer.parseInt(idEdicto));

		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder(
				"nuevaListaPublicados")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE)));

		// Detecta si es una exportación
		boolean export = request
				.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;

		// Obtener tamaño de pagina
		String tamTabla = request.getParameter((new ParamEncoder(
				"nuevaListaPublicados")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		}

		Integer diasCaducidad = Integer.parseInt(Constantes
				.getPropiedad("diasCaducidad"));

		// Contar el total de elementos sin relacionados
		int totalEdictos = edictoService
				.findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(
						organismo.getIdOrg(), Constantes.PUBLICADO,
						diasCaducidad, listaIdRelacionados);

		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		List listaEdictos = null;

		// Obtener el listado de elementos de BBDD específicos para la
		// página sin relacionados;//
		listaEdictos = edictoService
				.findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(
						organismo.getIdOrg(), Constantes.PUBLICADO,
						paginaActual, 10, diasCaducidad, listaIdRelacionados);

		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();
		Iterator it = listaEdictos.iterator();
		while (it.hasNext()) {
			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = transformarEdicto(
					formulario, lenguaje, edicto);
			listaPublicados.add(objetoEdictoVisualizar);
		}
		formulario.setListaPublicados(listaPublicados);
		formulario.setListaCentros(listaCentros);
		formulario.setListaTiposEdictos(listaTiposEdictos);
		formulario.setListaOrganismosExternos(listaOrganismosExternos);
		return formulario;

	}

	private ObjetoEdictoVisualizar transformarEdicto(
			RelacionarPublicacionesForm formulario, String lenguaje,
			Edicto edicto) {
		ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
		objetoEdictoVisualizar.setId(edicto.getIdEdicto());
		if (lenguaje.equals("va")) {
			objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
			objetoEdictoVisualizar.setDescripcion(edicto.getDescripcionVa());
		} else {
			objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
			objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
		}

		objetoEdictoVisualizar.setContenido(formulario.getContenido());
		if (edicto.getOrganismoExterno() != null
				&& edicto.getOrganismoExterno().getNombre() != null) {
			objetoEdictoVisualizar.setNombreCentro(edicto.getOrganismoExterno()
					.getNombre());
		} else {
			objetoEdictoVisualizar.setNombreCentro(edicto.getCentro()
					.getNombre());
		}
		objetoEdictoVisualizar
				.setTipoEdicto(edicto.getTipoEdicto().getNombre());
		objetoEdictoVisualizar.setFechaPublicacion(FechasUtil
				.convertDateToString(edicto.getFechaPublicacion(), 0));
		objetoEdictoVisualizar.setFechaRetirada(FechasUtil.convertDateToString(
				edicto.getFechaRetirada(), 0));
		objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil
				.convertDateToString(edicto.getFechaRetiradaPropuesta(), 0));
		objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
		objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado()
				.toString());
		objetoEdictoVisualizar.setUrl(edicto.getUrl());
		objetoEdictoVisualizar.setPublicado(true);
		objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
		return objetoEdictoVisualizar;
	}

	public RelacionarPublicacionesForm filtrar(
			RelacionarPublicacionesForm formulario, String cif,
			HttpServletRequest request, String lenguaje) throws Exception {

		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);

		List<Integer> listaIdRelacionados = new ArrayList<Integer>();

		Edicto edictoSust = edictoService.findById(Integer.parseInt(idEdicto));

		if (edictoSust != null && edictoSust.getSustituyeA() != null) {
			listaIdRelacionados.add(edictoSust.getSustituyeA().getIdEdicto());
		}
		if (edictoSust != null && edictoSust.getSustituidoPor() != null) {
			listaIdRelacionados
					.add(edictoSust.getSustituidoPor().getIdEdicto());
		}
		if (formulario.getIdEdictoSust() != null) {
			listaIdRelacionados
					.add(formulario.getIdEdictoSust());
		}
		for (ObjetoEdictoVisualizar edicto : formulario.getListaRelacionados()) {
			listaIdRelacionados.add(edicto.getId());
		}
		listaIdRelacionados.add(Integer.parseInt(idEdicto));
		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder(
				"nuevaListaPublicados")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE)));

		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		} else {
			if (!request.getSession().getAttribute("accionPublico").equals(
					"historicoEdictos")) {
				String historico = (String) request.getParameter("historico");
				if (historico == null) {
					request.getSession().setAttribute("consultaHistorico", "N");
				} else {
					request.getSession().setAttribute("consultaHistorico", "S");
				}
			} else {
				request.getSession().setAttribute("consultaHistorico", "S");
			}
		}

		Integer IdEstado = null;

		String consultaHistorico = (String) request.getSession().getAttribute(
				"consultaHistorico");
		if (consultaHistorico != null && consultaHistorico.equals("S")) {
			IdEstado = Constantes.RETIRADO;
			formulario.setHistorico(true);
		} else {
			IdEstado = Constantes.PUBLICADO;
			formulario.setHistorico(false);
		}

		Integer diasCaducidad = Integer.parseInt(Constantes
				.getPropiedad("diasCaducidad"));

		int totalEdictos = edictoService
				.findByFiltroPublicoSinRelacionadosCount(organismo.getIdOrg(),
						formulario.getOpcionTipoEdicto(), formulario
								.getOpcionCentro(), formulario
								.getOpcionOrganismoExterno(), formulario
								.getNumeroExpediente(), formulario
								.getFechaPublicacionInicio(), formulario
								.getFechaPublicacionFin(), IdEstado, formulario
								.getTitulo(), formulario.getDescripcion(),
						formulario.getContenido(), lenguaje, formulario
								.isHistorico(), diasCaducidad,
						listaIdRelacionados);

		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		List listaEdictos = null;

		// Obtener el listado de elementos de BBDD específicos para la
		// página;
		listaEdictos = edictoService.findByFiltroPublicoSinRelacionados(
				organismo.getIdOrg(), formulario.getOpcionTipoEdicto(),
				formulario.getOpcionCentro(), formulario
						.getOpcionOrganismoExterno(), formulario
						.getNumeroExpediente(), formulario
						.getFechaPublicacionInicio(), formulario
						.getFechaPublicacionFin(), IdEstado, formulario
						.getTitulo(), formulario.getDescripcion(), formulario
						.getContenido(), lenguaje, formulario.isHistorico(),
				paginaActual, 10, diasCaducidad, listaIdRelacionados);

		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();

		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {

			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = transformarEdicto(
					formulario, lenguaje, edicto);
			listaPublicados.add(objetoEdictoVisualizar);

		}

		formulario.setListaPublicados(listaPublicados);

		return formulario;

	}

	private List<ObjetoEdictoVisualizar> extraerRelaciones(String idEdicto,
			String lenguaje, RelacionarPublicacionesForm formulario) throws NumberFormatException, ServiceException {

		/* Edictos Relacionados */
		List<RelacionEdictos> listaRelaciones = relacionEdictosService
				.findByEdicto(Integer.parseInt(idEdicto));
		Iterator it = listaRelaciones.iterator();
		List<Edicto> listaEdictos = new ArrayList();
		while (it.hasNext()) {
			RelacionEdictos relacionEdictosAux = (RelacionEdictos) it.next();

			if (!relacionEdictosAux.getEdicto1().getIdEdicto().equals(
					Integer.parseInt(idEdicto))) {
				listaEdictos.add(relacionEdictosAux.getEdicto1());
			}
			if (!relacionEdictosAux.getEdicto2().getIdEdicto().equals(
					Integer.parseInt(idEdicto))) {
				listaEdictos.add(relacionEdictosAux.getEdicto2());
			}
		}

		List listaEdictosRelacionados = new ArrayList<ObjetoEdictoVisualizar>();
		it = listaEdictos.iterator();
		while (it.hasNext()) {
			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = transformarEdicto(
					formulario, lenguaje, edicto);
			listaEdictosRelacionados.add(objetoEdictoVisualizar);
		}
		return listaEdictosRelacionados;
	}
}
