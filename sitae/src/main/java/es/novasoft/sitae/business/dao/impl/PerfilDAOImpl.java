package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.PerfilDAO;
import es.novasoft.sitae.business.objects.Perfil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Perfil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .Perfil
 * @author MyEclipse Persistence Tools
 */

public class PerfilDAOImpl extends DAOBaseImpl implements PerfilDAO {
	private static final Log log = LogFactory.getLog(PerfilDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	protected void initDao() {
		// do nothing
	}

	public void save(Perfil transientInstance) throws DAOException {
		log.debug("saving Perfil instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Perfil persistentInstance) throws DAOException {
		log.debug("deleting Perfil instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Perfil findById(Integer id) throws DAOException {
		log.debug("getting Perfil instance with id: " + id);
		try {
			Perfil instance = (Perfil) getHibernateTemplate().get(
					"es.novasoft.sitae.business.objects.Perfil", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Perfil instance) throws DAOException {
		log.debug("finding Perfil instance by example");
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
		log.debug("finding Perfil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Perfil as model where model."
					+ propertyName + "= ?";
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
		log.debug("finding all Perfil instances");
		try {
			String queryString = "from Perfil";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Perfil merge(Perfil detachedInstance) throws DAOException {
		log.debug("merging Perfil instance");
		try {
			Perfil result = (Perfil) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Perfil instance) throws DAOException {
		log.debug("attaching dirty Perfil instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Perfil instance) throws DAOException {
		log.debug("attaching clean Perfil instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}