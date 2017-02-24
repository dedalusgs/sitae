package es.novasoft.sitae.business.objects;

public class UsuarioFirmante implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuarioFirmante;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String cargo;

	private Organismo organismo;

	private String numDocumento;

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	/** default constructor */
	public UsuarioFirmante() {
	}

	/** minimal constructor */
	public UsuarioFirmante(String nombre, String apellido1, String apellido2,
			String cargo, String numDocumento) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cargo = cargo;
		this.numDocumento = numDocumento;
	}

	public Integer getIdUsuarioFirmante() {
		return this.idUsuarioFirmante;
	}

	public void setIdUsuarioFirmante(Integer idUsuarioFirmante) {
		this.idUsuarioFirmante = idUsuarioFirmante;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

}