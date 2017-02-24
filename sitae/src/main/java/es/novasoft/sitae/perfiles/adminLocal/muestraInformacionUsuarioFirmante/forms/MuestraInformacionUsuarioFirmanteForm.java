package es.novasoft.sitae.perfiles.adminLocal.muestraInformacionUsuarioFirmante.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.UsuarioVisualizar;

public class MuestraInformacionUsuarioFirmanteForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private UsuarioVisualizar usuario;

	public UsuarioVisualizar getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVisualizar usuario) {
		this.usuario = usuario;
	}

	public MuestraInformacionUsuarioFirmanteForm() {

		this.usuario = new UsuarioVisualizar();
	}

}
