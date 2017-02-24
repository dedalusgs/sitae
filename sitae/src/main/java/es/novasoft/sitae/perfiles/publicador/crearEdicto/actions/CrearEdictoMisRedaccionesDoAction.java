package es.novasoft.sitae.perfiles.publicador.crearEdicto.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.files.FileServiceException;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.objects.TipoFirma;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.business.services.interfaz.TipoFirmaService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.FandangoException;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;

public class CrearEdictoMisRedaccionesDoAction extends ActionBase {
	
	private static Log	            log	                            = LogFactory.getLog(CrearEdictoMisRedaccionesDoAction.class);
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	TipoEdictoService	            tipoEdictoService	            = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
	
	EstadoService	                estadoService	                = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	UsuarioFirmanteService	        usuarioFirmanteService	        = (UsuarioFirmanteService) Factory.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	TipoFirmaService	            tipoFirmaService	            = (TipoFirmaService) Factory.getBean(ServiceConstants.TIPO_FIRMA_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	OrganismoExternoService	        organismoExternoService	        = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
	
	FestivoService	                festivoService	                = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	InputStream	                    solicitud	                    = null;
	
	Timestamp	                    fechaDoc	                    = new Timestamp(System.currentTimeMillis());
	
	UsuarioAutentificado	        solicitante	                    = null;
	FactoryFileService	            factoryFileServices	            = (FactoryFileService) Factory.getBean("FactoryFileServices");
	
	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		
		String forward = ActionBase.SUCCESS_KEY;
		
		CrearEdictoMisRedaccionesForm formulario = (CrearEdictoMisRedaccionesForm) form;
		try {
			String accion = request.getParameter("accion");
			
			if (accion != null && !accion.equals("")) {
				
				String dni = (String) request.getSession().getAttribute("nif");
				String cif = (String) request.getSession().getAttribute("cif");
				Usuario redactor = (Usuario) usuarioService.findByNumeroDocumento(dni).get(0);
				formulario.getEdicto().setRedactor(redactor);
				
				CentroProcedencia centro = centroProcedenciaService.findById(formulario.getOpcionCentro());
				
				formulario.getEdicto().setCentro(centro);
				formulario.setCentro(centro.getNombre());
				
				List relacionPermisos = relacionUsuOrgCentroPerfService.findByCentroUsuPerf(centro.getIdCentro().toString(), dni, String.valueOf(Constantes.PUBLICADOR));
				List relacionPermisosLocal = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, String.valueOf(Constantes.ADMIN_LOCAL));
				boolean permisos = false;
				if (!relacionPermisos.isEmpty() || !relacionPermisosLocal.isEmpty()) {
					permisos = true;
				}
				
				if (formulario.getOpcionOrganismoExterno() != -1) {
					OrganismoExterno organismoExterno = organismoExternoService.findById(new Integer(formulario.getOpcionOrganismoExterno()));
					formulario.getEdicto().setOrganismoExterno(organismoExterno);
				}
				Organismo organismo = (Organismo) organismoService.findByCif(cif).get(0);
				TipoEdicto tipoEdicto = tipoEdictoService.findById(formulario.getOpcionTipoEdicto());
				
				TipoFirma tipoFirma = tipoFirmaService.findById(formulario.getOpcionTipoFirma());
				
				formulario.getEdicto().setTipoFirma(tipoFirma);
				formulario.getEdicto().setSustituyeA(formulario.getEdictoSust());
				formulario.getEdicto().setOrganismo(organismo);
				formulario.getEdicto().setTipoEdicto(tipoEdicto);
				formulario.setTipoEdicto(tipoEdicto.getNombre());
				
				formulario.getEdicto().setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(formulario.getFechaPublicacion(), 0));
				
				formulario.getEdicto().setFechaRetiradaPropuesta(FechasUtil.convertStringToDate(formulario.getFechaRetirada(), 0));
				
				Date fechaActual = new Date();
				formulario.getEdicto().setFechaUltimaModificacion(fechaActual);
				formulario.getEdicto().setFechaRedaccion(fechaActual);
				
				formulario.getEdicto().setDiasExposicion(Integer.parseInt(formulario.getDiasPublicados()));
				formulario.getEdicto().setTipoExposicion(formulario.getTipoPublicacion());
				formulario.getEdicto().getCentro().getNombreCarpeta();
				// Almacenamiento del edicto
				Estado estado = this.estadoService.findById(Constantes.INICIADO);
				formulario.getEdicto().setEstado(estado);
				
				this.edictoService.save(formulario.getEdicto());
				
				formulario.setIdEdicto(formulario.getEdicto().getIdEdicto().toString());
				formulario.getEdicto().setNombrePdfAdjunto(formulario.getPdf().getFileName());
				FileService fileService = this.factoryFileServices.getService(formulario.getEdicto());
				String ruta = fileService.guardarBorrador(formulario.getPdf().getFileData(), formulario.getEdicto());
				formulario.getEdicto().setPdfAdjunto(ruta);
				
				this.edictoService.attachDirty(formulario.getEdicto());
				
				if (accion.equals("publicar") && (permisos == true)) {
					/* Ha publicado y tiene permisos para publicar */
					
					forward = ActionBase.ERROR_KEY;
					
					formulario.getEdicto().setPublicador(redactor);
					
					Edicto resultado = UtilPublicar.publicar(formulario.getEdicto());
					forward = ActionBase.SUCCESS_KEY;
					if (resultado == null) {
						request.setAttribute("valuerror", "publicarEdicto.error3");
						forward = ActionBase.ERROR_KEY;
					} else {
						if (resultado.getEstado().getIdEstado().equals(Constantes.PENDIENTE_PUBLICACION)) {
							forward = ActionBase.SUCCESS_KEY_2;
						} else {
							forward = ActionBase.SUCCESS_KEY;
							// Comprobar si los festivos están
							// declarados para avisar al usuario
							int anioFinPublicacion = FechasUtil.getYearByDate(formulario.getEdicto().getFechaRetiradaPropuesta());
							List festivosLocales = festivoService.findByOrgAnio(formulario.getEdicto().getOrganismo(), anioFinPublicacion);
							if (festivosLocales.isEmpty()) {
								request.setAttribute("festivos", "no");
								UtilPublicar.notificarFestivosNoDeclarados(formulario.getEdicto().getOrganismo(), anioFinPublicacion);
							}
							List festivosNacionales = festivoService.findByOrgAnio(null, anioFinPublicacion);
							if (festivosNacionales.isEmpty()) {
								request.setAttribute("festivos", "no");
								UtilPublicar.notificarFestivosNoDeclarados(null, anioFinPublicacion);
							}
							
						}
					}
					
				}
				if (accion.equals("publicar") && (permisos == false)) {
					
					formulario.getEdicto().setFechaPublicacion(null);
					formulario.getEdicto().setPublicador(null);
					
					/* Ha publicado y no tiene permisos para publicar */
					estado = estadoService.findById(Constantes.PENDIENTE_VALIDACION);
					formulario.getEdicto().setEstado(estado);
					edictoService.attachDirty(formulario.getEdicto());
					
					formulario.setIdEdicto(formulario.getEdicto().getIdEdicto().toString());
					/* notificamos a los usuarios */
					notificarSolicitudPublicacion(formulario.getEdicto().getIdEdicto());
					request.setAttribute("valuerror", "usuario.sinPermisos");
					forward = ActionBase.ERROR_KEY_2;
					
				}
				
				if (accion.equals("guardar")) {
					/* Ha guardado y no tiene permisos para publicar */
					// formulario.getEdicto().setPublicador(null);
					estado = estadoService.findById(Constantes.INICIADO);
					formulario.getEdicto().setEstado(estado);
					formulario.getEdicto().setFechaPublicacion(null);
					edictoService.attachDirty(formulario.getEdicto());
					
				}
			} else {
				return mapping.findForward(ActionBase.ERROR_KEY);
			}
			
		} catch (FandangoException fe) {
			request.setAttribute("valuerror", "publicarEdicto.error3");
			return mapping.findForward(ActionBase.ERROR_KEY_2);
		} catch (IOException e) {
			e.printStackTrace();
			return mapping.findForward(ActionBase.ERROR_KEY);
		} catch (Exception ex) {
			ex.printStackTrace();
			
			log.error("ERROR:" + ex.getMessage());
			log.error("TRAZA:", ex);
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {
			Edicto edictoOriginal = edictoService.findById(formulario.getEdicto().getIdEdicto());
			RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);
			
			if (edictoOriginal != null && formulario.getListaEdictosRelacionados() != null) {
				// Adjuntamos las nuevas relaciones
				for (ObjetoEdictoVisualizar objetoEdicto : formulario.getListaEdictosRelacionados()) {
					Edicto edicto = edictoService.findById(objetoEdicto.getId());
					if (edicto != null) {
						RelacionEdictos relacion = new RelacionEdictos();
						relacion.setEdicto1(formulario.getEdicto());
						relacion.setEdicto2(edicto);
						relacionEdictosService.save(relacion);
					}
				}
			}
			ResetForm.removeBean(mapping, request);
		}
		
		return mapping.findForward(forward);
	}
	
	private void notificarSolicitudPublicacion(int idEdicto) throws Exception {
		MailUtils correo = new MailUtils();
		ResourceBundle manejadorMensajes = ResourceBundle.getBundle("mailconfig");
		String asunto = manejadorMensajes.getString("asuntoSolicitudPublicacion");
		String mensaje = manejadorMensajes.getString("textoSolicitudPublicacionNombre");
		
		Edicto edicto = edictoService.findById(Integer.valueOf(idEdicto));
		
		// File adjunto = null;
		String nombreAdjunto = edicto.getNombrePdfAdjunto();
		
		File adjunto = null;
		try {
			FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
			FileService fileService = factoryFileServices.getService(edicto);
			adjunto = fileService.obtenerFicheroFile(edicto.getPdfAdjuntoString());
		} catch (FileServiceException e) {
			log.error("No se ha podido recuperar documento", e);
		}
		
		// adjunto = ;
		
		String host = manejadorMensajes.getString("host");
		String remitente = manejadorMensajes.getString("from");
		String texto = asunto + " " + edicto.getNombrePdfAdjunto();
		
		texto = texto + "\n\n Titulo del edicto :" + edicto.getTitulo();
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
		
		int res = 1;
		
		Iterator iterador = interesados.iterator();
		
		while (iterador.hasNext()) {
			Usuario interesado = (Usuario) iterador.next();
			res = correo.enviarCorreo(host, remitente, interesado.getEmail(), asunto, texto, adjunto, nombreAdjunto);
			if (res == 0) {
				log.error("CrearEdictoMisRedaccionesDoAction notificarSolicitudPublicacion: error al notificar el correo: " + interesado.getEmail());
				// throw new Exception();
			}
		}
		
	}
	
	// private byte[] obtenerDocumentoAdjunto(byte[] pdfAdjunto) throws
	// Exception{
	//
	// InputStream documento = null;
	// OutputStream out = null;
	// byte[] adjunto = null;
	//
	// byte[] f = new File(pdfAdjunto);
	// documento = new FileInputStream(f);
	// adjunto = new File(pdfAdjunto);
	// out = new FileOutputStream(adjunto);
	//
	// byte buf[]=new byte[1024];
	//
	// int len=documento.read(buf);
	// while(len>0){
	// out.write(buf);
	// len=documento.read(buf);
	// }
	// return adjunto;
	// }
	
}
