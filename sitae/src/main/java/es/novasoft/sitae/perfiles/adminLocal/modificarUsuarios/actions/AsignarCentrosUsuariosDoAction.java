package es.novasoft.sitae.perfiles.adminLocal.modificarUsuarios.actions;

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
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.perfiles.adminLocal.modificarUsuarios.forms.ModificarUsuariosForm;

public class AsignarCentrosUsuariosDoAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		PerfilService perfilService = (PerfilService) Factory
				.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory
				.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

		ModificarUsuariosForm formulario = (ModificarUsuariosForm) form;

		try {
			String accion = request.getParameter("accion");
			Perfil perfil = perfilService.findById(Constantes.PUBLICADOR);
			String dni = (String) request.getSession().getAttribute(
					"ModificarUsuariosDNI");
			String cif = (String) request.getSession().getAttribute(
					"ModificarUsuariosCIF");
			if (accion != null) {
				if (accion.equals("add")) {
					String idCentro = request.getParameter("opcionCentro");
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
					relacionUsuOrgCentroPerf.setOrganismo(cif);
					relacionUsuOrgCentroPerf.setPerfil(perfil);
					relacionUsuOrgCentroPerf.setUsuario(dni);
					CentroProcedencia centroProcedencia = (CentroProcedencia) centroProcedenciaService
							.findById(Integer.valueOf(idCentro));
					relacionUsuOrgCentroPerf
							.setCentroProcedencia(centroProcedencia);
					relacionUsuOrgCentroPerfService
							.save(relacionUsuOrgCentroPerf);
				} else {
					String centroSelecionado = request
							.getParameter("idCentroSelecionado");
					Integer idInteger = Integer.parseInt(centroSelecionado);
					CentroProcedencia centroProcedencia = (CentroProcedencia) centroProcedenciaService
							.findById(idInteger);
					List listaRelaciones = relacionUsuOrgCentroPerfService
							.findByCentroUsuPerf(centroProcedencia
									.getIdCentro().toString(), dni, perfil
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
