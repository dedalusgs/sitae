/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: SessionManagerListener.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.listeners;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContext;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.utils.SessionExpirationFilter;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving sessionManager events. The class that is
 * interested in processing a sessionManager event implements this interface,
 * and the object created with that class is registered with a component using
 * the component's <code>addSessionManagerListener<code> method. When
 * the sessionManager event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see SessionManagerEvent
 */
public class SessionManagerListener implements HttpSessionListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent eventoDeSession) {

		HttpSession sesion = eventoDeSession.getSession();

		SecurityContext ctx = ((SecurityContext) sesion
				.getAttribute(Constantes.ACEGI_SECURITY_CONTEXT));

		if (ctx != null) {// Si estamos autenticados con acegi y por tanto en
			// la intranet

			Authentication authentication = ctx.getAuthentication();

			/*
			 * UsuariosLogueados filtro= new UsuariosLogueados ();
			 * filtro.setLogin(authentication.getName()); UsuariosLogueados
			 * usuariosLogueados= usuarioLogueadoService.getUserbyLogin(filtro);
			 * usuarioLogueadoService.deleteUser(usuariosLogueados);
			 */
			// Si la sesión ha expirado
			long inactive = (new Date().getTime() - sesion
					.getLastAccessedTime());
			long maxinactivemilis = sesion.getMaxInactiveInterval() * 1000;
			if (maxinactivemilis < inactive) {
				SessionExpirationFilter.addExpiredSessionId(sesion.getId(),
						authentication.getName());
			}
		}

		for (Object o : Collections.list(sesion.getAttributeNames())) {

			sesion.removeAttribute((String) o);

		}
	}

}