package es.novasoft.sitae.perfiles.adminLocal.bajaUsuarioFirmante.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;

public class BajaUsuarioFirmanteDoAction extends ActionBase {

	UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
			.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
		String f = ActionBase.ERROR_KEY;
		try {
			String numDocumento = (String) request
					.getParameter("idUsuarioSeleccionado");
			if (numDocumento != null && !numDocumento.equals("")) {
				String cif = (String) request.getSession().getAttribute("cif");
				List listaOrganismo = organismoService.findByCif(cif);
				if (!listaOrganismo.isEmpty()) {
					Organismo organismo = (Organismo) listaOrganismo.get(0);
					Integer idOrganismo = organismo.getIdOrg();
					List listaUsuariosFirmantes = usuarioFirmanteService
							.findByIdOrgNumeroDocumento(idOrganismo,
									numDocumento);
					if (!listaUsuariosFirmantes.isEmpty()) {
						UsuarioFirmante usuarioFirmantes = (UsuarioFirmante) listaUsuariosFirmantes
								.get(0);
						usuarioFirmanteService.delete(usuarioFirmantes);
						f = ActionBase.SUCCESS_KEY;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaUsuarioFirmanteDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, f);
	}
}
