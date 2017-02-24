/**
 * CertificacionPublicacionWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.accv.fandango.services.CertificacionPublicacion;

public class CertificacionPublicacionWSServiceLocator extends
		org.apache.axis.client.Service
		implements
		es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionWSService {

	public CertificacionPublicacionWSServiceLocator() {
	}

	public CertificacionPublicacionWSServiceLocator(
			org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public CertificacionPublicacionWSServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for CertificacionPublicacion
	private java.lang.String CertificacionPublicacion_address = "https://sleipnir3.accv.es:8448/fandango/services/CertificacionPublicacion";

	public java.lang.String getCertificacionPublicacionAddress() {
		return CertificacionPublicacion_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String CertificacionPublicacionWSDDServiceName = "CertificacionPublicacion";

	public java.lang.String getCertificacionPublicacionWSDDServiceName() {
		return CertificacionPublicacionWSDDServiceName;
	}

	public void setCertificacionPublicacionWSDDServiceName(java.lang.String name) {
		CertificacionPublicacionWSDDServiceName = name;
	}

	public es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionWS getCertificacionPublicacion()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(CertificacionPublicacion_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getCertificacionPublicacion(endpoint);
	}

	public es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionWS getCertificacionPublicacion(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionSoapBindingStub _stub = new es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getCertificacionPublicacionWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setCertificacionPublicacionEndpointAddress(
			java.lang.String address) {
		CertificacionPublicacion_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionWS.class
					.isAssignableFrom(serviceEndpointInterface)) {
				es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionSoapBindingStub _stub = new es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionSoapBindingStub(
						new java.net.URL(CertificacionPublicacion_address),
						this);
				_stub.setPortName(getCertificacionPublicacionWSDDServiceName());
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
		if ("CertificacionPublicacion".equals(inputPortName)) {
			return getCertificacionPublicacion();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"https://sleipnir3.accv.es:8448/fandango/services/CertificacionPublicacion",
				"CertificacionPublicacionWSService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports
					.add(new javax.xml.namespace.QName(
							"https://sleipnir3.accv.es:8448/fandango/services/CertificacionPublicacion",
							"CertificacionPublicacion"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("CertificacionPublicacion".equals(portName)) {
			setCertificacionPublicacionEndpointAddress(address);
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
