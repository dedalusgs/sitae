package es.novasoft.castellon.vfe.business.services.support;

import java.io.Serializable;
import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;

public interface GenericService<T, ID extends Serializable> {

	public void save(T transientInstance) throws ServiceException;

	public void delete(T persistentInstance) throws ServiceException;

	public T findById(ID id) throws ServiceException;

	public List<T> findByExample(T instance) throws ServiceException;

	public List<T> findByProperty(String propertyName, Object value) throws ServiceException;

	public List<T> findAll() throws ServiceException;

	public T merge(T detachedInstance) throws ServiceException;

	public void attachDirty(T instance) throws ServiceException;

	public void attachClean(T instance) throws ServiceException;

}
