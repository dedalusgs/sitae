package es.novasoft.sitae.business.objects;

public class Funcionalidad implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idFuncionalidad;

	private String nombre;

	// Constructors

	/** default constructor */
	public Funcionalidad() {
	}

	/** minimal constructor */
	public Funcionalidad(String nombre) {
		this.nombre = nombre;
	}

	// Property accessors

	public Integer getIdFuncionalidad() {
		return this.idFuncionalidad;
	}

	public void setIdFuncionalidad(Integer idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}