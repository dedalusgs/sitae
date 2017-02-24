/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExterno.java
 * Creado: 21-nov-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.objects;

// TODO: Auto-generated Javadoc
/**
 * Entidad para la consultad de los datos de usuarios de la universidad.
 * 
 * @author ggomez
 */
public class Usuario implements java.io.Serializable {

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The usu. */
	private String usuario;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new usuario externo.
	 * 
	 * @param usu
	 *            the usu
	 * @param password
	 *            the password
	 */
	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
