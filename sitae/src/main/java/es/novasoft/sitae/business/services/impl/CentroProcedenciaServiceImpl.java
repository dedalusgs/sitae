package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.CentroProcedenciaDAO;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;

public class CentroProcedenciaServiceImpl implements CentroProcedenciaService {
	
	private static Log	         log	= LogFactory.getFactory().getInstance(CentroProcedenciaServiceImpl.class);
	
	private CentroProcedenciaDAO	centroProcedenciaDAO;
	
	public CentroProcedenciaDAO getCentroProcedenciaDao() {
		return centroProcedenciaDAO;
	}
	
	public void setCentroProcedenciaDAO(CentroProcedenciaDAO centroProcedenciaDAO) {
		this.centroProcedenciaDAO = centroProcedenciaDAO;
	}
	
	public void save(CentroProcedencia transientInstance) throws ServiceException {
		log.debug("save CentroProcedencia");
		try {
			centroProcedenciaDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void delete(CentroProcedencia persistentInstance) throws ServiceException {
		log.debug("deleting CentroProcedencia instance");
		try {
			centroProcedenciaDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public CentroProcedencia findById(Integer id) throws ServiceException {
		log.debug("getting CentroProcedencia instance with id: " + id);
		try {
			return centroProcedenciaDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByExample(CentroProcedencia instance) throws ServiceException {
		log.debug("finding CentroProcedencia instance by example");
		try {
			return centroProcedenciaDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return centroProcedenciaDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return centroProcedenciaDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findAll() throws ServiceException {
		log.debug("findAll Centro de Procedencia");
		try {
			return centroProcedenciaDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public CentroProcedencia merge(CentroProcedencia detachedInstance) throws ServiceException {
		log.debug("merging CentroProcedencia instance");
		try {
			return centroProcedenciaDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void attachDirty(CentroProcedencia instance) throws ServiceException {
		log.debug("attaching dirty CentroProcedencia instance");
		try {
			centroProcedenciaDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void attachClean(CentroProcedencia instance) throws ServiceException {
		log.debug("attaching clean CentroProcedencia instance");
		try {
			centroProcedenciaDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	// public List findByIdOrg(Integer idOrg) throws ServiceException {
	// log.debug("finding CentroProcedencia instance by example");
	// try {
	// return centroProcedenciaDAO.findByIdOrg(idOrg);
	// } catch (DAOException e) {
	// log.error(e.getMessage());
	// throw new ServiceException(e.getMessage(), e.getExceptionkey());
	// }
	// }
	
	public List findByNombreCif(String nombre, String cif) throws ServiceException {
		log.debug("finding CentroProcedencia instance by nombreCif");
		try {
			return centroProcedenciaDAO.findByNombreCif(nombre, cif);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
}
