package es.novasoft.sitae.perfiles.adminLocal.crearUsuarios.actions;

import java.util.ArrayList;
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
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.crearUsuarios.forms.CrearUsuariosForm;

public class CrearUsuariosFrontAction extends ActionBase {
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			UsuarioAutentificado ciudadano = null;
			List<Organismo> listaOrganismo = new ArrayList();
			
			CrearUsuariosForm formulario = (CrearUsuariosForm) form;
			
			if (request.getAttribute("numeroErrores") == null) {
				rellenaFormulario(formulario, ciudadano, request);
				String recargaPerfil = (String) request.getParameter("recarga");
				String valida = (String) request.getAttribute("validaCampos");
				
				if (recargaPerfil == null && valida == null) {
					formulario.getUsuarioExterno().setPassword("");
					formulario.getUsuarioExterno().setUsu("");
					formulario.getUsuario().setNombre("");
					formulario.getUsuario().setApellido1("");
					formulario.getUsuario().setApellido2("");
					formulario.getUsuario().setEmail("");
					formulario.getUsuario().setMovil("");
					formulario.getUsuario().setTelefono("");
					formulario.getUsuario().setNumDocumento("");
					formulario.setOpcionPerfil(new Integer("1"));
					formulario.setOpcionCentro(new Integer("-1"));
					formulario.setDesactivarCampos(true);
				}
			}
			
			request.getSession().setAttribute("listaCentros", formulario.getListaCentros());
			request.getSession().setAttribute("listaPerfil", formulario.getListaPerfil());
			request.setAttribute("CrearUsuariosForm", formulario);
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en CrearUsuariosFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
		
	}
	
	public CrearUsuariosForm rellenaFormulario(CrearUsuariosForm formulario, UsuarioAutentificado usuario, HttpServletRequest request) throws Exception {
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		PerfilService perfilService = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		
		String cif = (String) request.getSession().getAttribute("cif");
		formulario.setCif(cif);
		
		Organismo organismo = (Organismo) organismoService.findByCif(cif).get(0);
		Perfil perfRedactor = perfilService.findById(Constantes.REDACTOR);
		Perfil perfPublicador = perfilService.findById(Constantes.PUBLICADOR);
		
		String recargaPerfil = (String) request.getParameter("recarga");
		
		if (recargaPerfil == null) {
			formulario.setDesactivarCampos(false);
		}
		
		if (recargaPerfil != null && recargaPerfil.equalsIgnoreCase("si")) {
			
			if (formulario.getOpcionPerfil().equals(Constantes.PUBLICADOR)) {
				
				// List listaCentros =
				// centroProcedenciaService.findByIdOrg(organismo.getIdOrg());
				List listaCentros = centroProcedenciaService.findAll();
				formulario.setListaCentros(listaCentros);
				
			}
			
		}
		
		List listaPerfiles = new ArrayList<Perfil>();
		listaPerfiles.add(perfRedactor);
		listaPerfiles.add(perfPublicador);
		formulario.setListaPerfil(listaPerfiles);
		
		return formulario;
		
	}
	
}
