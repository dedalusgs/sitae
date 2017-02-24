package es.novasoft.sitae.perfiles.adminLocal.visualizarUsuariosFirmantes.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.UsuarioVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.visualizarUsuariosFirmantes.forms.VisualizarUsuariosFirmantesForm;

public class VisualizarUsuariosFirmantesFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			VisualizarUsuariosFirmantesForm formulario = (VisualizarUsuariosFirmantesForm) form;
			formulario = rellenaFormulario(formulario, ciudadano, request);
			request.setAttribute("listaUsuariosFirmantes", formulario
					.getListaUsuariosFirmantes());
			request.setAttribute("VisualizarUsuariosFirmantesForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarUsuariosFirmantesFrontAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarUsuariosFirmantesForm rellenaFormulario(
			VisualizarUsuariosFirmantesForm formulario,
			UsuarioAutentificado usuario, HttpServletRequest request)
			throws Exception {

		UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
				.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		String cif = (String) request.getSession().getAttribute("cif");
		List<UsuarioFirmante> listaUsuariosFirmantes = new ArrayList<UsuarioFirmante>();
		List<UsuarioVisualizar> listaUsuariosVisualizar = new ArrayList<UsuarioVisualizar>();

		Organismo organismo = null;

		List<Organismo> organismos = organismoService.findByCif(cif);
		if (!organismos.isEmpty()) {
			organismo = (Organismo) organismos.get(0);
		}
		if (organismo != null) {

			// Obtener página
			String parametroTabla = request.getParameter((new ParamEncoder(
					"nuevaListaUsuariosFirmantes")
					.encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
			int paginaActual = 1;
			if (parametroTabla != null) {
				paginaActual = (Integer.parseInt(parametroTabla));
			}

			// Contar el total de elementos
			int totalUsuariosFirmantes = usuarioFirmanteService
					.findByFilterCont(organismo.getIdOrg(), formulario
							.getNombre(), formulario.getNif());

			// Incorporar el total de elementos a la request para poder
			// recuperarlo en la JSP
			request.setAttribute("totalTablaUsuariosFirmantes",
					totalUsuariosFirmantes);

			// Obtener el listado de elementos de BBDD específicos para la
			// página;
			listaUsuariosFirmantes = usuarioFirmanteService.findByFilter(
					organismo.getIdOrg(), formulario.getNombre(), formulario
							.getNif(), paginaActual, 10);

			Iterator iterator = listaUsuariosFirmantes.iterator();
			while (iterator.hasNext()) {
				UsuarioFirmante usuarioFirmante = (UsuarioFirmante) iterator
						.next();
				UsuarioVisualizar usuarioVisualizar = new UsuarioVisualizar();
				usuarioVisualizar.setNombreUsuario(usuarioFirmante.getNombre()
						+ " " + usuarioFirmante.getApellido1() + " "
						+ usuarioFirmante.getApellido2());
				usuarioVisualizar.setNumDocumento(usuarioFirmante
						.getNumDocumento());
				usuarioVisualizar.setCargo(usuarioFirmante.getCargo());
				listaUsuariosVisualizar.add(usuarioVisualizar);
			}
		}
		formulario.setListaUsuariosFirmantes(listaUsuariosVisualizar);

		return formulario;
	}

}
