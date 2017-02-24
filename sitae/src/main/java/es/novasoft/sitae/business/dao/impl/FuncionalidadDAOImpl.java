package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.FuncionalidadDAO;
import es.novasoft.sitae.business.objects.Funcionalidad;

public class FuncionalidadDAOImpl extends DAOBaseImpl implements
		FuncionalidadDAO {

	private static final Log log = LogFactory
			.getLog(FuncionalidadDAOImpl.class);

	public static final String NOMBRE = "nombre";

	protected void initDao() {
		// do nothing
	}

	public void save(Funcionalidad transientInstance) throws DAOException {
		log.debug("saving Funcionalidad instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Funcionalidad persistentInstance) throws DAOException {
		log.debug("deleting Funcionalidad instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Funcionalidad findById(Integer id) throws DAOException {
		log.debug("getting Funcionalidad instance with id: " + id);
		try {
			Funcionalidad instance = (Funcionalidad) getHibernateTemplate()
					.get("es.novasoft.sitae.business.objects.Funcionalidad", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Funcionalidad instance) throws DAOException {
		log.debug("finding Funcionalidad instance by example");
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
		log.debug("finding Funcionalidad instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Funcionalidad as model where model."
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
		log.debug("finding all Funcionalidad instances");
		try {
			String queryString = "from Funcionalidad";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Funcionalidad merge(Funcionalidad detachedInstance)
			throws DAOException {
		log.debug("merging Funcionalidad instance");
		try {
			Funcionalidad result = (Funcionalidad) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Funcionalidad instance) throws DAOException {
		log.debug("attaching dirty Funcionalidad instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Funcionalidad instance) throws DAOException {
		log.debug("attaching clean Funcionalidad instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
