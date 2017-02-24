/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: FormBase.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.struts;

import org.apache.struts.validator.ValidatorActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class FormBase.
 * 
 * @author Pedro Villatoro
 * @since 17-10-2007
 * @version 1.0
 */
public class FormBase extends ValidatorActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The LIN e_ sep. */
	private static final String LINE_SEP = System.getProperty("line.separator");

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer stringBuffer = new StringBuffer("Form: ");
		stringBuffer.append(this.getClass().getName());
		stringBuffer.append(LINE_SEP);
		return stringBuffer.toString();
	}
}
