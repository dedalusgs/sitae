/**
 * 
 */
package es.novasoft.sitae.business.files;

import java.io.File;
import java.util.regex.Pattern;

import es.novasoft.sitae.business.objects.Edicto;

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

	abstract public String guardarBorrador(byte[] fichero, Edicto edicto) throws FileServiceException;

	abstract public String publicarAnuncio(byte[] fichero, Edicto edicto) throws FileServiceException;

	abstract public byte[] obtenerFichero(String Ruta) throws FileServiceException;

	abstract public File obtenerFicheroFile(String Ruta) throws FileServiceException;

	abstract public Pattern getPattern();

	abstract public Boolean eliminarBorrador(Edicto edicto) throws FileServiceException;

	abstract public Boolean eliminarPublicado(Edicto edicto) throws FileServiceException;

	abstract public String guardarFirmaDiligencia(byte[] firmadiligencia, String nombre, Edicto edicto) throws FileServiceException;

	abstract public String guardarDiligencia(byte[] diligencia, Edicto edicto) throws FileServiceException;
}
