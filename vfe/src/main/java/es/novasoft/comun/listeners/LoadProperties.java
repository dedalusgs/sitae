package es.novasoft.comun.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.Config;

public class LoadProperties implements ServletContextListener {

	/**
	 * Objeto log de trazas
	 */
	private static Log log = LogFactory.getLog(LoadProperties.class);

	/**
	 * Inicializaci�n de par�metros en el contexto
	 * 
	 * @param evento
	 */
	public void contextInitialized(ServletContextEvent event) {

		try {
			ServletContext context = event.getServletContext();
			Config.appPath = context.getRealPath("");
			log.info("Path de la aplicaci�n: " + Config.appPath);

			Config.reload();
			Factory.setSc(context);

		} catch (Exception e) {
			log
					.error("Error obteniendo los ficheros de configuraci�n: "
							+ e, e);
		}
	}

	/**
	 * @param evento
	 */
	public void contextDestroyed(ServletContextEvent evento) {
	}

}