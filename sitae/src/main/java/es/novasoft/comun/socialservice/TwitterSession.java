package es.novasoft.comun.socialservice;

import twitter4j.Twitter;
import es.novasoft.sitae.business.objects.Organismo;

public class TwitterSession {

	public static Long SIN_VALIDAR = new Long(1);
	public static Long USUARIO_AUTENTICADO_OK = new Long(2);
	public static Long USUARIO_AUTENTICADO_ERROR = new Long(3);

	private Long estado;

	private Twitter twitter;

	private String token;

	private Organismo organismo;

	public TwitterSession() {

	}

	public TwitterSession(String token, Twitter twitter, Organismo organismo) {
		this.twitter = twitter;
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

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
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

}
