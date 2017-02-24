/**
 * 
 */
package es.accv.fandango.test.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:jgutierrez@accv.es">José M Gutiérrez</a>
 * 
 */
public class FandangoLoginFilter implements Filter {

	private static boolean necesitaIdentificacion = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getServletPath();
		if ((httpRequest.getSession(false) == null || httpRequest.getSession()
				.getAttribute("login") == null)
				&& necesitaIdentificacion
				&& path.indexOf("login.jsp") == -1
				&& path.indexOf("respuestaLogin.jsp") == -1) {
			throw new ServletException("No se ha identificado en la aplicación");
		}

		chain.doFilter(request, response);
	}

	public static boolean isNecesitaIdentificacion() {
		return necesitaIdentificacion;
	}

	public static void setNecesitaIdentificacion(boolean necesitaIdentificacion) {
		FandangoLoginFilter.necesitaIdentificacion = necesitaIdentificacion;
	}

}
