package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.OrganismoExterno;

public interface OrganismoExternoDAO {

	public void save(OrganismoExterno transientInstance) throws DAOException;

	public void delete(OrganismoExterno persistentInstance) throws DAOException;

	public OrganismoExterno findById(Integer id) throws DAOException;

	public List findByExample(OrganismoExterno instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findByCif(Object cif) throws DAOException;

	public List findByDireccion(Object direccion) throws DAOException;

	public List findByTelefono(Object telefono) throws DAOException;

	public List findByFax(Object fax) throws DAOException;

	public List findByEmail(Object email) throws DAOException;

	public List findAll() throws DAOException;

	public OrganismoExterno merge(OrganismoExterno detachedInstance)
			throws DAOException;

	public void attachDirty(OrganismoExterno instance) throws DAOException;

	public void attachClean(OrganismoExterno instance) throws DAOException;

}
