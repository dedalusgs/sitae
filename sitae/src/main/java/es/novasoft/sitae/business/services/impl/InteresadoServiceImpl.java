package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.InteresadoDAO;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.InteresadoService;

public class InteresadoServiceImpl implements InteresadoService {

	private static Log log = LogFactory.getFactory().getInstance(CentroProcedenciaServiceImpl.class);

	private InteresadoDAO InteresadoDAO;

	public InteresadoDAO getInteresadoDao() {
		return InteresadoDAO;
	}

	public void setInteresadoDAO(InteresadoDAO InteresadoDAO) {
		this.InteresadoDAO = InteresadoDAO;
	}

	public void save(Interesado transientInstance) throws ServiceException {
		log.debug("save Interesado");
		try {
			InteresadoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(Interesado persistentInstance) throws ServiceException {
		log.debug("deleting Interesado instance");
		try {
			InteresadoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Interesado findById(Integer id) throws ServiceException {
		log.debug("getting Interesado instance with id: " + id);
		try {
			return InteresadoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(Interesado instance) throws ServiceException {
		log.debug("finding Interesado instance by example");
		try {
			return InteresadoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return InteresadoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByEmail(Object email) throws ServiceException {
		log.debug("findByNombre");
		try {
			return InteresadoDAO.findByEmail(email);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Tipo de Edicto");
		try {
			return InteresadoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Interesado merge(Interesado detachedInstance) throws ServiceException {
		log.debug("merging Interesado instance");
		try {
			return InteresadoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(Interesado instance) throws ServiceException {
		log.debug("attaching dirty Interesado instance");
		try {
			InteresadoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(Interesado instance) throws ServiceException {
		log.debug("attaching clean Interesado instance");
		try {
			InteresadoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Interesado findByEmailOrganismoActivo(String email, Organismo org, Boolean activo) throws ServiceException {
		log.debug("findByEmailOrganismoActivo");
		try {
			return InteresadoDAO.findByEmailOrganismoActivo(email, org, activo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAllByOrg(Organismo org) throws ServiceException {
		log.debug("findByEmailOrganismoActivo");
		try {
			return InteresadoDAO.findAllByOrg(org, Boolean.TRUE);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
}
