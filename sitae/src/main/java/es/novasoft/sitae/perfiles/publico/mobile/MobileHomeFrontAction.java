package es.novasoft.sitae.perfiles.publico.mobile;

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
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.InteresadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.perfiles.publico.visualizarEdicto.forms.VisualizarEdictoPublicoForm;

public class MobileHomeFrontAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	InteresadoService interesadoService = (InteresadoService) Factory.getBean(ServiceConstants.INTERESADO_BEAN_NAME);

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			VisualizarEdictoPublicoForm formulario = (VisualizarEdictoPublicoForm) form;
			formulario.setFechaPublicacionFin("");
			formulario.setFechaPublicacionInicio("");
			formulario.setTitulo("");
			formulario.setDescripcion("");
			formulario.setFechaPublicacionFin("");
			formulario.setFechaPublicacionInicio("");
			formulario.setOpcionCentro(-1);
			formulario.setOpcionTipoEdicto(-1);
			formulario.setNumeroExpediente("");
			formulario.setOpcionOrganismoExterno(-1);
			if (request.getParameter("volver") != null) {
				ResetForm.removeBean(mapping, request);
			}

			request.getSession().setAttribute("accionPublico", "inicio");

			String cifOrganismo = null;

			cifOrganismo = (String) request.getSession().getAttribute("cif");

			Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}

			if (request.getParameter("filtrar") == null) {
				formulario = rellenaFormulario(formulario, cifOrganismo, request, lenguaje);
			} else {
				formulario = filtrar(formulario, cifOrganismo, request, lenguaje);
			}

			request.getSession().setAttribute("VisualizarEdictoPublicoForm", formulario);
			request.getSession().setAttribute("listaPublicados", formulario.getListaPublicados());
			request.getSession().setAttribute("listaCentros", formulario.getListaCentros());
			request.getSession().setAttribute("listaOrganismosExternos", formulario.getListaOrganismosExternos());
			request.getSession().setAttribute("listaTiposEdictos", formulario.getListaTiposEdictos());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarEdictoPublicoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarEdictoPublicoForm rellenaFormulario(VisualizarEdictoPublicoForm formulario, String cif, HttpServletRequest request, String lenguaje) throws Exception {

		List listaTiposEdictos = RellenaFormularioActionUtil.RellenaTiposEdictos(cif);
		List listaCentros = RellenaFormularioActionUtil.RellenaCentrosProcedencia(cif);
		List listaOrganismosExternos = RellenaFormularioActionUtil.RellenaOrganismosExternos();
		Organismo organismo = (Organismo) organismoService.findByCif(cif).get(0);

		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder("nuevaListaPublicados").encodeParameterName(TableTagParameters.PARAMETER_PAGE)));

		// Detecta si es una exportación
		boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;

		// Obtener tamaño de pagina
		String tamTabla = request.getParameter((new ParamEncoder("nuevaListaPublicados").encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		}

		Integer diasCaducidad = Integer.parseInt(Constantes.getPropiedad("diasCaducidad"));

		// Contar el total de elementos
		int totalEdictos = edictoService.findByOrganismoEstadoOrderFechaPublicacionCount(organismo.getIdOrg(), Constantes.PUBLICADO, diasCaducidad);
		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		request.setAttribute("listaParcial", "true");
		List listaEdictos = null;
		if (export) {
			// Return entire list
			listaEdictos = edictoService.findByOrganismoEstadoOrderFechaPublicacion(organismo.getIdOrg(), Constantes.PUBLICADO, 1, totalEdictos, diasCaducidad);
			request.setAttribute("listaParcial", "false");
		} else {
			// Obtener el listado de elementos de BBDD específicos para la
			// página;//
			listaEdictos = edictoService.findByOrganismoEstadoOrderFechaPublicacion(organismo.getIdOrg(), Constantes.PUBLICADO, paginaActual, 10, diasCaducidad);
		}

		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();
		Iterator it = listaEdictos.iterator();
		while (it.hasNext()) {
			Edicto edicto = (Edicto) it.next();
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
			if (edicto.getOrganismoExterno() != null && edicto.getOrganismoExterno().getNombre() != null) {
				objetoEdictoVisualizar.setNombreCentro(edicto.getOrganismoExterno().getNombre());
			} else {
				objetoEdictoVisualizar.setNombreCentro(edicto.getCentro().getNombre());
			}
			objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto().getNombre());
			objetoEdictoVisualizar.setFechaPublicacion(FechasUtil.convertDateToString(edicto.getFechaPublicacion(), 0));
			objetoEdictoVisualizar.setFechaRetirada(FechasUtil.convertDateToString(edicto.getFechaRetirada(), 0));
			objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil.convertDateToString(edicto.getFechaRetiradaPropuesta(), 0));
			objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
			objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado().toString());
			objetoEdictoVisualizar.setUrl(edicto.getUrl());
			objetoEdictoVisualizar.setPublicado(true);
			objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
			listaPublicados.add(objetoEdictoVisualizar);
		}
		formulario.setListaPublicados(listaPublicados);
		formulario.setListaCentros(listaCentros);
		formulario.setListaTiposEdictos(listaTiposEdictos);
		formulario.setListaOrganismosExternos(listaOrganismosExternos);
		return formulario;

	}

	public VisualizarEdictoPublicoForm filtrar(VisualizarEdictoPublicoForm formulario, String cif, HttpServletRequest request, String lenguaje) throws Exception {

		Organismo organismo = (Organismo) organismoService.findByCif(cif).get(0);

		// Obtener página
		String parametroTabla = request.getParameter((new ParamEncoder("nuevaListaPublicados").encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		// Detecta si es una exportación
		boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;

		int paginaActual = 1;
		if (parametroTabla != null) {
			paginaActual = (Integer.parseInt(parametroTabla));
		} else {
			if (!export) {
				if (!request.getSession().getAttribute("accionPublico").equals("historicoEdictos")) {
					String historico = request.getParameter("historico");
					if (historico == null) {
						request.getSession().setAttribute("consultaHistorico", "N");
					} else {
						request.getSession().setAttribute("consultaHistorico", "S");
					}
				} else {
					request.getSession().setAttribute("consultaHistorico", "S");
				}
			}
		}

		Integer IdEstado = null;

		String consultaHistorico = (String) request.getSession().getAttribute("consultaHistorico");
		if (consultaHistorico != null && consultaHistorico.equals("S")) {
			IdEstado = Constantes.RETIRADO;
			formulario.setHistorico(true);
		} else {
			IdEstado = Constantes.PUBLICADO;
			formulario.setHistorico(false);
		}

		Integer diasCaducidad = Integer.parseInt(Constantes.getPropiedad("diasCaducidad"));

		int totalEdictos = edictoService.findByFiltroPublicoCount(organismo.getIdOrg(), formulario.getOpcionTipoEdicto(), formulario.getOpcionCentro(), formulario.getOpcionOrganismoExterno(),
				formulario.getNumeroExpediente(), formulario.getFechaPublicacionInicio(), formulario.getFechaPublicacionFin(), IdEstado, formulario.getTitulo(), formulario.getDescripcion(),
				formulario.getContenido(), lenguaje, formulario.isHistorico(), diasCaducidad);

		// Incorporar el total de elementos a la request para poder recuperarlo
		// en la JSP
		request.setAttribute("totalTablaEdictos", totalEdictos);
		List listaEdictos = null;
		request.setAttribute("listaParcial", "true");
		if (export) {
			request.setAttribute("listaParcial", "false");
			// Return entire list
			log.debug("Listado CSV o PDF");
			listaEdictos = edictoService.findByFiltroPublico(organismo.getIdOrg(), formulario.getOpcionTipoEdicto(), formulario.getOpcionCentro(), formulario.getOpcionOrganismoExterno(),
					formulario.getNumeroExpediente(), formulario.getFechaPublicacionInicio(), formulario.getFechaPublicacionFin(), IdEstado, formulario.getTitulo(), formulario.getDescripcion(),
					formulario.getContenido(), lenguaje, formulario.isHistorico(), 1, totalEdictos, diasCaducidad);

		} else {
			// Obtener el listado de elementos de BBDD específicos para la
			// página;
			log.debug("Listado Normal");
			listaEdictos = edictoService.findByFiltroPublico(organismo.getIdOrg(), formulario.getOpcionTipoEdicto(), formulario.getOpcionCentro(), formulario.getOpcionOrganismoExterno(),
					formulario.getNumeroExpediente(), formulario.getFechaPublicacionInicio(), formulario.getFechaPublicacionFin(), IdEstado, formulario.getTitulo(), formulario.getDescripcion(),
					formulario.getContenido(), lenguaje, formulario.isHistorico(), paginaActual, 10, diasCaducidad);
		}

		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();

		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {

			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			if (lenguaje.equals("va")) {
				objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcionVa());
			} else {
				objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
			}
			if (edicto.getOrganismoExterno() != null && edicto.getOrganismoExterno().getNombre() != null) {
				objetoEdictoVisualizar.setNombreCentro(edicto.getOrganismoExterno().getNombre());
			} else {
				objetoEdictoVisualizar.setNombreCentro(edicto.getCentro().getNombre());
			}
			objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto().getNombre());
			objetoEdictoVisualizar.setFechaPublicacion(FechasUtil.convertDateToString(edicto.getFechaPublicacion(), 0));
			objetoEdictoVisualizar.setFechaRedaccion(FechasUtil.convertDateToString(edicto.getFechaRedaccion(), 0));
			objetoEdictoVisualizar.setFechaRetirada(FechasUtil.convertDateToString(edicto.getFechaRetirada(), 0));
			objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil.convertDateToString(edicto.getFechaRetiradaPropuesta(), 0));
			objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
			objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado().toString());
			objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
			listaPublicados.add(objetoEdictoVisualizar);

		}

		formulario.setListaPublicados(listaPublicados);

		return formulario;

	}

}
