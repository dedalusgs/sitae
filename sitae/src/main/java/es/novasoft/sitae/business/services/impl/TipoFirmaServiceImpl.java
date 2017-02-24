package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.TipoFirmaDAO;
import es.novasoft.sitae.business.objects.TipoFirma;
import es.novasoft.sitae.business.services.interfaz.TipoFirmaService;

public class TipoFirmaServiceImpl implements TipoFirmaService {

	private static Log log = LogFactory.getFactory().getInstance(
			CentroProcedenciaServiceImpl.class);

	private TipoFirmaDAO TipoFirmaDAO;

	public TipoFirmaDAO getTipoFirmaDAO() {
		return TipoFirmaDAO;
	}

	public void setTipoFirmaDAO(TipoFirmaDAO TipoFirmaDAO) {
		this.TipoFirmaDAO = TipoFirmaDAO;
	}

	public void save(TipoFirma transientInstance) throws ServiceException {
		log.debug("save TipoFirma");
		try {
			TipoFirmaDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(TipoFirma persistentInstance)
			throws ServiceException {
		log.debug("deleting TipoFirma instance");
		try {
			TipoFirmaDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public TipoFirma findById(Integer id) throws ServiceException {
		log.debug("getting TipoFirma instance with id: " + id);
		try {
			return TipoFirmaDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(TipoFirma instance) throws ServiceException {
		log.debug("finding TipoFirma instance by example");
		try {
			return TipoFirmaDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return TipoFirmaDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return TipoFirmaDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Perfil");
		try {
			return TipoFirmaDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public TipoFirma merge(TipoFirma detachedInstance)
			throws ServiceException {
		log.debug("merging TipoFirma instance");
		try {
			return TipoFirmaDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(TipoFirma instance) throws ServiceException {
		log.debug("attaching dirty TipoFirma instance");
		try {
			TipoFirmaDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(TipoFirma instance) throws ServiceException {
		log.debug("attaching clean TipoFirma instance");
		try {
			TipoFirmaDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
