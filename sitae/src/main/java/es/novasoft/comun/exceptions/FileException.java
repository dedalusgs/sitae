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
 * Archivo: FileException.java <br>
 * Descripci�n: Excepci�n usada cuando se realizan operaciones con ficheros.
 * <br>
 * Copyright: Copyright, 17-10-2007 <br>
 * Compa��a: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */
public class FileException extends SystemException {

	private static final long serialVersionUID = -8794784320136547560L;

	/**
	 * Constructor por defecto de la clase
	 */
	public FileException() {
		super();
	}

	/**
	 * Constructor con una descripci�n como argumento
	 * 
	 * @param descripcion
	 *            Descripci�n de la excepci�n
	 */
	public FileException(String descripcion) {
		super(descripcion);
	}
}
