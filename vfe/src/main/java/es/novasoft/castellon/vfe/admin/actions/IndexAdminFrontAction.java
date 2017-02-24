package es.novasoft.castellon.vfe.admin.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.ActionBase;

public class IndexAdminFrontAction extends ActionBase {


	@Override
	public final ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		
		return mapping.findForward(ActionBase.SUCCESS_KEY);

	}

}