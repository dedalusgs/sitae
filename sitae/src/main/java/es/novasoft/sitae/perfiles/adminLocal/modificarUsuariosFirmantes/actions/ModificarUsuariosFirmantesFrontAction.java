package es.novasoft.sitae.perfiles.adminLocal.modificarUsuariosFirmantes.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.perfiles.adminLocal.modificarUsuariosFirmantes.forms.ModificarUsuariosFirmantesForm;

public class ModificarUsuariosFirmantesFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
					.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			ModificarUsuariosFirmantesForm formulario = (ModificarUsuariosFirmantesForm) form;
			Object numeroErrores = (Object) request
					.getAttribute("numeroErrores");
			if (numeroErrores == null) {
				String numDocumento = (String) request
						.getParameter("idUsuarioSeleccionado");
				if (numDocumento != null && !numDocumento.equals("")) {
					String cif = (String) request.getSession().getAttribute(
							"cif");
					UsuarioFirmante usuarioFirmante = new UsuarioFirmante();
					Organismo organismo = null;
					List organismos = organismoService.findByCif(cif);
					organismo = (Organismo) organismos.get(0);
					usuarioFirmante = (UsuarioFirmante) usuarioFirmanteService
							.findByIdOrgNumeroDocumento(organismo.getIdOrg(),
									numDocumento).get(0);
					formulario.setUsuarioFirmante(usuarioFirmante);
				}
			}
			request.setAttribute("ModificarUsuariosFirmantesForm", formulario);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ModificarUsuariosForm", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
