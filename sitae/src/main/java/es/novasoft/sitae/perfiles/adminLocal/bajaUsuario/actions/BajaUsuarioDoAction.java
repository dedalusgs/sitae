package es.novasoft.sitae.perfiles.adminLocal.bajaUsuario.actions;

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
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class BajaUsuarioDoAction extends ActionBase {
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	UsuarioExternoService	        usuarioExternoService	        = (UsuarioExternoService) Factory.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
		String f = ActionBase.ERROR_KEY;
		;
		
		try {
			
			String dni = (String) request.getParameter("idUsuarioSeleccionado");
			if (dni != null && !dni.equals("")) {
				List listaUsuarios = usuarioService.findByNumeroDocumento(dni);
				if (!listaUsuarios.isEmpty()) {
					Usuario usuario = (Usuario) listaUsuarios.get(0);
					UsuarioExterno usuarioExterno = null;
					try {
						usuarioExterno = usuarioExternoService.findFromUser(usuario.getNumDocumento());
						// es interno
						usuario.setInterno(true);
					} catch (ServiceException e) {
						usuario.setInterno(false);
					}
					String cif = (String) request.getSession().getAttribute("cif");
					List listaOrganismo = organismoService.findByCif(cif);
					if (!listaOrganismo.isEmpty()) {
						Organismo organismo = (Organismo) listaOrganismo.get(0);
						Integer idOrganismo = organismo.getIdOrg();
						boolean redactorConEdictos = false;
						List permisosRedactor = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, String.valueOf(Constantes.REDACTOR));
						/*
						 * Solo existira un Permiso de Redactor pero comprobamos
						 * si existe o no
						 */
						if (!permisosRedactor.isEmpty()) {
							// List centrosDeProcedenciaRedactor =
							// centroProcedenciaService.findByIdOrg(organismo.getIdOrg());
							List centrosDeProcedenciaRedactor = centroProcedenciaService.findAll();
							Iterator iteratorCentrosDeProcedenciaRedactor = centrosDeProcedenciaRedactor.iterator();
							while (iteratorCentrosDeProcedenciaRedactor.hasNext()) {
								CentroProcedencia centroProcedencia = (CentroProcedencia) iteratorCentrosDeProcedenciaRedactor.next();
								List listaEdictosRedactor = edictoService.findByCentroUsuarioPerfilYEstadosExPR(centroProcedencia.getIdCentro(), usuario.getIdUsuario(),
								        new Integer(Constantes.REDACTOR));
								if (!listaEdictosRedactor.isEmpty()) {
									redactorConEdictos = true;
									break;
								}
							}
						}
						boolean publicadorConEdictos = false;
						List permisosPublicador = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, String.valueOf(Constantes.PUBLICADOR));
						if (!permisosPublicador.isEmpty()) {
							Iterator it = permisosPublicador.iterator();
							while (it.hasNext()) {
								RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfIt = (RelacionUsuOrgCentroPerf) it.next();
								Integer idCentro = relacionUsuOrgCentroPerfIt.getCentroProcedencia().getIdCentro();
								if (idCentro != null) {
									List listaEdictosPublicador = edictoService.findByCentroUsuarioPerfilYEstadosExPR(idCentro, usuario.getIdUsuario(), new Integer(
									        Constantes.PUBLICADOR));
									if (!listaEdictosPublicador.isEmpty()) {
										publicadorConEdictos = true;
									}
								}
							}
						}
						if (redactorConEdictos == true || publicadorConEdictos == true) {
							f = ActionBase.SUCCESS_KEY_2;
						} else {
							/* Borramos permisos de redactor */
							Iterator it = permisosRedactor.iterator();
							while (it.hasNext()) {
								RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfIt = (RelacionUsuOrgCentroPerf) it.next();
								relacionUsuOrgCentroPerfService.delete(relacionUsuOrgCentroPerfIt);
								
							}
							/* Borramos permisos de publicador */
							it = permisosPublicador.iterator();
							while (it.hasNext()) {
								RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerfIt = (RelacionUsuOrgCentroPerf) it.next();
								relacionUsuOrgCentroPerfService.delete(relacionUsuOrgCentroPerfIt);
							}
							/* Borramos el usuario si es interno */
							if (usuario.isInterno()) {
								borrarUsuario(organismo, usuario, usuarioExterno);
							}
							f = ActionBase.SUCCESS_KEY;
						}
					}
				}
				
			} else {
				log.error("Error en BajaUsuarioDoAction");
				return forward(request, mapping, ActionBase.ERROR_KEY);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaUsuarioDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		
		return forward(request, mapping, f);
	}
	
	/**
	 * @param organismo
	 * @param usuario
	 * @param usuarioExterno
	 * @throws ServiceException
	 */
	private void borrarUsuario(Organismo organismo, Usuario usuario, UsuarioExterno usuarioExterno) throws ServiceException {
		usuarioService.delete(usuario);
		usuarioExternoService.delete(usuarioExterno);
	}
}
