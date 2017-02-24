package es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionOrganismo.actions;

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
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionOrganismo.forms.MuestraInformacionOrganismoForm;

public class MuestraInformacionOrganismoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			UsuarioService usuarioService = (UsuarioService) Factory
					.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
					.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

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

			MuestraInformacionOrganismoForm formulario = (MuestraInformacionOrganismoForm) form;

			String id = (String) request.getParameter("idOrganismoSelecionado");
			Organismo organismo = new Organismo();

			if (id != null && !id.equals("")) {
				organismo = organismoService.findById(Integer.valueOf(id));
			}

			List listaRelUsuOrg = relacionUsuOrgCentroPerfService
					.findByCif(organismo.getCif());

			Usuario usuario = new Usuario();

			List listaUsuarios = new ArrayList<Usuario>();

			Iterator it = listaRelUsuOrg.iterator();

			while (it.hasNext()) {

				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
						.next();

				// Compruebo que sea administrador local
				if (relacionUsuOrgCentroPerf.getPerfil().getIdPerfil() == Constantes.ADMIN_LOCAL) {

					String dni = relacionUsuOrgCentroPerf.getUsuario();
					Usuario usu = (Usuario) usuarioService
							.findByNumeroDocumento(dni).get(0);
					// Compruebo que ese usuario no está ya metido en la lista
					Iterator it4 = listaUsuarios.iterator();
					boolean enc = false;

					while (it4.hasNext() && enc == false) {

						Usuario usu2 = (Usuario) it4.next();
						if (usu.getNumDocumento()
								.equals(usu2.getNumDocumento())) {
							enc = true;
						}
					}

					if (enc == false) {
						listaUsuarios.add(usu);
					}

				}

			}
			formulario.setListaTemas(RellenaFormularioActionUtil
					.rellenarTemas());
			request.getSession().setAttribute("listaTemas",
					formulario.getListaTemas());
			formulario.setOrganismo(organismo);
			formulario.setListaUsuarios(listaUsuarios);
			request.setAttribute("listaUsuarios", listaUsuarios);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
