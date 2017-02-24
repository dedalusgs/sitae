package es.novasoft.sitae.perfiles.adminGlobal.eliminarFestivo.forms;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Festivo;

public class EliminarFestivoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Festivo festivo;

	public EliminarFestivoForm() {
		this.festivo = new Festivo();

	}

	public Festivo getCentro() {
		return this.festivo;
	}

	public void setCentro(Festivo festivo) {
		this.festivo = festivo;
	}
}
