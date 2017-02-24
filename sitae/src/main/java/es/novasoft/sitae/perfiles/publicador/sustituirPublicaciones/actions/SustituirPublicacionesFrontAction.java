package es.novasoft.sitae.perfiles.publicador.sustituirPublicaciones.actions;

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
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;
import es.novasoft.sitae.perfiles.publicador.muestraInformacionEdicto.forms.MuestraInformacionEdictoForm;
import es.novasoft.sitae.perfiles.publicador.relacionarPublicaciones.forms.RelacionarPublicacionesForm;
import es.novasoft.sitae.perfiles.publicador.sustituirPublicaciones.forms.SustituirPublicacionesForm;
import es.novasoft.sitae.perfiles.redactor.crearEdicto.forms.CrearEdictoForm;

public class SustituirPublicacionesFrontAction extends ActionBase {

	protected Log log = LogFactory
			.getLog(SustituirPublicacionesFrontAction.class);

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

			SustituirPublicacionesForm formulario = (SustituirPublicacionesForm) form;

			Locale locale = (Locale) request.getSession().getAttribute(
					Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}

			if (request.getParameter("idEdicto") != null) {
				formulario.reset(mapping, request);
				idEdicto = request.getParameter("idEdicto");
				request.getSession().setAttribute("idEdictoSus", idEdicto);
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

			idEdicto = (String) request.getSession()
					.getAttribute("idEdictoSus");
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

			request.getSession().setAttribute("SustituirPublicacionesForm",
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
			LOGGER.error("Error en VisualizarEdictoPublicoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public SustituirPublicacionesForm rellenaFormulario(
			SustituirPublicacionesForm formulario, String cif,
			HttpServletRequest request, String lenguaje) throws Exception {

		List listaTiposEdictos = RellenaFormularioActionUtil
				.RellenaTiposEdictos(cif);
		List listaCentros = RellenaFormularioActionUtil
				.RellenaCentrosProcedencia(cif);
		List listaOrganismosExternos = RellenaFormularioActionUtil
				.RellenaOrganismosExternos();
		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);

		formulario.setListaRelacionados(extraerRelaciones(idEdicto, lenguaje,
				formulario));
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
			listaIdRelacionados.add(formulario.getIdEdictoSust());
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
		
		List listaEdictos = null;

		// Obtener el listado de elementos de BBDD específicos para la
		// página sin relacionados;//
		listaEdictos = edictoService
				.findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(
						organismo.getIdOrg(), Constantes.RETIRADO,
						paginaActual, 10, diasCaducidad, listaIdRelacionados);

		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();
		Iterator it = listaEdictos.iterator();
		while (it.hasNext()) {
			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = transformarEdicto(
					formulario, lenguaje, edicto);
			if (edicto.getSustituidoPor() == null || edicto.getSustituidoPor().getIdEdicto() == null) {
			listaPublicados.add(objetoEdictoVisualizar);
			}
		}
		request.setAttribute("totalTablaEdictos", listaPublicados.size());
		formulario.setListaPublicados(listaPublicados);
		formulario.setListaCentros(listaCentros);
		formulario.setListaTiposEdictos(listaTiposEdictos);
		formulario.setListaOrganismosExternos(listaOrganismosExternos);
		return formulario;

	}

	public SustituirPublicacionesForm filtrar(
			SustituirPublicacionesForm formulario, String cif,
			HttpServletRequest request, String lenguaje) throws Exception {

		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);
		formulario.setListaRelacionados(extraerRelaciones(idEdicto, lenguaje,
				formulario));
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
			listaIdRelacionados.add(formulario.getIdEdictoSust());
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
		}

		Integer IdEstado = null;

		String consultaHistorico = "S";

		IdEstado = Constantes.RETIRADO;
		formulario.setHistorico(true);

		Integer diasCaducidad = Integer.parseInt(Constantes
				.getPropiedad("diasCaducidad"));

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
			if (edicto.getSustituidoPor() == null || edicto.getSustituidoPor().getIdEdicto() == null) {
				listaPublicados.add(objetoEdictoVisualizar);
			}
		}
		request.setAttribute("totalTablaEdictos", listaPublicados.size());
		formulario.setListaPublicados(listaPublicados);

		return formulario;

	}

	private List<ObjetoEdictoVisualizar> extraerRelaciones(String idEdicto,
			String lenguaje, SustituirPublicacionesForm formulario) throws NumberFormatException, ServiceException {

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

	private ObjetoEdictoVisualizar transformarEdicto(
			SustituirPublicacionesForm formulario, String lenguaje,
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
}
