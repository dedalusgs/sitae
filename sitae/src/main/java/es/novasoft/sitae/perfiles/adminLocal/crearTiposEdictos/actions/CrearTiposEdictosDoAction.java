package es.novasoft.sitae.perfiles.adminLocal.crearTiposEdictos.actions;

import java.io.IOException;
import java.sql.Timestamp;

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
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.crearTiposEdictos.forms.CrearTiposEdictosForm;

public class CrearTiposEdictosDoAction extends ActionBase {

	private static Log log = LogFactory.getLog(CrearTiposEdictosDoAction.class);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory
			.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);

	Timestamp fechaDoc = new Timestamp(System.currentTimeMillis());

	UsuarioAutentificado solicitante = null;

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String forward = ActionBase.SUCCESS_KEY;

		try {

			CrearTiposEdictosForm formulario = (CrearTiposEdictosForm) form;

			String cif = (String) request.getSession().getAttribute("cif");

			Organismo organismo = (Organismo) organismoService.findByCif(cif)
					.get(0);

			if (isCancelled(request)) {
				return mapping.findForward("cancel");
			}

			formulario.getTipoEdicto().setOrganismo(organismo);

			tipoEdictoService.save(formulario.getTipoEdicto());

		} catch (Exception ex) {

			ex.printStackTrace();
			log.error("ERROR:" + ex.getMessage());
			log.error("TRAZA:", ex);
			return mapping.findForward(ActionBase.ERROR_KEY);

		} finally {
			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
