package afirmaws.services.util;

public class DatosFirmaServidor {
	private String idAplicacion;
	private String idDocumento;
	private String firmante;
	private String idReferencia;
	private String algoritmoHash;
	private String formatoFirma;

	public String getIdAplicacion() {
		return this.idAplicacion;
	}

	public void setIdAplicacion(String paramString) {
		this.idAplicacion = paramString;
	}

	public String getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(String paramString) {
		this.idDocumento = paramString;
	}

	public String getFirmante() {
		return this.firmante;
	}

	public void setFirmante(String paramString) {
		this.firmante = paramString;
	}

	public String getIdReferencia() {
		return this.idReferencia;
	}

	public void setIdReferencia(String paramString) {
		this.idReferencia = paramString;
	}

	public String getAlgoritmoHash() {
		return this.algoritmoHash;
	}

	public void setAlgoritmoHash(String paramString) {
		this.algoritmoHash = paramString;
	}

	public String getFormatoFirma() {
		return this.formatoFirma;
	}

	public void setFormatoFirma(String paramString) {
		this.formatoFirma = paramString;
	}
}