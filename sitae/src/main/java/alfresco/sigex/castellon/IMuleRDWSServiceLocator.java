/**
 * IMuleRDWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package alfresco.sigex.castellon;

public class IMuleRDWSServiceLocator extends org.apache.axis.client.Service implements alfresco.sigex.castellon.IMuleRDWSService {

    public IMuleRDWSServiceLocator() {
    }


    public IMuleRDWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IMuleRDWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IMuleRDWSPort
    private java.lang.String IMuleRDWSPort_address = "http://localhost/services/MuleRDWS";

    public java.lang.String getIMuleRDWSPortAddress() {
        return IMuleRDWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IMuleRDWSPortWSDDServiceName = "IMuleRDWSPort";

    public java.lang.String getIMuleRDWSPortWSDDServiceName() {
        return IMuleRDWSPortWSDDServiceName;
    }

    public void setIMuleRDWSPortWSDDServiceName(java.lang.String name) {
        IMuleRDWSPortWSDDServiceName = name;
    }

    public alfresco.sigex.castellon.IMuleRDWS getIMuleRDWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IMuleRDWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIMuleRDWSPort(endpoint);
    }

    public alfresco.sigex.castellon.IMuleRDWS getIMuleRDWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            alfresco.sigex.castellon.IMuleRDWSServiceSoapBindingStub _stub = new alfresco.sigex.castellon.IMuleRDWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIMuleRDWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIMuleRDWSPortEndpointAddress(java.lang.String address) {
        IMuleRDWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (alfresco.sigex.castellon.IMuleRDWS.class.isAssignableFrom(serviceEndpointInterface)) {
                alfresco.sigex.castellon.IMuleRDWSServiceSoapBindingStub _stub = new alfresco.sigex.castellon.IMuleRDWSServiceSoapBindingStub(new java.net.URL(IMuleRDWSPort_address), this);
                _stub.setPortName(getIMuleRDWSPortWSDDServiceName());
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
        if ("IMuleRDWSPort".equals(inputPortName)) {
            return getIMuleRDWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "IMuleRDWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "IMuleRDWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IMuleRDWSPort".equals(portName)) {
            setIMuleRDWSPortEndpointAddress(address);
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
