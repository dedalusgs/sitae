package es.novasoft.castellon.vfe.ws;

import java.io.Serializable;

public class PeticionRegistro implements Serializable {
	private String usuario;
	private String contrasenia;
	private String nombreDocumento;
	private String idDocumento;
	private String tipoFirma;
	private String nombreFirma;
	private String idFirma;
	private String csv;
	private String tipoDocumento;
	private String idMunicipio;

	public PeticionRegistro() {

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

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTipoFirma() {
		return tipoFirma;
	}

	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}

	public String getNombreFirma() {
		return nombreFirma;
	}

	public void setNombreFirma(String nombreFirma) {
		this.nombreFirma = nombreFirma;
	}

	public String getIdFirma() {
		return idFirma;
	}

	public void setIdFirma(String idFirma) {
		this.idFirma = idFirma;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

}
