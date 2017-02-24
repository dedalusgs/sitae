package es.novasoft.sitae.business.objects;

public class Estado implements java.io.Serializable {

	// Fields

	private Integer idEstado;

	private String nombre;

	private Integer orden;
	
	// Constructors

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/** default constructor */
	public Estado() {
	}

	/** minimal constructor */
	public Estado(String nombre) {
		this.nombre = nombre;
	}

	// Property accessors

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
