package es.novasoft.sitae.perfiles.adminGlobal.visualizarOrganismos.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Organismo;

public class VisualizarOrganismoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevalistaOrganismos = new ArrayList();

	private String cambio = "";

	private Organismo organismo;

	private List listaUsuarios;

	public List getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public VisualizarOrganismoForm() {

		this.organismo = new Organismo();

	}

	public List getNuevalistaOrganismos() {
		return nuevalistaOrganismos;
	}

	public void setNuevalistaOrganismos(List nuevalistaOrganismos) {
		this.nuevalistaOrganismos = nuevalistaOrganismos;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

}
