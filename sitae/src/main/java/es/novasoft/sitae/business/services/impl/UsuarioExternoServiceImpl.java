/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoServiceImpl.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioExternoServiceImpl.
 */
public class UsuarioExternoServiceImpl implements UsuarioExternoService {

	/** The log. */
	private static Log log = LogFactory.getFactory().getInstance(
			UsuarioExternoServiceImpl.class);

	/** The usuarioExterno dao. */
	private UsuarioExternoDAO usuarioExternoDAO;

	/**
	 * Gets the usuarioExterno dao.
	 * 
	 * @return the usuarioExterno dao
	 */
	public UsuarioExternoDAO getUsuarioExternoDAO() {
		return usuarioExternoDAO;
	}

	/**
	 * Sets the usuarioExterno dao.
	 * 
	 * @param usuarioExternoDAO
	 *            the new usuarioExterno dao
	 */
	public void setUsuarioExternoDAO(UsuarioExternoDAO usuarioExternoDAO) {
		this.usuarioExternoDAO = usuarioExternoDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#save(es.novasoft
	 * .sitae.business.objects.UsuarioExterno)
	 */
	public void save(UsuarioExterno transientInstance) throws ServiceException {
		log.debug("save UsuarioExterno");
		try {
			usuarioExternoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#delete(es
	 * .novasoft.sitae.business.objects.UsuarioExterno)
	 */
	public void delete(UsuarioExterno persistentInstance) throws ServiceException {
		log.debug("deleting UsuarioExterno instance");
		try {
			usuarioExternoDAO.delete(persistentInstance);
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
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#findById(
	 * java.lang.Integer)
	 */
	public UsuarioExterno findById(Integer id) throws ServiceException {
		log.debug("getting UsuarioExterno instance with id: " + id);
		try {
			return usuarioExternoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#findByExample
	 * (es.novasoft.sitae.business.objects.UsuarioExterno)
	 */
	public List findByExample(UsuarioExterno instance) throws ServiceException {
		log.debug("finding UsuarioExterno instance by example");
		try {
			return usuarioExternoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#findByProperty
	 * (java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return usuarioExternoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#findAll()
	 */
	public List findAll() throws ServiceException {
		log.debug("findAll UsuarioExterno");
		try {
			return usuarioExternoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#merge(es.
	 * novasoft.sitae.business.objects.UsuarioExterno)
	 */
	public UsuarioExterno merge(UsuarioExterno detachedInstance) throws ServiceException {
		log.debug("merging UsuarioExterno");
		try {
			return usuarioExternoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#attachDirty
	 * (es.novasoft.sitae.business.objects.UsuarioExterno)
	 */
	public void attachDirty(UsuarioExterno instance) throws ServiceException {
		log.debug("attaching dirty UsuarioExterno instance");
		try {
			usuarioExternoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#attachClean
	 * (es.novasoft.sitae.business.objects.UsuarioExterno)
	 */
	public void attachClean(UsuarioExterno instance) throws ServiceException {
		log.debug("attaching clean UsuarioExterno instance");
		try {
			usuarioExternoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.services.interfaz.UsuarioExternoService#findFromUni
	 * (java.lang.String)
	 */
	public UsuarioExterno findFromUser(String usu) throws ServiceException {
		UsuarioExterno usuarioExterno = null;
		log.debug("Buscando usu externo.");
		try {
			usuarioExterno = usuarioExternoDAO.findByUsu(usu);
		} catch (DAOException e) {
			//log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}

		return usuarioExterno;
	}


}
