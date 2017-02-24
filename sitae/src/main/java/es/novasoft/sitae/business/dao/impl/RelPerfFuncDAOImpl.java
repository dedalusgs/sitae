package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.sitae.business.dao.interfaz.RelPerfFuncDAO;
import es.novasoft.sitae.business.objects.RelPerfFunc;

public class RelPerfFuncDAOImpl extends DAOBaseImpl implements RelPerfFuncDAO {

	private static final Log log = LogFactory.getLog(RelPerfFuncDAOImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(RelPerfFunc transientInstance) {
		log.debug("saving RelPerfFunc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RelPerfFunc persistentInstance) {
		log.debug("deleting RelPerfFunc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelPerfFunc findById(Integer id) {
		log.debug("getting RelPerfFunc instance with id: " + id);
		try {
			RelPerfFunc instance = (RelPerfFunc) getHibernateTemplate().get(
					"es.novasoft.sitae.business.objects.RelPerfFunc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RelPerfFunc instance) {
		log.debug("finding RelPerfFunc instance by example");
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

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RelPerfFunc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RelPerfFunc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all RelPerfFunc instances");
		try {
			String queryString = "from RelPerfFunc order by idRelacion";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RelPerfFunc merge(RelPerfFunc detachedInstance) {
		log.debug("merging RelPerfFunc instance");
		try {
			RelPerfFunc result = (RelPerfFunc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RelPerfFunc instance) {
		log.debug("attaching dirty RelPerfFunc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelPerfFunc instance) {
		log.debug("attaching clean RelPerfFunc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByPerfil(Integer idPerfil) {

		log.debug(" findByPerfil instance");

		try {
			String queryString = " from RelPerfFunc as model where (1=1)";
			queryString += " AND model.perfil.idPerfil='" + idPerfil + "' ";

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

	public List findByIdFuncionalidad(Integer idFuncionalidad) {

		log.debug(" findByFuncionalidad instance");

		try {
			String queryString = " from RelPerfFunc as model where (1=1)";
			queryString += " AND model.funcionalidad.idFuncionalidad='"
					+ idFuncionalidad + "' ";

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

}
