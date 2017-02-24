package es.novasoft.comun.utils;

import java.io.Serializable;

public class UsuarioVisualizar implements Serializable,
		Comparable<UsuarioVisualizar> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombreUsuario;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String movil;

	private String telefono;

	private String email;

	private String perfil;

	private String idPerfil;

	private String centro;

	private String numDocumento;

	private String cargo;
	
	private Boolean interno;

	public Boolean getInterno() {
		return interno;
	}

	public void setInterno(Boolean interno) {
		this.interno = interno;
	}

	public UsuarioVisualizar(String nombreUsuario, String numDocumento,
			String perfil) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.numDocumento = numDocumento;
		this.perfil = perfil;
	}

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

	public UsuarioVisualizar() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	// Para ordenar por nombre
	public int compareTo(UsuarioVisualizar o) {
		return this.nombreUsuario.compareTo(o.getNombreUsuario());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
