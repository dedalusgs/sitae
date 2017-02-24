package es.novasoft.sitae.business.objects;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String telefono;

	private String movil;

	private String email;
	private boolean interno;

	public boolean isInterno() {
		return interno;
	}

	public void setInterno(boolean interno) {
		this.interno = interno;
	}

	private String numDocumento;

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
	public Usuario(String nombre, String apellido1, String apellido2,
			String telefono, String movil, String email, String numDocumento) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.movil = movil;
		this.email = email;
		this.numDocumento = numDocumento;
	}

	// Property accessors

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return this.movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}