package es.novasoft.sitae.perfiles.adminLocal.modificarTiposEdictos.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.perfiles.adminLocal.modificarTiposEdictos.forms.ModificarTiposEdictosForm;

public class ModificarTiposEdictosFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory
					.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);

			ModificarTiposEdictosForm modificarTiposEdictosForm = (ModificarTiposEdictosForm) form;

			if (request.getAttribute("numeroErrores") == null) {

				TipoEdicto tipoEdicto = new TipoEdicto();

				String idTipoEdictoSelecionado = (String) request
						.getParameter("idTipoEdictoSelecionado");

				if (idTipoEdictoSelecionado != null
						&& !idTipoEdictoSelecionado.equals("")) {
					tipoEdicto = tipoEdictoService.findById(Integer
							.valueOf(idTipoEdictoSelecionado));
				}
				modificarTiposEdictosForm.setTipoEdicto(tipoEdicto);
				request.setAttribute("ModificarTiposEdictosForm",
						modificarTiposEdictosForm);

			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ModificarTiposEdictosFrontAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}
}
