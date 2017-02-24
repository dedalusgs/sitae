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
 * FECHA: "Fecha de la modificación"
 * AUTOR: "Autor de la modificación"
 * VERSION ACTUAL: "Versión en la que se encuentra el archivo"
 * VERSION MODIFICADA: "Versión que se está modificando"
 * RAZON: "Referencia a incidencia que ha provocado la modificación"
 * DESCRIPCION: "Detalle de la/s modificación/es realizadas"
 * ======================================================================
 */
/**
 * Archivo: Config.java <br>
 * Descripción: Clase utilizada para leer el/los fichero/s de configuración de
 * una aplicación. <br>
 * Copyright: Copyright, 22-10-2007 <br>
 * Compañía: Novasoft
 * 
 * @author Pedro Villatoro
 * @version 1.0
 */
public class Config {

	/**
	 * Objeto log de trazas
	 */
	private static Log log = LogFactory.getLog(Config.class);

	/**
	 * El objeto de Jakarta Common Configuration
	 */
	protected static Configuration config = null;

	// PARAMETROS PARA LOS FICHEROS DE CONFIGURACIÓN.

	/**
	 * Path de la aplicación. Es null y será cargada por el listener al arrancar
	 * cogiendo el path del servidor.
	 */
	public static String APP_PATH = null;

	/**
	 * Carpeta de la aplicación web donde se encuentran los ficheros de
	 * configuración.
	 */
	public static final String CARPETA_CONFIG = "/WEB-INF/classes/resources/application";

	/**
	 * Carpeta de la aplicación web donde se encuentran los ficheros de envio de
	 * mails configuración.
	 */
	public static final String CARPETA_MAIL = "/WEB-INF/classes/resources/mail";

	/**
	 * Carpeta de la aplicación web donde se encuentran el ficheros con los
	 * textos preformateados de contenidosStand
	 */
	public static final String CARPETA_DDESCRIPTIVOS = "/WEB-INF/classes/resources/textosDatosDescriptivosDefault";

	/**
	 * Datos de acceso a mysql
	 */
	public static final String CARPETA_MYSQL = "/WEB-INF/classes/resources/mysql";

	/**
	 * Recarga los parámetros de los ficheros de configuración de la aplicación
	 * 
	 * @throws Exception
	 */
	public static synchronized void reload() throws Exception {

		try {
			CompositeConfiguration compConfig = new CompositeConfiguration();

			/*
			 * 1.- Obtiene la ruta de los ficheros de configuración y todos los
			 * ficheros de configuración que hay en la misma.
			 */
			String path = getEnvConfigPath();
			log.info("path real: " + path);
			List list = getListFilesConfig(path);

			// 2.- Añade todos los parámetros de los ficheros de configuración
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
			// Se añade el appPath para que se pueda acceder como a cualquier
			// parámetro.
			config.addProperty("appPath", APP_PATH);
			if (log.isInfoEnabled()) {
				log.info("Parámetros de configuración: ");
				for (Iterator it = config.getKeys(); it.hasNext();) {
					String key = (String) it.next();
					log.info(key + "=" + config.getString(key));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Excepción al recargar la configuración: " + e, e);
			throw e;
		}
	}

	/**
	 * Método que lee la ruta donde se encuentran los ficheros de configuración.
	 * 
	 * @return Un String con la ruta donde están los ficheros de configuración.
	 */
	protected static String getEnvConfigPath() {
		log.debug("Iniciando método.");
		StringBuffer strBuffer = new StringBuffer();

		log.info("Genera el path de los ficheros de configuración");
		strBuffer.append(APP_PATH);
		strBuffer.append(CARPETA_CONFIG);
		log.info("strBuffer=" + strBuffer.toString());
		log.info("Finalizando método.");

		// Devuelve el path del lugar donde se encuentran los ficheros de
		// configuración.

		return strBuffer.toString();
	}

	/**
	 * @param path
	 *            Localización de los ficheros de configuración
	 * @return Una lista con el nombre de los ficheros XML y properties del path
	 *         en minúscula
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
			log.warn("La ruta del fichero de configuración es null o "
					+ "no es un directorio");
		}
		for (int i = 0; (filesConfig != null) && (i < filesConfig.length); i++) {
			if (filesConfig[i].toLowerCase().endsWith(Constantes.EXTENSION_XML)
					|| filesConfig[i].toLowerCase().endsWith(
							Constantes.EXTENSION_PROPERTIES)) {
				list.add(filesConfig[i]);
				log.info("Añadiendo fichero=" + filesConfig[i].toLowerCase());
			}
		}
		log.info("Finalizando método.");
		return list;
	}

	/**
	 * @param param
	 *            Parámetro del que se quiere conocer su valor
	 * @return El valor del parámetro solicitado
	 */
	public static String get(String param) {
		return config.getProperty(param).toString();
	}

	/**
	 * @param Nombre
	 *            del parámetro del cual se quiere conocer sus valores
	 * @return Una lista con los valores que coinciden con el nombre del
	 *         parámetro
	 */
	public static List getAll(String param) {
		return config.getList(param);
	}
}
