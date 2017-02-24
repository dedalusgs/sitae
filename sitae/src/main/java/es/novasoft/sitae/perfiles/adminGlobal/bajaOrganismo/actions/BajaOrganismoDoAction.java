package es.novasoft.sitae.perfiles.adminGlobal.bajaOrganismo.actions;

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
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;

public class BajaOrganismoDoAction extends ActionBase {
	
	OrganismoService	            organismoService	            = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	CentroProcedenciaService	    centroProcedenciaService	    = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	TipoEdictoService	            tipoEdictoService	            = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
	
	RelacionUsuOrgCentroPerfService	relacionUsuOrgCentroPerfService	= (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Organismo organismo = new Organismo();
		
		try {
			
			String idOrganismo = (String) request.getParameter("idOrganismoSelecionado");
			
			if (idOrganismo != null && !idOrganismo.equals("")) {
				
				organismo = organismoService.findById(Integer.valueOf(idOrganismo));
				
				// List listaCentros =
				// centroProcedenciaService.findByIdOrg(organismo.getIdOrg());
				List listaCentros = centroProcedenciaService.findAll();
				List listaTiposEdictos = tipoEdictoService.findByIdOrg(organismo.getIdOrg());
				
				organismo = organismoService.findById(Integer.valueOf(idOrganismo));
				
				String cif = organismo.getCif();
				List listaOrganismos = relacionUsuOrgCentroPerfService.findByCif(cif);
				
				if (listaOrganismos.isEmpty() && listaCentros.isEmpty() && listaTiposEdictos.isEmpty()) {
					organismoService.delete(organismo);
				} else {
					return forward(request, mapping, ActionBase.ERROR_KEY_2);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en BajaOrganismoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
