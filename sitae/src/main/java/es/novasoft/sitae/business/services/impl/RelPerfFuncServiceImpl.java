package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.RelPerfFuncDAO;
import es.novasoft.sitae.business.objects.RelPerfFunc;
import es.novasoft.sitae.business.services.interfaz.RelPerfFuncService;

public class RelPerfFuncServiceImpl implements RelPerfFuncService {

	private static Log log = LogFactory.getFactory().getInstance(
			RelacionUsuOrgCentroPerfServiceImpl.class);

	private RelPerfFuncDAO relPerfFuncDAO;

	public RelPerfFuncDAO getRelPerfFuncDAO() {
		return relPerfFuncDAO;
	}

	public void setRelPerfFuncDAO(RelPerfFuncDAO relPerfFuncDAO) {
		this.relPerfFuncDAO = relPerfFuncDAO;
	}

	public void save(RelPerfFunc transientInstance) throws ServiceException {
		log.debug("save RelPerfFunc");
		try {
			relPerfFuncDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(RelPerfFunc persistentInstance) throws ServiceException {
		log.debug("deleting RelPerfFunc instance");
		try {
			relPerfFuncDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RelPerfFunc findById(Integer id) throws ServiceException {
		log.debug("getting RelPerfFunc instance with id: " + id);
		try {
			return relPerfFuncDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(RelPerfFunc instance) throws ServiceException {
		log.debug("finding RelPerfFunc instance by example");
		try {
			return relPerfFuncDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return relPerfFuncDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll RelPerfFunc");
		try {
			return relPerfFuncDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RelPerfFunc merge(RelPerfFunc detachedInstance)
			throws ServiceException {
		log.debug("merging RelacionUsuOrgCentroPerf instance");
		try {
			return relPerfFuncDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(RelPerfFunc instance) throws ServiceException {
		log.debug("attaching dirty RelPerfFunc instance");
		try {
			relPerfFuncDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(RelPerfFunc instance) throws ServiceException {
		log.debug("attaching clean RelacionUsuOrgCentroPerf instance");
		try {
			relPerfFuncDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByPerfil(Integer idPerfil) throws ServiceException {
		log.debug("finding findByPerfil instance by example");
		try {
			return relPerfFuncDAO.findByPerfil(idPerfil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByIdFuncionalidad(Integer idFuncionalidad)
			throws ServiceException {
		log.debug("finding RelPerfFunc instance with idFuncionalidad: "
				+ idFuncionalidad);
		try {
			return relPerfFuncDAO.findByIdFuncionalidad(idFuncionalidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
