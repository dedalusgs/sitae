package es.novasoft.castellon.vfe.admin.organismo.muestraInformacionOrganismo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.actions.AltaOrganismoFrontAction;
import es.novasoft.castellon.vfe.admin.organismo.muestraInformacionOrganismo.forms.MuestraInformacionOrganismoForm;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;

// TODO: Auto-generated Javadoc
/**
 * The Class MuestraInformacionOrganismoFrontAction.
 */
public class MuestraInformacionOrganismoFrontAction extends ActionBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.comun.struts.
	 * ActionBase#executeAction(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	/** The organismo service. */
	private final transient OrganismoService organismoService = 
		(OrganismoService) Factory.getBean(
				ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	private static final Logger LOGGER = Logger.getLogger(MuestraInformacionOrganismoFrontAction.class);
	
	/* (non-Javadoc)
	 * @see es.novasoft.comun.struts.ActionBase#
	 * executeAction(org.apache.struts.action.ActionMapping, 
	 * org.apache.struts.action.ActionForm, 
	 * javax.servlet.http.HttpServletRequest, 
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String retAction = ActionBase.SUCCESS_KEY;
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		try {
			final MuestraInformacionOrganismoForm formulario = 
				(MuestraInformacionOrganismoForm) form;

			final String idOrganismo = (String) request
					.getParameter("idOrganismoSelecionado");

			if (idOrganismo != null && !idOrganismo.equals("")) {
				final Organismo organismo = organismoService.findById(Integer
						.valueOf(idOrganismo));
				formulario.setOrganismo(organismo);
			}

			formulario.setListaTemas(Organismo.rellenarTemas());
			request.getSession().setAttribute("listaTemas",
					formulario.getListaTemas());

		} catch (Exception e) {
			LOGGER.error("Error en MuestraInformacionOrganismoFront", e);
			retAction = ActionBase.ERROR_KEY;
		}
		return forward(request, mapping, retAction);
	}
}
