package es.accv.fandango.services.CertificacionPublicacion;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;

import es.novasoft.sitae.ws.fandango.FandangoClient;
import es.novasoft.sitae.ws.fandango.InformacionCertificadoPublicacion;

public class ACCVFandangoClientImpl implements FandangoClient{

	private String endPoint;
	private String rutaConfig;
	
	
	
	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endpoint) {
		this.endPoint = endpoint;
	}

	public String getRutaConfig() {
		return rutaConfig;
	}

	public void setRutaConfig(String rutaConfig) {
		this.rutaConfig = rutaConfig;
	}

	public void darDeAlta(String urlCertificadoPublicacion)
	throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
	client.darDeAlta(urlCertificadoPublicacion);
}

public void darDeBaja(String urlCertificadoPublicacion)
	throws RemoteException {
// TODO Auto-generated method stub
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
	client.darDeBaja(urlCertificadoPublicacion);

}

public String getCertificadoPublicacion(String urlDocumento,
	String firmaB64, int tipoFirma, String titulo)
	throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
	return client.getCertificadoPublicacion(urlDocumento, firmaB64, tipoFirma, titulo);

}

public String getCertificadoPublicacionPdf(String urlPdf, String titulo)
	throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
return client.getCertificadoPublicacionPdf(urlPdf, titulo);
}

public String getCertificadoPublicacionTodasOpciones(String urlDocumento,
	String firmaB64, int tipoFirma, String titulo,
	boolean subirCustodia, boolean isRevisable) throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
return client.getCertificadoPublicacionTodasOpciones(urlDocumento, firmaB64, tipoFirma, titulo, subirCustodia, isRevisable);
}

public InformacionCertificadoPublicacion getInformacionCertificado(
	String urlCertificadoPublicacion) throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
webservice.fandango.accv.es.InformacionCertificadoPublicacion infoCert= client.getInformacionCertificado(urlCertificadoPublicacion);
return transformInformacionCertificadoPublicacion(infoCert);
}

private InformacionCertificadoPublicacion transformInformacionCertificadoPublicacion(
		webservice.fandango.accv.es.InformacionCertificadoPublicacion infoCert) {
	InformacionCertificadoPublicacion retCert = new InformacionCertificadoPublicacion();
	retCert.setActivo(infoCert.isActivo());
	retCert.setFecha(infoCert.getFecha());
	retCert.setRevisable(infoCert.isRevisable());
	retCert.setTitulo(infoCert.getTitulo());
	retCert.setUrlCertificadoPublicacion(infoCert.getUrlCertificadoPublicacion());
	retCert.setUrlDocumento(infoCert.getUrlDocumento());
	return retCert;
}

public InformacionCertificadoPublicacion[] getInformacionCertificados(
	Calendar fechaDesde, Calendar fechaHasta, boolean soloActivos)
	throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
webservice.fandango.accv.es.InformacionCertificadoPublicacion[] inforCertis = client.getInformacionCertificados(fechaDesde, fechaHasta, soloActivos);

InformacionCertificadoPublicacion[] retCerts = new InformacionCertificadoPublicacion[inforCertis.length];
for (int i = 0; i< retCerts.length; i++) {
	retCerts[i] = transformInformacionCertificadoPublicacion(inforCertis[i]);
}
return retCerts;
}

public String getPDFCertificado(String urlCertificadoPublicacion)
	throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
return client.getPDFCertificado(urlCertificadoPublicacion);
}

public String getPDFInformeRevisiones(String urlCertificadoPublicacion)
	throws RemoteException {
	EngineConfiguration axisConfig = new FileProvider(rutaConfig);
	CertificacionPublicacionWSClient client = new CertificacionPublicacionWSClient(axisConfig);
	client.setEndpoint(endPoint);
return client.getPDFInformeRevisiones(urlCertificadoPublicacion);
}

}
