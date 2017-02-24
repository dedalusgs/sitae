package es.novasoft.sitae.perfiles.adminLocal.social.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class VisualizarRedesFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			String cif = (String) request.getSession().getAttribute("cif");

			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			Organismo organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);
			request.setAttribute("organismo", organismo);
			request.setAttribute("state", null);
			request.setAttribute("twitterToken", null);

		} catch (Exception e) {

			LOGGER.error("Error en VisualizarRedesFrontAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
