package es.novasoft.comun.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;

/*
 * Copyright Novasoft. Todos los derechos reservados.
 */
/*
 * ======================================================================
 * Historial de modificaciones:
 * ......................................................................
 * FECHA: "Fecha de la modificaci�n"
 * AUTOR: "Autor de la modificaci�n"
 * VERSION ACTUAL: "Versi�n en la que se encuentra el archivo"
 * VERSION MODIFICADA: "Versi�n que se est� modificando"
 * RAZON: "Referencia a incidencia que ha provocado la modificaci�n"
 * DESCRIPCION: "Detalle de la/s modificaci�n/es realizadas"
 * ======================================================================
 */
/**
 * Archivo: Config.java <br>
 * Descripci�n: Clase utilizada para leer el/los fichero/s de configuraci�n de
 * una aplicaci�n. <br>
 * Copyright: Copyright, 22-10-2007 <br>
 * Compa��a: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */
public class Config {

	/** Objeto log de trazas. */
	private static Log log = LogFactory.getLog(Config.class);

	/**
	 * El objeto de Jakarta Common Configuration
	 */
	protected static Configuration config = null;

	// PARAMETROS PARA LOS FICHEROS DE CONFIGURACI�N.

	/**
	 * Path de la aplicaci�n. Es null y ser� cargada por el listener al arrancar
	 * cogiendo el path del servidor.
	 */
	public static String appPath = null;

	/**
	 * Carpeta de la aplicaci�n web donde se encuentran los ficheros de
	 * configuraci�n.
	 */
	public static final String CARPETA_CONFIG = "/WEB-INF/classes/resources/application";

	/**
	 * Carpeta de la aplicaci�n web donde se encuentran los ficheros de envio de
	 * mails configuraci�n.
	 */
	public static final String CARPETA_MAIL = "/WEB-INF/classes/resources/mail";

	/**
	 * Carpeta de la aplicaci�n web donde se encuentran el ficheros con los
	 * textos preformateados de contenidosStand
	 */
	public static final String CARPETA_DDESCRIPTIVOS = "/WEB-INF/classes/resources/textosDatosDescriptivosDefault";

	/**
	 * Datos de acceso a mysql
	 */
	public static final String CARPETA_MYSQL = "/WEB-INF/classes/resources/mysql";

	/**
	 * Recarga los par�metros de los ficheros de configuraci�n de la aplicaci�n
	 * 
	 * @throws Exception
	 */
	public static synchronized void reload() throws Exception {

		try {
			CompositeConfiguration compConfig = new CompositeConfiguration();

			/*
			 * 1.- Obtiene la ruta de los ficheros de configuraci�n y todos los
			 * ficheros de configuraci�n que hay en la misma.
			 */
			String path = getEnvConfigPath();
			log.info("path real: " + path);
			List list = getListFilesConfig(path);

			// 2.- A�ade todos los par�metros de los ficheros de configuraci�n
			for (int i = 0; i < list.size(); i++) {
				String fileName = (String) list.get(i);

				if (fileName.endsWith(Constantes.EXTENSION_PROPERTIES)) {
					PropertiesConfiguration conf = new PropertiesConfiguration();
					conf.setBasePath(path);
					conf.load(fileName);
					compConfig.addConfiguration(conf);
				} else if (fileName.endsWith(Constantes.EXTENSION_XML)) {
					XMLConfiguration conf = new XMLConfiguration();
					conf.setBasePath(path);
					conf.load(fileName);
					compConfig.addConfiguration(conf);
				}
			}

			config = compConfig;
			// Se a�ade el appPath para que se pueda acceder como a cualquier
			// par�metro.
			config.addProperty("appPath", appPath);
			if (log.isInfoEnabled()) {
				log.info("Par�metros de configuraci�n: ");
				for (Iterator it = config.getKeys(); it.hasNext();) {
					String key = (String) it.next();
					log.info(key + "=" + config.getString(key));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Excepci�n al recargar la configuraci�n: " + e, e);
			throw e;
		}
	}

	/**
	 * M�todo que lee la ruta donde se encuentran los ficheros de configuraci�n.
	 * 
	 * @return Un String con la ruta donde est�n los ficheros de configuraci�n.
	 */
	protected static String getEnvConfigPath() {
		log.debug("Iniciando m�todo.");
		StringBuffer strBuffer = new StringBuffer();

		log.info("Genera el path de los ficheros de configuraci�n");
		strBuffer.append(appPath);
		strBuffer.append(CARPETA_CONFIG);
		log.info("strBuffer=" + strBuffer.toString());
		log.info("Finalizando m�todo.");

		// Devuelve el path del lugar donde se encuentran los ficheros de
		// configuraci�n.

		return strBuffer.toString();
	}

	/**
	 * @param path
	 *            Localizaci�n de los ficheros de configuraci�n
	 * @return Una lista con el nombre de los ficheros XML y properties del path
	 *         en min�scula
	 */
	private static List getListFilesConfig(String path) {

		List<String> list = new ArrayList<String>();
		File file = new File(path);
		String[] filesConfig = null;
		log.info("file=" + file);
		log.info("file.isDirectory()= " + file.isDirectory());
		if (file != null && file.isDirectory()) {
			filesConfig = file.list();
		} else {
			log.warn("La ruta del fichero de configuraci�n es null o "
					+ "no es un directorio");
		}
		for (int i = 0; (filesConfig != null) && (i < filesConfig.length); i++) {
			if (filesConfig[i].toLowerCase().endsWith(Constantes.EXTENSION_XML)
					|| filesConfig[i].toLowerCase().endsWith(
							Constantes.EXTENSION_PROPERTIES)) {
				list.add(filesConfig[i]);
				log.info("A�adiendo fichero=" + filesConfig[i].toLowerCase());
			}
		}
		log.info("Finalizando m�todo.");
		return list;
	}

	/**
	 * @param param
	 *            Par�metro del que se quiere conocer su valor
	 * @return El valor del par�metro solicitado
	 */
	public static String get(String param) {
		return config.getProperty(param).toString();
	}

	/**
	 * @param Nombre
	 *            del par�metro del cual se quiere conocer sus valores
	 * @return Una lista con los valores que coinciden con el nombre del
	 *         par�metro
	 */
	public static List getAll(String param) {
		return config.getList(param);
	}
}
