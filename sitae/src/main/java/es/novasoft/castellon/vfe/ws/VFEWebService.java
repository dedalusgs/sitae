/**
 * VFEWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.ws;

public interface VFEWebService extends java.rmi.Remote {
    public es.novasoft.castellon.vfe.ws.RespuestaRegistro eliminarRegistrarDocumento(es.novasoft.castellon.vfe.ws.PeticionRegistro peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.ws.RespuestaRegistro registrarDocumento(es.novasoft.castellon.vfe.ws.PeticionRegistro peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.ws.RespuestaDocumentoCSV obtenerDocumentoCSV(es.novasoft.castellon.vfe.ws.PeticionDocumentoCSV peticion) throws java.rmi.RemoteException;
}
