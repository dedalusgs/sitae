package es.novasoft.sitae.login.actions;

import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.opencms.firma.InfoCert;

import afirmaws.services.ValidarCertificado.ValidacionProxy;
import afirmaws.services.ValidarFirma.FirmaProxy;
import es.accv.arangi.base.signature.ISignature;
import es.accv.arangi.base.signature.XAdESSignature;
import es.accv.arangi.base.util.validation.ValidationResult;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class LoginConCertificadoDoAction extends ActionBase {
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		
		// ************************* Obtenemos fichero de properties para
		// conexión con @firma
		
		Log log = LogFactory.getLog(ActionBase.class);
		
		String uri = (String) request.getParameter("uri");
		
		String prop = "";
		
		String idApliacion = Constantes.getPropiedad("idAplicacion5");
		String urlFirma = Constantes.getPropiedad("endpoint5");
		
		// ************************* Certificado Digital
		String firma = request.getParameter("fichero");
		System.out.println(firma);
		byte[] firmaByte = Base64.decodeBase64(firma.getBytes());
		String firmaString = new String(firmaByte);
		System.out.println(firmaString);
		ISignature signature = XAdESSignature.getSignatureInstance(firmaString.getBytes());
		ValidationResult[] certificados = signature.isValidSignatureOnly();
		
		String cert = null;
		if (certificados.length > 0) {
			ValidationResult certi = certificados[0];
			cert = new String(Base64.encodeBase64(certi.getCertificate().getEncoded()));
		}
		
		// **********************Obtención del
		// idioma*****************************//
		
		// -- Validamos el UUID
		String loginUUID = (String) request.getSession().getAttribute("loginUUID");
		String uuid = request.getParameter("uuid");
		
		if (loginUUID != null && !loginUUID.equals(uuid)) {
			request.getSession().setAttribute("valuerror", "ERR_USU_PETICION_V"); // OJOOOO!!!
			request.getSession().setAttribute("causerror", "ERR_USU_PETICION_C"); // OJOOO!!!
			
			return mapping.findForward(Constantes.ERROR);
			
		}
		
		// ************************* Llamada a Web Service
		Object result = null;
		InfoCert info = null;
		String motivo = "Error no especificado";
		
		try {
			// log.debug("INICIO VALIDAR FIRMA");
			// String cert = validarFirma(firma);
			// log.debug("FIN VALIDAR FIRMA");
			
			log.debug("CERTIFICADO : " + cert);
			if (cert == null) {
				return mapping.findForward(Constantes.ERROR);
			}
			log.debug("INICIO VALIDAR CERTIFICADO");
			result = validarCertificado(cert);
			log.debug("FIN VALIDAR CERTIFICADO : " + result);
			
			if (result != null) {
				log.debug("Validacion Ok");
				
				if (((String) result).contains("<idCampo>NIFResponsable</idCampo>")) { // Autenticacion
					// OK
					String nif = (String) result;
					
					nif = nif.substring(nif.indexOf("<idCampo>NIFResponsable</idCampo>") + "<idCampo>NIFResponsable</idCampo>".length());
					nif = nif.substring(nif.indexOf("<valorCampo>") + "<valorCampo>".length(), nif.indexOf("</valorCampo>"));
					List<Usuario> lista = usuarioService.findByNumeroDocumento(nif);
					if (!lista.isEmpty()) {
						Usuario usuario = lista.get(0);
						request.getSession().setAttribute("nif", usuario.getNumDocumento());
					} else {
						log.error("Error de conexion con servidor de autenticación de firma digital:");
						request.getSession().setAttribute("valuerror", "valor del error"); // OJOOOO!!!
						request.getSession().setAttribute("causerror", "CAUSA DEL ERROR"); // OJOOO!!!
						return mapping.findForward(Constantes.ERROR);
					}
					
					// END - EMB - numero de notificaciones en session
					
				} else if (result instanceof String) { // Autenticacion NO OK
					motivo = (String) result;
					log.error(motivo);
					request.getSession().setAttribute("valuerror", "ERR_USU_PETICION_V"); // OJOOOO!!!
					request.getSession().setAttribute("causerror", "ERR_USU_PETICION_C"); // OJOOO!!!
					return mapping.findForward(Constantes.ERROR);
					
				}
			} else { // Peticion no valida a @firma
				log.error("Petición no válida realizada a arrobafirma:");
				request.getSession().setAttribute("valuerror", "ERR_USU_PETICION_V"); // OJOOOO!!!
				request.getSession().setAttribute("causerror", "ERR_USU_PETICION_C"); // OJOOO!!!
				log.error("Petición no válida realizada a arrobafirma:");
				return mapping.findForward(Constantes.ERROR);
			}
			
		} catch (Exception e) {
			
			log.error("Error de conexion con servidor de autenticación de firma digital:" + e);
			request.getSession().setAttribute("valuerror", "valor del error"); // OJOOOO!!!
			request.getSession().setAttribute("causerror", "CAUSA DEL ERROR"); // OJOOO!!!
			return mapping.findForward(Constantes.ERROR);
		}
		
		return mapping.findForward(Constantes.SUCCESS);
		
	}
	
	private Object validarCertificado(String cert) {
		String idAplicacion = Constantes.getPropiedad("idAplicacion5");
		
		String xmlEntrada = crearXMLValidarCertificado(cert, idAplicacion);
		this.log.debug("Mensaje para @firma : " + xmlEntrada);
		String response = launchRequestValidarCertificado(xmlEntrada);
		this.log.debug("FIN RESPONSE : " + response);
		if (response != null && response.contains("<estado>0</estado>")) {
			this.log.debug("RESPONSE CORRECTO");
			return response;
		} else {
			this.log.error("M.ValidarCertificado: Certificado no valido");
			return null;
		}
	}
	
	private String launchRequestValidarCertificado(String xmlEntrada) {
		String endPoint = Constantes.getPropiedad("endpoint5");
		try {
			ValidacionProxy locator = new ValidacionProxy((new StringBuilder(String.valueOf(endPoint))).append("/ValidarCertificado").toString());
			
			return locator.validarCertificado(xmlEntrada);
		} catch (Exception e) {
			this.log.error((new StringBuilder("M.launchRequest: Se ha producido un error enviando la petici\363n a ")).append(endPoint).append("/ValidarCertificado").toString());
			e.printStackTrace();
			return null;
		}
	}
	
	private String crearXMLValidarCertificado(String cert, String idAplicacion) {
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
	
	public String validarFirma(String firma) throws RemoteException {
		String idAplicacion = Constantes.getPropiedad("idAplicacion5");
		
		this.log.debug("CREAR XML");
		String xmlEntrada = crearXMLValidarFirma(firma, idAplicacion);
		this.log.debug("XML de ENTRADA : " + xmlEntrada);
		this.log.debug("LLAMADA WS DE VALIDAR FIRMA");
		String response = launchRequestFirma(xmlEntrada);
		this.log.debug("FIN RESPONSE : " + response);
		if (response != null && response.contains("<estado>true</estado>")) {
			this.log.debug("RESPONSE CORRECTO");
			return response.substring(response.indexOf("<certificado>") + "<certificado>".length(), response.indexOf("</certificado>"));
		} else {
			this.log.error("M.ValidarFirma: Firma no valida");
			return null;
		}
	}
	
	private String crearXMLValidarFirma(String firma, String idAplicacion) {
		try {
			
			String entradaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			        + "<mensajeEntrada targetNamespace=\"https://afirmaws/ws/firma\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"https://localhost/afirmaws/xsd/mfirma/ws.xsd\">"
			        + "<peticion>ValidarFirma</peticion>" + "<versionMsg>1.0</versionMsg>" + "<parametros>" + "<idAplicacion>" + idAplicacion + "</idAplicacion>"
			        + "<firmaElectronica><![CDATA[" + firma + "]]></firmaElectronica>" + "<formatoFirma>XADES</formatoFirma>" + "<hash></hash>" + "<algoritmoHash></algoritmoHash>"
			        + "<datos><![CDATA[null]]></datos>" + "</parametros></mensajeEntrada>";
			
			return entradaXML;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
			String s = null;
			return s;
		}
	}
	
	public synchronized String launchRequestFirma(String xmlEntrada) {
		String endPoint = Constantes.getPropiedad("endpoint5");
		try {
			
			FirmaProxy service = new FirmaProxy((new StringBuilder(String.valueOf(endPoint))).append("/ValidarFirma").toString());
			
			return service.validarFirma(xmlEntrada);
		} catch (Exception e) {
			this.log.error((new StringBuilder("M.launchRequest: Se ha producido un error enviando la petici\363n a ")).append(endPoint).append("/ValidarFirma").toString());
			e.printStackTrace();
			return null;
		}
	}
	
}
