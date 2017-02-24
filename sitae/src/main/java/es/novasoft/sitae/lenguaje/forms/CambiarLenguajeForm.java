package es.novasoft.sitae.lenguaje.forms;

import es.novasoft.comun.struts.FormBase;

public class CambiarLenguajeForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private String idioma;

	private String acceso;

	public String getAcceso() {
		return acceso;
	}

	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}

	public CambiarLenguajeForm() {
		this.idioma = "es";
		this.acceso = "publico";
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
