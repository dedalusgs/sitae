/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoDAOImpl.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO;
import es.novasoft.sitae.business.objects.UsuarioExterno;

// TODO: Auto-generated Javadoc
/**
 * A data access object (DAO) providing persistence and search support for
 * UsuarioExterno entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .UsuarioExterno
 * @author MyEclipse Persistence Tools
 */

public class UsuarioExternoDAOImpl extends DAOBaseImpl implements
		UsuarioExternoDAO {

	/** The Constant log. */
	private static final Log log = LogFactory
			.getLog(UsuarioExternoDAOImpl.class);

	// property constants
	/** The Constant NOMBRE. */
	public static final String USU = "usu";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.dao.support.DaoSupport#initDao()
	 */
	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#save(es.novasoft
	 * .sitae .business.objects.UsuarioExterno)
	 */
	public void save(UsuarioExterno transientInstance) throws DAOException {
		log.debug("saving UsuarioExterno instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#delete(es.novasoft
	 * .sitae.business.objects.UsuarioExterno)
	 */
	public void delete(UsuarioExterno persistentInstance) throws DAOException {
		log.debug("deleting UsuarioExterno instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#findById(java
	 * .lang .Integer)
	 */
	public UsuarioExterno findById(Integer id) throws DAOException {
		log.debug("getting UsuarioExterno instance with id: " + id);
		try {
			UsuarioExterno instance = (UsuarioExterno) getHibernateTemplate()
					.get("es.novasoft.sitae.business.objects.UsuarioExterno",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#findByExample
	 * (es.novasoft .sitae.business.objects.UsuarioExterno)
	 */
	public List findByExample(UsuarioExterno instance) throws DAOException {
		log.debug("finding UsuarioExterno instance by example");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#findByProperty
	 * (java .lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value)
			throws DAOException {
		log.debug("finding UsuarioExterno instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UsuarioExterno as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#findByNombre
	 * (java. lang.Object)
	 */
	public UsuarioExterno findByUsu(String usu) throws DAOException {
		List ret = findByProperty(USU, usu);
		if (ret == null || ret.isEmpty()) {
			throw new DAOException("usuario no encontrado");
		}
		return (UsuarioExterno) ret.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#findAll()
	 */
	public List findAll() throws DAOException {
		log.debug("finding all UsuarioExterno instances");
		try {
			String queryString = "from UsuarioExterno";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#merge(es.novasoft
	 * . sitae.business.objects.UsuarioExterno)
	 */
	public UsuarioExterno merge(UsuarioExterno detachedInstance)
			throws DAOException {
		log.debug("merging UsuarioExterno instance");
		try {
			UsuarioExterno result = (UsuarioExterno) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#attachDirty
	 * (es.novasoft .sitae.business.objects.UsuarioExterno)
	 */
	public void attachDirty(UsuarioExterno instance) throws DAOException {
		log.debug("attaching dirty UsuarioExterno instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.sitae.business.dao.interfaz.UsuarioExternoDAO#attachClean
	 * (es.novasoft .sitae.business.objects.UsuarioExterno)
	 */
	public void attachClean(UsuarioExterno instance) throws DAOException {
		log.debug("attaching clean UsuarioExterno instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * public static UsuarioExternoDAOImpl
	 * getFromApplicationContext(ApplicationContext ctx) { return
	 * (UsuarioExternoDAOImpl) ctx.getBean("UsuarioExternoDAOImpl"); }
	 */
}