package es.novasoft.sitae.perfiles.adminLocal.visualizarCentros.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;

public class VisualizarCentroForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevalistaCentros = new ArrayList();

	private String cambio = "";

	private CentroProcedencia centro;

	private List listaUsuarios;

	public List getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public VisualizarCentroForm() {

		this.centro = new CentroProcedencia();

	}

	public List getNuevalistaCentros() {
		return nuevalistaCentros;
	}

	public void setNuevalistaCentros(List nuevalistaCentros) {
		this.nuevalistaCentros = nuevalistaCentros;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public CentroProcedencia getCentro() {
		return centro;
	}

	public void setCentro(CentroProcedencia centro) {
		this.centro = centro;
	}

}
