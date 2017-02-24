/**
 * 
 */
package es.novasoft.castellon.vfe.business.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author dabel
 * 
 */
public class FileSystemService extends FileService {

	private Log log = LogFactory.getFactory().getInstance(FileSystemService.class);
	public static String PREFIJO = "file:///";
	private Pattern pattern;

	public byte[] obtenerFichero(String rutaArchivo) throws FileServiceException {
		if (rutaArchivo == null) {
			return null;
		}

		byte[] arrayByte;
		try {
			String ruta = rutaArchivo.substring(PREFIJO.length());

			File file = new File(ruta);
			if (!file.exists()) {
				return null;
			}

			arrayByte = FileUtils.readFileToByteArray(file);
		} catch (Exception e) {
			throw new FileServiceException("No ha sido posible recuperar el fichero de disco");
		}

		return arrayByte;
	}

	public File obtenerFicheroFile(String rutaArchivo) throws FileServiceException {
		if (rutaArchivo == null) {
			return null;
		}

		try {
			String ruta = rutaArchivo.substring(PREFIJO.length());

			File file = new File(ruta);
			if (!file.exists()) {
				throw new FileServiceException("No ha sido posible recuperar el fichero de disco");
			} else
				return file;

		} catch (Exception e) {
			throw new FileServiceException("No ha sido posible recuperar el fichero de disco");

		}

	}

	public void setPatronIdentificacion(String patronIdentificacion) {
		this.pattern = Pattern.compile(patronIdentificacion);
		;
	}

	@Override
	public Pattern getPattern() {

		return this.pattern;
	}

	private void fileCopy(String sourceFile, String destinationFile, Boolean eliminarOrigen) throws FileServiceException {

		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}

			in.close();
			out.close();
			if (eliminarOrigen) {
				File fileBorrador = new File(sourceFile);
				fileBorrador.delete();
			}
		} catch (IOException e) {
			throw new FileServiceException("Hubo un error al copiar ficheros entrada/salida!!!");

		}
	}

}
