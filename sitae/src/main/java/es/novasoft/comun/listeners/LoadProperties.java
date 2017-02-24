package es.novasoft.comun.listeners;

import java.security.Security;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.Config;

public class LoadProperties implements ServletContextListener {
	
	/**
	 * Objeto log de trazas
	 */
	private static Log	log	= LogFactory.getLog(LoadProperties.class);
	
	/**
	 * Inicialización de parámetros en el contexto
	 * 
	 * @param evento
	 */
	public void contextInitialized(ServletContextEvent event) {
		
		try {
			// Cargar Provider en JDK
			BouncyCastleProvider provider = new BouncyCastleProvider();
			Security.addProvider(provider);
			ServletContext context = event.getServletContext();
			Config.APP_PATH = context.getRealPath("");
			log.info("Path de la aplicación: " + Config.APP_PATH);
			
			Config.reload();
			Factory.setSc(context);
		} catch (Exception e) {
			log.error("Error obteniendo los ficheros de configuración: " + e, e);
		}
	}
	
	/**
	 * @param evento
	 */
	public void contextDestroyed(ServletContextEvent evento) {
	}
	
}