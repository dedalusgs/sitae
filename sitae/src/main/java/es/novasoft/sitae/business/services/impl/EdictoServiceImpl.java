package es.novasoft.sitae.business.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.dao.interfaz.EdictoDAO;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;

public class EdictoServiceImpl implements EdictoService {
	
	private static Log	log	= LogFactory.getFactory().getInstance(CentroProcedenciaServiceImpl.class);
	
	private EdictoDAO	edictoDAO;
	
	public EdictoDAO getEdictoDao() {
		return this.edictoDAO;
	}
	
	public void setEdictoDAO(EdictoDAO edictoDAO) {
		this.edictoDAO = edictoDAO;
	}
	
	public void save(Edicto transientInstance) throws ServiceException {
		log.debug("save Edicto");
		try {
			this.edictoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void delete(Edicto persistentInstance) throws ServiceException {
		log.debug("deleting Edicto instance");
		try {
			this.edictoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public Edicto findById(Integer id) throws ServiceException {
		log.debug("getting Edicto instance with id: " + id);
		try {
			return this.edictoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByExample(Edicto instance) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return this.edictoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return this.edictoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByIdOrganismoExterno(Integer idOrganismoExterno) throws ServiceException {
		log.debug("getting Edicto instance with id Organismo Externo: " + idOrganismoExterno);
		try {
			return this.edictoDAO.findByIdOrganismoExterno(idOrganismoExterno);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findAll() throws ServiceException {
		log.debug("findAll Edicto");
		try {
			return this.edictoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public Edicto merge(Edicto detachedInstance) throws ServiceException {
		log.debug("merging Edicto instance");
		try {
			return this.edictoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void attachDirty(Edicto instance) throws ServiceException {
		log.debug("attaching dirty Edicto instance");
		try {
			this.edictoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void attachClean(Edicto instance) throws ServiceException {
		log.debug("attaching clean Edicto instance");
		try {
			this.edictoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentroYEstadosExPRYPubORed(Integer idCentro, Integer idUsuario) throws ServiceException {
		
		log.debug("finding findByCentroYEstadosYPubORed instance by example");
		try {
			return this.edictoDAO.findByCentroYEstadosExPRYPubORed(idCentro, idUsuario);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentroUsuarioPerfilYEstadosExPR(Integer idCentro, Integer idUsuario, Integer idPerfil) throws ServiceException {
		
		log.debug("finding findByCentroUsuarioPerfilYEstadosExPR instance by example");
		try {
			return this.edictoDAO.findByCentroUsuarioPerfilYEstadosExPR(idCentro, idUsuario, idPerfil);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinEstadoHistorico(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor, Integer posIni, Integer maxElem) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinEstadoHistorico(idOrg, idRedactor, posIni, maxElem);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoRedactorSinEstadoHistoricoCount(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("count Edicto");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinEstadoHistoricoCount(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactor(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactor(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoRedactorSinPublicar(Integer idOrg, Integer idRedactor) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoRedactorSinPublicar(idOrg, idRedactor);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoPublicador(Integer idOrg, Integer idPublicador) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicador(idOrg, idPublicador);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentroPublicadorSinPublicar(Integer idCentro, Integer idPublicador) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicador(idCentro, idPublicador);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(idPublicador, centrosProcedencia, organismo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, int numPag, int tamPag,
	        Organismo organismo) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(idPublicador, centrosProcedencia, numPag, tamPag, organismo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(idPublicador, centrosProcedencia, organismo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoEstado(Integer idOrg, Integer idEstado) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstado(idOrg, idEstado);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoEstadoOrderFechaPublicacionCount(Integer idOrg, Integer idEstado, Integer diasCaducidad) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacionCount(idOrg, idEstado, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoEstadoOrderFechaPublicacion(Integer idOrg, Integer idEstado, int numPag, int tamPag, Integer diasCaducidad) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacion(idOrg, idEstado, numPag, tamPag, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(Integer idOrg, Integer idEstado, Integer diasCaducidad, List<Integer> listaRelacionados)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacionCount(idOrg, idEstado, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(Integer idOrg, Integer idEstado, int numPag, int tamPag, Integer diasCaducidad,
	        List<Integer> listaRelacionados) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByOrganismoEstadoOrderFechaPublicacion(idOrg, idEstado, numPag, tamPag, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByFiltroPublicoCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico, Integer diasCaducidad)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroPublicoCount(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado,
			        titulo, descripcion, lenguaje, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroPublico(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico, int numPag, int tamPag,
	        Integer diasCaducidad) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroPublico(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado, titulo,
			        descripcion, lenguaje, numPag, tamPag, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByFiltroPublicoSinRelacionadosCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroPublicoCount(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado,
			        titulo, descripcion, lenguaje, diasCaducidad) - listaRelacionados.size();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroPublicoSinRelacionados(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String contenido, String lenguaje, Boolean historico, int numPag, int tamPag,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroPublico(idOrg, idTipoEdicto, idCentro, idOrganismoExterno, numExp, fechaPublicacionInicio, fechaPublicacionFin, idEstado, titulo,
			        descripcion, lenguaje, numPag, tamPag, diasCaducidad);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltro(Integer idOrg, Integer idTipoEdicto, Integer idCentro, String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltro(idOrg, idTipoEdicto, idCentro, fechaPublicacionInicio, fechaPublicacionFin, idEstado);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer
	 * idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer
	 * idUsuario,String usuario,String titulo) throws ServiceException{ try {
	 * return edictoDAO.findByFiltroSinEstadoRetirado(fechaRedaccion, idOrg,
	 * idCentro,idEstado,idTipoEdicto,idUsuario,usuario,titulo); } catch
	 * (DAOException e) { log.error(e.getMessage()); throw new
	 * ServiceException(e.getMessage(), e.getExceptionkey()); } }
	 */
	public int findByFiltroSinEstadoRetiradoCount(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje) throws ServiceException {
		
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoCount(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto, idUsuario, usuario, titulo,
			        numeroExpediente, lenguaje);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje, int numPag, int tamPag) throws ServiceException {
		
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetirado(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto, idUsuario, usuario, titulo,
			        numeroExpediente, lenguaje, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto,
	        String lenguaje) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia, titulo, numeroExpediente, codigoEdicto, lenguaje);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto, String lenguaje,
	        int numPag, int tamPag) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(fechaRedaccion, idOrg, idCentro, organismoExterno, idEstado, idTipoEdicto,
			        idUsuario, usuario, centrosProcedencia, titulo, numeroExpediente, codigoEdicto, lenguaje, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFiltro(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario)
	        throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByFiltro(fechaRedaccion, idOrg, idCentro, idEstado, idTipoEdicto, idUsuario, usuario);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByRedactorEstado(String dni) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByRedactorEstado(dni);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCentro(Integer idCentro) throws ServiceException {
		log.debug("finding Edicto instance by example");
		try {
			return this.edictoDAO.findByCentro(idCentro);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByCodigo(String codigo) throws ServiceException {
		log.debug("finding Edicto instance by codigo");
		try {
			return this.edictoDAO.findByCodigo(codigo);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int findEdictosPendientesValidacionPorCentroCont(List centrosProcedencia) throws ServiceException {
		
		log.debug("finding Edicto instance by example");
		
		try {
			return this.edictoDAO.findEdictosPendientesValidacionPorCentroCont(centrosProcedencia);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findEdictosPendientesValidacionPorCentro(List centrosProcedencia, int numPag, int tamPag) throws ServiceException {
		
		log.debug("finding Edicto instance by example");
		
		try {
			return this.edictoDAO.findEdictosPendientesValidacionPorCentro(centrosProcedencia, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByFechaRetiradaPropuesta(String fechaRetirada) throws ServiceException {
		log.debug("finding Edicto instance by fecha retirada");
		try {
			return this.edictoDAO.findByFechaRetiradaPropuesta(fechaRetirada);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List findByIdEstado(Integer id) throws ServiceException {
		log.debug("getting Edicto instance with id: " + id);
		try {
			return this.edictoDAO.findByIdEstado(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public void actualizar(Edicto instance) throws ServiceException {
		// TODO Auto-generated method stub
		this.attachDirty(instance);
	}
	
	public List contarEdictosOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.contarEdictosOrganismoFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
		
	}
	
	public List contarEdictosOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.contarEdictosOrganismosFechas(fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismosFechas(fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismoFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismoExternosFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismoExternosFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List estadisticasCSVOrganismosExternosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			return this.edictoDAO.estadisticasCSVOrganismosExternosFechas(fechaPublicacionInicio, fechaPublicacionFin);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List contarEdictosOrgExtOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			
			List listadoResultados = this.edictoDAO.contarEdictosOrgExtOrganismosFechas(fechaPublicacionInicio, fechaPublicacionFin);
			OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
			List listadoOrgExternos = organismoExternoService.findAll();
			HashMap<Integer, OrganismoExterno> mapOrgExt = new HashMap<Integer, OrganismoExterno>();
			for (Iterator i = listadoOrgExternos.iterator(); i.hasNext();) {
				OrganismoExterno auxOrgExt = (OrganismoExterno) i.next();
				mapOrgExt.put(auxOrgExt.getIdOrg(), auxOrgExt);
				
			}
			for (Iterator it = listadoResultados.iterator(); it.hasNext();) {
				Object[] row = (Object[]) it.next();
				Integer idOrgExt = (Integer) row[1];
				if (idOrgExt != null) {
					OrganismoExterno auxOrgExt = mapOrgExt.get(idOrgExt);
					row[1] = auxOrgExt.getNombre();
				} else {
					row[1] = "Interno";
				}
			}
			
			return listadoResultados;
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List contarEdictosOrgExtOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException {
		try {
			List listadoResultados = this.edictoDAO.contarEdictosOrgExtOrganismoFechas(org, fechaPublicacionInicio, fechaPublicacionFin);
			OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
			List listadoOrgExternos = organismoExternoService.findAll();
			HashMap<Integer, OrganismoExterno> mapOrgExt = new HashMap<Integer, OrganismoExterno>();
			for (Iterator i = listadoOrgExternos.iterator(); i.hasNext();) {
				OrganismoExterno auxOrgExt = (OrganismoExterno) i.next();
				mapOrgExt.put(auxOrgExt.getIdOrg(), auxOrgExt);
				
			}
			for (Iterator it = listadoResultados.iterator(); it.hasNext();) {
				Object[] row = (Object[]) it.next();
				Integer idOrgExt = (Integer) row[1];
				if (idOrgExt != null) {
					OrganismoExterno auxOrgExt = mapOrgExt.get(idOrgExt);
					row[1] = auxOrgExt.getNombre();
				} else {
					row[1] = "Interno";
				}
			}
			
			return listadoResultados;
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public byte[] obtenerFicheroAnuncio(Edicto edicto) {
		
		return edicto.getPdfAdjunto();
	}
	
	public byte[] obtenerFicheroDiligencia(Edicto edicto) {
		
		return edicto.getDiligencia();
	}
	
	public byte[] obtenerFicheroFirmaDiligencia(Edicto edicto) {
		return edicto.getDiligencia();
		
	}
	
	public void actualizarRepublicarBorrador(Edicto transientInstance) throws ServiceException {
		this.attachDirty(transientInstance);
		
	}
	
	public List findByOrganismo(Integer idOrg) throws ServiceException {
		try {
			return this.edictoDAO.findByOrganismo(idOrg);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public List edictoConFirmaPosteriorA(Date fecha, Integer numPag, Integer tamPag) throws ServiceException {
		try {
			return edictoDAO.edictoConFirmaPosteriorA(fecha, numPag, tamPag);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	public int edictoConFirmaPosteriorACount(Date fecha) throws ServiceException {
		try {
			return edictoDAO.edictoConFirmaPosteriorACount(fecha);
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
}
