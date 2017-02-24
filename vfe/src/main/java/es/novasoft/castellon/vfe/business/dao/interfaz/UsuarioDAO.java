/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoDAO.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.dao.interfaz;

import java.util.List;

import es.novasoft.castellon.vfe.business.objects.Usuario;
import es.novasoft.comun.exceptions.DAOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioExternoDAO.
 */
public interface UsuarioDAO {

	/**
	 * Save.
	 * 
	 * @param transientInstance
	 *            the transient instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void save(Usuario transientInstance) throws DAOException;

	/**
	 * Delete.
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void delete(Usuario persistentInstance) throws DAOException;

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the Usuario
	 * @throws DAOException
	 *             the dAO exception
	 */
	public Usuario findById(Integer id) throws DAOException;

	/**
	 * Find by example.
	 * 
	 * @param instance
	 *            the instance
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByExample(Usuario instance) throws DAOException;

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
	 * @return the Usuario
	 * @throws DAOException
	 *             the dAO exception
	 */
	public Usuario merge(Usuario detachedInstance) throws DAOException;

	/**
	 * Attach dirty.
	 * 
	 * @param instance
	 *            the instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void attachDirty(Usuario instance) throws DAOException;

	/**
	 * Attach clean.
	 * 
	 * @param instance
	 *            the instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void attachClean(Usuario instance) throws DAOException;

	public Usuario findByUsu(String usu) throws DAOException;

}
