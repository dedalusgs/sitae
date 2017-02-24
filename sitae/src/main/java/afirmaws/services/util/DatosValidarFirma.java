package afirmaws.services.util;

public class DatosValidarFirma {
	private String idAplicacion;
	private String firmaElectronica;
	private String formatoFirma;
	private String hash;
	private String algoritmoHash;
	private byte[] contenidoFichero;
	private String obtenerInfo;

	public String getIdAplicacion() {
		return this.idAplicacion;
	}

	public void setIdAplicacion(String paramString) {
		this.idAplicacion = paramString;
	}

	public String getFirmaElectronica() {
		return this.firmaElectronica;
	}

	public void setFirmaElectronica(String paramString) {
		this.firmaElectronica = paramString;
	}

	public String getFormatoFirma() {
		return this.formatoFirma;
	}

	public void setFormatoFirma(String paramString) {
		this.formatoFirma = paramString;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String paramString) {
		this.hash = paramString;
	}

	public String getAlgoritmoHash() {
		return this.algoritmoHash;
	}

	public void setAlgoritmoHash(String paramString) {
		this.algoritmoHash = paramString;
	}

	public byte[] getContenidoFichero() {
		return (byte[]) this.contenidoFichero.clone();
	}

	public void setContenidoFichero(byte[] paramArrayOfByte) {
		this.contenidoFichero = ((byte[]) paramArrayOfByte.clone());
	}

	public String getObtenerInfo() {
		return this.obtenerInfo;
	}

	public void setObtenerInfo(String paramString) {
		this.obtenerInfo = paramString;
	}

}
