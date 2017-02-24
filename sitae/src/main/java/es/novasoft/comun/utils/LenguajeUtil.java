package es.novasoft.comun.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;

public class LenguajeUtil {

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
