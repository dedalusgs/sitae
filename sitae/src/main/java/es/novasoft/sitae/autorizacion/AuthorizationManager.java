/**
 * Autor: ggomez - Novasoft - Jaén (2011) 
 * Archivo: AuthoriztionManager.java
 * Creado: 17/06/2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.autorizacion;

import java.util.HashMap;
import java.util.Map;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.sitae.login.forms.LoginCertificadoForm;

/**
 * @author ggomez
 * 
 */
public class AuthorizationManager {

	private Map<String, Integer> authorizationRules = new HashMap<String, Integer>();

	public AuthorizationManager() {

	}

	/**
	 * Recupera de la request la url solicitada y de la sesion el usuario y sus
	 * permisos. Si tiene autorizacion para acceder a la url devuelve true.
	 * False en caso contrario.
	 * 
	 * @param request
	 * @return true si tiene autorizacion, false en caso contrario.
	 */
	public boolean isAuthorized(LoginCertificadoForm loginForm,
			String urlSolicitada) {
		boolean isAuthorized = false;

		Integer permisoNecesario = getPemisoNecesario(urlSolicitada);

		if (loginForm == null && permisoNecesario != null) {
			isAuthorized = false;
		} else {

			if (permisoNecesario != null) {
				switch (permisoNecesario) {
				case Constantes.ADMIN_GLOBAL:
					isAuthorized = loginForm.isAdministradorGlobal();
					break;

				case Constantes.ADMIN_LOCAL:
					isAuthorized = loginForm.isAdministradorLocal();
					break;

				case Constantes.PUBLICADOR:
					isAuthorized = loginForm.isAdministradorLocal()
							|| loginForm.isPublicador();
					break;

				case Constantes.REDACTOR:
					isAuthorized = loginForm.isRedactor();
					break;
				}
			} else { // No hay ninguna regla permitimos acceso
				isAuthorized = true;
			}

		}
		return isAuthorized;
	}

	/**
	 * @param urlSolicitada
	 * @return
	 */
	private Integer getPemisoNecesario(String urlSolicitada) {
		Integer permisoNecesario = null;

		for (String key : authorizationRules.keySet()) {
			if (urlSolicitada.matches(key)) {
				permisoNecesario = authorizationRules.get(key);
			}
		}

		return permisoNecesario;
	}

	/**
	 * @return the authorizationRules
	 */
	public Map<String, Integer> getAuthorizationRules() {
		return authorizationRules;
	}

	/**
	 * @param authorizationRules
	 *            the authorizationRules to set
	 */
	public void setAuthorizationRules(Map<String, Integer> authorizationRules) {
		this.authorizationRules = authorizationRules;
	}

}
