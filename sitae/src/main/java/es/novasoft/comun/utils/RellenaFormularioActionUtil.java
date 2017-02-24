package es.novasoft.comun.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.objects.TipoFirma;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.business.services.interfaz.TipoFirmaService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;

public class RellenaFormularioActionUtil {
	
	private static Log	log	= LogFactory.getLog(RellenaFormularioActionUtil.class);
	
	public static List<TipoEdicto> RellenaTiposEdictos(String cif) throws DAOException, ServiceException {
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
		List organismos = organismoService.findByCif(cif);
		Organismo organismo = null;
		if (!organismos.isEmpty()) {
			organismo = (Organismo) organismoService.findByCif(cif).get(0);
		}
		List listaTiposEdictos = new ArrayList();
		if (organismo != null) {
			listaTiposEdictos = tipoEdictoService.findByIdOrg(organismo.getIdOrg());
		}
		return listaTiposEdictos;
		
	}
	
	public static List<OrganismoExterno> RellenaOrganismosExternos() throws DAOException, ServiceException {
		
		OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
		List organismosExternos = organismoExternoService.findAll();
		return organismosExternos;
		
	}
	
	public static List<Perfil> RellenaPerfilesUsuarioAdmLocal() throws DAOException, ServiceException {
		
		PerfilService perfilService = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		
		List perfilesFiltrados = new ArrayList();
		List todosPerfiles = perfilService.findAll();
		Iterator iterator = todosPerfiles.iterator();
		
		while (iterator.hasNext()) {
			Perfil perfil = (Perfil) iterator.next();
			
			if ((perfil.getIdPerfil().intValue() != Constantes.ADMIN_GLOBAL) && (perfil.getIdPerfil().intValue() != Constantes.ADMIN_LOCAL)) {
				perfilesFiltrados.add(perfil);
			}
			
		}
		
		return perfilesFiltrados;
		
	}
	
	public static List<CentroProcedencia> RellenaCentrosProcedencia(String cif) throws DAOException, ServiceException {
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		List organismos = new ArrayList();
		organismos = organismoService.findByCif(cif);
		Organismo organismo = null;
		if (!organismos.isEmpty()) {
			organismo = (Organismo) organismos.get(0);
		}
		List listaCentros = new ArrayList();
		if (organismo != null) {
			listaCentros = centroProcedenciaService.findAll();
		}
		return listaCentros;
	}
	
	public static List<CentroProcedencia> RellenaCentrosProcedenciaPorUsuario(String cif, String dni) throws DAOException, ServiceException {
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		List listaCentros = new ArrayList();
		
		List relacion = relacionUsuOrgCentroPerfService.findByOrgUsuPerf(cif, dni, Integer.toOctalString(Constantes.PUBLICADOR));
		Iterator it = relacion.iterator();
		
		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
			listaCentros.add(relacionUsuOrgCentroPerf.getCentroProcedencia());
		}
		return listaCentros;
	}
	
	public static List<Estado> RellenaEstados() throws DAOException, ServiceException {
		
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		
		List listaCentros = estadoService.findAll();
		
		return listaCentros;
	}
	
	public static List<Estado> RellenaEstadosSinRetirado() throws DAOException, ServiceException {
		
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		
		List listaEstados = estadoService.findAll();
		
		Iterator it = listaEstados.iterator();
		
		int i = 0;
		int pos = 0;
		
		while (it.hasNext()) {
			
			Estado estado = (Estado) it.next();
			if (estado.getIdEstado() == (Constantes.RETIRADO)) {
				pos = i;
			}
			i++;
		}
		
		listaEstados.remove(pos);
		
		return listaEstados;
	}
	
	public static List<Estado> RellenaEstadosSinIniciadoYSinRetiradoPenVal() throws DAOException, ServiceException {
		
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		
		List listaEstados = estadoService.findAll();
		
		Iterator it = listaEstados.iterator();
		
		int i = 0;
		int posRetirado = 0;
		int posIniciado = 0;
		int posPenVal = 0;
		
		while (it.hasNext()) {
			
			Estado estado = (Estado) it.next();
			if (estado.getIdEstado() == (Constantes.INICIADO)) {
				posIniciado = i;
			}
			if (estado.getIdEstado() == (Constantes.PENDIENTE_VALIDACION)) {
				posPenVal = i;
			}
			if (estado.getIdEstado() == (Constantes.RETIRADO)) {
				posRetirado = i;
			}
			i++;
		}
		listaEstados.remove(posRetirado);
		listaEstados.remove(posPenVal);
		listaEstados.remove(posIniciado);
		
		return listaEstados;
	}
	
	public static List<TipoFirma> RellenaTiposFirma() throws DAOException, ServiceException {
		
		TipoFirmaService tipoFirmaService = (TipoFirmaService) Factory.getBean(ServiceConstants.TIPO_FIRMA_BEAN_NAME);
		
		List listaTiposFirma = tipoFirmaService.findAll();
		
		return listaTiposFirma;
		
	}
	
	public static List<UsuarioFirmante> RellenalistaFirmantes(String cif) throws DAOException, ServiceException {
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
		List organismos = new ArrayList();
		organismos = organismoService.findByCif(cif);
		Organismo organismo = null;
		if (!organismos.isEmpty()) {
			organismo = (Organismo) organismos.get(0);
		}
		List listaFirmantes = new ArrayList();
		if (organismo != null) {
			listaFirmantes = usuarioFirmanteService.findByIdOrg(organismo.getIdOrg());
		}
		
		return listaFirmantes;
	}
	
	public static String eliminarCaracteresInvalidosQuery(String cadena) {
		String cadenaSinComillas = "";
		cadenaSinComillas = cadena.replaceAll("\\'", "\\\\\'");
		// cadenaSinComillas = cadenaSinComillas.replaceAll("\"", "\\"");
		cadenaSinComillas = cadenaSinComillas.trim();
		return cadenaSinComillas;
	}
	
	public static List<Edicto> buscadorDescripcion(List listaEdictos, String texto) throws DAOException, ServiceException {
		
		List nuevaListaEdictos = new ArrayList<Edicto>();
		String palabra = "";
		String token = "";
		int i;
		// Uso de la clase StringTokenizer
		
		Iterator it = listaEdictos.iterator();
		while (it.hasNext()) {
			
			StringTokenizer busca = new StringTokenizer(texto, "\"'!¡., \t\n()[]?¿-_@");
			int numPalabras = busca.countTokens();
			i = 0;
			Edicto edicto = (Edicto) it.next();
			
			while (busca.hasMoreTokens() != false) {
				
				String palabrilla = busca.nextToken();
				
				if (edicto.getDescripcion().toLowerCase().contains(palabrilla.toLowerCase()) == true) {
					i++;
				}
				
			}
			
			if (i == numPalabras) {
				nuevaListaEdictos.add(edicto);
			}
		}
		
		return nuevaListaEdictos;
		
	}
	
	public static List<Edicto> buscador(List listaEdictos, String texto) throws DAOException, ServiceException {
		
		List nuevaListaEdictos = new ArrayList<Edicto>();
		String palabra = "";
		String token = "";
		int i;
		// Uso de la clase StringTokenizer
		
		Iterator it = listaEdictos.iterator();
		while (it.hasNext()) {
			
			StringTokenizer busca = new StringTokenizer(texto, "\"'!¡., \t\n()[]?¿-_@");
			int numPalabras = busca.countTokens();
			i = 0;
			Edicto edicto = (Edicto) it.next();
			
			while (busca.hasMoreTokens() != false) {
				
				String palabrilla = busca.nextToken();
				
				if (edicto.getTitulo().toLowerCase().contains(palabrilla.toLowerCase()) == true) {
					i++;
				}
				
			}
			
			if (i == numPalabras) {
				nuevaListaEdictos.add(edicto);
			}
		}
		
		return nuevaListaEdictos;
		
	}
	
	public static List<TemaVisualizar> rellenarTemas() {
		List listaTemas = new ArrayList();
		TemaVisualizar temaVisualizar = new TemaVisualizar();
		temaVisualizar.setId(1);
		temaVisualizar.setNombre("Verde");
		listaTemas.add(temaVisualizar);
		temaVisualizar = new TemaVisualizar();
		temaVisualizar.setId(2);
		temaVisualizar.setNombre("Azul");
		listaTemas.add(temaVisualizar);
		temaVisualizar = new TemaVisualizar();
		temaVisualizar.setId(3);
		temaVisualizar.setNombre("Naranja");
		listaTemas.add(temaVisualizar);
		return listaTemas;
	}
	
	public static List<UsuarioVisualizar> buscadorNombreCompletoUsuario(List listaUsuario, String texto) throws DAOException, ServiceException {
		
		List nuevaListaUsuarios = new ArrayList<UsuarioVisualizar>();
		String palabra = "";
		String token = "";
		int i;
		// Uso de la clase StringTokenizer
		
		Iterator it = listaUsuario.iterator();
		while (it.hasNext()) {
			
			StringTokenizer busca = new StringTokenizer(texto, "\"'!¡., \t\n()[]?¿-_@");
			int numPalabras = busca.countTokens();
			i = 0;
			UsuarioVisualizar usuarioVisualizar = (UsuarioVisualizar) it.next();
			
			while (busca.hasMoreTokens() != false) {
				
				String palabrilla = busca.nextToken();
				if (usuarioVisualizar.getNombreUsuario().toLowerCase().contains(palabrilla.toLowerCase()) == true) {
					i++;
				}
				
			}
			
			if (i == numPalabras) {
				nuevaListaUsuarios.add(usuarioVisualizar);
			}
		}
		
		return nuevaListaUsuarios;
		
	}
	
	public static List<UsuarioVisualizar> buscadorNifUsuario(List listaUsuario, String texto) throws DAOException, ServiceException {
		
		List nuevaListaUsuarios = new ArrayList<UsuarioVisualizar>();
		String palabra = "";
		String token = "";
		int i;
		// Uso de la clase StringTokenizer
		
		Iterator it = listaUsuario.iterator();
		while (it.hasNext()) {
			
			StringTokenizer busca = new StringTokenizer(texto, "\"'!¡., \t\n()[]?¿-_@");
			int numPalabras = busca.countTokens();
			i = 0;
			UsuarioVisualizar usuarioVisualizar = (UsuarioVisualizar) it.next();
			
			while (busca.hasMoreTokens() != false) {
				
				String palabrilla = busca.nextToken();
				if (usuarioVisualizar.getNumDocumento().toLowerCase().contains(palabrilla.toLowerCase()) == true) {
					i++;
				}
				
			}
			
			if (i == numPalabras) {
				nuevaListaUsuarios.add(usuarioVisualizar);
			}
		}
		
		return nuevaListaUsuarios;
		
	}
	
	public static List<UsuarioFirmante> RellenalistaFirmantesNombres(List<UsuarioFirmante> listaFirmantes) {
		// TODO Auto-generated method stub
		List<UsuarioFirmante> retlist = new ArrayList<UsuarioFirmante>();
		for (UsuarioFirmante usufir : listaFirmantes) {
			usufir.setNombre(usufir.getNombre() + " " + usufir.getApellido1() + " - " + usufir.getCargo());
			retlist.add(usufir);
		}
		return retlist;
	}
	
	public static String rellenaPropertiesStamp(Edicto edicto) {
		// TODO Auto-generated method stub
		String returnString = "";
		returnString = returnString.concat("tituloEntidad_es = " + edicto.getOrganismo().getNombre() + "\n");
		returnString = returnString.concat("entidadLocal = " + edicto.getOrganismo().getCodigo() + "\n");
		returnString = returnString.concat("endpoint5 = " + Constantes.getPropiedad("endpoint5") + "\n");
		returnString = returnString.concat("timeout5 = " + Constantes.getPropiedad("timeout5") + "\n");
		returnString = returnString.concat("idAplicacion5  = " + Constantes.getPropiedad("idAplicacion5") + "\n");
		
		return returnString;
	}
	
	public static List buscadorNifUsuarioOrganismo(List listaAdminLocal, String nif) {
		List nuevaListaUsuarios = new ArrayList<UsuarioVisualizar>();
		String palabra = "";
		String token = "";
		int i;
		// Uso de la clase StringTokenizer
		
		Iterator it = listaAdminLocal.iterator();
		while (it.hasNext()) {
			
			StringTokenizer busca = new StringTokenizer(nif, "\"'!¡., \t\n()[]?¿-_@");
			int numPalabras = busca.countTokens();
			i = 0;
			ObjetoUsuarioOrganismo usuarioVisualizar = (ObjetoUsuarioOrganismo) it.next();
			
			while (busca.hasMoreTokens() != false) {
				
				String palabrilla = busca.nextToken();
				if (usuarioVisualizar.getNumDocumento().toLowerCase().contains(palabrilla.toLowerCase()) == true) {
					i++;
				}
				
			}
			
			if (i == numPalabras) {
				nuevaListaUsuarios.add(usuarioVisualizar);
			}
		}
		
		return nuevaListaUsuarios;
	}
	
}
