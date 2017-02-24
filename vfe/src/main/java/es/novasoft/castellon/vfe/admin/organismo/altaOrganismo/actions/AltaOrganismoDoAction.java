package es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.forms.AltaOrganismoForm;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FileUtil;
import es.novasoft.comun.utils.ResetForm;

// TODO: Auto-generated Javadoc
/**
 * The Class AltaOrganismoDoAction.
 */
public class AltaOrganismoDoAction extends ActionBase {

	/** The log. */
	private static Log log = LogFactory.getLog(AltaOrganismoDoAction.class);

	/** The organismo service. */
	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	/** The solicitud. */
	InputStream solicitud = null;

	/** The fecha doc. */
	Timestamp fechaDoc = new Timestamp(System.currentTimeMillis());

	/* (non-Javadoc)
	 * @see es.novasoft.comun.struts.ActionBase#executeAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String forward = ActionBase.SUCCESS_KEY;
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		// CODIGO QUE COMPRUBA EL CANCELAR
		if (isCancelled(request)) {
			// Elimina los forms anticuados
			ResetForm.removeBean(mapping, request);
			return forward(request, mapping, ActionBase.CANCEL_KEY);
		}

		try {

			AltaOrganismoForm formulario = (AltaOrganismoForm) form;

			if (isCancelled(request)) {
				return mapping.findForward("cancel");
			}

	
			
			 
			

			if (formulario.getImagen() != null
					&& formulario.getImagen().getFileName() != null
					&& !formulario.getImagen().getFileName().trim().equals("")) {
				ServletContext contexto = this.getServlet().getServletContext();
				String rutaEscudo = contexto.getRealPath(Constantes
						.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
						+ File.separator
						+ formulario.getOrganismo().getCodigo());
				FileUtil.guardarArchivoFileSystem(formulario.getImagen()
						.getFileData(), formulario.getImagen().getFileName(),
						rutaEscudo);
				formulario.getOrganismo().setImagen(
						formulario.getImagen().getFileData());
				formulario.getOrganismo().setNombreImagen(
						formulario.getImagen().getFileName());
			}
			formulario.getOrganismo().setCodTema(
					Integer.valueOf(formulario.getOpcion()));
			organismoService.save(formulario.getOrganismo());

		} catch (IOException e) {
			e.printStackTrace();
			return mapping.findForward(ActionBase.ERROR_KEY);
		} catch (Exception ex) {
			ex.printStackTrace();

			log.error("ERROR:" + ex.getMessage());
			log.error("TRAZA:", ex);
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {

			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
