/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: InitDoAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.init.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.visualizarOrganismos.actions.VisualizarOrganismoFrontAction;
import es.novasoft.castellon.vfe.init.InitSession;
import es.novasoft.comun.struts.ActionBase;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction. El organismo se averigua por el nombre del host.
 */
public class InitDoAction extends ActionBase {

	private static final Logger LOGGER = Logger.getLogger(InitDoAction.class);
	
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

		String f = ActionBase.SUCCESS_KEY;

		try {

			String action = (String) request.getParameter("action");
			if ("logout".equalsIgnoreCase(action)) {
				InitSession.doReinit(request);
			} else {
				InitSession.doInit(request);
			}

			if (request.getAttribute("numeroErrores") == null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en InitDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, f);
	}
}
