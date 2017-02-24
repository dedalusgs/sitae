package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.RedSocial;

public interface RedSocialService {

	public void save(RedSocial transientInstance) throws ServiceException;

	public void delete(RedSocial persistentInstance) throws ServiceException;

	public RedSocial findById(Integer id) throws ServiceException;

	public List findByExample(RedSocial instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value) throws ServiceException;

	public List findAll() throws ServiceException;

	public RedSocial merge(RedSocial detachedInstance) throws ServiceException;

	public void attachDirty(RedSocial instance) throws ServiceException;

	public void attachClean(RedSocial instance) throws ServiceException;

}
