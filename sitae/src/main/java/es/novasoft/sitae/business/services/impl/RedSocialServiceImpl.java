package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.RedSocialDAO;
import es.novasoft.sitae.business.objects.RedSocial;
import es.novasoft.sitae.business.services.interfaz.RedSocialService;

public class RedSocialServiceImpl implements RedSocialService {

	private static Log log = LogFactory.getFactory().getInstance(RedSocialServiceImpl.class);

	private RedSocialDAO redSocialDAO;

	public RedSocialDAO getRedSocialDAO() {
		return redSocialDAO;
	}

	public void setRedSocialDAO(RedSocialDAO RedSocialDAO) {
		redSocialDAO = RedSocialDAO;
	}

	public void save(RedSocial transientInstance) throws ServiceException {
		log.debug("save RedSocial");
		try {
			redSocialDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(RedSocial persistentInstance) throws ServiceException {
		log.debug("deleting RedSocial instance");
		try {
			redSocialDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RedSocial findById(Integer id) throws ServiceException {
		log.debug("getting RedSocial instance with id: " + id);
		try {
			return redSocialDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(RedSocial instance) throws ServiceException {
		log.debug("finding RedSocial instance by example");
		try {
			return redSocialDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return redSocialDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Centro de Procedencia");
		try {
			return redSocialDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RedSocial merge(RedSocial detachedInstance) throws ServiceException {
		log.debug("merging RedSocial instance");
		try {
			return redSocialDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(RedSocial instance) throws ServiceException {
		log.debug("attaching dirty RedSocial instance");
		try {
			redSocialDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(RedSocial instance) throws ServiceException {
		log.debug("attaching clean RedSocial instance");
		try {
			redSocialDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
