/**
 * Autor: fjroa - Novasoft - Jaén (2011) 
 * Archivo: CaptchaAuthenticationProcessingFilter.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.acegi;

import javax.servlet.http.HttpServletRequest;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationServiceException;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class CaptchaAuthenticationProcessingFilter.
 */
public class CaptchaAuthenticationProcessingFilter extends
		AuthenticationProcessingFilter {

	/** The Constant CAPTCHA_KEY. */
	public static final String CAPTCHA_KEY = "j_captcha";

	/**
	 * Perform captcha authentication using {@link SimpleCaptcha}.
	 * 
	 * @param request
	 *            the request
	 * @return the authentication
	 * @throws AuthenticationException
	 *             the authentication exception
	 */

	public Authentication attemptAuthentication(HttpServletRequest request)
			throws AuthenticationException {

		if (request.getSession() != null
				&& (Integer) request.getSession().getAttribute(
						"contadorErrores") != null) {

			Integer contadorErrores = (Integer) request.getSession()
					.getAttribute("contadorErrores");

			if (contadorErrores >= 2) {
				/* La stringa generata da CAPTCHA */
				// String captchaText = (String) request.getSession()
				// .getAttribute(Constants.SIMPLE_CAPCHA_SESSION_KEY);
				// if (captchaText != null) {
				// if (!captchaText.equals(captcha)) {
				// throw new AuthenticationServiceException(
				// "error captcha");
				// }
			} else {
				throw new AuthenticationServiceException("error captcha");
			}
			// }
		}

		return super.attemptAuthentication(request);
	}

}