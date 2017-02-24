package es.novasoft.sitae.business.services.interfaz;

import java.util.Date;
import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Organismo;

public interface OrganismoService {

	public void save(Organismo transientInstance) throws ServiceException;

	public void delete(Organismo persistentInstance) throws ServiceException;

	public Organismo findById(Integer id) throws ServiceException;

	public List findByExample(Organismo instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findByCif(Object cif) throws DAOException;

	public List findByDireccion(Object direccion) throws DAOException;

	public List findByTelefono(Object telefono) throws DAOException;

	public List findByFax(Object fax) throws DAOException;

	public List findByEmail(Object email) throws DAOException;

	public List findByImagen(Object imagen) throws DAOException;

	public List findAll() throws ServiceException;

	public Organismo merge(Organismo detachedInstance) throws ServiceException;

	public void attachDirty(Organismo instance) throws ServiceException;

	public void attachClean(Organismo instance) throws ServiceException;

	public List findByCodigo(String codigo) throws ServiceException;
    
	
}
