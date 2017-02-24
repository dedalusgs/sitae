package afirmaws.services.util;

public class Documento {
	private String idAplicacion;
	private String contenidoficheroB64;
	private String nombreFichero;
	private String tipoDocumento;

	public String getIdAplicacion() {
		return this.idAplicacion;
	}

	public void setIdAplicacion(String paramString) {
		this.idAplicacion = paramString;
	}

	public String getContenidoficheroB64() {
		return this.contenidoficheroB64;
	}

	public void setContenidoficheroB64(String paramString) {
		this.contenidoficheroB64 = paramString;
	}

	public String getNombreFichero() {
		return this.nombreFichero;
	}

	public void setNombreFichero(String paramString) {
		this.nombreFichero = paramString;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String paramString) {
		this.tipoDocumento = paramString;
	}

	public String getNombreDocumentoSinExtension() {
		if (this.nombreFichero == null)
			return null;
		int i = this.nombreFichero.lastIndexOf('.');
		return this.nombreFichero.substring(0, i);
	}
}