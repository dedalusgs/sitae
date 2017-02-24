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
import es.novasoft.comun.utils.HashUtil;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.adminLocal.modificarUsuarios.forms.ModificarUsuariosForm;

public class ModificarUsuariosDoAction extends ActionBase {
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	UsuarioExternoService	        usuarioExternoService	        = (UsuarioExternoService) Factory.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	PerfilService	                perfilService	                = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Usuario usuario = new Usuario();
		ModificarUsuariosForm formulario = (ModificarUsuariosForm) form;
		
		String f = ActionBase.ERROR_KEY;
		
		try {
			
			List listaUsuarios = new ArrayList();
			usuario = formulario.getUsuario();
			String dni = (String) request.getSession().getAttribute("ModificarUsuariosDNI");
			String cif = (String) request.getSession().getAttribute("ModificarUsuariosCIF");
			List organismos = this.organismoService.findByCif(cif);
			Organismo organismo = (Organismo) organismos.get(0);
			boolean tienePermisosPublicador = false;
			List permisosPublicador = this.relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, String.valueOf(Constantes.PUBLICADOR));
			if (!permisosPublicador.isEmpty()) {
				tienePermisosPublicador = true;
			}
			boolean tienePermisosRedactor = false;
			List permisosRedactor = this.relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, String.valueOf(Constantes.REDACTOR));
			List centrosDeProcedenciaRedactor = this.centroProcedenciaService.findAll();
			// List centrosDeProcedenciaRedactor =
			// this.centroProcedenciaService.findByIdOrg(organismo.getIdOrg());
			if (!permisosRedactor.isEmpty()) {
				tienePermisosRedactor = true;
			}
			if (formulario.getOpcionPerfil().byteValue() == Constantes.REDACTOR) {
				if (tienePermisosPublicador == true) {
					boolean tieneEdictosPublicador = false;
					Iterator it = permisosPublicador.iterator();
					while (it.hasNext()) {
						RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
						List listaEdictosPublicador = this.edictoService.findByCentroUsuarioPerfilYEstadosExPR(relacionUsuOrgCentroPerf.getCentroProcedencia().getIdCentro(),
						        usuario.getIdUsuario(), new Integer(Constantes.PUBLICADOR));
						if (!listaEdictosPublicador.isEmpty()) {
							tieneEdictosPublicador = true;
						}
					}
					if (tieneEdictosPublicador) {
						f = ActionBase.SUCCESS_KEY_2;
					} else {
						Iterator itPermisosPublicador = permisosPublicador.iterator();
						while (itPermisosPublicador.hasNext()) {
							RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) itPermisosPublicador.next();
							this.relacionUsuOrgCentroPerfService.delete(relacionUsuOrgCentroPerf);
						}
						RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
						Perfil perfil = this.perfilService.findById(new Integer(Constantes.REDACTOR));
						relacionUsuOrgCentroPerf.setPerfil(perfil);
						relacionUsuOrgCentroPerf.setUsuario(dni);
						relacionUsuOrgCentroPerf.setOrganismo(cif);
						this.relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);
					}
					
				}
			}
			
			if (formulario.getOpcionPerfil().byteValue() == Constantes.PUBLICADOR) {
				if (tienePermisosRedactor == true) {
					boolean tieneEdictosRedactor = false;
					if (!permisosRedactor.isEmpty()) {
						Iterator iteratorCentrosDeProcedenciaRedactor = centrosDeProcedenciaRedactor.iterator();
						while (iteratorCentrosDeProcedenciaRedactor.hasNext()) {
							CentroProcedencia centroProcedencia = (CentroProcedencia) iteratorCentrosDeProcedenciaRedactor.next();
							List listaEdictosRedactor = this.edictoService.findByCentroUsuarioPerfilYEstadosExPR(centroProcedencia.getIdCentro(), usuario.getIdUsuario(),
							        new Integer(Constantes.REDACTOR));
							if (!listaEdictosRedactor.isEmpty()) {
								tieneEdictosRedactor = true;
								break;
							}
						}
					}
					if (tieneEdictosRedactor) {
						f = ActionBase.SUCCESS_KEY_2;
					} else {
						Iterator itPermisosRedactor = permisosRedactor.iterator();
						while (itPermisosRedactor.hasNext()) {
							RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) itPermisosRedactor.next();
							this.relacionUsuOrgCentroPerfService.delete(relacionUsuOrgCentroPerf);
						}
						RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
						Perfil perfil = this.perfilService.findById(new Integer(Constantes.PUBLICADOR));
						relacionUsuOrgCentroPerf.setPerfil(perfil);
						CentroProcedencia centroProcedencia = this.centroProcedenciaService.findById(new Integer(formulario.getOpcionCentro()));
						relacionUsuOrgCentroPerf.setCentroProcedencia(centroProcedencia);
						relacionUsuOrgCentroPerf.setUsuario(dni);
						relacionUsuOrgCentroPerf.setOrganismo(cif);
						this.relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);
					}
				}
				
			}
			this.usuarioService.attachDirty(usuario);
			if (formulario.getUsuario().isInterno()) {
				guardarUsuarioExterno(formulario);
			}
			if (f != ActionBase.SUCCESS_KEY_2) {
				f = ActionBase.SUCCESS_KEY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.log.error("Error en ModificarUsuariosDoAction", e);
			return forward(request, mapping, f);
		}
		
		return forward(request, mapping, f);
	}
	
	/**
	 * Guardar usuario externo.
	 * 
	 * @param formulario
	 *            the formulario
	 * @throws ServiceException
	 */
	private void guardarUsuarioExterno(ModificarUsuariosForm formulario) throws ServiceException {
		if (formulario.getPasswordNuevo() != null) {
			
			formulario.getUsuarioExterno().setPassword(HashUtil.calcularSHAString(formulario.getPasswordNuevo()));
			this.usuarioExternoService.attachDirty(formulario.getUsuarioExterno());
		}
	}
}
