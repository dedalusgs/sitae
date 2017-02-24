package es.novasoft.sitae.perfiles.redactor.crearEdicto.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;
import es.novasoft.sitae.perfiles.redactor.crearEdicto.forms.CrearEdictoForm;

public class CrearEdictoFrontAction extends ActionBase {
		
	FestivoService festivoService = (FestivoService) Factory
			.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			// UsuarioAutentificado ciudadano = null;

			if (isCancelled(request)) {
				return mapping.findForward("Volver");
			}

			LOGGER.debug("INICIO DEL METODO");

			
			CrearEdictoForm formulario = (CrearEdictoForm) form;
			if (request.getAttribute("reload") != null
					&& request.getAttribute("reload").equals("true")) {
				formulario = (CrearEdictoForm) request.getSession()
						.getAttribute("CrearEdictoForm");
			}
			// Recupero de la session el cif del organismo para obtener los
			// centros de procedencia y los tipos de edictos
			String cifOrganismo = (String) request.getSession().getAttribute(
					"cif");

			if (request.getAttribute("numeroErrores") == null) {

				BackButtonUtil.setPathAnterior(mapping, request);

				// Crear funcion que nos devuelva los tipos de edictos y otra
				// para que devuelva
				// los centros de procedencia a partir del cif

				List listaTiposEdictos = RellenaFormularioActionUtil
						.RellenaTiposEdictos(cifOrganismo);
				List listaCentros = RellenaFormularioActionUtil
						.RellenaCentrosProcedencia(cifOrganismo);
				List listaOrganismosExternos = RellenaFormularioActionUtil
						.RellenaOrganismosExternos();

				List listaTiposFirma = RellenaFormularioActionUtil
						.RellenaTiposFirma();
				List<UsuarioFirmante> listaFirmantes = RellenaFormularioActionUtil
						.RellenalistaFirmantes(cifOrganismo);
				List<UsuarioFirmante> listaFirmantesNombres = RellenaFormularioActionUtil
						.RellenalistaFirmantesNombres(listaFirmantes);

				formulario.setListaOrganismosExternos(listaOrganismosExternos);
				formulario.setListaCentros(listaCentros);
				formulario.setListaTiposEdictos(listaTiposEdictos);
				formulario.setListaTiposFirma(listaTiposFirma);
				formulario.setListaFirmantes(listaFirmantes);
				formulario.setListaFirmantesNombres(listaFirmantesNombres);

				// Compruebo si ha saltado el javascript y valido el numero de
				// dias;
				// si es negativo fecha de retirada coge cadena vacia; comprueba
				// tambien que se haya introducido el dia de publicacion

				String seleccionadoOrganismoExterno = (String) request
						.getParameter("seleccionadoOrganismoExterno");
				if (seleccionadoOrganismoExterno == null) {
					formulario.setSeleccionadoOrganismoExterno(false);
					formulario.setOpcionOrganismoExterno(new Integer("-1"));
				} else {
					formulario.setSeleccionadoOrganismoExterno(true);
				}
				formulario.setDiasLaborablesDefecto(Integer.parseInt(Constantes.getPropiedad(Constantes.CANTIDAD_DIAS_LABORALES)));
				
				formulario.setDiasNaturalesDefecto(Integer.parseInt(Constantes.getPropiedad(Constantes.CANTIDAD_DIAS_NATURALES)));
				formulario.setDiasPublicados(formulario.getDiasLaborablesDefecto().toString());
				Date fechaActual=new Date();
				formulario.setFechaPublicacion(FechasUtil.convertDateToString(fechaActual,FechasUtil.typeSdfDate));

				Organismo organismo = (Organismo) organismoService.findByCif(cifOrganismo).get(0);
						
				Date fRetirada=festivoService.obtenerFechaFinPublicacion(fechaActual, organismo,formulario.getDiasLaborablesDefecto(), Edicto.TIPO_PUBLICACION_LABORABLES);
				
				formulario.setFechaRetirada(FechasUtil.convertDateToString(fRetirada,FechasUtil.typeSdfDate));
				formulario.setTipoPublicacion(Edicto.TIPO_PUBLICACION_LABORABLES);
		
			}

			request.getSession().setAttribute("CrearEdictoForm", formulario);
			request.getSession().setAttribute("listaOrganismosExternos",
					formulario.getListaOrganismosExternos());
			request.getSession().setAttribute("listaTiposEdictos",
					formulario.getListaTiposEdictos());
			request.getSession().setAttribute("listaCentros",
					formulario.getListaCentros());
			request.getSession().setAttribute("listaTiposFirma",
					formulario.getListaTiposFirma());
			request.getSession().setAttribute("listaFirmantes",
					formulario.getListaFirmantes());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en CrearEdictoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
