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
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;

public class PublicarEdictoCrearDoAction extends ActionBase {
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	EstadoService	                estadoService	                = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	PerfilService	                perfilService	                = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
	FestivoService	                festivoService	                = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	
	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Edicto edicto = new Edicto();
		String s = ActionBase.ERROR_KEY;
		
		try {
			
			CrearEdictoMisRedaccionesForm formulario = (CrearEdictoMisRedaccionesForm) request.getSession().getAttribute("CrearEdictoMisRedaccionesForm");
			
			String idEdicto = (String) request.getSession().getAttribute("publicarAlCrear");
			
			// String idEdicto2 =
			// formulario.getEdicto().getIdEdicto().toString();
			
			if (idEdicto != null && !idEdicto.equals("")) {
				
				// Compruebo que el Publicador esta dado de alta en el centro de
				// Procedencia del edicto
				
				edicto = edictoService.findById(Integer.valueOf(idEdicto));
				
				CentroProcedencia centro = edicto.getCentro();
				
				String numDocumento = edicto.getRedactor().getNumDocumento();
				
				Perfil perfil = perfilService.findById(Constantes.PUBLICADOR);
				
				List listaCentros = relacionUsuOrgCentroPerfService.findByCentroUsuPerf(edicto.getCentro().getIdCentro().toString(), numDocumento, perfil.getIdPerfil().toString());
				
				if (listaCentros.isEmpty()) {
					
					s = ActionBase.ERROR_KEY_2;
					
				} else {
					
					// Publicamos Edicto
					
					edicto.setPublicador(edicto.getRedactor());
					Edicto resultado = UtilPublicar.publicar(edicto);
					if (resultado == null) {
						request.setAttribute("valuerror", "publicarEdicto.error3");
						s = ActionBase.ERROR_KEY;
					} else {
						if (resultado.getEstado().getIdEstado().equals(Constantes.PENDIENTE_PUBLICACION)) {
							s = ActionBase.SUCCESS_KEY_2;
						} else {
							s = ActionBase.SUCCESS_KEY;
							
							int anioFinPublicacion = FechasUtil.getYearByDate(formulario.getEdicto().getFechaRetiradaPropuesta());
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
						request.setAttribute("codigo", formulario.getEdicto().getCodigo());
						request.setAttribute("urlCertificado", formulario.getEdicto().getUrl());
						s = ActionBase.SUCCESS_KEY;
						
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en PublicarEdictoCrearDoAction", e);
			return forward(request, mapping, s);
		}
		
		return forward(request, mapping, s);
	}
}
