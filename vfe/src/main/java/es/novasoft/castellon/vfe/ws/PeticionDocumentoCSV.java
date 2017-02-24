package es.novasoft.castellon.vfe.ws;

import java.io.Serializable;

public class PeticionDocumentoCSV implements Serializable {
	private String usuario;
	private String contrasenia;
	private String idDocumento;
	private String csv;
	private String idAyto;

	public PeticionDocumentoCSV() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public String getIdAyto() {
		return idAyto;
	}

	public void setIdAyto(String idAyto) {
		this.idAyto = idAyto;
	}

}
