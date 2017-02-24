/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: OrganismoDAOImpl.java
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

import es.novasoft.castellon.vfe.business.dao.interfaz.OrganismoDAO;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;

// TODO: Auto-generated Javadoc
/**
 * A data access object (DAO) providing persistence and search support for
 * Organismo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .Organismo
 * @author MyEclipse Persistence Tools
 */

public class OrganismoDAOImpl extends DAOBaseImpl implements OrganismoDAO {

	/** The Constant log. */
	private static final Log LOG = LogFactory.getLog(OrganismoDAOImpl.class);

	// property constants
	/** The Constant NOMBRE. */
	public static final String NOMBRE = "nombre";

	/** The Constant DIRECCION. */
	public static final String DIRECCION = "direccion";

	/** The Constant TELEFONO. */
	public static final String TELEFONO = "telefono";

	/** The Constant FAX. */
	public static final String FAX = "fax";

	/** The Constant EMAIL. */
	public static final String EMAIL = "email";

	/** The Constant IMAGEN. */
	public static final String IMAGEN = "imagen";

	/** The Constant TEMA. */
	public static final String TEMA = "tema";

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
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#save(es.novasoft
	 * .uvtae.business.objects.Organismo)
	 */
	public void save(Organismo transientInstance) throws DAOException {
		LOG.debug("saving Organismo instance");
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
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#delete(es.novasoft
	 * .uvtae.business.objects.Organismo)
	 */
	public void delete(Organismo persistentInstance) throws DAOException {
		LOG.debug("deleting Organismo instance");
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
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findById(java.lang
	 * .Integer)
	 */
	public Organismo findById(Integer id) throws DAOException {
		LOG.debug("getting Organismo instance with id: " + id);
		try {
			Organismo instance = (Organismo) getHibernateTemplate().get(
					"es.novasoft.castellon.vfe.business.objects.Organismo", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByExample(es
	 * .novasoft.uvtae.business.objects.Organismo)
	 */
	public List findByExample(Organismo instance) throws DAOException {
		LOG.debug("finding Organismo instance by example");
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
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByProperty(java
	 * .lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value)
			throws DAOException {
		LOG.debug("finding Organismo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Organismo as model where model."
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
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByNombre(java
	 * .lang.Object)
	 */
	public List findByNombre(Object nombre) throws DAOException {
		return findByProperty(NOMBRE, nombre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByDireccion(
	 * java.lang.Object)
	 */
	public List findByDireccion(Object direccion) throws DAOException {
		return findByProperty(DIRECCION, direccion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByTelefono(java
	 * .lang.Object)
	 */
	public List findByTelefono(Object telefono) throws DAOException {
		return findByProperty(TELEFONO, telefono);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByFax(java.lang
	 * .Object)
	 */
	public List findByFax(Object fax) throws DAOException {
		return findByProperty(FAX, fax);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByEmail(java
	 * .lang.Object)
	 */
	public List findByEmail(Object email) throws DAOException {
		return findByProperty(EMAIL, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByImagen(java
	 * .lang.Object)
	 */
	public List findByImagen(Object imagen) throws DAOException {
		return findByProperty(IMAGEN, imagen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findAll()
	 */
	public List findAll() throws DAOException {
		LOG.debug("finding all Organismo instances");
		try {
			String queryString = "from Organismo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOG.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#merge(es.novasoft
	 * .uvtae.business.objects.Organismo)
	 */
	public Organismo merge(Organismo detachedInstance) throws DAOException {
		LOG.debug("merging Organismo instance");
		try {
			Organismo result = (Organismo) getHibernateTemplate().merge(
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
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#attachDirty(es.novasoft
	 * .uvtae.business.objects.Organismo)
	 */
	public void attachDirty(Organismo instance) throws DAOException {
		LOG.debug("attaching dirty Organismo instance");
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
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#attachClean(es.novasoft
	 * .uvtae.business.objects.Organismo)
	 */
	public void attachClean(Organismo instance) throws DAOException {
		LOG.debug("attaching clean Organismo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOG.debug("attach successful");
		} catch (RuntimeException re) {
			LOG.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.uvtae.business.dao.interfaz.OrganismoDAO#findByCodigo(java
	 * .lang.String)
	 */
	public List findByCodigo(String codigo) {

		LOG.debug(" findByCodigo instance");

		try {
			String queryString = " from Organismo as model where (1=1)";
			if (codigo != null && !codigo.trim().equals("")) {
				queryString += " AND model.codigo='" + codigo + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			LOG.error("findByCodigo failed", e);
			throw e;
		}
	}

}