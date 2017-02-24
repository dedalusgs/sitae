package es.novasoft.sitae.perfiles.adminLocal.crearUsuariosFirmantes.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.crearUsuariosFirmantes.forms.CrearUsuariosFirmantesForm;

public class CrearUsuariosFirmantesFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			UsuarioAutentificado ciudadano = null;
			List<Organismo> listaOrganismo = new ArrayList();

			CrearUsuariosFirmantesForm formulario = (CrearUsuariosFirmantesForm) form;

			if (request.getAttribute("numeroErrores") == null) {
				rellenaFormulario(formulario, ciudadano, request);
				formulario.getUsuarioFirmante().setNombre("");
				formulario.getUsuarioFirmante().setApellido1("");
				formulario.getUsuarioFirmante().setApellido2("");
				formulario.getUsuarioFirmante().setCargo("");
				formulario.setDesactivarCampos(true);

			}

			request.setAttribute("CrearUsuariosFirmantesForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en CrearUsuariosFirmantesForm", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

	public CrearUsuariosFirmantesForm rellenaFormulario(
			CrearUsuariosFirmantesForm formulario,
			UsuarioAutentificado usuario, HttpServletRequest request)
			throws Exception {

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		String cif = (String) request.getSession().getAttribute("cif");

		formulario.setCif(cif);

		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);

		formulario.getUsuarioFirmante().setOrganismo(organismo);

		return formulario;

	}

}
