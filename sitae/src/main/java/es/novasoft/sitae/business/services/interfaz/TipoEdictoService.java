package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.TipoEdicto;

public interface TipoEdictoService {

	public void save(TipoEdicto transientInstance) throws ServiceException;

	public void delete(TipoEdicto persistentInstance) throws ServiceException;

	public TipoEdicto findById(Integer id) throws ServiceException;

	public List findByExample(TipoEdicto instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findAll() throws ServiceException;

	public TipoEdicto merge(TipoEdicto detachedInstance)
			throws ServiceException;

	public void attachDirty(TipoEdicto instance) throws ServiceException;

	public void attachClean(TipoEdicto instance) throws ServiceException;

	public List findByIdOrg(Integer idOrg) throws ServiceException;

	public List findByNombreCif(String nombre, String cif)
			throws ServiceException;

}
