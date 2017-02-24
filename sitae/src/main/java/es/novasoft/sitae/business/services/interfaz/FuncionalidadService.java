package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Funcionalidad;

public interface FuncionalidadService {

	public void save(Funcionalidad transientInstance) throws ServiceException;

	public void delete(Funcionalidad persistentInstance)
			throws ServiceException;

	public Funcionalidad findById(Integer id) throws ServiceException;

	public List findByExample(Funcionalidad instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findAll() throws ServiceException;

	public Funcionalidad merge(Funcionalidad detachedInstance)
			throws ServiceException;

	public void attachDirty(Funcionalidad instance) throws ServiceException;

	public void attachClean(Funcionalidad instance) throws ServiceException;

}
