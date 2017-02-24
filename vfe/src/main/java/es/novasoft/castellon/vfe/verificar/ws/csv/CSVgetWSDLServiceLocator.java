/**
 * CSVgetWSDLServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.csv;

public class CSVgetWSDLServiceLocator extends org.apache.axis.client.Service
		implements CSVgetWSDLService {

	public CSVgetWSDLServiceLocator() {
	}

	public CSVgetWSDLServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public CSVgetWSDLServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for CSVgetWSDLPort
	private java.lang.String csvGetWSDLPortAddress = 
		"http://195.57.185.22/services/GetDocumentCsvSN";

	public java.lang.String getCSVgetWSDLPortAddress() {
		return csvGetWSDLPortAddress;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String csvGetWSDLPortWSDDServiceName = "CSVgetWSDLPort";

	public java.lang.String getCSVgetWSDLPortWSDDServiceName() {
		return csvGetWSDLPortWSDDServiceName;
	}

	public void setCSVgetWSDLPortWSDDServiceName(java.lang.String name) {
		csvGetWSDLPortWSDDServiceName = name;
	}

	public CSVgetWSDL getCSVgetWSDLPort() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(csvGetWSDLPortAddress);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getCSVgetWSDLPort(endpoint);
	}

	public CSVgetWSDL getCSVgetWSDLPort(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			CSVgetWSDLServiceSoapBindingStub _stub = new CSVgetWSDLServiceSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getCSVgetWSDLPortWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setCSVgetWSDLPortEndpointAddress(java.lang.String address) {
		csvGetWSDLPortAddress = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (CSVgetWSDL.class.isAssignableFrom(serviceEndpointInterface)) {
				CSVgetWSDLServiceSoapBindingStub _stub = new CSVgetWSDLServiceSoapBindingStub(
						new java.net.URL(csvGetWSDLPortAddress), this);
				_stub.setPortName(getCSVgetWSDLPortWSDDServiceName());
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
		if ("CSVgetWSDLPort".equals(inputPortName)) {
			return getCSVgetWSDLPort();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://interfaces.muleSN.xaloc.cv.com/", "CSVgetWSDLService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports
					.add(new javax.xml.namespace.QName(
							"http://interfaces.muleSN.xaloc.cv.com/",
							"CSVgetWSDLPort"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("CSVgetWSDLPort".equals(portName)) {
			setCSVgetWSDLPortEndpointAddress(address);
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
