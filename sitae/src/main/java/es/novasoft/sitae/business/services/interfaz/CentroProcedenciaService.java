package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.CentroProcedencia;

public interface CentroProcedenciaService {
	
	public void save(CentroProcedencia transientInstance) throws ServiceException;
	
	public void delete(CentroProcedencia persistentInstance) throws ServiceException;
	
	public CentroProcedencia findById(Integer id) throws ServiceException;
	
	public List findByExample(CentroProcedencia instance) throws ServiceException;
	
	public List findByProperty(String propertyName, Object value) throws ServiceException;
	
	public List findByNombre(Object nombre) throws ServiceException;
	
	public List findAll() throws ServiceException;
	
	public CentroProcedencia merge(CentroProcedencia detachedInstance) throws ServiceException;
	
	public void attachDirty(CentroProcedencia instance) throws ServiceException;
	
	public void attachClean(CentroProcedencia instance) throws ServiceException;
	
	// public List findByIdOrg(Integer idOrg) throws ServiceException;
	
	public List findByNombreCif(String nombre, String cif) throws ServiceException;
	
}
