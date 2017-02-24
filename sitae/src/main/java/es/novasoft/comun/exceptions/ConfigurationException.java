package es.novasoft.comun.exceptions;

public class ConfigurationException extends AppException {

	private static final long serialVersionUID = 4832528078919664810L;

	/**
	 * Constructor por defecto de la clase
	 */
	public ConfigurationException() {
		super();
	}

	/**
	 * Constructor con una descripcion como argumento
	 * 
	 * @param descripcion
	 *            Descripcion de la excepcion
	 */
	public ConfigurationException(String descripcion) {
		super(descripcion);
	}
}
