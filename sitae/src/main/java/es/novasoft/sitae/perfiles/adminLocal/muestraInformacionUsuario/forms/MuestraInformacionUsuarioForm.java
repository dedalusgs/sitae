package es.novasoft.sitae.perfiles.adminLocal.muestraInformacionUsuario.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.UsuarioExterno;

public class MuestraInformacionUsuarioForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private UsuarioVisualizar usuario;
	
	private UsuarioExterno usuarioExterno;

	private List listaCentrosAsignados;

	public UsuarioVisualizar getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVisualizar usuario) {
		this.usuario = usuario;
	}

	public MuestraInformacionUsuarioForm() {

		this.usuario = new UsuarioVisualizar();
		this.usuarioExterno = new UsuarioExterno();
	}

	public List getListaCentrosAsignados() {
		return listaCentrosAsignados;
	}

	public void setListaCentrosAsignados(List listaCentrosAsignados) {
		this.listaCentrosAsignados = listaCentrosAsignados;
	}

	public UsuarioExterno getUsuarioExterno() {
		return usuarioExterno;
	}

	public void setUsuarioExterno(UsuarioExterno usuarioExterno) {
		this.usuarioExterno = usuarioExterno;
	}

}
