package es.novasoft.sitae.perfiles.adminGlobal.altaAdmLocal.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.altaAdmLocal.forms.AltaAdmLocalForm;

public class AltaAdmLocalDoAction extends ActionBase {

	private static Log log = LogFactory.getLog(AltaAdmLocalDoAction.class);

	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	PerfilService perfilService = (PerfilService) Factory
			.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	UsuarioAutentificado solicitante = null;

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String forward = ActionBase.SUCCESS_KEY;

		// CODIGO QUE COMPRUBA EL CANCELAR
		if (isCancelled(request)) {
			// Elimina los forms anticuados
			ResetForm.removeBean(mapping, request);
			return forward(request, mapping, ActionBase.CANCEL_KEY);
		}

		String statusBusqueda = (String) request.getSession().getAttribute(
				"statusBusqueda");
		if (statusBusqueda.equals("S")) {
			request.getSession().setAttribute("statusBusqueda", "N");
			return forward(request, mapping, ActionBase.SUCCESS_KEY_2);
		}

		try {

			AltaAdmLocalForm formulario = (AltaAdmLocalForm) form;
			
			if (!formulario.getUsuario().isInterno()){
				String numDocumento= formulario.getUsuario().getNumDocumento().toUpperCase();
				formulario.getUsuario().setNumDocumento(numDocumento);
			}

			if (isCancelled(request)) {
				return mapping.findForward("cancel");
			}

			// SE COMPRUEBA QUE SE HA ACCEDIDO DE MANERA CORRECTA
			/*
			 * Utils util = new Utils(); if (!util.usuarioAutenticado(request)){
			 * return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			List listaUsuarios = usuarioService
					.findByNumeroDocumento(formulario.getUsuario()
							.getNumDocumento());
			if (listaUsuarios.isEmpty()) {
				usuarioService.save(formulario.getUsuario());
			} else {
				Usuario usuario = (Usuario) listaUsuarios.get(0);
				usuario.setNombre(formulario.getUsuario().getNombre());
				usuario.setApellido1(formulario.getUsuario().getApellido1());
				usuario.setApellido2(formulario.getUsuario().getApellido2());
				usuario.setTelefono(formulario.getUsuario().getTelefono());
				usuario.setMovil(formulario.getUsuario().getMovil());
				usuario.setEmail(formulario.getUsuario().getEmail());
				usuarioService.attachDirty(usuario);
			}
			if (formulario.isAdministradorGlobal()) {
				Perfil perfilAdministradorLocal = perfilService
						.findById(Constantes.ADMIN_GLOBAL);
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
				relacionUsuOrgCentroPerf.setCentroProcedencia(null);
				relacionUsuOrgCentroPerf.setPerfil(perfilAdministradorLocal);
				String cif = (String) request.getSession().getAttribute("cif");
				relacionUsuOrgCentroPerf.setOrganismo(cif);
				relacionUsuOrgCentroPerf.setUsuario(formulario.getUsuario()
						.getNumDocumento());
				relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);
			}
			if (formulario.getOpcion() != null
					&& !formulario.getOpcion().equals("")) {
				Perfil perfilAdministradorLocal = perfilService
						.findById(Constantes.ADMIN_LOCAL);
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
				relacionUsuOrgCentroPerf.setCentroProcedencia(null);
				relacionUsuOrgCentroPerf.setPerfil(perfilAdministradorLocal);
				relacionUsuOrgCentroPerf.setOrganismo(formulario.getOpcion());
				relacionUsuOrgCentroPerf.setUsuario(formulario.getUsuario()
						.getNumDocumento());
				relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);
			}
			request.setAttribute("nifSeleccionado", formulario.getUsuario()
					.getNumDocumento());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("ERROR:" + ex.getMessage());
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {
			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
