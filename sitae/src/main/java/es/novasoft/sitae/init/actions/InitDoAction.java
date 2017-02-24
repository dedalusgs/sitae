/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: InitDoAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.init.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.init.InitSession;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class InitDoAction extends ActionBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.comun.struts.ActionBase#executeAction(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String f = ActionBase.SUCCESS_KEY;

		try {

			String logout = request.getParameter("action");
			if ("logout".equalsIgnoreCase(logout)) {
				InitSession.doReinit(request);
			} else {
				InitSession.doInit(request);
			}

			String userAgent = request.getHeader("User-Agent");
			userAgent = userAgent.toLowerCase();
			if (userAgent.matches("(.*)iphone(.*)|(.*)ipod(.*)|(.*)ipad(.*)|(.*)android(.*)|(.*)blackberry(.*)|(.*)iemobile(.*)|(.*)opera(.*)")) {
				f = "mobile";
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en InitDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, f);
	}

}
