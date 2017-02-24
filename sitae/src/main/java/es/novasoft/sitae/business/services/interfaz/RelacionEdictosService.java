package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.RelacionEdictos;

public interface RelacionEdictosService {

	public void save(RelacionEdictos transientInstance) throws ServiceException;

	public void delete(RelacionEdictos persistentInstance) throws ServiceException;

	public RelacionEdictos findById(Integer id) throws ServiceException;

	public List findByExample(RelacionEdictos instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findAll() throws ServiceException;

	public RelacionEdictos merge(RelacionEdictos detachedInstance)
			throws ServiceException;

	public void attachDirty(RelacionEdictos instance) throws ServiceException;

	public void attachClean(RelacionEdictos instance) throws ServiceException;

	public List findByEdicto(Integer idEdicto) throws ServiceException;

}
