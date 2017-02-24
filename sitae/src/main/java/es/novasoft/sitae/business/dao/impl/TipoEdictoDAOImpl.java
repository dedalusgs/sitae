package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.TipoEdictoDAO;
import es.novasoft.sitae.business.objects.TipoEdicto;

public class TipoEdictoDAOImpl extends DAOBaseImpl implements TipoEdictoDAO {
	private static final Log	log	   = LogFactory.getLog(CentroProcedenciaDAOImpl.class);
	
	// property constants
	public static final String	NOMBRE	= "nombre";
	
	protected void initDao() {
		// do nothing
	}
	
	public void save(TipoEdicto transientInstance) throws DAOException {
		log.debug("saving TipoEdicto instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void delete(TipoEdicto persistentInstance) throws DAOException {
		log.debug("deleting TipoEdicto instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public TipoEdicto findById(Integer id) throws DAOException {
		log.debug("getting TipoEdicto instance with id: " + id);
		try {
			TipoEdicto instance = (TipoEdicto) getHibernateTemplate().get("es.novasoft.sitae.business.objects.TipoEdicto", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(TipoEdicto instance) throws DAOException {
		log.debug("finding TipoEdicto instance by example");
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
		log.debug("finding TipoEdicto instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TipoEdicto as model where model." + propertyName + "= ?";
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
		log.debug("finding all TipoEdicto instances");
		try {
			String queryString = "from TipoEdicto";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public TipoEdicto merge(TipoEdicto detachedInstance) throws DAOException {
		log.debug("merging TipoEdicto instance");
		try {
			TipoEdicto result = (TipoEdicto) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void attachDirty(TipoEdicto instance) throws DAOException {
		log.debug("attaching dirty TipoEdicto instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(TipoEdicto instance) throws DAOException {
		log.debug("attaching clean TipoEdicto instance");
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
			
			String queryString = " from TipoEdicto as model where (1=1)";
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
			String queryString = " from TipoEdicto as model where (1=1)";
			
			if (nombre != null && !nombre.trim().equals("")) {
				queryString += " AND model.nombre='" + nombre + "' ";
			}
			
			if (cif != null && !cif.trim().equals("")) {
				// queryString += " AND model.organismo.cif='" + cif + "' ";
			}
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
}
