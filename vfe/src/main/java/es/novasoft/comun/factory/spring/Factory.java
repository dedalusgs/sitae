/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: Factory.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.factory.spring;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Factory.
 */
public class Factory {

	/** The application context. */
	private static ApplicationContext applicationContext = null;

	/** The servlet context. */
	private static ServletContext servletContext = null;

	/**
	 * Sets the sc.
	 * 
	 * @param servletContext
	 *            the new sc
	 */
	public static void setSc(ServletContext servletContext) {
		Factory.servletContext = servletContext;
	}

	/**
	 * Gets the bean.
	 * 
	 * @param bean
	 *            the bean
	 * @return the bean
	 */
	public static Object getBean(String bean) {
		if (applicationContext == null) {
			applicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
		}
		return applicationContext.getBean(bean);
	}
}