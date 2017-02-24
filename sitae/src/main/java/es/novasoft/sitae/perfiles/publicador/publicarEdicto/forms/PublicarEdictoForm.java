package es.novasoft.sitae.perfiles.publicador.publicarEdicto.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Edicto;

public class PublicarEdictoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Edicto edicto;

	private String idEdicto;

	public String getIdEdicto() {
		return idEdicto;
	}

	public void setIdEdicto(String idEdicto) {
		this.idEdicto = idEdicto;
	}

	public PublicarEdictoForm() {
		this.edicto = new Edicto();

	}

	public Edicto getEdicto() {
		return edicto;
	}

	public void setEdicto(Edicto edicto) {
		this.edicto = edicto;
	}

}
