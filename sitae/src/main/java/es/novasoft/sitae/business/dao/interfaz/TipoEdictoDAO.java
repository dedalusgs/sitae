package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.TipoEdicto;

public interface TipoEdictoDAO {

	public void save(TipoEdicto transientInstance) throws DAOException;

	public void delete(TipoEdicto persistentInstance) throws DAOException;

	public TipoEdicto findById(Integer id) throws DAOException;

	public List findByExample(TipoEdicto instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public TipoEdicto merge(TipoEdicto detachedInstance) throws DAOException;

	public void attachDirty(TipoEdicto instance) throws DAOException;

	public void attachClean(TipoEdicto instance) throws DAOException;

	public List findByIdOrg(Integer idOrg) throws DAOException;

	public List findByNombreCif(String nombre, String cif) throws DAOException;

}
