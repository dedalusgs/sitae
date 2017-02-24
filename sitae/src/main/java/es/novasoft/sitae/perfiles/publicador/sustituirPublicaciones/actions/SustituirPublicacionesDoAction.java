package es.novasoft.sitae.perfiles.publicador.sustituirPublicaciones.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.perfiles.publicador.crearEdicto.forms.CrearEdictoMisRedaccionesForm;
import es.novasoft.sitae.perfiles.publicador.sustituirPublicaciones.forms.SustituirPublicacionesForm;
import es.novasoft.sitae.perfiles.redactor.crearEdicto.forms.CrearEdictoForm;

public class SustituirPublicacionesDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory
			.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			String idEdictoOriginal = (String) request.getSession()
					.getAttribute("idEdictoSus");

			SustituirPublicacionesForm formulario = (SustituirPublicacionesForm) form;

			String retAction = ActionBase.ERROR_KEY;
			String accion = request.getParameter("accion");
			String accionForm = (String) request.getSession().getAttribute("origenRelacion");
			if (request.getParameter("origen") != null) {
				accionForm = request.getParameter("origen");
			}
			if (request.getParameter("idEdicto") != null) {
				idEdictoOriginal = request.getParameter("idEdicto");
			}
			String idEdicto = request.getParameter("id");
			Edicto edicto = edictoService.findById(Integer.parseInt(idEdicto));

			if (accionForm != null && !accionForm.equals("")) {
				if (accionForm.equals("publicador")) {
					Edicto edictoOriginal = edictoService.findById(Integer
							.parseInt(idEdictoOriginal));
					if (edictoOriginal != null && edicto != null) {
						if (accion != null && !accion.equals("")) {
							if (accion.equals("alta")) {
								edictoOriginal.setSustituyeA(edicto);
								edicto.setSustituidoPor(edictoOriginal);
								edictoService.attachDirty(edicto);
								edictoService.attachDirty(edictoOriginal);
								retAction = ActionBase.SUCCESS_KEY;
							} else if (accion.equals("baja")) {
								edictoOriginal.setSustituyeA(null);
								edicto.setSustituidoPor(null);
								edictoService.attachDirty(edicto);
								edictoService.attachDirty(edictoOriginal);
								retAction = ActionBase.SUCCESS_KEY;
							}
						}
					}
				}
				if (accionForm.equals("publicadorMisRedacciones")) {
					Edicto edictoOriginal = edictoService.findById(Integer
							.parseInt(idEdictoOriginal));
					if (edictoOriginal != null && edicto != null) {
						if (accion != null && !accion.equals("")) {
							if (accion.equals("alta")) {
								edictoOriginal.setSustituyeA(edicto);
								edictoService.attachDirty(edictoOriginal);
								retAction = ActionBase.SUCCESS_KEY;
							} else if (accion.equals("baja")) {
								edictoOriginal.setSustituyeA(null);
								edictoService.attachDirty(edictoOriginal);
								retAction = ActionBase.SUCCESS_KEY;
							}
						}
					}
				}
				if (accionForm.equals("crearMisRedacciones")) {
					CrearEdictoMisRedaccionesForm formularioRet = (CrearEdictoMisRedaccionesForm) request
							.getSession().getAttribute(
									"CrearEdictoMisRedaccionesForm");
					if (accion.equals("alta")) {
					formularioRet.setEdictoSust(edicto);
					} else if (accion.equals("baja")) {
						formularioRet.setEdictoSust(null);
					}
					request.getSession().setAttribute(
							"CrearEdictoMisRedaccionesForm", formularioRet);
					retAction = ActionBase.SUCCESS_KEY;
				}

				if (accionForm.equals("crear")) {
					CrearEdictoForm formularioRet = (CrearEdictoForm) request
							.getSession().getAttribute("CrearEdictoForm");
					if (accion.equals("alta")) {
						formularioRet.setEdictoSust(edicto);
						} else if (accion.equals("baja")) {
							formularioRet.setEdictoSust(null);
						}
					request.getSession().setAttribute("CrearEdictoForm",
							formularioRet);
					retAction = ActionBase.SUCCESS_KEY;
				}

			}

			return forward(request, mapping, retAction);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarEdictoPublicoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

	}
}
