package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.TipoEdictoDAO;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;

public class TipoEdictoServiceImpl implements TipoEdictoService {

	private static Log log = LogFactory.getFactory().getInstance(
			CentroProcedenciaServiceImpl.class);

	private TipoEdictoDAO tipoEdictoDAO;

	public TipoEdictoDAO getTipoEdictoDao() {
		return tipoEdictoDAO;
	}

	public void setTipoEdictoDAO(TipoEdictoDAO tipoEdictoDAO) {
		this.tipoEdictoDAO = tipoEdictoDAO;
	}

	public void save(TipoEdicto transientInstance) throws ServiceException {
		log.debug("save TipoEdicto");
		try {
			tipoEdictoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(TipoEdicto persistentInstance) throws ServiceException {
		log.debug("deleting TipoEdicto instance");
		try {
			tipoEdictoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public TipoEdicto findById(Integer id) throws ServiceException {
		log.debug("getting TipoEdicto instance with id: " + id);
		try {
			return tipoEdictoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(TipoEdicto instance) throws ServiceException {
		log.debug("finding TipoEdicto instance by example");
		try {
			return tipoEdictoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return tipoEdictoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return tipoEdictoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Tipo de Edicto");
		try {
			return tipoEdictoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public TipoEdicto merge(TipoEdicto detachedInstance)
			throws ServiceException {
		log.debug("merging TipoEdicto instance");
		try {
			return tipoEdictoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(TipoEdicto instance) throws ServiceException {
		log.debug("attaching dirty TipoEdicto instance");
		try {
			tipoEdictoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(TipoEdicto instance) throws ServiceException {
		log.debug("attaching clean TipoEdicto instance");
		try {
			tipoEdictoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByIdOrg(Integer idOrg) throws ServiceException {
		log.debug("finding TipoEdicto instance by example");
		try {
			return tipoEdictoDAO.findByIdOrg(idOrg);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombreCif(String nombre, String cif)
			throws ServiceException {
		log.debug("finding TipoEdicto instance by example");
		try {
			return tipoEdictoDAO.findByNombreCif(nombre, cif);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
