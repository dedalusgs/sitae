package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.sitae.business.dao.interfaz.RelacionEdictosDAO;
import es.novasoft.sitae.business.objects.RelacionEdictos;

public class RelacionEdictosDAOImpl extends DAOBaseImpl implements RelacionEdictosDAO {

	private static final Log log = LogFactory.getLog(RelacionEdictosDAOImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(RelacionEdictos transientInstance) {
		log.debug("saving RelacionEdictos instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RelacionEdictos persistentInstance) {
		log.debug("deleting RelacionEdictos instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelacionEdictos findById(Integer id) {
		log.debug("getting RelacionEdictos instance with id: " + id);
		try {
			RelacionEdictos instance = (RelacionEdictos) getHibernateTemplate().get(
					"es.novasoft.sitae.business.objects.RelacionEdictos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RelacionEdictos instance) {
		log.debug("finding RelacionEdictos instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RelacionEdictos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RelacionEdictos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all RelacionEdictos instances");
		try {
			String queryString = "from RelacionEdictos order by idRelacion";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RelacionEdictos merge(RelacionEdictos detachedInstance) {
		log.debug("merging RelacionEdictos instance");
		try {
			RelacionEdictos result = (RelacionEdictos) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RelacionEdictos instance) {
		log.debug("attaching dirty RelacionEdictos instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelacionEdictos instance) {
		log.debug("attaching clean RelacionEdictos instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByEdicto(Integer idEdicto) {

		log.debug(" findByEdicto instance");

		try {
			String queryString = " from RelacionEdictos as model where (1=1)";
			queryString += " AND (model.edicto1.idEdicto=" + idEdicto + " ";
			queryString += " OR model.edicto2.idEdicto=" + idEdicto + ") ";
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

}
