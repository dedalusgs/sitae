package es.novasoft.castellon.vfe.admin.organismo.modificarOrganismo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.actions.AltaOrganismoFrontAction;
import es.novasoft.castellon.vfe.admin.organismo.modificarOrganismo.forms.ModificarOrganismoForm;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;

public class ModificarOrganismoFrontAction extends ActionBase {

	private static final Logger LOGGER = Logger.getLogger(ModificarOrganismoFrontAction.class);
	
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		try {

			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver");
			 * }
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

			ModificarOrganismoForm formulario = (ModificarOrganismoForm) form;

			if (request.getAttribute("numeroErrores") == null) {

				Organismo organismo = new Organismo();

				String idOrganismo = (String) request
						.getParameter("idOrganismoSelecionado");

				if (idOrganismo != null && !idOrganismo.equals("")) {
					organismo = organismoService.findById(Integer
							.valueOf(idOrganismo));
				}

				formulario.setListaTemas(Organismo.rellenarTemas());
				formulario.setOpcion(organismo.getCodTema().toString());
				formulario.setOrganismo(organismo);
				request.getSession().setAttribute(
						"codigoModificarOrganismoForm",
						formulario.getOrganismo().getCodigo());
				request.getSession().setAttribute("listaTemas",
						formulario.getListaTemas());
				request.setAttribute("ModificarOrganismoForm", formulario);

			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ModificarOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
