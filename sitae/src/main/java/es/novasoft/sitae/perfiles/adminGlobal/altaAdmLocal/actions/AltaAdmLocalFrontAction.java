package es.novasoft.sitae.perfiles.adminGlobal.altaAdmLocal.actions;

import java.util.ArrayList;
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
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.altaAdmLocal.forms.AltaAdmLocalForm;

public class AltaAdmLocalFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			UsuarioAutentificado ciudadano = null;
			List<Organismo> listaOrganismo = new ArrayList();

			if (isCancelled(request)) {
				return mapping.findForward("Volver");
			}

			LOGGER.debug("INICIO DEL METODO");

			// Informaci�n que se obtiene del certificado digital
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

			AltaAdmLocalForm formulario = (AltaAdmLocalForm) form;

			String valida = (String) request.getAttribute("validaCampos");

			
			if (request.getAttribute("numeroErrores") == null && valida == null) {
				formulario.getUsuario().setNombre("");
				formulario.getUsuario().setApellido1("");
				formulario.getUsuario().setApellido2("");
				formulario.getUsuario().setMovil("");
				formulario.getUsuario().setTelefono("");
				formulario.getUsuario().setEmail("");
				formulario.setAdministradorGlobal(false);
				formulario.setOpcion("");
				formulario.setDesactivarCampos(true);
				listaOrganismo = organismoService.findAll();
				formulario.setListaOrganismos(listaOrganismo);

			}

			request.setAttribute("AltaOrganismoForm", formulario);
			request.getSession().setAttribute("listaOrganismos",
					formulario.getListaOrganismos());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en AltaOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
