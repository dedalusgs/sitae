package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.OrganismoExterno;

public interface OrganismoExternoService {

	public void save(OrganismoExterno transientInstance)
			throws ServiceException;

	public void delete(OrganismoExterno persistentInstance)
			throws ServiceException;

	public OrganismoExterno findById(Integer id) throws ServiceException;

	public List findByExample(OrganismoExterno instance)
			throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findByCif(Object cif) throws DAOException;

	public List findByDireccion(Object direccion) throws DAOException;

	public List findByTelefono(Object telefono) throws DAOException;

	public List findByFax(Object fax) throws DAOException;

	public List findByEmail(Object email) throws DAOException;

	public List findAll() throws ServiceException;

	public OrganismoExterno merge(OrganismoExterno detachedInstance)
			throws ServiceException;

	public void attachDirty(OrganismoExterno instance) throws ServiceException;

	public void attachClean(OrganismoExterno instance) throws ServiceException;

}
