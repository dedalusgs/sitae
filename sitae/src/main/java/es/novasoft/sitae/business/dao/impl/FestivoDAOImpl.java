package es.novasoft.sitae.business.dao.impl;

// default package

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.FestivoDAO;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;

/**
 *
 */

public class FestivoDAOImpl extends DAOBaseImpl implements
		FestivoDAO {
	private static final Log log = LogFactory
			.getLog(FestivoDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";
	public static final String FECHA = "fecha";
	

	protected void initDao() {
		// do nothing
	}

	public void save(Festivo transientInstance) throws DAOException {
		log.debug("saving Festivo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Festivo persistentInstance)
			throws DAOException {
		log.debug("deleting Festivo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Festivo findById(Integer id) throws DAOException {
		log.debug("getting Festivo instance with id: " + id);
		try {
			Festivo instance = (Festivo) getHibernateTemplate()
					.get(
							"es.novasoft.sitae.business.objects.Festivo",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Festivo instance) throws DAOException {
		log.debug("finding Festivo instance by example");
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
		log.debug("finding Festivo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Festivo as model where model."
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
	public List findByFecha(Object nombre) throws DAOException {
		return findByProperty(FECHA, nombre);
	}

	public List findAll() throws DAOException {
		log.debug("finding all Festivo instances");
		try {
			String queryString = "from Festivo order by fecha";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Festivo merge(Festivo detachedInstance)
			throws DAOException {
		log.debug("merging Festivo instance");
		try {
			Festivo result = (Festivo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Festivo instance) throws DAOException {
		log.debug("attaching dirty Festivo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Festivo instance) throws DAOException {
		log.debug("attaching clean Festivo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
	
	public List findByIdOrgAnio(Integer idOrg, Integer anio) {

		log.debug("findByIdOrgAnio instance");

		try {

			String queryString = " from Festivo as model where (1=1)";
			queryString += " AND model.organismo.idOrg=" + idOrg + " ";
            queryString += " AND year(model.fecha)="+anio+" ";
            queryString += " order by model.fecha asc";
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	public List findByOrgAnio(Organismo org, Integer anio) {
		
		if (org!=null){
			return  findByIdOrgAnio(org.getIdOrg(), anio);
		}else{
			return  findByIdOrgAnio(null, anio);
		}
		
	}
	
	public List findByDate(Integer idOrg, Date fecha){
		log.debug("findByIdOrgAnio instance");

		try {

			String queryString = " from Festivo as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
            queryString += " AND model.fecha='"+fecha+"' ";
            queryString += " order by model.fecha asc";
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	

	public List findByNombreCif(String nombre, String cif) {

		log.debug(" findByNombreCif instance");
		try {
			String queryString = " from Festivo as model where (1=1)";

			if (nombre != null && !nombre.trim().equals("")) {
				queryString += " AND model.nombre='" + nombre + "' ";
			}

			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo.cif='" + cif + "' ";
			}
			queryString+=" order by model.nombre";
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
}