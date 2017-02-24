package es.novasoft.sitae.perfiles.adminLocal.crearTiposEdictos.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.perfiles.adminLocal.crearTiposEdictos.forms.CrearTiposEdictosForm;

public class CrearTiposEdictosFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			if (isCancelled(request)) {
				return mapping.findForward("Volver");
			}

			LOGGER.debug("INICIO DEL METODO");

			CrearTiposEdictosForm formulario = (CrearTiposEdictosForm) form;

			request.setAttribute("CrearTiposEdictosForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en CrearTiposEdictosFrontAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
