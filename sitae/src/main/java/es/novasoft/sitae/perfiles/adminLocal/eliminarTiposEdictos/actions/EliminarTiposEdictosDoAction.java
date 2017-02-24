package es.novasoft.sitae.perfiles.adminLocal.eliminarTiposEdictos.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;

public class EliminarTiposEdictosDoAction extends ActionBase {

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory
			.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

	TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory
			.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TipoEdicto tipoEdicto = new TipoEdicto();

		try {

			String idTipoEdicto = (String) request
					.getParameter("idTipoEdictoSelecionado");

			if (idTipoEdicto != null && !idTipoEdicto.equals("")) {

				tipoEdicto = tipoEdictoService.findById(Integer
						.valueOf(idTipoEdicto));

				// Faltaria comprobar que no hay ningun edicto con ese tipo

				tipoEdictoService.delete(tipoEdicto);

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en EliminarTiposEdictosDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
