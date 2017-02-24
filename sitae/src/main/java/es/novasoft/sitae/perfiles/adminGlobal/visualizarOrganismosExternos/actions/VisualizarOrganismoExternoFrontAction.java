package es.novasoft.sitae.perfiles.adminGlobal.visualizarOrganismosExternos.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.perfiles.adminGlobal.visualizarOrganismosExternos.forms.VisualizarOrganismoExternoForm;

public class VisualizarOrganismoExternoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			VisualizarOrganismoExternoForm formulario = (VisualizarOrganismoExternoForm) form;
			formulario = rellenaFormulario(formulario, request);
			request.setAttribute("VisualizarOrganismoExternoForm", formulario);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarOrganismoExternoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarOrganismoExternoForm rellenaFormulario(
			VisualizarOrganismoExternoForm formulario,
			HttpServletRequest request) throws Exception {
		OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
				.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
		List<Organismo> listaorganismos = organismoExternoService.findAll();
		formulario.setNuevalistaOrganismos(listaorganismos);
		return formulario;

	}

}
