/**
 * AnuncioServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.externo.ws;

public class AnuncioServiceSoapBindingStub extends org.apache.axis.client.Stub implements es.novasoft.sitae.perfiles.externo.ws.AnuncioService_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[3];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("publicarAnuncio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ttdev.com/ss", "publicarRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ttdev.com/ss", "solicitudRequest"), es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ttdev.com/ss", ">publicarResponse"));
        oper.setReturnClass(es.novasoft.sitae.perfiles.externo.ws.PublicarResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ttdev.com/ss", "publicarResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("solicitarPublicacionAnuncio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ttdev.com/ss", "solicitarPublicacionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ttdev.com/ss", "solicitudRequest"), es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ttdev.com/ss", ">solicitarPublicacionResponse"));
        oper.setReturnClass(es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ttdev.com/ss", "solicitarPublicacionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cancelarSolicitudPublicacionAnuncio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ttdev.com/ss", "cancelarSolicitudPublicacionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ttdev.com/ss", "cancelarSolicitudRequest"), es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ttdev.com/ss", ">cancelarSolicitudPublicacionResponse"));
        oper.setReturnClass(es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ttdev.com/ss", "cancelarSolicitudPublicacionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

    }

    public AnuncioServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AnuncioServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AnuncioServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ttdev.com/ss", ">cancelarSolicitudPublicacionResponse");
            cachedSerQNames.add(qName);
            cls = es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ttdev.com/ss", ">publicarResponse");
            cachedSerQNames.add(qName);
            cls = es.novasoft.sitae.perfiles.externo.ws.PublicarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ttdev.com/ss", ">solicitarPublicacionResponse");
            cachedSerQNames.add(qName);
            cls = es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ttdev.com/ss", "cancelarSolicitudRequest");
            cachedSerQNames.add(qName);
            cls = es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ttdev.com/ss", "solicitudRequest");
            cachedSerQNames.add(qName);
            cls = es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ttdev.com/ss", "typeError");
            cachedSerQNames.add(qName);
            cls = es.novasoft.sitae.perfiles.externo.ws.TypeError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public es.novasoft.sitae.perfiles.externo.ws.PublicarResponse publicarAnuncio(es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest publicarRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ttdev.com/ss/publicarAnuncio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "publicarAnuncio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {publicarRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.novasoft.sitae.perfiles.externo.ws.PublicarResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.novasoft.sitae.perfiles.externo.ws.PublicarResponse) org.apache.axis.utils.JavaUtils.convert(_resp, es.novasoft.sitae.perfiles.externo.ws.PublicarResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse solicitarPublicacionAnuncio(es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest solicitarPublicacionRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ttdev.com/ss/solicitarPublicacionAnuncio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "solicitarPublicacionAnuncio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {solicitarPublicacionRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse cancelarSolicitudPublicacionAnuncio(es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudRequest cancelarSolicitudPublicacionRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ttdev.com/ss/cancelarSolicitudPublicacionAnuncio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "cancelarSolicitudPublicacionAnuncio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cancelarSolicitudPublicacionRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
