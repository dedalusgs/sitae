/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: SessionBean.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
 * Archivo: SessionBean.java <br>
 * Descripción: Bean de session con una lista de Objects donde se almacenarán
 * los datos necesarios. <br>
 * Copyright: Copyright, 22-10-2007<br>
 * Compañía: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */
public class SessionBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2487203376350462412L;

	/** The lista. */
	private List<Object> lista;

	/**
	 * Instantiates a new session bean.
	 */
	public SessionBean() {
		lista = new ArrayList<Object>();
	}

	/**
	 * Gets the lista.
	 * 
	 * @return the lista
	 */
	public List<Object> getLista() {
		return lista;
	}

	/**
	 * Sets the lista.
	 * 
	 * @param lista
	 *            the new lista
	 */
	public void setLista(List<Object> lista) {
		this.lista = lista;
	}

}