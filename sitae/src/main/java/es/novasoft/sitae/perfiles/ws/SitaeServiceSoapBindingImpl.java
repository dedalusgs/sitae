/**
 * SitaeServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

import java.io.IOException;
import java.math.BigInteger;
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

import afirmaws.services.FirmaUtil;

import com.itextpdf.text.pdf.PdfReader;

import es.novasoft.castellon.vfe.ws.VFEUtil;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.HashUtil;
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
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.business.services.interfaz.TipoFirmaService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.FandangoException;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.ws.fandango.FandangoClient;

public class SitaeServiceSoapBindingImpl implements es.novasoft.sitae.perfiles.ws.SitaeService_PortType {
	
	private static final Log	                  log	                            = LogFactory.getLog(SitaeServiceSoapBindingImpl.class);
	private static final int	                  MILLIS_IN_A_DAY	                = 1000 * 60 * 60 * 24;
	
	/** The SI n_ errores. */
	private static String	                      SIN_ERRORES	                    = "ERR_00";
	
	/** The ERRO r_ general. */
	private static String	                      ERROR_GENERAL	                    = "ERR_01";
	
	/** The ERRO r_ bbdd. */
	private static String	                      ERROR_BBDD	                    = "ERR_02";
	
	/** The ERRO r_ usuario. */
	private static String	                      ERROR_USUARIO	                    = "ERR_03";
	
	/** The ERRO r_ password. */
	private static String	                      ERROR_PASSWORD	                = "ERR_04";
	
	/** The ERRO r_ validacion. */
	private static String	                      ERROR_VALIDACION	                = "ERR_05";
	
	/** The ERRO r_ firm a_ doc. */
	private static String	                      ERROR_FIRMA_DOC	                = "ERR_06";
	
	/** The ER r_ permisos. */
	private static String	                      ERROR_PERMISOS	                = "ERR_07";
	
	/** The ER r_ fandango. */
	private static String	                      ERROR_FANDANGO	                = "ERR_08";
	
	private static String	                      ANUNCIO_NO_EXISTE	                = "ERR_09";
	
	private static final String	                  ANUNCIO_ASIGNADO	                = "ERR_10";
	
	/** The edicto service. */
	private final EdictoService	                  edictoService	                    = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	/** The centro procedencia service. */
	private final CentroProcedenciaService	      centroProcedenciaService	        = (CentroProcedenciaService) Factory
	                                                                                        .getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	/** The tipo edicto service. */
	private final TipoEdictoService	              tipoEdictoService	                = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
	
	/** The estado service. */
	private final EstadoService	                  estadoService	                    = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	/** The usuario service. */
	private final UsuarioService	              usuarioService	                = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	/** The usuario firmante service. */
	private final UsuarioExternoService	          usuarioExternoService	            = (UsuarioExternoService) Factory.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
	
	/** The organismo service. */
	private final OrganismoService	              organismoService	                = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	/** The tipo firma service. */
	private final TipoFirmaService	              tipoFirmaService	                = (TipoFirmaService) Factory.getBean(ServiceConstants.TIPO_FIRMA_BEAN_NAME);
	
	/** The relacion usu org centro perf service. */
	private final RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory
	                                                                                        .getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	/** The organismo externo service. */
	private final OrganismoExternoService	      organismoExternoService	        = (OrganismoExternoService) Factory
	                                                                                        .getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
	
	private final FestivoService	              festivoService	                = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	
	FactoryFileService	                          factoryFileServices	            = (FactoryFileService) Factory.getBean("FactoryFileServices");
	
	public synchronized es.novasoft.sitae.perfiles.ws.PublicarResponse publicarAnuncio(es.novasoft.sitae.perfiles.ws.SolicitudRequest publicarRequest)
	        throws java.rmi.RemoteException {
		log.info("Inicio Publicación anuncioWS");
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(publicarRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("Autenticacion Correcta");
				response = validateCampos(publicarRequest, response);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			log.info("Validacion de campos correcta");
			response = procesarPDF(publicarRequest, response);
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			log.info("Documento PDF correcto");
			try {
				response = checkPermisos(publicarRequest, response);
			} catch (ServiceException e) {
				
				response.setCOD_ERROR(ERROR_PERMISOS);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		Edicto anuncio = null;
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("Permisos para la publicacion correctos");
				anuncio = crearEdicto(publicarRequest);
			} catch (ServiceException e) {
				
				response.setCOD_ERROR(ERROR_GENERAL);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
			try {
				response = publicarAnuncio(publicarRequest, response, anuncio);
			} catch (ServiceException e) {
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
				response.setCOD_ERROR(ERROR_GENERAL);
			}
		}
		TypeError[] errors = transformResponse(response);
		String idAnuncio = null;
		RespuestaSolicitudPubli respuesta = null;
		if (errors == null) {
			log.info("Publicacion de anuncio correcta");
			
			respuesta = new RespuestaSolicitudPubli();
			respuesta.setID_ANUNCIO(anuncio.getIdEdicto().toString());
			respuesta.setFECHA_INICIO(anuncio.getFechaPublicacionPropuesta());
			respuesta.setFECHA_FIN(anuncio.getFechaRetiradaPropuesta());
		}
		
		return new PublicarResponse(respuesta, errors);
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
	
	private Edicto crearEdicto(SolicitudRequest solicitudRequest) throws ServiceException {
		// TODO Auto-generated method stub
		log.info("Creando Anuncio en Borrador");
		UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
		Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
		List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
		Organismo organismo = null;
		if (!resultados.isEmpty()) {
			organismo = (Organismo) resultados.get(0);
		}
		
		Edicto edi = new Edicto();
		
		edi.setTitulo(solicitudRequest.getTITULO_ES());
		edi.setTituloVa(solicitudRequest.getTITULO_VA());
		edi.setRedesSociales(solicitudRequest.getREDES_SOCIALES());
		edi.setListaCorreo(solicitudRequest.getLISTA_CORREO());
		edi.setDescripcion(solicitudRequest.getDESCRIPCION_ES());
		edi.setDescripcionVa(solicitudRequest.getDESCRIPCION_VA());
		
		edi.setNumExp(solicitudRequest.getNUM_EXP());
		
		edi.setCentro((CentroProcedencia) this.centroProcedenciaService.findByNombreCif(solicitudRequest.getAREA_PROCEDENCIA(), organismo.getCif()).get(0));
		edi.setTipoEdicto((TipoEdicto) this.tipoEdictoService.findByNombre(solicitudRequest.getTIPO_ANUNCIO()).get(0));
		if (solicitudRequest.getORGANISMO_EXTERNO() != null && !solicitudRequest.getORGANISMO_EXTERNO().equals("")) {
			edi.setOrganismoExterno((OrganismoExterno) this.organismoExternoService.findByNombre(solicitudRequest.getORGANISMO_EXTERNO()).get(0));
		}
		edi.setTipoFirma(this.tipoFirmaService.findById(TipoFirma.DOC_FIRMADO));
		
		edi.setEstado(this.estadoService.findById(Constantes.INICIADO));
		
		long milisDiasPublicacion = solicitudRequest.getDIAS_PUBLICACION().longValue() * MILLIS_IN_A_DAY;
		edi.setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(solicitudRequest.getFECHA_PUBLICACION(), 0));
		edi.setDiasExposicion(solicitudRequest.getDIAS_PUBLICACION().intValue());
		final Date fechaActual = new Date();
		edi.setFechaUltimaModificacion(fechaActual);
		edi.setFechaRedaccion(fechaActual);
		edi.setPublicador(null);
		edi.setOrganismo(organismo);
		edi.setRedactor(usuarioExt);
		edi.setNombrePdfAdjunto(solicitudRequest.getNOMBRE_ADJUNTO());
		edi.setTipoExposicion(solicitudRequest.getTIPO_CONT_DIAS());
		Date fechaRetirada = this.festivoService.obtenerFechaFinPublicacion(edi.getFechaPublicacionPropuesta(), edi.getOrganismo(), edi.getDiasExposicion(),
		        edi.getTipoExposicion());
		edi.setFechaRetiradaPropuesta(fechaRetirada);
		log.info("Guardado previo Anuncio en Borrador");
		this.edictoService.save(edi);
		edi.setNombrePdfAdjunto(solicitudRequest.getNOMBRE_ADJUNTO());
		try {
			FileService fileService = this.factoryFileServices.getService(edi);
			String ruta = fileService.guardarBorrador(Base64.decode(solicitudRequest.getDOC_ADJUNTO()), edi);
			edi.setPdfAdjunto(ruta);
		} catch (Base64DecodingException e) {
			log.error("Error guardando fichero", e);
		} catch (FileServiceException e) {
			log.error("Error guardando fichero", e);
		}
		this.edictoService.attachDirty(edi);
		log.info("Guardado final borrador ");
		return edi;
	}
	
	private TypeError checkPermisos(SolicitudRequest solicitudRequest, TypeError response) throws ServiceException {
		// TODO Auto-generated method stub
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
		Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
		List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
		Organismo organismo = null;
		if (!resultados.isEmpty()) {
			organismo = (Organismo) resultados.get(0);
		}
		try {
			List<CentroProcedencia> listaCentros = RellenaFormularioActionUtil.RellenaCentrosProcedenciaPorUsuario(organismo.getCif(), usuarioExterno.getUsu());
			System.out.println("area: " + solicitudRequest.getAREA_PROCEDENCIA());
			Boolean permisosOk = false;
			for (CentroProcedencia centro : listaCentros) {
				System.out.println("centro: " + centro.getNombre());
				if (centro.getNombre().equals(solicitudRequest.getAREA_PROCEDENCIA())) {
					permisosOk = true;
					
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
		UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
		Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
		List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
		Organismo organismo = null;
		if (!resultados.isEmpty()) {
			organismo = (Organismo) resultados.get(0);
		}
		List listaRelacionUsuOrgPerf = new ArrayList<RelacionUsuOrgCentroPerf>();
		listaRelacionUsuOrgPerf = this.relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento());
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
		UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
		Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
		List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
		Organismo organismo = null;
		if (!resultados.isEmpty()) {
			organismo = (Organismo) resultados.get(0);
		}
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
		} else {
			try {
				boolean tipoEdictoExiste = false;
				// Integer idTipo =
				// Integer.parseInt(solicitudRequest.getAREA_PROCEDENCIA());
				List lista = this.centroProcedenciaService.findByNombreCif(solicitudRequest.getAREA_PROCEDENCIA(), organismo.getCif());
				CentroProcedencia tipo = null;
				if (lista != null && !lista.isEmpty()) {
					tipo = (CentroProcedencia) lista.get(0);
				}
				
				if (tipo != null) {
					tipoEdictoExiste = true;
				}
				
				if (!tipoEdictoExiste) {
					errores.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "es"), new Object[] { getMensaje("datosedicto.centroProcedencia", "es") }) + "\n");
					erroresVa
					        .append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "va"), new Object[] { getMensaje("datosedicto.centroProcedencia", "va") }) + "\n");
				}
			} catch (ServiceException e) {
				e.printStackTrace();
				response.setCOD_ERROR(ERROR_GENERAL);
				errores.append(getMensaje("ws.errorGeneral", "es") + "\n");
				erroresVa.append(getMensaje("ws.errorGeneral", "va") + "\n");
			} catch (NumberFormatException e) {
				errores.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "es"), new Object[] { getMensaje("datosedicto.centroProcedencia", "es") }) + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "va"), new Object[] { getMensaje("datosedicto.centroProcedencia", "va") }) + "\n");
			}
		}
		
		if (!solicitudRequest.getORGANISMO_EXTERNO().equals("")) {
			if (solicitudRequest.getORGANISMO_EXTERNO().length() >= Constantes.TAMANIO_MAX_NOMBRE) {
				errores.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "es"), new Object[] { getMensaje("datosedicto.organismoExterno", "es"),
				        Constantes.TAMANIO_MAX_NOMBRE })
				        + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.maxlength2", "va"), new Object[] { getMensaje("datosedicto.ismoExterno", "va"),
				        Constantes.TAMANIO_MAX_NOMBRE })
				        + "\n");
			}
			
			try {
				
				List<OrganismoExterno> listaOrganismosExternos = RellenaFormularioActionUtil.RellenaOrganismosExternos();
				boolean organismoCreado = false;
				for (OrganismoExterno orgExt : listaOrganismosExternos) {
					if (orgExt.getNombre().equals(solicitudRequest.getORGANISMO_EXTERNO())) {
						organismoCreado = true;
						
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
				boolean tipoEdictoExiste = false;
				// Integer idTipo =
				// Integer.parseInt(solicitudRequest.getTIPO_ANUNCIO());
				TipoEdicto tipo = null;
				List lista = this.tipoEdictoService.findByNombre(solicitudRequest.getTIPO_ANUNCIO());
				if (lista != null && !lista.isEmpty()) {
					tipo = (TipoEdicto) lista.get(0);
				}
				
				if (tipo != null) {
					tipoEdictoExiste = true;
				}
				
				if (!tipoEdictoExiste) {
					errores.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es") }) + "\n");
					erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va") }) + "\n");
				}
			} catch (ServiceException e) {
				e.printStackTrace();
				response.setCOD_ERROR(ERROR_GENERAL);
				errores.append(getMensaje("ws.errorGeneral", "es") + "\n");
				erroresVa.append(getMensaje("ws.errorGeneral", "va") + "\n");
			} catch (NumberFormatException e) {
				errores.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "es"), new Object[] { getMensaje("datosedicto.tipoEdicto", "es") }) + "\n");
				erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.noExiste", "va"), new Object[] { getMensaje("datosedicto.tipoEdicto", "va") }) + "\n");
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
		
		if (solicitudRequest.getTIPO_CONT_DIAS() == null) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.tipoPublicacion", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.tipoPublicacion", "va") }) + "\n");
		} else if (!solicitudRequest.getTIPO_CONT_DIAS().equals("LAB") && !solicitudRequest.getTIPO_CONT_DIAS().equals("NAT")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.tipoPublicacion", "es"), new Object[] { getMensaje("datosedicto.tipoPublicacion", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.tipoPublicacion", "va"), new Object[] { getMensaje("datosedicto.tipoPublicacion", "va") }) + "\n");
		}
		if (solicitudRequest.getREDES_SOCIALES() == null) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("redesSociales.tituloGestion", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("redesSociales.tituloGestion", "va") }) + "\n");
		} else if (!solicitudRequest.getREDES_SOCIALES().equals("SI") && !solicitudRequest.getREDES_SOCIALES().equals("NO")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.yesno", "es"), new Object[] { getMensaje("redesSociales.tituloGestion", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.yesno", "va"), new Object[] { getMensaje("redesSociales.tituloGestion", "va") }) + "\n");
		}
		if (solicitudRequest.getLISTA_CORREO() == null) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("listaCorreo.titulo", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("listaCorreo.titulo", "va") }) + "\n");
		} else if (!solicitudRequest.getLISTA_CORREO().equals("SI") && !solicitudRequest.getLISTA_CORREO().equals("NO")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.yesno", "es"), new Object[] { getMensaje("listaCorreo.titulo", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.yesno", "va"), new Object[] { getMensaje("listaCorreo.titulo", "va") }) + "\n");
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
	private TypeError publicarAnuncio(SolicitudRequest solicitudRequest, TypeError response, Edicto anuncio) throws ServiceException {
		
		Edicto resultado = null;
		try {
			Estado estado = estadoService.findById(Constantes.PENDIENTE_PUBLICACION);
			anuncio.setPublicador(anuncio.getRedactor());
			String validacion = null;
			resultado = UtilPublicar.publicar(anuncio);
			
			if (resultado.getEstado().getIdEstado().equals(estado.getIdEstado())) {
				validacion = FirmaUtil.validarDocumentoPADES(solicitudRequest.getDOC_ADJUNTO(), anuncio.getFechaPublicacionPropuesta());
				if (!validacion.equals("OK")) {
					response.setCOD_ERROR(ERROR_FANDANGO);
					response.setDESCRIPCION_ES(validacion);
					response.setDESCRIPCION_VA(validacion);
					edictoService.delete(anuncio);
				}
				
			}
		} catch (FandangoException e2) {
			response.setCOD_ERROR(ERROR_FANDANGO);
			response.setDESCRIPCION_ES(getMensaje("ws.errorFandango", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorFandango", "va"));
			edictoService.delete(anuncio);
			log.error(e2);
			return response;
		}
		
		if (resultado == null) {
			log.error("No se ha publicado el edicto");
			response.setCOD_ERROR(ERROR_GENERAL);
			response.setDESCRIPCION_ES(getMensaje("ws.errorGeneral", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorGeneral", "va"));
			edictoService.delete(anuncio);
		}
		
		return response;
		
	}
	
	/**
	 * Check autenticacion. Primero comprueba que el usuario exista como usuario
	 * externo. Luego prueba la contraseÃƒÆ’Ã‚Â±a.
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
			UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
			Organismo organismo = null;
			if (!resultados.isEmpty()) {
				organismo = (Organismo) resultados.get(0);
			}
			
			if (organismo == null || this.relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento()) == null) {
				response.setCOD_ERROR(ERROR_USUARIO);
				response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
			}
			if (!HashUtil.validarHashSHA1(solicitudRequest.getPASSWORD_USUARIO(), usuarioExterno.getPassword())) {
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
			UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
			Organismo organismo = null;
			if (!resultados.isEmpty()) {
				organismo = (Organismo) resultados.get(0);
			}
			if (organismo == null || this.relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento()) == null) {
				response.setCOD_ERROR(ERROR_USUARIO);
				response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
			}
			if (!HashUtil.validarHashSHA1(solicitudRequest.getPASSWORD_USUARIO(), usuarioExterno.getPassword())) {
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
	private TypeError solicitarPublicacionAnuncio(SolicitudRequest solicitudRequest, TypeError response, Edicto anuncio) {
		
		try {
			
			UtilPublicar.notificarSolicitudPublicacion(anuncio);
			Estado estado = this.estadoService.findById(Constantes.PENDIENTE_VALIDACION);
			anuncio.setEstado(estado);
			Date fechaActual = new Date();
			anuncio.setFechaUltimaModificacion(fechaActual);
			this.edictoService.attachDirty(anuncio);
			
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
	
	public es.novasoft.sitae.perfiles.ws.SolicitarPublicacionResponse solicitarPublicacionAnuncio(es.novasoft.sitae.perfiles.ws.SolicitudRequest solicitarPublicacionRequest)
	        throws java.rmi.RemoteException {
		log.info("Inicio de solicitud de publicación");
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(solicitarPublicacionRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("Autenticación correcta");
				response = validateCampos(solicitarPublicacionRequest, response);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			log.info("Validación de campos correcta");
			response = procesarPDF(solicitarPublicacionRequest, response);
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("VAlidación de documento PDF correcta");
				response = checkPermisosRedactor(solicitarPublicacionRequest, response);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				
				response.setCOD_ERROR(ERROR_PERMISOS);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e1);
			}
			
		}
		Edicto anuncio = null;
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				log.info("VAlidación de permisos de readactor correctos");
				anuncio = crearEdicto(solicitarPublicacionRequest);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				response.setCOD_ERROR(ERROR_GENERAL);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
			log.info("Anuncio Creado");
			response = solicitarPublicacionAnuncio(solicitarPublicacionRequest, response, anuncio);
		}
		TypeError[] errors = transformResponse(response);
		String[] idAnuncio = null;
		RespuestaSolicitudPubli respuesta = null;
		if (errors == null) {
			log.info("CreaciÃ³n de anuncio correcta");
			respuesta = new RespuestaSolicitudPubli();
			respuesta.setID_ANUNCIO(anuncio.getIdEdicto().toString());
			respuesta.setFECHA_INICIO(anuncio.getFechaPublicacionPropuesta());
			respuesta.setFECHA_FIN(anuncio.getFechaRetiradaPropuesta());
			
		}
		return new SolicitarPublicacionResponse(respuesta, errors);
	}
	
	public es.novasoft.sitae.perfiles.ws.CancelarSolicitudPublicacionResponse cancelarSolicitudPublicacionAnuncio(
	        es.novasoft.sitae.perfiles.ws.CancelarSolicitudRequest cancelarSolicitudPublicacionRequest) throws java.rmi.RemoteException {
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(cancelarSolicitudPublicacionRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				response = validateCampos(cancelarSolicitudPublicacionRequest, response);
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
			response = checkPermisos(cancelarSolicitudPublicacionRequest, response);
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			response = cancelarSolicitudPublicacionAnuncio(cancelarSolicitudPublicacionRequest, response);
		}
		TypeError[] errors = transformResponse(response);
		String idAnuncio = null;
		if (errors == null) {
			idAnuncio = "Correcto";
		} else {
			idAnuncio = "Error";
		}
		return new CancelarSolicitudPublicacionResponse(idAnuncio, errors);
	}
	
	private TypeError cancelarSolicitudPublicacionAnuncio(CancelarSolicitudRequest solicitudRequest, TypeError response) {
		
		try {
			Edicto edicto = this.edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			if (edicto != null && edicto.getEstado().getIdEstado() == Constantes.PENDIENTE_VALIDACION) {
				this.edictoService.delete(edicto);
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
			UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			
			Edicto edicto = this.edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			Usuario usuario = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			
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
		Edicto edicto = null;
		if (solicitudRequest.getID_ANUNCIO().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.id", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.id", "va") }) + "\n");
		} else {
			edicto = this.edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
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
	
	public es.novasoft.sitae.perfiles.ws.ConsultarAnuncioResponse consultarAnuncio(es.novasoft.sitae.perfiles.ws.ConsultarAnuncioRequest consultarRequest)
	        throws java.rmi.RemoteException {
		log.info("Comienzo de Consultar Anuncio");
		TypeError response = new TypeError();
		response.setCOD_ERROR(SIN_ERRORES);
		response.setDESCRIPCION_ES(getMensaje("ws.sinErrores", "es"));
		response.setDESCRIPCION_VA(getMensaje("ws.sinErrores", "va"));
		
		response = checkAutenticacion(consultarRequest, response);
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			try {
				response = validateCampos(consultarRequest, response);
			} catch (NumberFormatException e) {
				
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			} catch (ServiceException e) {
				
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
			}
		}
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			response = checkPermisos(consultarRequest, response);
		}
		InfoAnuncio anuncio = null;
		if (response.getCOD_ERROR().equals(SIN_ERRORES)) {
			anuncio = consultarAnuncio(consultarRequest, response);
		}
		
		TypeError[] errors = transformResponse(response);
		
		return new ConsultarAnuncioResponse(anuncio, errors);
	}
	
	/**
	 * Check autenticacion. Primero comprueba que el usuario exista como usuario
	 * externo. Luego prueba la contraseÃƒÆ’Ã‚Â±a.
	 *
	 * @param solicitudRequest
	 *            the solicitud request
	 * @param response
	 *            the response
	 * @return the solicitud response
	 */
	private TypeError checkAutenticacion(ConsultarAnuncioRequest solicitudRequest, TypeError response) {
		
		try {
			UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
			Organismo organismo = null;
			if (!resultados.isEmpty()) {
				organismo = (Organismo) resultados.get(0);
			}
			
			if (organismo == null || this.relacionUsuOrgCentroPerfService.findByCifDni(organismo.getCif(), usuarioExt.getNumDocumento()) == null) {
				response.setCOD_ERROR(ERROR_USUARIO);
				response.setDESCRIPCION_ES(getMensaje("ws.errorUsuario", "es"));
				response.setDESCRIPCION_VA(getMensaje("ws.errorUsuario", "va"));
			}
			Boolean passwordCorrecta = HashUtil.validarHashSHA1(solicitudRequest.getPASSWORD_USUARIO(), usuarioExterno.getPassword());
			if (!passwordCorrecta) {
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
	
	private TypeError checkPermisos(ConsultarAnuncioRequest solicitudRequest, TypeError response) {
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		Boolean permisosOk = false;
		Edicto edicto = null;
		try {
			UsuarioExterno usuarioExterno = this.usuarioExternoService.findFromUser(solicitudRequest.getNOMBRE_USUARIO());
			Usuario usuarioExt = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
			List resultados = this.organismoService.findByCodigo(solicitudRequest.getCOD_ORGANISMO());
			Organismo organismo = null;
			if (!resultados.isEmpty()) {
				organismo = (Organismo) resultados.get(0);
			}
			if (solicitudRequest.getCOD_ANUNCIO() != null || solicitudRequest.getID_ANUNCIO() != null) {
				if (solicitudRequest.getID_ANUNCIO() != null) {
					edicto = this.edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
				} else {
					List<Edicto> resultado = this.edictoService.findByCodigo(solicitudRequest.getCOD_ANUNCIO());
					if (resultado != null && !resultado.isEmpty()) {
						edicto = resultado.get(0);
					} else {
						edicto = null;
					}
				}
				if (edicto == null) {
					response.setCOD_ERROR(ANUNCIO_NO_EXISTE);
					errores.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoEncontrado", "es"), new Object[] { solicitudRequest.getID_ANUNCIO() }) + "\n");
					erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoEncontrado", "va"), new Object[] { solicitudRequest.getID_ANUNCIO() }) + "\n");
				} else {
					
				}
				
				Usuario usuario = (Usuario) this.usuarioService.findByNumeroDocumento(usuarioExterno.getUsu()).get(0);
				
				if (!edicto.getRedactor().getIdUsuario().equals(usuario.getIdUsuario())) {
					response.setCOD_ERROR(ERROR_PERMISOS);
					errores.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoPermisos", "es"), new Object[] { solicitudRequest.getID_ANUNCIO() }) + "\n");
					erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.anuncioNoPermisos", "va"), new Object[] { solicitudRequest.getID_ANUNCIO() }) + "\n");
				}
				
			} else {
				response.setCOD_ERROR(ERROR_VALIDACION);
				log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES());
			}
		} catch (ServiceException e) {
			
			response.setCOD_ERROR(ERROR_GENERAL);
			errores.append(getMensaje("ws.errorGeneral", "es"));
			erroresVa.append(getMensaje("ws.errorGeneral", "va"));
		} catch (NumberFormatException e) {
			response.setCOD_ERROR(ERROR_VALIDACION);
			log.error(response.getCOD_ERROR() + " " + response.getDESCRIPCION_ES(), e);
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
	
	private TypeError validateCampos(ConsultarAnuncioRequest solicitudRequest, TypeError response) throws NumberFormatException, ServiceException {
		StringBuffer errores = new StringBuffer();
		StringBuffer erroresVa = new StringBuffer();
		Edicto edicto = null;
		if (solicitudRequest.getID_ANUNCIO().equals("") && solicitudRequest.getCOD_ANUNCIO().equals("")) {
			errores.append(MessageFormat.format(getMensajeValidacion("errors.required", "es"), new Object[] { getMensaje("datosedicto.id", "es") }) + "\n");
			erroresVa.append(MessageFormat.format(getMensajeValidacion("errors.required", "va"), new Object[] { getMensaje("datosedicto.id", "va") }) + "\n");
		} else {
			if (solicitudRequest.getID_ANUNCIO() != null) {
				edicto = this.edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			} else {
				List<Edicto> resultado = this.edictoService.findByCodigo(solicitudRequest.getCOD_ANUNCIO());
				if (resultado != null && !resultado.isEmpty()) {
					edicto = resultado.get(0);
				} else {
					edicto = null;
				}
			}
			
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
	
	private InfoAnuncio consultarAnuncio(ConsultarAnuncioRequest solicitudRequest, TypeError response) {
		InfoAnuncio infoAnuncio = null;
		try {
			Edicto edicto = null;
			if (solicitudRequest.getID_ANUNCIO() != null) {
				edicto = this.edictoService.findById(Integer.valueOf(solicitudRequest.getID_ANUNCIO()));
			} else {
				List<Edicto> resultado = this.edictoService.findByCodigo(solicitudRequest.getCOD_ANUNCIO());
				if (resultado != null && !resultado.isEmpty()) {
					edicto = resultado.get(0);
				} else {
					edicto = null;
				}
			}
			log.info("Obteniendo informaci�n de Anuncio");
			log.debug("Obteniendo datos b�sicos de Anuncio");
			infoAnuncio = new InfoAnuncio();
			infoAnuncio.setCOD_ANUNCIO(edicto.getCodigo());
			infoAnuncio.setID_ANUNCIO(edicto.getIdEdicto().toString());
			infoAnuncio.setAREA_PROCEDENCIA(edicto.getCentro().getNombre());
			infoAnuncio.setCOD_ORGANISMO(edicto.getOrganismo().getCodigo());
			infoAnuncio.setTIPO_ANUNCIO(edicto.getTipoEdicto().getNombre());
			
			infoAnuncio.setTITULO_ES(edicto.getTitulo());
			infoAnuncio.setTITULO_VA(edicto.getTituloVa());
			infoAnuncio.setDESCRIPCION_ES(edicto.getDescripcion());
			infoAnuncio.setDESCRIPCION_VA(edicto.getDescripcionVa());
			infoAnuncio.setDIAS_PUBLICACION(new BigInteger(edicto.getDiasExposicion().toString()));
			if (edicto.getOrganismoExterno() != null) {
				infoAnuncio.setORGANISMO_EXTERNO(edicto.getOrganismoExterno().getNombre());
			}
			infoAnuncio.setREDES_SOCIALES(edicto.getRedesSociales());
			infoAnuncio.setLISTA_CORREO(edicto.getRedesSociales());
			infoAnuncio.setNUM_EXP(edicto.getNumExp());
			infoAnuncio.setFECHA_PUBLICACON_ESTIMADA(edicto.getFechaPublicacionPropuesta());
			infoAnuncio.setFECHA_RETIRADA_ESTIMADA(edicto.getFechaRetiradaPropuesta());
			infoAnuncio.setNOMBRE_DOC_ANUNCIO("");
			infoAnuncio.setANUNCIO_FICHERO("");
			infoAnuncio.setTIPO_CONT_DIAS(edicto.getTipoExposicion());
			infoAnuncio.setESTADO(edicto.getEstado().getNombre());
			
			if (edicto.getOrganismoExterno() != null) {
				infoAnuncio.setORGANISMO_EXTERNO(edicto.getOrganismoExterno().getNombre());
			}
			log.debug("Obteniendo documento Anuncio");
			if (edicto.getPdfAdjunto() != null) {
				FileService fileService = this.factoryFileServices.getService(edicto);
				
				byte[] documento = fileService.obtenerFichero(edicto.getPdfAdjuntoString());
				
				if (documento != null) {
					infoAnuncio.setANUNCIO_FICHERO(Base64.encode(documento));
					infoAnuncio.setNOMBRE_DOC_ANUNCIO("anuncio-" + edicto.getCodigo() + ".pdf");
				}
			}
			
			if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO || edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {
				infoAnuncio.setFECHA_PUBLICACION(edicto.getFechaPublicacion());
				log.debug("Obteniendo documento certificacion fandango");
				FandangoClient client = (FandangoClient) Factory.getBean(ServiceConstants.FANDANGO_BEAN_NAME);
				String certificadoPublicacion = "";
				try {
					
					certificadoPublicacion = client.getPDFCertificado(edicto.getUrl());
					log.debug("certificado: " + certificadoPublicacion);
				} catch (Exception e) {
					certificadoPublicacion = "";
					log.error("Se ha producido un error obteniendo certificado de publicacion", e);
				}
				if (!certificadoPublicacion.equals("")) {
					infoAnuncio.setCERTIFICADO_PUBLICACION_FICHERO(certificadoPublicacion);
					infoAnuncio.setNOMBRE_CERTIFICADO_PUBLICACION("certificado-" + edicto.getCodigo() + ".pdf");
				}
			}
			
			if (edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {
				infoAnuncio.setFECHA_RETIRADA(edicto.getFechaRetirada());
				log.debug("Obteniendo documento Diligencia");
				FileService fileService = this.factoryFileServices.getService(edicto);
				
				byte[] documento = VFEUtil.obtenerDiligenciaConPie(edicto);
				
				if (documento != null) {
					infoAnuncio.setDILIGENCIA_FICHERO(Base64.encode(documento));
					infoAnuncio.setNOMBRE_DILIGENCIA_ANUNCIO("diligencia-" + edicto.getCodigo() + ".pdf");
				}
				log.debug("Obteniendo documento Firma Diligencia");
				
				byte[] documentoFirma = fileService.obtenerFichero(edicto.getFirmaDiligenciaString());
				
				if (documentoFirma != null) {
					infoAnuncio.setFIRMA_DILIGENCIA_FICHERO(new String(Base64.encode(documentoFirma)));
					infoAnuncio.setNOMBRE_FIRMA_DILIGENCIA("Firmadiligencia-" + edicto.getCodigo() + ".xml");
				}
				
			}
			
			// if (edicto != null && edicto.getEstado().getIdEstado()
			// == Constantes.PENDIENTE_VALIDACION) {
			// edictoService.delete(edicto);
			// } else {
			// response.setCOD_ERROR(ANUNCIO_ASIGNADO);
			// response.setDESCRIPCION_ES(getMensajeValidacion("errors.anuncioAsignado",
			// "es"));
			// response.setDESCRIPCION_VA(getMensajeValidacion("errors.anuncioAsignado",
			// "va"));
			// }
			
			log.info("Fin Obteniendo información de Anuncio");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error obteniendo info de anuncio", e);
			response.setCOD_ERROR(ERROR_GENERAL);
			response.setDESCRIPCION_ES(getMensaje("ws.errorGeneral", "es"));
			response.setDESCRIPCION_VA(getMensaje("ws.errorGeneral", "va"));
		}
		
		return infoAnuncio;
	}
}
