package es.novasoft.sitae.business.dao.interfaz;

import java.util.Date;
import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;

public interface EdictoDAO {
	
	// property constants
	public static final String	NOMBRE	= "nombre";
	
	public abstract void save(Edicto transientInstance) throws DAOException;
	
	public abstract void delete(Edicto persistentInstance) throws DAOException;
	
	public abstract Edicto findById(Integer id) throws DAOException;
	
	public abstract List findByExample(Edicto instance) throws DAOException;
	
	public abstract List findByProperty(String propertyName, Object value) throws DAOException;
	
	public abstract List findByNombre(Object nombre) throws DAOException;
	
	public abstract List findByIdOrganismoExterno(Integer idOrganismoExterno) throws DAOException;
	
	public abstract List findAll() throws DAOException;
	
	public abstract Edicto merge(Edicto detachedInstance) throws DAOException;
	
	public abstract void attachDirty(Edicto instance) throws DAOException;
	
	public abstract void attachClean(Edicto instance) throws DAOException;
	
	public abstract List findByCentroYEstadosExPRYPubORed(Integer idCentro, Integer idUsuario) throws DAOException;
	
	public abstract List findByCentroUsuarioPerfilYEstadosExPR(Integer idCentro, Integer idUsuario, Integer idPerfil) throws DAOException;
	
	public abstract List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor) throws DAOException;
	
	public abstract List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor, Integer numPag, Integer tamPag) throws DAOException;
	
	public abstract int findByOrganismoRedactorSinEstadoHistoricoCount(Integer idOrg, Integer idRedactor) throws DAOException;
	
	public abstract List findByOrganismoRedactorSinPublicar(Integer idOrg, Integer idRedactor) throws DAOException;
	
	public abstract List findByOrganismoRedactor(Integer idOrg, Integer idRedactor) throws DAOException;
	
	public abstract List findByOrganismoPublicador(Integer idOrg, Integer idPublicador) throws DAOException;;
	
	public abstract List findByCentroPublicadorSinPublicar(Integer idCentro, Integer idPublicador) throws DAOException;
	
	public abstract int findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws DAOException;
	
	public abstract List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Integer numPag, Integer tamPag,
	        Organismo organismo) throws DAOException;
	
	public abstract List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws DAOException;
	
	public abstract List findByOrganismoEstado(Integer idOrg, Integer idEstado) throws DAOException;
	
	public abstract int findByOrganismoEstadoOrderFechaPublicacionCount(Integer idOrg, Integer idEstado, Integer diasCaducidad) throws DAOException;
	
	public abstract List findByOrganismoEstadoOrderFechaPublicacion(Integer idOrg, Integer idEstado, Integer numPag, Integer tamPag, Integer diasCaducidad) throws DAOException;
	
	public abstract int findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(Integer idOrg, Integer idEstado, Integer diasCaducidad, List<Integer> listaRelacionados)
	        throws DAOException;
	
	public abstract List findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(Integer idOrg, Integer idEstado, Integer numPag, Integer tamPag, Integer diasCaducidad,
	        List<Integer> listaRelacionados) throws DAOException;
	
	public abstract int findByFiltroPublicoCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer diasCaducidad) throws DAOException;
	
	public abstract List findByFiltroPublico(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer numPag, Integer tamPag, Integer diasCaducidad)
	        throws DAOException;
	
	public abstract int findByFiltroPublicoSinRelacionadosCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer diasCaducidad,
	        List<Integer> listaRelacionados) throws DAOException;
	
	public abstract List findByFiltroPublicoSinRelacionados(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String titulo, String descripcion, String lenguaje, Integer numPag, Integer tamPag,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws DAOException;
	
	public abstract List findByFiltro(Integer idOrg, Integer idTipoEdicto, Integer idCentro, String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado)
	        throws DAOException;
	
	public abstract int findByFiltroSinEstadoRetiradoCount(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje) throws DAOException;
	
	public abstract List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje, final Integer numPag, final Integer tamPag) throws DAOException;
	
	/*
	 * public abstract List findByFiltroSinEstadoRetirado(String fechaRedaccion,
	 * Integer idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto,
	 * Integer idUsuario, String usuario, String titulo) throws DAOException;
	 */
	public abstract List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia) throws DAOException;
	
	public abstract int findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto,
	        String lenguaje) throws DAOException;
	
	public abstract List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto,
	        String lenguaje, Integer numPag, Integer tamPag) throws DAOException;
	
	public abstract List findByFiltro(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario)
	        throws DAOException;
	
	public abstract List findByRedactorEstado(String dni) throws DAOException;
	
	public abstract List findByCentro(Integer idCentro) throws DAOException;
	
	public abstract List findByCodigo(String codigo) throws DAOException;
	
	public abstract int findEdictosPendientesValidacionPorCentroCont(List centroProcedencia) throws DAOException;
	
	public abstract List findEdictosPendientesValidacionPorCentro(List centroProcedencia, Integer numPag, Integer tamPag) throws DAOException;
	
	public List findByFechaRetiradaPropuesta(String fechaRetirada) throws DAOException;
	
	public List findByIdEstado(Integer id) throws DAOException;
	
	public List contarEdictosOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List contarEdictosOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List estadisticasCSVOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List estadisticasCSVOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List estadisticasCSVOrganismoExternosFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List estadisticasCSVOrganismosExternosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List contarEdictosOrgExtOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List contarEdictosOrgExtOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws DAOException;
	
	public List findByOrganismo(Integer idOrg) throws DAOException;
	
	public List edictoConFirmaPosteriorA(Date fecha, Integer numPag, Integer tamPag) throws DAOException;
	
	public int edictoConFirmaPosteriorACount(Date fecha) throws DAOException;
}