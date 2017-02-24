package es.novasoft.sitae.business.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.sitae.business.dao.interfaz.RelacionUsuOrgCentroPerfDAO;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;

/**
 * A data access object (DAO) providing persistence and search support for
 * RelacionUsuOrgCentroPerf entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see .RelacionUsuOrgCentroPerf
 * @author MyEclipse Persistence Tools
 */

public class RelacionUsuOrgCentroPerfDAOImpl extends DAOBaseImpl implements
		RelacionUsuOrgCentroPerfDAO {

	private static final Log log = LogFactory
			.getLog(RelacionUsuOrgCentroPerfDAOImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(RelacionUsuOrgCentroPerf transientInstance) {
		log.debug("saving RelacionUsuOrgCentroPerf instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RelacionUsuOrgCentroPerf persistentInstance) {
		log.debug("deleting RelacionUsuOrgCentroPerf instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelacionUsuOrgCentroPerf findById(Integer id) {
		log.debug("getting RelacionUsuOrgCentroPerf instance with id: " + id);
		try {
			RelacionUsuOrgCentroPerf instance = (RelacionUsuOrgCentroPerf) getHibernateTemplate()
					.get(
							"es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RelacionUsuOrgCentroPerf instance) {
		log.debug("finding RelacionUsuOrgCentroPerf instance by example");
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
		log.debug("finding RelacionUsuOrgCentroPerf instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RelacionUsuOrgCentroPerf as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all RelacionUsuOrgCentroPerf instances");
		try {
			String queryString = "from RelacionUsuOrgCentroPerf";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RelacionUsuOrgCentroPerf merge(
			RelacionUsuOrgCentroPerf detachedInstance) {
		log.debug("merging RelacionUsuOrgCentroPerf instance");
		try {
			RelacionUsuOrgCentroPerf result = (RelacionUsuOrgCentroPerf) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RelacionUsuOrgCentroPerf instance) {
		log.debug("attaching dirty RelacionUsuOrgCentroPerf instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelacionUsuOrgCentroPerf instance) {
		log.debug("attaching clean RelacionUsuOrgCentroPerf instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByOrgUsuPerf(String cif, String dni, String id_pefil) {

		log.debug(" findByOrgUsuPerf instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo='" + cif + "' ";
			}
			if (dni != null && !dni.trim().equals("")) {
				queryString += " AND model.usuario='" + dni + "' ";
			}
			if (id_pefil != null && !id_pefil.trim().equals("")) {
				queryString += " AND model.perfil.idPerfil='" + id_pefil + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

	public List findByUsuPerf(String dni, String id_pefil) {

		log.debug(" findByUsuPerf instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (dni != null && !dni.trim().equals("")) {
				queryString += " AND model.usuario='" + dni + "' ";
			}
			if (id_pefil != null && !id_pefil.trim().equals("")) {
				queryString += " AND model.perfil.idPerfil='" + id_pefil + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("findByUsuPerf failed", e);
			throw e;
		}
	}

	public List findByCentroUsuPerf(String idCentro, String dni, String id_pefil) {

		log.debug(" findByCentroUsuPerf instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (idCentro != null && !idCentro.trim().equals("")) {
				queryString += " AND model.centroProcedencia.idCentro='"
						+ idCentro + "' ";
			}
			if (dni != null && !dni.trim().equals("")) {
				queryString += " AND model.usuario='" + dni + "' ";
			}
			if (id_pefil != null && !id_pefil.trim().equals("")) {
				queryString += " AND model.perfil.idPerfil='" + id_pefil + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

	public List findByCif(String cif) {

		log.debug(" findByCif instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo='" + cif + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

	public List findByPerfil(Integer idPerfil) {

		log.debug(" findByPerfil instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			queryString += " AND model.perfil.idPerfil='" + idPerfil + "' ";
			if (idPerfil == Constantes.ADMIN_LOCAL) {
				queryString += " order by model.organismo";
			}
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

	public List findByUsuario(String dni) {

		log.debug(" findByUsuario instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (dni != null && !dni.trim().equals("")) {
				queryString += " AND model.usuario='" + dni + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}

	public List findByCifDni(String cif, String dni) {

		log.debug(" findByCifDni instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo='" + cif + "' ";
			}
			if (dni != null && !dni.trim().equals("")) {
				queryString += " AND model.usuario='" + dni + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoPerfiles failed", e);
			throw e;
		}
	}

	public List findByCentroPerfil(Integer idCentro, Integer idPerfil) {

		log.debug(" findByCentroPerfil instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			queryString += " AND model.centroProcedencia.idCentro='" + idCentro
					+ "' ";
			queryString += " AND model.perfil.idPerfil='" + idPerfil + "' ";

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoPerfiles failed", e);
			throw e;
		}
	}

	public List findByCentro(Integer idCentro) {

		log.debug(" findByCentro instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			queryString += " AND model.centroProcedencia.idCentro='" + idCentro
					+ "' ";

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoPerfiles failed", e);
			throw e;
		}
	}

	public List findByOrgPerf(String cif, String idPerfil) {

		log.debug(" findByOrgPerf instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo='" + cif + "' ";
			}
			if (idPerfil != null && !idPerfil.trim().equals("")) {
				queryString += " AND model.perfil.idPerfil='" + idPerfil + "' ";
			}

			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("listadoUsuarios failed", e);
			throw e;
		}
	}

	public List findByOrgIncluyendoPerfiles(String cif, List perfiles) {

		log.debug(" findByOrgIncluyendoPerfiles instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo='" + cif + "' ";
			}
			if (!perfiles.isEmpty()) {
				if (perfiles.size() > 1) {
					queryString += " AND (";
					boolean first = true;
					Iterator iterator = perfiles.iterator();
					while (iterator.hasNext()) {
						Perfil perfil = (Perfil) iterator.next();
						if (first == true) {
							queryString += " model.perfil.idPerfil='"
									+ perfil.getIdPerfil().toString() + "' ";
							first = false;
						} else {
							queryString += " OR model.perfil.idPerfil='"
									+ perfil.getIdPerfil().toString() + "' ";
						}
					}
					queryString += ")";
				} else {
					queryString += " AND model.perfil.idPerfil='"
							+ ((Perfil) perfiles.get(0)).getIdPerfil()
									.toString() + "' ";
				}
			}
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("findByOrgIncluyendoPerfiles failed", e);
			throw e;
		}
	}

	public List findByOrgNifIncluyendoPerfiles(String cif, String nif,
			List perfiles) {

		log.debug(" findByOrgIncluyendoPerfiles instance");

		try {
			String queryString = " from RelacionUsuOrgCentroPerf as model where (1=1)";
			if (cif != null && !cif.trim().equals("")) {
				queryString += " AND model.organismo='" + cif + "' ";
			}
			if (nif != null && !nif.trim().equals("")) {
				queryString += " AND model.usuario='" + nif + "' ";
			}
			if (!perfiles.isEmpty()) {
				if (perfiles.size() > 1) {
					queryString += " AND (";
					boolean first = true;
					Iterator iterator = perfiles.iterator();
					while (iterator.hasNext()) {
						Perfil perfil = (Perfil) iterator.next();
						if (first == true) {
							queryString += " model.perfil.idPerfil='"
									+ perfil.getIdPerfil().toString() + "' ";
							first = false;
						} else {
							queryString += " OR model.perfil.idPerfil='"
									+ perfil.getIdPerfil().toString() + "' ";
						}
					}
					queryString += ")";
				} else {
					queryString += " AND model.perfil.idPerfil='"
							+ ((Perfil) perfiles.get(0)).getIdPerfil()
									.toString() + "' ";
				}
			}
			return getHibernateTemplate().find(queryString);

		} catch (RuntimeException e) {
			log.error("findByOrgIncluyendoPerfiles failed", e);
			throw e;
		}
	}

}