package es.novasoft.comun.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Archivo: GeneralException.java <br>
 * Descripci�n: Excepci�n general en la aplicaci�n. <br>
 * Copyright: Copyright, 17-10-2007 <br>
 * Compa��a: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */

public class GeneralException extends Exception {

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
	 * @param message
	 *            Mensaje
	 */
	public GeneralException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * @param etiqueta
	 *            Etiqueta identificativa de la excepci�n
	 * @param message
	 *            Mensaje
	 */
	public GeneralException(String message, String exceptionkey) {
		super(message);
		log.error(message);
		this.exceptionkey = exceptionkey;
	}

	/**
	 * @param etiqueta
	 *            Etiqueta identificativa de la excepci�n
	 * @param message
	 *            Mensaje
	 */
	public GeneralException(String message, String exceptionkey,
			String exceptionMessage) {
		super(message);
		log.error(message);
		this.exceptionkey = exceptionkey;
		this.exceptionMessage = exceptionMessage;
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