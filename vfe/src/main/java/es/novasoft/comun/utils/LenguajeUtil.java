/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: LenguajeUtil.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;

// TODO: Auto-generated Javadoc
/**
 * The Class LenguajeUtil.
 */
public class LenguajeUtil {

	/**
	 * Gets the mensaje.
	 * 
	 * @param request
	 *            the request
	 * @param propiedad
	 *            the propiedad
	 * @return the mensaje
	 */
	public static String getMensaje(HttpServletRequest request, String propiedad) {
		ResourceBundle res = ResourceBundle.getBundle("ApplicationResources",
				(Locale) request.getSession().getAttribute(Globals.LOCALE_KEY));
		String value = null;
		if (propiedad != null) {
			value = res.getString(propiedad);
		}
		return value;
	}

}
