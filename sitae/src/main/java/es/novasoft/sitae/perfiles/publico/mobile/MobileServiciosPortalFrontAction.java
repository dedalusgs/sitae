package es.novasoft.sitae.perfiles.publico.mobile;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;

public class MobileServiciosPortalFrontAction extends ActionBase {
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String f = "error";
		Locale locale = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
		
		String lenguaje = locale.getLanguage();
		
		if (request.getParameter("accion") != null
				&& !request.getParameter("accion").equals("")) {
			String accion = request.getParameter("accion");
			if (accion.equals("contacto")) {
				f = "contacto";
			}
			if (accion.equals("ayuda")) {
				f = "ayuda"+ "_" + lenguaje;
			}
			if (accion.equals("mapaWeb")) {
				f = "mapaWeb";
			}
			if (accion.equals("accesibilidad")) {
				f = "accesibilidad" + "_" + lenguaje;

			}
			if (accion.equals("avisoLegal")) {
				f = "avisoLegal" + "_" + lenguaje;
			}
			if (accion.equals("acercaDe")) {
				f = "acercaDe" + "_" + lenguaje;
			}
		}

		return forward(request, mapping, f);
	}
}
