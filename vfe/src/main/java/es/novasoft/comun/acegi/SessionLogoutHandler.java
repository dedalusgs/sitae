/**
 * Autor: fjroa - Novasoft - Jaén (2011) 
 * Archivo: SessionLogoutHandler.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.acegi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.concurrent.SessionRegistry;
import org.acegisecurity.ui.logout.LogoutHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class SessionLogoutHandler.
 */
public class SessionLogoutHandler implements LogoutHandler {

	/** The session registry. */
	private SessionRegistry sessionRegistry;

	/**
	 * Logout.
	 * 
	 * @param request
	 *            not used (can be <code>null</code>)
	 * @param response
	 *            not used (can be <code>null</code>)
	 * @param authentication
	 *            not used (can be <code>null</code>)
	 */
	public void logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		HttpSession session = request.getSession(false);
		if (session != null) {

			sessionRegistry.removeSessionInformation(session.getId());
			request.getSession().invalidate();
		}
	}

	/**
	 * Sets the session registry.
	 * 
	 * @param sessionRegistry
	 *            the new session registry
	 */
	public void setSessionRegistry(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

}
