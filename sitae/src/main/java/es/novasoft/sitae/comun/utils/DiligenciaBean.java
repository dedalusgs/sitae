package es.novasoft.sitae.comun.utils;

import java.util.Date;

public class DiligenciaBean {
	private byte[]	diligencia;
	private byte[]	firma;
	private String	tipoFirma;
	private String	idTransaccion;
	private Date	caducidadFirma;
	
	public byte[] getDiligencia() {
		return diligencia;
	}
	
	public void setDiligencia(byte[] diligencia) {
		this.diligencia = diligencia;
	}
	
	public byte[] getFirma() {
		return firma;
	}
	
	public void setFirma(byte[] firma) {
		this.firma = firma;
	}
	
	public String getTipoFirma() {
		return tipoFirma;
	}
	
	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}
	
	public String getIdTransaccion() {
		return idTransaccion;
	}
	
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	
	public Date getCaducidadFirma() {
		return caducidadFirma;
	}
	
	public void setCaducidadFirma(Date caducidadFirma) {
		this.caducidadFirma = caducidadFirma;
	}
	
}
