package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Organismo;

public interface OrganismoDAO {

	public void save(Organismo transientInstance) throws DAOException;

	public void delete(Organismo persistentInstance) throws DAOException;

	public Organismo findById(Integer id) throws DAOException;

	public List findByExample(Organismo instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findByCif(Object cif) throws DAOException;

	public List findByDireccion(Object direccion) throws DAOException;

	public List findByTelefono(Object telefono) throws DAOException;

	public List findByFax(Object fax) throws DAOException;

	public List findByEmail(Object email) throws DAOException;

	public List findByImagen(Object imagen) throws DAOException;

	public List findAll() throws DAOException;

	public Organismo merge(Organismo detachedInstance) throws DAOException;

	public void attachDirty(Organismo instance) throws DAOException;

	public void attachClean(Organismo instance) throws DAOException;

	public List findByCodigo(String codigo) throws DAOException;

}
