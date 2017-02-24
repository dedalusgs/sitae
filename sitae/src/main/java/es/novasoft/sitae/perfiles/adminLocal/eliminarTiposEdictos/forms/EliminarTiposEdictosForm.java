package es.novasoft.sitae.perfiles.adminLocal.eliminarTiposEdictos.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.TipoEdicto;

public class EliminarTiposEdictosForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private TipoEdicto tipoEdicto;

	public EliminarTiposEdictosForm() {
		this.tipoEdicto = new TipoEdicto();

	}

	public TipoEdicto getTipoEdicto() {
		return tipoEdicto;
	}

	public void setTipoEdicto(TipoEdicto tipoEdicto) {
		this.tipoEdicto = tipoEdicto;
	}

}
