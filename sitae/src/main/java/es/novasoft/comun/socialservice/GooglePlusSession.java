package es.novasoft.comun.socialservice;

import es.novasoft.sitae.business.objects.Organismo;

public class GooglePlusSession {

	public static Long SIN_VALIDAR = new Long(1);
	public static Long USUARIO_AUTENTICADO_OK = new Long(2);
	public static Long USUARIO_AUTENTICADO_ERROR = new Long(3);

	private Long estado;

	private String state;

	private Organismo organismo;

	public GooglePlusSession() {

	}

	public GooglePlusSession(String state, Organismo organismo) {
		this.state = state;
		this.organismo = organismo;
		estado = SIN_VALIDAR;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Boolean isSinValidar() {
		return estado.equals(SIN_VALIDAR);
	}

	public Boolean isUsuarioAprobado() {
		return estado.equals(USUARIO_AUTENTICADO_OK);
	}

	public Boolean isUsuarioNoAprobado() {
		return estado.equals(USUARIO_AUTENTICADO_ERROR);
	}

	public void setSinValidar() {
		estado = USUARIO_AUTENTICADO_ERROR;
	}

	public void setUsuarioAprobado() {
		estado = USUARIO_AUTENTICADO_OK;
	}

	public void setUsuarioNoAprobado() {
		estado = USUARIO_AUTENTICADO_ERROR;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
