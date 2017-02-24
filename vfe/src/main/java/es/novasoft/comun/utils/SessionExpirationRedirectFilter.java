/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: SessionExpirationRedirectFilter.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.novasoft.castellon.vfe.init.InitSession;

// TODO: Auto-generated Javadoc
/**
 * The Class SessionExpirationRedirectFilter.
 */
public class SessionExpirationRedirectFilter implements Filter {

	/** The Constant HTTP_PORT. */
	private static final int HTTP_PORT = 80;

	/** The Constant HTTPS_PORT. */
	private static final int HTTPS_PORT = 443;

	/** The Constant sessionExpiredJSP. */
	private static final String SESSION_EXPIRED_JSP = "/sesionExpirada.jsp";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		if (session == null) {
			InitSession.doInit(httpRequest);
		}

		chain.doFilter(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * Gets the url.
	 * 
	 * @param request
	 *            the request
	 * @return the url
	 */
	private String getUrl(HttpServletRequest request) {
		String urlRet = null;
		if (request.getProtocol().startsWith("HTTP/")) {
			if (request.getServerPort() == HTTP_PORT) {
				urlRet = "http://" + request.getServerName()
						+ request.getContextPath();
			} else {

				urlRet = "http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath();
			}
		}

		else if (request.getProtocol().startsWith("HTTPS/")) {
			if (request.getServerPort() == HTTPS_PORT) {
				urlRet = "https://" + request.getServerName()
						+ request.getContextPath();
			} else {
				urlRet = "https://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath();
			}

		}
		return urlRet;
	}

}