/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: OrganismoDAO.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.dao.interfaz;

import java.util.List;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.exceptions.DAOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrganismoDAO.
 */
public interface OrganismoDAO {

	/**
	 * Save.
	 * 
	 * @param transientInstance
	 *            the transient instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void save(Organismo transientInstance) throws DAOException;

	/**
	 * Delete.
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void delete(Organismo persistentInstance) throws DAOException;

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the organismo
	 * @throws DAOException
	 *             the dAO exception
	 */
	public Organismo findById(Integer id) throws DAOException;

	/**
	 * Find by example.
	 * 
	 * @param instance
	 *            the instance
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByExample(Organismo instance) throws DAOException;

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
	 * Find by nombre.
	 * 
	 * @param nombre
	 *            the nombre
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByNombre(Object nombre) throws DAOException;

	/**
	 * Find by direccion.
	 * 
	 * @param direccion
	 *            the direccion
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByDireccion(Object direccion) throws DAOException;

	/**
	 * Find by telefono.
	 * 
	 * @param telefono
	 *            the telefono
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByTelefono(Object telefono) throws DAOException;

	/**
	 * Find by fax.
	 * 
	 * @param fax
	 *            the fax
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByFax(Object fax) throws DAOException;

	/**
	 * Find by email.
	 * 
	 * @param email
	 *            the email
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByEmail(Object email) throws DAOException;

	/**
	 * Find by imagen.
	 * 
	 * @param imagen
	 *            the imagen
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByImagen(Object imagen) throws DAOException;

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
	 * @return the organismo
	 * @throws DAOException
	 *             the dAO exception
	 */
	public Organismo merge(Organismo detachedInstance) throws DAOException;

	/**
	 * Attach dirty.
	 * 
	 * @param instance
	 *            the instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void attachDirty(Organismo instance) throws DAOException;

	/**
	 * Attach clean.
	 * 
	 * @param instance
	 *            the instance
	 * @throws DAOException
	 *             the dAO exception
	 */
	public void attachClean(Organismo instance) throws DAOException;

	/**
	 * Find by codigo.
	 * 
	 * @param codigo
	 *            the codigo
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByCodigo(String codigo) throws DAOException;

}
