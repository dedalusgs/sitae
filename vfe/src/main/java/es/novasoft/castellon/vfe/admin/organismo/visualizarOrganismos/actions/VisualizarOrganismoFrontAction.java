package es.novasoft.castellon.vfe.admin.organismo.visualizarOrganismos.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.muestraInformacionOrganismo.actions.MuestraInformacionOrganismoFrontAction;
import es.novasoft.castellon.vfe.admin.organismo.visualizarOrganismos.forms.VisualizarOrganismoForm;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;

public class VisualizarOrganismoFrontAction extends ActionBase {

	private static final Logger LOGGER = Logger.getLogger(VisualizarOrganismoFrontAction.class);
	
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			String nif=(String)request.getSession().getAttribute("nif");
			if (nif==null || nif.equalsIgnoreCase(""))	 
				return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
			// Reseteamos el formulario si retrocedemos al listado
			if (request.getParameter("volver") != null) {
				ResetForm.removeBean(mapping, request);
			}

			VisualizarOrganismoForm formulario = rellenaFormulario(
					(VisualizarOrganismoForm) form, request);

			request.setAttribute("VisualizarOrganismoForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarOrganismoForm rellenaFormulario(
			VisualizarOrganismoForm formulario, HttpServletRequest request)
			throws Exception {

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		List<Organismo> listaorganismos = organismoService.findAll();
		formulario.setNuevalistaOrganismos(listaorganismos);
		return formulario;

	}

}
