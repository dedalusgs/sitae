package es.novasoft.sitae.ws.fandango;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

public class MuleFandangoClientImpl implements FandangoClient {

	String endPoint;

	
	
	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public void darDeAlta(String urlCertificadoPublicacion)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			CertificacionPublicacionWS client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
			client.darDeAlta(urlCertificadoPublicacion);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void darDeBaja(String urlCertificadoPublicacion)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			CertificacionPublicacionWS client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
			client.darDeBaja(urlCertificadoPublicacion);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCertificadoPublicacion(String urlDocumento,
			String firmaB64, int tipoFirma, String titulo)
			throws RemoteException {
		// TODO Auto-generated method stub

			CertificacionPublicacionWS client = null;
			try {
				client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return client.getCertificadoPublicacion(urlDocumento, firmaB64, tipoFirma, titulo);

	}

	public String getCertificadoPublicacionPdf(String urlPdf, String titulo)
			throws RemoteException {
		CertificacionPublicacionWS client = null;
		try {
			client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getCertificadoPublicacionPdf(urlPdf, titulo);
	}

	public String getCertificadoPublicacionTodasOpciones(String urlDocumento,
			String firmaB64, int tipoFirma, String titulo,
			boolean subirCustodia, boolean isRevisable) throws RemoteException {
		CertificacionPublicacionWS client = null;
		try {
			client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getCertificadoPublicacionTodasOpciones(urlDocumento, firmaB64, tipoFirma, titulo, subirCustodia, isRevisable);
	}

	public InformacionCertificadoPublicacion getInformacionCertificado(
			String urlCertificadoPublicacion) throws RemoteException {
		CertificacionPublicacionWS client = null;
		try {
			client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getInformacionCertificado(urlCertificadoPublicacion);
	}

	public InformacionCertificadoPublicacion[] getInformacionCertificados(
			Calendar fechaDesde, Calendar fechaHasta, boolean soloActivos)
			throws RemoteException {
		CertificacionPublicacionWS client = null;
		try {
			client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getInformacionCertificados(fechaDesde, fechaHasta, soloActivos);
	}

	public String getPDFCertificado(String urlCertificadoPublicacion)
			throws RemoteException {
		CertificacionPublicacionWS client = null;
		try {
			client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getPDFCertificado(urlCertificadoPublicacion);
	}

	public String getPDFInformeRevisiones(String urlCertificadoPublicacion)
			throws RemoteException {
		CertificacionPublicacionWS client = null;
		try {
			client = (new CertificacionPublicacionWSServiceLocator()).getCertificacionPublicacion(new URL(endPoint));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getPDFInformeRevisiones(urlCertificadoPublicacion);
	}


}
