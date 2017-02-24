package es.novasoft.sitae.business.dao.interfaz;

/* Copyright Novasoft. Todos los derechos reservados. */
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
 * Archivo: DAOBaseI.java <br>
 * Descripci�n: <br>
 * Copyright: Copyright, 04/12/2007<br>
 * Compa��a: Novasoft
 * 
 * @author bjestes
 * @version 1.0
 */
public interface DAOBaseI {

	/**
	 * Realiza un flush de la session. Esto sincroniza los datos de la cache con
	 * los de la BBDD. Es necesario ponerlo antes de terminar los metodos
	 * transaccionales dentro del bloque try-catch de forma que en caso se
	 * produzca cualquier tipo de error con la BBDD se pueda controlar esa
	 * excepcion en el servicio y lanzar el rollback y controlar el mensaje.
	 */
	public void flush();

	public void flushAndClear();

}