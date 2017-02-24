package es.novasoft.sitae.perfiles.adminLocal.muestraInformacionCentro.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Usuario;

public class MuestraInformacionCentroForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevalistaCentros = new ArrayList();

	private CentroProcedencia centro;

	private List listaUsuarios;

	public List getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public CentroProcedencia getCentro() {
		return centro;
	}

	public void setCentro(CentroProcedencia centro) {

		this.listaUsuarios = new ArrayList<Usuario>();
		this.centro = centro;

	}

	public List getNuevalistaCentros() {
		return nuevalistaCentros;
	}

	public void setNuevalistaCentros(List nuevalistaCentros) {
		this.nuevalistaCentros = nuevalistaCentros;
	}

	public MuestraInformacionCentroForm() {

		this.centro = new CentroProcedencia();
	}

}
