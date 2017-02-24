package es.novasoft.sitae.business.objects;


import java.util.regex.Pattern;

public class TipoEdicto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idTipoEdicto;

	private Organismo organismo;

	private String nombre;

	// Constructors

	/** default constructor */
	public TipoEdicto() {
	}

	/** minimal constructor */
	public TipoEdicto(String nombre) {
		this.nombre = nombre;
	}

	/** full constructor */
	public TipoEdicto(Organismo organismo, String nombre) {
		this.organismo = organismo;
		this.nombre = nombre;
	}

	// Property accessors

	public Integer getidTipoEdicto() {
		return this.idTipoEdicto;
	}

	public void setidTipoEdicto(Integer idTipoEdicto) {
		this.idTipoEdicto = idTipoEdicto;
	}

	public Organismo getOrganismo() {
		return this.organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
