package es.novasoft.sitae.business.services.interfaz;

import java.util.Date;
import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.FestivoDAO;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;

public interface FestivoService {

	public abstract FestivoDAO getFestivoDao();

	public abstract void setFestivoDAO(FestivoDAO FestivoDAO);

	public abstract void save(Festivo transientInstance)
			throws ServiceException;

	public abstract void delete(Festivo persistentInstance)
			throws ServiceException;

	public abstract Festivo findById(Integer id) throws ServiceException;

	public abstract List findByExample(Festivo instance)
			throws ServiceException;

	public abstract List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public abstract List findByNombre(Object nombre) throws ServiceException;

	public abstract List findAll() throws ServiceException;

	public abstract Festivo merge(Festivo detachedInstance)
			throws ServiceException;

	public abstract void attachDirty(Festivo instance) throws ServiceException;

	public abstract void attachClean(Festivo instance) throws ServiceException;

	public abstract List findByIdOrgAnio(Integer idOrg, Integer anio)
			throws ServiceException;

	public abstract List findByOrgAnio(Organismo org, Integer anio)
			throws ServiceException;

	public abstract List findByDate(Integer idOrg, Date fecha)
			throws ServiceException;

	
	public abstract Date obtenerFechaFinPublicacion(Date fechaInicio,Organismo org, Integer diaslaborables,String tipo) throws ServiceException;
    
	public Integer obtenerDiasPublicacion(Date fechaInicio,Date fechaFin, Organismo org,String tipo) throws ServiceException;
}