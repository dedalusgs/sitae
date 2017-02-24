/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: ServiceException.java
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
 * Descripción: Excepción general indefinida.<br>
 * Copyright: Copyright, 17-10-2007 <br>
 * Compañía: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */

public class ServiceException extends GeneralException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The log. */
	private static Log log = LogFactory.getFactory().getInstance(
			ServiceException.class);

	/** The exceptionkey. */
	private String exceptionkey;

	/** The exception message. */
	private String exceptionMessage;

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param message
	 *            Mensaje
	 */
	public ServiceException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param message
	 *            Mensaje
	 * @param exceptionKey
	 *            the exception key
	 */
	public ServiceException(String message, String exceptionKey) {
		super(message);
		this.exceptionkey = exceptionKey;
		log.error(message);
	}

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param message
	 *            Mensaje
	 * @param exceptionKey
	 *            the exception key
	 * @param exceptionMessage
	 *            the exception message
	 */
	public ServiceException(String message, String exceptionKey,
			String exceptionMessage) {
		super(message);
		this.exceptionkey = exceptionKey;
		this.exceptionMessage = exceptionMessage;
		log.error(message);
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