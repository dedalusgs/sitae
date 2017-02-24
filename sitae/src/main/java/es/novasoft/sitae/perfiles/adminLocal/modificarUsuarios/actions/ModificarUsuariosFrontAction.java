package es.novasoft.sitae.perfiles.adminLocal.modificarUsuarios.actions;

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
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.modificarUsuarios.forms.ModificarUsuariosForm;

public class ModificarUsuariosFrontAction extends ActionBase {
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String externo = "";
		
		try {
			UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			UsuarioExternoService usuarioExternoService = (UsuarioExternoService) Factory.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
			PerfilService perfilService = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
			
			UsuarioAutentificado ciudadano = null;
			List<CentroProcedencia> listaCentrosProcedencia = new ArrayList();
			List<CentroProcedencia> listaCentrosProcedenciaFiltrada = new ArrayList();
			List<CentroProcedencia> listaCentrosProcedenciaAsignados = new ArrayList();
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
			
			ModificarUsuariosForm formulario = (ModificarUsuariosForm) form;
			Object numeroErrores = request.getAttribute("numeroErrores");
			if (numeroErrores == null || ((Integer) numeroErrores).intValue() == 0) {
				String numDocumento = request.getParameter("idUsuarioSeleccionado");
				if (numDocumento != null && !numDocumento.equals("")) {
					request.getSession().setAttribute("ModificarUsuariosDNI", numDocumento);
				}
				if (request.getSession().getAttribute("ModificarUsuariosDNI") != null && !request.getSession().getAttribute("ModificarUsuariosDNI").equals("")) {
					numDocumento = (String) request.getSession().getAttribute("ModificarUsuariosDNI");
					String cif = (String) request.getSession().getAttribute("cif");
					request.getSession().setAttribute("ModificarUsuariosCIF", cif);
					Usuario usuario = new Usuario();
					UsuarioExterno usuarioExterno = new UsuarioExterno();
					Organismo organismo = null;
					String recargaPerfil = request.getParameter("recarga");
					/* No hay recarga */
					List organismos = organismoService.findByCif(cif);
					organismo = (Organismo) organismos.get(0);
					cargaPerfiles(formulario, organismo.getIdOrg(), request);
					
					if (recargaPerfil == null || recargaPerfil.equalsIgnoreCase("")) {
						usuario = (Usuario) usuarioService.findByNumeroDocumento(numDocumento).get(0);
						
						try {
							usuarioExterno = usuarioExternoService.findFromUser(usuario.getNumDocumento());
							
						} catch (ServiceException e) {
							
						}
						formulario.setUsuario(usuario);
						formulario.setUsuarioExterno(usuarioExterno);
						List<RelacionUsuOrgCentroPerf> listaRelaciones = relacionUsuOrgCentroPerfService.findByCifDni(cif, numDocumento);
						Iterator it = listaRelaciones.iterator();
						while (it.hasNext()) {
							RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfAux = (RelacionUsuOrgCentroPerf) it.next();
							if (relacionUsuOrgCentroPerfAux.getPerfil().getIdPerfil().equals(Constantes.PUBLICADOR)) {
								CentroProcedencia centroProcedencia = centroProcedenciaService.findById(relacionUsuOrgCentroPerfAux.getCentroProcedencia().getIdCentro());
								listaCentrosProcedenciaAsignados.add(centroProcedencia);
							}
							
						}
						it = listaRelaciones.iterator();
						boolean redactor = true;
						Integer idPerfil = new Integer(Constantes.REDACTOR);
						while (it.hasNext()) {
							RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfAux = (RelacionUsuOrgCentroPerf) it.next();
							if (relacionUsuOrgCentroPerfAux.getPerfil().getIdPerfil().equals(Constantes.PUBLICADOR)) {
								redactor = false;
								idPerfil = new Integer(Constantes.PUBLICADOR);
							}
							
						}
						formulario.setOpcionPerfil(idPerfil);
						
						// listaCentrosProcedencia =
						// centroProcedenciaService.findByIdOrg(organismo.getIdOrg());
						listaCentrosProcedencia = centroProcedenciaService.findAll();
						it = listaCentrosProcedencia.iterator();
						while (it.hasNext()) {
							CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
							boolean encontrado = false;
							Iterator itAsignados = listaCentrosProcedenciaAsignados.iterator();
							while (itAsignados.hasNext()) {
								CentroProcedencia centroProcedenciaAsignado = (CentroProcedencia) itAsignados.next();
								String centroProcedenciaSinAsignarString = centroProcedencia.getIdCentro().toString();
								String centroProcedenciaAsignadoString = centroProcedenciaAsignado.getIdCentro().toString();
								if (centroProcedenciaSinAsignarString.equals(centroProcedenciaAsignadoString)) {
									encontrado = true;
								}
							}
							if (encontrado == false) {
								listaCentrosProcedenciaFiltrada.add(centroProcedencia);
								
							}
						}
						formulario.setListaCentrosProcedenciaAsignados(listaCentrosProcedenciaAsignados);
						formulario.setListaCentrosProcedencia(listaCentrosProcedenciaFiltrada);
					}
					
					request.setAttribute("ModificarUsuariosForm", formulario);
					if (usuarioExterno != null && usuarioExterno.getUsu() != null) {
						externo = "Externo";
					}
					
				} else {
					return forward(request, mapping, ActionBase.ERROR_KEY);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.LOGGER.error("Error en ModificarUsuariosForm", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY + externo);
	}
	
	public ModificarUsuariosForm cargaPerfiles(ModificarUsuariosForm formulario, Integer idOrganismo, HttpServletRequest request) throws Exception {
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		PerfilService perfilService = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		Perfil perfRedactor = perfilService.findById(Constantes.REDACTOR);
		Perfil perfPublicador = perfilService.findById(Constantes.PUBLICADOR);
		if (formulario.getOpcionPerfil().equals(Constantes.PUBLICADOR)) {
			List listaCentros = centroProcedenciaService.findAll();
			formulario.setListaCentros(listaCentros);
		}
		List listaPerfiles = new ArrayList<Perfil>();
		listaPerfiles.add(perfRedactor);
		listaPerfiles.add(perfPublicador);
		formulario.setListaPerfil(listaPerfiles);
		return formulario;
		
	}
	
}
