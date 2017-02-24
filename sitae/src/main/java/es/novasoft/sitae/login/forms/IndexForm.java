package es.novasoft.sitae.login.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.OrganismoVisualizar;

public class IndexForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List<OrganismoVisualizar> organismos;

	public IndexForm() {
		super();

	}

	public List getOrganismos() {
		return organismos;
	}

	public void setOrganismos(List organismos) {
		this.organismos = organismos;
	}

}
