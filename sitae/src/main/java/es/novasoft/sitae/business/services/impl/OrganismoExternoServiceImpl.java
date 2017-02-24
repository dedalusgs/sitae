package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.OrganismoExternoDAO;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;

public class OrganismoExternoServiceImpl implements OrganismoExternoService {

	private static Log log = LogFactory.getFactory().getInstance(
			OrganismoExternoServiceImpl.class);

	private OrganismoExternoDAO organismoExternoDAO;

	public OrganismoExternoDAO getOrganismoExternoDao() {
		return organismoExternoDAO;
	}

	public void setOrganismoExternoDAO(OrganismoExternoDAO organismoExternoDAO) {
		this.organismoExternoDAO = organismoExternoDAO;
	}

	public void save(OrganismoExterno transientInstance)
			throws ServiceException {
		log.debug("save OrganismoExterno");
		try {
			organismoExternoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(OrganismoExterno persistentInstance)
			throws ServiceException {
		log.debug("deleting OrganismoExterno instance");
		try {
			organismoExternoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public OrganismoExterno findById(Integer id) throws ServiceException {
		log.debug("getting OrganismoExterno instance with id: " + id);
		try {
			return organismoExternoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(OrganismoExterno instance)
			throws ServiceException {
		log.debug("finding OrganismoExterno instance by example");
		try {
			return organismoExternoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return organismoExternoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return organismoExternoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCif(Object cif) throws DAOException {
		log.debug("findByCif");
		try {
			return organismoExternoDAO.findByCif(cif);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByDireccion(Object direccion) throws DAOException {
		log.debug("findByDireccion");
		try {
			return organismoExternoDAO.findByDireccion(direccion);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByTelefono(Object telefono) throws DAOException {
		log.debug("findByTelefono");
		try {
			return organismoExternoDAO.findByTelefono(telefono);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByFax(Object fax) throws DAOException {
		log.debug("findByFax");
		try {
			return organismoExternoDAO.findByFax(fax);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByEmail(Object email) throws DAOException {
		log.debug("findByEmail");
		try {
			return organismoExternoDAO.findByEmail(email);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll OrganismoExterno");
		try {
			return organismoExternoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public OrganismoExterno merge(OrganismoExterno detachedInstance)
			throws ServiceException {
		log.debug("merging Organismo instance");
		try {
			return organismoExternoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(OrganismoExterno instance) throws ServiceException {
		log.debug("attaching dirty OrganismoExterno instance");
		try {
			organismoExternoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(OrganismoExterno instance) throws ServiceException {
		log.debug("attaching clean OrganismoExterno instance");
		try {
			organismoExternoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
