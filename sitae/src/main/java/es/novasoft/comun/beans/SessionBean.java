package es.novasoft.comun.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	private static final long serialVersionUID = -2487203376350462412L;

	private List<Object> lista;

	public SessionBean() {
		lista = new ArrayList<Object>();
	}

	public List<Object> getLista() {
		return lista;
	}

	public void setLista(List<Object> lista) {
		this.lista = lista;
	}

}