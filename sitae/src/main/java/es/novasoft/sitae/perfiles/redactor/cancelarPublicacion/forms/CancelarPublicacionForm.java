package es.novasoft.sitae.perfiles.redactor.cancelarPublicacion.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Edicto;

public class CancelarPublicacionForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Edicto edicto;

	public CancelarPublicacionForm() {
		this.edicto = new Edicto();

	}

	public Edicto getEdicto() {
		return edicto;
	}

	public void setEdicto(Edicto edicto) {
		this.edicto = edicto;
	}
}
