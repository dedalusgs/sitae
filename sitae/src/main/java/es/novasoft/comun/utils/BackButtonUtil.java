package es.novasoft.comun.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

public class BackButtonUtil {

	public static void setPathAnterior(ActionMapping mapping,
			HttpServletRequest request) {
		String path_anterior = mapping.getPath()+".do?reload=true";
		String queryString = request.getQueryString();
		if (queryString != null) {
			path_anterior += "&"+queryString;
		}
		request.getSession().setAttribute("pathAnterior",path_anterior);
	}
}
