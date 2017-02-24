package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.TipoFirma;

public interface TipoFirmaService {

	public void save(TipoFirma transientInstance) throws ServiceException;

	public void delete(TipoFirma persistentInstance)
			throws ServiceException;

	public TipoFirma findById(Integer id) throws ServiceException;

	public List findByExample(TipoFirma instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findAll() throws ServiceException;

	public TipoFirma merge(TipoFirma detachedInstance)
			throws ServiceException;

	public void attachDirty(TipoFirma instance) throws ServiceException;

	public void attachClean(TipoFirma instance) throws ServiceException;

}
