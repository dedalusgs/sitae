package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.OrganismoDAO;
import es.novasoft.sitae.business.objects.Organismo;

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
	private static final Log log = LogFactory.getLog(OrganismoDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	public static final String CIF = "cif";

	public static final String DIRECCION = "direccion";

	public static final String TELEFONO = "telefono";

	public static final String FAX = "fax";

	public static final String EMAIL = "email";

	public static final String IMAGEN = "imagen";

	public static final String TEMA = "tema";

	protected void initDao() {
		// do nothing
	}

	public void save(Organismo transientInstance) throws DAOException {
		log.debug("saving Organismo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Organismo persistentInstance) throws DAOException {
		log.debug("deleting Organismo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Organismo findById(Integer id) throws DAOException {
		log.debug("getting Organismo instance with id: " + id);
		try {
			Organismo instance = (Organismo) getHibernateTemplate().get(
					"es.novasoft.sitae.business.objects.Organismo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Organismo instance) throws DAOException {
		log.debug("finding Organismo instance by example");
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
		log.debug("finding Organismo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Organismo as model where model."
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

	public List findByCif(Object cif) throws DAOException {
		return findByProperty(CIF, cif);
	}

	public List findByDireccion(Object direccion) throws DAOException {
		return findByProperty(DIRECCION, direccion);
	}

	public List findByTelefono(Object telefono) throws DAOException {
		return findByProperty(TELEFONO, telefono);
	}

	public List findByFax(Object fax) throws DAOException {
		return findByProperty(FAX, fax);
	}

	public List findByEmail(Object email) throws DAOException {
		return findByProperty(EMAIL, email);
	}

	public List findByImagen(Object imagen) throws DAOException {
		return findByProperty(IMAGEN, imagen);
	}

	public List findAll() throws DAOException {
		log.debug("finding all Organismo instances");
		try {
			String queryString = "from Organismo as model order by model.nombre asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Organismo merge(Organismo detachedInstance) throws DAOException {
		log.debug("merging Organismo instance");
		try {
			Organismo result = (Organismo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Organismo instance) throws DAOException {
		log.debug("attaching dirty Organismo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Organismo instance) throws DAOException {
		log.debug("attaching clean Organismo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByCodigo(String codigo) {

		log.debug(" findByCodigo instance");

		try {
			String queryString = " from Organismo as model where (1=1)";
			if (codigo != null && !codigo.trim().equals("")) {
				queryString += " AND model.codigo='" + codigo + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("findByCodigo failed", e);
			throw e;
		}
	}

}