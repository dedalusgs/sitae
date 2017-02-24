package es.novasoft.sitae.perfiles.adminLocal.altaCentro.actions;

import java.io.InputStream;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.altaCentro.forms.AltaCentroForm;

public class AltaCentroDoAction extends ActionBase {
	
	private static Log	     log	          = LogFactory.getLog(AltaCentroDoAction.class);
	
	CentroProcedenciaService	centroService	= (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	InputStream	             solicitud	      = null;
	
	Timestamp	             fechaDoc	      = new Timestamp(System.currentTimeMillis());
	
	UsuarioAutentificado	 solicitante	  = null;
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		String forward = ActionBase.SUCCESS_KEY;
		
		// CODIGO QUE COMPRUBA EL CANCELAR
		if (isCancelled(request)) {
			// Elimina los forms anticuados
			ResetForm.removeBean(mapping, request);
			return forward(request, mapping, ActionBase.CANCEL_KEY);
		}
		
		try {
			
			AltaCentroForm formulario = (AltaCentroForm) form;
			
			if (isCancelled(request)) {
				return mapping.findForward("cancel");
			}
			
			// SE COMPRUEBA QUE SE HA ACCEDIDO DE MANERA CORRECTA
			/*
			 * Utils util = new Utils(); if (!util.usuarioAutenticado(request)){
			 * return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */
			
			String cif = (String) request.getSession().getAttribute("cif");
			
			request.setAttribute("AltaCentroForm", formulario);
			
			centroService.save(formulario.getCentro());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
			log.error("ERROR:" + ex.getMessage());
			log.error("TRAZA:", ex);
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {
			
			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
