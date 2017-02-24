package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.OrganismoExternoDAO;
import es.novasoft.sitae.business.objects.OrganismoExterno;

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

public class OrganismoExternoDAOImpl extends DAOBaseImpl implements
		OrganismoExternoDAO {
	private static final Log log = LogFactory
			.getLog(OrganismoExternoDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	public static final String CIF = "cif";

	public static final String DIRECCION = "direccion";

	public static final String TELEFONO = "telefono";

	public static final String FAX = "fax";

	public static final String EMAIL = "email";

	protected void initDao() {
		// do nothing
	}

	public void save(OrganismoExterno transientInstance) throws DAOException {
		log.debug("saving OrganismoExterno instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrganismoExterno persistentInstance) throws DAOException {
		log.debug("deleting OrganismoExterno instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganismoExterno findById(Integer id) throws DAOException {
		log.debug("getting Organismo instance with id: " + id);
		try {
			OrganismoExterno instance = (OrganismoExterno) getHibernateTemplate()
					.get("es.novasoft.sitae.business.objects.OrganismoExterno",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrganismoExterno instance) throws DAOException {
		log.debug("finding OrganismoExterno instance by example");
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
			String queryString = "from OrganismoExterno as model where model."
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

	public List findAll() throws DAOException {
		log.debug("finding all OrganismoExterno instances");
		try {
			String queryString = "from OrganismoExterno order by nombre";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrganismoExterno merge(OrganismoExterno detachedInstance)
			throws DAOException {
		log.debug("merging Organismo instance");
		try {
			OrganismoExterno result = (OrganismoExterno) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganismoExterno instance) throws DAOException {
		log.debug("attaching dirty OrganismoExterno instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganismoExterno instance) throws DAOException {
		log.debug("attaching clean OrganismoExterno instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}