/*
 * 
 */
package es.novasoft.castellon.vfe.verificar.ws;

import java.rmi.RemoteException;

import es.novasoft.castellon.vfe.business.objects.Organismo;

// TODO: Auto-generated Javadoc
/**
 * The Interface IVerificaService.
 */
public interface IVerificaService {

	/**
	 * Check codigo.
	 *
	 * @param codigo the codigo
	 * @param idEntidadLocal 
	 * @return true, if successful
	 */
	public boolean checkCodigo(String codigo, Organismo org);

	/**
	 * Gets the document.
	 *
	 * @return the document
	 * @throws RemoteException the remote exception
	 */
	public byte[] getDocument() throws RemoteException;
	
	/**
	 * Gets the firma electronica.
	 *
	 * @return the firma electronica
	 * @throws RemoteException the remote exception
	 */
	public byte[] getFirmaElectronica() throws RemoteException;

	public byte[] getDocumentoFirmado() throws RemoteException;
	
	public DatosFirmante getDatosFirmante() throws RemoteException;
	
	public String getNombreFichero() throws RemoteException;
	
	public String getExtensionFirma() throws RemoteException;
}
