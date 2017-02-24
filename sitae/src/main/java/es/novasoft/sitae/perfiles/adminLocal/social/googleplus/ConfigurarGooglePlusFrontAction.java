package es.novasoft.sitae.perfiles.adminLocal.social.googleplus;

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
import es.novasoft.comun.socialservice.GooglePlusService;
import es.novasoft.comun.socialservice.GooglePlusSession;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class ConfigurarGooglePlusFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			GooglePlusService googlePlusService = (GooglePlusService) Factory.getBean(ServiceConstants.GOOGLEPLUS_BEAN_NAME);
			String cif = (String) request.getSession().getAttribute("cif");

			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			Organismo organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);
			HttpSession sesion = request.getSession();

			String state = (String) sesion.getAttribute("state");
			if (state != null) {
				sesion.setAttribute("state", null);
				GooglePlusSession googlePlusSession = googlePlusService.sacar(state);
				if (googlePlusSession.isUsuarioAprobado()) {
					return forward(request, mapping, ActionBase.SUCCESS_KEY_2);
				} else if (googlePlusSession.isSinValidar()) {

					return forward(request, mapping, ActionBase.ERROR_KEY);
				} else {
					request.setAttribute("errorGoogle", "noConcededido");
					return forward(request, mapping, ActionBase.ERROR_KEY);
				}

			} else {
				state = new BigInteger(130, new SecureRandom()).toString(32);
				GooglePlusSession google = new GooglePlusSession(state, organismo);
				sesion.setAttribute("state", state);
				googlePlusService.put(state, google);
			}

			request.setAttribute("idkey", googlePlusService.getConsumerKey());
			request.setAttribute("idkeySecret", googlePlusService.getConsumerSecret());
			request.setAttribute("idAplicacion", googlePlusService.getAppName());
			request.setAttribute("urlCallback", googlePlusService.getURLAutentication(state));
			return forward(request, mapping, ActionBase.SUCCESS_KEY);

		} catch (Exception e) {

			LOGGER.error("Error en VisualizarRedesFrontAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
	}

}
