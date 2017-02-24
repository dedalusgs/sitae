package es.novasoft.sitae.business.services.impl;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.bouncycastle.util.encoders.Base64;

import alfresco.sigex.castellon.ContentDocument;
import alfresco.sigex.castellon.ContentDocumentRequest;
import alfresco.sigex.castellon.ContentDocumentResponse;
import alfresco.sigex.castellon.CreationDocumentUUIDResponse;
import alfresco.sigex.castellon.DocumentUuid;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import alfresco.sigex.castellon.Metadata;
import alfresco.sigex.castellon.SearchResponse;
import alfresco.sigex.castellon.Signer;

import com.cv.xaloc.muleRD.interfaces.tramitacionMuleRD;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.SHA1;
import es.novasoft.sitae.business.dao.interfaz.EdictoDAO;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.objects.TipoFirma;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDL;
import es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDLServiceLocator;

public class EdictoAlfrescoServiceImpl implements EdictoService {
	
	private static Log	log	= LogFactory.getFactory().getInstance(CentroProcedenciaServiceImpl.class);
	
	private EdictoDAO	edictoDAO;
	
	public EdictoDAO getEdictoDao() {
		return this.edictoDAO;
	}
	
	public void setEdictoDAO(EdictoDAO edictoDAO) {
		this.edictoDAO = edictoDAO;
	}
	
	public void save(Edicto transientInstance) throws ServiceException {
		log.info("save Edicto ALFRESCO");
		try {
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS alfrescoWS = locator.getIMuleRDWSPort(new URL(endpoint));
			ContentDocumentRequest contentDocumentRequest = new ContentDocumentRequest();
			contentDocumentRequest.setMimeType("pdf");
			contentDocumentRequest.setName(transientInstance.getNombrePdfAdjunto());
			contentDocumentRequest.setContent(Base64.encode(transientInstance.getPdfAdjunto()));
			
			Signer[] arrayOfSigners = new Signer[0];
			if (transientInstance.getTipoFirma().getIdTipoFirma() == TipoFirma.STAMP_SERVICE) {
				log.debug("Firmando con sello de organo");
				ContentDocumentRequest contentDocumentRequest2 = firmarServidorSello(transientInstance);
				if (contentDocumentRequest2.getContent() == null) {
					throw new ServiceException("No se ha firmado correctamente con la firma de Sello");
				}
				Signer signer = new Signer();
				String firmaSello = contentDocumentRequest2.getArrayOfMetadata(0).getValue();
				ContentDocument contentDocument = new ContentDocument();
				contentDocument.setContent(Base64.encode(firmaSello.getBytes()));
				contentDocument.setName("Firma-" + contentDocumentRequest2.getName() + ".xml");
				contentDocument.setMimeType("text/xml");
				signer.setContent(contentDocument);
				signer.setName("Sello de Organo de " + transientInstance.getOrganismo().getNombre());
				signer.setType("CLIENTE");
				signer.setAnagram("CLIENTE");
				signer.setNif(transientInstance.getOrganismo().getCif());
				signer.setJob("-");
				signer.setDate(FechasUtil.convertDateToString(Calendar.getInstance().getTime(), 0));
				signer.setIdAplication("generalitat.entidadesLocales");
				signer.setServer("ACCV");
				signer.setIdTransaction("-");
				SHA1 s = new SHA1();
				signer.setSignerData(new String(Base64.encode(s.getHash(firmaSello).getBytes())));
				
				arrayOfSigners = new Signer[1];
				arrayOfSigners[0] = signer;
			}
			
			transientInstance.setPdfAdjunto(new byte[0]);
			this.edictoDAO.save(transientInstance);
			if (Constantes.getPropiedad(Constantes.ALFRESCO_ACTIVO).equals("true")) {
				System.out.println(transientInstance.getIdEdicto());
				Edicto nuevoEdicto = this.edictoDAO.findById(transientInstance.getIdEdicto());
				try {
					CreationDocumentUUIDResponse creationDocumentUUIDResponse = alfrescoWS.createDraftEdictDocumentRDWS(nuevoEdicto.getOrganismo().getCodigo(), nuevoEdicto
					        .getIdEdicto().toString(), "false", contentDocumentRequest, arrayOfSigners);
					
					if (creationDocumentUUIDResponse != null) {
						log.info("UUID del Documento" + creationDocumentUUIDResponse.getUuid());
						transientInstance.setPdfAdjunto(creationDocumentUUIDResponse.getUuid().getBytes("ISO8859-1"));
					} else {
						this.edictoDAO.delete(transientInstance);
						throw new ServiceException("No se adjunto correctamente el documento en Alfresco");
					}
				} catch (Exception e) {
					this.edictoDAO.delete(transientInstance);
					throw new ServiceException("No se adjunto correctamente el documento en Alfresco");
				}
			}
			this.edictoDAO.attachDirty(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.xml.rpc.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ContentDocumentRequest firmarServidorSello(Edicto edicto) {
		IAlmacenaryFirmarSelloWSDL almacenaryfirmarSello;
		tramitacionMuleRD tramitacionMule;
		
		byte[] documentoFirmado = null;
		ContentDocumentRequest contentDocumentRequest = new ContentDocumentRequest();
		
		try {
			
			almacenaryfirmarSello = new IAlmacenaryFirmarSelloWSDLServiceLocator().getIAlmacenaryFirmarSelloWSDLPort(new URL(Constantes.getPropiedad("endpoint5")
			        + "/AlmacenaryFirmarSello"));
			
			String idEntidadLocal = edicto.getOrganismo().getCodigo();
			
			String entradaXMLAlmacenaryFirmar = obtenerXMLAlmacenaryFirmar(Constantes.getPropiedad("sello.idAplicacion"), edicto.getDiligencia(), edicto.getCodigo() + ".pdf",
			        edicto.getOrganismo().getAliasSello());
			
			String salidaXMLAlmacenaryFirmar = almacenaryfirmarSello.almacenaDocumento(entradaXMLAlmacenaryFirmar, idEntidadLocal, edicto.getOrganismo().getAliasSello());
			
			String idTransaccion = salidaXMLAlmacenaryFirmar.substring(salidaXMLAlmacenaryFirmar.lastIndexOf("<idTransaccion>") + 15,
			        salidaXMLAlmacenaryFirmar.indexOf("</idTransaccion>"));
			
			String firmaElectronica = salidaXMLAlmacenaryFirmar.substring(salidaXMLAlmacenaryFirmar.lastIndexOf("<firmaElectronica><![CDATA[") + 27,
			        salidaXMLAlmacenaryFirmar.indexOf("==]]></firmaElectronica>"));
			
			String formatoFirma = salidaXMLAlmacenaryFirmar.substring(salidaXMLAlmacenaryFirmar.lastIndexOf("<formatoFirma>") + 14,
			        salidaXMLAlmacenaryFirmar.indexOf("</formatoFirma>"));
			String prop = "";
			
			prop = prop + "endpoint5=" + Constantes.getPropiedad("endpoint5") + "\r\n";
			prop = prop + "usuario5=" + Constantes.getPropiedad("usuario5") + "\r\n";
			prop = prop + "password5=" + Constantes.getPropiedad("password5") + "\r\n";
			prop = prop + "trustedstore5=" + Constantes.getPropiedad("trustedstore5") + "\r\n";
			prop = prop + "trustedstorepassword5=" + Constantes.getPropiedad("trustedstorepassword5") + "\r\n";
			prop = prop + "timeout5=" + Constantes.getPropiedad("timeout5") + "\r\n";
			prop = prop + "idAplicacion5=" + Constantes.getPropiedad("idAplicacion5") + "\r\n";
			prop = prop + "proxy5=" + Constantes.getPropiedad("proxy5") + "\r\n";
			prop = prop + "proxyPort5=" + Constantes.getPropiedad("proxyPort5") + "\r\n";
			prop = prop + "proxyHost5=" + Constantes.getPropiedad("proxyHost5");
			
			contentDocumentRequest.setMimeType("application/pdf");
			contentDocumentRequest.setName("Diligencia_" + edicto.getCodigo());
			contentDocumentRequest.setArrayOfMetadata(new Metadata[3]);
			contentDocumentRequest.setArrayOfMetadata(0, new Metadata("firma", firmaElectronica));
			contentDocumentRequest.setArrayOfMetadata(1, new Metadata("idTransaccion", idTransaccion));
			contentDocumentRequest.setArrayOfMetadata(2, new Metadata("formatoFirma", formatoFirma));
			contentDocumentRequest.setContent(Base64.encode(edicto.getDiligencia()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contentDocumentRequest;
	}
	
	private String obtenerXMLAlmacenaryFirmar(String idAplicacion, byte[] contenidoFichero, String nombreFichero, String alias) {
		try {
			
			String entradaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			        + "<mensajeEntrada xmlns=\"http://afirmaws/ws/validacion\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mvalidacion/ws.xsd\">"
			        + "<peticion>AlmacenarDocumento</peticion>" + "<versionMsg>1.0</versionMsg>" + "<parametros>" + "<idAplicacion>" + idAplicacion + "</idAplicacion>"
			        + "<documento>" + new String(Base64.encode(contenidoFichero)) + "</documento>" + "<nombreDocumento>" + nombreFichero.substring(0, nombreFichero.length() - 4)
			        + "</nombreDocumento>" + "<tipoDocumento>PDF</tipoDocumento>" + "<firmante>" + idAplicacion + "</firmante>" + "</parametros>" + "</mensajeEntrada>";
			return entradaXML;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
			String s = null;
			return s;
		}
	}
	
	public void delete(Edicto persistentInstance) throws ServiceException {
		log.debug("deleting Edicto instance");
		try {
			this.edictoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public Edicto findById(Integer id) throws ServiceException {
		log.debug("getting Edicto instance with id: " + id);
		try {
			return this.edictoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByIdEstado(Integer id) throws ServiceException {
		log.debug("getting Edicto instance with id: " + id);
		try {
			return this.edictoDAO.findByIdEstado(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByExample(Edicto instance) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return this.edictoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return this.edictoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByIdOrganismoExterno(Integer idOrganismoExterno) throws ServiceException {
		log.debug("getting Edicto instance with id Organismo Externo: " + idOrganismoExterno);
		try {
			return this.edictoDAO.findByIdOrganismoExterno(idOrganismoExterno);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findAll() throws ServiceException {
		log.debug("findAll Edicto");
		try {
			return this.edictoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public Edicto merge(Edicto detachedInstance) throws ServiceException {
		log.debug("merging Edicto instance");
		try {
			return this.edictoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void attachDirty(Edicto instance) throws ServiceException {
		log.debug("attaching dirty Edicto instance");
		try {
			
			this.edictoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void actualizar(Edicto transientInstance) throws ServiceException {
		try {
			log.info("ACTUALIZAR");
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS alfrescoWS = locator.getIMuleRDWSPort(new URL(endpoint));
			ContentDocumentRequest contentDocumentRequest = new ContentDocumentRequest();
			contentDocumentRequest.setMimeType("pdf");
			contentDocumentRequest.setName(transientInstance.getNombrePdfAdjunto());
			contentDocumentRequest.setContent(Base64.encode(transientInstance.getPdfAdjunto()));
			
			Signer[] arrayOfSigners = new Signer[0];
			if (transientInstance.getTipoFirma().getIdTipoFirma() == TipoFirma.STAMP_SERVICE) {
				log.debug("Firmando con sello de organo");
				ContentDocumentRequest contentDocumentRequest2 = firmarServidorSello(transientInstance);
				if (contentDocumentRequest2.getContent() == null) {
					throw new ServiceException("No se ha firmado correctamente con la firma de Sello");
				}
				Signer signer = new Signer();
				String firmaSello = contentDocumentRequest2.getArrayOfMetadata(0).getValue();
				ContentDocument contentDocument = new ContentDocument();
				contentDocument.setContent(Base64.encode(firmaSello.getBytes()));
				contentDocument.setName("Firma-" + contentDocumentRequest2.getName() + ".xml");
				contentDocument.setMimeType("text/xml");
				signer.setContent(contentDocument);
				signer.setName("Sello de Organo de " + transientInstance.getOrganismo().getNombre());
				signer.setType("CLIENTE");
				signer.setAnagram("CLIENTE");
				signer.setNif(transientInstance.getOrganismo().getCif());
				signer.setJob("-");
				signer.setDate(FechasUtil.convertDateToString(Calendar.getInstance().getTime(), 0));
				signer.setIdAplication("generalitat.entidadesLocales");
				signer.setServer("ACCV");
				signer.setIdTransaction("-");
				SHA1 s = new SHA1();
				signer.setSignerData(new String(Base64.encode(s.getHash(firmaSello).getBytes())));
				
				arrayOfSigners = new Signer[1];
				arrayOfSigners[0] = signer;
			}
			
			transientInstance.setPdfAdjunto(new byte[0]);
			log.info(transientInstance.getIdEdicto());
			String firma = "SI";
			if (transientInstance.getTipoFirma().getIdTipoFirma() == TipoFirma.DOC_FIRMADO) {
				firma = "SI";
			} else {
				firma = "NO";
			}
			CreationDocumentUUIDResponse creationDocumentUUIDResponse = alfrescoWS.replaceDraftEdictRDWS(transientInstance.getOrganismo().getCodigo(), transientInstance
			        .getIdEdicto().toString(), firma, contentDocumentRequest, arrayOfSigners);
			if (creationDocumentUUIDResponse != null) {
				log.info("UUID del Documento" + creationDocumentUUIDResponse.getUuid());
				transientInstance.setPdfAdjunto(creationDocumentUUIDResponse.getUuid().getBytes("ISO8859-1"));
			} else {
				this.edictoDAO.delete(transientInstance);
				throw new ServiceException("No se adjunto correctamente el documento en Alfresco");
			}
			this.edictoDAO.attachDirty(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.xml.rpc.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarRepublicarBorrador(Edicto transientInstance) throws ServiceException {
		try {
			log.info("ACTUALIZAR");
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS alfrescoWS = locator.getIMuleRDWSPort(new URL(endpoint));
			byte[] pdf_adjunto = transientInstance.getPdfAdjunto();
			
			String documentUuid = new String(pdf_adjunto, "ISO8859-1");
			
			IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
			ContentDocumentRequest contentDocumentRequest = new ContentDocumentRequest();
			ContentDocumentResponse contentDocumentResponse = new ContentDocumentResponse();
			contentDocumentRequest.setMimeType("pdf");
			contentDocumentRequest.setName(transientInstance.getCodigo());
			contentDocumentRequest.setContent(transientInstance.getPdfAdjunto());
			contentDocumentResponse = WS.getDocumentRDWS(documentUuid);
			pdf_adjunto = Base64.decode(contentDocumentResponse.getContent());
			
			contentDocumentRequest = new ContentDocumentRequest();
			contentDocumentRequest.setMimeType("pdf");
			contentDocumentRequest.setName(transientInstance.getNombrePdfAdjunto());
			contentDocumentRequest.setContent(Base64.encode(pdf_adjunto));
			
			Signer[] arrayOfSigners = new Signer[0];
			if (transientInstance.getTipoFirma().getIdTipoFirma() == TipoFirma.STAMP_SERVICE) {
				log.debug("Firmando con sello de organo");
				ContentDocumentRequest contentDocumentRequest2 = firmarServidorSello(transientInstance);
				if (contentDocumentRequest2.getContent() == null) {
					throw new ServiceException("No se ha firmado correctamente con la firma de Sello");
				}
				Signer signer = new Signer();
				String firmaSello = contentDocumentRequest2.getArrayOfMetadata(0).getValue();
				ContentDocument contentDocument = new ContentDocument();
				contentDocument.setContent(Base64.encode(firmaSello.getBytes()));
				contentDocument.setName("Firma-" + contentDocumentRequest2.getName() + ".xml");
				contentDocument.setMimeType("text/xml");
				signer.setContent(contentDocument);
				signer.setName("Sello de Organo de " + transientInstance.getOrganismo().getNombre());
				signer.setType("CLIENTE");
				signer.setAnagram("CLIENTE");
				signer.setNif(transientInstance.getOrganismo().getCif());
				signer.setJob("-");
				signer.setDate(FechasUtil.convertDateToString(Calendar.getInstance().getTime(), 0));
				signer.setIdAplication("generalitat.entidadesLocales");
				signer.setServer("ACCV");
				signer.setIdTransaction("-");
				SHA1 s = new SHA1();
				signer.setSignerData(new String(Base64.encode(s.getHash(firmaSello).getBytes())));
				
				arrayOfSigners = new Signer[1];
				arrayOfSigners[0] = signer;
			}
			
			transientInstance.setPdfAdjunto(new byte[0]);
			log.info(transientInstance.getIdEdicto());
			String firma = "SI";
			if (transientInstance.getTipoFirma().getIdTipoFirma() == TipoFirma.DOC_FIRMADO) {
				firma = "SI";
			} else {
				firma = "NO";
			}
			CreationDocumentUUIDResponse creationDocumentUUIDResponse = alfrescoWS.createDraftEdictDocumentRDWS(transientInstance.getOrganismo().getCodigo(), transientInstance
			        .getIdEdicto().toString(), "false", contentDocumentRequest, arrayOfSigners);
			
			if (creationDocumentUUIDResponse != null) {
				log.info("UUID del Documento" + creationDocumentUUIDResponse.getUuid());
				transientInstance.setPdfAdjunto(creationDocumentUUIDResponse.getUuid().getBytes("ISO8859-1"));
			} else {
				this.edictoDAO.delete(transientInstance);
				throw new ServiceException("No se adjunto correctamente el documento en Alfresco");
			}
			this.edictoDAO.attachDirty(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.xml.rpc.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void attachClean(Edicto instance) throws ServiceException {
		log.debug("attaching clean Edicto instance");
		try {
			this.edictoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentroYEstadosExPRYPubORed(Integer idCentro, Integer idUsuario) throws ServiceException {
		
		log.debug("finding findByCentroYEstadosYPubORed instance by example");
		try {
			return this.edictoDAO.findByCentroYEstadosExPRYPubORed(idCentro, idUsuario);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentroUsuarioPerfilYEstadosExPR(Integer idCentro, Integer idUsuario, Integer idPerfil) throws ServiceException {
		
		log.debug("finding findByCentroUsuarioPerfilYEstadosExPR instance by example");
		try {
			return this.edictoDAO.findByCentroUsuarioPerfilYEstadosExPR(idCentro, idUsuario, idPerfil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinEstadoHistorico(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor, Integer posIni, Integer maxElem) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinEstadoHistorico(idOrg, idRedactor, posIni, maxElem);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoRedactorSinEstadoHistoricoCount(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("count Edicto");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinEstadoHistoricoCount(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactor(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactor(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactorSinPublicar(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinPublicar(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoPublicador(Integer idOrg, Integer idPublicador) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicador(idOrg, idPublicador);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentroPublicadorSinPublicar(Integer idCentro, Integer idPublicador) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicador(idCentro, idPublicador);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(idPublicador, centrosProcedencia, organismo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, int numPag, int tamPag,
	        Organismo organismo) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(idPublicador, centrosProcedencia, numPag, tamPag, organismo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(idPublicador, centrosProcedencia, organismo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoEstado(Integer idOrg, Integer idEstado) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstado(idOrg, idEstado);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoEstadoOrderFechaPublicacionCount(Integer idOrg, Integer idEstado, Integer diasCaducidad) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacionCount(idOrg, idEstado, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoEstadoOrderFechaPublicacion(Integer idOrg, Integer idEstado, int numPag, int tamPag, Integer diasCaducidad) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacion(idOrg, idEstado, numPag, tamPag, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(Integer idOrg, Integer idEstado, Integer diasCaducidad, List<Integer> listaRelacionados)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(idOrg, idEstado, diasCaducidad, listaRelacionados);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(Integer idOrg, Integer idEstado, int numPag, int tamPag, Integer diasCaducidad,
	        List<Integer> listaRelacionados) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(idOrg, idEstado, numPag, tamPag, diasCaducidad, listaRelacionados);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByFiltroPublicoCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico, Integer diasCaducidad)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			int num = this.edictoDAO.findByFiltroPublicoCount(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado,
			        titulo, descripcion, lenguaje, diasCaducidad);
			if (contenido != null && !contenido.equals("")) {
				SearchResponse filter = filterEdictContentDocuments(idOrg, idTipoEdicto.toString(), titulo, idCentro.toString(), contenido, fechaPublicacionInicio,
				        fechaPublicacionFin, historico);
				if (filter != null) {
					if (filter.getArrayOfUuid() != null) {
						num = num - filter.getArrayOfUuid().length;
					} else {
						num = 0;
					}
				}
			}
			return num;
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroPublico(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico, int numPag, int tamPag,
	        Integer diasCaducidad) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			List response = this.edictoDAO.findByFiltroPublico(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado,
			        titulo, descripcion, lenguaje, numPag, tamPag, diasCaducidad);
			List response2 = new ArrayList();
			
			if (contenido != null && !contenido.equals("")) {
				SearchResponse filter = filterEdictContentDocuments(idOrg, idTipoEdicto.toString(), titulo, idCentro.toString(), contenido, fechaPublicacionInicio,
				        fechaPublicacionFin, historico);
				if (filter != null && filter.getArrayOfUuid() != null) {
					DocumentUuid[] documents = filter.getArrayOfUuid();
					for (int i = 0; i < documents.length; i++) {
						DocumentUuid documentUuid = documents[i];
						for (Iterator iterator = response.iterator(); iterator.hasNext();) {
							Edicto edicto = (Edicto) iterator.next();
							String edictoUuid = new String(edicto.getPdfAdjunto(), "ISO8859-1");
							log.info("edictosBaseDatos : " + edictoUuid);
							if (edictoUuid.equals(documentUuid.getUuid())) {
								response2.add(edicto);
							}
						}
					}
				}
			} else {
				return response;
			}
			
			return response2;
			
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	public int findByFiltroPublicoSinRelacionadosCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroPublicoSinRelacionadosCount(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin,
			        idEstado, titulo, descripcion, lenguaje, diasCaducidad, listaRelacionados);
			
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroPublicoSinRelacionados(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico, int numPag, int tamPag,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroPublicoSinRelacionados(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin,
			        idEstado, titulo, descripcion, lenguaje, numPag, tamPag, diasCaducidad, listaRelacionados);
			
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltro(Integer idOrg, Integer idTipoEdicto, Integer idCentro, String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltro(idOrg, idTipoEdicto, idCentro, fechaPublicacionInicio, fechaPublicacionFin, idEstado);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer
	 * idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer
	 * idUsuario,String usuario,String titulo) throws ServiceException{ try {
	 * return edictoDAO.findByFiltroSinEstadoRetirado(fechaRedaccion, idOrg,
	 * idCentro,idEstado,idTipoEdicto,idUsuario,usuario,titulo); } catch
	 * (DAOException e) { log.error(e.getMessage()); throw new
	 * ServiceException(e.getMessage(), e.getExceptionkey()); } }
	 */
	public int findByFiltroSinEstadoRetiradoCount(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje) throws ServiceException {
		
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoCount(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto, idUsuario, usuario, titulo,
			        numeroExpediente, lenguaje);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje, int numPag, int tamPag) throws ServiceException {
		
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetirado(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto, idUsuario, usuario, titulo,
			        numeroExpediente, lenguaje, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto,
	        String lenguaje) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia, titulo, numeroExpediente, codigoEdicto, lenguaje);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto, String lenguaje,
	        int numPag, int tamPag) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia, titulo, numeroExpediente, codigoEdicto, lenguaje, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltro(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltro(fechaRedaccion, idOrg, idCentro, idEstado, idTipoEdicto, idUsuario, usuario);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByRedactorEstado(String dni) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByRedactorEstado(dni);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentro(Integer idCentro) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByCentro(idCentro);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCodigo(String codigo) throws ServiceException {
		log.debug("finding Edicto instance by codigo");
		try {
			return this.edictoDAO.findByCodigo(codigo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findEdictosPendientesValidacionPorCentroCont(List centrosProcedencia) throws ServiceException {
		
		log.debug("finding Edicto instance by example");
		
		try {
			return this.edictoDAO.findEdictosPendientesValidacionPorCentroCont(centrosProcedencia);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findEdictosPendientesValidacionPorCentro(List centrosProcedencia, int numPag, int tamPag) throws ServiceException {
		
		log.debug("finding Edicto instance by example");
		
		try {
			return this.edictoDAO.findEdictosPendientesValidacionPorCentro(centrosProcedencia, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFechaRetiradaPropuesta(String fechaRetirada) throws ServiceException {
		log.debug("finding Edicto instance by fecha retirada");
		try {
			return this.edictoDAO.findByFechaRetiradaPropuesta(fechaRetirada);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	private SearchResponse filterEdictContentDocuments(Integer idOrg, String idTipoEdicto, String titulo, String idCentro, String contenido, String fechaInicioPublicacion,
	        String fechaFinPublicacion, boolean historico) throws ServiceException {
		SearchResponse response = null;
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
		try {
			Organismo org = organismoService.findById(idOrg);
			CentroProcedencia centro = new CentroProcedencia();
			if (!idCentro.equals("-1")) {
				centro = centroService.findById(Integer.parseInt(idCentro));
			} else {
				centro.setNombre("");
			}
			TipoEdicto tipoEdicto = new TipoEdicto();
			if (!idTipoEdicto.equals("-1")) {
				tipoEdicto = tipoEdictoService.findById(Integer.valueOf(idTipoEdicto));
			} else {
				tipoEdicto.setNombre("");
			}
			String historicoString = "NO";
			if (historico) {
				historicoString = "SI";
			}
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS alfrescoWS;
			alfrescoWS = locator.getIMuleRDWSPort(new URL(endpoint));
			log.info("--Inicio Petición de busqueda en Alfresco---");
			log.info("entity : " + org.getCodigo());
			log.info("edictArea : " + centro.getNombre());
			log.info("edictType : " + tipoEdicto.getNombre());
			log.info("title : " + titulo);
			// contenido = "";
			log.info("content : " + contenido);
			log.info("startPublicationDate : " + fechaInicioPublicacion);
			log.info("endPublicationDate : " + fechaFinPublicacion);
			log.info("unsuscribed : " + historicoString);
			
			response = alfrescoWS.searchEdictDocuments(org.getCodigo(), centro.getNombre(), tipoEdicto.getNombre(), titulo, contenido, fechaInicioPublicacion, fechaFinPublicacion,
			        historicoString);
			
			log.info("--RESPONSE--");
			if (response != null) {
				if (response.getErrors() != null) {
					for (int i = 0; i < response.getErrors().length; i++) {
						log.info("--Error--");
						log.info("ErrorCode : " + response.getErrors(i).getCode());
						log.info("ErrorDescription : " + response.getErrors(i).getDescription());
						log.info("--Fin Error--");
					}
				}
				if (response.getArrayOfUuid() != null) {
					for (int i = 0; i < response.getArrayOfUuid().length; i++) {
						log.info("Uuid : " + response.getArrayOfUuid(i).getUuid());
						
					}
				}
				
				log.info("ResultsNumber : " + response.getResultsNumber());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (javax.xml.rpc.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public List contarEdictosOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.contarEdictosOrganismoFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
		
	}
	
	public List contarEdictosOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.contarEdictosOrganismosFechas(fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismosFechas(fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismoFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismoExternosFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismoExternosFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismosExternosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismosExternosFechas(fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List contarEdictosOrgExtOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			
			List listadoResultados = this.edictoDAO.contarEdictosOrgExtOrganismosFechas(fechaPublicacionInicio, fechaPublicacionFin);
			OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
			List listadoOrgExternos = organismoExternoService.findAll();
			HashMap<Integer, OrganismoExterno> mapOrgExt = new HashMap<Integer, OrganismoExterno>();
			for (Iterator i = listadoOrgExternos.iterator(); i.hasNext();) {
				OrganismoExterno auxOrgExt = (OrganismoExterno) i.next();
				mapOrgExt.put(auxOrgExt.getIdOrg(), auxOrgExt);
				
			}
			for (Iterator it = listadoResultados.iterator(); it.hasNext();) {
				Object[] row = (Object[]) it.next();
				Integer idOrgExt = (Integer) row[1];
				if (idOrgExt != null) {
					OrganismoExterno auxOrgExt = mapOrgExt.get(idOrgExt);
					row[1] = auxOrgExt.getNombre();
				} else {
					row[1] = "Interno";
				}
			}
			
			return listadoResultados;
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List contarEdictosOrgExtOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			List listadoResultados = this.edictoDAO.contarEdictosOrgExtOrganismoFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
			OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
			List listadoOrgExternos = organismoExternoService.findAll();
			HashMap<Integer, OrganismoExterno> mapOrgExt = new HashMap<Integer, OrganismoExterno>();
			
			for (Iterator i = listadoOrgExternos.iterator(); i.hasNext();) {
				OrganismoExterno auxOrgExt = (OrganismoExterno) i.next();
				mapOrgExt.put(auxOrgExt.getIdOrg(), auxOrgExt);
				
			}
			for (Iterator it = listadoResultados.iterator(); it.hasNext();) {
				Object[] row = (Object[]) it.next();
				Integer idOrgExt = (Integer) row[1];
				if (idOrgExt != null) {
					OrganismoExterno auxOrgExt = mapOrgExt.get(idOrgExt);
					row[1] = auxOrgExt.getNombre();
				} else {
					row[1] = "Interno";
				}
			}
			
			return listadoResultados;
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public byte[] obtenerFicheroAnuncio(Edicto edicto) {
		
		String documentUuid = null;
		try {
			documentUuid = new String(edicto.getPdfAdjunto(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		try {
			return obtenerFichero(documentUuid);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}
	
	public byte[] obtenerFicheroDiligencia(Edicto edicto) {
		
		String documentUuid = null;
		try {
			documentUuid = new String(edicto.getDiligencia(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		try {
			return obtenerFichero(documentUuid);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}
	
	public byte[] obtenerFicheroFirmaDiligencia(Edicto edicto) {
		try {
			byte[] pdf_adjunto = null;
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			String documentUuid = new String(edicto.getDiligencia(), "ISO8859-1");
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
			ContentDocumentResponse contentDocumentResponse = new ContentDocumentResponse();
			contentDocumentResponse = WS.getDocumentRDWS(documentUuid);
			if (contentDocumentResponse.getErrors() == null) {
				Signer[] firmantes = contentDocumentResponse.getArrayOfSigner();
				log.debug("array firmantes " + contentDocumentResponse.getArrayOfSigner());
				pdf_adjunto = firmantes[0].getContent().getContent();
				log.debug("firma " + pdf_adjunto);
				return pdf_adjunto;
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		
	}
	
	private byte[] obtenerFichero(String uuid) throws MalformedURLException, javax.xml.rpc.ServiceException, RemoteException, Base64DecodingException {
		byte[] pdf_adjunto = null;
		String endpoint = Constantes.getPropiedad("endPointALFRESCO");
		log.debug("Obtenido URL Alfresco: " + endpoint);
		IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
		IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
		log.debug("WS obtenido: " + WS);
		ContentDocumentResponse contentDocumentResponse = new ContentDocumentResponse();
		contentDocumentResponse = WS.getDocumentRDWS(uuid);
		log.debug("Respuesta : " + contentDocumentResponse);
		log.debug("Respuesta errores: " + contentDocumentResponse.getErrors());
		log.debug("Respuesta  contenido: " + contentDocumentResponse.getContent());
		
		if (contentDocumentResponse.getErrors() == null) {
			pdf_adjunto = Base64.decode(contentDocumentResponse.getContent());
		}
		return pdf_adjunto;
	}
	
	public List findByOrganismo(Integer idOrg) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List edictoConFirmaPosteriorA(Date fecha, Integer numPag, Integer tamPag) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int edictoConFirmaPosteriorACount(Date fecha) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
