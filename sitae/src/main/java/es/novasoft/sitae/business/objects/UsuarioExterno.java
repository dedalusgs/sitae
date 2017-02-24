/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExterno.java
 * Creado: 21-nov-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.business.objects;

// TODO: Auto-generated Javadoc
/**
 * Entidad para la consultad de los datos de usuarios de la universidad.
 *
 * @author ggomez
 */
public class UsuarioExterno implements java.io.Serializable {

	public UsuarioExterno() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The usu. */
	private String usu;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new usuario externo.
	 *
	 * @param usu the usu
	 * @param password the password
	 */
	public UsuarioExterno(String usu, String password) {
		super();
		this.usu = usu;
		this.password = password;
	}

	/**
	 * Gets the usu.
	 *
	 * @return the usu
	 */
	public String getUsu() {
		return usu;
	}

	/**
	 * Sets the usu.
	 *
	 * @param usu the new usu
	 */
	public void setUsu(String usu) {
		this.usu = usu;
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
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
