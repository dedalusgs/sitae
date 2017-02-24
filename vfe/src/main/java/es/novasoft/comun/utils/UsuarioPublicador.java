/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioPublicador.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioPublicador.
 */
public class UsuarioPublicador implements Serializable,
		Comparable<UsuarioPublicador> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;

	/** The nombre usuario. */
	private String nombreUsuario;

	/** The num documento. */
	private String numDocumento;

	/** The email. */
	private String email;

	/** The perfil. */
	private String perfil;

	/** The centro. */
	private String centro;

	/**
	 * Gets the centro.
	 * 
	 * @return the centro
	 */
	public String getCentro() {
		return centro;
	}

	/**
	 * Sets the centro.
	 * 
	 * @param centro
	 *            the new centro
	 */
	public void setCentro(String centro) {
		this.centro = centro;
	}

	/**
	 * Gets the perfil.
	 * 
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Sets the perfil.
	 * 
	 * @param perfil
	 *            the new perfil
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Gets the num documento.
	 * 
	 * @return the num documento
	 */
	public String getNumDocumento() {
		return numDocumento;
	}

	/**
	 * Sets the num documento.
	 * 
	 * @param numDocumento
	 *            the new num documento
	 */
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Instantiates a new usuario publicador.
	 */
	public UsuarioPublicador() {
		super();
	}

	/**
	 * Instantiates a new usuario publicador.
	 * 
	 * @param nombreUsuario
	 *            the nombre usuario
	 * @param numDocumento
	 *            the num documento
	 * @param perfil
	 *            the perfil
	 */
	public UsuarioPublicador(String nombreUsuario, String numDocumento,
			String perfil) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.numDocumento = numDocumento;
		this.perfil = perfil;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the nombre usuario.
	 * 
	 * @return the nombre usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Sets the nombre usuario.
	 * 
	 * @param nombreUsuario
	 *            the new nombre usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	// Para ordenar por nombre
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(UsuarioPublicador o) {
		return this.nombreUsuario.compareTo(o.getNombreUsuario());
	}

}
