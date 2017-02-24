package es.novasoft.sitae.perfiles.adminGlobal.bajaAdmLocal.actions;

import java.util.Iterator;
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
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class BajaAdmLocalDoAction extends ActionBase {
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	PerfilService	                perfilService	                = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String f = ActionBase.SUCCESS_KEY;
		
		try {
			
			String dniSeleccionado = (String) request.getParameter("idAdmLocalSelecionado");
			
			if (dniSeleccionado != null && !dniSeleccionado.equals("")) {
				
				boolean tieneEdictos = false;
				
				List listaUsuarios = usuarioService.findByNumeroDocumento(dniSeleccionado);
				if (!listaUsuarios.isEmpty()) {
					Usuario usuario = (Usuario) listaUsuarios.get(0);
					List relacionesUsuOrgCentroPerf = relacionUsuOrgCentroPerfService.findByUsuPerf(dniSeleccionado, String.valueOf(Constantes.ADMIN_LOCAL));
					Iterator it = relacionesUsuOrgCentroPerf.iterator();
					while (it.hasNext()) {
						RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
						String cifOrganimo = (String) relacionUsuOrgCentroPerf.getOrganismo();
						List organismos = organismoService.findByCif(cifOrganimo);
						if (!organismos.isEmpty()) {
							Organismo organismo = (Organismo) organismos.get(0);
							Integer idOrg = organismo.getIdOrg();
							List centrosDeProcedencia = centroProcedenciaService.findAll();
							// .findByIdOrg(idOrg);
							if (!centrosDeProcedencia.isEmpty()) {
								Iterator it2 = centrosDeProcedencia.iterator();
								while (it2.hasNext()) {
									CentroProcedencia centroProcedencia = (CentroProcedencia) it2.next();
									List listaEdictos = edictoService.findByCentroYEstadosExPRYPubORed(centroProcedencia.getIdCentro(), usuario.getIdUsuario());
									if (!listaEdictos.isEmpty()) {
										tieneEdictos = true;
										break;
									}
								}
							}
						}
					}
					
					if (tieneEdictos == false) {
						List relacionesUsuOrgCentroPerfBorrar = relacionUsuOrgCentroPerfService.findByUsuPerf(dniSeleccionado, String.valueOf(Constantes.ADMIN_LOCAL));
						if (!relacionesUsuOrgCentroPerfBorrar.isEmpty()) {
							Iterator iterador = relacionesUsuOrgCentroPerfBorrar.iterator();
							while (iterador.hasNext()) {
								RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) iterador.next();
								relacionUsuOrgCentroPerfService.delete(relacionUsuOrgCentroPerf);
							}
						}
						relacionesUsuOrgCentroPerfBorrar = relacionUsuOrgCentroPerfService.findByUsuPerf(dniSeleccionado, String.valueOf(Constantes.ADMIN_GLOBAL));
						if (!relacionesUsuOrgCentroPerfBorrar.isEmpty()) {
							Iterator iterador = relacionesUsuOrgCentroPerfBorrar.iterator();
							while (iterador.hasNext()) {
								RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) iterador.next();
								relacionUsuOrgCentroPerfService.delete(relacionUsuOrgCentroPerf);
							}
						}
					} else {
						f = ActionBase.ERROR_KEY_2;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaAdmLocalDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		
		return forward(request, mapping, f);
	}
}
