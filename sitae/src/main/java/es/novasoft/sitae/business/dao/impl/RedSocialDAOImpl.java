package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.RedSocialDAO;
import es.novasoft.sitae.business.objects.RedSocial;

/**
 * A data access object (DAO) providing persistence and search support for
 * RedSocial entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .RedSocial
 * @author MyEclipse Persistence Tools
 */

public class RedSocialDAOImpl extends DAOBaseImpl implements RedSocialDAO {
	private static final Log log = LogFactory.getLog(RedSocialDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(RedSocial transientInstance) throws DAOException {
		log.debug("saving RedSocial instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RedSocial persistentInstance) throws DAOException {
		log.debug("deleting RedSocial instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RedSocial findById(Integer id) throws DAOException {
		log.debug("getting RedSocial instance with id: " + id);
		try {
			RedSocial instance = (RedSocial) getHibernateTemplate().get("es.novasoft.sitae.business.objects.RedSocial", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RedSocial instance) throws DAOException {
		log.debug("finding RedSocial instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) throws DAOException {
		log.debug("finding RedSocial instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RedSocial as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() throws DAOException {
		log.debug("finding all RedSocial instances");
		try {
			String queryString = "from RedSocial order by nombre";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RedSocial merge(RedSocial detachedInstance) throws DAOException {
		log.debug("merging RedSocial instance");
		try {
			RedSocial result = (RedSocial) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RedSocial instance) throws DAOException {
		log.debug("attaching dirty RedSocial instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RedSocial instance) throws DAOException {
		log.debug("attaching clean RedSocial instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}