package es.novasoft.sitae.perfiles.publicador.modificarMisRedacciones.actions;

import java.io.File;
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
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.files.FileServiceException;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.FandangoException;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.perfiles.publicador.modificarMisRedacciones.forms.ModificarMisRedaccionesForm;

public class ModificarMisRedaccionesDoAction extends ActionBase {
	
	EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	TipoEdictoService	            tipoEdictoService	            = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	EstadoService	                estadoService	                = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	OrganismoExternoService	        organismoExternoService	        = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
	
	FestivoService	                festivoService	                = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	
	FactoryFileService	            factoryFileServices	            = (FactoryFileService) Factory.getBean("FactoryFileServices");
	
	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModificarMisRedaccionesForm formulario = (ModificarMisRedaccionesForm) form;
		
		String s = ActionBase.ERROR_KEY;
		
		CentroProcedencia cp = new CentroProcedencia();
		TipoEdicto te = new TipoEdicto();
		boolean nuevoDocumento = false;
		try {
			String accion = request.getParameter("accion");
			
			if (accion != null && !accion.equals("")) {
				String dni = (String) request.getSession().getAttribute("nif");
				String cif = (String) request.getSession().getAttribute("cif");
				Usuario redactor = (Usuario) usuarioService.findByNumeroDocumento(dni).get(0);
				formulario.getEdicto().setRedactor(redactor);
				
				CentroProcedencia centro = centroProcedenciaService.findById(formulario.getOpcionCentro());
				
				formulario.getEdicto().setCentro(centro);
				// - formulario.setCentro(centro.getNombre());
				
				if (formulario.getOpcionOrganismoExterno() != -1) {
					OrganismoExterno organismoExterno = organismoExternoService.findById(new Integer(formulario.getOpcionOrganismoExterno()));
					formulario.getEdicto().setOrganismoExterno(organismoExterno);
				} else {
					formulario.getEdicto().setOrganismoExterno(null);
				}
				
				List relacionPermisos = relacionUsuOrgCentroPerfService.findByCentroUsuPerf(centro.getIdCentro().toString(), dni, String.valueOf(Constantes.PUBLICADOR));
				List relacionPermisosLocal = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, String.valueOf(Constantes.ADMIN_LOCAL));
				boolean permisos = false;
				if (!relacionPermisos.isEmpty() || !relacionPermisosLocal.isEmpty()) {
					permisos = true;
				}
				
				TipoEdicto tipoEdicto = tipoEdictoService.findById(formulario.getOpcionTipoEdicto());
				
				formulario.getEdicto().setTipoEdicto(tipoEdicto);
				// -- formulario.setTipoEdicto(tipoEdicto.getNombre());
				
				formulario.getEdicto().setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(formulario.getFechaPublicacion(), 0));
				
				formulario.getEdicto().setFechaRetiradaPropuesta(FechasUtil.convertStringToDate(formulario.getFechaRetirada(), 0));
				formulario.getEdicto().setTipoExposicion(formulario.getTipoPublicacion());
				formulario.getEdicto().setDiasExposicion(formulario.getDiasExposicion());
				Date fechaActual = new Date();
				formulario.getEdicto().setFechaUltimaModificacion(fechaActual);
				// formulario.getEdicto().setFechaRedaccion(fechaActual);
				
				// Almacenamiento del edicto
				
				if (formulario.getPdf() != null && formulario.getPdf().getFileName() != null && !formulario.getPdf().getFileName().trim().equals("")) {
					
					String nombreEdicto = formulario.getPdf().getFileName();
					formulario.getEdicto().setNombrePdfAdjunto(nombreEdicto);
					FileService fileService = this.factoryFileServices.getService(formulario.getEdicto());
					String ruta = fileService.guardarBorrador(formulario.getPdf().getFileData(), formulario.getEdicto());
					formulario.getEdicto().setPdfAdjunto(ruta);
					this.edictoService.attachDirty(formulario.getEdicto());
				}
				
				if (accion.equals("publicar") && (permisos == true)) {
					/* Ha publicado y tiene permisos para publicar */
					
					s = ActionBase.ERROR_KEY;
					
					formulario.getEdicto().setPublicador(redactor);
					
					Edicto resultado = UtilPublicar.publicar(formulario.getEdicto());
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
					Estado estado = estadoService.findById(Constantes.PENDIENTE_VALIDACION);
					formulario.getEdicto().setEstado(estado);
					if (nuevoDocumento) {
						edictoService.actualizar(formulario.getEdicto());
					} else {
						edictoService.attachDirty(formulario.getEdicto());
					}
					/* notificamos a los usuarios */
					notificarSolicitudPublicacion(formulario.getEdicto().getIdEdicto());
					request.setAttribute("valuerror", "publicarEdicto.error4");
					request.setAttribute("valuerror", "usuario.sinPermisos");
					s = ActionBase.ERROR_KEY_2;
					
				}
				if (accion.equals("guardar")) {
					
					/* Ha guardado y tiene permisos para publicar */
					if (nuevoDocumento) {
						edictoService.actualizar(formulario.getEdicto());
					} else {
						edictoService.attachDirty(formulario.getEdicto());
					}
					s = ActionBase.SUCCESS_KEY;
				}
				
			} else {
				return mapping.findForward(ActionBase.ERROR_KEY);
			}
			
		} catch (FandangoException fe) {
			request.setAttribute("valuerror", "publicarEdicto.error3");
			return mapping.findForward(ActionBase.ERROR_KEY_2);
		} catch (Exception e) {
			log.error("Error en ModificarEdictoDoAction: " + e.getMessage(), e);
			return forward(request, mapping, s);
		}
		
		return forward(request, mapping, s);
	}
	
	private void notificarSolicitudPublicacion(int idEdicto) throws Exception {
		MailUtils correo = new MailUtils();
		ResourceBundle manejadorMensajes = ResourceBundle.getBundle("mailconfig");
		String asunto = manejadorMensajes.getString("asuntoSolicitudPublicacion");
		String mensaje = manejadorMensajes.getString("textoSolicitudPublicacionNombre");
		
		Edicto edicto = edictoService.findById(Integer.valueOf(idEdicto));
		
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
		
		String host = manejadorMensajes.getString("host");
		String remitente = manejadorMensajes.getString("from");
		String texto = asunto + " " + adjunto.getName();
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
	
}
