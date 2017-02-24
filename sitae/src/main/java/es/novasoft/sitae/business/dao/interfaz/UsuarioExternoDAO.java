/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoDAO.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.UsuarioExterno;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioExternoDAO.
 */
public interface UsuarioExternoDAO {

	/**
	 * Save.
	 * 
	 * @param transientInstance
	 *            the transient instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void save(UsuarioExterno transientInstance) throws DAOException;

	/**
	 * Delete.
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void delete(UsuarioExterno persistentInstance) throws DAOException;

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the usuarioExterno
	 * @throws DAOException
	 *             the dAO exception
	 */
	public UsuarioExterno findById(Integer id) throws DAOException;

	/**
	 * Find by example.
	 * 
	 * @param instance
	 *            the instance
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByExample(UsuarioExterno instance) throws DAOException;

	/**
	 * Find by property.
	 * 
	 * @param propertyName
	 *            the property name
	 * @param value
	 *            the value
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	/**
	 * Find all.
	 * 
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findAll() throws DAOException;

	/**
	 * Merge.
	 * 
	 * @param detachedInstance
	 *            the detached instance
	 * @return the usuarioExterno
	 * @throws DAOException
	 *             the dAO exception
	 */
	public UsuarioExterno merge(UsuarioExterno detachedInstance) throws DAOException;

	/**
	 * Attach dirty.
	 * 
	 * @param instance
	 *            the instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void attachDirty(UsuarioExterno instance) throws DAOException;

	/**
	 * Attach clean.
	 * 
	 * @param instance
	 *            the instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void attachClean(UsuarioExterno instance) throws DAOException;

	public UsuarioExterno findByUsu(String usu) throws DAOException;

}
