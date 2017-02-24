/**
 * CSVCreationWSDLServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.csv;

public class CSVCreationWSDLServiceLocator extends
		org.apache.axis.client.Service implements
		es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDLService {

	public CSVCreationWSDLServiceLocator() {
	}

	public CSVCreationWSDLServiceLocator(
			org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public CSVCreationWSDLServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for CSVCreationWSDLPort
	private java.lang.String cSVCreationWSDLPortAddress = "http://premulebus.dipcas.es/services/CreateDocumentCsvSN";

	public java.lang.String getCSVCreationWSDLPortAddress() {
		return cSVCreationWSDLPortAddress;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String cSVCreationWSDLPortWSDDServiceName = "CSVCreationWSDLPort";

	public java.lang.String getCSVCreationWSDLPortWSDDServiceName() {
		return cSVCreationWSDLPortWSDDServiceName;
	}

	public void setCSVCreationWSDLPortWSDDServiceName(java.lang.String name) {
		cSVCreationWSDLPortWSDDServiceName = name;
	}

	public es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDL getCSVCreationWSDLPort()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(cSVCreationWSDLPortAddress);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getCSVCreationWSDLPort(endpoint);
	}

	public es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDL getCSVCreationWSDLPort(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDLServiceSoapBindingStub _stub = new es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDLServiceSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getCSVCreationWSDLPortWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setCSVCreationWSDLPortEndpointAddress(java.lang.String address) {
		cSVCreationWSDLPortAddress = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDL.class
					.isAssignableFrom(serviceEndpointInterface)) {
				es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDLServiceSoapBindingStub _stub = new es.novasoft.castellon.vfe.verificar.ws.csv.CSVCreationWSDLServiceSoapBindingStub(
						new java.net.URL(cSVCreationWSDLPortAddress), this);
				_stub.setPortName(getCSVCreationWSDLPortWSDDServiceName());
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
		if ("CSVCreationWSDLPort".equals(inputPortName)) {
			return getCSVCreationWSDLPort();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://interfaces.muleSN.xaloc.cv.com/",
				"CSVCreationWSDLService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"http://interfaces.muleSN.xaloc.cv.com/",
					"CSVCreationWSDLPort"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("CSVCreationWSDLPort".equals(portName)) {
			setCSVCreationWSDLPortEndpointAddress(address);
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
