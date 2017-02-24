/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: OrganismoService.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.services.interfaz;

import java.util.List;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrganismoService.
 */
public interface OrganismoService {

	/**
	 * Save.
	 * 
	 * @param transientInstance
	 *            the transient instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void save(Organismo transientInstance) throws ServiceException;

	/**
	 * Delete.
	 * 
	 * @param persistentInstance
	 *            the persistent instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void delete(Organismo persistentInstance) throws ServiceException;

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the organismo
	 * @throws ServiceException
	 *             the service exception
	 */
	public Organismo findById(Integer id) throws ServiceException;

	/**
	 * Find by example.
	 * 
	 * @param instance
	 *            the instance
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List findByExample(Organismo instance) throws ServiceException;

	/**
	 * Find by property.
	 * 
	 * @param propertyName
	 *            the property name
	 * @param value
	 *            the value
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	/**
	 * Find by nombre.
	 * 
	 * @param nombre
	 *            the nombre
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List findByNombre(Object nombre) throws ServiceException;

	/**
	 * Find by direccion.
	 * 
	 * @param direccion
	 *            the direccion
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByDireccion(Object direccion) throws ServiceException;

	/**
	 * Find by telefono.
	 * 
	 * @param telefono
	 *            the telefono
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByTelefono(Object telefono) throws ServiceException;

	/**
	 * Find by fax.
	 * 
	 * @param fax
	 *            the fax
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByFax(Object fax) throws ServiceException;

	/**
	 * Find by email.
	 * 
	 * @param email
	 *            the email
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByEmail(Object email) throws ServiceException;

	/**
	 * Find by imagen.
	 * 
	 * @param imagen
	 *            the imagen
	 * @return the list
	 * @throws DAOException
	 *             the dAO exception
	 */
	public List findByImagen(Object imagen) throws ServiceException;

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
	 * @return the organismo
	 * @throws ServiceException
	 *             the service exception
	 */
	public Organismo merge(Organismo detachedInstance) throws ServiceException;

	/**
	 * Attach dirty.
	 * 
	 * @param instance
	 *            the instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void attachDirty(Organismo instance) throws ServiceException;

	/**
	 * Attach clean.
	 * 
	 * @param instance
	 *            the instance
	 * @throws ServiceException
	 *             the service exception
	 */
	public void attachClean(Organismo instance) throws ServiceException;

	/**
	 * Find by codigo.
	 * 
	 * @param codigo
	 *            the codigo
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List findByCodigo(String codigo) throws ServiceException;

}
