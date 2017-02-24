/**
 * AnuncioService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.externo.ws;

public class AnuncioService_ServiceLocator extends org.apache.axis.client.Service implements es.novasoft.sitae.perfiles.externo.ws.AnuncioService_Service {

    public AnuncioService_ServiceLocator() {
    }


    public AnuncioService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AnuncioService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AnuncioService
    private java.lang.String AnuncioService_address = "http://webgesdes.uv.es/uvTaeWeb/services/AnuncioService";

    public java.lang.String getAnuncioServiceAddress() {
        return AnuncioService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AnuncioServiceWSDDServiceName = "AnuncioService";

    public java.lang.String getAnuncioServiceWSDDServiceName() {
        return AnuncioServiceWSDDServiceName;
    }

    public void setAnuncioServiceWSDDServiceName(java.lang.String name) {
        AnuncioServiceWSDDServiceName = name;
    }

    public es.novasoft.sitae.perfiles.externo.ws.AnuncioService_PortType getAnuncioService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AnuncioService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAnuncioService(endpoint);
    }

    public es.novasoft.sitae.perfiles.externo.ws.AnuncioService_PortType getAnuncioService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.novasoft.sitae.perfiles.externo.ws.AnuncioServiceSoapBindingStub _stub = new es.novasoft.sitae.perfiles.externo.ws.AnuncioServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAnuncioServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAnuncioServiceEndpointAddress(java.lang.String address) {
        AnuncioService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.novasoft.sitae.perfiles.externo.ws.AnuncioService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                es.novasoft.sitae.perfiles.externo.ws.AnuncioServiceSoapBindingStub _stub = new es.novasoft.sitae.perfiles.externo.ws.AnuncioServiceSoapBindingStub(new java.net.URL(AnuncioService_address), this);
                _stub.setPortName(getAnuncioServiceWSDDServiceName());
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
        if ("AnuncioService".equals(inputPortName)) {
            return getAnuncioService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ttdev.com/ss", "AnuncioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ttdev.com/ss", "AnuncioService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AnuncioService".equals(portName)) {
            setAnuncioServiceEndpointAddress(address);
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
