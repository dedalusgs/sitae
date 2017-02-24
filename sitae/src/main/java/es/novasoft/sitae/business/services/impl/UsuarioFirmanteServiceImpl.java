package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.UsuarioFirmanteDAO;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;

public class UsuarioFirmanteServiceImpl implements UsuarioFirmanteService {

	private static Log log = LogFactory.getFactory().getInstance(
			UsuarioFirmanteServiceImpl.class);

	private UsuarioFirmanteDAO usuarioFirmanteDAO;

	public UsuarioFirmanteDAO getUsuarioFirmanteDAO() {
		return usuarioFirmanteDAO;
	}

	public void setUsuarioFirmanteDAO(UsuarioFirmanteDAO usuarioFirmanteDAO) {
		this.usuarioFirmanteDAO = usuarioFirmanteDAO;
	}

	public void save(UsuarioFirmante transientInstance) throws ServiceException {
		log.debug("save UsuarioFirmante");
		try {
			usuarioFirmanteDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(UsuarioFirmante persistentInstance)
			throws ServiceException {
		log.debug("deleting UsuarioFirmante instance");
		try {
			usuarioFirmanteDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public UsuarioFirmante findById(Integer id) throws ServiceException {
		log.debug("getting UsuarioFirmante instance with id: " + id);
		try {
			return usuarioFirmanteDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByExample(UsuarioFirmante instance) throws ServiceException {
		log.debug("finding UsuarioFirmante instance by example");
		try {
			return usuarioFirmanteDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ServiceException {
		try {
			return usuarioFirmanteDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioFirmanteDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByApellido1(Object apellido1) throws ServiceException {
		log.debug("findByApellido1");
		try {
			return usuarioFirmanteDAO.findByApellido1(apellido1);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByApellido2(Object apellido2) throws ServiceException {
		log.debug("findByApellido2");
		try {
			return usuarioFirmanteDAO.findByApellido2(apellido2);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByCargo(Object cargo) throws ServiceException {
		log.debug("findByNombre");
		try {
			return usuarioFirmanteDAO.findByCargo(cargo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByNumeroDocumento(Object numDocumento)
			throws ServiceException {
		log.debug("findByNumeroDocumento");
		try {
			return usuarioFirmanteDAO.findByNumeroDocumento(numDocumento);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findAll() throws ServiceException {
		log.debug("findAll UsuarioFirmante");
		try {
			return usuarioFirmanteDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public UsuarioFirmante merge(UsuarioFirmante detachedInstance)
			throws ServiceException {
		log.debug("merging UsuarioFirmante");
		try {
			return usuarioFirmanteDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(UsuarioFirmante instance) throws ServiceException {
		log.debug("attaching dirty UsuarioFirmante instance");
		try {
			usuarioFirmanteDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(UsuarioFirmante instance) throws ServiceException {
		log.debug("attaching clean UsuarioFirmante instance");
		try {
			usuarioFirmanteDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByIdOrg(Integer idOrg) throws ServiceException {
		log.debug("finding UsuarioFirmante instance by example");
		try {
			return usuarioFirmanteDAO.findByIdOrg(idOrg);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByIdOrgNumeroDocumento(Integer idOrg, String numDocumento)
			throws ServiceException {
		log.debug("finding UsuarioFirmante instance by example");
		try {
			return usuarioFirmanteDAO.findByIdOrgNumeroDocumento(idOrg,
					numDocumento);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public int findByFilterCont(Integer idOrg, String nombre, String nif)
			throws ServiceException {

		log.debug("finding UsuarioFirmante instance by example");

		try {
			return usuarioFirmanteDAO.findByFilterCont(idOrg, nombre, nif);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List findByFilter(Integer idOrg, String nombre, String nif,
			int numPag, int tamPag) throws ServiceException {

		log.debug("finding UsuarioFirmante instance by example");

		try {
			return usuarioFirmanteDAO.findByFilter(idOrg, nombre, nif, numPag,
					tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
