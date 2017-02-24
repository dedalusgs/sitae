package es.novasoft.sitae.perfiles.adminLocal.altaFestivo.actions;

import java.io.InputStream;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.altaFestivo.forms.AltaFestivoForm;

public class AltaFestivoDoAction extends ActionBase {

	private static Log log = LogFactory.getLog(AltaFestivoDoAction.class);

	FestivoService festivoService = (FestivoService) Factory
			.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);

	InputStream solicitud = null;

	Timestamp fechaDoc = new Timestamp(System.currentTimeMillis());

	UsuarioAutentificado solicitante = null;

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String forward = ActionBase.SUCCESS_KEY;

		// CODIGO QUE COMPRUBA EL CANCELAR
		if (isCancelled(request)) {
			// Elimina los forms anticuados
			ResetForm.removeBean(mapping, request);
			return forward(request, mapping, ActionBase.CANCEL_KEY);
		}

		try {

			AltaFestivoForm formulario = (AltaFestivoForm) form;

			if (isCancelled(request)) {
				return mapping.findForward("cancel");
			}

			String cif = (String) request.getSession().getAttribute("cif");
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

			Organismo organismo = (Organismo) organismoService.findByCif(cif)
					.get(Constantes.CERO_INT);

			request.setAttribute("AltaFestivoForm", formulario);
			formulario.getFestivo().setOrganismo(organismo);

			festivoService.save(formulario.getFestivo());

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
