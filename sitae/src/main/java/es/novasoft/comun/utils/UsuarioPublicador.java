package es.novasoft.comun.utils;

import java.io.Serializable;

public class UsuarioPublicador implements Serializable,
		Comparable<UsuarioPublicador> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombreUsuario;

	private String numDocumento;

	private String email;

	private String perfil;

	private String centro;

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioPublicador() {
		super();
	}

	public UsuarioPublicador(String nombreUsuario, String numDocumento,
			String perfil) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.numDocumento = numDocumento;
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	// Para ordenar por nombre
	public int compareTo(UsuarioPublicador o) {
		return this.nombreUsuario.compareTo(o.getNombreUsuario());
	}

}
