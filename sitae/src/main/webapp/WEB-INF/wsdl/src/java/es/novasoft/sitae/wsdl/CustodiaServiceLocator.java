/**
 * CustodiaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.wsdl;

public class CustodiaServiceLocator extends org.apache.axis.client.Service implements es.novasoft.sitae.wsdl.CustodiaService {

    public CustodiaServiceLocator() {
    }


    public CustodiaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustodiaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AlmacenarDocumento
    private java.lang.String AlmacenarDocumento_address = "https://preafirma.accv.es:443/afirmaws/services/AlmacenarDocumento";

    public java.lang.String getAlmacenarDocumentoAddress() {
        return AlmacenarDocumento_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AlmacenarDocumentoWSDDServiceName = "AlmacenarDocumento";

    public java.lang.String getAlmacenarDocumentoWSDDServiceName() {
        return AlmacenarDocumentoWSDDServiceName;
    }

    public void setAlmacenarDocumentoWSDDServiceName(java.lang.String name) {
        AlmacenarDocumentoWSDDServiceName = name;
    }

    public es.novasoft.sitae.wsdl.Custodia getAlmacenarDocumento() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AlmacenarDocumento_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAlmacenarDocumento(endpoint);
    }

    public es.novasoft.sitae.wsdl.Custodia getAlmacenarDocumento(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.novasoft.sitae.wsdl.AlmacenarDocumentoSoapBindingStub _stub = new es.novasoft.sitae.wsdl.AlmacenarDocumentoSoapBindingStub(portAddress, this);
            _stub.setPortName(getAlmacenarDocumentoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAlmacenarDocumentoEndpointAddress(java.lang.String address) {
        AlmacenarDocumento_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.novasoft.sitae.wsdl.Custodia.class.isAssignableFrom(serviceEndpointInterface)) {
                es.novasoft.sitae.wsdl.AlmacenarDocumentoSoapBindingStub _stub = new es.novasoft.sitae.wsdl.AlmacenarDocumentoSoapBindingStub(new java.net.URL(AlmacenarDocumento_address), this);
                _stub.setPortName(getAlmacenarDocumentoWSDDServiceName());
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
        if ("AlmacenarDocumento".equals(inputPortName)) {
            return getAlmacenarDocumento();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://afirmaws/services/AlmacenarDocumento", "CustodiaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://afirmaws/services/AlmacenarDocumento", "AlmacenarDocumento"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AlmacenarDocumento".equals(portName)) {
            setAlmacenarDocumentoEndpointAddress(address);
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
