package es.novasoft.comun.socialservice;

import es.novasoft.sitae.business.objects.Organismo;
import facebook4j.Facebook;

public class FacebookSession {

	public static Long SIN_VALIDAR = new Long(1);
	public static Long USUARIO_AUTENTICADO_OK = new Long(2);
	public static Long USUARIO_AUTENTICADO_ERROR = new Long(3);

	private Long estado;

	private Facebook facebook;

	private String token;

	private Organismo organismo;

	public FacebookSession() {

	}

	public FacebookSession(String token, Facebook facebook, Organismo organismo) {
		this.facebook = facebook;
		this.token = token;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public Facebook getFacebook() {
		return facebook;
	}

	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}

}
