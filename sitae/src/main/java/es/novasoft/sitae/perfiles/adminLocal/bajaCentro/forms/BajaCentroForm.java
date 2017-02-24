package es.novasoft.sitae.perfiles.adminLocal.bajaCentro.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;

public class BajaCentroForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private CentroProcedencia centro;

	public BajaCentroForm() {
		this.centro = new CentroProcedencia();

	}

	public CentroProcedencia getCentro() {
		return centro;
	}

	public void setCentro(CentroProcedencia centro) {
		this.centro = centro;
	}
}
