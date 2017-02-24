/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: SessionExpirationRedirectFilter.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.init.InitSession;

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
	private static final String sessionExpiredJSP = "/sesionExpirada.jsp";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession(false);

		Integer idOrganismo = null;
		String idOrg = (String) request.getParameter("idOrganismo");


		if (session == null ) {
			InitSession.doInit(httpRequest);
		} 
		
		chain.doFilter(request, response);
	}

	private Organismo getOrganismobyCodigo(String codOrganismo) {
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		Organismo organismo = null;
		try {

			List<Organismo> listOrganismo = organismoService
					.findByCodigo(codOrganismo);
			if (!listOrganismo.isEmpty()) {
				organismo = listOrganismo.get(0);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return organismo;
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
	private String getUrl(HttpServletRequest request)

	{

		if (request.getProtocol().startsWith("HTTP/") == true)

		{

			switch (request.getServerPort())

			{

			case HTTP_PORT:

				return "http://" + request.getServerName()
						+ request.getContextPath();

			default:

				return "http://" + request.getServerName()
				// + ":"
						// + request.getServerPort()
						+ request.getContextPath();

			}

		}

		else if (request.getProtocol().startsWith("HTTPS/") == true)

		{

			switch (request.getServerPort())

			{

			case HTTPS_PORT:

				return "https://" + request.getServerName()
						+ request.getContextPath();

			default:

				return "https://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath();

			}

		}
		return null;
	}
}