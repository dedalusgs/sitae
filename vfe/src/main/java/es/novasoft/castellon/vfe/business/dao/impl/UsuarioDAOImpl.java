/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: UsuarioExternoDAOImpl.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.castellon.vfe.business.dao.interfaz.UsuarioDAO;
import es.novasoft.castellon.vfe.business.objects.Usuario;
import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;

// TODO: Auto-generated Javadoc
/**
 * A data access object (DAO) providing persistence and search support for
 * UsuarioExterno entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .Usuario
 * @author MyEclipse Persistence Tools
 */

public class UsuarioDAOImpl extends DAOBaseImpl implements UsuarioDAO {

	/** The Constant log. */
	private static final Log LOG = LogFactory.getLog(UsuarioDAOImpl.class);

	// property constants
	/** The Constant NOMBRE. */
	public static final String USU = "usuario";

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
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#save(es.novasoft
	 * .uvtae .business.objects.Usuario)
	 */
	public void save(Usuario transientInstance) throws DAOException {
		LOG.debug("saving Usuario instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#delete(es.novasoft
	 * .uvtae.business.objects.Usuario)
	 */
	public void delete(Usuario persistentInstance) throws DAOException {
		LOG.debug("deleting Usuario instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOG.debug("delete successful");
		} catch (RuntimeException re) {
			LOG.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#findById(java
	 * .lang .Integer)
	 */
	public Usuario findById(Integer id) throws DAOException {
		LOG.debug("getting Usuario instance with id: " + id);
		try {
			Usuario instance = (Usuario) getHibernateTemplate().get(
					"es.novasoft.castellon.vfe.business.objects.Usuario", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#findByExample
	 * (es.novasoft .uvtae.business.objects.Usuario)
	 */
	public List findByExample(Usuario instance) throws DAOException {
		LOG.debug("finding Usuario instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			LOG.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			LOG.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#findByProperty
	 * (java .lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value)
			throws DAOException {
		LOG.debug("finding Usuario instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Usuario as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#findByNombre
	 * (java. lang.Object)
	 */
	public Usuario findByUsu(String usu) throws DAOException {
		List ret = findByProperty(USU, usu);
		if (ret == null || ret.isEmpty()) {
			throw new DAOException("usuario no encontrado");
		}
		return (Usuario) ret.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#findAll()
	 */
	public List findAll() throws DAOException {
		LOG.debug("finding all Usuario instances");
		try {
			String queryString = "from Usuario";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOG.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#merge(es.novasoft
	 * . uvtae.business.objects.Usuario)
	 */
	public Usuario merge(Usuario detachedInstance) throws DAOException {
		LOG.debug("merging Usuario instance");
		try {
			Usuario result = (Usuario) getHibernateTemplate().merge(
					detachedInstance);
			LOG.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOG.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#attachDirty
	 * (es.novasoft .uvtae.business.objects.Usuario)
	 */
	public void attachDirty(Usuario instance) throws DAOException {
		LOG.debug("attaching dirty Usuario instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOG.debug("attach successful");
		} catch (RuntimeException re) {
			LOG.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.UsuarioDAO#attachClean
	 * (es.novasoft .uvtae.business.objects.Usuario)
	 */
	public void attachClean(Usuario instance) throws DAOException {
		LOG.debug("attaching clean Usuario instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOG.debug("attach successful");
		} catch (RuntimeException re) {
			LOG.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * public static UsuarioDAOImpl getFromApplicationContext(ApplicationContext
	 * ctx) { return (UsuarioDAOImpl) ctx.getBean("UsuarioDAOImpl"); }
	 */
}