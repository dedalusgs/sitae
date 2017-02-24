package es.novasoft.castellon.vfe.admin.organismo.bajaOrganismo.forms;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.struts.FormBase;

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
