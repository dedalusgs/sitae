package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Estado;

public interface EstadoDAO {

	public void save(Estado transientInstance) throws DAOException;

	public void delete(Estado persistentInstance) throws DAOException;

	public Estado findById(Integer id) throws DAOException;

	public List findByExample(Estado instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public Estado merge(Estado detachedInstance) throws DAOException;

	public void attachDirty(Estado instance) throws DAOException;

	public void attachClean(Estado instance) throws DAOException;

}
