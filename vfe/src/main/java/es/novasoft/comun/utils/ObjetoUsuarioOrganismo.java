/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: ObjetoUsuarioOrganismo.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjetoUsuarioOrganismo.
 */
public class ObjetoUsuarioOrganismo implements Serializable,
		Comparable<ObjetoUsuarioOrganismo> {

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

	/** The administrador. */
	private boolean administrador;

	/** The organismos. */
	private List organismos = new ArrayList();

	/**
	 * Checks if is administrador.
	 * 
	 * @return true, if is administrador
	 */
	public boolean isAdministrador() {
		return administrador;
	}

	/**
	 * Sets the administrador.
	 * 
	 * @param administrador
	 *            the new administrador
	 */
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	/**
	 * Gets the organismos.
	 * 
	 * @return the organismos
	 */
	public List getOrganismos() {
		return organismos;
	}

	/**
	 * Sets the organismos.
	 * 
	 * @param organismos
	 *            the new organismos
	 */
	public void setOrganismos(List organismos) {
		this.organismos = organismos;
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
	 * Instantiates a new objeto usuario organismo.
	 */
	public ObjetoUsuarioOrganismo() {
		super();
	}

	/**
	 * Instantiates a new objeto usuario organismo.
	 * 
	 * @param nombreUsuario
	 *            the nombre usuario
	 * @param numDocumento
	 *            the num documento
	 */
	public ObjetoUsuarioOrganismo(String nombreUsuario, String numDocumento) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.numDocumento = numDocumento;
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

	// Para ordenar por idVivienda (Preferencia de la vivienda)
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ObjetoUsuarioOrganismo o) {
		return this.nombreUsuario.compareTo(o.getNombreUsuario());
	}

}
