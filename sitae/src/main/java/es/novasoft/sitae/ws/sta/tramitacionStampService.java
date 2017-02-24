package es.novasoft.sitae.ws.sta;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.axis.client.Stub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.xml.rpc.ServiceException;

public class tramitacionStampService {

	private static final Log LOG = LogFactory
			.getLog(es.novasoft.sitae.ws.sta.tramitacionStampService.class);
	private String endpoint;

	String timeout;
	String idAplicacion;
	StampService_ServiceLocator secServer;
	private String job;
	private String name;
	private String province;
	private String service;

	public tramitacionStampService(String properties) {
		secServer = new StampService_ServiceLocator();
		if (properties != null) {
			Properties prop = new Properties();
			try {
				prop.load(new ByteArrayInputStream(properties.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			job = "StampService";
			name = prop.getProperty("tituloEntidad_es");
			province = prop.getProperty("entidadLocal");
			service = "StampService";
			endpoint = prop.getProperty("endpoint5");
			timeout = prop.getProperty("timeout5");
			idAplicacion = prop.getProperty("idAplicacion5");
			if (endpoint != null)
				secServer
						.setStampServicePortEndpointAddress((new StringBuilder(
								String.valueOf(endpoint))).append("/MuleSTA")
								.toString());
			if (timeout == null || timeout.equals(""))
				timeout = "45000";
		}
	}

	public String marcarDocumento(String fichero) throws ServiceException,
			MalformedURLException {
		StampService_PortType service = secServer.getStampServicePort(new URL(
				secServer.getStampServicePortAddress()));
		((Stub) service).setTimeout(Integer.parseInt(timeout));

		LOG.debug("URL endpoint :: "
				+ new URL(secServer.getStampServicePortAddress()));
		LOG.debug("FICHERO :: " + fichero);
		ContentDocument contentDocument = new ContentDocument();
		contentDocument.setContent(fichero.getBytes());

		try {
			Response response = service.waterMark(contentDocument);
			LOG.debug("RESP XML MARCA AGUA ::"
					+ new String(procesarResponse(response)));
			return new String(procesarResponse(response));

		} catch (Exception e) {
			LOG.error((new StringBuilder(
					"ERROR:: Marca Agua Documento. \nMensaje:")).append(
					e.getMessage()).append("\nXmlEntrada:\n").append(
					contentDocument.getContent()).toString());
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	public String marcarDocumento(byte[] fichero) throws ServiceException,
			MalformedURLException {
		StampService_PortType service = secServer.getStampServicePort(new URL(
				secServer.getStampServicePortAddress()));
		((Stub) service).setTimeout(Integer.parseInt(timeout));

		LOG.debug("FICHERO ::" + new String(fichero));
		ContentDocument contentDocument = new ContentDocument();
		contentDocument.setContent(Base64.encode(fichero).getBytes());

		try {
			Response response = service.waterMark(contentDocument);
			LOG.debug("RESP XML MARCA AGUA BYTE::"
					+ new String(procesarResponse(response)));
			return new String(procesarResponse(response));
		} catch (Exception e) {
			LOG.error((new StringBuilder(
					"ERROR:: Marca Agua Documento byte[]. \nMensaje:")).append(
					e.getMessage()).append("\nXmlEntrada:\n").append(
					contentDocument.getContent()).toString());
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	public String sellarDocumento(byte[] fichero, int pos)
			throws ServiceException, MalformedURLException {
		StampService_PortType service_port = secServer
				.getStampServicePort(new URL(secServer
						.getStampServicePortAddress()));
		((Stub) service_port).setTimeout(Integer.parseInt(timeout));

		Signer signer = new Signer();

		signer.setContent(fichero);
		signer.setJob(job);
		signer.setName(name);
		signer.setPos(BigInteger.valueOf(pos));
		signer.setProvince(province);
		signer.setService(service);

		try {
			Response response = service_port.stamp(signer);
			return new String(procesarResponse(response));
		} catch (Exception e) {
			LOG.error((new StringBuilder(
					"ERROR:: Sellar Documento byte. \nMensaje:")).append(
					e.getMessage()).append("\nXmlEntrada:\n").append(
					signer.toString()).toString());
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	public String sellarDocumento(String fichero, int pos)
			throws ServiceException, MalformedURLException {
		StampService_PortType service_port = secServer
				.getStampServicePort(new URL(secServer
						.getStampServicePortAddress()));
		((Stub) service_port).setTimeout(Integer.parseInt(timeout));

		Signer signer = new Signer();
		signer.setContent(fichero.getBytes());
		signer.setJob(job);
		signer.setName(name);
		signer.setPos(BigInteger.valueOf(pos));
		signer.setProvince(province);
		signer.setService(service);

		try {
			Response response = service_port.stamp(signer);
			return Base64.encode(procesarResponse(response));
		} catch (Exception e) {
			LOG
					.error((new StringBuilder(
							"ERROR:: Sellar Documento. \nMensaje:")).append(
							e.getMessage()).append("\nXmlEntrada:\n").append(
							signer.toString()).toString());
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	private boolean hasErrors(Response response) {
		if (response.getContent() != null) {
			return false;
		} else {
			return true;
		}
	}

	private byte[] procesarResponse(Response response) throws ServiceException {
		if (hasErrors(response)) {
			String respError = "";
			for (StampError err : response.getStampError()) {
				respError += err.getCode() + " : " + err.getDescription()
						+ " | ";
			}
			LOG.error(respError);
			throw new ServiceException(respError);
		}
		return Base64.decode(new String(response.getContent()));
	}
}
