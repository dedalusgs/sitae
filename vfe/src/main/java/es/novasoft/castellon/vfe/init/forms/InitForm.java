/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: InitForm.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.init.forms;

import es.novasoft.comun.struts.FormBase;

// TODO: Auto-generated Javadoc
/**
 * The Class InitForm.
 */
public class InitForm extends FormBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The idioma. */
	private String idioma;

	/**
	 * Instantiates a new inits the form.
	 */
	public InitForm() {
		this.idioma = "es";
	}

	/**
	 * Gets the idioma.
	 * 
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Sets the idioma.
	 * 
	 * @param idioma
	 *            the new idioma
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
