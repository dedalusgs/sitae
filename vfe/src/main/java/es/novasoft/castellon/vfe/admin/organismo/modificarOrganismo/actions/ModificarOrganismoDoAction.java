package es.novasoft.castellon.vfe.admin.organismo.modificarOrganismo.actions;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.organismo.modificarOrganismo.forms.ModificarOrganismoForm;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FileUtil;

public class ModificarOrganismoDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModificarOrganismoForm formulario = (ModificarOrganismoForm) form;
		String nif=(String)request.getSession().getAttribute("nif");
		if (nif==null || nif.equalsIgnoreCase(""))	 
			return mapping.findForward(Constantes.FORWARD_ERROR_ACCESO);
		try {
			
			Organismo organismo = formulario.getOrganismo();
			organismo.setCodTema(Integer.valueOf(formulario.getOpcion()));
			ServletContext contexto = this.getServlet().getServletContext();
			if (formulario.getImagen() != null
					&& formulario.getImagen().getFileName() != null
					&& !formulario.getImagen().getFileName().trim().equals("")) {
				log.info("Inicio Guardar fichero Imagen");
				
				String rutaEscudo = contexto.getRealPath(Constantes
						.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
						+ File.separator
						+ formulario.getOrganismo().getCodigo());
				log.info("Ruta escudo: "+rutaEscudo);
				FileUtil.guardarArchivoFileSystem(formulario.getImagen()
						.getFileData(), formulario.getImagen().getFileName(),
						rutaEscudo);
				log.info("Se finaliza guardar en disco.");
				formulario.getOrganismo().setImagen(
						formulario.getImagen().getFileData());
				formulario.getOrganismo().setNombreImagen(
						formulario.getImagen().getFileName());
			}

			organismoService.attachDirty(organismo);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarOrganismoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
