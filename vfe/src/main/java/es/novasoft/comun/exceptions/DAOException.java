/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: DAOException.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * Archivo: DAOException.java <br>
 * Descripción: Excepción de la aplicación. <br>
 * Copyright: Copyright, 22-10-2007 <br>
 * Compañía: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */

public class DAOException extends GeneralException {

	/** The log. */
	private static Log log = LogFactory.getFactory().getInstance(
			DAOException.class);

	/**
	 * Instantiates a new dAO exception.
	 * 
	 * @param message
	 *            Mensaje
	 */
	public DAOException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * Instantiates a new dAO exception.
	 * 
	 * @param message
	 *            Mensaje
	 * @param exceptionKey
	 *            the exception key
	 */
	public DAOException(String message, String exceptionKey) {
		super(message);
		this.exceptionkey = exceptionKey;
		log.error(message);
	}

	/**
	 * Instantiates a new dAO exception.
	 * 
	 * @param message
	 *            Mensaje
	 * @param exceptionKey
	 *            the exception key
	 * @param exceptionMessage
	 *            the exception message
	 */
	public DAOException(String message, String exceptionKey,
			String exceptionMessage) {
		super(message);
		this.exceptionkey = exceptionKey;
		this.exceptionMessage = exceptionMessage;
		log.error(message);
	}
}