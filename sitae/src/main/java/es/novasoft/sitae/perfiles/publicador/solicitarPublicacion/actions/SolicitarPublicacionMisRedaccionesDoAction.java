package es.novasoft.sitae.perfiles.publicador.solicitarPublicacion.actions;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.files.FileServiceException;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.publicador.solicitarPublicacion.forms.SolicitarPublicacionMisRedaccionesForm;

public class SolicitarPublicacionMisRedaccionesDoAction extends ActionBase {
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	EstadoService	                estadoService	                = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SolicitarPublicacionMisRedaccionesForm formulario = (SolicitarPublicacionMisRedaccionesForm) form;
		Edicto edicto = new Edicto();
		String s = ActionBase.ERROR_KEY;
		
		try {
			
			String idEdicto = (String) request.getParameter("idEdictoSeleccionado");
			
			if (idEdicto != null && !idEdicto.equals("")) {
				
				edicto = edictoService.findById(Integer.valueOf(idEdicto));
				
				InputStream documento = null;
				OutputStream out = null;
				// File adjunto = null;
				
				log.debug("Inicio del try");
				
				MailUtils correo = null;
				correo = new MailUtils();
				ResourceBundle mailconfig = ResourceBundle.getBundle("mailconfig");
				
				// String nombreAdjunto="";
				String asunto = "";
				
				ServletContext contexto = this.getServlet().getServletContext();
				String rutaEdicto = contexto.getRealPath(Constantes.getPropiedad(Constantes.RUTA_EDICTOS));
				String nombreAdjunto = edicto.getNombrePdfAdjunto();
				
				File adjunto = null;
				try {
					FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
					FileService fileService = factoryFileServices.getService(edicto);
					adjunto = fileService.obtenerFicheroFile(edicto.getPdfAdjuntoString());
				} catch (FileServiceException e) {
					log.error("No se ha podido recuperar documento", e);
				}
				
				// Obtener interesados
				Integer idCentro = edicto.getCentro().getIdCentro();
				Integer idPerfil = Constantes.PUBLICADOR;
				List relacion = relacionUsuOrgCentroPerfService.findByCentroPerfil(idCentro, idPerfil);
				List interesados = new ArrayList<Usuario>();
				
				Iterator it = relacion.iterator();
				
				while (it.hasNext()) {
					RelacionUsuOrgCentroPerf rel = (RelacionUsuOrgCentroPerf) it.next();
					Usuario usuario = (Usuario) usuarioService.findByNumeroDocumento(rel.getUsuario()).get(0);
					interesados.add(usuario);
				}
				
				String host = mailconfig.getString("host");
				String remitente = mailconfig.getString("from");
				String texto = mailconfig.getString("textoSolicitudPublicacionNombre") + " " + edicto.getTitulo();
				texto = texto + mailconfig.getString("textoSolicitudPublicacionNombre2");
				texto = texto + mailconfig.getString("textoSolicitudPublicacionNombreVa") + " " + edicto.getTituloVa();
				texto = texto + mailconfig.getString("textoSolicitudPublicacionNombre2Va");
				texto = texto + "<p>http://" + edicto.getOrganismo().getDominio() + "</p>";
				Estado estado = estadoService.findById(Constantes.PENDIENTE_VALIDACION);
				if (edicto.getEstado().getIdEstado().equals(Constantes.INICIADO) || edicto.getEstado().getIdEstado().equals(Constantes.RECHAZADO)
				        || edicto.getEstado().getIdEstado().equals(Constantes.RECHAZADO_FIRMA)) {
					
					int res = 1;
					
					Iterator iterador = interesados.iterator();
					
					while (iterador.hasNext()) {
						Usuario interesado = (Usuario) iterador.next();
						// res=correo.enviarCorreo(host, remitente,
						// interesado.getEmail(), asunto, texto, adjunto,
						// nombreAdjunto);
						if (res == 0)
							throw new Exception();
					}
					
					edicto.setEstado(estado);
					edictoService.attachDirty(edicto);
					s = ActionBase.SUCCESS_KEY;
					Date fechaActual = new Date();
					edicto.setFechaUltimaModificacion(fechaActual);
					
				} else {
					s = ActionBase.ERROR_KEY_2;
				}
				
				log.debug("Correo enviado correctamente");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en SolicitarPublicacionDoAction", e);
			return forward(request, mapping, s);
		}
		
		return forward(request, mapping, s);
	}
}
