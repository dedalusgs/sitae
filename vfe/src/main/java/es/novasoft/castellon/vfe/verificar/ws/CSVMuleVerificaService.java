/*
 * 
 */
package es.novasoft.castellon.vfe.verificar.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.regex.Pattern;

import javax.xml.rpc.ServiceException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.accv.arangi.base.certificate.Certificate;
import es.accv.arangi.signature.XAdESTSignature;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDL;
import es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDLServiceLocator;
import es.novasoft.castellon.vfe.verificar.ws.csv.CSVgetWSDL;
import es.novasoft.castellon.vfe.verificar.ws.csv.CSVgetWSDLServiceLocator;
import es.novasoft.castellon.vfe.verificar.ws.csv.ContentDocumentResponse;
import es.novasoft.comun.utils.FechasUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class CVSMuleVerificaService.
 */
public class CSVMuleVerificaService implements IVerificaService {
	// Codigo de Ejemplo del codigo de mule 3D0541F9-094F2BCC-505B7DD7-50DCFDC
	// xxxxxxxx-xxxxxxxx-xxxxxxxx-xxxxxxx
	// 652DB5F0-4E4A1DC0-63DA5A89-D66AE69
	// w8-w8-w8-w7
	/** The Constant NOMBRE_ERROR. */
	private static final String NOMBRE_ERROR = "Error al leer el certificado.";

	/** The code pattern. */
	private final Pattern codePattern;

	/** The response. */
	private ContentDocumentResponse response;
	/** The endpoint. */
	private final URL endpoint;

	/** The endpoint creacion csv. */
	private URL endpointCreacionCSV;

	/** The datos firmante. */
	private DatosFirmante datosFirmante;
	/** The nombre fichero. */
	private String nombreFichero;

	private static final Log LOGGER = LogFactory.getLog(CSVMuleVerificaService.class);

	private String codigo;

	/**
	 * Sets the endpoint creacion csv.
	 * 
	 * @param endpoint
	 *            the new endpoint creacion csv
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	public void setEndpointCreacionCSV(String endpoint) throws MalformedURLException {
		endpointCreacionCSV = new URL(endpoint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getNombreFichero
	 * ()
	 */
	public String getNombreFichero() throws RemoteException {
		if (response == null) {
			throw new RemoteException("No se ha realizado la Verificacion");
		}
		return nombreFichero;
	}

	/** The extension firma. */
	private String extensionFirma = "xml";

	private String entidadLocal;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getExtensionFirma
	 * ()
	 */
	public String getExtensionFirma() throws RemoteException {
		if (response == null) {
			throw new RemoteException("No se ha realizado la Verificacion");
		}
		return extensionFirma;
	}

	public void setExtensionFirma(String extensionFirma) {
		this.extensionFirma = extensionFirma;
	}

	/**
	 * Instantiates a new cVS mule verifica service.
	 * 
	 * @param codePattern
	 *            the code pattern
	 * @param endpoint
	 *            the endpoint
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	public CSVMuleVerificaService(String codePattern, String endpoint) throws MalformedURLException {
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
	public boolean checkCodigo(String codigo, Organismo org) {
		boolean respuesta = codePattern.matcher(codigo).find();
		if (respuesta == true) {
			try {
				CSVgetWSDLServiceLocator locator = new CSVgetWSDLServiceLocator();
				CSVgetWSDL ws = locator.getCSVgetWSDLPort(endpoint);
				response = ws.validaDocumentCsvSN(codigo);
				if (response.getErrors() != null && response.getErrors().length > 0) {
					respuesta = false;
				} else {
					nombreFichero = response.getName();
					datosFirmante = new DatosFirmante();
					entidadLocal = org.getCodigo();
					datosFirmante.setNombre(NOMBRE_ERROR);
					if (response.getArrayOfSigner() != null) {
						datosFirmante.setNombre(response.getArrayOfSigner(0).getName());
					}
					byte[] firma = this.getFirmaElectronica();
					if (firma != null) {
						String firmaString = new String(firma);
						LOGGER.debug("FirmaXades:\n " + firmaString);
						String timeStamp = firmaString.substring(firmaString.indexOf("<xades:SigningTime>") + "<xades:SigningTime>".length(),
								firmaString.indexOf("</xades:SigningTime>") - "+01:00".length());

						Date fechaAux = FechasUtil.convertStringToDate(timeStamp, FechasUtil.TYPESDFTIMESTAMP);

						datosFirmante.setFecha(FechasUtil.convertDateToString(fechaAux, FechasUtil.TYPESDFDATE));
						LOGGER.info("Fecha de la firma: " + datosFirmante.getFecha());
						try {
							XAdESTSignature firmaXades = new XAdESTSignature(firma);
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
							LOGGER.error("Error interpretando firma xades ", e);
						}

					}
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDocument(java
	 * .lang.String)
	 */
	public byte[] getDocument() throws RemoteException {
		if (response == null) {
			throw new RemoteException("No se ha realizado la Verificacion");
		}
		return new Base64().decode(response.getContent());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDocument(java
	 * .lang.String)
	 */
	public byte[] getDocumentoFirmado() throws RemoteException {
		if (response == null) {
			throw new RemoteException("No se ha realizado la Verificacion");
		}
		try {
			CSVCreationWSDLServiceLocator locator = new CSVCreationWSDLServiceLocator();
			CSVCreationWSDL ws = locator.getCSVCreationWSDLPort(endpointCreacionCSV);
			String[] idEntidadLocalSplit = response.getArrayOfSigner(0).getContent().getName().split("-");
			String idEntidadLocal = idEntidadLocalSplit[2] + "-" + idEntidadLocalSplit[3];
			String uuid = response.getName();
			return new Base64().decode(ws.createDocumentCsvSN(idEntidadLocal, uuid).getContent());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			throw new RemoteException("Error al llamar al ws de CreateCSV");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RemoteException("Error al parsear el nombre de la firma");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CVSMuleVerificaService";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getFirmaElectronica
	 * (java.lang.String)
	 */
	public byte[] getFirmaElectronica() throws RemoteException {
		if (response == null) {
			throw new RemoteException("No se ha realizado la Verificacion");
		}
		return new Base64().decode(new Base64().decode(response.getArrayOfSigner(0).getContent().getContent()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.castellon.vfe.verificar.ws.IVerificaService#getDatosFirmante
	 * ()
	 */
	public DatosFirmante getDatosFirmante() throws RemoteException {
		// TODO Auto-generated method stub
		return datosFirmante;
	}

}
