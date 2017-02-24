/**
 * 
 */
package es.novasoft.castellon.vfe.business.files;

import java.io.File;
import java.util.regex.Pattern;

/**
 * @author dabel
 * 
 */
public abstract class FileService {

	public Boolean checkPatron(String url) {
		if (url == null) {
			return Boolean.FALSE;
		}
		boolean respuesta = getPattern().matcher(url).find();
		return respuesta;
	};

	abstract public byte[] obtenerFichero(String Ruta) throws FileServiceException;

	abstract public File obtenerFicheroFile(String Ruta) throws FileServiceException;

	abstract public Pattern getPattern();

}
