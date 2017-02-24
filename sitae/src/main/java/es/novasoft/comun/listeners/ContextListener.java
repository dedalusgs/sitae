package es.novasoft.comun.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.Config;

public class ContextListener implements ServletContextListener {

	/**
	 * Objeto log de trazas
	 */
	private static Log log = LogFactory.getLog(ContextListener.class);

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Config.APP_PATH = arg0.getServletContext().getRealPath("");
			log.info("Path de la aplicación: " + Config.APP_PATH);
			Config.reload();
			ServletContext context = arg0.getServletContext();
			Factory.setSc(context);

		} catch (Exception e) {
			log
					.error("Error obteniendo los ficheros de configuración: "
							+ e, e);
		}

	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
