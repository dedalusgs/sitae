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
 * FECHA: "Fecha de la modificaci�n"
 * AUTOR: "Autor de la modificaci�n"
 * VERSION ACTUAL: "Versi�n en la que se encuentra el archivo"
 * VERSION MODIFICADA: "Versi�n que se est� modificando"
 * RAZON: "Referencia a incidencia que ha provocado la modificaci�n"
 * DESCRIPCION: "Detalle de la/s modificaci�n/es realizadas"
 * ======================================================================
 */
/**
 * Archivo: SessionBean.java <br>
 * Descripci�n: Bean de session con una lista de Objects donde se almacenar�n
 * los datos necesarios. <br>
 * Copyright: Copyright, 22-10-2007<br>
 * Compa��a: Novasoft
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