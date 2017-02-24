/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: ConfigurationException.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationException.
 */
public class ConfigurationException extends AppException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4832528078919664810L;

	/**
	 * Constructor por defecto de la clase.
	 */
	public ConfigurationException() {
		super();
	}

	/**
	 * Constructor con una descripcion como argumento.
	 * 
	 * @param descripcion
	 *            Descripcion de la excepcion
	 */
	public ConfigurationException(String descripcion) {
		super(descripcion);
	}
}
