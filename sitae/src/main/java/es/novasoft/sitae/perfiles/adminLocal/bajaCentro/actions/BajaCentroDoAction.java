package es.novasoft.sitae.perfiles.adminLocal.bajaCentro.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;

public class BajaCentroDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	CentroProcedenciaService centroService = (CentroProcedenciaService) Factory
			.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CentroProcedencia centro = new CentroProcedencia();

		try {

			String idCentro = (String) request
					.getParameter("idCentroSeleccionado");

			if (idCentro != null && !idCentro.equals("")) {

				centro = centroService.findById(Integer.valueOf(idCentro));

				List listaEdictos = edictoService.findByCentro(centro
						.getIdCentro());
				List listaRelUsuOrgCentPerf = relacionUsuOrgCentroPerfService
						.findByCentro(Integer.valueOf(idCentro));

				if (listaEdictos.isEmpty() && listaRelUsuOrgCentPerf.isEmpty()) {
					centroService.delete(centro);
				} else {
					return forward(request, mapping, ActionBase.ERROR_KEY);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaCentroDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
