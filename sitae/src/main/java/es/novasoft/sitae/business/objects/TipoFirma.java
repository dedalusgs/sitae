package es.novasoft.sitae.business.objects;

import java.io.Serializable;

public class TipoFirma implements Serializable{

	
	private static final long serialVersionUID = 1L;
	public static final int PORTAFIRMAS = 2;
	public static final int STAMP_SERVICE = 3;
	public static final int DOC_FIRMADO = 1;
	
	private int idTipoFirma;
	
	private String nombre;
	
	
	public TipoFirma(){
		}
	
	public TipoFirma(String nombre){
		this.nombre=nombre;
	}

	public int getIdTipoFirma() {
		return idTipoFirma;
	}

	public void setIdTipoFirma(int idTipoFirma) {
		this.idTipoFirma = idTipoFirma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
