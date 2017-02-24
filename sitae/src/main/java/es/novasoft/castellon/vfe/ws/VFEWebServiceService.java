/**
 * VFEWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.ws;

public interface VFEWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getVFEWebServiceAddress();

    public es.novasoft.castellon.vfe.ws.VFEWebService getVFEWebService() throws javax.xml.rpc.ServiceException;

    public es.novasoft.castellon.vfe.ws.VFEWebService getVFEWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
