/**
 * Autor: ggomez - Novasoft - Jaén (2011) 
 * Archivo: AuthorizationFilter.java
 * Creado: 17/06/2011
 * Version: 1.0
 */
package es.novasoft.sitae.autorizacion;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.login.forms.LoginCertificadoForm;

/**
 * @author ggomez
 * 
 *         Filtra las urls según los permisos.
 */
public class AuthorizationFilter implements Filter {
	private FilterConfig filterConfig = null;
	private AuthorizationManager authorizationManager = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (this.filterConfig == null) {
			return;
		}
		
		if(request instanceof HttpServletRequest){
		    HttpServletRequest httpRequest = (HttpServletRequest) request;
		    LoginCertificadoForm loginForm = (LoginCertificadoForm) httpRequest.getSession().getAttribute("LoginCertificadoForm");
			String urlSolicitada = httpRequest.getRequestURL().toString();
			
				
			if (!authorizationManager.isAuthorized(loginForm,urlSolicitada)) {
				((HttpServletResponse) response)
						.sendRedirect(this.filterConfig
								.getInitParameter(AuthorizationConstants.FILTER_PARAM_URL_NO_AUTH));
				return;
			}
		}

		chain.doFilter(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		this.authorizationManager = (AuthorizationManager) Factory.getBean("AuthorizationManager");

	}

}
