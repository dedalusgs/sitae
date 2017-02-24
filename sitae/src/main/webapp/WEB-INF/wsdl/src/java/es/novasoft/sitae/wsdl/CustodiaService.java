/**
 * CustodiaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.wsdl;

public interface CustodiaService extends javax.xml.rpc.Service {
    public java.lang.String getAlmacenarDocumentoAddress();

    public es.novasoft.sitae.wsdl.Custodia getAlmacenarDocumento() throws javax.xml.rpc.ServiceException;

    public es.novasoft.sitae.wsdl.Custodia getAlmacenarDocumento(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
