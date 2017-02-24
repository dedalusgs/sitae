package es.novasoft.comun.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getFactory().getInstance(
			ServiceException.class);

	private String exceptionkey;

	private String exceptionMessage;

	/**
	 * @param message
	 *            Mensaje
	 */
	public ServiceException(String message) {
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
	public ServiceException(String message, String exceptionKey) {
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
	public ServiceException(String message, String exceptionKey,
			String exceptionMessage) {
		super(message);
		this.exceptionkey = exceptionKey;
		this.exceptionMessage = exceptionMessage;
		log.error(message);
	}

	public String getExceptionkey() {
		return exceptionkey;
	}

	public void setExceptionkey(String exceptionkey) {
		this.exceptionkey = exceptionkey;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}