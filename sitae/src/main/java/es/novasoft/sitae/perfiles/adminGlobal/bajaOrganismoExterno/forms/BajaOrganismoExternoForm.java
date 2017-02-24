package es.novasoft.sitae.perfiles.adminGlobal.bajaOrganismoExterno.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.OrganismoExterno;

public class BajaOrganismoExternoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private OrganismoExterno organismoExterno;

	public BajaOrganismoExternoForm() {
		this.organismoExterno = new OrganismoExterno();

	}

	public OrganismoExterno getOrganismoExterno() {
		return organismoExterno;
	}

	public void setOrganismoExterno(OrganismoExterno organismoExterno) {
		this.organismoExterno = organismoExterno;
	}

}
