package es.novasoft.sitae.perfiles.adminLocal.muestraInformacionUsuarioFirmante.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.perfiles.adminLocal.muestraInformacionUsuarioFirmante.forms.MuestraInformacionUsuarioFirmanteForm;

public class MuestraInformacionUsuarioFirmanteFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
					.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
			MuestraInformacionUsuarioFirmanteForm formulario = (MuestraInformacionUsuarioFirmanteForm) form;
			UsuarioFirmante usuarioFirmante = new UsuarioFirmante();
			UsuarioVisualizar usuarioVisualizar = new UsuarioVisualizar();
			String dni = (String) request.getParameter("idUsuarioSeleccionado");
			if (dni != null && !dni.equals("")) {
				String cif = (String) request.getSession().getAttribute("cif");
				usuarioFirmante = (UsuarioFirmante) usuarioFirmanteService
						.findByNumeroDocumento(dni).get(0);
				usuarioVisualizar.setNumDocumento(usuarioFirmante
						.getNumDocumento());
				usuarioVisualizar.setNombre(usuarioFirmante.getNombre());
				usuarioVisualizar.setApellido1(usuarioFirmante.getApellido1());
				usuarioVisualizar.setApellido2(usuarioFirmante.getApellido2());
				usuarioVisualizar.setCargo(usuarioFirmante.getCargo());
				formulario.setUsuario(usuarioVisualizar);
			}
			request.setAttribute("MuestraInformacionUsuarioFirmanteForm",
					formulario);
			request.getSession().setAttribute("DNI",
					formulario.getUsuario().getNumDocumento());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionUsuarioFirmanteFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
