/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioVisualizar.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioVisualizar.
 */
public class UsuarioVisualizar implements Serializable,
		Comparable<UsuarioVisualizar> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;

	/** The nombre usuario. */
	private String nombreUsuario;

	/** The nombre. */
	private String nombre;

	/** The apellido1. */
	private String apellido1;

	/** The apellido2. */
	private String apellido2;

	/** The movil. */
	private String movil;

	/** The telefono. */
	private String telefono;

	/** The email. */
	private String email;

	/** The perfil. */
	private String perfil;

	/** The id perfil. */
	private String idPerfil;

	/** The centro. */
	private String centro;

	/** The num documento. */
	private String numDocumento;

	/** The cargo. */
	private String cargo;

	private boolean interno;

	public boolean isInterno() {
		return interno;
	}

	/**
	 * Instantiates a new usuario visualizar.
	 * 
	 * @param nombreUsuario
	 *            the nombre usuario
	 * @param numDocumento
	 *            the num documento
	 * @param perfil
	 *            the perfil
	 */
	public UsuarioVisualizar(String nombreUsuario, String numDocumento,
			String perfil) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.numDocumento = numDocumento;
		this.perfil = perfil;
	}

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
	 * Instantiates a new usuario visualizar.
	 */
	public UsuarioVisualizar() {
		super();
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
	 * Gets the apellido1.
	 * 
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Sets the apellido1.
	 * 
	 * @param apellido1
	 *            the new apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Gets the apellido2.
	 * 
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Sets the apellido2.
	 * 
	 * @param apellido2
	 *            the new apellido2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Gets the serial version uid.
	 * 
	 * @return the serial version uid
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	public int compareTo(UsuarioVisualizar o) {
		return this.nombreUsuario.compareTo(o.getNombreUsuario());
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the telefono.
	 * 
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets the telefono.
	 * 
	 * @param telefono
	 *            the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets the movil.
	 * 
	 * @return the movil
	 */
	public String getMovil() {
		return movil;
	}

	/**
	 * Sets the movil.
	 * 
	 * @param movil
	 *            the new movil
	 */
	public void setMovil(String movil) {
		this.movil = movil;
	}

	/**
	 * Gets the id perfil.
	 * 
	 * @return the id perfil
	 */
	public String getIdPerfil() {
		return idPerfil;
	}

	/**
	 * Sets the id perfil.
	 * 
	 * @param idPerfil
	 *            the new id perfil
	 */
	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * Gets the cargo.
	 * 
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Sets the cargo.
	 * 
	 * @param cargo
	 *            the new cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setInterno(boolean interno) {
		this.interno = interno;
	}

}
