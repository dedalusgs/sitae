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

public class SessionManagerListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

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