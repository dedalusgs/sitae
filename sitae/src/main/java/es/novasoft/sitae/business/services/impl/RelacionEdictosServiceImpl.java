package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.RelacionEdictosDAO;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;

public class RelacionEdictosServiceImpl implements RelacionEdictosService {

	private static Log log = LogFactory.getFactory().getInstance(
			RelacionUsuOrgCentroPerfServiceImpl.class);

	private RelacionEdictosDAO relacionEdictosDAO;

	public RelacionEdictosDAO getRelacionEdictosDAO() {
		return relacionEdictosDAO;
	}

	public void setRelacionEdictosDAO(RelacionEdictosDAO relacionEdictosDAO) {
		this.relacionEdictosDAO = relacionEdictosDAO;
	}

	public void save(RelacionEdictos transientInstance) throws ServiceException {
		log.debug("save RelacionEdictos");
		try {
			relacionEdictosDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(RelacionEdictos persistentInstance) throws ServiceException {
		log.debug("deleting RelacionEdictos instance");
		try {
			relacionEdictosDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RelacionEdictos findById(Integer id) throws ServiceException {
		log.debug("getting RelacionEdictos instance with id: " + id);
		try {
			return relacionEdictosDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(RelacionEdictos instance) throws ServiceException {
		log.debug("finding RelacionEdictos instance by example");
		try {
			return relacionEdictosDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return relacionEdictosDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll RelacionEdictos");
		try {
			return relacionEdictosDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RelacionEdictos merge(RelacionEdictos detachedInstance)
			throws ServiceException {
		log.debug("merging RelacionUsuOrgCentroPerf instance");
		try {
			return relacionEdictosDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(RelacionEdictos instance) throws ServiceException {
		log.debug("attaching dirty RelacionEdictos instance");
		try {
			relacionEdictosDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(RelacionEdictos instance) throws ServiceException {
		log.debug("attaching clean RelacionUsuOrgCentroPerf instance");
		try {
			relacionEdictosDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByEdicto(Integer idEdicto) throws ServiceException {
		log.debug("finding findByPerfil instance by example");
		try {
			return relacionEdictosDAO.findByEdicto(idEdicto);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
