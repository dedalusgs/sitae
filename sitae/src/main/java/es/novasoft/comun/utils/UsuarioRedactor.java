package es.novasoft.comun.utils;

import java.io.Serializable;

public class UsuarioRedactor implements Serializable,
		Comparable<UsuarioRedactor> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombreUsuario;

	private String numDocumento;

	private String email;

	private String perfil;

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

	public UsuarioRedactor() {
		super();
	}

	public UsuarioRedactor(String nombreUsuario, String numDocumento,
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
	public int compareTo(UsuarioRedactor o) {
		return this.nombreUsuario.compareTo(o.getNombreUsuario());
	}

}
