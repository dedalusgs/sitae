/**
 * AnuncioService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.externo.ws;

public interface AnuncioService_PortType extends java.rmi.Remote {
    public es.novasoft.sitae.perfiles.externo.ws.PublicarResponse publicarAnuncio(es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest publicarRequest) throws java.rmi.RemoteException;
    public es.novasoft.sitae.perfiles.externo.ws.SolicitarPublicacionResponse solicitarPublicacionAnuncio(es.novasoft.sitae.perfiles.externo.ws.SolicitudRequest solicitarPublicacionRequest) throws java.rmi.RemoteException;
    public es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudPublicacionResponse cancelarSolicitudPublicacionAnuncio(es.novasoft.sitae.perfiles.externo.ws.CancelarSolicitudRequest cancelarSolicitudPublicacionRequest) throws java.rmi.RemoteException;
}
