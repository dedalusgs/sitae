package es.novasoft.sitae.business.dao.impl;

// default package

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;

import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.dao.interfaz.UsuarioFirmanteDAO;
import es.novasoft.sitae.business.objects.UsuarioFirmante;

/**
 * A data access object (DAO) providing persistence and search support for
 * UsuarioFirmante entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .Usuario
 * @author MyEclipse Persistence Tools
 */

public class UsuarioFirmanteDAOImpl extends DAOBaseImpl implements
		UsuarioFirmanteDAO {
	private static final Log log = LogFactory.getLog(UsuarioDAOImpl.class);

	// property constants
	public static final String NOMBRE = "nombre";

	public static final String APELLIDO1 = "apellido1";

	public static final String APELLIDO2 = "apellido2";

	public static final String CARGO = "cargo";

	public static final String NUM_DOCUMENTO = "numDocumento";

	protected void initDao() {
		// do nothing
	}

	public void save(UsuarioFirmante transientInstance) throws DAOException {
		log.debug("saving UsuarioFirmante instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UsuarioFirmante persistentInstance) throws DAOException {
		log.debug("deleting UsuarioFirmante instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UsuarioFirmante findById(Integer id) throws DAOException {
		log.debug("getting UsuarioFirmante instance with id: " + id);
		try {
			UsuarioFirmante instance = (UsuarioFirmante) getHibernateTemplate()
					.get("es.novasoft.sitae.business.objects.UsuarioFirmante",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UsuarioFirmante instance) throws DAOException {
		log.debug("finding UsuarioFirmante instance by example");
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
		log.debug("finding UsuarioFirmante instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UsuarioFirmante as model where model."
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

	public List findByCargo(Object cargo) throws DAOException {
		return findByProperty(CARGO, cargo);
	}

	public List findByNumeroDocumento(Object numDocumento) throws DAOException {
		return findByProperty(NUM_DOCUMENTO, numDocumento);
	}

	public List findAll() throws DAOException {
		log.debug("finding all UsuarioFirmante instances");
		try {
			String queryString = "from UsuarioFirmante";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UsuarioFirmante merge(UsuarioFirmante detachedInstance)
			throws DAOException {
		log.debug("merging UsuarioFirmante instance");
		try {
			UsuarioFirmante result = (UsuarioFirmante) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UsuarioFirmante instance) throws DAOException {
		log.debug("attaching dirty UsuarioFirmante instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UsuarioFirmante instance) throws DAOException {
		log.debug("attaching clean UsuarioFirmante instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByIdOrg(Integer idOrg) throws DAOException {
		log.debug("findByIdOrg instance");
		try {
			String queryString = " from UsuarioFirmante as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("findByIdOrg failed", e);
			throw e;
		}
	}

	public List findByIdOrgNumeroDocumento(Integer idOrg, String numeroDocumento)
			throws DAOException {
		log.debug("findByIdOrg instance");
		try {
			String queryString = " from UsuarioFirmante as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			queryString += " AND model.numDocumento='" + numeroDocumento + "' ";
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("findByIdOrg failed", e);
			throw e;
		}
	}

	public int findByFilterCont(Integer idOrg, String nombre, String nif)
			throws DAOException {

		log.debug("findByFilterCont Count");
		try {

			String descripcion = null;
			String queryString = findByFilterQuery(idOrg, nombre, nif);
			return getCount("select count(*) " + queryString, nombre, nif);
		} catch (RuntimeException e) {
			log.error("findByFilterCont failed", e);
			throw e;
		}
	}

	public List findByFilter(Integer idOrg, String nombre, String nif,
			final Integer numPag, final Integer tamPag) throws DAOException {

		log.debug(" findByFiltro instance");

		try {
			String queryString = findByFilterQuery(idOrg, nombre, nif);

			if (numPag == null || tamPag == null) {

				final String queryStringParameter = queryString;
				final String nombreParameter = nombre;
				final String nifParameter = nif;

				return getHibernateTemplate().executeFind(
						new HibernateCallback() {

							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session
										.createQuery(queryStringParameter);
								if (nombreParameter != null
										&& !nombreParameter.equals("")) {
									query.setParameter("nombre", "%"
											+ nombreParameter + "%");
								}
								if (nifParameter != null
										&& !nifParameter.equals("")) {
									query.setParameter("nif", "%"
											+ nifParameter + "%");
								}
								return query.list();
							}
						});

			} else {
				return getPaginateList(queryString, numPag, tamPag, null,
						nombre, nif);
			}

		} catch (RuntimeException e) {
			log.error("findByFiltro failed", e);
			throw e;
		}
	}

	private String findByFilterQuery(Integer idOrg, String nombre, String nif) {

		log.debug("findByFilterQuery instance");

		String queryString = " from UsuarioFirmante as model where (1=1)";

		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";

		if (nif != null && !nif.equals("")) {
			queryString += " AND upper(model.numDocumento) like upper(:nif)";
		}

		if (nombre != null && !nombre.equals("")) {
			queryString += " AND upper(model.nombre || ' ' || model.apellido1 || ' ' || model.apellido2) like upper(:nombre)";
		}

		return queryString;
	}

	private final int getCount(String querySql, String datoNombre,
			String datoNif) {
		final String queryString = querySql;
		final String nombre = datoNombre;
		final String nif = datoNif;

		return DataAccessUtils.intResult(getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						if (nombre != null && !nombre.equals("")) {
							query.setParameter("nombre", "%" + nombre + "%");
						}
						if (nif != null && !nif.equals("")) {
							query.setParameter("nif", "%" + nif + "%");
						}
						return query.list();
					}
				}));

	}

	private List getPaginateList(String querySql, final int startIndex,
			final int rowsPerPage, String orderBySql, String datoNombre,
			String datoNif) {
		if (orderBySql != null) {
			querySql += " " + orderBySql;
		}

		final String queryString = querySql;
		final String nombre = datoNombre;
		final String nif = datoNif;

		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				if (nombre != null && !nombre.equals("")) {
					query.setParameter("nombre", "%" + nombre + "%");
				}
				if (nif != null && !nif.equals("")) {
					query.setParameter("nif", "%" + nif + "%");
				}
				query.setMaxResults(rowsPerPage);
				query.setFirstResult((startIndex - 1) * rowsPerPage);
				return query.list();
			}
		});

	}

}