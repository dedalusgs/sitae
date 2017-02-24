package es.novasoft.sitae.perfiles.adminLocal.modificarUsuariosFirmantes.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.perfiles.adminLocal.modificarUsuariosFirmantes.forms.ModificarUsuariosFirmantesForm;

public class ModificarUsuariosFirmantesDoAction extends ActionBase {

	UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
			.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UsuarioFirmante usuarioFirmante = new UsuarioFirmante();
		ModificarUsuariosFirmantesForm formulario = (ModificarUsuariosFirmantesForm) form;

		String f = ActionBase.ERROR_KEY;

		try {
			usuarioFirmante = formulario.getUsuarioFirmante();
			usuarioFirmanteService.attachDirty(usuarioFirmante);
			f = ActionBase.SUCCESS_KEY;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarUsuariosFirmantesDoAction", e);
			return forward(request, mapping, f);
		}

		return forward(request, mapping, f);
	}
}
