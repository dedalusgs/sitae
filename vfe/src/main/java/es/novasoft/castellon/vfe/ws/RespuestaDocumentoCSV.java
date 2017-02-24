package es.novasoft.castellon.vfe.ws;

import java.io.Serializable;

public class RespuestaDocumentoCSV implements Serializable {
	String codigoERROR;
	String mensajeError;
	byte[] documento;

	public RespuestaDocumentoCSV() {

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

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

}
