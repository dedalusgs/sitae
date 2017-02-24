package es.novasoft.comun.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
	 *            Etiqueta identificativa de la excepción
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
	 *            Etiqueta identificativa de la excepción
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