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

import javax.xml.rpc.ServiceException;

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

import es.juntadeandalucia.cice.verifirma.utils.StaticDesEncrypter;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.verificar.ws.pfirma.FirmaUtil;
import es.novasoft.castellon.vfe.verificar.ws.pfirma.PfServicioWSServiceLocator;
import es.novasoft.castellon.vfe.verificar.ws.pfirma.PfServicioWS_PortType;
import es.novasoft.comun.utils.FechasUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class PFirmaVerificaService.
 */
public class PFirmaVerificaService implements IVerificaService {
	
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
	private static final Log LOGGER = LogFactory
			.getLog(PFirmaVerificaService.class);

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

	/* (non-Javadoc)
	 * @see es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getNombreFichero()
	 */
	public String getNombreFichero() throws RemoteException {
		if (hashDoc == null) {
			throw new RemoteException("hash Inválido");
		}
		return nombreFichero;
	}

	/** The extension firma. */
	private String extensionFirma = "p7s";

	/** The codigo. */
	private String codigo;

	/**
	 * Sets the extension firma.
	 *
	 * @param extensionFirma the new extension firma
	 */
	public void setExtensionFirma(String extensionFirma) {
		this.extensionFirma = extensionFirma;
	}

	/* (non-Javadoc)
	 * @see es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getExtensionFirma()
	 */
	public String getExtensionFirma() throws RemoteException {
		if (hashDoc == null) {
			throw new RemoteException("hash Inválido");
		}
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
	public PFirmaVerificaService(String codePattern, String endpoint)
			throws MalformedURLException {
		super();
		this.codePattern = Pattern.compile(codePattern);
		this.endpoint = new URL(endpoint);
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
				hashDoc = StaticDesEncrypter.getInstance(key).decode(codigo);
				if (hashDoc != null) {
					LOGGER.debug("HashDoc : " + hashDoc);
					nombreFichero = NOMBRE_FICHERO;
					datosFirmante = new DatosFirmante();
					datosFirmante.setNombre(NOMBRE_ERROR);
					try {
						loadDatosFirmante(new String(getFirmaElectronica()));
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
	 * @param firmaXadesT the firma xades t
	 * @throws RemoteException the remote exception
	 */
	private void loadDatosFirmante(final String firmaXadesT)
			throws RemoteException {
		try {
			// Obtener Nombre
			String cert = firmaXadesT.substring(firmaXadesT
					.indexOf("<ds:X509Certificate>")
					+ "<ds:X509Certificate>".length(), firmaXadesT
					.indexOf("</ds:X509Certificate>"));
			loadDatosFirmanteCert(cert);

			// Obtener Fecha
			String timeStamp = firmaXadesT.substring(firmaXadesT
					.indexOf("<xades:SigningTime>")
					+ "<xades:SigningTime>".length(), firmaXadesT
					.indexOf("</xades:SigningTime>")-"-02:00".length());

			Date fechaAux = FechasUtil.convertStringToDate(timeStamp,
					FechasUtil.TYPESDFTIMESTAMP);

			datosFirmante.setFecha(FechasUtil.convertDateToString(
					fechaAux,
					FechasUtil.TYPESDFDATE));
			LOGGER.info("Fecha de la firma: "+datosFirmante.getFecha() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Load datos firmante cert.
	 *
	 * @param firma the firma
	 */
	private void loadDatosFirmanteCert(String firma) {

		try {
			ASN1StreamParser streamParser = new ASN1StreamParser(Base64
					.decode(firma));
			DEREncodable object = streamParser.readObject();
			DERObject derObject = object.getDERObject();
			ASN1Sequence asn1sequence = DERSequence.getInstance(derObject);

			DERSequence cert = (DERSequence) asn1sequence.getObjectAt(0);
			DERSequence signerInfo = (DERSequence) cert.getObjectAt(5);
			DERSet fullName = (DERSet) signerInfo.getObjectAt(0);
			DERSequence name = (DERSequence) fullName.getObjectAt(0);
			datosFirmante.setNombre(((DERPrintableString) name.getObjectAt(1))
					.getString());
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
		if (hashDoc == null) {
			throw new RemoteException("hash Inválido");
		}

		try {
			PfServicioWSServiceLocator locator = new PfServicioWSServiceLocator();
			PfServicioWS_PortType service = locator.getPfServicioWS(endpoint);
			return service.descargarDocumento(hashDoc);
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
		if (hashDoc == null) {
			throw new RemoteException("hash Inválido");
		}

		try {
			return FirmaUtil.obtenerDocumentoPortafirmas(getDocument(), codigo,
					datosFirmante.getFecha(), datosFirmante.getServidor(),
					datosFirmante.getNombre().split("-")[0]);
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

		if (hashDoc == null) {
			throw new RemoteException("hash Inválido");
		}

		try {
			PfServicioWSServiceLocator locator = new PfServicioWSServiceLocator();
			PfServicioWS_PortType service = locator.getPfServicioWS(endpoint);
			return service.descargarPKCS7(hashDoc, parseDouble(service
					.obtenerIdTransaccion(hashDoc)));
		} catch (ServiceException e) {
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
		return "PFirmaVerificaService";
	}

	/**
	 * Parses the double.
	 *
	 * @param d the d
	 * @return the string
	 */
	private static String parseDouble(double d) {
		DecimalFormat f = new DecimalFormat(DOUBLE_PATTERN);
		return f.format(d);
	}

	/* (non-Javadoc)
	 * @see es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDatosFirmante()
	 */
	public DatosFirmante getDatosFirmante() throws RemoteException {
		return datosFirmante;
	}

}
