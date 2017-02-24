package es.novasoft.sitae.perfiles.adminGlobal.altaOrganismo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.altaOrganismo.forms.AltaOrganismoForm;

public class AltaOrganismoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			if (isCancelled(request)) {
				return mapping.findForward("Volver");
			}

			LOGGER.debug("INICIO DEL METODO");

			// Información que se obtiene del certificado digital
			// SE COMPRUEBA QUE SE HA ACCEDIDO DE MANERA CORRECTA
			/*
			 * Utils util = new Utils(); if (!util.usuarioAutenticado(request)){
			 * return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 * else{ //INFORMACI�N QUE SE OBTIENE DEL CERTIFICADO DIGITAL
			 * ciudadano = obtenerUsuario(request);
			 * 
			 * if(ciudadano==null) return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			AltaOrganismoForm formulario = (AltaOrganismoForm) form;
			formulario.setListaTemas(RellenaFormularioActionUtil
					.rellenarTemas());
			request.setAttribute("AltaOrganismoForm", formulario);
			request.getSession().setAttribute("listaTemas",
					formulario.getListaTemas());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en AltaOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
