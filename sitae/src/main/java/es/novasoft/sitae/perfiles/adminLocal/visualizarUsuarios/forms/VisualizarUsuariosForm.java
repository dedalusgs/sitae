package es.novasoft.sitae.perfiles.adminLocal.visualizarUsuarios.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Usuario;

public class VisualizarUsuariosForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevaListaUsuariosPublicadoresRedactores;

	private String cambio = "";

	private List listaPerfiles;

	private Integer opcionPerfiles;

	private List listaCentros;

	private Integer opcionCentros;
	
	public List getListaCentros() {
		return listaCentros;
	}

	public void setListaCentros(List listaCentros) {
		this.listaCentros = listaCentros;
	}

	public Integer getOpcionCentros() {
		return opcionCentros;
	}

	public void setOpcionCentros(Integer opcionCentros) {
		this.opcionCentros = opcionCentros;
	}

	private String nif;

	private String nombre;

	Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public VisualizarUsuariosForm() {

		listaPerfiles = new ArrayList();
		opcionPerfiles = -1;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Integer getOpcionPerfiles() {
		return opcionPerfiles;
	}

	public void setOpcionPerfil(Integer opcionPerfiles) {
		this.opcionPerfiles = opcionPerfiles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}

	public List getNuevaListaUsuariosPublicadoresRedactores() {
		return nuevaListaUsuariosPublicadoresRedactores;
	}

	public void setNuevaListaUsuariosPublicadoresRedactores(
			List nuevaListaUsuariosPublicadoresRedactores) {
		this.nuevaListaUsuariosPublicadoresRedactores = nuevaListaUsuariosPublicadoresRedactores;
	}

	public void setOpcionPerfiles(Integer opcionPerfiles) {
		this.opcionPerfiles = opcionPerfiles;
	}

}
