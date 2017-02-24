package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.UsuarioDAO;
import es.novasoft.sitae.business.objects.Usuario;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuario entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .Usuario
 * @author MyEclipse Persistence Tools
 */

public class UsuarioDAOImpl extends DAOBaseImpl implements UsuarioDAO {
	private static final Log log = LogFactory.getLog(UsuarioDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	public static final String APELLIDO1 = "apellido1";

	public static final String APELLIDO2 = "apellido2";

	public static final String TELEFONO = "telefono";

	public static final String MOVIL = "movil";

	public static final String EMAIL = "email";

	public static final String NUM_DOCUMENTO = "numDocumento";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuario transientInstance) throws DAOException {
		log.debug("saving Usuario instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuario persistentInstance) throws DAOException {
		log.debug("deleting Usuario instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuario findById(Integer id) throws DAOException {
		log.debug("getting Usuario instance with id: " + id);
		try {
			Usuario instance = (Usuario) getHibernateTemplate().get(
					"es.novasoft.sitae.business.objects.Usuario", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Usuario instance) throws DAOException {
		log.debug("finding Usuario instance by example");
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
		log.debug("finding Usuario instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Usuario as model where model."
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

	public List findByApellido1(Object apellido1) throws DAOException {
		return findByProperty(APELLIDO1, apellido1);
	}

	public List findByApellido2(Object apellido2) throws DAOException {
		return findByProperty(APELLIDO2, apellido2);
	}

	public List findByTelefono(Object telefono) throws DAOException {
		return findByProperty(TELEFONO, telefono);
	}

	public List findByMovil(Object movil) throws DAOException {
		return findByProperty(MOVIL, movil);
	}

	public List findByNumeroDocumento(Object numDocumento) throws DAOException {
		return findByProperty(NUM_DOCUMENTO, numDocumento);
	}

	public List findByEmail(Object email) throws DAOException {
		return findByProperty(EMAIL, email);
	}

	public List findAll() throws DAOException {
		log.debug("finding all Usuario instances");
		try {
			String queryString = "from Usuario";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuario merge(Usuario detachedInstance) throws DAOException {
		log.debug("merging Usuario instance");
		try {
			Usuario result = (Usuario) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuario instance) throws DAOException {
		log.debug("attaching dirty Usuario instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuario instance) throws DAOException {
		log.debug("attaching clean Usuario instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * public static UsuarioDAOImpl getFromApplicationContext(ApplicationContext
	 * ctx) { return (UsuarioDAOImpl) ctx.getBean("UsuarioDAOImpl"); }
	 */
}