package es.novasoft.sitae.perfiles.adminLocal.social.twitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import twitter4j.Twitter;
import twitter4j.auth.RequestToken;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.TwitterService;
import es.novasoft.comun.socialservice.TwitterSession;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class ConfigurarTwitterFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			TwitterService twitterService = (TwitterService) Factory.getBean(ServiceConstants.TWITTER_BEAN_NAME);
			String cif = (String) request.getSession().getAttribute("cif");

			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			Organismo organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);
			HttpSession sesion = request.getSession();

			String token = (String) sesion.getAttribute("twitterToken");

			if (token != null) {
				sesion.setAttribute("twitterToken", null);
				TwitterSession twitterSession = twitterService.sacar(token);
				if (twitterSession.isUsuarioAprobado()) {
					return forward(request, mapping, ActionBase.SUCCESS_KEY_2);
				} else {
					request.setAttribute("twitterConfigurado", "noConcededido");
					return forward(request, mapping, ActionBase.ERROR_KEY);
				}
			}

			Twitter twitter = twitterService.getInstancia();
			RequestToken requestToken = twitter.getOAuthRequestToken();
			String tokenRequest = requestToken.getToken();
			TwitterSession twSession = new TwitterSession(token, twitter, organismo);
			sesion.setAttribute("twitterToken", tokenRequest);
			twitterService.put(tokenRequest, twSession);

			request.setAttribute("urlTwitter", requestToken.getAuthorizationURL());

		} catch (Exception e) {

			LOGGER.error("Error en ConfiguraTwitter", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
