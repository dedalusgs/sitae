package es.novasoft.sitae.business.dao.support;

import java.io.Serializable;
import java.util.List;

import es.novasoft.comun.exceptions.DAOException;

public interface GenericDao<T, ID extends Serializable> {

	public void save(T persistentInstance) throws DAOException;

	public void delete(T persistentInstance) throws DAOException;

	public T findById(ID id) throws DAOException;

	public List<T> findByExample(T instance) throws DAOException;

	public List<T> findByProperty(String propertyName, Object value) throws DAOException;

	public List<T> findAll() throws DAOException;

	public T merge(T detachedInstance) throws DAOException;

	public void attachDirty(T instance) throws DAOException;

	public void attachClean(T instance) throws DAOException;
}
