/**
 * 
 */
package es.novasoft.sitae.business.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibm.icu.text.SimpleDateFormat;

import es.novasoft.sitae.business.objects.Edicto;

/**
 * @author dabel
 * 
 */
public class FileSystemService extends FileService {
	
	private String	     rutaAlmacenamientoBorrador;
	private String	     rutaAlmacenamientoPublicado;
	private Log	         log	    = LogFactory.getFactory().getInstance(FileSystemService.class);
	public static String	PREFIJO	= "file:///";
	private Pattern	     pattern;
	
	public String guardarBorrador(byte[] fichero, Edicto edicto) throws FileServiceException {
		if (edicto == null || edicto.getCentro() == null) {
			throw new FileServiceException(" El edicto no está inicializado");
		}
		
		String ruta = generarRutaBorrador(edicto);
		File file = new File(ruta);
		String rutaFinal = null;
		try {
			
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(ruta + "/" + edicto.getIdEdicto() + ".pdf");
			file.createNewFile();
			FileOutputStream fileOut = new FileOutputStream(file);
			fileOut.write(fichero);
			fileOut.close();
			rutaFinal = PREFIJO + file.getCanonicalPath();
		} catch (IOException e) {
			throw (new FileServiceException("Error guardando fichero en el sistema de ficheros ", e));
		}
		return rutaFinal;
		
	}
	
	public String publicarAnuncio(byte[] fichero, Edicto edicto) throws FileServiceException {
		if (edicto == null || edicto.getCentro() == null) {
			throw new FileServiceException(" El edicto no estÃ¡ inicializado");
			
		}
		
		String rutaPublicado = null;
		String rutaEnBorrador = null;
		try {
			if (fichero == null) {
				String ruta = generarRutaPublicado(edicto);
				
				File file = new File(ruta);
				if (!file.exists()) {
					file.mkdirs();
				}
				String rutaPublicacion = ruta + "/" + edicto.getCodigo() + ".pdf";
				file = new File(rutaPublicacion);
				fileCopy(edicto.getPdfAdjuntoString().substring(PREFIJO.length() - 1), rutaPublicacion, Boolean.FALSE);
				rutaPublicado = PREFIJO + file.getCanonicalPath();
				
			} else {
				String ruta = generarRutaPublicado(edicto);
				File file = new File(ruta);
				if (!file.exists()) {
					file.mkdirs();
				}
				String rutaPublicacion = ruta + "/" + edicto.getCodigo() + ".pdf";
				file = new File(rutaPublicacion);
				file.createNewFile();
				FileOutputStream fileOut = new FileOutputStream(file);
				fileOut.write(fichero);
				fileOut.close();
				
				rutaPublicado = PREFIJO + file.getCanonicalPath();
			}
			
		} catch (Exception e) {
			throw new FileServiceException("Error E/S en sistema de ficheros", e);
		}
		
		return rutaPublicado;
	}
	
	public String guardarDiligencia(byte[] diligencia, Edicto edicto) throws FileServiceException {
		if (edicto == null || edicto.getCentro() == null) {
			throw new FileServiceException(" El edicto no estaá inicializado");
			
		}
		try {
			String rutaDiligenciaFinal = null;
			if (diligencia == null) {
				throw new FileServiceException(" La diligencia está vacía");
			} else {
				
				String ruta = generarRutaDiligencia(edicto);
				File file = new File(ruta);
				if (!file.exists()) {
					file.mkdirs();
				}
				String rutaDiligencia = ruta + "/DILIGENCIA_" + edicto.getCodigo() + ".pdf";
				file = new File(rutaDiligencia);
				file.createNewFile();
				FileOutputStream fileOut = new FileOutputStream(file);
				fileOut.write(diligencia);
				fileOut.close();
				rutaDiligenciaFinal = PREFIJO + file.getCanonicalPath();
			}
			return rutaDiligenciaFinal;
		} catch (Exception e) {
			throw new FileServiceException("Error E/S en sistema de ficheros", e);
		}
	}
	
	public String guardarFirmaDiligencia(byte[] firmadiligencia, String nombre, Edicto edicto) throws FileServiceException {
		if (edicto == null || edicto.getCentro() == null) {
			throw new FileServiceException(" El edicto no estaá inicializado");
			
		}
		try {
			String rutaFirmaDiligenciaFinal = null;
			if (firmadiligencia == null) {
				log.warn("No hay firma. La diligencia debe ser firma PADES");
				return null;
			} else {
				
				String ruta = generarRutaFirmaDiligencia(edicto);
				File file = new File(ruta);
				if (!file.exists()) {
					file.mkdirs();
				}
				String nombreFichero = edicto.getCodigo() + "diligencia_firma.xml";
				if (nombre != null && !nombre.equals("")) {
					nombreFichero = nombre;
				}
				String rutaDiligencia = ruta + "/" + nombreFichero;
				file = new File(rutaDiligencia);
				file.createNewFile();
				FileOutputStream fileOut = new FileOutputStream(file);
				fileOut.write(firmadiligencia);
				fileOut.close();
				rutaFirmaDiligenciaFinal = PREFIJO + file.getCanonicalPath();
			}
			return rutaFirmaDiligenciaFinal;
		} catch (Exception e) {
			throw new FileServiceException("Error E/S en sistema de ficheros", e);
		}
	}
	
	public byte[] obtenerFichero(String rutaArchivo) throws FileServiceException {
		if (rutaArchivo == null) {
			return null;
		}
		
		byte[] arrayByte;
		try {
			String ruta = rutaArchivo.substring(PREFIJO.length());
			
			File file = new File(ruta);
			if (!file.exists()) {
				throw new FileServiceException("No ha sido posible recuperar el fichero de disco");
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
			} else return file;
			
		} catch (Exception e) {
			throw new FileServiceException("No ha sido posible recuperar el fichero de disco");
			
		}
		
	}
	
	public String getRutaAlmacenamientoBorrador() {
		return this.rutaAlmacenamientoBorrador;
	}
	
	public void setRutaAlmacenamientoBorrador(String rutaAlmacenamientoBorrador) {
		this.rutaAlmacenamientoBorrador = rutaAlmacenamientoBorrador;
	}
	
	public String getRutaAlmacenamientoPublicado() {
		return this.rutaAlmacenamientoPublicado;
	}
	
	public void setRutaAlmacenamientoPublicado(String rutaAlmacenamientoPublicado) {
		this.rutaAlmacenamientoPublicado = rutaAlmacenamientoPublicado;
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
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.uvtae.business.files.FileService#eliminarBorrador(es.novasoft
	 * .uvtae.business.objects.Edicto)
	 */
	@Override
	public Boolean eliminarBorrador(Edicto edicto) throws FileServiceException {
		
		String ruta = generarRutaBorrador(edicto);
		ruta = ruta + "/" + edicto.getIdEdicto() + ".pdf";
		File fileBorrador = new File(ruta);
		
		return fileBorrador.delete();
	}
	
	@Override
	public Boolean eliminarPublicado(Edicto edicto) throws FileServiceException {
		if (edicto.getCodigo() == null || edicto.getCodigo().equals("")) {
			throw new FileServiceException("El edicto no tiene codigo de publicacion por lo que no es posible eliminar el fichero del anuncio, en el caso de que exista");
		}
		String ruta = generarRutaPublicado(edicto);
		ruta = ruta + "/" + edicto.getCodigo() + ".pdf";
		File fileBorrador = new File(ruta);
		
		return fileBorrador.delete();
	}
	
	private String generarRutaPublicado(Edicto edicto) {
		SimpleDateFormat formateador2 = new SimpleDateFormat("YYYY", new Locale("es_ES"));
		String anio = formateador2.format(edicto.getFechaPublicacion());
		
		String codigoAyto = edicto.getOrganismo().getCodigo();
		String area = edicto.getCentro().getNombreCarpeta();
		SimpleDateFormat formateador = new SimpleDateFormat("MMMM", new Locale("es_ES"));
		String mes = formateador.format(edicto.getFechaPublicacion());
		String ruta = this.rutaAlmacenamientoPublicado + "/" + codigoAyto + "/EDICTOS/" + area + "/" + anio + "/" + mes + "/" + edicto.getCodigo();
		ruta = ruta.trim();
		return ruta;
	}
	
	private String generarRutaDiligencia(Edicto edicto) {
		SimpleDateFormat formateador2 = new SimpleDateFormat("YYYY", new Locale("es_ES"));
		String anio = formateador2.format(edicto.getFechaPublicacion());
		
		String codigoAyto = edicto.getOrganismo().getCodigo();
		String area = edicto.getCentro().getNombreCarpeta();
		SimpleDateFormat formateador = new SimpleDateFormat("MMMM", new Locale("es_ES"));
		String mes = formateador.format(edicto.getFechaPublicacion());
		String ruta = this.rutaAlmacenamientoPublicado + "/" + codigoAyto + "/EDICTOS/" + area + "/" + anio + "/" + mes + "/" + edicto.getCodigo() + "/DILIGENCIA";
		ruta = ruta.trim();
		return ruta;
	}
	
	private String generarRutaFirmaDiligencia(Edicto edicto) {
		return generarRutaDiligencia(edicto) + "/FIRMA";
	}
	
	private String generarRutaBorrador(Edicto edicto) {
		String codigoAyto = edicto.getOrganismo().getCodigo();
		SimpleDateFormat formateador = new SimpleDateFormat("YYYY", new Locale("es_ES"));
		String anio = formateador.format(edicto.getFechaRedaccion());
		String ruta = this.rutaAlmacenamientoBorrador + "/" + codigoAyto + "/EDICTOS/BORRADOR/" + anio;
		ruta = ruta.trim();
		return ruta;
	}
	
}
