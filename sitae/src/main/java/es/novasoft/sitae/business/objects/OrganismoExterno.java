package es.novasoft.sitae.business.objects;


/**
 * Organismo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class OrganismoExterno implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idOrg;

	private String nombre;

	private String cif;

	private String direccion;

	private String telefono;

	private String fax;

	private String email;

	// Constructors

	/** default constructor */
	public OrganismoExterno() {
	}

	/** minimal constructor */
	public OrganismoExterno(String nombre, String cif, String direccion,
			String telefono, String fax, String email) {
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fax = fax;
		this.email = email;
	}

	// Property accessors

	public Integer getIdOrg() {
		return this.idOrg;
	}

	public void setIdOrg(Integer idOrg) {
		this.idOrg = idOrg;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}