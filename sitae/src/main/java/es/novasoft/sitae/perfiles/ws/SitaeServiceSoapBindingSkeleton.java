/**
 * SitaeServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class SitaeServiceSoapBindingSkeleton implements es.novasoft.sitae.perfiles.ws.SitaeService_PortType, org.apache.axis.wsdl.Skeleton {
    private es.novasoft.sitae.perfiles.ws.SitaeService_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "publicarRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "solicitudRequest"), es.novasoft.sitae.perfiles.ws.SolicitudRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("publicarAnuncio", _params, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "publicarResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">publicarResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "publicarAnuncio"));
        _oper.setSoapAction("http://novasoft.es/sitae/perfiles/ws/publicarAnuncio");
        _myOperationsList.add(_oper);
        if (_myOperations.get("publicarAnuncio") == null) {
            _myOperations.put("publicarAnuncio", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("publicarAnuncio")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "solicitarPublicacionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "solicitudRequest"), es.novasoft.sitae.perfiles.ws.SolicitudRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("solicitarPublicacionAnuncio", _params, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "solicitarPublicacionResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">solicitarPublicacionResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "solicitarPublicacionAnuncio"));
        _oper.setSoapAction("http://novasoft.es/sitae/perfiles/ws/solicitarPublicacionAnuncio");
        _myOperationsList.add(_oper);
        if (_myOperations.get("solicitarPublicacionAnuncio") == null) {
            _myOperations.put("solicitarPublicacionAnuncio", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("solicitarPublicacionAnuncio")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "cancelarSolicitudPublicacionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "cancelarSolicitudRequest"), es.novasoft.sitae.perfiles.ws.CancelarSolicitudRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarSolicitudPublicacionAnuncio", _params, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "cancelarSolicitudPublicacionResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">cancelarSolicitudPublicacionResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "cancelarSolicitudPublicacionAnuncio"));
        _oper.setSoapAction("http://novasoft.es/sitae/perfiles/ws/cancelarSolicitudPublicacionAnuncio");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarSolicitudPublicacionAnuncio") == null) {
            _myOperations.put("cancelarSolicitudPublicacionAnuncio", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarSolicitudPublicacionAnuncio")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "consultarAnuncioRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">consultarAnuncioRequest"), es.novasoft.sitae.perfiles.ws.ConsultarAnuncioRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("consultarAnuncio", _params, new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "consultarAnuncioResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">consultarAnuncioResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "consultarAnuncio"));
        _oper.setSoapAction("http://novasoft.es/sitae/perfiles/ws/consultarAnuncio");
        _myOperationsList.add(_oper);
        if (_myOperations.get("consultarAnuncio") == null) {
            _myOperations.put("consultarAnuncio", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("consultarAnuncio")).add(_oper);
    }

    public SitaeServiceSoapBindingSkeleton() {
        this.impl = new es.novasoft.sitae.perfiles.ws.SitaeServiceSoapBindingImpl();
    }

    public SitaeServiceSoapBindingSkeleton(es.novasoft.sitae.perfiles.ws.SitaeService_PortType impl) {
        this.impl = impl;
    }
    public es.novasoft.sitae.perfiles.ws.PublicarResponse publicarAnuncio(es.novasoft.sitae.perfiles.ws.SolicitudRequest publicarRequest) throws java.rmi.RemoteException
    {
        es.novasoft.sitae.perfiles.ws.PublicarResponse ret = impl.publicarAnuncio(publicarRequest);
        return ret;
    }

    public es.novasoft.sitae.perfiles.ws.SolicitarPublicacionResponse solicitarPublicacionAnuncio(es.novasoft.sitae.perfiles.ws.SolicitudRequest solicitarPublicacionRequest) throws java.rmi.RemoteException
    {
        es.novasoft.sitae.perfiles.ws.SolicitarPublicacionResponse ret = impl.solicitarPublicacionAnuncio(solicitarPublicacionRequest);
        return ret;
    }

    public es.novasoft.sitae.perfiles.ws.CancelarSolicitudPublicacionResponse cancelarSolicitudPublicacionAnuncio(es.novasoft.sitae.perfiles.ws.CancelarSolicitudRequest cancelarSolicitudPublicacionRequest) throws java.rmi.RemoteException
    {
        es.novasoft.sitae.perfiles.ws.CancelarSolicitudPublicacionResponse ret = impl.cancelarSolicitudPublicacionAnuncio(cancelarSolicitudPublicacionRequest);
        return ret;
    }

    public es.novasoft.sitae.perfiles.ws.ConsultarAnuncioResponse consultarAnuncio(es.novasoft.sitae.perfiles.ws.ConsultarAnuncioRequest consultarRequest) throws java.rmi.RemoteException
    {
        es.novasoft.sitae.perfiles.ws.ConsultarAnuncioResponse ret = impl.consultarAnuncio(consultarRequest);
        return ret;
    }

}
