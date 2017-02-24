package es.novasoft.sitae.perfiles.adminLocal.social.twitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.TwitterService;
import es.novasoft.comun.socialservice.TwitterSession;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RedSocial;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RedSocialService;

public class TwitterCallbackAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cif = (String) request.getSession().getAttribute("cif");
		HttpSession sesion = request.getSession();
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RedSocialService redSocialService = (RedSocialService) Factory.getBean(ServiceConstants.REDSOCIAL_BEAN_NAME);
		TwitterService twitterService = (TwitterService) Factory.getBean(ServiceConstants.TWITTER_BEAN_NAME);
		Organismo organismo = null;
		String pin = request.getParameter("oauth_verifier");
		String ouathtoken = request.getParameter("oauth_token");

		TwitterSession twitterSession = twitterService.obtener(ouathtoken);
		Twitter twitter = null;
		if (twitterSession != null) {
			twitter = twitterSession.getTwitter();
			organismo = twitterSession.getOrganismo();
		}

		if (twitter != null && pin != null && !pin.equals("")) {

			try {

				AccessToken token = twitter.getOAuthAccessToken(pin);

				RedSocial usuario = new RedSocial();
				usuario.setTokenCuenta(token.getTokenSecret());
				usuario.setIdCuenta(token.getToken());

				usuario.setNombre(twitter.verifyCredentials().getName());
				usuario.setTipo(RedSocial.TIPO_TWITTER);
				usuario.setUrlImgUser(twitter.verifyCredentials().getProfileImageURL());
				usuario.setUrlUser(twitter.verifyCredentials().getScreenName());
				twitterSession.setUsuarioAprobado();
				redSocialService.attachDirty(usuario);
				if (organismo.getTwitter() != null) {
					redSocialService.delete(organismo.getTwitter());
				}
				organismo.setTwitter(usuario);
				organismoService.attachDirty(organismo);
				sesion.setAttribute("twitterOk", "correcto");

				return forward(request, mapping, ActionBase.SUCCESS_KEY);

			} catch (TwitterException e) {
				log.error(e);
				sesion.setAttribute("twitterOk", "error");
				twitterSession.setUsuarioNoAprobado();
				return forward(request, mapping, ActionBase.SUCCESS_KEY);
			}
		} else {
			String denegado = request.getParameter("denied");
			twitterSession = twitterService.obtener(denegado);
			twitterSession.setUsuarioNoAprobado();
			sesion.setAttribute("twitterOk", "error");
			return forward(request, mapping, ActionBase.SUCCESS_KEY);
		}

	}
}
