package es.novasoft.sitae.perfiles.adminGlobal.visualizarAdmLocales.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import es.novasoft.comun.utils.ObjetoUsuarioOrganismo;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.visualizarAdmLocales.forms.VisualizarAdmLocalForm;

public class VisualizarAdmLocalFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver");
			 * }
			 * 
			 * LOGGER.debug("INICIO DEL METODO"); //Información que se obtiene
			 * del certificado digital //Se comprueba que se ha accedido de
			 * manera correcta Utils util = new Utils(); if
			 * (!util.usuarioAutenticado(request)){ return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); } else{
			 * //Información que se obtiene del certificado digital ciudadano =
			 * obtenerUsuario(request);
			 * 
			 * if(ciudadano==null) return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			VisualizarAdmLocalForm formulario = (VisualizarAdmLocalForm) form;

			formulario = rellenaFormulario(formulario, ciudadano, request);

			request.setAttribute("VisualizarAdmLocalForm", formulario);
			request.getSession().setAttribute("organismoSeleccionado",
					formulario.getOpcionOrganismo());
			request.getSession().setAttribute("nuevaListaAdmLocales",
					formulario.getNuevaListaAdmLocales());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarAdmLocalFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarAdmLocalForm rellenaFormulario(
			VisualizarAdmLocalForm formulario, UsuarioAutentificado usuario,
			HttpServletRequest request) throws Exception {

		// RELLENAMOS EL FORMULARIO CON EL LISTADO ORGANISMOS

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

		String actualizando = (String) request.getParameter("actualizando");
		String id = (String) request.getParameter("idAdmLocalSelecionado");

		List listaOrganismos = new ArrayList<Organismo>();
		List listaRelUsuOrgCentroPerf = new ArrayList<RelacionUsuOrgCentroPerf>();
		List listaRelUsuOrgCentroPerfAdministradoresGlobales = new ArrayList<RelacionUsuOrgCentroPerf>();
		List listaAdminLocal = new ArrayList<ObjetoUsuarioOrganismo>();
		List listaAdminGlobal = new ArrayList<ObjetoUsuarioOrganismo>();

		listaOrganismos = organismoService.findAll();

		// Aqui comprobamos si volvemos de alguna pagina, de forma que se
		// quedaria guardado aquello que habiamos rellenado anteriormente
		if (actualizando == null) {
			String vuelta = (String) request.getParameter("volver");
			if (vuelta != null) {
				actualizando = "si";
			}
		}

		if (actualizando != null) {

			formulario.setCambio("1");

			// Si no marcamos nada, no devuelve nada
			if (formulario.getOpcionOrganismo() != null
					&& !formulario.getOpcionOrganismo().equals("")) {
				listaRelUsuOrgCentroPerf = relacionUsuOrgCentroPerfService
						.findByCif(formulario.getOpcionOrganismo());
			} else {
				listaRelUsuOrgCentroPerf = relacionUsuOrgCentroPerfService
						.findByPerfil(Constantes.ADMIN_LOCAL);
				listaRelUsuOrgCentroPerfAdministradoresGlobales = relacionUsuOrgCentroPerfService
						.findByPerfil(Constantes.ADMIN_GLOBAL);

			}

			// Si la lista esta vacia no se ha marcadao nada, que no muestre
			// mensaje de que no hay usuarios
			if (listaRelUsuOrgCentroPerf.isEmpty()
					&& (formulario.getOpcionOrganismo() == null || formulario
							.getOpcionOrganismo().equals(""))) {
				formulario.setCambio("0");
			}

			Iterator it = listaRelUsuOrgCentroPerf.iterator();

			while (it.hasNext()) {

				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
						.next();
				// Compruebo que para el organismo, el usuario tiene perfil de
				// admin local
				if (relacionUsuOrgCentroPerf.getPerfil().getIdPerfil().equals(
						Constantes.ADMIN_LOCAL)) {
					List usuarios = usuarioService
							.findByNumeroDocumento(relacionUsuOrgCentroPerf
									.getUsuario());

					if (!usuarios.isEmpty()) {

						Usuario usu = (Usuario) usuarios.get(0);
						boolean enc = false;
						Iterator it2 = listaAdminLocal.iterator();
						ObjetoUsuarioOrganismo objetoUsuario = new ObjetoUsuarioOrganismo();
						objetoUsuario.setId(relacionUsuOrgCentroPerf
								.getIdRelacion());
						objetoUsuario
								.setNombreUsuario(usu.getNombre() + " "
										+ usu.getApellido1() + " "
										+ usu.getApellido2());
						objetoUsuario.setEmail(usu.getEmail());
						objetoUsuario.setNumDocumento(usu.getNumDocumento());
						// Compruebo que el usuario no esta metido ya
						while (it2.hasNext() && enc == false) {
							ObjetoUsuarioOrganismo usu2 = (ObjetoUsuarioOrganismo) it2
									.next();
							if (usu2.getNumDocumento().equals(
									usu.getNumDocumento())) {
								enc = true;
							}
						}
						if (enc == false) {
							List administradorGlobal = relacionUsuOrgCentroPerfService
									.findByUsuPerf(objetoUsuario
											.getNumDocumento(), String
											.valueOf(Constantes.ADMIN_GLOBAL));
							if (!administradorGlobal.isEmpty()) {
								objetoUsuario.setAdministrador(true);
							} else {
								objetoUsuario.setAdministrador(false);
							}
							List perfilesAdministradorLocal = relacionUsuOrgCentroPerfService
									.findByUsuPerf(objetoUsuario
											.getNumDocumento(), String
											.valueOf(Constantes.ADMIN_LOCAL));
							Iterator it3 = perfilesAdministradorLocal
									.iterator();
							List organimosUsuario = new ArrayList();
							while (it3.hasNext()) {
								RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf2 = (RelacionUsuOrgCentroPerf) it3
										.next();
								String organismo = relacionUsuOrgCentroPerf2
										.getOrganismo();
								List organismos = organismoService
										.findByCif(organismo);
								Organismo organismo2 = (Organismo) organismos
										.get(0);
								organimosUsuario.add(organismo2);
							}
							Collections.sort(organimosUsuario);
							objetoUsuario.setOrganismos(organimosUsuario);
							listaAdminLocal.add(objetoUsuario);
						}
					}

				}
			}
		}

		if (formulario.getOpcionOrganismo() == null
				|| formulario.getOpcionOrganismo().equals("")) {
			Iterator it = listaRelUsuOrgCentroPerfAdministradoresGlobales
					.iterator();
			while (it.hasNext()) {
				boolean encontrado = false;
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
						.next();
				Iterator it2 = listaAdminLocal.iterator();
				while (it2.hasNext()) {
					ObjetoUsuarioOrganismo usu = (ObjetoUsuarioOrganismo) it2
							.next();
					if (relacionUsuOrgCentroPerf.getUsuario().equals(
							usu.getNumDocumento())) {
						encontrado = true;
					}
				}
				if (encontrado == false) {
					List usuarios = usuarioService
							.findByNumeroDocumento(relacionUsuOrgCentroPerf
									.getUsuario());
					if (!usuarios.isEmpty()) {
						Usuario usu = (Usuario) usuarios.get(0);
						ObjetoUsuarioOrganismo objetoUsuario = new ObjetoUsuarioOrganismo();
						objetoUsuario.setAdministrador(true);
						objetoUsuario.setId(relacionUsuOrgCentroPerf
								.getIdRelacion());
						objetoUsuario
								.setNombreUsuario(usu.getNombre() + " "
										+ usu.getApellido1() + " "
										+ usu.getApellido2());
						objetoUsuario.setEmail(usu.getEmail());
						objetoUsuario.setNumDocumento(usu.getNumDocumento());
						listaAdminGlobal.add(objetoUsuario);
					}
				}
			}
			listaAdminLocal.addAll(listaAdminGlobal);
		}

		List<UsuarioVisualizar> listaAdminLocalNif = new ArrayList<UsuarioVisualizar>();
		
		if (formulario.getNif() != null && !formulario.getNif().equals("")) {
			listaAdminLocal = RellenaFormularioActionUtil.buscadorNifUsuarioOrganismo(
					listaAdminLocal, formulario.getNif());
		}

		Collections.sort(listaAdminLocal);
		formulario.setNuevaListaAdmLocales(listaAdminLocal);
		Collections.sort(listaOrganismos);
		formulario.setListaOrganismos(listaOrganismos);

		return formulario;
	}

}
