package es.novasoft.sitae.perfiles.adminGlobal.visualizarOrganismos.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.visualizarOrganismos.forms.VisualizarOrganismoForm;

public class VisualizarOrganismoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			// Reseteamos el formulario si retrocedemos al listado
			if (request.getParameter("volver") != null) {
				ResetForm.removeBean(mapping, request);
			}

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver"); }
			 * 
			 * LOGGER.debug("INICIO DEL METODO"); //Información que se obtiene
			 * del certificado digital //Se comprueba que se ha accedido de
			 * manera correcta Utils util = new Utils(); if
			 * (!util.usuarioAutenticado(request)){ return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); } else{
			 * //Información que se obtiene del certificado digital ciudadano =
			 * obtenerUsuario(request);
			 * 
			 * if(ciudadano==null) return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			VisualizarOrganismoForm formulario = (VisualizarOrganismoForm) form;

			formulario = rellenaFormulario(formulario, ciudadano, request);

			request.setAttribute("VisualizarOrganismoForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarOrganismoForm rellenaFormulario(
			VisualizarOrganismoForm formulario, UsuarioAutentificado usuario,
			HttpServletRequest request) throws Exception {

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		List<Organismo> listaorganismos = organismoService.findAll();
		formulario.setNuevalistaOrganismos(listaorganismos);
		return formulario;

	}

}
