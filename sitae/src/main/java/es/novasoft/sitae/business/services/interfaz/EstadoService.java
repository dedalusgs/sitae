package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Estado;

public interface EstadoService {

	public void save(Estado transientInstance) throws ServiceException;

	public void delete(Estado persistentInstance) throws ServiceException;

	public Estado findById(Integer id) throws ServiceException;

	public List findByExample(Estado instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findAll() throws ServiceException;

	public Estado merge(Estado detachedInstance) throws ServiceException;

	public void attachDirty(Estado instance) throws ServiceException;

	public void attachClean(Estado instance) throws ServiceException;

}
