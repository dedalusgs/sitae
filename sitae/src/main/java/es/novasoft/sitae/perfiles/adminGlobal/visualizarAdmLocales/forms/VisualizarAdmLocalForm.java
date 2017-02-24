package es.novasoft.sitae.perfiles.adminGlobal.visualizarAdmLocales.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Usuario;

public class VisualizarAdmLocalForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevaListaAdmLocales;

	private List listaOrganismos;

	private String cambio = "";

	private String nif;
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	String opcionOrganismo;

	Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getOpcionOrganismo() {
		return opcionOrganismo;
	}

	public void setOpcionOrganismo(String opcionOrganismo) {
		this.opcionOrganismo = opcionOrganismo;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public List getListaOrganismos() {
		return listaOrganismos;
	}

	public void setListaOrganismos(List listaOrganismos) {
		this.listaOrganismos = listaOrganismos;
	}

	public List getNuevaListaAdmLocales() {
		return nuevaListaAdmLocales;
	}

	public void setNuevaListaAdmLocales(List nuevaListaAdmLocales) {
		this.nuevaListaAdmLocales = nuevaListaAdmLocales;
	}

	public VisualizarAdmLocalForm() {

		nuevaListaAdmLocales = new ArrayList();
		listaOrganismos = new ArrayList();
	}

}
