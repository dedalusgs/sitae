/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoService.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.UsuarioExterno;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioExternoService.
 */
public interface UsuarioExternoService {

	/**
	 * Save.
	 * 
	 * @param transientInstance
	 *            the transient instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void save(UsuarioExterno transientInstance) throws ServiceException;

	/**
	 * Delete.
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void delete(UsuarioExterno persistentInstance) throws ServiceException;

	 /* 
	 * @param usu
	 * @return
	 * @throws ServiceException
	 */
	public UsuarioExterno findFromUser(String usu) throws ServiceException;


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
	 * @return the usuarioExternoExterno
	 * @throws ServiceException
	 *             the service exception
	 */
	public UsuarioExterno merge(UsuarioExterno detachedInstance) throws ServiceException;

	/**
	 * Attach dirty.
	 * 
	 * @param instance
	 *            the instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void attachDirty(UsuarioExterno instance) throws ServiceException;

	/**
	 * Attach clean.
	 * 
	 * @param instance
	 *            the instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void attachClean(UsuarioExterno instance) throws ServiceException;

}
