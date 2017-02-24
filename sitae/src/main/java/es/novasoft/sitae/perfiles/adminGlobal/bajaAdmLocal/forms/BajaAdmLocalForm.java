package es.novasoft.sitae.perfiles.adminGlobal.bajaAdmLocal.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Usuario;

public class BajaAdmLocalForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public BajaAdmLocalForm() {
		this.usuario = new Usuario();

	}

	public Usuario getOrganismo() {
		return usuario;
	}

	public void setOrganismo(Usuario usuario) {
		this.usuario = usuario;
	}
}
