package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.EstadoDAO;
import es.novasoft.sitae.business.objects.Estado;

public class EstadoDAOImpl extends DAOBaseImpl implements EstadoDAO {
	private static final Log log = LogFactory.getLog(PerfilDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	protected void initDao() {
		// do nothing
	}

	public void save(Estado transientInstance) throws DAOException {
		log.debug("saving Estado instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Estado persistentInstance) throws DAOException {
		log.debug("deleting Estado instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Estado findById(Integer id) throws DAOException {
		log.debug("getting Estado instance with id: " + id);
		try {
			Estado instance = (Estado) getHibernateTemplate().get(
					"es.novasoft.sitae.business.objects.Estado", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Estado instance) throws DAOException {
		log.debug("finding Estado instance by example");
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

	public List findByProperty(String propertyName, Object value)
			throws DAOException {
		log.debug("finding Estado instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Estado as model where model."
					+ propertyName + "= ?";
			queryString = queryString + " order by model.orden asc";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombre(Object nombre) throws DAOException {
		return findByProperty(NOMBRE, nombre);
	}

	public List findAll() throws DAOException {
		log.debug("finding all Estado instances");
		try {
			String queryString = "from Estado as model";
			queryString = queryString + " order by model.orden";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Estado merge(Estado detachedInstance) throws DAOException {
		log.debug("merging Perfil instance");
		try {
			Estado result = (Estado) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Estado instance) throws DAOException {
		log.debug("attaching dirty Estado instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Estado instance) throws DAOException {
		log.debug("attaching clean Estado instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
