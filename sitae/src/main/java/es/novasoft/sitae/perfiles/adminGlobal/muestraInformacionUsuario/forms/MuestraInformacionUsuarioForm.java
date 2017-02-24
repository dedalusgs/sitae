package es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionUsuario.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Usuario;

public class MuestraInformacionUsuarioForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private List listaOrganismosAsignados;

	private boolean administradorGlobal;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MuestraInformacionUsuarioForm() {

		this.usuario = new Usuario();
		this.administradorGlobal = false;
	}

	public List getListaOrganismosAsignados() {
		return listaOrganismosAsignados;
	}

	public void setListaOrganismosAsignados(List listaOrganismosAsignados) {
		this.listaOrganismosAsignados = listaOrganismosAsignados;
	}

	public boolean isAdministradorGlobal() {
		return administradorGlobal;
	}

	public void setAdministradorGlobal(boolean administradorGlobal) {
		this.administradorGlobal = administradorGlobal;
	}

}
