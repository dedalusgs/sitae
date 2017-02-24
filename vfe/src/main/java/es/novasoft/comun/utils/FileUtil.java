/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: FileUtil.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUtil.
 */
public class FileUtil {

	/** The log. */
	private static Log log = LogFactory.getLog(FileUtil.class);

	/**
	 * DEVUELVE EL FICHERO FORMFILE AL FORMATO FILE.
	 * 
	 * @param formfile
	 *            the formfile
	 * @param rutaAdjunto
	 *            the ruta adjunto
	 * @param nombreAdjunto
	 *            the nombre adjunto
	 * @return the file
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */

	public static File conversion(FormFile formfile, String rutaAdjunto,
			String nombreAdjunto) throws FileNotFoundException, IOException {

		File file = new File(rutaAdjunto + File.separator + nombreAdjunto);

		log.debug("Ruta fichero = " + rutaAdjunto + File.separator
				+ nombreAdjunto);

		try {

			InputStream in = formfile.getInputStream();
			OutputStream out = new FileOutputStream(file);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();

		} catch (Exception te) {
			log.error("Se ha producido un error al obtener la lista de paises",
					te);
			return null;
		}
		return file;
	}

	/**
	 * Guardar archivo file system.
	 * 
	 * @param archivo
	 *            the archivo
	 * @param nombre
	 *            the nombre
	 * @param ruta
	 *            the ruta
	 * @throws Exception
	 *             the exception
	 */
	public static void guardarArchivoFileSystem(byte[] archivo, String nombre,
			String ruta) throws Exception {
		try {
			log.info("guardarArchivoFileSystem");
			File directorio = new File(ruta);
			log.info("ruta "+ruta);
			log.info("directorio "+directorio);
			directorio.mkdirs();
			if (directorio.exists()) {
				String rutaArchivo = ruta + File.separator + nombre;
				log.info("ruta de fichero: "+rutaArchivo);
				FileOutputStream fos = new FileOutputStream(rutaArchivo);
				fos.write(archivo);
				fos.close();
			}else{
				log.error("Directorio no encontrado para guardar fichero.");
			}	
		} catch (RuntimeException e) {
			e.printStackTrace();
			log
					.error("Se ha producido un error al guardar el fichero en file system."
							+ e);
		}
	}

}
