package es.novasoft.castellon.vfe.ws;

import java.io.Serializable;

public class RespuestaRegistro implements Serializable {
	String codigoERROR;
	String mensajeError;
	String csv;

	public RespuestaRegistro() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigoERROR() {
		return codigoERROR;
	}

	public void setCodigoERROR(String codigoERROR) {
		this.codigoERROR = codigoERROR;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

}
