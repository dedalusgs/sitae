/**
 * SitaeService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public interface SitaeService_PortType extends java.rmi.Remote {
    public es.novasoft.sitae.perfiles.ws.PublicarResponse publicarAnuncio(es.novasoft.sitae.perfiles.ws.SolicitudRequest publicarRequest) throws java.rmi.RemoteException;
    public es.novasoft.sitae.perfiles.ws.SolicitarPublicacionResponse solicitarPublicacionAnuncio(es.novasoft.sitae.perfiles.ws.SolicitudRequest solicitarPublicacionRequest) throws java.rmi.RemoteException;
    public es.novasoft.sitae.perfiles.ws.CancelarSolicitudPublicacionResponse cancelarSolicitudPublicacionAnuncio(es.novasoft.sitae.perfiles.ws.CancelarSolicitudRequest cancelarSolicitudPublicacionRequest) throws java.rmi.RemoteException;
    public es.novasoft.sitae.perfiles.ws.ConsultarAnuncioResponse consultarAnuncio(es.novasoft.sitae.perfiles.ws.ConsultarAnuncioRequest consultarRequest) throws java.rmi.RemoteException;
}
