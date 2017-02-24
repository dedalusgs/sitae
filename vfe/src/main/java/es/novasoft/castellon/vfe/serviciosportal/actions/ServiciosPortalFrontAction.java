/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: ServiciosPortalFrontAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.serviciosportal.actions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiciosPortalFrontAction.
 */
public class ServiciosPortalFrontAction extends ActionBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.comun.struts.ActionBase#executeAction(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
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
			if (accion.equals("ayuda")) {
				f = "ayuda" + "_" + lenguaje;
			}
		}

		return forward(request, mapping, f);
	}
}
