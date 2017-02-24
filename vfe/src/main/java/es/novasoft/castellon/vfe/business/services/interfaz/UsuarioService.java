/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoService.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.services.interfaz;

import java.util.List;

import es.novasoft.castellon.vfe.business.objects.Usuario;
import es.novasoft.comun.exceptions.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioExternoService.
 */
public interface UsuarioService {

	/**
	 * Save.
	 * 
	 * @param transientInstance
	 *            the transient instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void save(Usuario transientInstance) throws ServiceException;

	/**
	 * Delete.
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void delete(Usuario persistentInstance) throws ServiceException;

	/*
	 * @param usu
	 * 
	 * @return
	 * 
	 * @throws ServiceException
	 */
	public Usuario findFromUser(String usu) throws ServiceException;

	/**
	 * Find all.
	 * 
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List findAll() throws ServiceException;

	/**
	 * Merge.
	 * 
	 * @param detachedInstance
	 *            the detached instance
	 * @return the UsuarioExterno
	 * @throws ServiceException
	 *             the service exception
	 */
	public Usuario merge(Usuario detachedInstance) throws ServiceException;

	/**
	 * Attach dirty.
	 * 
	 * @param instance
	 *            the instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void attachDirty(Usuario instance) throws ServiceException;

	/**
	 * Attach clean.
	 * 
	 * @param instance
	 *            the instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void attachClean(Usuario instance) throws ServiceException;

}
