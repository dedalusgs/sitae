package es.novasoft.sitae.business.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.InteresadoDAO;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;

public class InteresadoDAOImpl extends DAOBaseImpl implements InteresadoDAO {
	private static final Log log = LogFactory.getLog(CentroProcedenciaDAOImpl.class);

	// property constants
	public static final String EMAIL = "email";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(Interesado transientInstance) throws DAOException {
		log.debug("saving Interesado instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Interesado persistentInstance) throws DAOException {
		log.debug("deleting Interesado instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Interesado findById(Integer id) throws DAOException {
		log.debug("getting Interesado instance with id: " + id);
		try {
			Interesado instance = (Interesado) getHibernateTemplate().get("es.novasoft.sitae.business.objects.Interesado", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Interesado instance) throws DAOException {
		log.debug("finding Interesado instance by example");
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
		log.debug("finding Interesado instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Interesado as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEmail(Object email) throws DAOException {
		return findByProperty(EMAIL, email);
	}

	public Interesado findByEmailOrganismoActivo(String email, Organismo org, Boolean activo) throws DAOException {
		log.debug("finding Interesado instance with email: " + email + ", organismo: " + org.getNombre() + ", activo: " + activo);
		String queryString = "from Interesado as model where model.email = '" + email + "' AND model.organismo.idOrg = " + org.getIdOrg();
		if (activo != null) {
			if (activo) {
				queryString += " AND model.activo = 'S' ";
			} else {
				queryString += " AND model.activo = 'N' ";
			}
		}
		List<Interesado> resultado = getHibernateTemplate().find(queryString);
		if (resultado.size() > 0) {
			return resultado.get(0);
		} else {
			return null;
		}

	}

	public List findAll() throws DAOException {
		log.debug("finding all Interesado instances");
		try {
			String queryString = "from Interesado";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Interesado merge(Interesado detachedInstance) throws DAOException {
		log.debug("merging Interesado instance");
		try {
			Interesado result = (Interesado) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Interesado instance) throws DAOException {
		log.debug("attaching dirty Interesado instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Interesado instance) throws DAOException {
		log.debug("attaching clean Interesado instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findAllByOrg(Organismo org, Boolean activo) throws DAOException {
		log.debug("finding Interesado instance with  organismo: " + org.getNombre() + ", activo: " + activo);
		String queryString = "from Interesado as model where  model.organismo.idOrg = " + org.getIdOrg();
		if (activo != null) {
			if (activo) {
				queryString += " AND model.activo = 'S' ";
			} else {
				queryString += " AND model.activo = 'N' ";
			}
		}
		List<Interesado> resultado = getHibernateTemplate().find(queryString);
		return resultado;
	}

}
