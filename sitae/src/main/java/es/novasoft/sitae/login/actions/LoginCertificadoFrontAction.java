package es.novasoft.sitae.login.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
import es.novasoft.sitae.business.objects.RelPerfFunc;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.RelPerfFuncService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.forms.LoginCertificadoForm;

public class LoginCertificadoFrontAction extends ActionBase {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

		LoginCertificadoForm formulario = (LoginCertificadoForm) form;
        
		String puerta=Constantes.getPropiedad(Constantes.PUERTA_TRASERA);
		String dni=null;
		if (puerta.equalsIgnoreCase(Constantes.S)){
			dni = request.getParameter("nif");
			if (dni != null && !dni.equals("")) {
				request.getSession().setAttribute("nif", dni);
			} else {
				dni = (String) request.getSession().getAttribute("nif");
			}
		}else{
			dni = (String) request.getSession().getAttribute("nif");
		}
		Usuario usuario = new Usuario();

		if (!isRegistrado(dni)) {
			return mapping.findForward(Constantes.FAILURE);

		} else {
			usuario = (Usuario) usuarioService.findByNumeroDocumento(dni)
					.get(0);
			
			formulario.setUsuario(usuario);
			
			String cif = (String) request.getSession().getAttribute("cif");

			boolean esAdministradorGlobal = esAdministradorGlobal(usuario);
			formulario.setAdministradorGlobal(esAdministradorGlobal);

			RelPerfFuncService relPerfFuncService = (RelPerfFuncService) Factory
					.getBean(ServiceConstants.REL_PERF_FUNC_BEAN_NAME);
			List funcialidades = relPerfFuncService.findAll();

			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
					.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			List listaRelacionUsuOrgPerf = new ArrayList<RelacionUsuOrgCentroPerf>();
			listaRelacionUsuOrgPerf = relacionUsuOrgCentroPerfService
					.findByCifDni(cif, usuario.getNumDocumento());

			boolean esAdministradorLocal = esAdministradorLocal(listaRelacionUsuOrgPerf);

			if (esAdministradorGlobal) {
				List funcionalidadesAdministradorGlobal = filtrarFuncionalidades(
						funcialidades, Constantes.ADMIN_GLOBAL);
				formulario
						.setFuncionalidadesAdministradorGlobal(funcionalidadesAdministradorGlobal);
			}

			if (esAdministradorLocal) {
				formulario.setAdministradorLocal(esAdministradorLocal);
				List funcionalidadesAdministradorLocal = filtrarFuncionalidades(
						funcialidades, Constantes.ADMIN_LOCAL);
				formulario
						.setFuncionalidadesAdministradorLocal(funcionalidadesAdministradorLocal);
			} else {
				boolean esPublicador = esPublicador(listaRelacionUsuOrgPerf);
				if (esPublicador) {
					formulario.setPublicador(esPublicador);
					List funcionalidadesPublicador = filtrarFuncionalidades(
							funcialidades, Constantes.PUBLICADOR);
					formulario
							.setFuncionalidadesPublicador(funcionalidadesPublicador);
				} else {
					boolean esRedactor = esRedactor(listaRelacionUsuOrgPerf);
					if (esRedactor) {
						formulario.setRedactor(esRedactor);
						List funcionalidadesRedactor = filtrarFuncionalidades(
								funcialidades, Constantes.REDACTOR);
						formulario
								.setFuncionalidadesRedactor(funcionalidadesRedactor);
					} else {
						if (esAdministradorGlobal == false) {
							return mapping.findForward(Constantes.FAILURE_2);
						}
					}
				}
			}
			formulario.setRegistrado(true);
			StringBuffer nombreCompleto = new StringBuffer();
			if (usuario.getNombre() != null && !usuario.getNombre().equals("")) {
				nombreCompleto.append(usuario.getNombre());
				nombreCompleto.append(" ");
			}
			if (usuario.getApellido1() != null
					&& !usuario.getApellido1().equals("")) {
				nombreCompleto.append(usuario.getApellido1());
				nombreCompleto.append(" ");
			}

			if (usuario.getApellido2() != null
					&& !usuario.getApellido2().equals("")) {
				nombreCompleto.append(usuario.getApellido2());
				nombreCompleto.append(" ");
			}
			if (nombreCompleto != null) {
				formulario.setNombreUsuario(nombreCompleto.toString());
			} else {
				formulario.setNombreUsuario("");
			}
		}

		request.getSession().setAttribute("LoginCertificadoForm", formulario);

		// ENVIAMOS A JSP EN EL QUE MOSTRAMOS EL USUARIO, PERFILES Y
		// ORGANIZACION PARA QUE ELIJA LA OPCION ADECUADA

		/*
		 * if(usuarioAutenticado(request)){
		 * 
		 * //COMPRUEBO SI EL USUARIO CON CERTIFICADO ESTA EN NUESTRA BBDD //AQUI
		 * SE COMPRUEBA EN CASO DE QUE EL NAVEGADOR ESTE ABIERTO CON SESION
		 * GUARDADA
		 * 
		 * try{ UsuarioAutentificado ciudadano = obtenerUsuario(request); if
		 * (!isRegistradoBBDD(ciudadano)){ return
		 * mapping.findForward(ActionBase.ALTA_USER); }
		 * 
		 * }catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); LOGGER.error("Error en
		 * LoginCertificadoFront",e); return forward(request, mapping,
		 * ActionBase.ERROR_KEY); } return mapping.findForward(redireccionar); }
		 * 
		 * 
		 * String sessionID = session.getId(); LOGGER.debug(sessionID + "Id
		 * sesion antes de llamar @FIRMA"); String servidor_firma_fachada =
		 * ConstantesFirma.getPropiedad(ConstantesFirma.CERTIFICADO_IP_SERVIDOR);
		 * String id_aplicacion =
		 * ConstantesFirma.getPropiedad(ConstantesFirma.CERTIFICADO_ID_AUTENTICACION_FIRMA);
		 *  // Esta es la direcciÓn String url_firma =
		 * ConstantesFirma.getPropiedad(ConstantesFirma.URL_FIRMA); String https =
		 * "https://" + servidor_firma_fachada + url_firma + id_aplicacion +
		 * "&sesion=" + sessionID; try { response.sendRedirect(https);
		 *  } catch (Exception e) { LOGGER.debug("Exception en
		 * LoginCertificadoFrontAction : " + e.getMessage());
		 * e.printStackTrace(); return
		 * mapping.findForward(ActionBase.ERROR_KEY); }
		 * LOGGER.debug(ConstantesFirma.FIN_METODO); //REALIZADO COMPROBACION
		 * DEL CERTIFICADO LLEGA CORRECTAMENTE Utils util = new Utils(); if
		 * (!util.usuarioAutenticado(request)){ return
		 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		 *  }
		 */

		return mapping.findForward(Constantes.PANTALLA_INICIO);

	}

	private boolean isRegistrado(String nif) {

		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		List<Usuario> usuarios = new LinkedList<Usuario>();
		try {
			usuarios = usuarioService.findByNumeroDocumento(nif);
			if (!usuarios.isEmpty()) {
				return true;
			} else {
				return false;
			}

		} catch (ServiceException e) {
			LOGGER
					.error("Se ha producido un error al recuperar datos de la BBDD");
			LOGGER.error(e.getCause());
			return false;
		} catch (Exception e) {
			LOGGER
					.error("Se ha producido un error al recuperar datos de la BBDD");
			LOGGER.error(e.getCause());
			return false;
		}
	}

	private boolean esAdministradorGlobal(Usuario usuario) throws ServiceException {
		boolean esAdministradorGlobal = false;
		List listaRelacionUsuOrgPerf = new ArrayList<RelacionUsuOrgCentroPerf>();
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		listaRelacionUsuOrgPerf = relacionUsuOrgCentroPerfService
				.findByUsuPerf(usuario.getNumDocumento(), String
						.valueOf(Constantes.ADMIN_GLOBAL));
		if (!listaRelacionUsuOrgPerf.isEmpty()) {
			esAdministradorGlobal = true;
		}
		return esAdministradorGlobal;
	}

	private boolean esAdministradorLocal(List listaRelaciones) {
		boolean esAdministradorLocal = false;
		Iterator it = listaRelaciones.iterator();
		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
					.next();
			if (relacionUsuOrgCentroPerf.getPerfil().getIdPerfil() == Constantes.ADMIN_LOCAL) {
				esAdministradorLocal = true;
				break;
			}
		}
		return esAdministradorLocal;
	}

	private boolean esPublicador(List listaRelaciones) {
		boolean esPublicador = false;
		Iterator it = listaRelaciones.iterator();
		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
					.next();
			if (relacionUsuOrgCentroPerf.getPerfil().getIdPerfil() == Constantes.PUBLICADOR) {
				esPublicador = true;
				break;
			}
		}
		return esPublicador;
	}

	private boolean esRedactor(List listaRelaciones) {
		boolean esRedactor = false;
		Iterator it = listaRelaciones.iterator();
		while (it.hasNext()) {
			RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
					.next();
			if (relacionUsuOrgCentroPerf.getPerfil().getIdPerfil() == Constantes.REDACTOR) {
				esRedactor = true;
				break;
			}
		}
		return esRedactor;
	}

	private List filtrarFuncionalidades(List listaFuncionalidades, int id) {
		Integer idPerfil = new Integer(id);
		List funcionalidadesFiltradas = new ArrayList();
		Iterator it = listaFuncionalidades.iterator();
		while (it.hasNext()) {
			RelPerfFunc relPerfFunc = (RelPerfFunc) it.next();
			Integer kk = relPerfFunc.getPerfil().getIdPerfil();
			if (relPerfFunc.getPerfil().getIdPerfil().equals(idPerfil)) {
				funcionalidadesFiltradas.add(relPerfFunc);
			}
		}
		return funcionalidadesFiltradas;
	}

}
