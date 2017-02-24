package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.RelacionUsuOrgCentroPerfDAO;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;

public class RelacionUsuOrgCentroPerfServiceImpl implements
		RelacionUsuOrgCentroPerfService {

	private static Log log = LogFactory.getFactory().getInstance(
			RelacionUsuOrgCentroPerfServiceImpl.class);

	private RelacionUsuOrgCentroPerfDAO relacionUsuOrgCentroPerfDAO;

	public RelacionUsuOrgCentroPerfDAO getRelacionUsuOrgCentroPerfDAO() {
		return relacionUsuOrgCentroPerfDAO;
	}

	public void setRelacionUsuOrgCentroPerfDAO(
			RelacionUsuOrgCentroPerfDAO relacionUsuOrgCentroPerfDAO) {
		this.relacionUsuOrgCentroPerfDAO = relacionUsuOrgCentroPerfDAO;
	}

	public void save(RelacionUsuOrgCentroPerf transientInstance)
			throws ServiceException {
		log.debug("save RelacionUsuOrgCentroPerf");
		try {
			relacionUsuOrgCentroPerfDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(RelacionUsuOrgCentroPerf persistentInstance)
			throws ServiceException {
		log.debug("deleting RelacionUsuOrgCentroPerf instance");
		try {
			relacionUsuOrgCentroPerfDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RelacionUsuOrgCentroPerf findById(Integer id)
			throws ServiceException {
		log.debug("getting RelacionUsuOrgCentroPerf instance with id: " + id);
		try {
			return relacionUsuOrgCentroPerfDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(RelacionUsuOrgCentroPerf instance)
			throws ServiceException {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return relacionUsuOrgCentroPerfDAO.findByProperty(propertyName,
					value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll RelacionUsuOrgCentroPerf");
		try {
			return relacionUsuOrgCentroPerfDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public RelacionUsuOrgCentroPerf merge(
			RelacionUsuOrgCentroPerf detachedInstance) throws ServiceException {
		log.debug("merging RelacionUsuOrgCentroPerf instance");
		try {
			return relacionUsuOrgCentroPerfDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(RelacionUsuOrgCentroPerf instance)
			throws ServiceException {
		log.debug("attaching dirty RelacionUsuOrgCentroPerf instance");
		try {
			relacionUsuOrgCentroPerfDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(RelacionUsuOrgCentroPerf instance)
			throws ServiceException {
		log.debug("attaching clean RelacionUsuOrgCentroPerf instance");
		try {
			relacionUsuOrgCentroPerfDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByOrgUsuPerf(String cif, String dni, String id_pefil)
			throws ServiceException {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByOrgUsuPerf(cif, dni,
					id_pefil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByUsuPerf(String dni, String id_pefil)
			throws ServiceException {
		log.debug("finding findByUsuPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByUsuPerf(dni, id_pefil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCentroUsuPerf(String idCentro, String dni, String id_pefil)
			throws ServiceException {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByCentroUsuPerf(idCentro,
					dni, id_pefil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCif(String cif) throws ServiceException {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByCif(cif);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByPerfil(Integer idPerfil) throws ServiceException {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByPerfil(idPerfil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByUsuario(String dni) throws ServiceException {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByUsuario(dni);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCifDni(String cif, String dni) throws ServiceException {
		log.debug("finding findByCifDni instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByCifDni(cif, dni);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCentroPerfil(Integer idCentro, Integer idPerfil)
			throws ServiceException {
		log.debug("finding findByCentroPerfil instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByCentroPerfil(idCentro,
					idPerfil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCentro(Integer idCentro) throws ServiceException {
		log.debug("finding findByCentro instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByCentro(idCentro);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByOrgPerf(String cif, String idPerfil)
			throws ServiceException {
		log.debug("finding findByOrgPerf instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByOrgPerf(cif, idPerfil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByOrgIncluyendoPerfiles(String cif, List perfiles)
			throws ServiceException {
		log.debug("finding findByOrgIncluyendoPerfiles instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByOrgIncluyendoPerfiles(cif,
					perfiles);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByOrgNifIncluyendoPerfiles(String cif, String nif,
			List perfiles) throws ServiceException {
		log.debug("finding findByOrgNifIncluyendoPerfiles instance by example");
		try {
			return relacionUsuOrgCentroPerfDAO.findByOrgNifIncluyendoPerfiles(
					cif, nif, perfiles);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}