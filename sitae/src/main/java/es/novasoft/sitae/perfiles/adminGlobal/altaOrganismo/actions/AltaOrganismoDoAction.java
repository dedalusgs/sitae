package es.novasoft.sitae.perfiles.adminGlobal.altaOrganismo.actions;

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

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FileUtil;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.altaOrganismo.forms.AltaOrganismoForm;

public class AltaOrganismoDoAction extends ActionBase {

	private static Log log = LogFactory.getLog(AltaOrganismoDoAction.class);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	InputStream solicitud = null;

	Timestamp fechaDoc = new Timestamp(System.currentTimeMillis());

	UsuarioAutentificado solicitante = null;

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String forward = ActionBase.SUCCESS_KEY;

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

			// SE COMPRUEBA QUE SE HA ACCEDIDO DE MANERA CORRECTA
			/*
			 * Utils util = new Utils(); if (!util.usuarioAutenticado(request)){
			 * return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			if (formulario.getImagen() != null
					&& formulario.getImagen().getFileName() != null
					&& !formulario.getImagen().getFileName().trim().equals("")) {
				ServletContext contexto = this.getServlet().getServletContext();
				String rutaEscudo = contexto.getRealPath(Constantes
						.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
						+ File.separator + formulario.getOrganismo().getCif());
				FileUtil.guardarArchivoFileSystem(formulario.getImagen()
						.getFileData(), formulario.getImagen().getFileName(),
						rutaEscudo);
				formulario.getOrganismo().setImagen(
						formulario.getImagen().getFileData());
				formulario.getOrganismo().setNombreImagen(
						formulario.getImagen().getFileName());
			}
			formulario.getOrganismo().setTema(
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
