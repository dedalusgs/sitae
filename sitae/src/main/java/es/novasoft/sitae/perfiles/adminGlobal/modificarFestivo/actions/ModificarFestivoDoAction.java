package es.novasoft.sitae.perfiles.adminGlobal.modificarFestivo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.perfiles.adminGlobal.modificarFestivo.forms.ModificarFestivoForm;


public class ModificarFestivoDoAction extends ActionBase {

	FestivoService festivoService = (FestivoService) Factory
			.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Festivo festivo = null;
		ModificarFestivoForm formulario = (ModificarFestivoForm) form;
        
		try {

			festivo = formulario.getFestivo();

			festivoService.attachDirty(festivo);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarFestivoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
