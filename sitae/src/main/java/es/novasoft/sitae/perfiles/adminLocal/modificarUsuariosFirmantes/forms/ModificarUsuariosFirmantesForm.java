package es.novasoft.sitae.perfiles.adminLocal.modificarUsuariosFirmantes.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;

public class ModificarUsuariosFirmantesForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private UsuarioFirmante usuarioFirmante;

	public UsuarioFirmante getUsuarioFirmante() {
		return usuarioFirmante;
	}

	public void setUsuarioFirmante(UsuarioFirmante usuarioFirmante) {
		this.usuarioFirmante = usuarioFirmante;
	}

	public ModificarUsuariosFirmantesForm() {

		this.usuarioFirmante = new UsuarioFirmante();

	}

	/**
	 * Función para validar el alta de Organismo
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
				.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);

		if (usuarioFirmante.getNombre().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosusuario.nombre")));
		} else {
			if (usuarioFirmante.getNombre().length() >= Constantes.TAMANIO_MAX)
				errors.add(null,
						new ActionMessage("errors.maxlength", LenguajeUtil
								.getMensaje(request, "datosusuario.nombre")));
		}

		if (usuarioFirmante.getApellido1().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosusuario.apellido1")));
		} else {
			if (usuarioFirmante.getApellido1().length() >= Constantes.TAMANIO_MAX)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosusuario.apellido1")));
		}

		if (usuarioFirmante.getApellido2().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosusuario.apellido2")));
		} else {
			if (usuarioFirmante.getApellido2().length() >= Constantes.TAMANIO_MAX)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosusuario.apellido2")));
		}

		if (usuarioFirmante.getCargo().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosusuario.cargo")));
		} else {
			if (usuarioFirmante.getCargo().length() >= Constantes.TAMANIO_MAX)
				errors
						.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datosusuario.cargo")));
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

}
