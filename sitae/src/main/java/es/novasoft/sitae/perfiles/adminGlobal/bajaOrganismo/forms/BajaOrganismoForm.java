package es.novasoft.sitae.perfiles.adminGlobal.bajaOrganismo.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Organismo;

public class BajaOrganismoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Organismo organismo;

	public BajaOrganismoForm() {
		this.organismo = new Organismo();

	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}
}
