package es.novasoft.comun.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Archivo: DAOException.java <br>
 * Descripci�n: Excepci�n de la aplicaci�n. <br>
 * Copyright: Copyright, 22-10-2007 <br>
 * Compa��a: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */

public class DAOException extends GeneralException {

	private static Log log = LogFactory.getFactory().getInstance(
			DAOException.class);

	/**
	 * @param message
	 *            Mensaje
	 */
	public DAOException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * @param etiqueta
	 *            Etiqueta identificativa de la excepci�n
	 * @param prettyKey
	 *            prettyKey
	 * @param message
	 *            Mensaje
	 */
	public DAOException(String message, String exceptionKey) {
		super(message);
		this.exceptionkey = exceptionKey;
		log.error(message);
	}

	/**
	 * @param etiqueta
	 *            Etiqueta identificativa de la excepci�n
	 * @param message
	 *            Mensaje
	 * @param prettyKey
	 *            prettyKey
	 * @param prettyMsg
	 *            prettyMsg
	 */
	public DAOException(String message, String exceptionKey,
			String exceptionMessage) {
		super(message);
		this.exceptionkey = exceptionKey;
		this.exceptionMessage = exceptionMessage;
		log.error(message);
	}
}