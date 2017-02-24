package es.novasoft.sitae.perfiles.adminLocal.visualizarUsuarios.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.visualizarUsuarios.forms.VisualizarUsuariosForm;

public class VisualizarUsuariosFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			VisualizarUsuariosForm formulario = (VisualizarUsuariosForm) form;

			if (request.getParameter("filtrar") == null) {
				formulario = rellenaFormulario(formulario, ciudadano, request);
			} else {
				formulario = filtrar(formulario, ciudadano, request);
			}
			request.setAttribute("nuevaListaUsuariosPublicadoresRedactores",
					formulario.getNuevaListaUsuariosPublicadoresRedactores());
			request.setAttribute("VisualizarUsuariosForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarUsuariosFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarUsuariosForm rellenaFormulario(
			VisualizarUsuariosForm formulario, UsuarioAutentificado usuario,
			HttpServletRequest request) throws Exception {

		List listaPerfiles = RellenaFormularioActionUtil
				.RellenaPerfilesUsuarioAdmLocal();

		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory
				.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		UsuarioExternoService usuarioExternoService = (UsuarioExternoService) Factory
		.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
		
		String cif = (String) request.getSession().getAttribute("cif");

		List listaCentros = RellenaFormularioActionUtil
				.RellenaCentrosProcedencia(cif);
		List listaRelUsuOrgCentroPerfPublicadorRedactor = relacionUsuOrgCentroPerfService
				.findByOrgIncluyendoPerfiles(cif, listaPerfiles);
		List filtradoPublicadoresYPublicadores = new ArrayList();
		Iterator it = listaRelUsuOrgCentroPerfPublicadorRedactor.iterator();

		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
					.next();
			Iterator it2 = filtradoPublicadoresYPublicadores.iterator();
			boolean encontrado = false;
			while (it2.hasNext()) {
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf2 = (RelacionUsuOrgCentroPerf) it2
						.next();
				if (relacionUsuOrgCentroPerf.getUsuario().equals(
						relacionUsuOrgCentroPerf2.getUsuario())) {
					encontrado = true;
				}
			}
			if (encontrado == false) {
				filtradoPublicadoresYPublicadores.add(relacionUsuOrgCentroPerf);
			}
		}

		List listaPublicadoresRedactores = new ArrayList();

		Iterator iterator = filtradoPublicadoresYPublicadores.iterator();

		while (iterator.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf3 = (RelacionUsuOrgCentroPerf) iterator
					.next();

			Usuario usu = (Usuario) usuarioService.findByNumeroDocumento(
					relacionUsuOrgCentroPerf3.getUsuario()).get(0);
			UsuarioVisualizar usuarioVisualizar = new UsuarioVisualizar();
			usuarioVisualizar.setId(relacionUsuOrgCentroPerf3.getIdRelacion());
			usuarioVisualizar.setNombreUsuario(usu.getNombre() + " "
					+ usu.getApellido1() + " " + usu.getApellido2());
			usuarioVisualizar.setEmail(usu.getEmail());
			try {
				usuarioExternoService.findFromUser(usu.getNumDocumento());
				usuarioVisualizar.setInterno(true);
			} catch (ServiceException e){
				usuarioVisualizar.setInterno(false);
			}
			usuarioVisualizar.setNumDocumento(usu.getNumDocumento());
			usuarioVisualizar.setPerfil(relacionUsuOrgCentroPerf3.getPerfil()
					.getNombre());
			listaPublicadoresRedactores.add(usuarioVisualizar);

		}

		formulario.setListaPerfiles(listaPerfiles);
		formulario.setListaCentros(listaCentros);
		formulario
				.setNuevaListaUsuariosPublicadoresRedactores(listaPublicadoresRedactores);

		return formulario;
	}

	public VisualizarUsuariosForm filtrar(VisualizarUsuariosForm formulario,
			UsuarioAutentificado usuario, HttpServletRequest request)
			throws Exception {

		PerfilService perfilService = (PerfilService) Factory
				.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);

		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory
				.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		UsuarioExternoService usuarioExternoService = (UsuarioExternoService) Factory
		.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);
		
		String cif = (String) request.getSession().getAttribute("cif");

		List listaPerfiles = new ArrayList();
		List listaPerfilesFiltro = new ArrayList();
		listaPerfiles = RellenaFormularioActionUtil
				.RellenaPerfilesUsuarioAdmLocal();

		List listaCentros = RellenaFormularioActionUtil
				.RellenaCentrosProcedencia(cif);

		CentroProcedencia centroFiltro = null;
		if (formulario.getOpcionCentros() != -1) {
			centroFiltro = centroProcedenciaService.findById(formulario
					.getOpcionCentros());
		}
		if (formulario.getOpcionPerfiles() == -1) {
			listaPerfilesFiltro = RellenaFormularioActionUtil
					.RellenaPerfilesUsuarioAdmLocal();
		} else {
			if (formulario.getOpcionPerfiles() == Constantes.REDACTOR) {
				Perfil perfil = perfilService.findById(new Integer(
						Constantes.REDACTOR));
				listaPerfilesFiltro.add(perfil);
			} else {
				if (formulario.getOpcionPerfiles() == Constantes.PUBLICADOR) {
					Perfil perfil = perfilService.findById(new Integer(
							Constantes.PUBLICADOR));
					listaPerfilesFiltro.add(perfil);
				}
			}
		}

		if (formulario.getOpcionPerfiles() == -1) {
			listaPerfilesFiltro = RellenaFormularioActionUtil
					.RellenaPerfilesUsuarioAdmLocal();
		}
		// List listaRelUsuOrgCentroPerfPublicadorRedactor =
		// relacionUsuOrgCentroPerfService.findByOrgNifIncluyendoPerfiles(cif,
		// formulario.getNif() ,listaPerfilesFiltro);

		List listaRelUsuOrgCentroPerfPublicadorRedactor = relacionUsuOrgCentroPerfService
				.findByOrgNifIncluyendoPerfiles(cif, null, listaPerfilesFiltro);

		List filtradoPublicadoresYPublicadores = new ArrayList();
		Iterator it = listaRelUsuOrgCentroPerfPublicadorRedactor.iterator();

		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
					.next();

			boolean filtradoCentro = false;
			if (centroFiltro != null) {
				filtradoCentro = true;
				if (relacionUsuOrgCentroPerf.getCentroProcedencia() != null) {
					if (relacionUsuOrgCentroPerf.getCentroProcedencia()
							.getIdCentro() != null) {
							System.out.println("CentroProcedencia : " + relacionUsuOrgCentroPerf.getCentroProcedencia()
							.getIdCentro());
							System.out.println("Centro Filtro : " + centroFiltro.getIdCentro());
						if (relacionUsuOrgCentroPerf.getCentroProcedencia()
								.getIdCentro().equals(
										centroFiltro.getIdCentro())) {
							filtradoCentro = false;
						}
					}
				}
			}
			if (!filtradoCentro) {
				Iterator it2 = filtradoPublicadoresYPublicadores.iterator();
				boolean encontrado = false;
				while (it2.hasNext()) {
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf2 = (RelacionUsuOrgCentroPerf) it2
							.next();

					if (relacionUsuOrgCentroPerf.getUsuario().equals(
							relacionUsuOrgCentroPerf2.getUsuario())) {
						encontrado = true;
					}
				}
				if (encontrado == false) {
					filtradoPublicadoresYPublicadores
							.add(relacionUsuOrgCentroPerf);
					System.out.println("Metido user");
				}
			}
		}

		List listaPublicadoresRedactores = new ArrayList();

		// Rellenamos la lista de Publicadores y Redactores

		Iterator iterator = filtradoPublicadoresYPublicadores.iterator();

		while (iterator.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf3 = (RelacionUsuOrgCentroPerf) iterator
					.next();

			Usuario usu = (Usuario) usuarioService.findByNumeroDocumento(
					relacionUsuOrgCentroPerf3.getUsuario()).get(0);
			UsuarioVisualizar usuarioVisualizar = new UsuarioVisualizar();
			usuarioVisualizar.setId(relacionUsuOrgCentroPerf3.getIdRelacion());
			usuarioVisualizar.setNombreUsuario(usu.getNombre() + " "
					+ usu.getApellido1() + " " + usu.getApellido2());
			usuarioVisualizar.setEmail(usu.getEmail());
			usuarioVisualizar.setNumDocumento(usu.getNumDocumento());
			usuarioVisualizar.setPerfil(relacionUsuOrgCentroPerf3.getPerfil()
					.getNombre());
			try {
				usuarioExternoService.findFromUser(usu.getNumDocumento());
				usuarioVisualizar.setInterno(true);
			} catch (ServiceException e){
				usuarioVisualizar.setInterno(false);
			}
			listaPublicadoresRedactores.add(usuarioVisualizar);

		}

		if (!formulario.getNombre().equals("")) {
			listaPublicadoresRedactores = RellenaFormularioActionUtil
					.buscadorNombreCompletoUsuario(listaPublicadoresRedactores,
							formulario.getNombre());
		}
		if (!formulario.getNif().equals("")) {
			listaPublicadoresRedactores = RellenaFormularioActionUtil
					.buscadorNifUsuario(listaPublicadoresRedactores, formulario
							.getNif());
		}

		formulario.setListaPerfiles(listaPerfiles);
		formulario
				.setNuevaListaUsuariosPublicadoresRedactores(listaPublicadoresRedactores);

		return formulario;

	}
}
