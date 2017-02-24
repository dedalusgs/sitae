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

public class FileUtil {

	private static Log log = LogFactory.getLog(FileUtil.class);

	/**
	 * DEVUELVE EL FICHERO FORMFILE AL FORMATO FILE
	 * 
	 * @return
	 */

	public static File conversion(FormFile formfile, String rutaAdjunto,
			String nombreAdjunto) throws FileNotFoundException, IOException {

		File file = new File(rutaAdjunto + File.separator + nombreAdjunto);

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
			log.error("Se ha producido un error al obtener la lista de paises");
			return null;
		}
		return file;
	}

	public static void guardarArchivoFileSystem(byte[] archivo, String nombre,
			String ruta) throws Exception {
		try {
			File directorio = new File(ruta);
			directorio.mkdirs();
			String rutaArchivo = ruta + File.separator + nombre;
			FileOutputStream fos = new FileOutputStream(rutaArchivo);
			fos.write(archivo);
			fos.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
			log
					.error("Se ha producido un error al guardar el fichero en file system."
							+ e);
		}
	}

}
