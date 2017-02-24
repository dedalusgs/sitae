package es.novasoft.sitae.perfiles.adminLocal.bajaUsuario.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Usuario;

public class BajaUsuarioForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public BajaUsuarioForm() {
		this.usuario = new Usuario();

	}

	public Usuario getOrganismo() {
		return usuario;
	}

	public void setOrganismo(Usuario usuario) {
		this.usuario = usuario;
	}
}
