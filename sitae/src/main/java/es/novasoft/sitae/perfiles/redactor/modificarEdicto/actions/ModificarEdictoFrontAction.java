package es.novasoft.sitae.perfiles.redactor.modificarEdicto.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.BackButtonUtil;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;
import es.novasoft.sitae.perfiles.redactor.modificarEdicto.forms.ModificarEdictoForm;

public class ModificarEdictoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			EdictoService edictoService = (EdictoService) Factory
					.getBean(ServiceConstants.EDICTO_BEAN_NAME);
			RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory
					.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);



			ModificarEdictoForm formulario = (ModificarEdictoForm) form;
			if (request.getAttribute("reload") != null
					&& request.getAttribute("reload").equals("true")) {
				formulario = (ModificarEdictoForm) request.getSession()
						.getAttribute("ModificarEdictoForm");
			}
			Edicto edicto = new Edicto();
			Locale locale = (Locale) request.getSession().getAttribute(
					Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}
			// Obtengo el id del edicto
			String idEdicto = (String) request
					.getParameter("idEdictoSeleccionado");

			// Recupero de la session el cif del organismo para obtener los
			// centros de procedencia y los tipos de edictos
			String cifOrganismo = (String) request.getSession().getAttribute(
					"cif");

			if (request.getAttribute("numeroErrores") == null) {

				BackButtonUtil.setPathAnterior(mapping, request);

				String actualizaFechaPublicacion = (String) request
						.getParameter("actualizaFechaPublicacion");

				String actualizaDia = (String) request
						.getParameter("actualizaDia");

				String actualizaFechaRetirada = (String) request
						.getParameter("actualizaFechaRetirada");

				if ((idEdicto == null || idEdicto.equals(""))
						&& (actualizaFechaPublicacion == null || !actualizaFechaPublicacion
								.equals("si"))

						&& (actualizaDia == null || !actualizaDia.equals("si"))

						&& (actualizaFechaRetirada == null || !actualizaFechaRetirada
								.equals("si"))) {

					idEdicto = formulario.getId();
				}

				if (idEdicto != null && !idEdicto.equals("")) {

					edicto = (Edicto) edictoService.findById(Integer
							.parseInt(idEdicto));

					List listaTiposEdictos = RellenaFormularioActionUtil
							.RellenaTiposEdictos(cifOrganismo);
					List listaCentros = RellenaFormularioActionUtil
							.RellenaCentrosProcedencia(cifOrganismo);
					List listaOrganismosExternos = RellenaFormularioActionUtil
							.RellenaOrganismosExternos();
					formulario
							.setListaOrganismosExternos(listaOrganismosExternos);
					formulario.setListaCentros(listaCentros);
					formulario.setListaTiposEdictos(listaTiposEdictos);
					formulario.setEdictoSust(edicto.getSustituyeA());

					if (edicto.getOrganismoExterno() != null) {
						formulario.setOpcionOrganismoExterno(edicto
								.getOrganismoExterno().getIdOrg());
						formulario.setSeleccionadoOrganismoExterno(true);
					} else {
						formulario.setOpcionOrganismoExterno(null);
						formulario.setSeleccionadoOrganismoExterno(false);
					}
					formulario
							.setOpcionCentro(edicto.getCentro().getIdCentro());
					formulario.setOpcionTipoEdicto(edicto.getTipoEdicto()
							.getidTipoEdicto());

					formulario
							.setFechaRedaccion(FechasUtil.convertDateToString(
									edicto.getFechaRedaccion(), 0));
					formulario.setFechaPublicacion(FechasUtil
							.convertDateToString(edicto
									.getFechaPublicacionPropuesta(), 0));
					formulario.setFechaRetirada(FechasUtil.convertDateToString(
							edicto.getFechaRetiradaPropuesta(), 0));
					int dias = (int) (FechasUtil.getDifferenceByDays(edicto
							.getFechaPublicacionPropuesta(), edicto
							.getFechaRetiradaPropuesta()));
					formulario.setDiasPublicados(String.valueOf(dias));

					formulario.setEdicto(edicto);
					formulario.setId(idEdicto);
					formulario.setDiasPublicados(edicto.getDiasExposicion().toString());
					formulario.setDiasNaturalesDefecto(Integer.parseInt(Constantes.getPropiedad(Constantes.CANTIDAD_DIAS_NATURALES)));
					formulario.setDiasLaborablesDefecto(Integer.parseInt(Constantes.getPropiedad(Constantes.CANTIDAD_DIAS_LABORALES)));
					formulario.setTipoPublicacion(edicto.getTipoExposicion());
					
				
				}
			}

			// Compruebo si ha saltado el javascript y valido el numero de dias;
			// si es negativo fecha de retirada coge cadena vacia; comprueba
			// tambien que se haya introducido el dia de publicacion

			
			request.getSession().setAttribute("listaOrganismosExternos",
					formulario.getListaOrganismosExternos());
			request.getSession().setAttribute("listaTiposEdictos",
					formulario.getListaTiposEdictos());
			request.getSession().setAttribute("listaCentros",
					formulario.getListaCentros());
			/* Edictos Relacionados */
			List<RelacionEdictos> listaRelaciones = relacionEdictosService
					.findByEdicto(Integer.parseInt(idEdicto));
			Iterator it = listaRelaciones.iterator();
			List<Edicto> listaEdictos = new ArrayList();
			while (it.hasNext()) {
				RelacionEdictos relacionEdictosAux = (RelacionEdictos) it
						.next();

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
				edicto = (Edicto) it.next();
				ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
				objetoEdictoVisualizar.setId(edicto.getIdEdicto());
				if (lenguaje.equals("va")) {
					objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
					objetoEdictoVisualizar.setDescripcion(edicto
							.getDescripcionVa());
				} else {
					objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
					objetoEdictoVisualizar.setDescripcion(edicto
							.getDescripcion());
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
				objetoEdictoVisualizar.setFechaRetirada(FechasUtil
						.convertDateToString(edicto.getFechaRetirada(), 0));
				objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil
						.convertDateToString(
								edicto.getFechaRetiradaPropuesta(), 0));
				objetoEdictoVisualizar
						.setEstado(edicto.getEstado().getNombre());
				objetoEdictoVisualizar.setIdEstado(edicto.getEstado()
						.getIdEstado().toString());
				objetoEdictoVisualizar.setUrl(edicto.getUrl());
				objetoEdictoVisualizar.setPublicado(true);
				objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
				listaEdictosRelacionados.add(objetoEdictoVisualizar);
				objetoEdictoVisualizar.setDiasPublicacion(edicto.getDiasExposicion());
				objetoEdictoVisualizar.setTipoExposicion(edicto.getTipoExposicion());
			}
			formulario.setListaEdictosRelacionados(listaEdictosRelacionados);
			request.setAttribute("ModificarEdictoForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ModificarEdictoForm", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
