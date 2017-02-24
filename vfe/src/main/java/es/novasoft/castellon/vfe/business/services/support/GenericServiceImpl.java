package es.novasoft.castellon.vfe.business.services.support;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;

import es.novasoft.castellon.vfe.business.dao.support.GenericDao;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	public abstract Log log();

	public abstract Class<T> tipoClase();

	public abstract GenericDao<T, ID> getDao();

	public GenericServiceImpl() {
		super();
	}

	public void save(T transientInstance) throws ServiceException {
		log().debug("save  " + tipoClase().getSimpleName() + " ");
		try {
			getDao().save(transientInstance);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void delete(T persistentInstance) throws ServiceException {
		log().debug("deleting  " + tipoClase().getSimpleName() + "  instance");
		try {
			getDao().delete(persistentInstance);
			log().debug("delete successful");
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public T findById(ID id) throws ServiceException {
		log().debug("getting  " + tipoClase().getSimpleName() + "  instance with id: " + id);
		try {
			return getDao().findById(id);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List<T> findByExample(T instance) throws ServiceException {
		log().debug("finding  " + tipoClase().getSimpleName() + "  instance by example");
		try {
			return getDao().findByExample(instance);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List<T> findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return getDao().findByProperty(propertyName, value);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public List<T> findAll() throws ServiceException {
		log().debug("findAll  " + tipoClase().getSimpleName() + " ");
		try {
			return getDao().findAll();
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public T merge(T detachedInstance) throws ServiceException {
		log().debug("merging  " + tipoClase().getSimpleName() + "  instance");
		try {
			return getDao().merge(detachedInstance);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachDirty(T instance) throws ServiceException {
		log().debug("attaching dirty  " + tipoClase().getSimpleName() + "  instance");
		try {
			getDao().attachDirty(instance);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

	public void attachClean(T instance) throws ServiceException {
		log().debug("attaching clean  " + tipoClase().getSimpleName() + "  instance");
		try {
			getDao().attachClean(instance);
		} catch (DAOException e) {
			log().error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}

}
