package es.novasoft.sitae.business.dao.interfaz;

/* Copyright Novasoft. Todos los derechos reservados. */
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
 * Archivo: DAOBaseI.java <br>
 * Descripción: <br>
 * Copyright: Copyright, 04/12/2007<br>
 * Compañía: Novasoft
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