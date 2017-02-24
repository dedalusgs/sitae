package es.novasoft.castellon.vfe.login.forms;

import java.util.List;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.struts.FormBase;

public class IndexForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List<Organismo> organismos;

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
