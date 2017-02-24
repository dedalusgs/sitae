package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.UsuarioDAO;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private static Log log = LogFactory.getFactory().getInstance(
			UsuarioServiceImpl.class);

	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void save(Usuario transientInstance) throws ServiceException {
		log.debug("save Usuario");
		try {
			usuarioDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

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

	public Usuario findById(Integer id) throws ServiceException {
		log.debug("getting Usuario instance with id: " + id);
		try {
			return usuarioDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(Usuario instance) throws ServiceException {
		log.debug("finding Usuario instance by example");
		try {
			return usuarioDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return usuarioDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByApellido1(Object apellido1) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioDAO.findByApellido1(apellido1);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByApellido2(Object apellido2) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioDAO.findByApellido2(apellido2);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByTelefono(Object telefono) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioDAO.findByTelefono(telefono);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByMovil(Object movil) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioDAO.findByMovil(movil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByEmail(Object email) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioDAO.findByEmail(email);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNumeroDocumento(Object numDocumento)
			throws ServiceException {
		log.debug("findByNumeroDocumento");
		try {
			return usuarioDAO.findByNumeroDocumento(numDocumento);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Usuario");
		try {
			return usuarioDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Usuario merge(Usuario detachedInstance) throws ServiceException {
		log.debug("merging Usuario");
		try {
			return usuarioDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(Usuario instance) throws ServiceException {
		log.debug("attaching dirty Usuario instance");
		try {
			usuarioDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(Usuario instance) throws ServiceException {
		log.debug("attaching clean Usuario instance");
		try {
			usuarioDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
