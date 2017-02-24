package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.OrganismoDAO;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class OrganismoServiceImpl implements OrganismoService {

	private static Log log = LogFactory.getFactory().getInstance(
			OrganismoServiceImpl.class);

	private OrganismoDAO organismoDAO;

	public OrganismoDAO getOrganismoDao() {
		return organismoDAO;
	}

	public void setOrganismoDAO(OrganismoDAO organismoDAO) {
		this.organismoDAO = organismoDAO;
	}

	public void save(Organismo transientInstance) throws ServiceException {
		log.debug("save Organismo");
		try {
			organismoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(Organismo persistentInstance) throws ServiceException {
		log.debug("deleting Organismo instance");
		try {
			organismoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Organismo findById(Integer id) throws ServiceException {
		log.debug("getting Organismo instance with id: " + id);
		try {
			return organismoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(Organismo instance) throws ServiceException {
		log.debug("finding Organismo instance by example");
		try {
			return organismoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return organismoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return organismoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCif(Object cif) throws DAOException {
		log.debug("findByCif");
		try {
			return organismoDAO.findByCif(cif);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByDireccion(Object direccion) throws DAOException {
		log.debug("findByDireccion");
		try {
			return organismoDAO.findByDireccion(direccion);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByTelefono(Object telefono) throws DAOException {
		log.debug("findByTelefono");
		try {
			return organismoDAO.findByTelefono(telefono);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByFax(Object fax) throws DAOException {
		log.debug("findByFax");
		try {
			return organismoDAO.findByFax(fax);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByEmail(Object email) throws DAOException {
		log.debug("findByEmail");
		try {
			return organismoDAO.findByEmail(email);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByImagen(Object imagen) throws DAOException {
		log.debug("findByImagen");
		try {
			return organismoDAO.findByImagen(imagen);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Organismo");
		try {
			return organismoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Organismo merge(Organismo detachedInstance) throws ServiceException {
		log.debug("merging Organismo instance");
		try {
			return organismoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(Organismo instance) throws ServiceException {
		log.debug("attaching dirty Organismo instance");
		try {
			organismoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(Organismo instance) throws ServiceException {
		log.debug("attaching clean Organismo instance");
		try {
			organismoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCodigo(String codigo) throws ServiceException {
		log.debug("finding findByCodigo instance by example");
		try {
			return organismoDAO.findByCodigo(codigo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
