package es.novasoft.sitae.init.forms;

import es.novasoft.comun.struts.FormBase;

public class InitForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private String idioma;

	public InitForm() {
		this.idioma = "es";
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
