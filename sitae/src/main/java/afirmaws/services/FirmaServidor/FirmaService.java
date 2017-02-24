/**
 * FirmaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afirmaws.services.FirmaServidor;

public interface FirmaService extends javax.xml.rpc.Service {
    public java.lang.String getFirmaServidorAddress();

    public afirmaws.services.FirmaServidor.Firma getFirmaServidor() throws javax.xml.rpc.ServiceException;

    public afirmaws.services.FirmaServidor.Firma getFirmaServidor(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
