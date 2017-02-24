package es.novasoft.sitae.comun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.util.encoders.Base64;

import afirmaws.services.FirmaUtil;
import alfresco.sigex.castellon.AssertionResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.PdfPKCS7;

import es.accv.arangi.base.signature.XAdESTSignature;
import es.novasoft.castellon.vfe.ws.VFEUtil;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.GeneradorClavesUtil;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.files.FileServiceException;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.ws.fandango.FandangoClient;
import es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDL;

public class UtilPublicar implements Serializable {
	private static final Log	log	= LogFactory.getLog(UtilPublicar.class);
	
	public static InputStream generaDiligencia(Edicto edicto, Organismo organismo) throws IOException, com.itextpdf.text.DocumentException {
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		FestivoService festivoService = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
		// ServletContext contexto = this.getServlet().getServletContext();
		String rutaPlantilla = Constantes.getPropiedad(Constantes.RUTA_PLANTILLA_DILIGENCIA_ABSOLUTA);
		String rutaFichero = Constantes.getPropiedad(Constantes.RUTA_DILIGENCIAS_ABSOLUTA) + "/Diligencia_" + edicto.getCodigo() + ".pdf";
		
		HashMap<String, String> campos = new HashMap<String, String>();
		
		Date fechaDesde = edicto.getFechaPublicacion();
		
		Date fechaDesdeAux = FechasUtil.addDays(fechaDesde, 1);
		
		String fechaDesdeStr = FechasUtil.getDayByDate(fechaDesdeAux) + " de " + FechasUtil.getMonthStrByDate(fechaDesdeAux) + " de " + FechasUtil.getYearByDate(fechaDesdeAux);
		String fechaDesdeStrVa = FechasUtil.getDayByDate(fechaDesdeAux) + " " + FechasUtil.getMonthStrByDateVa(fechaDesdeAux) + " de " + FechasUtil.getYearByDate(fechaDesdeAux);
		
		Date fechaHasta = FechasUtil.getCurrentDate();
		
		Date fechaHastaAux = FechasUtil.addDays(FechasUtil.getCurrentDate(), -1);
		String fechaHastaStr = FechasUtil.getDayByDate(fechaHastaAux) + " de " + FechasUtil.getMonthStrByDate(fechaHastaAux) + " de " + FechasUtil.getYearByDate(fechaHastaAux);
		String fechaHastaStrVa = FechasUtil.getDayByDate(fechaHastaAux) + " " + FechasUtil.getMonthStrByDateVa(fechaHastaAux) + " de " + FechasUtil.getYearByDate(fechaHastaAux);
		
		Integer numDias = 0;
		;
		
		try {
			numDias = festivoService.obtenerDiasPublicacion(fechaDesde, fechaHastaAux, organismo, edicto.getTipoExposicion());
		} catch (es.novasoft.comun.exceptions.ServiceException e) {
			
			log.error(e, e);
		}
		String tipoPublicacion;
		String tipoPublicacionValenciano;
		String dias;
		String diasValenciano;
		if (numDias > 1) {
			dias = " días";
			diasValenciano = " dies";
			if (edicto.getTipoExposicion().equals(Edicto.TIPO_PUBLICACION_NATURALES)) {
				tipoPublicacion = " naturales";
				tipoPublicacionValenciano = " naturals";
			} else {
				tipoPublicacion = " hábiles";
				tipoPublicacionValenciano = " hàbils";
			}
		} else {
			dias = " día";
			diasValenciano = " dia";
			if (edicto.getTipoExposicion().equals(Edicto.TIPO_PUBLICACION_NATURALES)) {
				tipoPublicacion = " natural";
				tipoPublicacionValenciano = " natural";
			} else {
				tipoPublicacion = " hábil";
				tipoPublicacionValenciano = " hàbil";
			}
			
		}
		
		String plazo = "Ha permanecido expuesto en el Tablón de Edictos Electrónico de este Ayuntamiento durante " + numDias + dias + tipoPublicacion + ",desde el "
		        + fechaDesdeStr + " hasta el " + fechaHastaStr + ",ambós inclusive.";
		String plazoVa = "Ha romàs exposat en el Tauler d'Edictes Electrònic d'este Ajuntament durant " + numDias + diasValenciano + tipoPublicacionValenciano + ",des del "
		        + fechaDesdeStrVa + " fins el " + fechaHastaStrVa + ",amdbós inclusivament.";
		
		if (numDias == 1) {
			plazo = "Ha permanecido expuesto en el Tablón de Edictos Electrónico de este Ayuntamiento durante " + numDias + dias + tipoPublicacion + ", el " + fechaDesdeStr;
			plazoVa = "Ha romàs exposat en el Tauler d'Edictes Electrònic d'este Ajuntament durant " + numDias + diasValenciano + tipoPublicacionValenciano + ", el "
			        + fechaDesdeStrVa;
		}
		
		if (numDias < 1) {
			plazo = "No ha permanecido expuesto en el Tablón de Edictos Electrónico de este Ayuntamiento durante ningún día completo";
			plazoVa = "No ha romàs exposat en el Tauler d'Edictes Electrònic d'este Ajuntament durant cap dia complet";
		}
		
		Date fechaActual = new Date();
		String fechaActualStr = FechasUtil.getDayByDate(fechaActual) + " de " + FechasUtil.getMonthStrByDate(fechaActual) + " de " + FechasUtil.getYearByDate(fechaActual);
		String fechaActualStrVa = FechasUtil.getDayByDate(fechaActual) + " " + FechasUtil.getMonthStrByDateVa(fechaActual) + " de " + FechasUtil.getYearByDate(fechaActual);
		
		String localidadfecha = "En " + organismo.getNombre() + ", a " + fechaActualStr;
		String localidadfechaVa = "A " + organismo.getNombreVa() + ", a " + fechaActualStrVa;
		
		String protocolo = Constantes.getPropiedad(Constantes.PROTOCOLO);
		
		String nombreApp = Constantes.getPropiedad(Constantes.NOMBRE_APP);
		
		String urlEdicto = edicto.getCodigo();
		
		campos.put("plazo", plazo);
		campos.put("plazoVa", plazoVa);
		campos.put("localidadfecha", localidadfecha);
		campos.put("localidadfechaVa", localidadfechaVa);
		campos.put("organismo", organismo.getNombre());
		campos.put("domicilio", organismo.getDireccion());
		campos.put("telefono", "Tlf: " + organismo.getTelefono());
		campos.put("email", organismo.getEmail());
		campos.put("tituloEdicto", edicto.getTitulo());
		campos.put("tituloEdictoVa", edicto.getTituloVa());
		campos.put("codigoEdicto", urlEdicto);
		campos.put("codigoEdictoVa", urlEdicto);
		
		// Fichero pdf que se genera para almacenar la diligencia
		
		File f = new File(rutaFichero);
		
		// Apertura de la plantilla pdf donde se insertan los datos
		
		PdfReader reader = new PdfReader(rutaPlantilla);
		OutputStream stream = new FileOutputStream(f);
		
		// Creo la salida
		PdfStamper stamp = new PdfStamper(reader, stream);
		
		// Relleno los campos
		AcroFields form = stamp.getAcroFields();
		
		// Relleno de la imagen del escudo
		java.util.List<AcroFields.FieldPosition> photograph = form.getFieldPositions("escudo");
		if (photograph != null && photograph.size() > 0) {
			Rectangle rect = photograph.get(0).position;
			
			Image img = Image.getInstance(organismo.getImagen());
			// Image img = Image.getInstance(rutaEscudo);
			
			img.scaleToFit(rect.getWidth(), rect.getHeight());
			img.setBorder(2);
			img.setAbsolutePosition(rect.getLeft() + (rect.getWidth() - img.getScaledWidth()), rect.getTop() - (rect.getHeight()));
			PdfContentByte cb = stamp.getOverContent((int) photograph.get(0).page);
			cb.addImage(img);
		}
		
		// Recorremos el el map para poder rellenar el pdf
		
		Set<String> claves = campos.keySet();
		
		Iterator<String> iterator = claves.iterator();
		
		while (iterator.hasNext()) {
			
			String clave = iterator.next();
			
			String valorAtributo = campos.get(clave);
			
			form.setField(clave, valorAtributo);
			
		}
		
		// Cerrampos la apertura del fichero y de la plantilla
		
		stamp.setFormFlattening(true);
		stamp.close();
		reader.consolidateNamedDestinations();
		stream.close();
		
		return new FileInputStream(f);
	}
	
	public static boolean guardarEdictoConDiligencia(Edicto edicto, DiligenciaBean diligenciaBean) {
		
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
		FestivoService festivoService = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
		FileService fileService = factoryFileServices.getService(edicto);
		try {
			String rutaDil = fileService.guardarDiligencia(diligenciaBean.getDiligencia(), edicto);
			String rutaFirma = fileService.guardarFirmaDiligencia(diligenciaBean.getFirma(), null, edicto);
			edicto.setDiligencia(rutaDil);
			edicto.setFirmaDiligencia(rutaFirma);
			edicto.setTipoFirmaDiligencia(diligenciaBean.getTipoFirma());
			edicto.setCaducidadFirma(diligenciaBean.getCaducidadFirma());
			Boolean registro = VFEUtil.registrarDiligencia(edicto, null);
			if (registro) {
				edictoService.attachDirty(edicto);
				
				return true;
			} else {
				log.error("Ha fallado el registro de la documentacion en VFE.");
				return false;
			}
		} catch (Exception e) {
			log.error("Error, no se ha podido almacenar la diligencia y/o su firma", e);
			return false;
		}
		
	}
	
	public static DiligenciaBean firmarServidorSello(Edicto edicto, byte[] diligencia_archivo) {
		IAlmacenaryFirmarSelloWSDL almacenaryfirmarSello;
		
		DiligenciaBean diligencia = new DiligenciaBean();
		
		try {
			
			// if
			// (Constantes.getPropiedad(Constantes.FANDANGO_ACTIVO).equals("true"))
			// {
			byte[] firmaElectronica = FirmaUtil.firmaServidor(diligencia_archivo, "Diligencia_" + edicto.getCodigo() + ".pdf", "XADES",
			        Constantes.getPropiedad("sello.idAplicacion"), edicto.getOrganismo().getAliasSello(), Constantes.getPropiedad("endpoint5"));
			if (firmaElectronica == null)
				return null;
			XAdESTSignature signature1X = (XAdESTSignature) XAdESTSignature.getXAdESObject(firmaElectronica);
			es.accv.arangi.signature.XAdESXLSignature signature1XL = es.accv.arangi.signature.XAdESXLSignature.completeToXAdESXL(signature1X);
			Date fechaExpiracion = signature1XL.getTimeStampCertificateExpiration();
			diligencia.setCaducidadFirma(fechaExpiracion);
			diligencia.setDiligencia(diligencia_archivo);
			diligencia.setFirma(signature1XL.toByteArray());
			diligencia.setTipoFirma("XADES");
			
		} catch (Exception e) {
			
			log.error("Se ha producido un Error firmando de documento con Sello de Órgano.", e);
			return null;
		}
		log.info("Se ha firmado documento con sello de órgano correctamente.");
		return diligencia;
	}
	
	public static String obtenerXMLAlmacenaryFirmar(String idAplicacion, byte[] contenidoFichero, String nombreFichero, String alias) {
		
		try {
			
			String entradaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			        + "<mensajeEntrada xmlns=\"http://afirmaws/ws/validacion\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:SchemaLocation=\"https://localhost/afirmaws/xsd/mvalidacion/ws.xsd\">"
			        + "<peticion>AlmacenarDocumento</peticion>" + "<versionMsg>1.0</versionMsg>" + "<parametros>" + "<idAplicacion>" + idAplicacion + "</idAplicacion>"
			        + "<documento>" + new String(Base64.encode(contenidoFichero)) + "</documento>" + "<nombreDocumento>" + nombreFichero.substring(0, nombreFichero.length() - 4)
			        + "</nombreDocumento>" + "<tipoDocumento>PDF</tipoDocumento>" + "<firmante>" + alias + "</firmante>" + "</parametros>" + "</mensajeEntrada>";
			return entradaXML;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
			String s = null;
			return s;
		}
	}
	
	public static void notificarBajaPublicacion(Edicto edicto, String motivoRechazo) {
		MailUtils correo = new MailUtils();
		ResourceBundle manejadorMensajes = ResourceBundle.getBundle("mailconfig");
		String asunto = manejadorMensajes.getString("asuntoBajaPublicacion") + edicto.getTitulo();
		String texto = manejadorMensajes.getString("textoBajaPublicacionNombre") + edicto.getTitulo();
		texto = texto + manejadorMensajes.getString("textoBajaPublicacionNombre2") + " " + motivoRechazo + manejadorMensajes.getString("textoBajaPublicacionNombre3");
		texto = texto + manejadorMensajes.getString("textoBajaPublicacionNombreVa") + edicto.getTituloVa();
		texto = texto + manejadorMensajes.getString("textoBajaPublicacionNombre2Va") + " " + motivoRechazo + manejadorMensajes.getString("textoBajaPublicacionNombre3Va");
		texto = texto + "<p>http://" + edicto.getOrganismo().getDominio() + "/sitae</p>";
		
		/* Notificamos al redactor */
		Usuario redactor = edicto.getRedactor();
		int resultado = correo.notificar(null, null, redactor.getEmail(), asunto, texto);
		if (resultado == 0) {
			System.out.println("Error en DarBajaPublicacionDoAction: Al notificar por correo al redactor");
		}
		/* Notificamos al publicador */
		Usuario publicador = edicto.getPublicador();
		
		if (redactor.getIdUsuario() != publicador.getIdUsuario()) {
			resultado = correo.notificar(null, null, publicador.getEmail(), asunto, texto);
			if (resultado == 0) {
				log.error("Error en DarBajaPublicacionDoAction: Al notificar por correo al publicador");
			}
		}
	}
	
	public static void notificarBajaPublicacion(Edicto edicto, String motivoRechazo, String motivoRechazoVa) {
		MailUtils correo = new MailUtils();
		ResourceBundle manejadorMensajes = ResourceBundle.getBundle("mailconfig");
		String asunto = manejadorMensajes.getString("asuntoBajaPublicacion") + edicto.getTitulo();
		String texto = manejadorMensajes.getString("textoBajaPublicacionNombre") + edicto.getTitulo();
		texto = texto + manejadorMensajes.getString("textoBajaPublicacionNombre2") + " " + motivoRechazo + manejadorMensajes.getString("textoBajaPublicacionNombre3");
		texto = texto + manejadorMensajes.getString("textoBajaPublicacionNombreVa") + edicto.getTituloVa();
		texto = texto + manejadorMensajes.getString("textoBajaPublicacionNombre2Va") + " " + motivoRechazoVa + manejadorMensajes.getString("textoBajaPublicacionNombre3Va");
		texto = texto + "<p>http://" + edicto.getOrganismo().getDominio() + "/sitae</p>";
		
		/* Notificamos al redactor */
		Usuario redactor = edicto.getRedactor();
		int resultado = correo.notificar(null, null, redactor.getEmail(), asunto, texto);
		if (resultado == 0) {
			log.error("Error en DarBajaPublicacionDoAction: Al notificar por correo al redactor");
		}
		/* Notificamos al publicador */
		Usuario publicador = edicto.getPublicador();
		if (redactor.getIdUsuario() != publicador.getIdUsuario()) {
			resultado = correo.notificar(null, null, publicador.getEmail(), asunto, texto);
			if (resultado == 0) {
				log.error("Error en DarBajaPublicacionDoAction: Al notificar por correo al publicador");
			}
		}
	}
	
	public static void notificarErrorDuranteBaja(Edicto edicto, String error) {
		MailUtils correo = new MailUtils();
		String mensajeError = " Se ha producido el siguiente error realizando la baja del anuncio " + edicto.getCodigo() + " procedente del organismo "
		        + edicto.getOrganismo().getNombre() + " :\n";
		String finMensajeError = "<p>http://" + edicto.getOrganismo().getDominio() + "/sitae</p>";
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		
		List<RelacionUsuOrgCentroPerf> listaRelUsuOrgCentroPerfAdministradoresGlobales = new ArrayList<RelacionUsuOrgCentroPerf>();
		List<Usuario> listaAdminGlobal = new ArrayList<Usuario>();
		try {
			listaRelUsuOrgCentroPerfAdministradoresGlobales = relacionUsuOrgCentroPerfService.findByPerfil(Constantes.ADMIN_GLOBAL);
			
			Iterator it = listaRelUsuOrgCentroPerfAdministradoresGlobales.iterator();
			while (it.hasNext()) {
				boolean encontrado = false;
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
				List listadoUsuarios = usuarioService.findByNumeroDocumento(relacionUsuOrgCentroPerf.getUsuario());
				Iterator iter = listadoUsuarios.iterator();
				while (iter.hasNext()) {
					listaAdminGlobal.add((Usuario) iter.next());
				}
			}
			/* Notificamos al redactor */
			Iterator<Usuario> it2 = listaAdminGlobal.iterator();
			while (it2.hasNext()) {
				Usuario adminglobal = it2.next();
				int resultado = correo.notificar(null, null, adminglobal.getEmail(), "[SITAE]Error realizando Baja  " + edicto.getCodigo(), mensajeError + error + finMensajeError);
				if (resultado == 0) {
					log.error("Error en DarBajaPublicacionDoAction: Al notificar por correo a los administradores Globales, tras un error anterior. ");
				}
			}
		} catch (es.novasoft.comun.exceptions.ServiceException e) {
			log.error("Error en DarBajaPublicacionDoAction: Al notificar por correo a los administradores Globales, tras un error anterior. ");
			e.printStackTrace();
		}
		
	}
	
	public static boolean darDeBaja(String urlCertificado) throws Exception {
		boolean baja = false;
		FandangoClient client = (FandangoClient) Factory.getBean(ServiceConstants.FANDANGO_BEAN_NAME);
		
		try {
			if (Constantes.getPropiedad(Constantes.FANDANGO_ACTIVO).equals("true")) {
				client.darDeBaja(urlCertificado);
				baja = true;
			} else {
				baja = true;
			}
			
		} catch (RemoteException e) {
			baja = false;
			log.error("Error", e);
			
		}
		return baja;
		
	}
	
	public static boolean validarFirmaDocumento(byte[] documentofirmado) {
		boolean valido = true;
		try {
			
			Random rnd = new Random();
			
			PdfReader reader = new PdfReader(documentofirmado);
			AcroFields af = reader.getAcroFields();
			ArrayList names = af.getSignatureNames();
			for (int k = 0; k < names.size(); ++k) {
				String name = (String) names.get(k);
				int random = rnd.nextInt();
				FileOutputStream out = new FileOutputStream("revision_" + random + "_" + af.getRevision(name) + ".pdf");
				byte bb[] = new byte[8192];
				InputStream ip = af.extractRevision(name);
				int n = 0;
				while ((n = ip.read(bb)) > 0) {
					out.write(bb, 0, n);
				}
				out.close();
				ip.close();
				PdfPKCS7 pk = af.verifySignature(name);
				Calendar cal = pk.getSignDate();
				Certificate pkc[] = pk.getCertificates();
				Boolean verificado;
				try {
					verificado = pk.verify();
				} catch (GeneralSecurityException e) {
					verificado = false;
					log.info(e);
				}
				
				if (verificado) {
					
					System.out.print(pk.getSignName());
					log.info("Firma: " + pk.getSignName());
				} else {
					log.info("Firma no válida");
					System.out.print("Firma no válida");
					valido = false;
				}
				File f = new File("revision_" + random + "_" + af.getRevision(name) + ".pdf");
				f.delete();
				
			}
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return true;
		
	}
	
	public static void publicarEdictoAlfresco(Edicto edicto) throws ServiceException {
		
		try {
			String endpoint = Constantes.getPropiedad("endPointALFRESCO");
			IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
			IMuleRDWS alfrescoWS = locator.getIMuleRDWSPort(new URL(endpoint));
			
			AssertionResponse asresp = alfrescoWS.publicDraftEdictRDWS(edicto.getOrganismo().getCodigo(), edicto.getIdEdicto().toString(), edicto.getCodigo(), edicto.getCentro()
			        .getNombre(), edicto.getTipoEdicto().getNombre(), edicto.getTitulo());
			
			log.info("Message Alfresco : " + asresp.getMessage());
			if (asresp.getErrors() != null) {
				for (int i = 0; i < asresp.getErrors().length; i++) {
					log.error("--Error--");
					String error = asresp.getErrors(i).getCode();
					log.error("ErrorCode : " + asresp.getErrors(i).getCode());
					log.error("ErrorDescription : " + asresp.getErrors(i).getDescription());
					log.error("--Fin Error--");
				}
				throw new ServiceException("Error en la operación realizada en Alfresco");
			}
		} catch (RemoteException e) {
			log.error(e);
			throw new ServiceException("Error de comunicaciones con Alfresco.");
			
		} catch (MalformedURLException e) {
			log.error(e);
			throw new ServiceException("Error de comunicaciones con Alfresco.");
		} catch (javax.xml.rpc.ServiceException e) {
			log.error(e);
			throw new ServiceException("Error de comunicaciones con Alfresco.");
		}
		
	}
	
	public static String obtenerUrlCertificado(String url, String titulo) throws Exception {
		
		String sTipoFirma = null;
		
		String urlCertificado = "";
		
		FandangoClient client = (FandangoClient) Factory.getBean(ServiceConstants.FANDANGO_BEAN_NAME);
		
		try {
			if (sTipoFirma == null) {
				// PDF
				log.info("url: " + url);
				log.info("titulo: " + titulo);
				if (Constantes.getPropiedad(Constantes.FANDANGO_ACTIVO).equals("true")) {
					boolean isRevisable = Constantes.getPropiedad(Constantes.REVISABLE).equals("true");
					urlCertificado = client.getCertificadoPublicacionTodasOpciones(url, null, 0, titulo, false, isRevisable);
					log.info("urlCertificado: " + urlCertificado);
				} else {
					urlCertificado = "http://urlfandangosimulada.es";
					log.info("urlCertificado: " + urlCertificado);
				}
				
			} else {
				// CMS, PKCS#7 o token
				urlCertificado = null;
			}
		} catch (Exception e) {
			urlCertificado = null;
			
			log.error(e, e);
		}
		
		return urlCertificado;
	}
	
	public static void notificarSolicitudPublicacion(Edicto edicto) {
		
		log.info("Inicio enviar notificación a publicadores");
		if (edicto.getEstado().getIdEstado().equals(Constantes.INICIADO) || edicto.getEstado().getIdEstado().equals(Constantes.RECHAZADO)
		        || edicto.getEstado().getIdEstado().equals(Constantes.RECHAZADO_FIRMA)) {
			try {
				
				EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
				
				UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
				
				RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				        .getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
				
				EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
				
				InputStream documento = null;
				OutputStream out = null;
				
				MailUtils correo = null;
				correo = new MailUtils();
				ResourceBundle mailconfig = ResourceBundle.getBundle("mailconfig");
				String rutaEdicto = Constantes.getPropiedad(Constantes.RUTA_EDICTOS_ABSOLUTA);
				String protocolo = Constantes.getPropiedad(Constantes.PROTOCOLO);
				
				String nombreAdjunto = edicto.getNombrePdfAdjunto();
				File adjunto = null;
				try {
					FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
					FileService fileService = factoryFileServices.getService(edicto);
					adjunto = fileService.obtenerFicheroFile(edicto.getPdfAdjuntoString());
				} catch (FileServiceException e) {
					log.error("No se ha podido recuperar documento", e);
				}
				String asunto = mailconfig.getString("asuntoSolicitudPublicacion") + " " + edicto.getTitulo();
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
				texto = texto + "<p>" + protocolo + "://" + edicto.getOrganismo().getDominio() + "</p>";
				
				int res = 1;
				
				Iterator iterador = interesados.iterator();
				
				while (iterador.hasNext()) {
					Usuario interesado = (Usuario) iterador.next();
					res = correo.enviarCorreo(host, remitente, interesado.getEmail(), asunto, texto, adjunto, nombreAdjunto);
					
				}
				log.info("Se ha notificado correctamente a los publicadores");
				
			} catch (es.novasoft.comun.exceptions.ServiceException e) {
				log.error(e);
			}
		} else {
			log.error("El anuncio el cual se quiere notificar no se encuentra en estado INICIADO");
		}
		
	}
	
	public static void notificarFestivosNoDeclarados(Organismo org, Integer anio) {
		
		MailUtils correo = new MailUtils();
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		
		String mensajeError;
		if (org != null) {
			mensajeError = "Mensaje de Aviso de SITAE:\n Se ha detectado que no se ha establecido el calendario laboral en el organismo " + org.getNombre() + " para el año "
			        + anio + ". Por favor entre en la administración y declare los día festivos.";
		} else {
			mensajeError = "Mensaje de Aviso de SITAE:\n Se ha detectado que no se ha establecido el calendario laboral a nivel nacional para el año " + anio
			        + ". Por favor entre en la administración y declare los día festivos.";
		}
		List<RelacionUsuOrgCentroPerf> listaRelUsuOrgCentroPerfAdministradores;
		List<Usuario> listaAdminLocal = new ArrayList<Usuario>();
		try {
			if (org != null) {
				listaRelUsuOrgCentroPerfAdministradores = relacionUsuOrgCentroPerfService.findByPerfil(Constantes.ADMIN_LOCAL);
			} else {
				listaRelUsuOrgCentroPerfAdministradores = relacionUsuOrgCentroPerfService.findByPerfil(Constantes.ADMIN_GLOBAL);
			}
			
			Iterator it = listaRelUsuOrgCentroPerfAdministradores.iterator();
			while (it.hasNext()) {
				
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
				if (org != null) {
					if (relacionUsuOrgCentroPerf.getOrganismo().equals(org.getCif())) {
						List listadoUsuarios = usuarioService.findByNumeroDocumento(relacionUsuOrgCentroPerf.getUsuario());
						Iterator iter = listadoUsuarios.iterator();
						while (iter.hasNext()) {
							listaAdminLocal.add((Usuario) iter.next());
						}
					}
				} else {
					List listadoUsuarios = usuarioService.findByNumeroDocumento(relacionUsuOrgCentroPerf.getUsuario());
					Iterator iter = listadoUsuarios.iterator();
					while (iter.hasNext()) {
						listaAdminLocal.add((Usuario) iter.next());
					}
					
				}
				
			}
			/* Notificamos al redactor */
			Iterator<Usuario> it2 = listaAdminLocal.iterator();
			while (it2.hasNext()) {
				Usuario admin = it2.next();
				int resultado = correo.notificar(null, null, admin.getEmail(), "[SITAE] Declarar Calendario Laboral", mensajeError);
				
				if (resultado == 0) {
					if (org == null) {
						log.error("Error en al notificar: Al notificar por correo que no se ha declarado el calendario laboral nacional");
					} else {
						log.error("Error en al notificar: Al notificar por correo que no se ha declarado el calendario laboral del organismo " + org.getNombre());
					}
				}
			}
		} catch (es.novasoft.comun.exceptions.ServiceException e) {
			if (org == null) {
				log.error("Error en al notificar: Al notificar por correo que no se ha declarado el calendario laboral nacional", e);
			} else {
				log.error("Error en al notificar: Al notificar por correo que no se ha declarado el calendario laboral del organismo " + org.getNombre(), e);
			}
			
		}
		
	}
	
	static synchronized public Edicto publicar(Edicto edicto) throws ServiceException, FandangoException {
		
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
		FestivoService festivoService = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
		log.info("Inicio publicacion edicto id: " + edicto.getIdEdicto());
		Organismo organismo = organismoService.findById(edicto.getOrganismo().getIdOrg());
		Integer contador_edicto = organismo.getCont_edicto();
		Date fecha_edicto = organismo.getFecha_edicto();
		Date fechaActual = new Date();
		SimpleDateFormat sdf;
		sdf = FechasUtil.getSimpleDateFormat(FechasUtil.typeSdfDate);
		Estado estadoAnterior = edicto.getEstado();
		
		if (FechasUtil.getDifferenceByDays(FechasUtil.convertStringToDate(sdf.format(fechaActual), FechasUtil.typeSdfDate),
		        FechasUtil.convertStringToDate(sdf.format(edicto.getFechaPublicacionPropuesta()), FechasUtil.typeSdfDate)) > 0) {
			Estado estado = estadoService.findById(Constantes.PENDIENTE_PUBLICACION);
			edicto.setEstado(estado);
			edictoService.attachDirty(edicto);
			return edicto;
		}
		Estado estado = estadoService.findById(Constantes.PUBLICADO);
		edicto.setEstado(estado);
		int anyoFechaEdictoOrganismo = FechasUtil.getYearByDate(fecha_edicto);
		int anyoFechaActual = FechasUtil.getYearByDate(fechaActual);
		String anyoFechaActualString = String.valueOf(anyoFechaActual);
		if (anyoFechaActual > anyoFechaEdictoOrganismo) {
			contador_edicto = 0;
			organismo.setFecha_edicto(new Date());
		}
		
		String claveGenerada;
		try {
			claveGenerada = GeneradorClavesUtil.generarClaveEdictoCodigo(organismo.getCodigo(), anyoFechaActualString, contador_edicto.toString());
		} catch (Exception e1) {
			log.error(e1);
			return null;
		}
		contador_edicto++;
		edicto.setCodigo(claveGenerada);
		
		Date fRetirada = festivoService.obtenerFechaFinPublicacion(fechaActual, organismo, edicto.getDiasExposicion(), edicto.getTipoExposicion());
		edicto.setFechaRetiradaPropuesta(fRetirada);
		
		edicto.setFechaUltimaModificacion(fechaActual);
		edicto.setFechaPublicacion(fechaActual);
		FileService fileService = factoryFileServices.getService(edicto);
		
		byte[] documentoBorrador = null;
		try {
			documentoBorrador = fileService.obtenerFichero(edicto.getPdfAdjuntoString());
			
		} catch (FileServiceException e1) {
			
			log.error("Error al obtener fichero borrador durante el proceso de publicación", e1);
			
			return null;
			
		}
		/** FIRMAR **/
		// Boolean documentoFirmado =
		// validadorFirma.isFandangoValidDocumentAfirma(documentoBorrador);
		//
		// byte[] ficheroFirmado = null;
		// if (!documentoFirmado) {
		// ficheroFirmado =
		// validadorFirma.firmarDocumentoPDF(documentoBorrador);
		//
		// } else {
		// ficheroFirmado = documentoBorrador;
		//
		// }
		
		String ruta = null;
		try {
			ruta = fileService.publicarAnuncio(null, edicto);
		} catch (FileServiceException e1) {
			log.error("Error al publicar fichero borrador durante el proceso de publicación", e1);
			return null;
		}
		
		edicto.setPdfAdjunto(ruta);
		edictoService.attachDirty(edicto);
		String protocolo = Constantes.getPropiedad(Constantes.PROTOCOLO);
		
		String nombreApp = Constantes.getPropiedad(Constantes.NOMBRE_APP);
		
		String url = protocolo + "://" + organismo.getDominio() + "/" + nombreApp + "/DescargarAnuncio.do?codigo=" + edicto.getCodigo();
		
		try {
			String urlCertificadoPublicacion = obtenerUrlCertificado(url, claveGenerada);
			if (urlCertificadoPublicacion != null && !urlCertificadoPublicacion.equals("")) {
				edicto.setUrl(urlCertificadoPublicacion);
				organismo.setCont_edicto(contador_edicto);
				fileService.eliminarBorrador(edicto);
				organismoService.attachDirty(organismo);
				edictoService.attachDirty(edicto);
				
				if (edicto.getSustituyeA() != null) {
					Edicto edictoSust = edicto.getSustituyeA();
					edictoSust.setSustituidoPor(edicto);
					edictoService.attachDirty(edictoSust);
				}
				if (edicto.getRedesSociales().equals("SI")) {
					UtilRedesSociales.publicarRedesSociales(edicto);
				}
				if (edicto.getListaCorreo().equals("SI")) {
					UtilRedesSociales.publicarListaCorreo(edicto);
				}
				
				return edicto;
			} else {
				log.error("Error producido al generar el certificado de publicación");
				fileService.eliminarPublicado(edicto);
				edicto.setCodigo("");
				edicto.setFechaPublicacion(null);
				String rutaFinal = fileService.guardarBorrador(documentoBorrador, edicto);
				edicto.setPdfAdjunto(rutaFinal);
				edicto.setEstado(estadoAnterior);
				edictoService.attachDirty(edicto);
				throw new FandangoException("Error al publicar en Fandango");
				
			}
			
		} catch (Exception e) {
			
			edicto.setCodigo("");
			edicto.setFechaPublicacion(null);
			edicto.setEstado(estadoAnterior);
			edictoService.attachDirty(edicto);
			log.error("Error al publicar en fandango", e);
			throw new FandangoException("Error al publicar en Fandango");
		}
	}
	
	public synchronized static Boolean bajaPublicacion(Edicto edicto) {
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		boolean bajaCorrecta = true;
		try {
			Estado estadoRetirado = estadoService.findById(Constantes.RETIRADO);
			Estado estadoPublicado = estadoService.findById(Constantes.PUBLICADO);
			Date ultimaModificacion = edicto.getFechaUltimaModificacion();
			Date fecha = new Date();
			
			log.debug("Generar diligencia");
			InputStream is = UtilPublicar.generaDiligencia(edicto, edicto.getOrganismo());
			
			log.debug("Firmar Diligencia con Sello de órgano");
			DiligenciaBean diligenciafirmada = UtilPublicar.firmarServidorSello(edicto, IOUtils.toByteArray(is));
			
			if (diligenciafirmada == null) {
				UtilPublicar.notificarErrorDuranteBaja(edicto,
				        "No se ha podido firmar la diligencia con sello de órgano. Se abortará el proceso de baja. Se volverá a intetar automáticamente más tarde.");
				log.error("No se ha podido firmar la diligencia con sello de órgano. Se abortará el proceso de baja. Se volverá a intentar automáticamente más tarde.");
				
			}
			
			if (bajaCorrecta) {
				try {
					if (diligenciafirmada != null) {
						Date fechaHastaAux = FechasUtil.addDays(fecha, -1);
						edicto.setFechaUltimaModificacion(fecha);
						edicto.setFechaRetirada(fechaHastaAux);
						bajaCorrecta = UtilPublicar.guardarEdictoConDiligencia(edicto, diligenciafirmada);
						if (!bajaCorrecta) {
							log.error("No se ha podido realizar la baja. Se ha producido un error al almacenar Documento o registrar en VFE. Se abortará el proceso de baja. Se volverá a intentar automáticamente más tarde.");
							UtilPublicar
							        .notificarErrorDuranteBaja(edicto,
							                "No se ha podido realizar la baja. Se ha producido un error al almacenar Documento o registrar en VFE. Se volverá a intentar automáticamente más tarde.");
						}
						if (bajaCorrecta) {
							log.debug("urlCertificado a dar de baja: " + edicto.getUrl());
							bajaCorrecta = UtilPublicar.darDeBaja(edicto.getUrl());
							edicto.setEstado(estadoRetirado);
							
							edicto.setFechaRetirada(fechaHastaAux);
							edicto.setFechaUltimaModificacion(fecha);
							edictoService.attachDirty(edicto);
							if (!bajaCorrecta) {
								log.error("Se ha producido un error al realizar la baja en Fandango. Será necesario realizar la baja del certificado manualmente desde el panel de administración de  Fandango.");
								UtilPublicar.notificarErrorDuranteBaja(edicto, "No se ha podido realizar la baja del certificado de exposición de Fandango.");
								
							}
							
						}
						
					} else {
						bajaCorrecta = false;
					}
					
				} catch (Exception e) {
					bajaCorrecta = false;
					log.error(e, e);
				}
			}
			log.debug("bajaCorrecta: " + bajaCorrecta);
			if (bajaCorrecta) {
				if (edicto.getRedesSociales().equals("SI")) {
					UtilRedesSociales.despublicarRedesSociales(edicto);
				}
				UtilPublicar.notificarBajaPublicacion(edicto, "Baja Automatica");
				// edictoService.attachDirty(edicto);
			} else {
				edicto.setFirmaDiligencia("");
				edicto.setDiligencia("");
				edicto.setTipoFirmaDiligencia("");
				edicto.setEstado(estadoPublicado);
				
				edicto.setFechaRetirada(null);
				edicto.setFechaUltimaModificacion(ultimaModificacion);
				edictoService.attachDirty(edicto);
				
			}
			log.info("Baja exitosa de anuncio " + edicto.getCodigo() + " con titulo " + edicto.getTitulo());
			
		} catch (Exception e) {
			bajaCorrecta = false;
			log.error(e, e);
		}
		
		return bajaCorrecta;
	}
}
