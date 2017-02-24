package es.novasoft.sitae.perfiles.adminLocal.visualizarTiposEdictos.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Organismo;

public class VisualizarTiposEdictosForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevalistaTipoEdicto = new ArrayList();

	private Organismo organismo;

	public VisualizarTiposEdictosForm() {

		this.organismo = new Organismo();

	}

	public List getNuevalistaTipoEdicto() {
		return nuevalistaTipoEdicto;
	}

	public void setNuevalistaTipoEdicto(List nuevalistaTipoEdicto) {
		this.nuevalistaTipoEdicto = nuevalistaTipoEdicto;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

}
