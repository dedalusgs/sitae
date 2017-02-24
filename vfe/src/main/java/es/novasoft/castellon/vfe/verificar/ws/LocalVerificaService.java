/*
 * 
 */
package es.novasoft.castellon.vfe.verificar.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.util.encoders.Base64;

import es.accv.arangi.base.certificate.Certificate;
import es.accv.arangi.signature.XAdESTSignature;
import es.novasoft.castellon.vfe.business.files.FactoryFileService;
import es.novasoft.castellon.vfe.business.files.FileService;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.objects.RegistroDocumento;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.castellon.vfe.business.services.interfaz.RegistroDocumentoService;
import es.novasoft.castellon.vfe.csv.GeneradorPDFcsv;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class PFirmaVerificaService.
 */
public class LocalVerificaService implements IVerificaService {

	/** The Constant NOMBRE_ERROR. */
	private static final String NOMBRE_ERROR = "Error al leer el certificado.";

	/** The Constant NOMBRE_FICHERO. */
	private static final String NOMBRE_FICHERO = "Documento";

	// Codigo de Ejemplo del codigo de pfirma 1
	// codigo : ea9s26KEBrjA0orSzm2c+X5CKCJ3NmbA
	// clave: claveDecode.1
	// id Transaccion: 1325595602866661
	// Hash: YhzuYopXFH

	// Codigo de Ejemplo del codigo de pfirma 2
	// codigo = Hash : McWIIZ0ddMY61ufqozavsA==

	/** The Constant DOUBLE_PATTERN. */
	private static final String DOUBLE_PATTERN = "##############################";

	/** The Constant LOGGER. */
	private static final Log LOGGER = LogFactory.getLog(LocalVerificaService.class);

	/** The code pattern. */
	private Pattern codePattern;

	/** The endpoint. */
	private URL endpoint;

	/** The hash doc. */
	private String hashDoc;

	/** The key. */
	private String key;

	/** The mime type. */
	private String nombreFichero;

	/** The datos firmante. */
	private DatosFirmante datosFirmante;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getNombreFichero
	 * ()
	 */
	public String getNombreFichero() throws RemoteException {
		if (null == nombreFichero) {
			throw new RemoteException("Nombre no encontrado");
		}
		return nombreFichero;
	}

	/** The extension firma. */
	private String extensionFirma = "xml";

	/** The codigo. */
	private String codigo;

	/**
	 * Sets the extension firma.
	 *
	 * @param extensionFirma
	 *            the new extension firma
	 */
	public void setExtensionFirma(String extensionFirma) {
		this.extensionFirma = extensionFirma;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getExtensionFirma
	 * ()
	 */
	public String getExtensionFirma() throws RemoteException {

		return extensionFirma;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Instantiates a new p firma verifica service.
	 * 
	 * @param codePattern
	 *            the code pattern
	 * @param endpoint
	 *            the endpoint
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	public LocalVerificaService(String codePattern) throws MalformedURLException {
		super();
		this.codePattern = Pattern.compile(codePattern);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#checkCodigo(java
	 * .lang.String)
	 */
	public boolean checkCodigo(String codigoCheck, Organismo org) {
		codigo = codigoCheck;
		if (codePattern.matcher(codigo).find()) {
			try {
				RegistroDocumentoService registroService = (RegistroDocumentoService) Factory.getBean("RegistroDocumentoService");
				RegistroDocumento registro = registroService.findRegistroDocumentoByCSV(codigo);
				if (registro == null) {
					return false;
				} else {

					nombreFichero = registro.getNombreFichero();
					datosFirmante = new DatosFirmante();
					datosFirmante.setNombre(NOMBRE_ERROR);
					try {
						loadDatosFirmante(getFirmaElectronica());
						// Obtener Servidor
						datosFirmante.setServidor(org.getDominio());
					} catch (Exception e) {
						LOGGER.error(e);
					}
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Load datos firmante.
	 *
	 * @param firmaXadesT
	 *            the firma xades t
	 * @throws RemoteException
	 *             the remote exception
	 */
	private void loadDatosFirmante(byte[] firmaXadesT) throws RemoteException {
		try {
			// Obtener Nombre
			String firmaString = new String(firmaXadesT, "UTF-8");
			LOGGER.debug("FirmaXades:\n " + firmaString);
			String timeStamp = firmaString.substring(firmaString.indexOf("<xades:SigningTime>") + "<xades:SigningTime>".length(), firmaString.indexOf("</xades:SigningTime>") - "+01:00".length());

			Date fechaAux = FechasUtil.convertStringToDate(timeStamp, FechasUtil.TYPESDFTIMESTAMP);

			datosFirmante.setFecha(FechasUtil.convertDateToString(fechaAux, FechasUtil.TYPESDFDATE));
			LOGGER.info("Fecha de la firma: " + datosFirmante.getFecha());

			XAdESTSignature firmaXades = new XAdESTSignature(firmaXadesT);
			Certificate[] certificados = firmaXades.getCertificates();
			if (certificados.length > 0) {
				String nombreFirmantes = "";
				for (int i = 0; i < certificados.length; i++) {
					Certificate certificado = certificados[i];
					LOGGER.debug("Certificado de la firma:  " + certificado);
					if (i > 0) {
						nombreFirmantes += " ; ";
					}
					String cadenaDescrip = certificado.getSubjectDN();
					String[] campos = cadenaDescrip.split(",");
					for (int j = 0; j < campos.length; j++) {
						if (campos[j].contains("CN=")) {
							nombreFirmantes += campos[j].substring(3) + " - ";
						}
						if (campos[j].contains("O=")) {
							nombreFirmantes += campos[j].substring(2);
						}
					}

				}
				datosFirmante.setNombre(nombreFirmantes);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * Load datos firmante cert.
	 *
	 * @param firma
	 *            the firma
	 */
	private void loadDatosFirmanteCert(String firma) {

		try {
			ASN1StreamParser streamParser = new ASN1StreamParser(Base64.decode(firma));
			DEREncodable object = streamParser.readObject();
			DERObject derObject = object.getDERObject();
			ASN1Sequence asn1sequence = DERSequence.getInstance(derObject);

			DERSequence cert = (DERSequence) asn1sequence.getObjectAt(0);
			DERSequence signerInfo = (DERSequence) cert.getObjectAt(5);
			DERSet fullName = (DERSet) signerInfo.getObjectAt(0);
			DERSequence name = (DERSequence) fullName.getObjectAt(0);
			datosFirmante.setNombre(((DERPrintableString) name.getObjectAt(1)).getString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDocument(java
	 * .lang.String)
	 */
	public final byte[] getDocument() throws RemoteException {
		// TODO Auto-generated method stub

		RegistroDocumentoService registroService = (RegistroDocumentoService) Factory.getBean("RegistroDocumentoService");
		FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
		RegistroDocumento registro = registroService.findRegistroDocumentoByCSV(codigo);

		try {
			if (registro == null) {
				return null;
			} else {
				FileService fileService = factoryFileServices.getService(registro.getRutaFichero());

				return fileService.obtenerFichero(registro.getRutaFichero());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDocument(java
	 * .lang.String)
	 */
	public final byte[] getDocumentoFirmado() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			RegistroDocumentoService registroService = (RegistroDocumentoService) Factory.getBean("RegistroDocumentoService");
			FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
			RegistroDocumento registro = registroService.findRegistroDocumentoByCSV(codigo);
			OrganismoService organismoService = (OrganismoService) Factory.getBean("OrganismoService");
			Organismo organismo = (Organismo) organismoService.findByCodigo(registro.getCodAyto()).get(0);

			if (registro == null) {
				return null;
			} else {
				FileService fileService = factoryFileServices.getService(registro.getRutaFichero());
				byte[] pdf = GeneradorPDFcsv.pdfShrinkAddCsv(fileService.obtenerFicheroFile(registro.getRutaFichero()), registro.getCsv(), "https://" + organismo.getDominio() + "/vfe");
				return pdf;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage(), e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getFirmaElectronica
	 * (java.lang.String)
	 */
	public byte[] getFirmaElectronica() throws RemoteException {

		RegistroDocumentoService registroService = (RegistroDocumentoService) Factory.getBean("RegistroDocumentoService");
		FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");
		RegistroDocumento registro = registroService.findRegistroDocumentoByCSV(codigo);

		try {
			if (registro == null) {
				return null;
			} else {
				FileService fileService = factoryFileServices.getService(registro.getRutaFirma());

				return fileService.obtenerFichero(registro.getRutaFirma());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "LocalVerificaService";
	}

	/**
	 * Parses the double.
	 *
	 * @param d
	 *            the d
	 * @return the string
	 */
	private static String parseDouble(double d) {
		DecimalFormat f = new DecimalFormat(DOUBLE_PATTERN);
		return f.format(d);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDatosFirmante
	 * ()
	 */
	public DatosFirmante getDatosFirmante() throws RemoteException {
		return datosFirmante;
	}

}
