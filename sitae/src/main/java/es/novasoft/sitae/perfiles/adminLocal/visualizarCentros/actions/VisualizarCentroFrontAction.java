package es.novasoft.sitae.perfiles.adminLocal.visualizarCentros.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.visualizarCentros.forms.VisualizarCentroForm;

public class VisualizarCentroFrontAction extends ActionBase {
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			UsuarioAutentificado ciudadano = null;
			
			// Reseteamos el formulario si retrocedemos al listado
			if (request.getParameter("volver") != null) {
				ResetForm.removeBean(mapping, request);
			}
			
			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver");
			 * } LOGGER.debug("INICIO DEL METODO"); //Información que se
			 * obtiene del certificado digital //Se comprueba que se ha accedido
			 * de manera correcta Utils util = new Utils(); if
			 * (!util.usuarioAutenticado(request)){ return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); } else{
			 * //Información que se obtiene del certificado digital ciudadano =
			 * obtenerUsuario(request); if(ciudadano==null) return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */
			
			VisualizarCentroForm formulario = (VisualizarCentroForm) form;
			
			formulario = rellenaFormulario(formulario, ciudadano, request);
			
			request.setAttribute("VisualizarCentroForm", formulario);
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
	
	public VisualizarCentroForm rellenaFormulario(VisualizarCentroForm formulario, UsuarioAutentificado usuario, HttpServletRequest request) throws Exception {
		
		// RELLENAMOS EL FORMULARIO CON EL LISTADO DE CENTROS
		String cif = (String) request.getSession().getAttribute("cif");
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		
		CentroProcedenciaService centroService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		
		Organismo organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);
		// List<CentroProcedencia> listacentros =
		// centroService.findByIdOrg(organismo.getIdOrg());
		List<CentroProcedencia> listacentros = centroService.findAll();
		formulario.setNuevalistaCentros(listacentros);
		
		return formulario;
		
	}
	
}
