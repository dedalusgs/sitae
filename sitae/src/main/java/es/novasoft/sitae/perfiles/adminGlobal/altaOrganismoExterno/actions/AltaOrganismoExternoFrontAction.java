package es.novasoft.sitae.perfiles.adminGlobal.altaOrganismoExterno.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.perfiles.adminGlobal.altaOrganismoExterno.forms.AltaOrganismoExternoForm;

public class AltaOrganismoExternoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			AltaOrganismoExternoForm formulario = (AltaOrganismoExternoForm) form;
			request.setAttribute("AltaOrganismoExternoForm", formulario);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en AltaOrganismoExternoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
