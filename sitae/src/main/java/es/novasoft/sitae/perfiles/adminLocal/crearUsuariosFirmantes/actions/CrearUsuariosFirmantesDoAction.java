package es.novasoft.sitae.perfiles.adminLocal.crearUsuariosFirmantes.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.perfiles.adminLocal.crearUsuariosFirmantes.forms.CrearUsuariosFirmantesForm;

public class CrearUsuariosFirmantesDoAction extends ActionBase {

	private static Log log = LogFactory
			.getLog(CrearUsuariosFirmantesDoAction.class);

	UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
			.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String forward = ActionBase.SUCCESS_KEY;
		String statusBusqueda = (String) request.getSession().getAttribute(
				"statusBusqueda");
		if (statusBusqueda.equals("S")) {
			request.getSession().setAttribute("statusBusqueda", "N");
			return forward(request, mapping, ActionBase.SUCCESS_KEY_2);
		}
		try {
			CrearUsuariosFirmantesForm formulario = (CrearUsuariosFirmantesForm) form;
			usuarioFirmanteService.save(formulario.getUsuarioFirmante());
			request.setAttribute("nifSeleccionado", formulario
					.getUsuarioFirmante().getNumDocumento());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("ERROR:" + ex.getMessage());
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {
			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
