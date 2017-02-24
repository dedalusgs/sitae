package es.novasoft.sitae.perfiles.publicador.relacionarPublicaciones.actions;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;
import es.novasoft.sitae.perfiles.publicador.relacionarPublicaciones.forms.RelacionarPublicacionesForm;
import es.novasoft.sitae.perfiles.redactor.crearEdicto.forms.CrearEdictoForm;

public class RelacionarPublicacionesDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory
			.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			String idEdictoOriginal = (String) request.getSession()
					.getAttribute("idEdictoRelacionado");
			Edicto edictoOriginal = edictoService.findById(Integer
					.parseInt(idEdictoOriginal));
			RelacionarPublicacionesForm formulario = (RelacionarPublicacionesForm) form;

			List<ObjetoEdictoVisualizar> listaRelacionados = (List<ObjetoEdictoVisualizar>) request
					.getSession().getAttribute("listaRelacionados");

			String retAction = ActionBase.ERROR_KEY;
			String accion = formulario.getAccion();

			if (accion != null && !accion.equals("")) {
				if (accion.equals("publicador")) {
					if (edictoOriginal != null && listaRelacionados != null) {
						// Eliminamos las relaciones previas
						List<RelacionEdictos> listaRelaciones = relacionEdictosService
								.findByEdicto(Integer
										.parseInt(idEdictoOriginal));
						Iterator it = listaRelaciones.iterator();
						while (it.hasNext()) {
							RelacionEdictos relacionEdictosAux = (RelacionEdictos) it
									.next();
							relacionEdictosService.delete(relacionEdictosAux);
						}
						// Adjuntamos las nuevas relaciones
						for (ObjetoEdictoVisualizar objetoEdicto : listaRelacionados) {
							Edicto edicto = edictoService.findById(objetoEdicto
									.getId());
							if (edicto != null) {
								RelacionEdictos relacion = new RelacionEdictos();
								relacion.setEdicto1(edictoOriginal);
								relacion.setEdicto2(edicto);
								relacionEdictosService.save(relacion);
							}
						}
					}
				}
				if (accion.equals("crearMisRedacciones")) {
					CrearEdictoMisRedaccionesForm formularioRet = (CrearEdictoMisRedaccionesForm) request.getSession()
							.getAttribute("CrearEdictoMisRedaccionesForm");
					formularioRet
							.setListaEdictosRelacionados(listaRelacionados);
					request.getSession().setAttribute("CrearEdictoMisRedaccionesForm",
							formularioRet);
				}
				
				if (accion.equals("crear")) {
					CrearEdictoForm formularioRet = (CrearEdictoForm) request.getSession()
							.getAttribute("CrearEdictoForm");
					formularioRet
							.setListaEdictosRelacionados(listaRelacionados);
					request.getSession().setAttribute("CrearEdictoForm",
							formularioRet);
				}
				retAction = ActionBase.SUCCESS_KEY;
			}

			return forward(request, mapping, retAction);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarEdictoPublicoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

	}
}
