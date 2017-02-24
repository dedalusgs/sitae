package es.novasoft.sitae.perfiles.adminLocal.bajaUsuarioFirmante.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.UsuarioFirmante;

public class BajaUsuarioFirmanteForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private UsuarioFirmante usuarioFirmante;

	public BajaUsuarioFirmanteForm() {
		this.usuarioFirmante = new UsuarioFirmante();

	}

	public UsuarioFirmante getUsuarioFirmante() {
		return usuarioFirmante;
	}

	public void setUsuarioFirmante(UsuarioFirmante usuarioFirmante) {
		this.usuarioFirmante = usuarioFirmante;
	}
}
