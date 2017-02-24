package es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismo.actions;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FileUtil;
import es.novasoft.comun.utils.OrganismoVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismo.forms.ModificarOrganismoForm;

public class ModificarOrganismoDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Organismo organismo = new Organismo();
		ModificarOrganismoForm formulario = (ModificarOrganismoForm) form;

		try {

			organismo = formulario.getOrganismo();
			organismo.setTema(Integer.valueOf(formulario.getOpcion()));
			String cifAntiguo = (String) request.getSession().getAttribute(
					"CIF");
			ServletContext contexto = this.getServlet().getServletContext();
			if (formulario.getImagen() != null
					&& formulario.getImagen().getFileName() != null
					&& !formulario.getImagen().getFileName().trim().equals("")) {
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

			if (!cifAntiguo.equals(organismo.getCif())) {
				List listaOrganismos = relacionUsuOrgCentroPerfService
						.findByCif(cifAntiguo);
				Iterator it = listaOrganismos.iterator();
				while (it.hasNext()) {
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
							.next();
					relacionUsuOrgCentroPerf.setOrganismo(organismo.getCif());
					relacionUsuOrgCentroPerfService
							.attachDirty(relacionUsuOrgCentroPerf);
				}
			}

			organismoService.attachDirty(organismo);
			
//			OrganismoVisualizar OrganismoVisualizar = new OrganismoVisualizar(
//				     formulario.getOrganismo());
//				   request.getSession().setAttribute("organismoSesion",
//				     OrganismoVisualizar);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarOrganismoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		
		
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
