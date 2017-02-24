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
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismoExterno.forms.ModificarOrganismoExternoForm;

public class ModificarOrganismoExternoDoAction extends ActionBase {

	OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
			.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		OrganismoExterno organismoExterno = new OrganismoExterno();
		ModificarOrganismoExternoForm formulario = (ModificarOrganismoExternoForm) form;

		try {
			organismoExterno = formulario.getOrganismoExterno();
			organismoExternoService.attachDirty(organismoExterno);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarOrganismoExternoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
