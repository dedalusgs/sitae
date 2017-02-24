package es.novasoft.sitae.business.objects;

// default package


/**
 * Perfil entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Perfil implements java.io.Serializable {

	// Fields

	private Integer idPerfil;

	private String nombre;

	// Constructors

	/** default constructor */
	public Perfil() {
	}

	/** minimal constructor */
	public Perfil(String nombre) {
		this.nombre = nombre;
	}

	// Property accessors

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}