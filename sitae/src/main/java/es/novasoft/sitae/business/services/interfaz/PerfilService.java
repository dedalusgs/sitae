package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Perfil;

public interface PerfilService {

	public void save(Perfil transientInstance) throws ServiceException;

	public void delete(Perfil persistentInstance) throws ServiceException;

	public Perfil findById(Integer id) throws ServiceException;

	public List findByExample(Perfil instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findAll() throws ServiceException;

	public Perfil merge(Perfil detachedInstance) throws ServiceException;

	public void attachDirty(Perfil instance) throws ServiceException;

	public void attachClean(Perfil instance) throws ServiceException;

}
