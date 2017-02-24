package es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismo.forms.ModificarOrganismoForm;

public class ModificarOrganismoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			UsuarioAutentificado ciudadano = null;

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

			ModificarOrganismoForm formulario = (ModificarOrganismoForm) form;

			if (request.getAttribute("numeroErrores") == null) {

				Organismo organismo = new Organismo();

				String idOrganismo = (String) request
						.getParameter("idOrganismoSelecionado");

				if (idOrganismo != null && !idOrganismo.equals("")) {
					organismo = organismoService.findById(Integer
							.valueOf(idOrganismo));
				}

				formulario.setListaTemas(RellenaFormularioActionUtil
						.rellenarTemas());
				formulario.setOpcion(organismo.getTema().toString());
				formulario.setOrganismo(organismo);
				request.getSession().setAttribute("CIF",
						formulario.getOrganismo().getCif());
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
