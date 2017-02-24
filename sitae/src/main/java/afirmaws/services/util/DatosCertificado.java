package afirmaws.services.util;

public class DatosCertificado {
	private byte[] datos;
	private String idAplicacion;
	private String modoValidacion;
	private String obtenerInfo;

	public byte[] getDatos() {
		return (byte[]) this.datos.clone();
	}

	public void setDatos(byte[] paramArrayOfByte) {
		this.datos = ((byte[]) paramArrayOfByte.clone());
	}

	public String getIdAplicacion() {
		return this.idAplicacion;
	}

	public void setIdAplicacion(String paramString) {
		this.idAplicacion = paramString;
	}

	public String getModoValidacion() {
		return this.modoValidacion;
	}

	public void setModoValidacion(String paramString) {
		this.modoValidacion = paramString;
	}

	public String getObtenerInfo() {
		return this.obtenerInfo;
	}

	public void setObtenerInfo(String paramString) {
		this.obtenerInfo = paramString;
	}
}
