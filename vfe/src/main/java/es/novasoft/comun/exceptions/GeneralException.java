/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: GeneralException.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * Archivo: GeneralException.java <br>
 * Descripción: Excepción general en la aplicación. <br>
 * Copyright: Copyright, 17-10-2007 <br>
 * Compañía: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */

public class GeneralException extends Exception {

	/** The log. */
	private static Log log = LogFactory.getFactory().getInstance(
			GeneralException.class);

	/**
	 * Para internacionalizar el mensaje.
	 */
	protected String exceptionkey;

	/**
	 * Mensaje para mostrar a un cliente.
	 */
	protected String exceptionMessage;

	/**
	 * Instantiates a new general exception.
	 * 
	 * @param message
	 *            Mensaje
	 */
	public GeneralException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * Instantiates a new general exception.
	 * 
	 * @param message
	 *            Mensaje
	 * @param exceptionkey
	 *            the exceptionkey
	 */
	public GeneralException(String message, String exceptionkey) {
		super(message);
		log.error(message);
		this.exceptionkey = exceptionkey;
	}

	/**
	 * Instantiates a new general exception.
	 * 
	 * @param message
	 *            Mensaje
	 * @param exceptionkey
	 *            the exceptionkey
	 * @param exceptionMessage
	 *            the exception message
	 */
	public GeneralException(String message, String exceptionkey,
			String exceptionMessage) {
		super(message);
		log.error(message);
		this.exceptionkey = exceptionkey;
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * Gets the exceptionkey.
	 * 
	 * @return the exceptionkey
	 */
	public String getExceptionkey() {
		return exceptionkey;
	}

	/**
	 * Sets the exceptionkey.
	 * 
	 * @param exceptionkey
	 *            the new exceptionkey
	 */
	public void setExceptionkey(String exceptionkey) {
		this.exceptionkey = exceptionkey;
	}

	/**
	 * Gets the exception message.
	 * 
	 * @return the exception message
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * Sets the exception message.
	 * 
	 * @param exceptionMessage
	 *            the new exception message
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}