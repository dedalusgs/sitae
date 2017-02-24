package es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.forms.AltaOrganismoForm;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.ActionBase;

// TODO: Auto-generated Javadoc
/**
 * The Class AltaOrganismoFrontAction.
 */
public class AltaOrganismoFrontAction extends ActionBase {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AltaOrganismoFrontAction.class);
	
	/* (non-Javadoc)
	 * @see es.novasoft.comun.struts.ActionBase#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		try {

			if (isCancelled(request)) {
				return mapping.findForward("Volver");
			}

			LOGGER.debug("INICIO DEL METODO");

			AltaOrganismoForm formulario = (AltaOrganismoForm) form;
			formulario.setListaTemas(Organismo.rellenarTemas());
			request.setAttribute("AltaOrganismoForm", formulario);
			request.getSession().setAttribute("listaTemas",
					formulario.getListaTemas());

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en AltaOrganismoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
