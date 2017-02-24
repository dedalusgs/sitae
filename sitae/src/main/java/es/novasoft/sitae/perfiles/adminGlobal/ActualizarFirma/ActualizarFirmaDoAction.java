package es.novasoft.sitae.perfiles.adminGlobal.ActualizarFirma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bouncycastle.util.encoders.Base64;

import alfresco.sigex.castellon.ContentDocumentResponse;
import alfresco.sigex.castellon.EdictDocument;
import alfresco.sigex.castellon.EdictDocumentsResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import alfresco.sigex.castellon.Signer;
import es.accv.arangi.base.exception.certificate.NormalizeCertificateException;
import es.accv.arangi.base.exception.signature.RetrieveOCSPException;
import es.accv.arangi.base.exception.signature.SignatureException;
import es.accv.arangi.base.exception.signature.XMLDocumentException;
import es.accv.arangi.base.exception.timestamp.MalformedTimeStampException;
import es.accv.arangi.base.signature.XAdESTSignature;
import es.accv.arangi.signature.XAdESXLSignature;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;

public class ActualizarFirmaDoAction extends ActionBase {
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
			
			FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
			UsuarioAutentificado ciudadano = null;
			String actualizar = request.getParameter("actualizar");
			
			List<Organismo> listaOrganismos = organismoService.findAll();
			File rutaLogs = new File("/opt/xaloc/logSITAEMigracion/");
			if (!rutaLogs.exists()) {
				rutaLogs.mkdirs();
			}
			File edictosCorrectosTotal = new File("/opt/xaloc/logSITAEMigracion/correctosFirma.txt");
			if (edictosCorrectosTotal.exists()) {
				edictosCorrectosTotal.delete();
			}
			edictosCorrectosTotal.createNewFile();
			File errorNoSeObtieneDocumentos = new File("/opt/xaloc/logSITAEMigracion/errorNoSeObtieneFirma.txt");
			if (errorNoSeObtieneDocumentos.exists()) {
				errorNoSeObtieneDocumentos.delete();
			}
			errorNoSeObtieneDocumentos.createNewFile();
			File errorNoSeObtieneCSV = new File("/opt/xaloc/logSITAEMigracion/errorNosepuedePromocionar.txt");
			if (errorNoSeObtieneCSV.exists()) {
				errorNoSeObtieneCSV.delete();
			}
			errorNoSeObtieneCSV.createNewFile();
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			PrintWriter ficheroErrorNoSeObtieneFirma = new PrintWriter(new FileWriter(errorNoSeObtieneDocumentos));
			PrintWriter ficheroEdictosCorrectosTotal = new PrintWriter(new FileWriter(edictosCorrectosTotal));
			PrintWriter ficheroErrorNoSePuedePromocionar = new PrintWriter(new FileWriter(errorNoSeObtieneCSV));
			ficheroEdictosCorrectosTotal.println("Total Ayuntamientos " + listaOrganismos.size());
			for (Organismo organismo : listaOrganismos) {
				int edictosCorrectos = 0;
				int edictosError = 0;
				int edictosNoPromocion = 0;
				int edictosNofirma = 0;
				
				Date horainicio = new Date();
				List<Edicto> listaEdictoOrg = edictoService.findByOrganismo(organismo.getIdOrg());
				ficheroEdictosCorrectosTotal.println("Ayuntamiento " + organismo.getCodigo() + " Total de Edictos: " + listaEdictoOrg.size());
				ficheroErrorNoSeObtieneFirma.println("Ayuntamiento " + organismo.getCodigo());
				ficheroErrorNoSePuedePromocionar.println("Ayuntamiento " + organismo.getCodigo());
				ficheroEdictosCorrectosTotal.println("Hora de Inicio" + dt.format(horainicio));
				ficheroErrorNoSeObtieneFirma.println("Hora de Inicio" + dt.format(horainicio));
				ficheroErrorNoSePuedePromocionar.println("Hora de Inicio" + dt.format(horainicio));
				
				ficheroEdictosCorrectosTotal.flush();
				ficheroErrorNoSeObtieneFirma.flush();
				ficheroErrorNoSePuedePromocionar.flush();
				int contador = 0;
				for (Edicto edicto : listaEdictoOrg) {
					contador++;
					if ((contador % 50) == 0) {
						long momento = new Date().getTime();
						ficheroEdictosCorrectosTotal.println("Procesados " + contador + "tiempo Total segundos " + (momento - horainicio.getTime()) / 1000);
					}
					ficheroEdictosCorrectosTotal.flush();
					ficheroErrorNoSeObtieneFirma.flush();
					ficheroErrorNoSePuedePromocionar.flush();
					log.info("EDICTO LEIDO :" + edicto.getCodigo() + " - " + edicto.getIdEdicto());
					try {
						if (edicto.getEstado().getIdEstado().equals(Constantes.RETIRADO)) {
							
							FileService fileService = factoryFileServices.getService(edicto);
							File fileFirma = fileService.obtenerFicheroFile(edicto.getFirmaDiligenciaString());
							
							XAdESTSignature signature1X = (XAdESTSignature) XAdESTSignature.getXAdESObject(fileFirma);
							
							XAdESXLSignature signature1XL = XAdESXLSignature.completeToXAdESXL(signature1X);
							
							Date fechaExpiracion = signature1XL.getTimeStampCertificateExpiration();
							edicto.setCaducidadFirma(fechaExpiracion);
							edictoService.attachDirty(edicto);
							signature1XL.save(fileFirma);
							edictosCorrectos++;
							log.info("EDICTO PROMOCIONADO " + edicto.getCodigo() + " - " + edicto.getIdEdicto() + " FEcha Caducidad " + fechaExpiracion);
						}
						
					} catch (NumberFormatException e) {
						
					} catch (SignatureException e) {
						edictosError++;
						edictosNoPromocion++;
						log.error(e);
					} catch (XMLDocumentException e) {
						edictosError++;
						edictosNoPromocion++;
						log.error(e);
					} catch (FileNotFoundException e) {
						edictosError++;
						edictosNofirma++;
						log.error(e);
					} catch (NormalizeCertificateException e) {
						edictosError++;
						edictosNoPromocion++;
						log.error(e);
					} catch (RetrieveOCSPException e) {
						edictosError++;
						edictosNoPromocion++;
						log.error(e);
					} catch (MalformedTimeStampException e) {
						edictosError++;
						edictosNoPromocion++;
						log.error(e);
					} catch (IOException e) {
						edictosError++;
						edictosNofirma++;
						log.error(e);
					} catch (Exception e) {
						edictosError++;
						edictosNofirma++;
						log.error(e);
					}
					
				}
				ficheroEdictosCorrectosTotal.println("Ayto " + organismo.getCodigo() + " Edictos correctos: " + edictosCorrectos);
				
				ficheroEdictosCorrectosTotal.println("Ayto " + organismo.getCodigo() + " Edictos con Error : " + edictosError);
				ficheroEdictosCorrectosTotal.println("Ayto " + organismo.getCodigo() + " Edictos sin firma : " + edictosNofirma);
				ficheroEdictosCorrectosTotal.println("Ayto " + organismo.getCodigo() + " Edictos no promocionados: " + edictosNoPromocion);
				
				Date horafinal = new Date();
				long diferencia = (horafinal.getTime() - horainicio.getTime()) / 1000;
				ficheroEdictosCorrectosTotal.println("Hora de Final" + dt.format(horafinal) + " ha tardado en segundos:" + diferencia);
				ficheroErrorNoSeObtieneFirma.println("Hora de Final" + dt.format(horafinal) + " ha tardado en segundos:" + diferencia);
				ficheroErrorNoSePuedePromocionar.println("Hora de Final" + dt.format(horafinal) + " ha tardado en segundos:" + diferencia);
				
			}
			ficheroEdictosCorrectosTotal.close();
			ficheroErrorNoSePuedePromocionar.close();
			ficheroErrorNoSeObtieneFirma.close();
			
			/*
			 * List<Organismo> listaOrganismos = organismoService.findAll();
			 * File rutaLogs = new File("/opt/xaloc/logSITAEMigracion/"); if
			 * (!rutaLogs.exists()) { rutaLogs.mkdirs(); } File
			 * edictosCorrectosTotal = new
			 * File("/opt/xaloc/logSITAEMigracion/correctos.txt"); if
			 * (edictosCorrectosTotal.exists()) {
			 * edictosCorrectosTotal.delete(); }
			 * edictosCorrectosTotal.createNewFile(); File
			 * errorNoSeObtieneDocumentos = new
			 * File("/opt/xaloc/logSITAEMigracion/errorNoSeObtieneDocumentos.txt"
			 * ); if (errorNoSeObtieneDocumentos.exists()) {
			 * errorNoSeObtieneDocumentos.delete(); }
			 * errorNoSeObtieneDocumentos.createNewFile(); File
			 * errorNoSeObtieneCSV = new
			 * File("/opt/xaloc/logSITAEMigracion/errorNoSeObtieneCSV.txt"); if
			 * (errorNoSeObtieneCSV.exists()) { errorNoSeObtieneCSV.delete(); }
			 * errorNoSeObtieneCSV.createNewFile(); SimpleDateFormat dt = new
			 * SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); PrintWriter
			 * ficheroErrorNoSeObtieneDocumentos = new PrintWriter(new
			 * FileWriter(errorNoSeObtieneDocumentos)); PrintWriter
			 * ficheroEdictosCorrectosTotal = new PrintWriter(new
			 * FileWriter(edictosCorrectosTotal)); PrintWriter
			 * ficheroErrorNoSeObtieneCSV = new PrintWriter(new
			 * FileWriter(errorNoSeObtieneCSV));
			 * ficheroEdictosCorrectosTotal.println("Total Ayuntamientos " +
			 * listaOrganismos.size()); for (Organismo organismo :
			 * listaOrganismos) { int edictosCorrectos = 0; int edictosError =
			 * 0; int edictosNoCSV = 0; int edictosAlfresco = 0; int
			 * edictosSiCSV = 0; int edictosNuevos = 0; Date horainicio = new
			 * Date(); List<Edicto> listaEdictoOrg =
			 * edictoService.findByOrganismo(organismo.getIdOrg());
			 * ficheroEdictosCorrectosTotal.println("Ayuntamiento " +
			 * organismo.getCodigo() + " Total de Edictos: " +
			 * listaEdictoOrg.size());
			 * ficheroErrorNoSeObtieneDocumentos.println("Ayuntamiento " +
			 * organismo.getCodigo());
			 * ficheroErrorNoSeObtieneCSV.println("Ayuntamiento " +
			 * organismo.getCodigo());
			 * ficheroEdictosCorrectosTotal.println("Hora de Inicio" +
			 * dt.format(horainicio));
			 * ficheroErrorNoSeObtieneDocumentos.println("Hora de Inicio" +
			 * dt.format(horainicio));
			 * ficheroErrorNoSeObtieneCSV.println("Hora de Inicio" +
			 * dt.format(horainicio)); ficheroEdictosCorrectosTotal.flush();
			 * ficheroErrorNoSeObtieneDocumentos.flush();
			 * ficheroErrorNoSeObtieneCSV.flush(); int contador = 0; for (Edicto
			 * edicto : listaEdictoOrg) { contador++; if ((contador % 50) == 0)
			 * { long momento = new Date().getTime();
			 * ficheroEdictosCorrectosTotal.println("Procesados " + contador +
			 * "tiempo Total segundos " + (momento - horainicio.getTime()) /
			 * 1000); } ficheroEdictosCorrectosTotal.flush();
			 * ficheroErrorNoSeObtieneDocumentos.flush();
			 * ficheroErrorNoSeObtieneCSV.flush(); log.info("EDICTO LEIDO :" +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto()); String
			 * idFichero = null; String idDiligencia = null; idFichero =
			 * obtenerUuidEdictoAlfreso(edicto); if (idFichero == null) {
			 * edictosError++;
			 * ficheroErrorNoSeObtieneDocumentos.println("Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * "Error no tiene Anuncio"); continue; } Boolean esnuevo = false;
			 * FileService fileService = factoryFileServices.getService(edicto);
			 * byte[] ficheroEdicto = null; byte[] ficheroDiligencia = null;
			 * byte[] ficheroFirma = null; if (!idFichero.startsWith("file")) {
			 * edictosAlfresco++; ficheroEdicto =
			 * obtenerFicheroAlfresco(idFichero); } else {
			 * ficheroErrorNoSeObtieneDocumentos.println(edicto.getCodigo() +
			 * " EDICTO"); edictosNuevos++; if
			 * (edicto.getEstado().getIdEstado().equals(Constantes.RETIRADO)) {
			 * if (actualizar != null) { Boolean resultado =
			 * VFEUtil.registrarDiligencia(edicto, null); if (resultado ==
			 * false) { ficheroErrorNoSeObtieneDocumentos.println("Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * "Error edicto nuevo no tiene Firma o diligencia");
			 * edictosError++; } else {
			 * ficheroErrorNoSeObtieneCSV.println(edicto.getCodigo());
			 * edictosNoCSV++; } } } continue; } Boolean tieneDiligencia =
			 * false; Boolean errorDiligencia = false; if
			 * (edicto.getEstado().getIdEstado().equals(Constantes.RETIRADO)) {
			 * idDiligencia = obtenerUuidDiligenciaAlfreso(edicto); if
			 * (idDiligencia == null) { edictosError++;
			 * ficheroErrorNoSeObtieneDocumentos.println("Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * "Error no tiene diligencia"); continue; } tieneDiligencia = true;
			 * ficheroDiligencia = obtenerFicheroAlfresco(idDiligencia);
			 * ficheroFirma = obtenerFicheroFirmaDiligencia(idDiligencia); if
			 * (ficheroDiligencia == null || ficheroFirma == null) {
			 * errorDiligencia = true; } } if (!errorDiligencia) { String ruta =
			 * null; if (edicto.getCodigo() == null ||
			 * edicto.getCodigo().equals("")) { ruta =
			 * fileService.guardarBorrador(ficheroEdicto, edicto); } else { if
			 * (ficheroEdicto == null) { edictosError++;
			 * ficheroErrorNoSeObtieneDocumentos.println(" Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * " No se ha encontrado en Alfresco"); continue; } else { ruta =
			 * fileService.publicarAnuncio(ficheroEdicto, edicto); } } if (ruta
			 * == null) { edictosError++;
			 * ficheroErrorNoSeObtieneDocumentos.println(" Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * " No se almacena fichero en file system"); continue; } else {
			 * edicto.setPdfAdjunto(ruta); } if (tieneDiligencia) { String
			 * rutaDiligencia = fileService.guardarDiligencia(ficheroDiligencia,
			 * edicto); if (rutaDiligencia == null) { edictosError++;
			 * ficheroErrorNoSeObtieneDocumentos.println(" Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * " No se almacena diligencia en file system"); continue; } else {
			 * edicto.setDiligencia(rutaDiligencia); } String
			 * rutaFirmaDiligencia =
			 * fileService.guardarFirmaDiligencia(ficheroFirma, null, edicto);
			 * if (rutaFirmaDiligencia == null) { edictosError++;
			 * ficheroErrorNoSeObtieneDocumentos.println(" Edicto " +
			 * edicto.getCodigo() + " - " + edicto.getIdEdicto() +
			 * " No se almacena firma en file system"); continue; } else {
			 * edicto.setFirmaDiligencia(rutaFirmaDiligencia); } } if
			 * (actualizar != null) { edictoService.attachDirty(edicto);
			 * ficheroEdictosCorrectosTotal.println(edicto.getCodigo());
			 * edictosCorrectos++; } else {
			 * ficheroEdictosCorrectosTotal.println(edicto.getCodigo());
			 * edictosCorrectos++; } } else {
			 * ficheroErrorNoSeObtieneDocumentos.println(edicto.getCodigo() +
			 * " Error en diligencia o su firma"); edictosError++; continue; }
			 * if (!errorDiligencia && tieneDiligencia) { RegistroCSV registro =
			 * registroCSVService.findBySourceDoc(idDiligencia); String
			 * codigoCSV = null; if (registro != null) { if (actualizar != null)
			 * { edictosSiCSV++; Boolean resultado =
			 * VFEUtil.registrarDiligencia(edicto, registro.getDocumentCSV()); }
			 * } else { if (actualizar != null) { Boolean resultado =
			 * VFEUtil.registrarDiligencia(edicto, null);
			 * ficheroErrorNoSeObtieneCSV.println(edicto.getCodigo());
			 * edictosNoCSV++; } continue; } } }
			 * ficheroEdictosCorrectosTotal.println("Ayto " +
			 * organismo.getCodigo() + " Edictos correctos: " +
			 * edictosCorrectos); ficheroEdictosCorrectosTotal.println("Ayto " +
			 * organismo.getCodigo() + " Edictos Alfresco: " + edictosAlfresco);
			 * ficheroEdictosCorrectosTotal.println("Ayto " +
			 * organismo.getCodigo() +
			 * " Edictos con Error al obtener documento: " + edictosError);
			 * ficheroEdictosCorrectosTotal.println("Ayto " +
			 * organismo.getCodigo() + " Edictos con formato nuevo: " +
			 * edictosNuevos); ficheroEdictosCorrectosTotal.println("Ayto " +
			 * organismo.getCodigo() + " Edictos registrados con CSV nuevo: " +
			 * edictosNoCSV + " de " + listaEdictoOrg.size());
			 * ficheroErrorNoSeObtieneCSV.println("Ayto " +
			 * organismo.getCodigo() + " Edictos registrados con CSV: " +
			 * edictosSiCSV + " de " + listaEdictoOrg.size()); Date horafinal =
			 * new Date(); long diferencia = (horafinal.getTime() -
			 * horainicio.getTime()) / 1000;
			 * ficheroEdictosCorrectosTotal.println("Hora de Final" +
			 * dt.format(horafinal) + " ha tardado en segundos:" + diferencia);
			 * ficheroErrorNoSeObtieneDocumentos.println("Hora de Final" +
			 * dt.format(horafinal) + " ha tardado en segundos:" + diferencia);
			 * ficheroErrorNoSeObtieneCSV.println("Hora de Final" +
			 * dt.format(horafinal) + " ha tardado en segundos:" + diferencia);
			 * } ficheroEdictosCorrectosTotal.close();
			 * ficheroErrorNoSeObtieneCSV.close();
			 * ficheroErrorNoSeObtieneDocumentos.close();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
	
	private byte[] obtenerFicheroAlfresco(String uuid) throws MalformedURLException {
		
		byte[] pdf_adjunto = null;
		
		String endpoint = Constantes.getPropiedad("endPointALFRESCO");
		try {
			
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
			
			log.debug("El uuid a buscar del Edicto es:" + uuid);
			ContentDocumentResponse contentDocumentResponse = new ContentDocumentResponse();
			contentDocumentResponse = WS.getDocumentRDWS(uuid);
			
			if (contentDocumentResponse.getErrors() == null) {
				pdf_adjunto = Base64.decode(contentDocumentResponse.getContent());
			}
		} catch (Exception e) {
			log.error("Error obteniendo documento de Alfreco ", e);
			return null;
		}
		return pdf_adjunto;
	}
	
	private String obtenerUuidDiligenciaAlfreso(Edicto edicto) {
		String uuid = null;
		try {
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
			
			byte[] uuidString = edicto.getDiligencia();
			if (uuidString == null || uuidString.length == 0 || uuidString.length > 100) {
				log.warn("Diligencia Anuncio " + edicto.getCodigo() + " No está en bbdd. Buscando en Alfresco");
				EdictDocumentsResponse edictoDocument = new EdictDocumentsResponse();
				edictoDocument = WS.getDiligenceEdictRDWS(edicto.getCodigo());
				if (edictoDocument.getErrors() == null) {
					EdictDocument[] edicDocuArray = edictoDocument.getArrayOfDocuments();
					EdictDocument edicDocu = null;
					if (edicDocuArray.length > 0) {
						edicDocu = edicDocuArray[0];
						uuid = edicDocu.getUuid();
						log.warn("Diligencia Encontrada");
					} else {
						log.warn("Diligencia No Encontrada");
					}
				} else {
					log.warn("Diligencia No Encontrada");
				}
			} else {
				uuid = new String(edicto.getDiligencia(), "ISO8859-1");
			}
		} catch (Exception e) {
			log.error("Error obteniendo documento de Alfreco ", e);
			return null;
		}
		return uuid;
		
	}
	
	private String obtenerUuidEdictoAlfreso(Edicto edicto) {
		String uuid = null;
		try {
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
			
			byte[] uuidString = edicto.getPdfAdjunto();
			if (uuidString == null || uuidString.length == 0 || uuidString.length > 100) {
				log.warn("Edicto Anuncio " + edicto.getCodigo() + " No está en bbdd. Buscando en Alfresco");
				EdictDocumentsResponse edictoDocument = new EdictDocumentsResponse();
				if (edicto.getEstado().getIdEstado().equals(Constantes.PUBLICADO) || edicto.getEstado().getIdEstado().equals(Constantes.RETIRADO)) {
					edictoDocument = WS.getEdictDocumentsRDWS(edicto.getOrganismo().getCodigo(), edicto.getCentro().getNombreCarpeta(), edicto.getCodigo());
				} else {
					edictoDocument = WS.getDraftEdictRDWS(edicto.getOrganismo().getCodigo(), edicto.getIdEdicto().toString());
				}
				if (edictoDocument.getErrors() == null) {
					EdictDocument[] edicDocuArray = edictoDocument.getArrayOfDocuments();
					EdictDocument edicDocu = null;
					if (edicDocuArray.length > 0) {
						edicDocu = edicDocuArray[0];
						uuid = edicDocu.getUuid();
						log.warn("Edicto Encontrado");
					} else {
						log.warn("Edicto No Encontrado");
					}
				} else {
					log.warn("Edicto No Encontrado");
				}
			} else {
				
				uuid = new String(edicto.getPdfAdjunto(), "ISO8859-1");
				
			}
		} catch (Exception e) {
			log.error("Error obteniendo documento de Alfreco ", e);
			return null;
		}
		return uuid;
		
	}
	
	public byte[] obtenerFicheroFirmaDiligencia(String uiid) {
		Signer[] firmantes = null;
		try {
			byte[] pdf_adjunto = null;
			log.debug("Buscando Firma Diligencia");
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			log.debug("El uuid a buscar es:" + uiid);
			String documentUuid = uiid;
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
			ContentDocumentResponse contentDocumentResponse = new ContentDocumentResponse();
			contentDocumentResponse = WS.getDocumentRDWS(documentUuid);
			if (contentDocumentResponse.getErrors() == null) {
				firmantes = contentDocumentResponse.getArrayOfSigner();
				
				pdf_adjunto = firmantes[0].getContent().getContent();
				pdf_adjunto = Base64.decode(pdf_adjunto);
				pdf_adjunto = Base64.decode(pdf_adjunto);
				
				return pdf_adjunto;
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("Error obteniendo firma diligencia", e);
			if (firmantes != null) {
				log.error(firmantes.length);
				if (firmantes.length > 0) {
					log.error("Numero de Firmantes" + firmantes.length);
					Signer signer = firmantes[0];
					log.error("Objeto firmante " + signer);
					if (signer != null) {
						log.error("contenido1 " + signer.getContent());
						
					}
				}
			}
			return null;
		}
		
	}
	
}
