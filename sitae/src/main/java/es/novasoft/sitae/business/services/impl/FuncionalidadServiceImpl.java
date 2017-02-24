package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.FuncionalidadDAO;
import es.novasoft.sitae.business.objects.Funcionalidad;
import es.novasoft.sitae.business.services.interfaz.FuncionalidadService;

public class FuncionalidadServiceImpl implements FuncionalidadService {

	private static Log log = LogFactory.getFactory().getInstance(
			CentroProcedenciaServiceImpl.class);

	private FuncionalidadDAO funcionalidadDAO;

	public FuncionalidadDAO getFuncionalidadDAO() {
		return funcionalidadDAO;
	}

	public void setFuncionalidadDAO(FuncionalidadDAO funcionalidadDAO) {
		this.funcionalidadDAO = funcionalidadDAO;
	}

	public void save(Funcionalidad transientInstance) throws ServiceException {
		log.debug("save Funcionalidad");
		try {
			funcionalidadDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(Funcionalidad persistentInstance)
			throws ServiceException {
		log.debug("deleting Funcionalidad instance");
		try {
			funcionalidadDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Funcionalidad findById(Integer id) throws ServiceException {
		log.debug("getting Funcionalidad instance with id: " + id);
		try {
			return funcionalidadDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(Funcionalidad instance) throws ServiceException {
		log.debug("finding Funcionalidad instance by example");
		try {
			return funcionalidadDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return funcionalidadDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return funcionalidadDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll Perfil");
		try {
			return funcionalidadDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public Funcionalidad merge(Funcionalidad detachedInstance)
			throws ServiceException {
		log.debug("merging Funcionalidad instance");
		try {
			return funcionalidadDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(Funcionalidad instance) throws ServiceException {
		log.debug("attaching dirty Funcionalidad instance");
		try {
			funcionalidadDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(Funcionalidad instance) throws ServiceException {
		log.debug("attaching clean Funcionalidad instance");
		try {
			funcionalidadDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
