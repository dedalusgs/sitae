package es.novasoft.comun.exceptions;

/*
 * Copyright Novasoft. Todos los derechos reservados.
 */
/*
 * ======================================================================
 * Historial de modificaciones:
 * ......................................................................
 * FECHA: "Fecha de la modificaci�n"
 * AUTOR: "Autor de la modificaci�n"
 * VERSION ACTUAL: "Versi�n en la que se encuentra el archivo"
 * VERSION MODIFICADA: "Versi�n que se est� modificando"
 * RAZON: "Referencia a incidencia que ha provocado la modificaci�n"
 * DESCRIPCION: "Detalle de la/s modificaci�n/es realizadas"
 * ======================================================================
 */
/**
 * Archivo: AppException.java <br>
 * Descripci�n: Excepci�n de la aplicaci�n. <br>
 * Copyright: Copyright, 17-10-2007 <br>
 * Compa��a: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 7038712829284302075L;

	/**
	 * Constructor por defecto de la clase
	 */
	public AppException() {
		super();
	}

	/**
	 * Constructor con una descripci�n como argumento
	 * 
	 * @param descripcion
	 *            Descripci�n de la excepci�n
	 */
	public AppException(String descripcion) {
		super(descripcion);
	}

}
