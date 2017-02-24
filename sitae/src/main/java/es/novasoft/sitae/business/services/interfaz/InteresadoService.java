package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;

public interface InteresadoService {

	public void save(Interesado transientInstance) throws ServiceException;

	public void delete(Interesado persistentInstance) throws ServiceException;

	public Interesado findById(Integer id) throws ServiceException;

	public List findByExample(Interesado instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value) throws ServiceException;

	public List findByEmail(Object email) throws ServiceException;

	public List findAll() throws ServiceException;

	public Interesado merge(Interesado detachedInstance) throws ServiceException;

	public void attachDirty(Interesado instance) throws ServiceException;

	public void attachClean(Interesado instance) throws ServiceException;

	public Interesado findByEmailOrganismoActivo(String email, Organismo org, Boolean activo) throws ServiceException;

	public List findAllByOrg(Organismo org) throws ServiceException;
}
