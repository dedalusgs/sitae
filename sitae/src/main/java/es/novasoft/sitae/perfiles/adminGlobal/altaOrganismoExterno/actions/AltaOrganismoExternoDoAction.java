package es.novasoft.sitae.perfiles.adminGlobal.altaOrganismoExterno.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.perfiles.adminGlobal.altaOrganismoExterno.forms.AltaOrganismoExternoForm;

public class AltaOrganismoExternoDoAction extends ActionBase {

	private static Log log = LogFactory
			.getLog(AltaOrganismoExternoDoAction.class);

	OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
			.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String forward = ActionBase.SUCCESS_KEY;
		try {
			AltaOrganismoExternoForm formulario = (AltaOrganismoExternoForm) form;
			organismoExternoService.save(formulario.getOrganismoExterno());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("ERROR:" + ex.getMessage());
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {
			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
