/**
 * SitaeService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class SitaeService_ServiceLocator extends org.apache.axis.client.Service implements es.novasoft.sitae.perfiles.ws.SitaeService_Service {

    public SitaeService_ServiceLocator() {
    }


    public SitaeService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SitaeService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SitaeService
    private java.lang.String SitaeService_address = "http://adminsitae.dipcas.es/sitae/services/SitaeService";

    public java.lang.String getSitaeServiceAddress() {
        return SitaeService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SitaeServiceWSDDServiceName = "SitaeService";

    public java.lang.String getSitaeServiceWSDDServiceName() {
        return SitaeServiceWSDDServiceName;
    }

    public void setSitaeServiceWSDDServiceName(java.lang.String name) {
        SitaeServiceWSDDServiceName = name;
    }

    public es.novasoft.sitae.perfiles.ws.SitaeService_PortType getSitaeService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SitaeService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSitaeService(endpoint);
    }

    public es.novasoft.sitae.perfiles.ws.SitaeService_PortType getSitaeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.novasoft.sitae.perfiles.ws.SitaeServiceSoapBindingStub _stub = new es.novasoft.sitae.perfiles.ws.SitaeServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSitaeServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSitaeServiceEndpointAddress(java.lang.String address) {
        SitaeService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.novasoft.sitae.perfiles.ws.SitaeService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                es.novasoft.sitae.perfiles.ws.SitaeServiceSoapBindingStub _stub = new es.novasoft.sitae.perfiles.ws.SitaeServiceSoapBindingStub(new java.net.URL(SitaeService_address), this);
                _stub.setPortName(getSitaeServiceWSDDServiceName());
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
        if ("SitaeService".equals(inputPortName)) {
            return getSitaeService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "SitaeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "SitaeService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SitaeService".equals(portName)) {
            setSitaeServiceEndpointAddress(address);
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
