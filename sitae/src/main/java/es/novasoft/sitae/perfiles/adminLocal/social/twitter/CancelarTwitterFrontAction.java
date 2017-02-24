package es.novasoft.sitae.perfiles.adminLocal.social.twitter;

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
import es.novasoft.sitae.business.services.interfaz.RedSocialService;

public class CancelarTwitterFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cif = (String) request.getSession().getAttribute("cif");

		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RedSocialService redSocialService = (RedSocialService) Factory.getBean(ServiceConstants.REDSOCIAL_BEAN_NAME);
		Organismo organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);
		redSocialService.delete(organismo.getTwitter());
		organismo.setTwitter(null);
		organismoService.attachDirty(organismo);
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
