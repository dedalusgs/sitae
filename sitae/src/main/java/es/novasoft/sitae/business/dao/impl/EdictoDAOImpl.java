package es.novasoft.sitae.business.dao.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.dao.spring.DAOBaseImpl;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.dao.interfaz.EdictoDAO;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;

public class EdictoDAOImpl extends DAOBaseImpl implements EdictoDAO {
	private static final Log	log	= LogFactory.getLog(CentroProcedenciaDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#save(es.novasoft.sitae.
	 * business.objects.Edicto)
	 */
	public void save(Edicto transientInstance) throws DAOException {
		log.debug("saving Edicto instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#delete(es.novasoft.sitae
	 * .business.objects.Edicto)
	 */
	public void delete(Edicto persistentInstance) throws DAOException {
		log.debug("deleting Edicto instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findById(java.lang.Integer)
	 */
	public Edicto findById(Integer id) throws DAOException {
		log.debug("getting Edicto instance with id: " + id);
		try {
			Edicto instance = (Edicto) getHibernateTemplate().get("es.novasoft.sitae.business.objects.Edicto", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByExample(es.novasoft
	 * .sitae.business.objects.Edicto)
	 */
	public List findByExample(Edicto instance) throws DAOException {
		log.debug("finding Edicto instance by example");
		try {
			Example example = Example.create(instance);
			example.enableLike(MatchMode.ANYWHERE); // this is it.
			example.ignoreCase();
			example.excludeProperty("pdfAdjunto");
			example.excludeProperty("diligencia");
			
			DetachedCriteria c = DetachedCriteria.forClass(Edicto.class).add(example);
			
			List results = getHibernateTemplate().findByCriteria(c);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByProperty(java.lang
	 * .String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) throws DAOException {
		log.debug("finding Edicto instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Edicto as model where model." + propertyName + "= ?";
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByNombre(java.lang.
	 * Object)
	 */
	public List findByNombre(Object nombre) throws DAOException {
		return findByProperty(NOMBRE, nombre);
	}
	
	public List findByIdOrganismoExterno(Integer idOrganismoExterno) throws DAOException {
		log.debug("finding Edicto instance with idOrganismoExterno: " + idOrganismoExterno);
		try {
			String queryString = "from Edicto as model where model.organismoExterno.idOrg= " + idOrganismoExterno;
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see es.novasoft.sitae.business.dao.impl.EdictoDAO#findAll()
	 */
	public List findAll() throws DAOException {
		log.debug("finding all Edicto instances");
		try {
			String queryString = "from Edicto";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#merge(es.novasoft.sitae
	 * .business.objects.Edicto)
	 */
	public Edicto merge(Edicto detachedInstance) throws DAOException {
		log.debug("merging CentroProcedencia instance");
		try {
			Edicto result = (Edicto) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#attachDirty(es.novasoft
	 * .sitae.business.objects.Edicto)
	 */
	public void attachDirty(Edicto instance) throws DAOException {
		log.debug("attaching dirty Edicto instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#attachClean(es.novasoft
	 * .sitae.business.objects.Edicto)
	 */
	public void attachClean(Edicto instance) throws DAOException {
		log.debug("attaching clean Edicto instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByCentroYEstadosExPRYPubORed(java.lang.Integer, java.lang.Integer)
	 */
	public List findByCentroYEstadosExPRYPubORed(Integer idCentro, Integer idUsuario) {
		
		log.debug("findByCentroYEstadosExPRYPubORed instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			
			if (idUsuario != -1) {
				queryString += " AND ( model.publicador.idUsuario='" + idUsuario + "' ";
				queryString += " OR model.redactor.idUsuario='" + idUsuario + "' )";
			}
			if (idCentro != -1) {
				queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			}
			
			queryString += " AND ( model.estado.idEstado='" + Constantes.INICIADO + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.PENDIENTE_VALIDACION + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.PENDIENTE_FIRMA + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.REVISION + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.RECHAZADO_FIRMA + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.RECHAZADO + "' )";
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByCentroYEstadosExPRYPubORed failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByCentroUsuarioPerfilYEstadosExPR(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer)
	 */
	public List findByCentroUsuarioPerfilYEstadosExPR(Integer idCentro, Integer idUsuario, Integer idPerfil) {
		
		log.debug("findByCentroUsuarioPerfilYEstadosExPR instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			if (idUsuario != -1) {
				if (idPerfil.intValue() == Constantes.REDACTOR) {
					queryString += " AND model.redactor.idUsuario='" + idUsuario + "'";
				}
				if (idPerfil.intValue() == Constantes.PUBLICADOR) {
					queryString += " AND model.publicador.idUsuario='" + idUsuario + "'";
				}
				
			}
			if (idCentro != -1) {
				queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			}
			
			queryString += " AND ( model.estado.idEstado='" + Constantes.INICIADO + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.PENDIENTE_VALIDACION + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.PENDIENTE_FIRMA + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.REVISION + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.RECHAZADO_FIRMA + "' ";
			queryString += " OR model.estado.idEstado='" + Constantes.RECHAZADO + "' )";
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByCentroUsuarioPerfilYEstadosExPR failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoRedactorSinEstadoHistorico(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor) {
		
		log.debug("findByOrganismoRedactor instance");
		
		try {
			
			String queryString = findByOrganismoRedactorSinEstadoHistoricoQuery(idOrg, idRedactor);
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoRedactorSinEstadoHistorico(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor, Integer numPag, Integer tamPag) {
		
		log.debug("findByOrganismoRedactor instance");
		
		try {
			
			String queryString = findByOrganismoRedactorSinEstadoHistoricoQuery(idOrg, idRedactor);
			
			if (numPag == null || tamPag == null) {
				return getHibernateTemplate().find(queryString);
			} else {
				
				return getPaginateList(queryString, numPag, tamPag, null);
			}
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	private String findByOrganismoRedactorSinEstadoHistoricoQuery(Integer idOrg, Integer idRedactor) {
		String queryString = " from Edicto as model where (1=1)";
		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
		queryString += " AND model.redactor.idUsuario='" + idRedactor + "' ";
		queryString += " AND model.estado.idEstado<>'" + Constantes.RETIRADO + "'";
		queryString += " order by model.fechaRedaccion desc";
		return queryString;
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoRedactorSinEstadoHistoricoCount(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public int findByOrganismoRedactorSinEstadoHistoricoCount(Integer idOrg, Integer idRedactor) {
		
		log.debug("findByOrganismoRedactor Count");
		
		try {
			
			String queryString = findByOrganismoRedactorSinEstadoHistoricoQuery(idOrg, idRedactor);
			
			return getCount("select count(*) " + queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoRedactorSinPublicar(java.lang.Integer, java.lang.Integer)
	 */
	public List findByOrganismoRedactorSinPublicar(Integer idOrg, Integer idRedactor) {
		
		log.debug("findByOrganismoRedactorSinPublicar instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " ANorganismo.ganismo.idOrg='" + idOrg + "' ";
			queryString += " AND model.redactor.idUsuario='" + idRedactor + "' ";
			queryString += " AND (model.estado.idEstado<>'" + Constantes.RETIRADO + "'";
			queryString += " OR model.estado.idEstado<>'" + Constantes.PUBLICADO + "')";
			queryString += " order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoRedactorSinPublicar failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByOrganismoRedactor
	 * (java.lang.Integer, java.lang.Integer)
	 */
	public List findByOrganismoRedactor(Integer idOrg, Integer idRedactor) {
		
		log.debug("findByOrganismoRedactor instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			queryString += " AND model.redactor.idUsuario='" + idRedactor + "' ";
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByOrganismoPublicador
	 * (java.lang.Integer, java.lang.Integer)
	 */
	public List findByOrganismoPublicador(Integer idOrg, Integer idPublicador) {
		
		log.debug("findByOrganismoRedactor instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			queryString += " AND model.publicador.idUsuario='" + idPublicador + "' ";
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	public List findByOrganismo(Integer idOrg) {
		
		log.debug("findByOrganismoRedactor instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByCentroPublicadorSinPublicar(java.lang.Integer, java.lang.Integer)
	 */
	public List findByCentroPublicadorSinPublicar(Integer idCentro, Integer idPublicador) {
		
		log.debug("findByOrganismoRedactor instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			queryString += " AND model.publicador.idUsuario='" + idPublicador + "' ";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	/* Cambiado por paginacion */
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia
	 * (java.lang.Integer, java.util.List)
	 */
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Organismo organismo) {
		
		log.debug("findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia instance");
		
		try {
			String queryString = " from Edicto as model where (1=1)";
			if (centrosProcedencia != null) {
				if (centrosProcedencia.size() > 1) {
					Iterator it = centrosProcedencia.iterator();
					queryString += "AND ( ";
					boolean first = true;
					while (it.hasNext()) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
						if (first == true) {
							queryString += " model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
							first = false;
						} else {
							queryString += " OR model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
						}
						
					}
					queryString += " ) ";
				} else {
					if (centrosProcedencia.size() == 1) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) centrosProcedencia.get(0);
						queryString += " AND model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
					} else {
						queryString += " AND model.centro.idCentro='-1'";
					}
					
				}
			} else if (organismo != null) {
				queryString += "AND model.organismo.idOrg='" + organismo.getIdOrg() + "'";
			}
			
			queryString += " AND model.publicador.idUsuario='" + idPublicador + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RETIRADO + "'";
			queryString += " AND model.estado.idEstado<>'" + Constantes.INICIADO + "'";
			queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_VALIDACION + "'";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO + "'";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO_FIRMA + "'";
			queryString += " order by model.fechaPublicacion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia failed", e);
			throw e;
		}
	}
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Integer numPag, Integer tamPag,
	        Organismo organismo) {
		
		log.debug(" findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia instance");
		
		try {
			String queryString = findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaQuery(idPublicador, centrosProcedencia, organismo);
			
			if (numPag == null || tamPag == null) {
				return getHibernateTemplate().find(queryString);
			} else {
				
				return getPaginateList(queryString, numPag, tamPag, null);
			}
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia failed", e);
			throw e;
		}
		
	}
	
	public int findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(Integer idPublicador, List centrosProcedencia, Organismo organismo) {
		
		log.debug(" findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont instance");
		
		try {
			String queryString = findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaQuery(idPublicador, centrosProcedencia, organismo);
			queryString = "select count(*) " + queryString;
			return getCount(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont failed", e);
			throw e;
		}
	}
	
	private String findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaQuery(Integer idPublicador, List centrosProcedencia, Organismo organismo) {
		log.debug("findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia instance");
		
		String queryString = " from Edicto as model where (1=1)";
		
		if (centrosProcedencia != null) {
			if (centrosProcedencia.size() > 1) {
				Iterator it = centrosProcedencia.iterator();
				queryString += "AND ( ";
				boolean first = true;
				while (it.hasNext()) {
					CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
					if (first == true) {
						queryString += " model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
						first = false;
					} else {
						queryString += " OR model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
					}
					
				}
				queryString += " ) ";
			} else {
				if (centrosProcedencia.size() == 1) {
					CentroProcedencia centroProcedencia = (CentroProcedencia) centrosProcedencia.get(0);
					queryString += " AND model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
				} else {
					queryString += " AND model.centro.idCentro='-1'";
				}
				
			}
			queryString += " AND model.publicador.idUsuario='" + idPublicador + "' ";
		} else if (organismo != null) {
			queryString += "AND model.organismo.idOrg='" + organismo.getIdOrg() + "'";
		}
		
		queryString += " AND model.estado.idEstado<>'" + Constantes.RETIRADO + "'";
		queryString += " AND model.estado.idEstado<>'" + Constantes.INICIADO + "'";
		queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_VALIDACION + "'";
		queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_FIRMA + "'";
		queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO_FIRMA + "'";
		queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO + "'";
		queryString += " order by model.estado.idEstado asc, model.fechaPublicacion desc";
		return queryString;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByOrganismoEstado(java
	 * .lang.Integer, java.lang.Integer)
	 */
	public List findByOrganismoEstado(Integer idOrg, Integer idEstado) {
		
		log.debug("findByOrganismoEstado instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			queryString += " AND model.estado.idEstado='" + idEstado + "' ";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	public int findByOrganismoEstadoOrderFechaPublicacionCount(Integer idOrg, Integer idEstado, Integer diasCaducidad) {
		log.debug("findByOrganismoEstadoOrderFechaPublicacionCount instance");
		try {
			String queryString = findByOrganismoEstadoOrderFechaPublicacionQuery(idOrg, idEstado);
			queryString = "select count(*) " + queryString;
			return getCountNum(queryString, null, null, null, null, diasCaducidad);
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoEstadoOrderFechaPublicacionCount failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoEstadoOrderFechaPublicacion(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List findByOrganismoEstadoOrderFechaPublicacion(Integer idOrg, Integer idEstado, Integer numPag, Integer tamPag, Integer diasCaducidad) {
		
		log.debug("findByOrganismoEstadoOrderFechaPublicacion instance");
		
		try {
			
			String queryString = findByOrganismoEstadoOrderFechaPublicacionQuery(idOrg, idEstado);
			
			if (numPag == null || tamPag == null) {
				return getHibernateTemplate().find(queryString);
			} else {
				
				return getPaginateListNum(queryString, numPag, tamPag, null, null, null, null, null, diasCaducidad);
			}
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoEstadoOrderFechaPublicacion failed", e);
			throw e;
		}
	}
	
	private String findByOrganismoEstadoOrderFechaPublicacionQuery(Integer idOrg, Integer idEstado) {
		String queryString = " from Edicto as model where (1=1)";
		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
		queryString += " AND model.estado.idEstado='" + idEstado + "'";
		queryString += " AND model.fechaPublicacion >= :fechaMinima";
		queryString += " order by model.fechaPublicacion desc";
		
		return queryString;
	}
	
	public int findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(Integer idOrg, Integer idEstado, Integer diasCaducidad, List<Integer> listaRelacionados) {
		log.debug("findByOrganismoEstadoOrderFechaPublicacionCount instance");
		try {
			String queryString = findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosQuery(idOrg, idEstado, listaRelacionados);
			queryString = "select count(*) " + queryString;
			return getCountNum(queryString, null, null, null, null, diasCaducidad);
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoEstadoOrderFechaPublicacionCount failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByOrganismoEstadoOrderFechaPublicacion(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(Integer idOrg, Integer idEstado, Integer numPag, Integer tamPag, Integer diasCaducidad,
	        List<Integer> listaRelacionados) {
		
		log.debug("findByOrganismoEstadoOrderFechaPublicacion instance");
		
		try {
			
			String queryString = findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosQuery(idOrg, idEstado, listaRelacionados);
			
			if (numPag == null || tamPag == null) {
				return getHibernateTemplate().find(queryString);
			} else {
				
				return getPaginateListNum(queryString, numPag, tamPag, null, null, null, null, null, diasCaducidad);
			}
			
		} catch (RuntimeException e) {
			log.error("findByOrganismoEstadoOrderFechaPublicacion failed", e);
			throw e;
		}
	}
	
	private String findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosQuery(Integer idOrg, Integer idEstado, List<Integer> listaRelacionados) {
		String queryString = " from Edicto as model where (1=1)";
		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
		queryString += " AND model.estado.idEstado='" + idEstado + "'";
		for (int idEdicto : listaRelacionados) {
			queryString += " AND model.idEdicto != " + idEdicto;
		}
		queryString += " AND model.fechaPublicacion >= :fechaMinima";
		queryString += " order by model.fechaPublicacion desc";
		
		return queryString;
	}
	
	public int findByFiltroPublicoCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer diasCaducidad) {
		
		log.debug(" findByFiltroPublicoCount instance");
		try {
			String queryString = findByFiltroPublicoQuery(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado, titulo,
			        descripcion, lenguaje, diasCaducidad);
			
			queryString = "select count(*) " + queryString;
			return getCountNum(queryString, titulo, descripcion, numExp, null, diasCaducidad);
			
		} catch (RuntimeException e) {
			log.error("findByFiltroPublicoCount failed", e);
			throw e;
		}
	}
	
	public List findByFiltroPublicoSinRelacionados(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer numPag, Integer tamPag, Integer diasCaducidad,
	        List<Integer> listaRelacionados) {
		
		log.debug(" findByFiltroPublico instance");
		
		try {
			String queryString = findByFiltroPublicoSinRelacionadosQuery(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin,
			        idEstado, titulo, descripcion, lenguaje, diasCaducidad, listaRelacionados);
			
			if (numPag == null || tamPag == null) {
				
				final String queryStringParameter = queryString;
				final String tituloParameter = titulo;
				final String descripcionParameter = descripcion;
				final String numExpParameter = numExp;
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR, -diasCaducidad);
				final Date fechaMinima = cal.getTime();
				
				return getHibernateTemplate().executeFind(new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(queryStringParameter);
						if (tituloParameter != null && !tituloParameter.equals("")) {
							query.setParameter("titulo", "%" + tituloParameter + "%");
						}
						if (descripcionParameter != null && !descripcionParameter.equals("")) {
							query.setParameter("descripcion", "%" + descripcionParameter + "%");
						}
						if (numExpParameter != null && !numExpParameter.equals("")) {
							query.setParameter("numExp", "%" + numExpParameter + "%");
						}
						if (fechaMinima != null) {
							query.setParameter("fechaMinima", fechaMinima);
						}
						return query.list();
					}
				});
				
			} else {
				return getPaginateListNum(queryString, numPag, tamPag, null, titulo, descripcion, numExp, null, diasCaducidad);
			}
			
		} catch (RuntimeException e) {
			log.error("findByFiltroPublico failed", e);
			throw e;
		}
	}
	
	public int findByFiltroPublicoSinRelacionadosCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer diasCaducidad,
	        List<Integer> listaRelacionados) {
		
		log.debug(" findByFiltroPublicoCount instance");
		try {
			String queryString = findByFiltroPublicoSinRelacionadosQuery(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin,
			        idEstado, titulo, descripcion, lenguaje, diasCaducidad, listaRelacionados);
			
			queryString = "select count(*) " + queryString;
			return getCountNum(queryString, titulo, descripcion, numExp, null, diasCaducidad);
			
		} catch (RuntimeException e) {
			log.error("findByFiltroPublicoCount failed", e);
			throw e;
		}
	}
	
	public List findByFiltroPublico(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer numPag, Integer tamPag, Integer diasCaducidad) {
		
		log.debug(" findByFiltroPublico instance");
		
		try {
			String queryString = findByFiltroPublicoQuery(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado, titulo,
			        descripcion, lenguaje, diasCaducidad);
			
			if (numPag == null || tamPag == null) {
				
				final String queryStringParameter = queryString;
				final String tituloParameter = titulo;
				final String descripcionParameter = descripcion;
				final String numExpParameter = numExp;
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR, -diasCaducidad);
				final Date fechaMinima = cal.getTime();
				
				return getHibernateTemplate().executeFind(new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(queryStringParameter);
						if (tituloParameter != null && !tituloParameter.equals("")) {
							query.setParameter("titulo", "%" + tituloParameter + "%");
						}
						if (descripcionParameter != null && !descripcionParameter.equals("")) {
							query.setParameter("descripcion", "%" + descripcionParameter + "%");
						}
						if (numExpParameter != null && !numExpParameter.equals("")) {
							query.setParameter("numExp", "%" + numExpParameter + "%");
						}
						if (fechaMinima != null) {
							query.setParameter("fechaMinima", fechaMinima);
						}
						return query.list();
					}
				});
				
			} else {
				return getPaginateListNum(queryString, numPag, tamPag, null, titulo, descripcion, numExp, null, diasCaducidad);
			}
			
		} catch (RuntimeException e) {
			log.error("findByFiltroPublico failed", e);
			throw e;
		}
	}
	
	private final int getCount(String querySql, String datoTitulo, String datoDescripcion) {
		final String queryString = querySql;
		final String titulo = datoTitulo;
		final String descripcion = datoDescripcion;
		return DataAccessUtils.intResult(getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				if (titulo != null && !titulo.equals("")) {
					query.setParameter("titulo", "%" + titulo + "%");
				}
				if (descripcion != null && !descripcion.equals("")) {
					query.setParameter("descripcion", "%" + descripcion + "%");
				}
				return query.list();
			}
		}
		
		));
		
	}
	
	private final int getCountNum(String querySql, String datoTitulo, String datoDescripcion, String datoNumExp, String datoCodEdicto, Integer datoDiasCaducidad) {
		final String queryString = querySql;
		final String titulo = datoTitulo;
		final String descripcion = datoDescripcion;
		final String numExp = datoNumExp;
		final String codEdicto = datoCodEdicto;
		Calendar cal = Calendar.getInstance();
		Date fechaMin = null;
		if (datoDiasCaducidad != null) {
			cal.add(Calendar.DAY_OF_YEAR, -datoDiasCaducidad);
			fechaMin = cal.getTime();
		}
		final Date fechaMinima = fechaMin;
		return DataAccessUtils.intResult(getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				if (titulo != null && !titulo.equals("")) {
					query.setParameter("titulo", "%" + titulo + "%");
				}
				if (descripcion != null && !descripcion.equals("")) {
					query.setParameter("descripcion", "%" + descripcion + "%");
				}
				if (numExp != null && !numExp.equals("")) {
					query.setParameter("numExp", "%" + numExp + "%");
				}
				if (codEdicto != null && !codEdicto.equals("")) {
					query.setParameter("codEdicto", "%" + codEdicto + "%");
				}
				if (fechaMinima != null) {
					query.setParameter("fechaMinima", fechaMinima);
				}
				return query.list();
			}
		}
		
		));
		
	}
	
	private List getPaginateList(String querySql, final int startIndex, final int rowsPerPage, String orderBySql, String datoTitulo, String datoDescripcion) {
		if (orderBySql != null) {
			querySql += " " + orderBySql;
		}
		
		final String queryString = querySql;
		final String titulo = datoTitulo;
		final String descripcion = datoDescripcion;
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				if (titulo != null && !titulo.equals("")) {
					query.setParameter("titulo", "%" + titulo + "%");
				}
				if (descripcion != null && !descripcion.equals("")) {
					query.setParameter("descripcion", "%" + descripcion + "%");
				}
				query.setMaxResults(rowsPerPage);
				query.setFirstResult((startIndex - 1) * rowsPerPage);
				return query.list();
			}
		});
		
	}
	
	private List getPaginateListNum(String querySql, final int startIndex, final int rowsPerPage, String orderBySql, String datoTitulo, String datoDescripcion, String datoNumExp,
	        String datoCodEdict, Integer datoDiasCaducidad) {
		if (orderBySql != null) {
			querySql += " " + orderBySql;
		}
		
		final String queryString = querySql;
		final String titulo = datoTitulo;
		final String descripcion = datoDescripcion;
		final String numExp = datoNumExp;
		final String codEdict = datoCodEdict;
		Calendar cal = Calendar.getInstance();
		Date fechaMin = null;
		if (datoDiasCaducidad != null) {
			cal.add(Calendar.DAY_OF_YEAR, -datoDiasCaducidad);
			fechaMin = cal.getTime();
		}
		
		final Date fechaMinima = fechaMin;
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				if (titulo != null && !titulo.equals("")) {
					query.setParameter("titulo", "%" + titulo + "%");
				}
				if (descripcion != null && !descripcion.equals("")) {
					query.setParameter("descripcion", "%" + descripcion + "%");
				}
				if (numExp != null && !numExp.equals("")) {
					query.setParameter("numExp", "%" + numExp + "%");
				}
				if (fechaMinima != null) {
					query.setParameter("fechaMinima", fechaMinima);
				}
				if (codEdict != null && !codEdict.equals("")) {
					query.setParameter("codEdicto", "%" + codEdict + "%");
				}
				query.setMaxResults(rowsPerPage);
				query.setFirstResult((startIndex - 1) * rowsPerPage);
				return query.list();
			}
		});
		
	}
	
	private String findByFiltroPublicoQuery(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer diasCaducidad) {
		
		String queryString = " from Edicto as model where (1=1)";
		
		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
		
		if (!fechaPublicacionInicio.equals("") && fechaPublicacionInicio != null && ValidatorUtils.validaFecha(fechaPublicacionInicio, "", true)) {
			queryString += " AND model.fechaPublicacion >= to_date('" + fechaPublicacionInicio + " - 00:00:01" + "','DD/MM/YYYY - HH24:MI:SS') ";
		}
		
		if (!fechaPublicacionFin.equals("") && fechaPublicacionFin != null && ValidatorUtils.validaFecha(fechaPublicacionFin, "", true)) {
			queryString += " AND model.fechaPublicacion <= to_date('" + fechaPublicacionFin + " - 23:59:59" + "','DD/MM/YYYY  - HH24:MI:SS')";
		}
		
		if (idCentro != -1) {
			queryString += " AND model.centro.idCentro='" + idCentro + "' ";
		}
		
		if (idOrganismoExterno != -1) {
			queryString += " AND model.organismoExterno.idOrg='" + idOrganismoExterno + "' ";
		}
		
		if (idEstado != -1) {
			queryString += " AND model.estado.idEstado='" + idEstado + "' ";
		}
		
		if (idTipoEdicto != -1) {
			queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
		}
		
		if (titulo != null && !titulo.equals("")) {
			if (lenguaje.equals("va")) {
				queryString += " AND upper(model.tituloVa) like upper(:titulo)";
			} else {
				queryString += " AND upper(model.titulo) like upper(:titulo)";
			}
		}
		if (numExp != null && !numExp.equals("")) {
			queryString += " AND upper(model.numExp) like upper(:numExp)";
		}
		if (descripcion != null && !descripcion.equals("")) {
			if (lenguaje.equals("va")) {
				queryString += " AND upper(model.descripcionVa) like upper(:descripcion)";
			} else {
				queryString += " AND upper(model.descripcion) like upper(:descripcion)";
			}
		}
		
		queryString += " AND model.fechaPublicacion >= :fechaMinima";
		queryString += " order by model.fechaPublicacion desc";
		
		return queryString;
	}
	
	private String findByFiltroPublicoSinRelacionadosQuery(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer diasCaducidad,
	        List<Integer> listaRelacionados) {
		
		String queryString = " from Edicto as model where (1=1)";
		
		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
		
		if (!fechaPublicacionInicio.equals("") && fechaPublicacionInicio != null && ValidatorUtils.validaFecha(fechaPublicacionInicio, "", true)) {
			queryString += " AND model.fechaPublicacion >= to_date('" + fechaPublicacionInicio + "','DD/MM/YYYY') ";
		}
		
		if (!fechaPublicacionFin.equals("") && fechaPublicacionFin != null && ValidatorUtils.validaFecha(fechaPublicacionFin, "", true)) {
			queryString += " AND model.fechaPublicacion <= to_date('" + fechaPublicacionFin + "','DD/MM/YYYY')";
		}
		
		if (idCentro != -1) {
			queryString += " AND model.centro.idCentro='" + idCentro + "' ";
		}
		
		if (idOrganismoExterno != -1) {
			queryString += " AND model.organismoExterno.idOrg='" + idOrganismoExterno + "' ";
		}
		
		if (idEstado != -1) {
			queryString += " AND model.estado.idEstado='" + idEstado + "' ";
		}
		
		if (idTipoEdicto != -1) {
			queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
		}
		
		if (titulo != null && !titulo.equals("")) {
			if (lenguaje.equals("va")) {
				queryString += " AND upper(model.tituloVa) like upper(:titulo)";
			} else {
				queryString += " AND upper(model.titulo) like upper(:titulo)";
			}
		}
		if (numExp != null && !numExp.equals("")) {
			queryString += " AND upper(model.numExp) like upper(:numExp)";
		}
		if (descripcion != null && !descripcion.equals("")) {
			if (lenguaje.equals("va")) {
				queryString += " AND upper(model.descripcionVa) like upper(:descripcion)";
			} else {
				queryString += " AND upper(model.descripcion) like upper(:descripcion)";
			}
		}
		if (listaRelacionados.size() > 0) {
			for (int idEdicto : listaRelacionados) {
				queryString += " AND model.idEdicto != " + idEdicto;
			}
		}
		queryString += " AND model.fechaPublicacion >= :fechaMinima";
		queryString += " order by model.fechaPublicacion desc";
		
		return queryString;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByFiltro(java.lang.
	 * Integer, java.lang.Integer, java.lang.Integer, java.lang.String,
	 * java.lang.String, java.lang.Integer)
	 */
	public List findByFiltro(Integer idOrg, Integer idTipoEdicto, Integer idCentro, String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado) {
		
		log.debug(" findByFiltro instance");
		
		try {
			String queryString = " from Edicto as model where (1=1)";
			
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			
			if (!fechaPublicacionInicio.equals("") && fechaPublicacionInicio != null && ValidatorUtils.validaFecha(fechaPublicacionInicio, "", true)) {
				queryString += " AND model.fechaPublicacion >= to_date('" + fechaPublicacionInicio + "','DD/MM/YYYY') ";
			}
			
			if (!fechaPublicacionFin.equals("") && fechaPublicacionFin != null && ValidatorUtils.validaFecha(fechaPublicacionFin, "", true)) {
				queryString += " AND model.fechaPublicacion <= to_date('" + fechaPublicacionFin + "','DD/MM/YYYY')";
			}
			
			if (idCentro != -1) {
				queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			}
			
			if (idEstado != -1) {
				queryString += " AND model.estado.idEstado='" + idEstado + "' ";
			}
			
			if (idTipoEdicto != -1) {
				queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
			}
			
			queryString += " order by model.fechaPublicacion desc";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoEdictosPublico failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByFiltroSinEstadoRetiradoCount(java.lang.String, java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer,
	 * java.lang.Integer)
	 */
	public int findByFiltroSinEstadoRetiradoCount(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numExp, String lenguaje) {
		
		log.debug(" findByFiltroSinEstadoRetirado instance");
		
		String descripcion = null;
		
		try {
			String queryString = findByFiltroSinEstadoRetiradoQuery(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto, idUsuario, usuario, titulo, numExp,
			        lenguaje);
			queryString = "select count(*) " + queryString;
			
			return getCountNum(queryString, titulo, descripcion, numExp, null, null);
			
		} catch (RuntimeException e) {
			log.error("findByFiltroSinEstadoRetiradoCount failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByFiltroSinEstadoRetirado
	 * (java.lang.String, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 * java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numExp, String lenguaje, final Integer numPag, final Integer tamPag) {
		
		log.debug(" findByFiltroSinEstadoRetirado instance");
		
		try {
			String queryString = findByFiltroSinEstadoRetiradoQuery(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto, idUsuario, usuario, titulo, numExp,
			        lenguaje);
			
			String descripcion = null;
			if (numPag == null || tamPag == null) {
				
				final String queryStringParameter = queryString;
				final String tituloParameter = titulo;
				final String descripcionParameter = descripcion;
				final String numeroExpedienteParameter = numExp;
				
				return getHibernateTemplate().executeFind(new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(queryStringParameter);
						if (tituloParameter != null && !tituloParameter.equals("")) {
							query.setParameter("titulo", "%" + tituloParameter + "%");
						}
						if (descripcionParameter != null && !descripcionParameter.equals("")) {
							query.setParameter("descripcion", "%" + descripcionParameter + "%");
						}
						if (numeroExpedienteParameter != null && !numeroExpedienteParameter.equals("")) {
							query.setParameter("numExp", "%" + numeroExpedienteParameter + "%");
						}
						return query.list();
					}
				});
				
			} else {
				return getPaginateListNum(queryString, numPag, tamPag, null, titulo, descripcion, numExp, null, null);
			}
			
		} catch (RuntimeException e) {
			log.error("findByFiltroSinEstadoRetirado failed", e);
			throw e;
		}
	}
	
	/*
	 * public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer
	 * idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer
	 * idUsuario, String usuario,String titulo) {
	 * log.debug(" findByFiltroSinEstadoRetirado instance"); try { String
	 * queryString = findByFiltroSinEstadoRetiradoQuery( fechaRedaccion, idOrg,
	 * idCentro, idEstado, idTipoEdicto, idUsuario, usuario, titulo); return
	 * getHibernateTemplate().find(queryString); } catch (RuntimeException e) {
	 * log.error("findByFiltroSinEstadoRetirado failed", e); throw e; } }
	 */
	
	private String findByFiltroSinEstadoRetiradoQuery(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numExp, String lenguaje) {
		String queryString = " from Edicto as model where (1=1)";
		
		queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
		
		if (usuario.equals("publicador")) {
			queryString += " AND model.publicador.idUsuario='" + idUsuario + "' ";
		}
		
		if (usuario.equals("redactor")) {
			queryString += " AND model.redactor.idUsuario='" + idUsuario + "' ";
		}
		
		if (!fechaRedaccion.equals("") && fechaRedaccion != null && ValidatorUtils.validaFecha(fechaRedaccion, "", true)) {
			queryString += " AND model.fechaRedaccion like to_date('" + fechaRedaccion + "','DD/MM/YYYY') ";
		}
		
		if (idCentro != -1) {
			queryString += " AND model.centro.idCentro='" + idCentro + "' ";
		}
		
		if (organismoExterno != -1) {
			queryString += " AND model.organismoExterno.idOrg='" + organismoExterno + "' ";
		}
		
		if (idEstado != -1) {
			queryString += " AND model.estado.idEstado='" + idEstado + "' ";
		} else {
			queryString += " AND model.estado.idEstado<>'" + Constantes.RETIRADO + "' ";
		}
		
		if (idTipoEdicto != -1) {
			queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
		}
		
		if (titulo != null && !titulo.equals("")) {
			if (lenguaje.equals("va")) {
				queryString += " AND upper(model.tituloVa) like upper(:titulo)";
			} else {
				queryString += " AND upper(model.titulo) like upper(:titulo)";
			}
		}
		
		if (numExp != null && !numExp.equals("")) {
			queryString += " AND upper(model.numExp) like upper(:numExp)";
		}
		
		queryString += "order by model.fechaRedaccion desc";
		
		return queryString;
	}
	
	/*
	 * (non-Javadoc)
	 * @seees.novasoft.sitae.business.dao.impl.EdictoDAO#
	 * findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia
	 * (java.lang.String, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 * java.lang.String, java.util.List)
	 */
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer organismoExterno, Integer idCentro, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia) {
		
		log.debug(" findByFiltroSinEstadoRetirado instance");
		
		try {
			String queryString = " from Edicto as model where (1=1)";
			
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			
			if (usuario.equals("publicador")) {
				queryString += " AND model.publicador.idUsuario='" + idUsuario + "' ";
			}
			
			if (usuario.equals("redactor")) {
				queryString += " AND model.redactor.idUsuario='" + idUsuario + "' ";
			}
			
			if (!fechaRedaccion.equals("") && fechaRedaccion != null && ValidatorUtils.validaFecha(fechaRedaccion, "", true)) {
				queryString += " AND model.fechaRedaccion like to_date('" + fechaRedaccion + "','DD/MM/YYYY') ";
			}
			
			if (idCentro != -1) {
				queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			} else {
				if (centrosProcedencia.size() > 1) {
					Iterator it = centrosProcedencia.iterator();
					queryString += "AND ( ";
					boolean first = true;
					while (it.hasNext()) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
						if (first == true) {
							queryString += " model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
							first = false;
						} else {
							queryString += " OR model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
						}
						
					}
					queryString += " ) ";
				} else {
					if (centrosProcedencia.size() == 1) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) centrosProcedencia.get(0);
						queryString += " AND model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
					} else {
						queryString += " AND model.centro.idCentro='-1'";
					}
					
				}
				
			}
			
			if (organismoExterno != -1) {
				queryString += " AND model.organismoExterno.idOrg='" + organismoExterno + "' ";
			}
			
			if (idEstado != -1) {
				queryString += " AND model.estado.idEstado='" + idEstado + "' ";
			} else {
				queryString += " AND model.estado.idEstado<>'" + Constantes.RETIRADO + "' ";
				queryString += " AND model.estado.idEstado<>'" + Constantes.INICIADO + "' ";
				queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_VALIDACION + "' ";
				queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_FIRMA + "' ";
				queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO_FIRMA + "' ";
				queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO + "' ";
			}
			
			if (idTipoEdicto != -1) {
				queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
			}
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByFiltroSinEstadoRetirado failed", e);
			throw e;
		}
	}
	
	public int findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numExp, String codigoEdicto, String lenguaje) {
		
		log.debug("findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia Count");
		
		try {
			
			String descripcion = null;
			String queryString = findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaQuery(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia, titulo, numExp, codigoEdicto, lenguaje);
			return getCountNum("select count(*) " + queryString, titulo, descripcion, numExp, codigoEdicto, null);
			
		} catch (RuntimeException e) {
			log.error("findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia failed", e);
			throw e;
		}
	}
	
	/** Modificacion */
	
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numExp, String codigoEdicto, String lenguaje, Integer numPag,
	        Integer tamPag) {
		
		log.debug("findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia Count");
		
		try {
			String descripcion = null;
			String queryString = findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaQuery(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia, titulo, numExp, codigoEdicto, lenguaje);
			if (numPag == null || tamPag == null) {
				
				final String queryStringParameter = queryString;
				final String tituloParameter = titulo;
				final String descripcionParameter = descripcion;
				final String numeroExpedienteParameter = numExp;
				final String codigoEdictoParameter = codigoEdicto;
				return getHibernateTemplate().executeFind(
				
				new HibernateCallback() {
					
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(queryStringParameter);
						if (tituloParameter != null && !tituloParameter.equals("")) {
							query.setParameter("titulo", "%" + tituloParameter + "%");
						}
						if (descripcionParameter != null && !descripcionParameter.equals("")) {
							query.setParameter("descripcion", "%" + descripcionParameter + "%");
						}
						if (numeroExpedienteParameter != null && !numeroExpedienteParameter.equals("")) {
							query.setParameter("numExp", "%" + numeroExpedienteParameter + "%");
						}
						if (codigoEdictoParameter != null && !codigoEdictoParameter.equals("")) {
							query.setParameter("codEdicto", "%" + codigoEdictoParameter + "%");
						}
						return query.list();
					}
				});
				
			} else {
				return getPaginateListNum(queryString, numPag, tamPag, null, titulo, descripcion, numExp, codigoEdicto, null);
			}
			
		} catch (RuntimeException e) {
			log.error("findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia failed", e);
			throw e;
		}
		
	}
	
	public String findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaQuery(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numExp, String codEdicto, String lenguaje) {
		
		String queryString = " from Edicto as model where (1=1)";
		
		if (titulo != null && !titulo.equals("")) {
			if (lenguaje.equals("va")) {
				queryString += " AND upper(model.tituloVa) like upper(:titulo)";
			} else {
				queryString += " AND upper(model.titulo) like upper(:titulo)";
			}
		}
		
		if (numExp != null && !numExp.equals("")) {
			queryString += " AND upper(model.numExp) like upper(:numExp)";
		}
		if (codEdicto != null && !codEdicto.equals("")) {
			queryString += " AND upper(model.codigo) like upper(:codEdicto)";
		}
		
		if (!fechaRedaccion.equals("") && fechaRedaccion != null && ValidatorUtils.validaFecha(fechaRedaccion, "", true)) {
			queryString += " AND model.fechaRedaccion like to_date('" + fechaRedaccion + "','DD/MM/YYYY') ";
		}
		
		if (organismoExterno != -1) {
			queryString += " AND model.organismoExterno.idOrg='" + organismoExterno + "' ";
		}
		
		if (idCentro != -1) {
			queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			if (usuario.equals("publicador")) {
				queryString += " AND model.publicador.idUsuario='" + idUsuario + "' ";
			}
			
			if (usuario.equals("redactor")) {
				queryString += " AND model.redactor.idUsuario='" + idUsuario + "' ";
			}
		} else {
			if (centrosProcedencia != null) {
				if (centrosProcedencia.size() > 1) {
					Iterator it = centrosProcedencia.iterator();
					queryString += "AND ( ";
					boolean first = true;
					while (it.hasNext()) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
						if (first == true) {
							queryString += " model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
							first = false;
						} else {
							queryString += " OR model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
						}
						
					}
					queryString += " ) ";
				} else {
					if (centrosProcedencia.size() == 1) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) centrosProcedencia.get(0);
						queryString += " AND model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
					} else {
						queryString += " AND model.centro.idCentro='-1'";
					}
					
				}
				if (usuario.equals("publicador")) {
					queryString += " AND model.publicador.idUsuario='" + idUsuario + "' ";
				}
				
				if (usuario.equals("redactor")) {
					queryString += " AND model.redactor.idUsuario='" + idUsuario + "' ";
				}
			} else if (idOrg != null) {
				queryString += "AND model.organismo.idOrg='" + idOrg + "'";
				
			}
			
		}
		
		if (idEstado != -1) {
			queryString += " AND model.estado.idEstado='" + idEstado + "' ";
		} else {
			queryString += " AND model.estado.idEstado<>'" + Constantes.RETIRADO + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.INICIADO + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_VALIDACION + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_FIRMA + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO_FIRMA + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO + "' ";
		}
		
		if (idTipoEdicto != -1) {
			queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
		}
		queryString += "order by  model.estado.idEstado asc, model.fechaPublicacion desc";
		return queryString;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByFiltro(java.lang.
	 * String, java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public List findByFiltro(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario) {
		
		log.debug(" findByFiltro instance");
		
		try {
			String queryString = " from Edicto as model where (1=1)";
			
			queryString += " AND model.organismo.idOrg='" + idOrg + "' ";
			
			if (usuario.equals("publicador")) {
				queryString += " AND model.publicador.idUsuario='" + idUsuario + "' ";
			}
			
			if (usuario.equals("redactor")) {
				queryString += " AND model.redactor.idUsuario='" + idUsuario + "' ";
			}
			
			if (!fechaRedaccion.equals("") && fechaRedaccion != null && ValidatorUtils.validaFecha(fechaRedaccion, "", true)) {
				queryString += " AND model.fechaRedaccion like to_date('" + fechaRedaccion + "','DD/MM/YYYY') ";
			}
			
			if (idCentro != -1) {
				queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			}
			
			if (idEstado != -1) {
				queryString += " AND model.estado.idEstado='" + idEstado + "' ";
			}
			
			if (idTipoEdicto != -1) {
				queryString += " AND model.tipoEdicto.idTipoEdicto='" + idTipoEdicto + "' ";
			}
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoPerfiles failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByRedactorEstado(java
	 * .lang.String)
	 */
	public List findByRedactorEstado(String dni) {
		
		log.debug(" findByRedactorEstado instance");
		
		try {
			String queryString = " from Edicto as model where (1=1)";
			
			if (!dni.equals("") && dni != null) {
				queryString += " AND model.redactor.numDocumento='" + dni + "' ";
			}
			
			queryString += " AND model.estado.idEstado<>'" + Constantes.INICIADO + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_VALIDACION + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.PENDIENTE_FIRMA + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO_FIRMA + "' ";
			queryString += " AND model.estado.idEstado<>'" + Constantes.RECHAZADO + "' ";
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoPerfiles failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByCentro(java.lang.
	 * Integer)
	 */
	public List findByCentro(Integer idCentro) {
		
		log.debug("findByCentro instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.centro.idCentro='" + idCentro + "' ";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.dao.impl.EdictoDAO#findByCodigo(java.lang.
	 * String)
	 */
	public List findByCodigo(String codigo) {
		
		log.debug("findByCodigo instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			queryString += " AND model.codigo='" + codigo + "' ";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	public List findEdictosPendientesValidacionPorCentro(List centrosProcedencia) {
		
		log.debug("findEdictosPendientesValidacionPorCentro instance");
		
		try {
			String queryString = " from Edicto as model where (1=1)";
			if (centrosProcedencia != null) {
				if (centrosProcedencia.size() > 1) {
					Iterator it = centrosProcedencia.iterator();
					queryString += "AND ( ";
					boolean first = true;
					while (it.hasNext()) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
						if (first == true) {
							queryString += " model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
							first = false;
						} else {
							queryString += " OR model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
						}
					}
					queryString += " ) ";
				} else {
					if (centrosProcedencia.size() == 1) {
						CentroProcedencia centroProcedencia = (CentroProcedencia) centrosProcedencia.get(0);
						queryString += " AND model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
					} else {
						queryString += " AND model.centro.idCentro='-1'";
					}
				}
			}
			queryString += " AND model.estado.idEstado='" + Constantes.PENDIENTE_VALIDACION + "'";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findEdictosPendientesValidacionPorCentro failed", e);
			throw e;
		}
		
	}
	
	public int findEdictosPendientesValidacionPorCentroCont(
	
	List centrosProcedencia) {
		
		log.debug("findEdictosPendientesValidacionPorCentro Count");
		
		try {
			
			String queryString = findEdictosPendientesValidacionPorCentroQuery(centrosProcedencia);
			
			return getCount("select count(*) " + queryString);
			
		} catch (RuntimeException e) {
			log.error("findEdictosPendientesValidacionPorCentro failed", e);
			throw e;
		}
	}
	
	public List findEdictosPendientesValidacionPorCentro(List centrosProcedencia, Integer numPag, Integer tamPag) {
		
		log.debug("findEdictosPendientesValidacionPorCentro");
		
		try {
			String queryString = findEdictosPendientesValidacionPorCentroQuery(centrosProcedencia);
			if (numPag == null || tamPag == null) {
				return getHibernateTemplate().find(queryString);
			} else {
				
				return getPaginateList(queryString, numPag, tamPag, null);
			}
			
		} catch (RuntimeException e) {
			log.error("findEdictosPendientesValidacionPorCentro", e);
			throw e;
		}
		
	}
	
	private String findEdictosPendientesValidacionPorCentroQuery(List centrosProcedencia) {
		
		log.debug("findEdictosPendientesValidacionPorCentroQuery instance");
		
		String queryString = " from Edicto as model where (1=1)";
		if (centrosProcedencia != null) {
			if (centrosProcedencia.size() > 1) {
				Iterator it = centrosProcedencia.iterator();
				queryString += "AND ( ";
				boolean first = true;
				while (it.hasNext()) {
					CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
					if (first == true) {
						queryString += " model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
						first = false;
					} else {
						queryString += " OR model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
					}
				}
				queryString += " ) ";
			} else {
				if (centrosProcedencia.size() == 1) {
					CentroProcedencia centroProcedencia = (CentroProcedencia) centrosProcedencia.get(0);
					queryString += " AND model.centro.idCentro='" + centroProcedencia.getIdCentro() + "'";
				} else {
					queryString += " AND model.centro.idCentro='-1'";
				}
			}
		}
		queryString += " AND model.estado.idEstado='" + Constantes.PENDIENTE_VALIDACION + "'";
		queryString += "order by model.fechaRedaccion desc";
		return queryString;
		
	}
	
	public List findByFechaRetiradaPropuesta(String fechaRetirada) throws DAOException {
		log.debug("findByCodigo instance");
		
		try {
			
			String queryString = "from Edicto as model where " +
			// " SET id_estado=" + estadoRetirado.getIdEstado()+" " +
			        "model.estado.idEstado=5 " + "AND model.fechaRetiradaPropuesta < to_date('" + fechaRetirada + " - 00:00:00" + "','DD/MM/YYYY - HH24:MI:SS')";
			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
	public List findByIdEstado(Integer idEstado) {
		
		log.debug("findByIdEstado instance");
		
		try {
			
			String queryString = " from Edicto as model where (1=1)";
			
			if (idEstado != -1) {
				queryString += " AND model.estado.idEstado=" + idEstado.intValue();
			}
			queryString += "order by model.fechaRedaccion desc";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException e) {
			log.error("findByIdEstado failed", e);
			throw e;
		}
	}
	
	public List contarEdictosOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			
			String queryString = "SELECT edicto.organismo.nombre, COUNT(edicto.id),edicto.organismo.idOrg FROM Edicto as edicto  WHERE (edicto.estado.idEstado="
			        + Constantes.RETIRADO + " OR  edicto.estado.idEstado=" + Constantes.PUBLICADO + ") " + " AND edicto.fechaPublicacion>= to_date('" + fechaPublicacionInicio
			        + " - 00:00:01" + "','DD/MM/YYYY - HH24:MI:SS') " + " AND edicto.fechaPublicacion <= to_date('" + fechaPublicacionFin + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')" + " GROUP BY edicto.organismo.idOrg, edicto.organismo.nombre";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("contarEdictosOrganismosFechas", e);
			
			throw e;
			
		}
		
	}
	
	public List contarEdictosOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			
			String queryString = "SELECT cen.nombre, COUNT(edicto.id), cen.idCentro FROM Edicto as edicto inner join  edicto.centro as cen   WHERE ( edicto.estado.idEstado="
			        + Constantes.RETIRADO + " OR  edicto.estado.idEstado=" + Constantes.PUBLICADO + ") " + " AND edicto.fechaPublicacion>= to_date('" + fechaPublicacionInicio
			        + " - 00:00:01" + "','DD/MM/YYYY - HH24:MI:SS') " + " AND edicto.fechaPublicacion <= to_date('" + fechaPublicacionFin + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')" + " AND edicto.organismo.idOrg=" + org.getIdOrg() + " GROUP BY cen.idCentro ,cen.nombre";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("contarEdictosOrganismoFechas", e);
			
			throw e;
			
		}
	}
	
	public List contarEdictosOrgExtOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			
			String queryString = "SELECT  COUNT(edicto.id), edicto.IdOrganismoExterno FROM Edicto as edicto inner join  edicto.centro as cen  WHERE (edicto.estado.idEstado="
			        + Constantes.RETIRADO + " OR  edicto.estado.idEstado=" + Constantes.PUBLICADO + ") " + " AND edicto.fechaPublicacion>= to_date('" + fechaPublicacionInicio
			        + " - 00:00:01" + "','DD/MM/YYYY - HH24:MI:SS') " + " AND edicto.fechaPublicacion <= to_date('" + fechaPublicacionFin + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')" + " GROUP BY edicto.IdOrganismoExterno";
			List resultado = getHibernateTemplate().find(queryString);
			
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("contarEdictosOrganismosFechas", e);
			
			throw e;
			
		}
		
	}
	
	public List contarEdictosOrgExtOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			
			String queryString = "SELECT  COUNT(edicto.id), edicto.IdOrganismoExterno FROM Edicto as edicto inner join  edicto.centro as cen   WHERE ( edicto.estado.idEstado="
			        + Constantes.RETIRADO + " OR  edicto.estado.idEstado=" + Constantes.PUBLICADO + ") " + " AND edicto.fechaPublicacion>= to_date('" + fechaPublicacionInicio
			        + " - 00:00:01" + "','DD/MM/YYYY - HH24:MI:SS') " + " AND edicto.fechaPublicacion <= to_date('" + fechaPublicacionFin + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')" + " AND edicto.organismo.idOrg=" + org.getIdOrg() + " GROUP BY edicto.IdOrganismoExterno";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("contarEdictosOrganismoFechas", e);
			
			throw e;
			
		}
	}
	
	public List estadisticasCSVOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			String queryString = "SELECT cen.nombre, COUNT(edicto.id), cen.idCentro, year(edicto.fechaPublicacion) as year, month(edicto.fechaPublicacion) as month, edicto.tipoEdicto.nombre as tipo FROM Edicto as edicto inner join  edicto.centro as cen   WHERE (edicto.estado.idEstado="
			        + Constantes.RETIRADO
			        + " OR  edicto.estado.idEstado="
			        + Constantes.PUBLICADO
			        + ") "
			        + " AND edicto.fechaPublicacion>= to_date('"
			        + fechaPublicacionInicio
			        + " - 00:00:01"
			        + "','DD/MM/YYYY - HH24:MI:SS') "
			        + " AND edicto.fechaPublicacion <= to_date('"
			        + fechaPublicacionFin
			        + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')"
			        + " AND edicto.organismo.idOrg="
			        + org.getIdOrg()
			        + " GROUP BY cen.idCentro ,cen.nombre, month(edicto.fechaPublicacion), year(edicto.fechaPublicacion), edicto.tipoEdicto.nombre";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("estadisticasCSVOrganismoFechas", e);
			
			throw e;
			
		}
		
	}
	
	public List estadisticasCSVOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			
			String queryString = "SELECT edicto.organismo.nombre, COUNT(edicto.id), edicto.organismo.idOrg, cen.nombre, cen.idCentro, year(edicto.fechaPublicacion) as year, month(edicto.fechaPublicacion) as month, edicto.tipoEdicto.nombre as tipo  FROM Edicto as edicto inner join  edicto.centro as cen  WHERE (edicto.estado.idEstado="
			        + Constantes.RETIRADO
			        + " OR  edicto.estado.idEstado="
			        + Constantes.PUBLICADO
			        + ") "
			        + " AND edicto.fechaPublicacion>= to_date('"
			        + fechaPublicacionInicio
			        + " - 00:00:01"
			        + "','DD/MM/YYYY - HH24:MI:SS') "
			        + " AND edicto.fechaPublicacion <= to_date('"
			        + fechaPublicacionFin
			        + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')"
			        + " GROUP BY edicto.organismo.idOrg, edicto.organismo.nombre,cen.idCentro ,cen.nombre, month(edicto.fechaPublicacion), year(edicto.fechaPublicacion), edicto.tipoEdicto.nombre";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("estadisticasCSVOrganismosFechas", e);
			
			throw e;
			
		}
		
	}
	
	public List estadisticasCSVOrganismoExternosFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			String queryString = "SELECT cen.nombre, COUNT(edicto.id), cen.idCentro, year(edicto.fechaPublicacion) as year, month(edicto.fechaPublicacion) as month, edicto.tipoEdicto.nombre as tipo, edicto.IdOrganismoExterno FROM Edicto as edicto inner join  edicto.centro as cen    WHERE (edicto.estado.idEstado="
			        + Constantes.RETIRADO
			        + " OR  edicto.estado.idEstado="
			        + Constantes.PUBLICADO
			        + ") "
			        + " AND edicto.fechaPublicacion>= to_date('"
			        + fechaPublicacionInicio
			        + " - 00:00:01"
			        + "','DD/MM/YYYY - HH24:MI:SS') "
			        + " AND edicto.fechaPublicacion <= to_date('"
			        + fechaPublicacionFin
			        + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')"
			        + " AND edicto.organismo.idOrg="
			        + org.getIdOrg()
			        + " GROUP BY cen.idCentro ,cen.nombre, month(edicto.fechaPublicacion), year(edicto.fechaPublicacion), edicto.tipoEdicto.nombre, edicto.IdOrganismoExterno";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("estadisticasCSVOrganismoFechas", e);
			
			throw e;
			
		}
		
	}
	
	public List estadisticasCSVOrganismosExternosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException {
		
		try {
			
			String queryString = "SELECT edicto.organismo.nombre, COUNT(edicto.id), edicto.organismo.idOrg, cen.nombre, cen.idCentro, year(edicto.fechaPublicacion) as year, month(edicto.fechaPublicacion) as month, edicto.tipoEdicto.nombre as tipo, edicto.IdOrganismoExterno FROM Edicto as edicto inner join  edicto.centro as cen  WHERE (edicto.estado.idEstado="
			        + Constantes.RETIRADO
			        + " OR  edicto.estado.idEstado="
			        + Constantes.PUBLICADO
			        + ") "
			        + " AND edicto.fechaPublicacion>= to_date('"
			        + fechaPublicacionInicio
			        + " - 00:00:01"
			        + "','DD/MM/YYYY - HH24:MI:SS') "
			        + " AND edicto.fechaPublicacion <= to_date('"
			        + fechaPublicacionFin
			        + " - 23:59:59"
			        + "','DD/MM/YYYY  - HH24:MI:SS')"
			        + " GROUP BY edicto.organismo.idOrg, edicto.organismo.nombre,cen.idCentro ,cen.nombre, month(edicto.fechaPublicacion), year(edicto.fechaPublicacion), edicto.tipoEdicto.nombre, edicto.IdOrganismoExterno";
			List resultado = getHibernateTemplate().find(queryString);
			return resultado;
			
		} catch (RuntimeException e) {
			log.error("estadisticasCSVOrganismosFechas", e);
			
			throw e;
			
		}
		
	}
	
	public String edictoConfirmaPosteriorAQuery(Date fecha) {
		String fechaString = FechasUtil.convertDateToString(fecha, FechasUtil.typeSdfDate);
		String queryString = "  FROM Edicto as edicto WHERE edicto.caducidadFirma<= to_date('" + fechaString + " - 00:00:01" + "','DD/MM/YYYY - HH24:MI:SS') ";
		return queryString;
	}
	
	public int edictoConFirmaPosteriorACount(Date fecha) throws DAOException {
		
		log.debug("edictoConFirmaPosteriorACount ");
		
		try {
			
			String query = edictoConfirmaPosteriorAQuery(fecha);
			
			return getCount("select count(*) " + query);
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
		
	}
	
	public List edictoConFirmaPosteriorA(Date fecha, Integer numPag, Integer tamPag) throws DAOException {
		
		log.debug("edictoConFirmaPosteriorACount instance");
		
		try {
			
			String queryString = edictoConfirmaPosteriorAQuery(fecha);
			
			if (numPag == null || tamPag == null) {
				return getHibernateTemplate().find(queryString);
			} else {
				
				return getPaginateList(queryString, numPag, tamPag, null);
			}
			
		} catch (RuntimeException e) {
			log.error("listadoTramites failed", e);
			throw e;
		}
	}
	
}