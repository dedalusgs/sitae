/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoServiceImpl.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.castellon.vfe.business.dao.interfaz.UsuarioDAO;
import es.novasoft.castellon.vfe.business.objects.Usuario;
import es.novasoft.castellon.vfe.business.services.interfaz.UsuarioService;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioExternoServiceImpl.
 */
public class UsuarioServiceImpl implements UsuarioService {

	/** The log. */
	private static Log log = LogFactory.getFactory().getInstance(
			UsuarioServiceImpl.class);

	/** The Usuario dao. */
	private UsuarioDAO usuarioDAO;

	/**
	 * Gets the Usuario dao.
	 * 
	 * @return the Usuario dao
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * Sets the Usuario dao.
	 * 
	 * @param UsuarioDAO
	 *            the new Usuario dao
	 */
	public void setUsuarioDAO(UsuarioDAO UsuarioDAO) {
		this.usuarioDAO = UsuarioDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#save(es.novasoft
	 * .uvtae.business.objects.Usuario)
	 */
	public void save(Usuario transientInstance) throws ServiceException {
		log.debug("save Usuario");
		try {
			usuarioDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#delete(es
	 * .novasoft.uvtae.business.objects.Usuario)
	 */
	public void delete(Usuario persistentInstance) throws ServiceException {
		log.debug("deleting Usuario instance");
		try {
			usuarioDAO.delete(persistentInstance);
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
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#findById(
	 * java.lang.Integer)
	 */
	public Usuario findById(Integer id) throws ServiceException {
		log.debug("getting Usuario instance with id: " + id);
		try {
			return usuarioDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#findByExample
	 * (es.novasoft.uvtae.business.objects.Usuario)
	 */
	public List findByExample(Usuario instance) throws ServiceException {
		log.debug("finding Usuario instance by example");
		try {
			return usuarioDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#findByProperty
	 * (java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return usuarioDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#findAll()
	 */
	public List findAll() throws ServiceException {
		log.debug("findAll Usuario");
		try {
			return usuarioDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#merge(es.
	 * novasoft.uvtae.business.objects.Usuario)
	 */
	public Usuario merge(Usuario detachedInstance) throws ServiceException {
		log.debug("merging Usuario");
		try {
			return usuarioDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#attachDirty
	 * (es.novasoft.uvtae.business.objects.Usuario)
	 */
	public void attachDirty(Usuario instance) throws ServiceException {
		log.debug("attaching dirty Usuario instance");
		try {
			usuarioDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#attachClean
	 * (es.novasoft.uvtae.business.objects.Usuario)
	 */
	public void attachClean(Usuario instance) throws ServiceException {
		log.debug("attaching clean Usuario instance");
		try {
			usuarioDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.services.interfaz.UsuarioService#findFromUni
	 * (java.lang.String)
	 */
	public Usuario findFromUser(String usu) throws ServiceException {
		Usuario Usuario = null;
		log.debug("Buscando usu externo.");
		try {
			Usuario = usuarioDAO.findByUsu(usu);
		} catch (DAOException e) {
			// log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}

		return Usuario;
	}

}
