package es.accv.fandango.services.CertificacionPublicacion;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.apache.axis.EngineConfiguration;

import webservice.fandango.accv.es.InformacionCertificadoPublicacion;

public class CertificacionPublicacionWSClient implements
		CertificacionPublicacionWS {
	private String _endpoint = null;

	private CertificacionPublicacionWS certificacionPublicacionWS = null;

	public CertificacionPublicacionWSClient(EngineConfiguration engineConfig) {
		_initCertificacionPublicacionWSProxy(engineConfig);
	}

	private void _initCertificacionPublicacionWSProxy(
			EngineConfiguration engineConfig) {
		try {
			certificacionPublicacionWS = (new CertificacionPublicacionWSServiceLocator(
					engineConfig)).getCertificacionPublicacion();
			if (certificacionPublicacionWS != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) certificacionPublicacionWS)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) certificacionPublicacionWS)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
			serviceException.printStackTrace();
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (certificacionPublicacionWS != null)
			((javax.xml.rpc.Stub) certificacionPublicacionWS)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public String getCertificadoPublicacion(String urlDocumento,
			String firmaB64, int tipoFirma, String titulo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS.getCertificadoPublicacion(
				urlDocumento, firmaB64, tipoFirma, titulo);
	}

	public String getCertificadoPublicacionPdf(String urlPdf, String titulo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS.getCertificadoPublicacionPdf(urlPdf,
				titulo);
	}

	public String getCertificadoPublicacionTodasOpciones(String urlDocumento,
			String firmaB64, int tipoFirma, String titulo,
			boolean subirCustodia, boolean isRevisable) throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS
				.getCertificadoPublicacionTodasOpciones(urlDocumento, firmaB64,
						tipoFirma, titulo, subirCustodia, isRevisable);
	}

	public CertificacionPublicacionWS getCertificacionPublicacionWS() {
		return certificacionPublicacionWS;
	}

	public void darDeAlta(String urlCertificadoPublicacion)
			throws RemoteException {
		// TODO Auto-generated method stub
		certificacionPublicacionWS.darDeAlta(urlCertificadoPublicacion);
	}

	public void darDeBaja(String urlCertificadoPublicacion)
			throws RemoteException {
		// TODO Auto-generated method stub
		certificacionPublicacionWS.darDeBaja(urlCertificadoPublicacion);
	}

	public InformacionCertificadoPublicacion getInformacionCertificado(
			String urlCertificadoPublicacion) throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS
				.getInformacionCertificado(urlCertificadoPublicacion);
	}

	public InformacionCertificadoPublicacion[] getInformacionCertificados(
			Calendar fechaDesde, Calendar fechaHasta, boolean soloActivos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS.getInformacionCertificados(
				fechaDesde, fechaHasta, soloActivos);
	}

	public String getPDFCertificado(String urlCertificadoPublicacion)
			throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS
				.getPDFCertificado(urlCertificadoPublicacion);
	}

	public String getPDFInformeRevisiones(String urlCertificadoPublicacion)
			throws RemoteException {
		// TODO Auto-generated method stub
		return certificacionPublicacionWS
				.getPDFInformeRevisiones(urlCertificadoPublicacion);
	}

}
