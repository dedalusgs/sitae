/**
 * StampService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.ws.sta;

public interface StampService_PortType extends java.rmi.Remote {
    public es.novasoft.sitae.ws.sta.Response stamp(es.novasoft.sitae.ws.sta.Signer signer) throws java.rmi.RemoteException;
    public es.novasoft.sitae.ws.sta.Response waterMark(es.novasoft.sitae.ws.sta.ContentDocument contentDocument) throws java.rmi.RemoteException;
}
