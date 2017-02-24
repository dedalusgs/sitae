/**
 * StampService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.ws.sta;

public class StampService_ServiceLocator extends org.apache.axis.client.Service implements es.novasoft.sitae.ws.sta.StampService_Service {

    public StampService_ServiceLocator() {
    }


    public StampService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StampService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StampServicePort
    private java.lang.String StampServicePort_address = "http://127.0.0.1:80/services/MuleSTA";

    public java.lang.String getStampServicePortAddress() {
        return StampServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StampServicePortWSDDServiceName = "StampServicePort";

    public java.lang.String getStampServicePortWSDDServiceName() {
        return StampServicePortWSDDServiceName;
    }

    public void setStampServicePortWSDDServiceName(java.lang.String name) {
        StampServicePortWSDDServiceName = name;
    }

    public es.novasoft.sitae.ws.sta.StampService_PortType getStampServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StampServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStampServicePort(endpoint);
    }

    public es.novasoft.sitae.ws.sta.StampService_PortType getStampServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.novasoft.sitae.ws.sta.StampServiceHTTPBindingStub _stub = new es.novasoft.sitae.ws.sta.StampServiceHTTPBindingStub(portAddress, this);
            _stub.setPortName(getStampServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStampServicePortEndpointAddress(java.lang.String address) {
        StampServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.novasoft.sitae.ws.sta.StampService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                es.novasoft.sitae.ws.sta.StampServiceHTTPBindingStub _stub = new es.novasoft.sitae.ws.sta.StampServiceHTTPBindingStub(new java.net.URL(StampServicePort_address), this);
                _stub.setPortName(getStampServicePortWSDDServiceName());
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
        if ("StampServicePort".equals(inputPortName)) {
            return getStampServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:es:castellon:sigex:stampservice:v1.0", "StampService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:es:castellon:sigex:stampservice:v1.0", "StampServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StampServicePort".equals(portName)) {
            setStampServicePortEndpointAddress(address);
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
