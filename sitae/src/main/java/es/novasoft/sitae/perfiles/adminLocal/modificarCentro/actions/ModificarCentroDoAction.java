package es.novasoft.sitae.perfiles.adminLocal.modificarCentro.actions;

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
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.perfiles.adminLocal.modificarCentro.forms.ModificarCentroForm;

public class ModificarCentroDoAction extends ActionBase {

	CentroProcedenciaService centroService = (CentroProcedenciaService) Factory
			.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CentroProcedencia centro = new CentroProcedencia();
		ModificarCentroForm formulario = (ModificarCentroForm) form;

		try {

			centro = formulario.getCentro();

			centroService.attachDirty(centro);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarCentroDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
