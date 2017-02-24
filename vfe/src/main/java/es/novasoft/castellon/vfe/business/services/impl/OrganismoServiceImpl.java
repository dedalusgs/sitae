/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: OrganismoServiceImpl.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.castellon.vfe.business.dao.interfaz.OrganismoDAO;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * The Class OrganismoServiceImpl.
 */
public class OrganismoServiceImpl implements OrganismoService {

	/** The log. */
	private static Log log = LogFactory.getFactory().getInstance(
			OrganismoServiceImpl.class);

	/** The organismo dao. */
	private OrganismoDAO organismoDAO;

	/**
	 * Gets the organismo dao.
	 * 
	 * @return the organismo dao
	 */
	public OrganismoDAO getOrganismoDao() {
		return organismoDAO;
	}

	/**
	 * Sets the organismo dao.
	 * 
	 * @param organismoDAO
	 *            the new organismo dao
	 */
	public void setOrganismoDAO(OrganismoDAO organismoDAO) {
		this.organismoDAO = organismoDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#save(es
	 * .novasoft.uvtae.business.objects.Organismo)
	 */
	public void save(Organismo transientInstance) throws ServiceException {
		log.debug("save Organismo");
		try {
			organismoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#delete(
	 * es.novasoft.uvtae.business.objects.Organismo)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findById
	 * (java.lang.Integer)
	 */
	public Organismo findById(Integer id) throws ServiceException {
		log.debug("getting Organismo instance with id: " + id);
		try {
			return organismoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByExample
	 * (es.novasoft.uvtae.business.objects.Organismo)
	 */
	public List findByExample(Organismo instance) throws ServiceException {
		log.debug("finding Organismo instance by example");
		try {
			return organismoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByProperty
	 * (java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return organismoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByNombre
	 * (java.lang.Object)
	 */
	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return organismoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByDireccion
	 * (java.lang.Object)
	 */
	public List findByDireccion(Object direccion) throws ServiceException {
		log.debug("findByDireccion");
		try {
			return organismoDAO.findByDireccion(direccion);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByTelefono
	 * (java.lang.Object)
	 */
	public List findByTelefono(Object telefono) throws ServiceException {
		log.debug("findByTelefono");
		try {
			return organismoDAO.findByTelefono(telefono);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByFax
	 * (java.lang.Object)
	 */
	public List findByFax(Object fax) throws ServiceException {
		log.debug("findByFax");
		try {
			return organismoDAO.findByFax(fax);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByEmail
	 * (java.lang.Object)
	 */
	public List findByEmail(Object email) throws ServiceException {
		log.debug("findByEmail");
		try {
			return organismoDAO.findByEmail(email);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByImagen
	 * (java.lang.Object)
	 */
	public List findByImagen(Object imagen) throws ServiceException {
		log.debug("findByImagen");
		try {
			return organismoDAO.findByImagen(imagen);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findAll()
	 */
	public List findAll() throws ServiceException {
		log.debug("findAll Organismo");
		try {
			return organismoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#merge(es
	 * .novasoft.uvtae.business.objects.Organismo)
	 */
	public Organismo merge(Organismo detachedInstance) throws ServiceException {
		log.debug("merging Organismo instance");
		try {
			return organismoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#attachDirty
	 * (es.novasoft.uvtae.business.objects.Organismo)
	 */
	public void attachDirty(Organismo instance) throws ServiceException {
		log.debug("attaching dirty Organismo instance");
		try {
			organismoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#attachClean
	 * (es.novasoft.uvtae.business.objects.Organismo)
	 */
	public void attachClean(Organismo instance) throws ServiceException {
		log.debug("attaching clean Organismo instance");
		try {
			organismoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.OrganismoService#findByCodigo
	 * (java.lang.String)
	 */
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
