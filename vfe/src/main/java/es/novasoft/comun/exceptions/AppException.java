/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: AppException.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.exceptions;

// TODO: Auto-generated Javadoc
/*
 * Copyright Novasoft. Todos los derechos reservados.
 */
/*
 * ======================================================================
 * Historial de modificaciones:
 * ......................................................................
 * FECHA: "Fecha de la modificación"
 * AUTOR: "Autor de la modificación"
 * VERSION ACTUAL: "Versión en la que se encuentra el archivo"
 * VERSION MODIFICADA: "Versión que se está modificando"
 * RAZON: "Referencia a incidencia que ha provocado la modificación"
 * DESCRIPCION: "Detalle de la/s modificación/es realizadas"
 * ======================================================================
 */
/**
 * Archivo: AppException.java <br>
 * Descripción: Excepción de la aplicación. <br>
 * Copyright: Copyright, 17-10-2007 <br>
 * Compañía: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */
public class AppException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7038712829284302075L;

	/**
	 * Constructor por defecto de la clase.
	 */
	public AppException() {
		super();
	}

	/**
	 * Constructor con una descripción como argumento.
	 * 
	 * @param descripcion
	 *            Descripción de la excepción
	 */
	public AppException(String descripcion) {
		super(descripcion);
	}

}
