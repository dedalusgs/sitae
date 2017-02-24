package es.novasoft.sitae.perfiles.adminGlobal.modificarAdmLocal.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.perfiles.adminGlobal.modificarAdmLocal.forms.ModificarAdmLocalForm;

public class AsignarOrganismosAdmLocalDoAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		PerfilService perfilService = (PerfilService) Factory
				.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);

		ModificarAdmLocalForm formulario = (ModificarAdmLocalForm) form;

		try {
			String accion = request.getParameter("accion");
			Perfil perfil = perfilService.findById(Constantes.ADMIN_LOCAL);
			String dni = (String) request.getSession().getAttribute("DNI");
			if (accion != null) {
				if (accion.equals("add")) {

					List listaRelacionPublicador = relacionUsuOrgCentroPerfService
							.findByOrgUsuPerf(formulario.getOpcionOrganismo(),
									dni, String.valueOf(Constantes.PUBLICADOR));
					List listaRelacionRedactor = relacionUsuOrgCentroPerfService
							.findByOrgUsuPerf(formulario.getOpcionOrganismo(),
									dni, String.valueOf(Constantes.REDACTOR));

					if (!listaRelacionPublicador.isEmpty()
							|| !listaRelacionRedactor.isEmpty()) {
						return forward(request, mapping, ActionBase.ERROR_KEY_2);
					}
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
					relacionUsuOrgCentroPerf.setOrganismo(formulario
							.getOpcionOrganismo());
					relacionUsuOrgCentroPerf.setPerfil(perfil);
					relacionUsuOrgCentroPerf.setUsuario(dni);
					relacionUsuOrgCentroPerfService
							.save(relacionUsuOrgCentroPerf);
				} else {
					String organismoSelecionado = request
							.getParameter("idOrgSelecionado");
					Integer idInteger = Integer.parseInt(organismoSelecionado);
					Organismo organismo = (Organismo) organismoService
							.findById(idInteger);
					List listaRelaciones = relacionUsuOrgCentroPerfService
							.findByOrgUsuPerf(organismo.getCif(), dni, perfil
									.getIdPerfil().toString());
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) listaRelaciones
							.get(0);
					relacionUsuOrgCentroPerfService
							.delete(relacionUsuOrgCentroPerf);
				}
			} else {
				log
						.error("Error en AsignarOrganismosAdmLocalDoAction, accion vacia");
				return forward(request, mapping, ActionBase.ERROR_KEY);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en AsignarOrganismosAdmLocalDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
