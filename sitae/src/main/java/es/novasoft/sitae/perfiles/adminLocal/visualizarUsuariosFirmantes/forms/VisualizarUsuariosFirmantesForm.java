package es.novasoft.sitae.perfiles.adminLocal.visualizarUsuariosFirmantes.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.UsuarioVisualizar;

public class VisualizarUsuariosFirmantesForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List<UsuarioVisualizar> listaUsuariosFirmantes;

	private String nif;

	private String nombre;

	public VisualizarUsuariosFirmantesForm() {
		listaUsuariosFirmantes = new ArrayList<UsuarioVisualizar>();
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioVisualizar> getListaUsuariosFirmantes() {
		return listaUsuariosFirmantes;
	}

	public void setListaUsuariosFirmantes(
			List<UsuarioVisualizar> listaUsuariosFirmantes) {
		this.listaUsuariosFirmantes = listaUsuariosFirmantes;
	}

}
