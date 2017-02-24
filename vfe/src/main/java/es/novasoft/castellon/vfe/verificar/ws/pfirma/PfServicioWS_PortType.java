/**
 * PfServicioWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.pfirma;

public interface PfServicioWS_PortType extends java.rmi.Remote {
    public long actualizarPeticion(java.lang.String chash, java.lang.String aplicacion, boolean firmaCascada, boolean firmaOrdenada, boolean notificaEmail, boolean notificaMovil, boolean notificaAviso, java.util.Calendar fInicio, java.util.Calendar fCaducidad, java.lang.String remitenteNombre, java.lang.String remitenteEmail, java.lang.String remitenteMovil, java.lang.String dReferencia, java.lang.String dAsunto, java.math.BigDecimal nPrioridad, java.lang.String usuario, java.lang.String petChash, java.lang.String tTexto) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[] consultarDestinatariosPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[] consultarDocumentosPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[] consultarEntregasPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public java.lang.String[] consultarNotificacionesPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS consultarPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS consultarUsuario(java.lang.String dni) throws java.rmi.RemoteException;
    public byte[] descargarDocumento(java.lang.String documento) throws java.rmi.RemoteException;
    public byte[] descargarPKCS7(java.lang.String documento, java.lang.String idTransaccion) throws java.rmi.RemoteException;
    public long eliminarDestinatarioPeticion(java.lang.String dni, java.lang.String peticion) throws java.rmi.RemoteException;
    public long eliminarDocumentoPeticion(java.lang.String documento) throws java.rmi.RemoteException;
    public long eliminarNotificacionPeticion(java.lang.String peticion, java.lang.String estado) throws java.rmi.RemoteException;
    public boolean entregadaPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public long entregarPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public long insertarDestinatarioPeticion(java.lang.String dni, java.lang.String peticion) throws java.rmi.RemoteException;
    public java.lang.String insertarDocumentoPeticion(java.lang.String peticion, java.lang.String tipoDoc, java.lang.String nombreDoc, java.lang.String tipoMime, byte[] documento) throws java.rmi.RemoteException;
    public long insertarNotificacionPeticion(java.lang.String peticion, java.lang.String estado) throws java.rmi.RemoteException;
    public java.lang.String insertarPeticion(java.lang.String usuario) throws java.rmi.RemoteException;
    public java.lang.String[] valoresEstados() throws java.rmi.RemoteException;
    public java.lang.String[] valoresTiposDocumento() throws java.rmi.RemoteException;
    public long documentoAccion(java.lang.String hashDoc, java.lang.String estado, java.lang.String accion, java.lang.String tipo) throws java.rmi.RemoteException;
    public long cambiarDestinatario(java.lang.String hashPeticion, java.lang.String dniOrigen, java.lang.String dniDestino, java.lang.String nombre, java.lang.String apellido1, java.lang.String apellido2, java.lang.String nuevo) throws java.rmi.RemoteException;
    public java.lang.String consultarObservacionesEntrega(java.lang.String hashDoc, java.lang.String dni) throws java.rmi.RemoteException;
    public long insertarDestinatarioPet(es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuario, java.lang.String peticion) throws java.rmi.RemoteException;
    public long eliminarDestinatarioPet(es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuario, java.lang.String peticion) throws java.rmi.RemoteException;
    public long cambiarDestinatarioPet(java.lang.String hashPeticion, es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuarioOrigen, es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuarioDestino, java.lang.String nuevo) throws java.rmi.RemoteException;
    public long eliminarPeticion(java.lang.String peticion) throws java.rmi.RemoteException;
    public es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[] obtenerListaUsuarios() throws java.rmi.RemoteException;
    public double obtenerIdTransaccion(java.lang.String documento) throws java.rmi.RemoteException;
}
