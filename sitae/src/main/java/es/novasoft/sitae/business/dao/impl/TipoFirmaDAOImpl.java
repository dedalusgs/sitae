package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.TipoFirmaDAO;
import es.novasoft.sitae.business.objects.TipoFirma;

public class TipoFirmaDAOImpl extends DAOBaseImpl implements
		TipoFirmaDAO {

	private static final Log log = LogFactory
			.getLog(TipoFirmaDAOImpl.class);

	public static final String NOMBRE = "nombre";

	protected void initDao() {
		// do nothing
	}

	public void save(TipoFirma transientInstance) throws DAOException {
		log.debug("saving TipoFirma instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TipoFirma persistentInstance) throws DAOException {
		log.debug("deleting TipoFirma instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoFirma findById(Integer id) throws DAOException {
		log.debug("getting TipoFirma instance with id: " + id);
		try {
			TipoFirma instance = (TipoFirma) getHibernateTemplate()
					.get("es.novasoft.sitae.business.objects.TipoFirma", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TipoFirma instance) throws DAOException {
		log.debug("finding TipoFirma instance by example");
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
		log.debug("finding TipoFirma instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TipoFirma as model where model."
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
		log.debug("finding all TipoFirma instances");
		try {
			String queryString = "from TipoFirma";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TipoFirma merge(TipoFirma detachedInstance)
			throws DAOException {
		log.debug("merging TipoFirma instance");
		try {
			TipoFirma result = (TipoFirma) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoFirma instance) throws DAOException {
		log.debug("attaching dirty TipoFirma instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoFirma instance) throws DAOException {
		log.debug("attaching clean TipoFirma instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
