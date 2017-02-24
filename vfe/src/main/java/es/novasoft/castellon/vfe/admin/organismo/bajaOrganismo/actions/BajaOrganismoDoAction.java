package es.novasoft.castellon.vfe.admin.organismo.bajaOrganismo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;

public class BajaOrganismoDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		try {
			String idOrganismo = (String) request
					.getParameter("idOrganismoSelecionado");

			if (idOrganismo != null && !idOrganismo.equals("")) {
				organismoService.delete(organismoService.findById(Integer
						.valueOf(idOrganismo)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaOrganismoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
