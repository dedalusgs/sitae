/**
 * IAlmacenaryFirmarSelloWSDLServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.ws.sello;

public class IAlmacenaryFirmarSelloWSDLServiceLocator extends org.apache.axis.client.Service implements es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDLService {

    public IAlmacenaryFirmarSelloWSDLServiceLocator() {
    }


    public IAlmacenaryFirmarSelloWSDLServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IAlmacenaryFirmarSelloWSDLServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IAlmacenaryFirmarSelloWSDLPort
    private java.lang.String IAlmacenaryFirmarSelloWSDLPort_address = "http://195.57.185.24/services/AlmacenaryFirmarSello";

    public java.lang.String getIAlmacenaryFirmarSelloWSDLPortAddress() {
        return IAlmacenaryFirmarSelloWSDLPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IAlmacenaryFirmarSelloWSDLPortWSDDServiceName = "IAlmacenaryFirmarSelloWSDLPort";

    public java.lang.String getIAlmacenaryFirmarSelloWSDLPortWSDDServiceName() {
        return IAlmacenaryFirmarSelloWSDLPortWSDDServiceName;
    }

    public void setIAlmacenaryFirmarSelloWSDLPortWSDDServiceName(java.lang.String name) {
        IAlmacenaryFirmarSelloWSDLPortWSDDServiceName = name;
    }

    public es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDL getIAlmacenaryFirmarSelloWSDLPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IAlmacenaryFirmarSelloWSDLPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIAlmacenaryFirmarSelloWSDLPort(endpoint);
    }

    public es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDL getIAlmacenaryFirmarSelloWSDLPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDLServiceSoapBindingStub _stub = new es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDLServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIAlmacenaryFirmarSelloWSDLPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIAlmacenaryFirmarSelloWSDLPortEndpointAddress(java.lang.String address) {
        IAlmacenaryFirmarSelloWSDLPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDL.class.isAssignableFrom(serviceEndpointInterface)) {
                es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDLServiceSoapBindingStub _stub = new es.novasoft.sitae.ws.sello.IAlmacenaryFirmarSelloWSDLServiceSoapBindingStub(new java.net.URL(IAlmacenaryFirmarSelloWSDLPort_address), this);
                _stub.setPortName(getIAlmacenaryFirmarSelloWSDLPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IAlmacenaryFirmarSelloWSDLPort".equals(inputPortName)) {
            return getIAlmacenaryFirmarSelloWSDLPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://interfaces.muleAF.xaloc.cv.com/", "IAlmacenaryFirmarSelloWSDLService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://interfaces.muleAF.xaloc.cv.com/", "IAlmacenaryFirmarSelloWSDLPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IAlmacenaryFirmarSelloWSDLPort".equals(portName)) {
            setIAlmacenaryFirmarSelloWSDLPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
