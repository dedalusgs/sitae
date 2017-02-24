package es.novasoft.sitae.business.dao.support;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;

public abstract class GenericDaoImpl<T, ID extends Serializable> extends DAOBaseImpl implements GenericDao<T, ID> {

	public abstract Log log();

	public abstract Class<T> tipoClase();

	public GenericDaoImpl() {
		super();
	}

	public void save(T persistentInstance) throws DAOException {
		log().debug("saving " + tipoClase().getSimpleName() + " instance");
		try {
			getHibernateTemplate().save(persistentInstance);
			log().debug("save successful");
		} catch (RuntimeException re) {
			log().error("save failed", re);
			throw re;
		}
	}

	public void delete(T persistentInstance) throws DAOException {
		log().debug("deleting  " + tipoClase().getSimpleName() + "  instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log().debug("delete successful");
		} catch (RuntimeException re) {
			log().error("delete failed", re);
			throw re;
		}
	}

	public T findById(ID id) throws DAOException {
		log().debug("getting  " + tipoClase().getSimpleName() + " instance with id: " + id);
		try {

			T instance = getHibernateTemplate().get(tipoClase(), id);
			return instance;
		} catch (RuntimeException re) {
			log().error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T instance) throws DAOException {
		log().debug("finding  " + tipoClase().getSimpleName() + " instance by example");
		try {
			List<T> results = getHibernateTemplate().findByExample(instance);
			log().debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log().error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) throws DAOException {
		log().debug("finding " + tipoClase().getSimpleName() + " instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from " + tipoClase().getSimpleName() + " as model where model." + propertyName + "= ?";
			
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log().error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DAOException {
		log().debug("finding all " + tipoClase().getSimpleName() + " instances");
		try {
			String queryString = "from " + tipoClase().getSimpleName() + " as model";
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log().error("find all failed", re);
			throw re;
		}
	}

	public T merge(T detachedInstance) throws DAOException {
		log().debug("merging  " + tipoClase().getSimpleName() + "  instance");
		try {
			T result = getHibernateTemplate().merge(detachedInstance);
			log().debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log().error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(T instance) throws DAOException {
		log().debug("attaching dirty  " + tipoClase().getSimpleName() + "  instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log().debug("attach successful");
		} catch (RuntimeException re) {
			log().error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(T instance) throws DAOException {
		log().debug("attaching clean Estado instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log().debug("attach successful");
		} catch (RuntimeException re) {
			log().error("attach failed", re);
			throw re;
		}
	}

}
