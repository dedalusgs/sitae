package es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionUsuario.actions;

import java.util.ArrayList;
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
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionUsuario.forms.MuestraInformacionUsuarioForm;

public class MuestraInformacionUsuarioFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			UsuarioService usuarioService = (UsuarioService) Factory
					.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
					.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			UsuarioAutentificado ciudadano = null;

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver"); }
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

			MuestraInformacionUsuarioForm formulario = (MuestraInformacionUsuarioForm) form;
			formulario.setAdministradorGlobal(false);

			Usuario usuario = new Usuario();

			// Obtengo el id del administrador en la Tabla REL_USU_ORG...
			String dni = (String) request.getParameter("idAdmLocalSelecionado");
			List<Organismo> listaOrganismosAsignados = new ArrayList();
			if (dni != null && !dni.equals("")) {
				List usuarios = usuarioService.findByNumeroDocumento(dni);
				if (!usuarios.isEmpty()) {

					usuario = (Usuario) usuarioService.findByNumeroDocumento(
							dni).get(0);

					List<RelacionUsuOrgCentroPerf> listaRelaciones = relacionUsuOrgCentroPerfService
							.findByUsuario(dni);
					Iterator it = listaRelaciones.iterator();

					while (it.hasNext()) {
						RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfAux = (RelacionUsuOrgCentroPerf) it
								.next();
						if (relacionUsuOrgCentroPerfAux.getPerfil()
								.getIdPerfil().equals(Constantes.ADMIN_LOCAL)) {
							Organismo organismo = (Organismo) organismoService
									.findByCif(
											relacionUsuOrgCentroPerfAux
													.getOrganismo()).get(0);
							listaOrganismosAsignados.add(organismo);
						}
						if (relacionUsuOrgCentroPerfAux.getPerfil()
								.getIdPerfil().equals(Constantes.ADMIN_GLOBAL)) {
							formulario.setAdministradorGlobal(true);
						}

					}
				}
			}
			formulario.setListaOrganismosAsignados(listaOrganismosAsignados);
			formulario.setUsuario(usuario);
			request.setAttribute("MuestraInformacionUsuarioForm", formulario);
			request.getSession().setAttribute("DNI",
					formulario.getUsuario().getNumDocumento());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionUsuarioFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
