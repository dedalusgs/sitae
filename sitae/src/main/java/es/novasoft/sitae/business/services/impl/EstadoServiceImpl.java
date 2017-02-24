package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.EstadoDAO;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.services.interfaz.EstadoService;

public class EstadoServiceImpl implements EstadoService {

	private static Log log = LogFactory.getFactory().getInstance(
			CentroProcedenciaServiceImpl.class);

	private EstadoDAO estadoDAO;

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public void save(Estado transientInstance) throws ServiceException {
		log.debug("save Estado");
		try {
			estadoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(Estado persistentInstance) throws ServiceException {
		log.debug("deleting Estado instance");
		try {
			estadoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Estado findById(Integer id) throws ServiceException {
		log.debug("getting Estado instance with id: " + id);
		try {
			return estadoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(Estado instance) throws ServiceException {
		log.debug("finding Estado instance by example");
		try {
			return estadoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return estadoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return estadoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Estado");
		try {
			return estadoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Estado merge(Estado detachedInstance) throws ServiceException {
		log.debug("merging Estado instance");
		try {
			return estadoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(Estado instance) throws ServiceException {
		log.debug("attaching dirty Estado instance");
		try {
			estadoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(Estado instance) throws ServiceException {
		log.debug("attaching clean Estado instance");
		try {
			estadoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
