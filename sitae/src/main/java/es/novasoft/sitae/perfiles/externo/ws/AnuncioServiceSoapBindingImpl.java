/**
 * AnuncioService_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.externo.ws;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;

import com.itextpdf.text.pdf.PdfReader;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.files.FileServiceException;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.objects.TipoFirma;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.business.services.interfaz.TipoFirmaService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.FandangoException;
import es.novasoft.sitae.comun.utils.UtilPublicar;

public class AnuncioServiceSoapBindingImpl implements es.novasoft.sitae.perfiles.externo.ws.AnuncioService_PortType {
	private static final Log	            log	                            = LogFactory.getLog(AnuncioServiceSoapBindingImpl.class);
	
	private static final int	            MILLIS_IN_A_DAY	                = 1000 * 60 * 60 * 24;
	
	/** The SI n_ errores. */
	private static String	                SIN_ERRORES	                    = "ERR_00";
	
	/** The ERRO r_ general. */
	private static String	                ERROR_GENERAL	                = "ERR_01";
	
	/** The ERRO r_ bbdd. */
	private static String	                ERROR_BBDD	                    = "ERR_02";
	
	/** The ERRO r_ usuario. */
	private static String	                ERROR_USUARIO	                = "ERR_03";
	
	/** The ERRO r_ password. */
	private static String	                ERROR_PASSWORD	                = "ERR_04";
	
	/** The ERRO r_ validacion. */
	private static String	                ERROR_VALIDACION	            = "ERR_05";
	
	/** The ERRO r_ firm a_ doc. */
	private static String	                ERROR_FIRMA_DOC	                = "ERR_06";
	
	/** The ER r_ permisos. */
	private static String	                ERROR_PERMISOS	                = "ERR_07";
	
	/** The ER r_ fandango. */
	private static String	                ERROR_FANDANGO	                = "ERR_08";
	
	private static String	                ANUNCIO_NO_EXISTE	            = "ERR_09";
	
	private static final String	            ANUNCIO_ASIGNADO	            = "ERR_10";
	
	private UsuarioExterno	                usuarioExterno;
	private Usuario	                        usuarioExt;
	private Edicto	                        edicto;
	private TipoEdicto	                    tipo;
	private CentroProcedencia	            centro;
	private OrganismoExterno	            orgExt;
	private Organismo	                    organismo;
	
	/** The edicto service. */
	private EdictoService	                edictoService	                = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	/** The centro procedencia service. */
	private CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	/** The tipo edicto service. */
	private TipoEdictoService	            tipoEdictoService	            = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
	
	/** The estado service. */
	private EstadoService	                estadoService	                = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	/** The usuario service. */
	private UsuarioService	                usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	/** The usuario firmante service. */
	private UsuarioExternoService	        usuarioExternoService	        = (UsuarioExternoService) Factory.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
	
	/** The organismo service. */
	private OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	/** The tipo firma service. */
	private TipoFirmaService	            tipoFirmaService	            = (TipoFirmaService) Factory.getBean(ServiceConstants.TIPO_FIRMA_BEAN_NAME);
	
	/** The relacion usu org centro perf service. */
	private RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	/** The organismo externo service. */
	private OrganismoExternoService	        organismoExternoService	        = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
	
	FactoryFileService	                    factoryFileServices	            = (FactoryFileService) Factory.getBean("FactoryFileServices");
	
	public es.novasoft.sitae.perfiles.externo.ws.PublicarResponse publicarAnuncio(es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest solicitudRequest)
	        throws java.rmi.RemoteException {
		log.info("Inicio Publicación anuncioWS");
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(solicitudRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("Autenticacion Correcta");
				response = validateCampos(solicitudRequest, response);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			log.info("Validación de campos correcta");
			response = procesarPDF(solicitudRequest, response);
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			log.info("Documento PDF correcto");
			try {
				response = checkPermisos(solicitudRequest, response);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_PERMISOS);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("Permisos para la publicación correctos");
				crearEdicto(solicitudRequest);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_GENERAL);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
			try {
				response = publicarAnuncio(solicitudRequest, response);
			} catch (ServiceException e) {
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
				response.setCOD_ERROR(ERROR_GENERAL);
			}
		}
		TypeError[] errors = transformResponse(response);
		String[] idAnuncio = null;
		if (errors == null) {
			log.info("Publicación de anuncio correcta");
			idAnuncio = new String[1];
			idAnuncio[0] = String.valueOf(edicto.getIdEdicto());
		}
		return new PublicarResponse(idAnuncio, errors);
	}
	
	private TypeError[] transformResponse(TypeError response) {
		// TODO Auto-generated method stub
		
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			return null;
		}
		
		String[] splitResponse = response.getDESCRIPCION_ES().split("\n");
		String[] splitResponseVa = response.getDESCRIPCION_VA().split("\n");
		TypeError[] responseArray = new TypeError[splitResponse.length];
		for (int i = 0; i < splitResponse.length; i++) {
			responseArray[i] = new TypeError();
			responseArray[i].setCOD_ERROR(response.getCOD_ERROR());
			responseArray[i].setDESCRIPCION_ES(splitResponse[i]);
			responseArray[i].setDESCRIPCION_VA(splitResponseVa[i]);
		}
		return responseArray;
	}
	
	private void crearEdicto(SolicitudRequest solicitudRequest) throws ServiceException {
		// TODO Auto-generated method stub
		log.info("Creando Anuncio en Borrador");
		edicto = new Edicto();
		
		edicto.setTitulo(solicitudRequest.getTITULO_ES());
		edicto.setTituloVa(solicitudRequest.getTITULO_VA());
		
		edicto.setDescripcion(solicitudRequest.getDESCRIPCION_ES());
		edicto.setDescripcionVa(solicitudRequest.getDESCRIPCION_VA());
		
		edicto.setNumExp(solicitudRequest.getNUM_EXP());
		
		edicto.setCentro(this.centro);
		edicto.setTipoEdicto(this.tipo);
		if (orgExt != null) {
			edicto.setOrganismoExterno(orgExt);
		}
		edicto.setTipoFirma((TipoFirma) tipoFirmaService.findById(TipoFirma.DOC_FIRMADO));
		
		edicto.setEstado(estadoService.findById(Constantes.INICIADO));
		
		edicto.setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(solicitudRequest.getFECHA_PUBLICACION(), 0));
		
		long milisDiasPublicacion = solicitudRequest.getDIAS_PUBLICACION().longValue() * MILLIS_IN_A_DAY;
		
		edicto.setFechaRetiradaPropuesta(new Date(FechasUtil.convertStringToDate(solicitudRequest.getFECHA_PUBLICACION(), 0).getTime() + milisDiasPublicacion));
		final Date fechaActual = new Date();
		edicto.setFechaUltimaModificacion(fechaActual);
		edicto.setFechaRedaccion(fechaActual);
		edicto.setPublicador(null);
		edicto.setRedactor(usuarioExt);
		
		this.edictoService.save(edicto);
		edicto.setNombrePdfAdjunto(solicitudRequest.getNOMBRE_ADJUNTO());
		try {
			FileService fileService = this.factoryFileServices.getService(edicto);
			String ruta = fileService.guardarBorrador(Base64.decode(solicitudRequest.getDOC_ADJUNTO()), edicto);
			edicto.setPdfAdjunto(ruta);
		} catch (Base64DecodingException e) {
			log.error("Error guardando fichero", e);
		} catch (FileServiceException e) {
			log.error("Error guardando fichero", e);
		}
		this.edictoService.attachDirty(edicto);
		
	}
	
	private TypeError checkPermisos(SolicitudRequest solicitudRequest, TypeError response) throws ServiceException {
		// TODO Auto-generated method stub
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		
		try {
			List<CentroProcedencia> listaCentros = RellenaFormularioActionUtil.RellenaCentrosProcedenciaPorUsuario(organismo.getCif(), usuarioExterno.getUsu());
			System.out.println("area: " + solicitudRequest.getAREA_PROCEDENCIA());
			Boolean permisosOk = false;
			for (CentroProcedencia centro : listaCentros) {
				System.out.println("centro: " + centro.getNombre());
				if (centro.getNombre().equals(solicitudRequest.getAREA_PROCEDENCIA())) {
					permisosOk = true;
					this.centro = centro;
				}
			}
			if (!permisosOk) {
				errores.append(MessageFormat.format(getMensajeValidacion("errors.usuarioPermisos", "es"),
				        new Object[] { usuarioExterno.getUsu(), getMensaje("datosedicto.centroProcedencia", "es") })
				        + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.usuarioPermisos", "va"),
				        new Object[] { usuarioExterno.getUsu(), getMensaje("datosedicto.centroProcedencia", "va") })
				        + "\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			response.setCOD_ERROR(ERROR_GENERAL);
			errores.append(getMensaje("ws.errorGeneral", "es"));
			erroresVa.append(getMensaje("ws.errorGeneral", "va"));
		}
		
		if (errores.length() != 0) {
			if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
				response.setCOD_ERROR(ERROR_USUARIO);
			}
			response.setDESCRIPCION_ES(errores.toString());
			response.setDESCRIPCION_VA(erroresVa.toString());
		}
		
		return response;
	}
	
	private boolean esRedactor(List listaRelaciones) {
		boolean esRedactor = false;
		return !listaRelaciones.isEmpty();
	}
	
	private boolean esPublicador(List listaRelaciones) {
		boolean esPublicador = false;
		Iterator it = listaRelaciones.iterator();
		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
			if (relacionUsuOrgCentroPerf.getPerfil().getIdPerfil() == Constantes.PUBLICADOR) {
				esPublicador = true;
				break;
			}
		}
		return esPublicador;
	}
	
	private TypeError checkPermisosRedactor(SolicitudRequest solicitudRequest, TypeError response) throws ServiceException {
		// TODO Auto-generated method stub
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		
		List listaRelacionUsuOrgPerf = new ArrayList<RelacionUsuOrgCentroPerf>();
		listaRelacionUsuOrgPerf = relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento());
		Boolean permisosOk = esRedactor(listaRelacionUsuOrgPerf);
		
		if (!permisosOk) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.usuarioPermisos", "es"),
			        new Object[] { usuarioExterno.getUsu(), getMensaje("datosedicto.organismo", "es") })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.usuarioPermisos", "va"),
			        new Object[] { usuarioExterno.getUsu(), getMensaje("datosedicto.organismo", "va") })
			        + "\n");
		}
		try {
			List<CentroProcedencia> listaCentros = RellenaFormularioActionUtil.RellenaCentrosProcedencia(organismo.getCif());
			
			permisosOk = false;
			for (CentroProcedencia centro : listaCentros) {
				
				if (centro.getNombre().equals(solicitudRequest.getAREA_PROCEDENCIA())) {
					permisosOk = true;
					this.centro = centro;
				}
			}
			if (!permisosOk) {
				errores.append(MessageFormat.format(getMensajeValidacion("errors.usuarioPermisos", "es"),
				        new Object[] { usuarioExterno.getUsu(), getMensaje("datosedicto.centroProcedencia", "es") })
				        + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.usuarioPermisos", "va"),
				        new Object[] { usuarioExterno.getUsu(), getMensaje("datosedicto.centroProcedencia", "va") })
				        + "\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			response.setCOD_ERROR(ERROR_GENERAL);
			errores.append(getMensaje("ws.errorGeneral", "es"));
			erroresVa.append(getMensaje("ws.errorGeneral", "va"));
		}
		
		if (errores.length() != 0) {
			if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
				response.setCOD_ERROR(ERROR_USUARIO);
			}
			response.setDESCRIPCION_ES(errores.toString());
			response.setDESCRIPCION_VA(erroresVa.toString());
		}
		
		return response;
	}
	
	private TypeError procesarPDF(SolicitudRequest solicitudRequest, TypeError response) {
		// TODO Auto-generated method stub
		try {
			byte[] docAdjunto = Base64.decode(solicitudRequest.getDOC_ADJUNTO());
			PdfReader pdf = new PdfReader(docAdjunto);
			if (pdf.getAcroFields().getSignatureNames().isEmpty()) {
				response.setCOD_ERROR(ERROR_FIRMA_DOC);
				response.setDESCRIPCION_ES(getMensaje("ws.errorFirma", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorFirma", "va"));
			}
		} catch (IOException e) {
			response.setCOD_ERROR(ERROR_FIRMA_DOC);
			response.setDESCRIPCION_ES(getMensaje("ws.errorNoPdf", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorNoPdf", "va"));
		} catch (Base64DecodingException e) {
			response.setCOD_ERROR(ERROR_FIRMA_DOC);
			response.setDESCRIPCION_ES(getMensaje("ws.errorDocBase64", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorDocBase64", "va"));
		}
		
		return response;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.perfiles.externo.ws.PublicacionAnuncioService_PortType
	 * #solicitarPublicacionAnuncio
	 * (es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest)
	 */
	public synchronized es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse solicitarPublicacionAnuncio(
	        es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest solicitudRequest) throws java.rmi.RemoteException {
		log.info("Inicio de solicitud de publicación");
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(solicitudRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("Autenticación correcta");
				response = validateCampos(solicitudRequest, response);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			log.info("Validación de campos correcta");
			response = procesarPDF(solicitudRequest, response);
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("VAlidación de documento PDF correcta");
				response = checkPermisosRedactor(solicitudRequest, response);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				
				response.setCOD_ERROR(ERROR_PERMISOS);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e1);
			}
			
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("VAlidación de permisos de readactor correctos");
				crearEdicto(solicitudRequest);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_GENERAL);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
			log.info("Anuncio Creado");
			response = solicitarPublicacionAnuncio(solicitudRequest, response);
		}
		TypeError[] errors = transformResponse(response);
		String[] idAnuncio = null;
		if (errors == null) {
			log.info("Creación de anuncio correcta");
			idAnuncio = new String[1];
			idAnuncio[0] = String.valueOf(edicto.getIdEdicto());
		}
		return new SolicitarPublicacionResponse(idAnuncio, errors);
	}
	
	/**
	 * Validate campos.
	 * 
	 * @param solicitudRequest
	 *            the solicitud request
	 * @param response
	 *            the response
	 * @return the solicitud response
	 * @throws ServiceException
	 */
	private TypeError validateCampos(SolicitudRequest solicitudRequest, TypeError response) throws ServiceException {
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		if (solicitudRequest.getTITULO_ES().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.titulo", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.titulo", "va") }) + "\n");
		} else if (solicitudRequest.getTITULO_ES().length() >= Constantes.TAM_MAX_TITULO) {
			errores.append(MessageFormat
			        .format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.titulo", "es"), Constantes.TAM_MAX_TITULO }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"),
			        new Object[] { getMensaje("datosedicto.titulo", "va"), Constantes.TAM_MAX_TITULO }) + "\n");
		}
		
		if (solicitudRequest.getTITULO_VA().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.tituloVa", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.tituloVa", "va") }) + "\n");
		} else if (solicitudRequest.getTITULO_VA().length() >= Constantes.TAM_MAX_TITULO) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"),
			        new Object[] { getMensaje("datosedicto.tituloVa", "es"), Constantes.TAM_MAX_TITULO }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.tituloVa", "va"),
			        Constantes.TAM_MAX_TITULO })
			        + "\n");
		}
		
		if (solicitudRequest.getDESCRIPCION_ES().length() >= Constantes.TAM_MAX_TITULO) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.descripcion", "es"),
			        Constantes.TAM_MAX_TITULO })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.descripcion", "va"),
			        Constantes.TAM_MAX_TITULO })
			        + "\n");
		}
		
		if (solicitudRequest.getDESCRIPCION_VA().length() >= Constantes.TAM_MAX_TITULO) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.descripcionVa", "es"),
			        Constantes.TAM_MAX_TITULO })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.descripcionVa", "va"),
			        Constantes.TAM_MAX_TITULO })
			        + "\n");
		}
		
		if (solicitudRequest.getAREA_PROCEDENCIA().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.centroProcedencia", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.centroProcedencia", "va") }) + "\n");
		} else if (solicitudRequest.getAREA_PROCEDENCIA().length() >= Constantes.TAMANIO_MAX_NOMBRE) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.centroProcedencia", "es"),
			        Constantes.TAMANIO_MAX_NOMBRE })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.centroProcedencia", "va"),
			        Constantes.TAMANIO_MAX_NOMBRE })
			        + "\n");
		}
		if (!solicitudRequest.getORGANISMO_EXTERNO().equals("")) {
			if (solicitudRequest.getORGANISMO_EXTERNO().length() >= Constantes.TAMANIO_MAX_NOMBRE) {
				errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.organismoExterno", "es"),
				        Constantes.TAMANIO_MAX_NOMBRE })
				        + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.organismoExterno", "va"),
				        Constantes.TAMANIO_MAX_NOMBRE })
				        + "\n");
			}
			
			try {
				List<OrganismoExterno> listaOrganismosExternos = RellenaFormularioActionUtil.RellenaOrganismosExternos();
				boolean organismoCreado = false;
				for (OrganismoExterno orgExt : listaOrganismosExternos) {
					if (orgExt.getNombre().equals(solicitudRequest.getORGANISMO_EXTERNO())) {
						organismoCreado = true;
						this.orgExt = orgExt;
					}
				}
				if (!organismoCreado) {
					errores.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "es"), new Object[] { getMensaje("datosedicto.organismoExterno", "es") }) + "\n");
					erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "va"), new Object[] { getMensaje("datosedicto.organismoExterno", "va") }) + "\n");
				}
			} catch (DAOException e) {
				e.printStackTrace();
				response.setCOD_ERROR(ERROR_GENERAL);
				errores.append(getMensaje("ws.errorGeneral", "es") + "\n");
				erroresVa.append(getMensaje("ws.errorGeneral", "va") + "\n");
			}
		} else {
			this.orgExt = null;
		}
		if (solicitudRequest.getTIPO_ANUNCIO().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va") }) + "\n");
		} else if (solicitudRequest.getTIPO_ANUNCIO().length() >= Constantes.TAMANIO_MAX_NOMBRE) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es"),
			        Constantes.TAMANIO_MAX_NOMBRE })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va"),
			        Constantes.TAMANIO_MAX_NOMBRE })
			        + "\n");
		} else {
			try {
				List<TipoEdicto> listaTiposEdictos = RellenaFormularioActionUtil.RellenaTiposEdictos(organismo.getCif());
				boolean tipoEdictoExiste = false;
				for (TipoEdicto tipoEdicto : listaTiposEdictos) {
					if (tipoEdicto.getNombre().equals(solicitudRequest.getTIPO_ANUNCIO())) {
						tipoEdictoExiste = true;
						this.tipo = tipoEdicto;
					}
				}
				if (!tipoEdictoExiste) {
					errores.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es") }) + "\n");
					erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va") }) + "\n");
				}
			} catch (DAOException e) {
				e.printStackTrace();
				response.setCOD_ERROR(ERROR_GENERAL);
				errores.append(getMensaje("ws.errorGeneral", "es") + "\n");
				erroresVa.append(getMensaje("ws.errorGeneral", "va") + "\n");
			}
		}
		
		if (solicitudRequest.getNUM_EXP().length() >= Constantes.TAM_MAX_NUMEXP) {
			errores.append(MessageFormat
			        .format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.numExp", "es"), Constantes.TAM_MAX_NUMEXP }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"),
			        new Object[] { getMensaje("datosedicto.numExp", "va"), Constantes.TAM_MAX_NUMEXP }) + "\n");
		}
		
		if (solicitudRequest.getFECHA_PUBLICACION().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.fechaPublicacion", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.fechaPublicacion", "va") }) + "\n");
		} else if ((!ValidatorUtils.validaFecha(solicitudRequest.getFECHA_PUBLICACION(), getMensaje("datosedicto.fechaPublicacion", "es"), true))) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.fecha_formato", "es"), new Object[] { getMensaje("datosedicto.fechaPublicacionPropuesta", "es") })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.fecha_formato", "va"), new Object[] { getMensaje("datosedicto.fechaPublicacionPropuesta", "va") })
			        + "\n");
		} else {
			Date fechaAyer = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
			if (FechasUtil.compareDates(FechasUtil.convertStringToDate(solicitudRequest.getFECHA_PUBLICACION(), 0), fechaAyer)) {
				errores.append(getMensajeValidacion("errors.fecha_actual", "es") + "\n");
				erroresVa.append(getMensajeValidacion("errors.fecha_actual", "va") + "\n");
			}
		}
		
		if (solicitudRequest.getDIAS_PUBLICACION() == null) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va") }) + "\n");
		} else if (solicitudRequest.getDIAS_PUBLICACION().intValue() <= 0) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.diasPublicacion", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.diasPublicacion", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va") }) + "\n");
		}
		
		if (solicitudRequest.getNOMBRE_ADJUNTO().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.nombreAdjunto", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.nombreAdjunto", "va") }) + "\n");
		} else if (solicitudRequest.getNOMBRE_ADJUNTO().length() >= Constantes.TAMANIO_MAX_DESCRIPCION) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.nombreAdjunto", "es"),
			        Constantes.TAMANIO_MAX_DESCRIPCION })
			        + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.nombreAdjunto", "va"),
			        Constantes.TAMANIO_MAX_DESCRIPCION })
			        + "\n");
		}
		
		if (solicitudRequest.getDOC_ADJUNTO() == null) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.docAdjunto", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.docAdjunto", "va") }) + "\n");
		}
		
		if (errores.length() != 0) {
			if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
				response.setCOD_ERROR(ERROR_VALIDACION);
			}
			
			response.setDESCRIPCION_ES(errores.toString());
			response.setDESCRIPCION_VA(erroresVa.toString());
		}
		return response;
	}
	
	private String getMensajeValidacion(String propiedad, String idioma) {
		ResourceBundle res = ResourceBundle.getBundle("resources.validation", getLanguage(idioma));
		String value = null;
		if (propiedad != null) {
			value = res.getString(propiedad);
		}
		return value;
	}
	
	/**
	 * Publicar anuncio.
	 * 
	 * @param solicitudRequest
	 *            the solicitud request
	 * @param response
	 *            the response
	 * @return the solicitud response
	 * @throws ServiceException
	 */
	private TypeError publicarAnuncio(SolicitudRequest solicitudRequest, TypeError response) throws ServiceException {
		
		Edicto resultado = null;
		try {
			
			resultado = UtilPublicar.publicar(edicto);
		} catch (FandangoException e2) {
			response.setCOD_ERROR(ERROR_FANDANGO);
			response.setDESCRIPCION_ES(getMensaje("ws.errorFandango", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorFandango", "va"));
			edictoService.delete(edicto);
			log.error(e2);
		}
		
		if (resultado == null) {
			log.error("No se ha publicado el edicto");
			response.setCOD_ERROR(ERROR_GENERAL);
			response.setDESCRIPCION_ES(getMensaje("ws.errorGeneral", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorGeneral", "va"));
			
		}
		return response;
	}
	
	/**
	 * Check autenticacion. Primero comprueba que el usuario exista como usuario
	 * externo. Luego prueba la contraseña.
	 * 
	 * @param solicitudRequest
	 *            the solicitud request
	 * @param response
	 *            the response
	 * @return the solicitud response
	 */
	private TypeError checkAutenticacion(SolicitudRequest solicitudRequest, TypeError response) {
		// TODO Auto-generated method stubaaaa
		try {
			usuarioExterno = usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			usuarioExt = (Usuario) usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			List resultados = organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
			organismo = null;
			if (!resultados.isEmpty())
				organismo = (Organismo) resultados.get(0);
			
			if (organismo == null || relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento()) == null) {
				response.setCOD_ERROR(ERROR_USUARIO);
				response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
			}
			if (!solicitudRequest.getPASSWORD_USUARIO().equals(usuarioExterno.getPassword())) {
				response.setCOD_ERROR(ERROR_PASSWORD);
				response.setDESCRIPCION_ES(getMensaje("ws.errorPassword", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorPassword", "va"));
			}
		} catch (ServiceException e) {
			response.setCOD_ERROR(ERROR_USUARIO);
			response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
			
		}
		
		return response;
	}
	
	private TypeError checkAutenticacion(CancelarSolicitudRequest solicitudRequest, TypeError response) {
		// TODO Auto-generated method stub
		try {
			usuarioExterno = usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			usuarioExt = (Usuario) usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			organismo = (Organismo) organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO()).get(0);
			
			if (relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento()) == null) {
				response.setCOD_ERROR(ERROR_USUARIO);
				response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
			}
			if (!solicitudRequest.getPASSWORD_USUARIO().equals(usuarioExterno.getPassword())) {
				response.setCOD_ERROR(ERROR_PASSWORD);
				response.setDESCRIPCION_ES(getMensaje("ws.errorPassword", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorPassword", "va"));
			}
		} catch (ServiceException e) {
			response.setCOD_ERROR(ERROR_USUARIO);
			response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
		}
		
		return response;
	}
	
	/**
	 * Solicitar publicacion anuncio.
	 * 
	 * @param solicitudRequest
	 *            the solicitud request
	 * @param response
	 *            the response
	 * @return the solicitud response
	 */
	private TypeError solicitarPublicacionAnuncio(SolicitudRequest solicitudRequest, TypeError response) {
		
		try {
			
			UtilPublicar.notificarSolicitudPublicacion(edicto);
			Estado estado = estadoService.findById(Constantes.PENDIENTE_VALIDACION);
			edicto.setEstado(estado);
			Date fechaActual = new Date();
			edicto.setFechaUltimaModificacion(fechaActual);
			edictoService.attachDirty(edicto);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setCOD_ERROR(ERROR_GENERAL);
			response.setDESCRIPCION_ES(getMensaje("ws.errorGeneral", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorGeneral", "va"));
		}
		
		return response;
	}
	
	private static Locale getLanguage(String idioma) {
		if (idioma.equals("va")) {
			return Constantes.VALENCIANO;
		} else if (idioma.equals("en")) {
			return Constantes.INGLES;
		}
		
		return Constantes.ESPANYOL;
	}
	
	private static String getMensaje(String propiedad, String idioma) {
		ResourceBundle res = ResourceBundle.getBundle("ApplicationResources", getLanguage(idioma));
		String value = null;
		if (propiedad != null) {
			value = res.getString(propiedad);
		}
		return value;
	}
	
	public es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse cancelarSolicitudPublicacionAnuncio(
	        es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudRequest solicitudRequest) throws java.rmi.RemoteException {
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(solicitudRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				response = validateCampos(solicitudRequest, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			response = checkPermisos(solicitudRequest, response);
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			response = cancelarSolicitudPublicacionAnuncio(solicitudRequest, response);
		}
		TypeError[] errors = transformResponse(response);
		String[] idAnuncio = null;
		if (errors == null) {
			idAnuncio = new String[1];
			idAnuncio[0] = "Correcto";
		}
		return new CancelarSolicitudPublicacionResponse(idAnuncio, errors);
	}
	
	private TypeError cancelarSolicitudPublicacionAnuncio(CancelarSolicitudRequest solicitudRequest, TypeError response) {
		
		try {
			edicto = edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			if (edicto != null && edicto.getEstado().getIdEstado() == Constantes.PENDIENTE_VALIDACION) {
				edictoService.delete(edicto);
			} else {
				response.setCOD_ERROR(ANUNCIO_ASIGNADO);
				response.setDESCRIPCION_ES(getMensajeValidacion("errors.anuncioAsignado", "es"));
				response.setDESCRIPCION_VA(getMensajeValidacion("errors.anuncioAsignado", "va"));
			}
			
			log.debug("Correo enviado correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setCOD_ERROR(ERROR_GENERAL);
			response.setDESCRIPCION_ES(getMensaje("ws.errorGeneral", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorGeneral", "va"));
		}
		
		return response;
	}
	
	private TypeError checkPermisos(CancelarSolicitudRequest solicitudRequest, TypeError response) {
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		Boolean permisosOk = false;
		try {
			edicto = edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			Usuario usuario = (Usuario) usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			
			if (edicto.getRedactor().getIdUsuario().equals(usuario.getIdUsuario())) {
				permisosOk = true;
			}
			if (!permisosOk) {
				response.setCOD_ERROR(ANUNCIO_NO_EXISTE);
				errores.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoPermisos", "es"), new Object[] { solicitudRequest.getID_ANUNCIO() }) + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoPermisos", "va"), new Object[] { solicitudRequest.getID_ANUNCIO() }) + "\n");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			response.setCOD_ERROR(ERROR_GENERAL);
			errores.append(getMensaje("ws.errorGeneral", "es"));
			erroresVa.append(getMensaje("ws.errorGeneral", "va"));
		}
		
		if (errores.length() != 0) {
			if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
				response.setCOD_ERROR(ERROR_USUARIO);
			}
			response.setDESCRIPCION_ES(errores.toString());
			response.setDESCRIPCION_VA(erroresVa.toString());
		}
		
		return response;
	}
	
	private TypeError validateCampos(CancelarSolicitudRequest solicitudRequest, TypeError response) throws NumberFormatException, ServiceException {
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		if (solicitudRequest.getID_ANUNCIO().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.id", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.id", "va") }) + "\n");
		} else {
			edicto = edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			if (edicto == null) {
				
				errores.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoEncontrado", "es"), new Object[] { getMensaje("datosedicto.titulo", "es") }) + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoEncontrado", "va"), new Object[] { getMensaje("datosedicto.titulo", "va") }) + "\n");
			}
			
		}
		
		if (errores.length() != 0) {
			if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
				response.setCOD_ERROR(ERROR_VALIDACION);
			}
			
			response.setDESCRIPCION_ES(errores.toString());
			response.setDESCRIPCION_VA(erroresVa.toString());
		}
		return response;
	}
}
