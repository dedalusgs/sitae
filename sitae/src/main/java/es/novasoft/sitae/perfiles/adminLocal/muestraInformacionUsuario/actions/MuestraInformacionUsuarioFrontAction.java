package es.novasoft.sitae.perfiles.adminLocal.muestraInformacionUsuario.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.muestraInformacionUsuario.forms.MuestraInformacionUsuarioForm;

public class MuestraInformacionUsuarioFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String externo = "";
		try {

			UsuarioService usuarioService = (UsuarioService) Factory
					.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			UsuarioExternoService usuarioExternoService = (UsuarioExternoService) Factory
			.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
			PerfilService perfilService = (PerfilService) Factory
					.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
					.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory
					.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

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

			MuestraInformacionUsuarioForm formulario = (MuestraInformacionUsuarioForm) form;

			Usuario usuario = new Usuario();
			UsuarioExterno usuarioExterno = new UsuarioExterno();

			UsuarioVisualizar usuarioVisualizar = new UsuarioVisualizar();

			// Obtengo el id de la Tabla REL_USU_ORG...
			String dni = (String) request.getParameter("idUsuarioSeleccionado");
			List<CentroProcedencia> listaCentrosAsignados = new ArrayList();
			if (dni != null && !dni.equals("")) {
				String cif = (String) request.getSession().getAttribute("cif");
				usuario = (Usuario) usuarioService.findByNumeroDocumento(dni)
						.get(0);
				
				try {
					usuarioExterno = usuarioExternoService.findFromUser(usuario.getNumDocumento());
					
				} catch (ServiceException e){

				}

				
				formulario.setUsuarioExterno(usuarioExterno);
				
				usuarioVisualizar.setNumDocumento(usuario.getNumDocumento());
				usuarioVisualizar.setNombre(usuario.getNombre());
				usuarioVisualizar.setApellido1(usuario.getApellido1());
				usuarioVisualizar.setApellido2(usuario.getApellido2());
				usuarioVisualizar.setTelefono(usuario.getTelefono());
				usuarioVisualizar.setMovil(usuario.getMovil());
				usuarioVisualizar.setEmail(usuario.getEmail());
				List<RelacionUsuOrgCentroPerf> listaRelacionesPublicador = relacionUsuOrgCentroPerfService
						.findByOrgUsuPerf(cif, dni, String
								.valueOf(Constantes.PUBLICADOR));
				Perfil perfil = null;
				if (!listaRelacionesPublicador.isEmpty()) {
					Iterator it = listaRelacionesPublicador.iterator();
					while (it.hasNext()) {
						RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfAux = (RelacionUsuOrgCentroPerf) it
								.next();
						CentroProcedencia centroProcedencia = relacionUsuOrgCentroPerfAux
								.getCentroProcedencia();
						listaCentrosAsignados.add(centroProcedencia);
					}
					formulario.setListaCentrosAsignados(listaCentrosAsignados);
					perfil = perfilService.findById(new Integer(
							Constantes.PUBLICADOR));
				} else {
					perfil = perfilService.findById(new Integer(
							Constantes.REDACTOR));
					formulario.setListaCentrosAsignados(null);
				}
				usuarioVisualizar.setIdPerfil(perfil.getIdPerfil().toString());
				usuarioVisualizar.setPerfil(perfil.getNombre());
				formulario.setUsuario(usuarioVisualizar);
			}
			request.setAttribute("MuestraInformacionUsuarioForm", formulario);
			request.getSession().setAttribute("DNI",
					formulario.getUsuario().getNumDocumento());

			if (usuarioExterno!=null && usuarioExterno.getUsu()!=null){
				externo = "Externo";
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionUsuarioFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY + externo);
	}
}
