package es.novasoft.sitae.login.business.objects;

public class UsuarioAutentificado {

	private String nombre;

	private String primerapellido;

	private String segundoapellido;

	private String dni;

	private String email;

	private String cifEntidad;

	private String nombreEntidad;

	private String anagrama;

	public UsuarioAutentificado(String nombre, String primerapellido,
			String segundoapellido, String dni, String email,
			String cifEntidad, String nombreEntidad, String anagrama) {
		super();
		this.nombre = nombre;
		this.primerapellido = primerapellido;
		this.segundoapellido = segundoapellido;
		this.dni = dni;
		this.email = email;
		this.cifEntidad = cifEntidad;
		this.nombreEntidad = nombreEntidad;
		this.anagrama = anagrama;
	}

	public String getAnagrama() {
		return anagrama;
	}

	public void setAnagrama(String anagrama) {
		this.anagrama = anagrama;
	}

	public UsuarioAutentificado() {
		nombre = primerapellido = segundoapellido = dni = email = cifEntidad = nombreEntidad = "";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerapellido() {
		return primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getSegundoapellido() {
		return segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getCifEntidad() {
		return cifEntidad;
	}

	public void setCifEntidad(String cifEntidad) {
		this.cifEntidad = cifEntidad;
	}

	public String getNombreEntidad() {
		return nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}

}
