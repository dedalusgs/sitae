package afirmaws.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis.encoding.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.CDATA;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import afirmaws.services.AlmacenarDocumento.CustodiaProxy;
import afirmaws.services.FirmaServidor.FirmaProxy;
import afirmaws.services.ValidarCertificado.ValidacionProxy;
import afirmaws.services.util.DatosCertificado;
import afirmaws.services.util.DatosFirmaServidor;
import afirmaws.services.util.DatosValidarFirma;
import afirmaws.services.util.Documento;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.security.PdfPKCS7;

import es.accv.arangi.base.exception.certificate.NormalizeCertificateException;
import es.accv.arangi.base.exception.signature.RetrieveOCSPException;
import es.accv.arangi.base.exception.signature.SignatureException;
import es.accv.arangi.base.exception.signature.XMLDocumentException;
import es.accv.arangi.base.exception.timestamp.MalformedTimeStampException;
import es.accv.arangi.signature.XAdESTSignature;
import es.accv.arangi.signature.XAdESXLSignature;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.modulos.comun.exceptions.critical.SystemException;

public class FirmaUtil {
	static private Log	log	= LogFactory.getLog(FirmaUtil.class);
	
	public FirmaUtil() {
		
	}
	
	public static byte[] firmaServidor(byte[] fichero, String nombreFichero, String tipoFirma, String idAplicacion, String idSello, String urlfirma) {
		Documento documento = new Documento();
		
		documento.setContenidoficheroB64(Base64.encode(fichero));
		documento.setIdAplicacion(idAplicacion);
		documento.setNombreFichero(nombreFichero);
		documento.setTipoDocumento("PDF");
		
		String xml = null;
		try {
			String xmlAlmacenar = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><mensajeEntrada xmlns=\"https://afirmaws/ws/custodia\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mcustodia/ws.xsd\"><peticion>AlmacenarDocumento</peticion><versionMsg>1.0</versionMsg><parametros><idAplicacion/><documento/><nombreDocumento/><tipoDocumento/></parametros></mensajeEntrada>";
			
			xml = obtenerXMLAlmacenarDocumento(documento, IOUtils.toInputStream(xmlAlmacenar, "UTF-8"));
		} catch (SystemException e) {
			log.error("Error al Obtener XML para almacenamiento de fichero en @firma 5", e);
			return null;
		} catch (IOException e) {
			log.error("Error al Obtener XML para almacenamiento de fichero en @firma 5", e);
			return null;
		}
		CustodiaProxy custodia = new CustodiaProxy(urlfirma + "AlmacenarDocumento");
		String xmlRespuesta = null;
		try {
			xmlRespuesta = custodia.almacenarDocumento(xml);
		} catch (RemoteException e) {
			log.error("Error al enviar a almacenar el fichero en @firma 5", e);
			return null;
		}
		String idTransaccion = null;
		if (xmlRespuesta == null)
			return null;
		
		try {
			
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xmlDoc = documentBuilder.parse(IOUtils.toInputStream(xmlRespuesta, "UTF-8"));
			log.info("xmlRespuesta Almacenar: " + xmlRespuesta);
			NodeList nodo = xmlDoc.getElementsByTagName("idDocumento");
			if (nodo == null || nodo.getLength() == 0) {
				nodo = xmlDoc.getElementsByTagName("descripcion");
				if (nodo != null) {
					log.error("Error al almacenar documento en afirma5: " + nodo.item(0).getNodeValue());
					return null;
				} else {
					log.error("Error al almacenar documento en afirma5. Se desconoce el motivo");
				}
			} else {
				idTransaccion = nodo.item(0).getFirstChild().getNodeValue();
			}
		} catch (ParserConfigurationException e1) {
			
			log.error(e1);
			return null;
		} catch (FactoryConfigurationError e1) {
			
			log.error(e1);
			return null;
		} catch (SAXException e) {
			
			log.error(e);
			return null;
		} catch (IOException e) {
			
			log.error(e);
			return null;
		}
		log.info("Paso 1 Finalizado. Documento almacenado en afirma Correctamente");
		DatosFirmaServidor xmlFirma = new DatosFirmaServidor();
		xmlFirma.setAlgoritmoHash("SHA1");
		xmlFirma.setFirmante(idSello);
		xmlFirma.setFormatoFirma("XADES-T");
		xmlFirma.setIdAplicacion(idAplicacion);
		xmlFirma.setIdDocumento(idTransaccion);
		xml = null;
		try {
			String xmlFirmaServ = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><mensajeEntrada xmlns=\"https://afirmaws/ws/firma\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchemainstance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mfirma/ws.xsd\"><peticion>FirmaServidor</peticion><versionMsg>1.0</versionMsg><parametros><idAplicacion></idAplicacion><idDocumento></idDocumento><firmante></firmante><idReferencia></idReferencia><algoritmoHash></algoritmoHash><formatoFirma></formatoFirma></parametros></mensajeEntrada>";
			xml = obtenerXMLFirmaServidor(xmlFirma, IOUtils.toInputStream(xmlFirmaServ, "UTF-8"));
		} catch (SystemException e) {
			log.error("Error al Obtener XML para firmar de fichero en  servidor @firma 5", e);
			return null;
		} catch (IOException e) {
			log.error("Error al Obtener XML para firmar de fichero en  servidor @firma 5", e);
			return null;
		}
		
		FirmaProxy firmaServidor = new FirmaProxy(urlfirma + "FirmaServidor");
		try {
			xmlRespuesta = firmaServidor.firmaServidor(xml);
		} catch (RemoteException e) {
			log.error("Error al firmar fichero en @firma 5", e);
			return null;
		}
		if (xmlRespuesta == null)
			return null;
		log.info("xmlRespuesta Firmar: " + xmlRespuesta);
		String firmaBase64 = null;
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xmlDoc = documentBuilder.parse(IOUtils.toInputStream(xmlRespuesta, "UTF-8"));
			NodeList nodo = xmlDoc.getElementsByTagName("firmaElectronica");
			if (nodo == null || nodo.getLength() == 0) {
				nodo = xmlDoc.getElementsByTagName("descripcion");
				if (nodo != null) {
					log.error("Error al firmar documento en afirma5: " + nodo.item(0).getNodeValue());
					return null;
				} else {
					log.error("Error al firma documento en afirma5. Se desconoce el motivo");
				}
			} else {
				log.info(nodo.toString());
				log.info("numero de nodos " + nodo.getLength());
				firmaBase64 = nodo.item(0).getFirstChild().getNodeValue();
			}
		} catch (ParserConfigurationException e1) {
			
			log.error(e1);
			return null;
		} catch (FactoryConfigurationError e1) {
			
			log.error(e1);
			return null;
		} catch (SAXException e) {
			
			log.error(e);
			return null;
		} catch (IOException e) {
			
			log.error(e);
			return null;
		}
		if (firmaBase64 != null || !firmaBase64.equals("")) {
			log.info("Paso 2 Finalizado. Documento firmado correctamente.");
			return Base64.decode(firmaBase64);
		} else {
			log.error("No se ha podido firmar correctamente");
			return null;
		}
		
	}
	
	public static String obtenerValidarCertificado(byte[] fichero, String nombreFichero, String tipoFirma, String idAplicacion, String tipoHash, String firma,
	        String hashDocumento, String urlFirma) {
		
		DatosValidarFirma datosValidarFirma = new DatosValidarFirma();
		datosValidarFirma.setAlgoritmoHash(tipoHash);
		datosValidarFirma.setContenidoFichero(fichero);
		datosValidarFirma.setFirmaElectronica(firma);
		datosValidarFirma.setFormatoFirma(tipoFirma);
		datosValidarFirma.setHash(hashDocumento);
		datosValidarFirma.setIdAplicacion(idAplicacion);
		// datosValidarFirma.setObtenerInfo(paramString);
		String XMLValidarFirma = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><mensajeEntrada xmlns=\"https://afirmaws/ws/firma\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mfirma/ws.xsd\"><peticion>ValidarFirma</peticion><versionMsg>1.0</versionMsg><parametros><idAplicacion></idAplicacion><firmaElectronica></firmaElectronica><formatoFirma></formatoFirma><hash></hash><algoritmoHash></algoritmoHash><datos></datos></parametros></mensajeEntrada>";
		
		String xmlPeticionValidarFirma = null;
		try {
			xmlPeticionValidarFirma = obtenerXMLValidarFirma(datosValidarFirma, XMLValidarFirma);
		} catch (SystemException e) {
			log.error("Se ha producido un error generando el xml para validarFirma ", e);
			return null;
		}
		afirmaws.services.ValidarFirma.FirmaProxy servicio = new afirmaws.services.ValidarFirma.FirmaProxy(urlFirma + "/ValidarFirma");
		String respuestaValidarFirma = null;
		
		try {
			respuestaValidarFirma = servicio.validarFirma(xmlPeticionValidarFirma);
		} catch (RemoteException e) {
			log.error("Se ha producido un error realizando la validacion de la firma ", e);
			return null;
		}
		if (respuestaValidarFirma == null) {
			log.error("Se ha producido un error realizando la validacion de la firma. El XML es nulo o está vacio ");
			return null;
		}
		DocumentBuilder documentBuilder;
		String certificadoString = null;
		try {
			documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
			Document xmlDoc = documentBuilder.parse(IOUtils.toInputStream(respuestaValidarFirma, "UTF-8"));
			NodeList nodo = xmlDoc.getElementsByTagName("estado");
			
			if (nodo == null || nodo.getLength() == 0) {
				nodo = xmlDoc.getElementsByTagName("descripcion");
				if (nodo != null) {
					log.error("Error al validar firma documento en afirma5: " + nodo.item(0).getNodeValue());
					return null;
				} else {
					log.error("Error al validar firma en afirma5. Se desconoce el motivo");
				}
			} else {
				String estado = nodo.item(0).getFirstChild().getNodeValue();
				if (estado.equals("false")) {
					log.error("La firma electrónica no es correcta");
					return null;
				}
				nodo = xmlDoc.getElementsByTagName("certificado");
				if (nodo == null || nodo.getLength() == 0) {
					log.error("No se encuentra certificado de la firma ");
					return null;
				}
				certificadoString = nodo.item(0).getFirstChild().getNodeValue();
				
			}
		} catch (ParserConfigurationException e) {
			log.error(e);
			return null;
		} catch (FactoryConfigurationError e) {
			log.error(e);
			return null;
		} catch (SAXException e) {
			log.error(e);
			return null;
		} catch (IOException e) {
			log.error(e);
			return null;
		}
		if (certificadoString != null) {
			String xmlRespuestaCertificado = null;
			try {
				DatosCertificado datosCertificado = new DatosCertificado();
				datosCertificado.setIdAplicacion(idAplicacion);
				datosCertificado.setDatos(certificadoString.getBytes("UTF-8"));
				datosCertificado.setModoValidacion("1");
				
				String entradaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				        + "<mensajeEntrada xmlns=\"https://afirmaws/ws/firma\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mvalidacion/ws.xsd\">"
				        + "<peticion>ValidarCertificado</peticion>" + "<versionMsg>1.0</versionMsg>" + "<parametros>" + "<idAplicacion></idAplicacion>"
				        + "<certificado>></certificado>" + "<modoValidacion></modoValidacion>" + "<obtenerInfo></obtenerInfo>" + "</parametros></mensajeEntrada>";
				String xmlPeticionValidarCertificado = obtenerXMLValidarCertificado(datosCertificado, entradaXML);
				ValidacionProxy validacionService = new ValidacionProxy(urlFirma + "/ValidarCertificado");
				
				xmlRespuestaCertificado = validacionService.validarCertificado(xmlPeticionValidarCertificado);
			} catch (UnsupportedEncodingException e) {
				log.error("error pasando el certificado a byte", e);
				return null;
			} catch (SystemException e) {
				log.error("Error generando xml de  validacion del certificado", e);
				return null;
			} catch (RemoteException e) {
				log.error("Error realizando la validacion del certificado en firma", e);
				return null;
			}
			
			try {
				documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				
				Document xmlDoc = documentBuilder.parse(IOUtils.toInputStream(xmlRespuestaCertificado, "UTF-8"));
				NodeList nodo = xmlDoc.getElementsByTagName("estado");
				
				if (nodo == null || nodo.getLength() == 0) {
					nodo = xmlDoc.getElementsByTagName("descripcion");
					if (nodo != null) {
						log.error("Error al validar firma documento en afirma5: " + nodo.item(0).getNodeValue());
						return null;
					} else {
						log.error("Error al validar firma en afirma5. Se desconoce el motivo");
						return null;
					}
				} else {
					String estado = nodo.item(0).getFirstChild().getNodeValue();
					if (!estado.equals("0")) {
						log.error("El certificado no es valido");
						return null;
					}
					if ((xmlRespuestaCertificado).contains("<idCampo>NIFResponsable</idCampo>")) { // Autenticacion
						// OK
						String nif = (String) xmlRespuestaCertificado;
						
						nif = nif.substring(nif.indexOf("<idCampo>NIFResponsable</idCampo>") + "<idCampo>NIFResponsable</idCampo>".length());
						nif = nif.substring(nif.indexOf("<valorCampo>") + "<valorCampo>".length(), nif.indexOf("</valorCampo>"));
						return nif;
					} else {
						log.error("No se encuentra el NIF en el certificado");
						return null;
					}
				}
				
			} catch (ParserConfigurationException e) {
				log.error(e);
				return null;
			} catch (FactoryConfigurationError e) {
				log.error(e);
				return null;
			} catch (SAXException e) {
				log.error(e);
				return null;
			} catch (IOException e) {
				log.error(e);
				return null;
			}
		}
		return null;
	}
	
	public static String obtenerXMLAlmacenarDocumento(Documento paramDocumento, InputStream paramString) throws SystemException {
		log.debug("Iniciando metodo ObtenerXMLAlmacenarDocumento");
		SAXBuilder localSAXBuilder = new SAXBuilder(false);
		org.jdom.Document localDocument = null;
		try {
			localDocument = localSAXBuilder.build(paramString);
		} catch (JDOMException localJDOMException) {
			throw new SystemException("Se ha producido un error al convertir el fichero Xml en un Document", localJDOMException);
		} catch (IOException localIOException) {
			throw new SystemException("Se ha producido un error de IO al leer el archivo que contiene la plantilla Xml", localIOException);
		}
		addContentString(localDocument, "idAplicacion", paramDocumento.getIdAplicacion());
		addContentString(localDocument, "nombreDocumento", paramDocumento.getNombreDocumentoSinExtension());
		addContentString(localDocument, "tipoDocumento", paramDocumento.getTipoDocumento());
		addBinaryContent(localDocument, "documento", paramDocumento.getContenidoficheroB64());
		XMLOutputter localXMLOutputter = new XMLOutputter();
		String str = localXMLOutputter.outputString(localDocument);
		log.debug("Fin de metodo ObtenerXMLAlmacenarDocumento");
		return str;
	}
	
	public static String obtenerXMLFirmaServidor(DatosFirmaServidor paramDatosFirmaServidor, InputStream paramString) throws SystemException {
		log.debug("Iniciando metodo ObtenerXMLFirmaServidor");
		SAXBuilder localSAXBuilder = new SAXBuilder(false);
		org.jdom.Document localDocument = null;
		try {
			localDocument = localSAXBuilder.build(paramString);
		} catch (JDOMException localJDOMException) {
			throw new SystemException("Se ha producido un error al convertir el fichero Xml en un Document", localJDOMException);
		} catch (IOException localIOException) {
			throw new SystemException("Se ha producido un error de IO al leer el archivo que contiene la plantilla Xml", localIOException);
		}
		log.debug("Estableciendo propiedades");
		log.debug("Adding IdAplicacion " + paramDatosFirmaServidor.getIdAplicacion());
		addContentString(localDocument, "idAplicacion", paramDatosFirmaServidor.getIdAplicacion());
		log.debug("Adding IdDocumento " + paramDatosFirmaServidor.getIdDocumento());
		addContentString(localDocument, "idDocumento", paramDatosFirmaServidor.getIdDocumento());
		log.debug("Adding Firmante " + paramDatosFirmaServidor.getFirmante());
		addContentString(localDocument, "firmante", paramDatosFirmaServidor.getFirmante());
		log.debug("Adding IdReferencia " + paramDatosFirmaServidor.getIdReferencia());
		addContentString(localDocument, "idReferencia", paramDatosFirmaServidor.getIdReferencia());
		log.debug("Adding algoritmoHash " + paramDatosFirmaServidor.getAlgoritmoHash());
		addContentString(localDocument, "algoritmoHash", paramDatosFirmaServidor.getAlgoritmoHash());
		log.debug("Adding formatoFirma " + paramDatosFirmaServidor.getFormatoFirma());
		addContentString(localDocument, "formatoFirma", paramDatosFirmaServidor.getFormatoFirma());
		log.debug("Convirtiendo el XML a un String");
		XMLOutputter localXMLOutputter = new XMLOutputter();
		String str = localXMLOutputter.outputString(localDocument);
		log.debug("El valor del XMLFirmaServidor es : " + str);
		log.debug("Fin de metodo ObtenerXMLFirmaServidor");
		return str;
	}
	
	public static String obtenerXMLValidarFirma(DatosValidarFirma paramDatosValidarFirma, String paramString) throws SystemException {
		log.debug("Iniciando metodo obtenerXMLValidarFirma");
		SAXBuilder localSAXBuilder = new SAXBuilder(false);
		org.jdom.Document localDocument = null;
		try {
			localDocument = localSAXBuilder.build(paramString);
		} catch (JDOMException localJDOMException) {
			throw new SystemException("Se ha producido un error al convertir el fichero Xml en un Document", localJDOMException);
		} catch (IOException localIOException) {
			throw new SystemException("Se ha producido un error de IO al leer el archivo que contiene la plantilla Xml", localIOException);
		}
		addContentString(localDocument, "idAplicacion", paramDatosValidarFirma.getIdAplicacion());
		addBinaryContent(localDocument, "firmaElectronica", paramDatosValidarFirma.getFirmaElectronica());
		addContentString(localDocument, "formatoFirma", paramDatosValidarFirma.getFormatoFirma());
		addBinaryContent(localDocument, "hash", paramDatosValidarFirma.getHash());
		addContentString(localDocument, "algoritmoHash", paramDatosValidarFirma.getAlgoritmoHash());
		addBinaryContent(localDocument, "documento", Base64.encode(paramDatosValidarFirma.getContenidoFichero()));
		addContentString(localDocument, "obtenerInfo", paramDatosValidarFirma.getObtenerInfo());
		XMLOutputter localXMLOutputter = new XMLOutputter();
		String str = localXMLOutputter.outputString(localDocument);
		log.debug("El valor del obtenerXMLValidarFirma es : " + str);
		log.debug("Fin de metodo obtenerXMLValidarFirma");
		return str;
	}
	
	public static String obtenerXMLValidarCertificado(DatosCertificado paramDatosCertificado, String paramString) throws SystemException {
		log.debug("Iniciando metodo obtenerXMLValidarCertificado");
		SAXBuilder localSAXBuilder = new SAXBuilder(false);
		org.jdom.Document localDocument = null;
		try {
			localDocument = localSAXBuilder.build(paramString);
		} catch (JDOMException localJDOMException) {
			throw new SystemException("Se ha producido un error al convertir el fichero Xml en un Document", localJDOMException);
		} catch (IOException localIOException) {
			throw new SystemException("Se ha producido un error de IO al leer el archivo que contiene la plantilla Xml", localIOException);
		}
		addContentString(localDocument, "idAplicacion", paramDatosCertificado.getIdAplicacion());
		addContentString(localDocument, "modoValidacion", paramDatosCertificado.getModoValidacion());
		addContentString(localDocument, "obtenerInfo", paramDatosCertificado.getObtenerInfo());
		addBinaryContent(localDocument, "certificado", Base64.encode(paramDatosCertificado.getDatos()));
		XMLOutputter localXMLOutputter = new XMLOutputter();
		String str = localXMLOutputter.outputString(localDocument);
		log.debug("El valor de obtenerXMLValidarCertificado es : " + str);
		log.debug("Fin de metodo obtenerXMLValidarCertificado");
		return str;
	}
	
	private static void addContentString(org.jdom.Document paramDocument, String paramString1, String paramString2) {
		if (paramString2 == null) {
			log.debug("El campo " + paramString1 + " es nulo");
			return;
		}
		if (paramDocument == null) {
			log.debug("El documento es nul!!!!");
			return;
		}
		Element localElement1 = paramDocument.getRootElement();
		if (localElement1 == null) {
			log.debug("ERROR XML root");
			return;
		}
		Element localElement2 = localElement1.getChild("parametros", localElement1.getNamespace());
		if (localElement2 == null) {
			log.debug("ERROR XML elementParam");
			return;
		}
		Element localElement3 = localElement2.getChild(paramString1, localElement1.getNamespace());
		if (localElement3 == null) {
			log.debug("ERROR XML element");
			return;
		}
		localElement3.setText(paramString2);
	}
	
	private static void addBinaryContent(org.jdom.Document paramDocument, String paramString1, String paramString2) {
		Element localElement1 = paramDocument.getRootElement();
		Element localElement2 = localElement1.getChild("parametros", localElement1.getNamespace());
		Element localElement3 = localElement2.getChild(paramString1, localElement1.getNamespace());
		CDATA localCDATA = new CDATA(paramString2);
		localElement3.setContent(localCDATA);
	}
	
	private static void addNewParameter(org.jdom.Document paramDocument, String paramString1, String paramString2) {
		if (paramString2 == null) {
			log.debug("El campo " + paramString1 + " es nulo");
			return;
		}
		if (paramDocument == null) {
			log.debug("El documento es nul!!!!");
			return;
		}
		Element localElement1 = paramDocument.getRootElement();
		if (localElement1 == null) {
			log.debug("ERROR XML root");
			return;
		}
		log.debug("Getting ParametrosSolicitud-XML");
		Element localElement2 = (Element) localElement1.getChildren().get(0);
		log.debug("Getting Parametros-XML");
		Element localElement3 = (Element) localElement2.getChildren().get(0);
		log.debug("Getting Parametro-XML");
		List localList = localElement3.getChildren();
		Iterator localIterator = localList.iterator();
		while (localIterator.hasNext()) {
			Element localElement4 = (Element) localIterator.next();
			log.debug("Getting Nombre-XML");
			Element localElement5 = localElement4.getChild("nombre", localElement4.getNamespace());
			if (localElement5.getValue().equalsIgnoreCase(paramString1)) {
				log.debug("Getting Valor-XML");
				Element localElement6 = localElement4.getChild("valor", localElement4.getNamespace());
				localElement6.setText(paramString2);
			}
		}
	}
	
	public static List<String> obtenerCertificadoPADES(byte[] fichero) {
		
		try {
			
			PdfReader reader = new PdfReader(fichero);
			AcroFields af = reader.getAcroFields();
			ArrayList<String> names = af.getSignatureNames();
			if (names.isEmpty())
				return null;
			else {
				String nombre = names.get(0);
				PdfPKCS7 pk = af.verifySignature(nombre);
				Certificate[] certificados = pk.getCertificates();
				Certificate encontrado = null;
				ArrayList<String> listaCertificados = new ArrayList<String>();
				for (int i = 0; i < certificados.length; i++) {
					byte[] certificado = certificados[i].getEncoded();
					;
					listaCertificados.add(Base64.encode(certificado));
				}
				
				if (listaCertificados.isEmpty()) {
					return null;
				} else {
					return listaCertificados;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		// String documento = Base64.encode(fichero);
		// try {
		// return validarFirmaPADES(documento);
		// } catch (RemoteException e) {
		// log.error("Error validando firma", e);
		// return null;
		// }
		
	}
	
	private static Object validarCertificado(String cert) {
		String idAplicacion = Constantes.getPropiedad("idAplicacion5");
		
		String xmlEntrada = crearXMLValidarCertificado(cert, idAplicacion);
		log.debug("Mensaje para @firma : " + xmlEntrada);
		String response = launchRequestValidarCertificado(xmlEntrada);
		log.debug("FIN RESPONSE : " + response);
		return response;
	}
	
	private static String launchRequestValidarCertificado(String xmlEntrada) {
		String endPoint = Constantes.getPropiedad("endpoint5");
		try {
			ValidacionProxy locator = new ValidacionProxy((new StringBuilder(String.valueOf(endPoint))).append("/ValidarCertificado").toString());
			
			return locator.validarCertificado(xmlEntrada);
		} catch (Exception e) {
			log.error((new StringBuilder("M.launchRequest: Se ha producido un error enviando la petici\363n a ")).append(endPoint).append("/ValidarCertificado").toString());
			e.printStackTrace();
			return null;
		}
	}
	
	private static String crearXMLValidarCertificado(String cert, String idAplicacion) {
		try {
			
			String entradaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			        + "<mensajeEntrada xmlns=\"https://afirmaws/ws/firma\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mvalidacion/ws.xsd\">"
			        + "<peticion>ValidarCertificado</peticion>" + "<versionMsg>1.0</versionMsg>" + "<parametros>" + "<idAplicacion>" + idAplicacion + "</idAplicacion>"
			        + "<certificado><![CDATA[" + cert + "]]></certificado>" + "<modoValidacion>1</modoValidacion>" + "<obtenerInfo>true</obtenerInfo>"
			        + "</parametros></mensajeEntrada>";
			
			return entradaXML;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
			String s = null;
			return s;
		}
	}
	
	public static String validarDocumentoPADES(String documento, Date fechaPublicacion) {
		try {
			byte[] documentoByte = Base64.decode(documento);
			List<String> certificados = obtenerCertificadoPADES(documentoByte);
			CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
			
			if (certificados != null && !certificados.isEmpty()) {
				
				Boolean valido = Boolean.FALSE;
				
				for (String certi : certificados) {
					
					String result = (String) validarCertificado(certi);
					
					if (result != null && result.contains("<estado>0</estado>")) {
						log.debug("Validacion Ok");
						valido = Boolean.TRUE;
						if (((String) result).contains("<idCampo>NIFResponsable</idCampo>")) { // Autenticacion
							// OK
							String validacion = (String) result;
							
							validacion = validacion.substring(validacion.indexOf("<ValidacionSimple>") + "<ValidacionSimple>".length(), validacion.indexOf("</ValidacionSimple>"));
							String codigoResultado = validacion.substring(validacion.indexOf("<codigoResultado>") + "<codigoResultado>".length(),
							        validacion.indexOf("</codigoResultado>"));
							String descResultado = validacion.substring(validacion.indexOf("<descResultado>") + "<descResultado>".length(), validacion.indexOf("</descResultado>"));
							CertificateFactory certFactory2 = CertificateFactory.getInstance("X.509");
							InputStream in3 = new ByteArrayInputStream(Base64.decode(certi));
							X509Certificate cert3 = (X509Certificate) certFactory.generateCertificate(in3);
							Date despues3 = cert3.getNotAfter();
							SimpleDateFormat sdf3;
							sdf3 = FechasUtil.getSimpleDateFormat(FechasUtil.typeSdfDate);
							if (FechasUtil.getDifferenceByDays(FechasUtil.convertStringToDate(sdf3.format(fechaPublicacion), FechasUtil.typeSdfDate),
							        FechasUtil.convertStringToDate(sdf3.format(despues3), FechasUtil.typeSdfDate)) == 0) {
								log.error("El certificado estará caducado en el  momento de la publicación.");
								return "El certificado estará caducado en el  momento de la publicación.";
							}
							return "OK";
							// END - EMB - numero de notificaciones en session
							
						} else if (result instanceof String) { // Autenticacion
							                                   // NO
							                                   // OK
							String motivo = (String) result;
							log.error(motivo);
							
						}
						
					} else if (result.contains("descripcion")) { // Peticion no
						                                         // valida a
						                                         // @firma
						String mensaje = result.substring(result.indexOf("<descripcion>") + "<descripcion>".length(), result.indexOf("</descripcion>"));
						log.error("Error en la validacion certificado : " + mensaje);
						
					} else {
						log.error("Error en la validacion Certificado. No hay descripcion del error");
						
					}
				}
				
			} else {
				return "Error el documento no está firmado";
			}
		} catch (Exception e) {
			log.error(e);
			return "No se ha podido contactar con el servicio de verificacion de la firma.";
		}
		return "No se ha podido verificar la firma del documento";
	}
	
	public static String validarFirmaPADES(String firma) throws RemoteException {
		String idAplicacion = Constantes.getPropiedad("idAplicacion5");
		
		log.debug("CREAR XML");
		String xmlEntrada = crearXMLValidarFirmaPADES(firma, idAplicacion);
		log.debug("XML de ENTRADA : " + xmlEntrada);
		log.debug("LLAMADA WS DE VALIDAR FIRMA");
		String response = launchRequestFirma(xmlEntrada);
		log.debug("FIN RESPONSE : " + response);
		if (response != null && response.contains("<estado>true</estado>")) {
			log.debug("RESPONSE CORRECTO");
			return response.substring(response.indexOf("<certificado>") + "<certificado>".length(), response.indexOf("</certificado>"));
		} else {
			log.error("M.ValidarFirma: Firma no valida");
			log.error(response);
			return null;
		}
	}
	
	private static String crearXMLValidarFirmaPADES(String firma, String idAplicacion) {
		try {
			
			String entradaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			        + "<mensajeEntrada targetNamespace=\"https://afirmaws/ws/firma\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"https://localhost/afirmaws/xsd/mfirma/ws.xsd\">"
			        + "<peticion>ValidarFirma</peticion>" + "<versionMsg>1.0</versionMsg>" + "<parametros>" + "<idAplicacion>" + idAplicacion + "</idAplicacion>"
			        + "<firmaElectronica><![CDATA[" + firma + "]]></firmaElectronica>" + "<formatoFirma>PADES</formatoFirma>" + "<hash></hash>" + "<algoritmoHash></algoritmoHash>"
			        + "<datos><![CDATA[null]]></datos>" + "</parametros></mensajeEntrada>";
			
			return entradaXML;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
			String s = null;
			return s;
		}
	}
	
	public synchronized static String launchRequestFirma(String xmlEntrada) {
		String endPoint = Constantes.getPropiedad("endpoint5");
		try {
			
			afirmaws.services.ValidarFirma.FirmaProxy service = new afirmaws.services.ValidarFirma.FirmaProxy((new StringBuilder(String.valueOf(endPoint))).append("/ValidarFirma")
			        .toString());
			
			return service.validarFirma(xmlEntrada);
		} catch (Exception e) {
			log.error((new StringBuilder("M.launchRequest: Se ha producido un error enviando la petici\363n a ")).append(endPoint).append("/ValidarFirma").toString());
			e.printStackTrace();
			return null;
		}
	}
	
	public static XAdESXLSignature promocionarFirmaXadesXL(String ruta) {
		try {
			File file1 = new File(ruta);
			XAdESTSignature signature1X = (XAdESTSignature) XAdESTSignature.getXAdESObject(file1);
			
			XAdESXLSignature signature1XL = XAdESXLSignature.completeToXAdESXL(signature1X);
			Date fechaExpiracion = signature1XL.getTimeStampCertificateExpiration();
			
			signature1XL.save(file1);
			return signature1XL;
		} catch (IOException e) {
			log.error("Error Promocionando Firma ", e);
			return null;
		} catch (MalformedTimeStampException e) {
			log.error("Error Promocionando Firma ", e);
			return null;
		} catch (SignatureException e) {
			log.error("Error Promocionando Firma ", e);
			return null;
		} catch (NormalizeCertificateException e) {
			log.error("Error Promocionando Firma ", e);
			return null;
		} catch (RetrieveOCSPException e) {
			log.error("Error Promocionando Firma ", e);
			return null;
		} catch (XMLDocumentException e) {
			log.error("Error Promocionando Firma ", e);
			return null;
		}
	}
}
