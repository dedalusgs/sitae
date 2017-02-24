package es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismoExterno.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismoExterno.forms.ModificarOrganismoExternoForm;

public class ModificarOrganismoExternoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
					.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
			ModificarOrganismoExternoForm formulario = (ModificarOrganismoExternoForm) form;
			if (request.getAttribute("numeroErrores") == null) {

				OrganismoExterno organismoExterno = new OrganismoExterno();

				String idOrganismo = (String) request
						.getParameter("idOrganismoSelecionado");

				if (idOrganismo != null && !idOrganismo.equals("")) {
					organismoExterno = organismoExternoService.findById(Integer
							.valueOf(idOrganismo));
				}

				formulario.setOrganismoExterno(organismoExterno);
				request.getSession().setAttribute("CIF",
						formulario.getOrganismoExterno().getCif());
				request.setAttribute("ModificarOrganismoExternoForm",
						formulario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ModificarOrganismoExternoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
