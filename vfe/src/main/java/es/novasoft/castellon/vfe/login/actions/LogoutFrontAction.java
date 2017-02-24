/**
 * Autor: ggomez - Novasoft - Jaén (2011) 
 * Archivo: LoginSinCertificaooFrontAction.java
 * Creado: 08, junio 2011
 * Version: 1.0
 */
package es.novasoft.castellon.vfe.login.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;

/**
 * The Class LoginSinCertificadoFrontAction.
 */
public class LogoutFrontAction extends ActionBase {

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

		request.getSession().invalidate();

		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
