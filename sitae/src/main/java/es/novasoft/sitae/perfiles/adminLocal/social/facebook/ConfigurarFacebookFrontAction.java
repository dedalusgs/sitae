package es.novasoft.sitae.perfiles.adminLocal.social.facebook;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.FacebookService;
import es.novasoft.comun.socialservice.FacebookSession;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import facebook4j.Facebook;

public class ConfigurarFacebookFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			String cif = (String) request.getSession().getAttribute("cif");

			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			Organismo organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);

			FacebookService facebookService = (FacebookService) Factory.getBean(ServiceConstants.FACEBOOK_BEAN_NAME);

			HttpSession sesion = request.getSession();
			String token = (String) sesion.getAttribute("facebookToken");

			if (token != null) {
				sesion.setAttribute("facebookToken", null);

			}
			Facebook facebook = facebookService.getInstancia();

			String tokenRequest = new BigInteger(130, new SecureRandom()).toString(32);
			FacebookSession fbSession = new FacebookSession(tokenRequest, facebook, organismo);
			sesion.setAttribute("facebookToken", tokenRequest);
			facebookService.put(tokenRequest, fbSession);

			request.setAttribute("organismo", organismo);

			request.getSession().setAttribute("facebook", facebook);

			StringBuffer callbackURL = new StringBuffer(facebookService.getUrlCallback());

			callbackURL.append("CallBackFacebook.do?facebookToken=" + tokenRequest);

			request.setAttribute("urlFacebook", facebook.getOAuthAuthorizationURL(callbackURL.toString()));

		} catch (Exception e) {

			LOGGER.error("Error en VisualizarRedesFrontAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
