package es.novasoft.castellon.vfe.business.objects;

import java.io.Serializable;
import java.util.Date;

public class RegistroDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	Long id;
	String csv;
	String rutaFichero;
	String nombreFichero;
	String rutaFirma;
	String nombreFirma;
	String tipoFirma;
	String tipoDocumento;
	String codAyto;
	Date fechaCreacion;

	public RegistroDocumento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public String getRutaFichero() {
		return rutaFichero;
	}

	public void setRutaFichero(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}

	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public String getRutaFirma() {
		return rutaFirma;
	}

	public void setRutaFirma(String rutaFirma) {
		this.rutaFirma = rutaFirma;
	}

	public String getNombreFirma() {
		return nombreFirma;
	}

	public void setNombreFirma(String nombreFirma) {
		this.nombreFirma = nombreFirma;
	}

	public String getTipoFirma() {
		return tipoFirma;
	}

	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodAyto() {
		return codAyto;
	}

	public void setCodAyto(String codAyto) {
		this.codAyto = codAyto;
	}

}
