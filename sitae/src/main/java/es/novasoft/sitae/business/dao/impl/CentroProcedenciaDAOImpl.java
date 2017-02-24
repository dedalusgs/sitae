package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.CentroProcedenciaDAO;
import es.novasoft.sitae.business.objects.CentroProcedencia;

/**
 * A data access object (DAO) providing persistence and search support for
 * CentroProcedencia entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .CentroProcedencia
 * @author MyEclipse Persistence Tools
 */

public class CentroProcedenciaDAOImpl extends DAOBaseImpl implements CentroProcedenciaDAO {
	private static final Log	log	   = LogFactory.getLog(CentroProcedenciaDAOImpl.class);
	
	// property constants
	public static final String	NOMBRE	= "nombre";
	
	protected void initDao() {
		// do nothing
	}
	
	public void save(CentroProcedencia transientInstance) throws DAOException {
		log.debug("saving CentroProcedencia instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void delete(CentroProcedencia persistentInstance) throws DAOException {
		log.debug("deleting CentroProcedencia instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public CentroProcedencia findById(Integer id) throws DAOException {
		log.debug("getting CentroProcedencia instance with id: " + id);
		try {
			CentroProcedencia instance = (CentroProcedencia) getHibernateTemplate().get("es.novasoft.sitae.business.objects.CentroProcedencia", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(CentroProcedencia instance) throws DAOException {
		log.debug("finding CentroProcedencia instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) throws DAOException {
		log.debug("finding CentroProcedencia instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CentroProcedencia as model where model." + propertyName + "= ?";
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
		log.debug("finding all CentroProcedencia instances");
		try {
			String queryString = "from CentroProcedencia order by nombre";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public CentroProcedencia merge(CentroProcedencia detachedInstance) throws DAOException {
		log.debug("merging CentroProcedencia instance");
		try {
			CentroProcedencia result = (CentroProcedencia) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void attachDirty(CentroProcedencia instance) throws DAOException {
		log.debug("attaching dirty CentroProcedencia instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(CentroProcedencia instance) throws DAOException {
		log.debug("attaching clean CentroProcedencia instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findByIdOrg(Integer idOrg) {
		
		log.debug("findByIdOrg instance");
		
		try {
			
			String queryString = " from CentroProcedencia as model where (1=1)";
			// queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	public List findByNombreCif(String nombre, String cif) {
		
		log.debug(" findByNombreCif instance");
		try {
			String queryString = " from CentroProcedencia as model where (1=1)";
			
			if (nombre != null && !nombre.trim().equals("")) {
				queryString += " AND model.nombre='" + nombre + "' ";
			}
			
			// if (cif != null && !cif.trim().equals("")) {
			// queryString += " AND model.organismo.cif='" + cif + "' ";
			// }
			queryString += " order by model.nombre";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
}