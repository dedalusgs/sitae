/**
 * FirmaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.ws;

public class FirmaServiceLocator extends org.apache.axis.client.Service
		implements es.novasoft.sitae.ws.FirmaService {

	public FirmaServiceLocator() {
	}

	public FirmaServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public FirmaServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for FirmaServidor
	private java.lang.String FirmaServidor_address = "https://10.0.10.31:443/afirmaws/services/FirmaServidor";

	public java.lang.String getFirmaServidorAddress() {
		return FirmaServidor_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String FirmaServidorWSDDServiceName = "FirmaServidor";

	public java.lang.String getFirmaServidorWSDDServiceName() {
		return FirmaServidorWSDDServiceName;
	}

	public void setFirmaServidorWSDDServiceName(java.lang.String name) {
		FirmaServidorWSDDServiceName = name;
	}

	public es.novasoft.sitae.ws.Firma getFirmaServidor()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(FirmaServidor_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getFirmaServidor(endpoint);
	}

	public es.novasoft.sitae.ws.Firma getFirmaServidor(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			es.novasoft.sitae.ws.FirmaServidorSoapBindingStub _stub = new es.novasoft.sitae.ws.FirmaServidorSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getFirmaServidorWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setFirmaServidorEndpointAddress(java.lang.String address) {
		FirmaServidor_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (es.novasoft.sitae.ws.Firma.class
					.isAssignableFrom(serviceEndpointInterface)) {
				es.novasoft.sitae.ws.FirmaServidorSoapBindingStub _stub = new es.novasoft.sitae.ws.FirmaServidorSoapBindingStub(
						new java.net.URL(FirmaServidor_address), this);
				_stub.setPortName(getFirmaServidorWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("FirmaServidor".equals(inputPortName)) {
			return getFirmaServidor();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://afirmaws/services/FirmaServidor", "FirmaService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"http://afirmaws/services/FirmaServidor", "FirmaServidor"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("FirmaServidor".equals(portName)) {
			setFirmaServidorEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
