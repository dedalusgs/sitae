package es.novasoft.comun.utils;

import java.io.Serializable;

public class TemaVisualizar implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String Nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

}
