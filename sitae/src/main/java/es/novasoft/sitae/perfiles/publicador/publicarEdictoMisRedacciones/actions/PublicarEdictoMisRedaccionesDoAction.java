package es.novasoft.sitae.perfiles.publicador.publicarEdictoMisRedacciones.actions;

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
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.FandangoException;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.perfiles.publicador.muestraInformacionEdicto.forms.MuestraInformacionEdictoForm;
import es.novasoft.sitae.perfiles.publicador.publicarEdictoMisRedacciones.forms.PublicarEdictoMisRedaccionesForm;

public class PublicarEdictoMisRedaccionesDoAction extends ActionBase {
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	EstadoService	                estadoService	                = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	FestivoService	                festivoService	                = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	
	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PublicarEdictoMisRedaccionesForm formulario = (PublicarEdictoMisRedaccionesForm) form;
		Edicto edicto = new Edicto();
		String s = ActionBase.ERROR_KEY;
		
		try {
			
			String idEdicto = request.getParameter("idEdictoSeleccionado");
			MuestraInformacionEdictoForm formulario2 = (MuestraInformacionEdictoForm) request.getSession().getAttribute("MuestraInformacionEdictoForm");
			
			if (idEdicto == null) {
				// Lo recogemos de aqui si viene del boton publicar del Mostrar
				// Informacion del edicto
				idEdicto = formulario2.getIdEdicto();
			}
			
			if (idEdicto == null || idEdicto.equals("")) {
				
				idEdicto = formulario.getIdEdicto();
			}
			if (idEdicto != null && !idEdicto.equals("")) {
				/* Ha publicado y tiene permisos para publicar */
				edicto = edictoService.findById(Integer.valueOf(idEdicto));
				String dni = (String) request.getSession().getAttribute("nif");
				
				Usuario publicador = (Usuario) usuarioService.findByNumeroDocumento(dni).get(0);
				formulario.getEdicto().setPublicador(publicador);
				s = ActionBase.ERROR_KEY;
				
				Edicto resultado = UtilPublicar.publicar(edicto);
				s = ActionBase.SUCCESS_KEY;
				if (resultado == null) {
					request.setAttribute("valuerror", "publicarEdicto.error3");
					s = ActionBase.ERROR_KEY;
				} else {
					if (resultado.getEstado().getIdEstado().equals(Constantes.PENDIENTE_PUBLICACION)) {
						s = ActionBase.SUCCESS_KEY_2;
					} else {
						s = ActionBase.SUCCESS_KEY;
						// Comprobar si los festivos están
						// declarados para avisar al usuario
						int anioFinPublicacion = FechasUtil.getYearByDate(edicto.getFechaRetiradaPropuesta());
						List festivosLocales = festivoService.findByOrgAnio(edicto.getOrganismo(), anioFinPublicacion);
						if (festivosLocales.isEmpty()) {
							request.setAttribute("festivos", "no");
							UtilPublicar.notificarFestivosNoDeclarados(edicto.getOrganismo(), anioFinPublicacion);
						}
						List festivosNacionales = festivoService.findByOrgAnio(null, anioFinPublicacion);
						if (festivosNacionales.isEmpty()) {
							request.setAttribute("festivos", "no");
							UtilPublicar.notificarFestivosNoDeclarados(null, anioFinPublicacion);
						}
						
					}
					
				}
				
			} else {
				request.setAttribute("valuerror", "publicarEdicto.error2");
				s = ActionBase.ERROR_KEY_2;
			}
			
		} catch (FandangoException fe) {
			request.setAttribute("valuerror", "publicarEdicto.error3");
			return mapping.findForward(ActionBase.ERROR_KEY_2);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en PublicarEdictoMisRedaccionesDoAction", e);
			return forward(request, mapping, s);
		}
		
		return forward(request, mapping, s);
	}
	
}
