/**
 * ValidacionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afirmaws.services.ValidarCertificado;

public class ValidacionServiceLocator extends org.apache.axis.client.Service implements afirmaws.services.ValidarCertificado.ValidacionService {

    public ValidacionServiceLocator() {
    }


    public ValidacionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ValidacionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ValidarCertificado
    private java.lang.String ValidarCertificado_address = "https://preafirma.accv.es:443/afirmaws/services/ValidarCertificado";

    public java.lang.String getValidarCertificadoAddress() {
        return ValidarCertificado_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ValidarCertificadoWSDDServiceName = "ValidarCertificado";

    public java.lang.String getValidarCertificadoWSDDServiceName() {
        return ValidarCertificadoWSDDServiceName;
    }

    public void setValidarCertificadoWSDDServiceName(java.lang.String name) {
        ValidarCertificadoWSDDServiceName = name;
    }

    public afirmaws.services.ValidarCertificado.Validacion getValidarCertificado() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidarCertificado_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidarCertificado(endpoint);
    }

    public afirmaws.services.ValidarCertificado.Validacion getValidarCertificado(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            afirmaws.services.ValidarCertificado.ValidarCertificadoSoapBindingStub _stub = new afirmaws.services.ValidarCertificado.ValidarCertificadoSoapBindingStub(portAddress, this);
            _stub.setPortName(getValidarCertificadoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidarCertificadoEndpointAddress(java.lang.String address) {
        ValidarCertificado_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (afirmaws.services.ValidarCertificado.Validacion.class.isAssignableFrom(serviceEndpointInterface)) {
                afirmaws.services.ValidarCertificado.ValidarCertificadoSoapBindingStub _stub = new afirmaws.services.ValidarCertificado.ValidarCertificadoSoapBindingStub(new java.net.URL(ValidarCertificado_address), this);
                _stub.setPortName(getValidarCertificadoWSDDServiceName());
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
        if ("ValidarCertificado".equals(inputPortName)) {
            return getValidarCertificado();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://afirmaws/services/ValidarCertificado", "ValidacionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://afirmaws/services/ValidarCertificado", "ValidarCertificado"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ValidarCertificado".equals(portName)) {
            setValidarCertificadoEndpointAddress(address);
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
