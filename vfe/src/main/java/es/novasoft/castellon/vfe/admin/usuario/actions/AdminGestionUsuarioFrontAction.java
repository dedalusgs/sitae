/**
 * Autor: ggomez - Novasoft - Ja�n (2011) 
 * Archivo: LoginSinCertificaooFrontAction.java
 * Creado: 08, junio 2011
 * Version: 1.0
 */
package es.novasoft.castellon.vfe.admin.usuario.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.usuario.forms.AdminGestionUsuarioForm;
import es.novasoft.castellon.vfe.login.forms.LoginForm;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.ActionBase;

/**
 * The Class LoginSinCertificadoFrontAction.
 */
public class AdminGestionUsuarioFrontAction extends ActionBase {

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
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
