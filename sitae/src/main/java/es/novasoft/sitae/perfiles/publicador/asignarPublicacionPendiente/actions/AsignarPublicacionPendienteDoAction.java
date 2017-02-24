package es.novasoft.sitae.perfiles.publicador.asignarPublicacionPendiente.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class AsignarPublicacionPendienteDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	EstadoService estadoService = (EstadoService) Factory
			.getBean(ServiceConstants.ESTADO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Edicto edicto = new Edicto();
		Estado estado = estadoService.findById(Constantes.REVISION);
		String f = ActionBase.SUCCESS_KEY;
		;

		try {

			String idEdicto = (String) request
					.getParameter("idEdictoSeleccionado");
			String dni = (String) request.getSession().getAttribute("nif");

			if (idEdicto != null && !idEdicto.equals("")) {

				Usuario usuario = (Usuario) usuarioService
						.findByNumeroDocumento(dni).get(0);
				edicto = edictoService.findById(Integer.parseInt(idEdicto));
				// Asignamos el publicador al edicto
				edicto.setPublicador(usuario);
				// Ponemos el estado a revision
				edicto.setEstado(estado);
				Date fechaActual = new Date();
				edicto.setFechaUltimaModificacion(fechaActual);
			}

			edictoService.attachDirty(edicto);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en AsignarPublicacionPendienteDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, f);
	}
}
