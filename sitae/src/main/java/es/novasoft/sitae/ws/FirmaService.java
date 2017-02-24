/**
 * FirmaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.ws;

public interface FirmaService extends javax.xml.rpc.Service {
	public java.lang.String getFirmaServidorAddress();

	public es.novasoft.sitae.ws.Firma getFirmaServidor()
			throws javax.xml.rpc.ServiceException;

	public es.novasoft.sitae.ws.Firma getFirmaServidor(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
