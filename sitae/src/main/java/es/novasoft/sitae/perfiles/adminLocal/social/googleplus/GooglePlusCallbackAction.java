package es.novasoft.sitae.perfiles.adminLocal.social.googleplus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.model.Person;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.GooglePlusService;
import es.novasoft.comun.socialservice.GooglePlusSession;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RedSocial;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RedSocialService;

public class GooglePlusCallbackAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession sesion = request.getSession();
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RedSocialService redSocialService = (RedSocialService) Factory.getBean(ServiceConstants.REDSOCIAL_BEAN_NAME);
		GooglePlusService googlePlusService = (GooglePlusService) Factory.getBean(ServiceConstants.GOOGLEPLUS_BEAN_NAME);
		String state = request.getParameter("state");
		GooglePlusSession googleSession = googlePlusService.obtener(state);

		Organismo organismo = googleSession.getOrganismo();

		String code = request.getParameter("code");

		if (code != null && !code.equals("")) {

			try {
				GoogleTokenResponse tokenResponse = googlePlusService.getGoogleTokenResponse(code);
				Plus plusService = googlePlusService.getPlusService(tokenResponse.toString());
				String refreshToken = tokenResponse.getRefreshToken();
				GoogleIdToken idToken = tokenResponse.parseIdToken();
				String gplusId = idToken.getPayload().getSubject();

				RedSocial usuario = new RedSocial();
				usuario.setTokenCuenta(refreshToken);
				usuario.setIdCuenta(gplusId);
				Person person = plusService.people().get(gplusId).execute();
				usuario.setNombre(person.getDisplayName());
				usuario.setTipo(RedSocial.TIPO_GOOGLE);
				usuario.setUrlImgUser(person.getImage().getUrl());
				usuario.setUrlUser(person.getUrl());
				googleSession.setUsuarioAprobado();
				redSocialService.attachDirty(usuario);
				if (organismo.getGoogle() != null) {
					redSocialService.delete(organismo.getGoogle());
				}
				organismo.setGoogle(usuario);
				organismoService.attachDirty(organismo);

				return forward(request, mapping, ActionBase.SUCCESS_KEY);

			} catch (Exception e) {
				log.error(e);

				return forward(request, mapping, ActionBase.SUCCESS_KEY);
			}
		} else {
			googleSession.setUsuarioNoAprobado();

			return forward(request, mapping, ActionBase.SUCCESS_KEY);

		}

	}
}
