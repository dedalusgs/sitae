package es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionOrganismoExterno.actions;

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
import es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionOrganismoExterno.forms.MuestraInformacionOrganismoExternoForm;

public class MuestraInformacionOrganismoExternoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
					.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
			MuestraInformacionOrganismoExternoForm formulario = (MuestraInformacionOrganismoExternoForm) form;
			String id = (String) request.getParameter("idOrganismoSelecionado");
			OrganismoExterno organismoExterno = new OrganismoExterno();
			if (id != null && !id.equals("")) {
				organismoExterno = organismoExternoService.findById(Integer
						.valueOf(id));
			}
			formulario.setOrganismoExterno(organismoExterno);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionOrganismoExternoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
