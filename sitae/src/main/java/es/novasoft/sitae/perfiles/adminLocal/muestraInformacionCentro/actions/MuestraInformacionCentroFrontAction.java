package es.novasoft.sitae.perfiles.adminLocal.muestraInformacionCentro.actions;

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
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.RelPerfFunc;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.RelPerfFuncService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.muestraInformacionCentro.forms.MuestraInformacionCentroForm;

public class MuestraInformacionCentroFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			UsuarioService usuarioService = (UsuarioService) Factory
					.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
					.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			CentroProcedenciaService centroService = (CentroProcedenciaService) Factory
					.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
			RelPerfFuncService relPerfFuncService = (RelPerfFuncService) Factory
					.getBean(ServiceConstants.REL_PERF_FUNC_BEAN_NAME);

			UsuarioAutentificado ciudadano = null;

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver"); }
			 * 
			 * LOGGER.debug("INICIO DEL METODO"); //Información que se obtiene
			 * del certificado digital //Se comprueba que se ha accedido de
			 * manera correcta Utils util = new Utils(); if
			 * (!util.usuarioAutenticado(request)){ return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); } else{
			 * //Información que se obtiene del certificado digital ciudadano =
			 * obtenerUsuario(request);
			 * 
			 * if(ciudadano==null) return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			MuestraInformacionCentroForm formulario = (MuestraInformacionCentroForm) form;

			String id = (String) request.getParameter("idCentroSeleccionado");
			CentroProcedencia centro = new CentroProcedencia();

			List listaUsuarios = new ArrayList<Usuario>();

			if (id != null && !id.equals("")) {
				centro = centroService.findById(Integer.valueOf(id));
			}

			// Lista con las funcionalidades
			List listaRelPerfFunc = relPerfFuncService
					.findByIdFuncionalidad(Integer
							.valueOf(Constantes.FUNCIONALIDAD_PUBLICACION));
			Iterator itListaRelPerfFunc = listaRelPerfFunc.iterator();
			while (itListaRelPerfFunc.hasNext()) {
				RelPerfFunc relacionPerfilFuncion = (RelPerfFunc) itListaRelPerfFunc
						.next();
				// Creamos una lista con los elementos de
				// RELACION_USU_ORG_CENTRO_PERF que tengan algun perfil con la
				// funcionalidad requerida
				List listaRelUsuOrg = relacionUsuOrgCentroPerfService
						.findByPerfil(relacionPerfilFuncion.getPerfil()
								.getIdPerfil());
				Iterator itListaRelUsuOrg = listaRelUsuOrg.iterator();
				while (itListaRelUsuOrg.hasNext()) {
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) itListaRelUsuOrg
							.next();
					// comprobamos si pertenece al centro que estamos viendo
					if (relacionUsuOrgCentroPerf.getCentroProcedencia() != null) {
						if (relacionUsuOrgCentroPerf.getCentroProcedencia()
								.getIdCentro().equals(centro.getIdCentro())) {

							String dni = relacionUsuOrgCentroPerf.getUsuario();
							Usuario usu = (Usuario) usuarioService
									.findByNumeroDocumento(dni).get(0);
							// Compruebo que ese usuario no está ya metido en
							// la lista
							Iterator it4 = listaUsuarios.iterator();
							boolean enc = false;

							while (it4.hasNext() && enc == false) {

								Usuario usu2 = (Usuario) it4.next();
								if (usu.getNumDocumento().equals(
										usu2.getNumDocumento())) {
									enc = true;
								}
							}

							if (enc == false) {
								listaUsuarios.add(usu);
							}
						}
					}
				}// fin while bucle de recorrido de REL_USU_ORG_CENTRO_PERF
			}// fin while bucle de recorrido de las funcionalidades

			formulario.setCentro(centro);
			formulario.setListaUsuarios(listaUsuarios);
			request.setAttribute("listaUsuarios", listaUsuarios);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionCentroFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
