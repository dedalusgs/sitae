package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.RelPerfFunc;

public interface RelPerfFuncService {

	public void save(RelPerfFunc transientInstance) throws ServiceException;

	public void delete(RelPerfFunc persistentInstance) throws ServiceException;

	public RelPerfFunc findById(Integer id) throws ServiceException;

	public List findByExample(RelPerfFunc instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findAll() throws ServiceException;

	public RelPerfFunc merge(RelPerfFunc detachedInstance)
			throws ServiceException;

	public void attachDirty(RelPerfFunc instance) throws ServiceException;

	public void attachClean(RelPerfFunc instance) throws ServiceException;

	public List findByPerfil(Integer idPerfil) throws ServiceException;

	public List findByIdFuncionalidad(Integer idFuncionalidad)
			throws ServiceException;

}
