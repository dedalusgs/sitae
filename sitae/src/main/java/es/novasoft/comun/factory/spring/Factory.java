package es.novasoft.comun.factory.spring;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Factory {

	private static ApplicationContext applicationContext = null;

	private static ServletContext servletContext = null;

	/**
	 * @param sc
	 *            The sc to set
	 */
	public static void setSc(ServletContext servletContext) {
		Factory.servletContext = servletContext;
	}

	/**
	 * 
	 * @param bean
	 * @return
	 */
	public static Object getBean(String bean) {
		if (applicationContext == null) {
			applicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
		}
		return applicationContext.getBean(bean);
	}
}