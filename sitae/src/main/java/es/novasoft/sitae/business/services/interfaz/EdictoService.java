package es.novasoft.sitae.business.services.interfaz;

import java.util.Date;
import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;

public interface EdictoService {
	
	public void save(Edicto transientInstance) throws ServiceException;
	
	public void delete(Edicto persistentInstance) throws ServiceException;
	
	public Edicto findById(Integer id) throws ServiceException;
	
	public List findByExample(Edicto instance) throws ServiceException;
	
	public List findByProperty(String propertyName, Object value) throws ServiceException;
	
	public List findByNombre(Object nombre) throws ServiceException;
	
	public List findAll() throws ServiceException;
	
	public Edicto merge(Edicto detachedInstance) throws ServiceException;
	
	public void attachDirty(Edicto instance) throws ServiceException;
	
	public void attachClean(Edicto instance) throws ServiceException;
	
	public List findByCentroYEstadosExPRYPubORed(Integer idCentro, Integer idUsuario) throws ServiceException;
	
	public List findByCentroUsuarioPerfilYEstadosExPR(Integer idCentro, Integer idUsuario, Integer idPerfil) throws ServiceException;
	
	public List findByOrganismoRedactor(Integer idOrg, Integer idRedactor) throws ServiceException;
	
	public List findByOrganismoRedactorSinPublicar(Integer idOrg, Integer idRedactor) throws ServiceException;
	
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor) throws ServiceException;
	
	public List findByOrganismoRedactorSinEstadoHistorico(Integer idOrg, Integer idRedactor, Integer posIni, Integer maxElem) throws ServiceException;
	
	public int findByOrganismoRedactorSinEstadoHistoricoCount(Integer idOrg, Integer idRedactor) throws ServiceException;
	
	public List findByOrganismoPublicador(Integer idOrg, Integer idPublicador) throws ServiceException;
	
	public List findByCentroPublicadorSinPublicar(Integer idCentro, Integer idPublicador) throws ServiceException;
	
	public int findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedenciaCont(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws ServiceException;
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, int numPag, int tamPag,
	        Organismo organismo) throws ServiceException;
	
	public List findByOrganismoPublicadorSinEstadoHistoricoIniciadoPenValCentrosProcedencia(Integer idPublicador, List centrosProcedencia, Organismo organismo)
	        throws ServiceException;
	
	public List findByOrganismoEstado(Integer idOrg, Integer idSEstado) throws ServiceException;
	
	public int findByOrganismoEstadoOrderFechaPublicacionCount(Integer idOrg, Integer idSEstado, Integer diasCaducidad) throws ServiceException;
	
	public List findByOrganismoEstadoOrderFechaPublicacion(Integer idOrg, Integer idSEstado, int numPag, int tamPag, Integer diasCaducidad) throws ServiceException;
	
	public int findByOrganismoEstadoOrderFechaPublicacionSinRelacionadosCount(Integer idOrg, Integer idSEstado, Integer diasCaducidad, List<Integer> listaRelacionados)
	        throws ServiceException;
	
	public List findByOrganismoEstadoOrderFechaPublicacionSinRelacionados(Integer idOrg, Integer idSEstado, int numPag, int tamPag, Integer diasCaducidad,
	        List<Integer> listaRelacionados) throws ServiceException;
	
	public int findByFiltroPublicoCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String nombre, String descripcion, String contenido, String lenguaje, Boolean historico, Integer diasCaducidad)
	        throws ServiceException;
	
	public List findByFiltroPublico(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String nombre, String descripcion, String contenido, String lenguaje, Boolean historico, int numPag, int tamPag,
	        Integer diasCaducidad) throws ServiceException;
	
	public int findByFiltroPublicoSinRelacionadosCount(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp,
	        String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado, String nombre, String descripcion, String contenido, String lenguaje, Boolean historico,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws ServiceException;
	
	public List findByFiltroPublicoSinRelacionados(Integer idOrg, Integer idTipoEdicto, Integer idCentro, Integer idOrganismoExterno, String numExp, String fechaPublicacionInicio,
	        String fechaPublicacionFin, Integer idEstado, String nombre, String descripcion, String contenido, String lenguaje, Boolean historico, int numPag, int tamPag,
	        Integer diasCaducidad, List<Integer> listaRelacionados) throws ServiceException;
	
	public List findByFiltro(Integer idOrg, Integer idTipoEdicto, Integer idCentro, String fechaPublicacionInicio, String fechaPublicacionFin, Integer idEstado)
	        throws ServiceException;
	
	public List findByFiltro(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario)
	        throws ServiceException;
	
	// public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer
	// idOrg, Integer idCentro, Integer idEstado, Integer idTipoEdicto, Integer
	// idUsuario,String usuario, String titulo) throws ServiceException;
	
	public List findByFiltroSinEstadoRetirado(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje, int numPag, int tamPag) throws ServiceException;
	
	public int findByFiltroSinEstadoRetiradoCount(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado, Integer idTipoEdicto,
	        Integer idUsuario, String usuario, String titulo, String numeroExpediente, String lenguaje) throws ServiceException;
	
	// public List
	// findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String
	// fechaRedaccion, Integer idOrg, Integer idCentro, Integer idEstado,
	// Integer idTipoEdicto, Integer idUsuario,String usuario, List
	// centrosProcedencia) throws ServiceException;
	
	public int findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedenciaCont(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno,
	        Integer idEstado, Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto,
	        String lenguaje) throws ServiceException;
	
	public List findByFiltroSinEstadoRetiradoIniciadoPenValCentrosProcedencia(String fechaRedaccion, Integer idOrg, Integer idCentro, Integer organismoExterno, Integer idEstado,
	        Integer idTipoEdicto, Integer idUsuario, String usuario, List centrosProcedencia, String titulo, String numeroExpediente, String codigoEdicto, String lenguaje,
	        int numPag, int tamPag) throws ServiceException;
	
	public List findByRedactorEstado(String dni) throws ServiceException;
	
	public List findByCentro(Integer idCentro) throws ServiceException;
	
	public List findByCodigo(String codigo) throws ServiceException;
	
	public List findByIdOrganismoExterno(Integer idOrganismoExterno) throws ServiceException;
	
	public int findEdictosPendientesValidacionPorCentroCont(List centrosProcedencia) throws ServiceException;
	
	public List findEdictosPendientesValidacionPorCentro(List centrosProcedencia, int numPag, int tamPag) throws ServiceException;
	
	public List findByFechaRetiradaPropuesta(String fechaRetirada) throws ServiceException;
	
	public List findByIdEstado(Integer idEstado) throws ServiceException;
	
	public void actualizar(Edicto instance) throws ServiceException;
	
	public List contarEdictosOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List contarEdictosOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List estadisticasCSVOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List estadisticasCSVOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List estadisticasCSVOrganismoExternosFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List estadisticasCSVOrganismosExternosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List contarEdictosOrgExtOrganismosFechas(String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public List contarEdictosOrgExtOrganismoFechas(Organismo org, String fechaPublicacionInicio, String fechaPublicacionFin) throws ServiceException;
	
	public byte[] obtenerFicheroAnuncio(Edicto edicto);
	
	public byte[] obtenerFicheroDiligencia(Edicto edicto);
	
	public byte[] obtenerFicheroFirmaDiligencia(Edicto edicto);
	
	public void actualizarRepublicarBorrador(Edicto transientInstance) throws ServiceException;
	
	public List findByOrganismo(Integer idOrg) throws ServiceException;
	
	public List edictoConFirmaPosteriorA(Date fecha, Integer numPag, Integer tamPag) throws ServiceException;
	
	public int edictoConFirmaPosteriorACount(Date fecha) throws ServiceException;
}
