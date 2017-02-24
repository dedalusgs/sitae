package es.novasoft.sitae.perfiles.adminGlobal.bajaOrganismoExterno.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;

public class BajaOrganismoExternoDoAction extends ActionBase {

	OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
			.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		OrganismoExterno organismoExterno = new OrganismoExterno();

		try {

			String idOrganismo = (String) request
					.getParameter("idOrganismoSelecionado");

			if (idOrganismo != null && !idOrganismo.equals("")) {

				organismoExterno = organismoExternoService.findById(Integer
						.valueOf(idOrganismo));

				String cif = organismoExterno.getCif();
				List listaEdictos = edictoService
						.findByIdOrganismoExterno(organismoExterno.getIdOrg());
				if (listaEdictos.isEmpty()) {
					organismoExternoService.delete(organismoExterno);
				} else {
					return forward(request, mapping, ActionBase.ERROR_KEY_2);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaOrganismoExternoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
