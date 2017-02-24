package es.novasoft.sitae.perfiles.publicador.eliminarMisRedacciones.actions;

import java.util.Iterator;
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
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class EliminarMisRedaccionesDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");

	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Edicto edicto = new Edicto();

		try {

			String idEdicto = (String) request.getParameter("idEdictoSeleccionado");
			String idUsuario = (String) request.getSession().getAttribute("nif");

			if (idEdicto != null && !idEdicto.equals("")) {

				edicto = edictoService.findById(Integer.valueOf(idEdicto));

				// Compruebo que aun no ha pasado la fase de revision y que ha
				// sido creado por el propio publicador
				Integer idEstado = edicto.getEstado().getIdEstado();

				if (idUsuario.equals(edicto.getRedactor().getNumDocumento())) {

					if (idEstado == Constantes.INICIADO || idEstado == Constantes.PENDIENTE_VALIDACION || idEstado == Constantes.REVISION || idEstado == Constantes.RECHAZADO || idEstado == Constantes.RECHAZADO_FIRMA) {
						// Eliminamos las relaciones previas
						RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);
						List<RelacionEdictos> listaRelaciones = relacionEdictosService.findByEdicto(edicto.getIdEdicto());
						Iterator it = listaRelaciones.iterator();
						while (it.hasNext()) {
							RelacionEdictos relacionEdictosAux = (RelacionEdictos) it.next();
							relacionEdictosService.delete(relacionEdictosAux);
						}
						FileService fileService = this.factoryFileServices.getService(edicto);
						fileService.eliminarBorrador(edicto);
						edictoService.delete(edicto);

					} else {
						return forward(request, mapping, ActionBase.ERROR_KEY);
					}

				} else {
					return forward(request, mapping, ActionBase.ERROR_KEY_2);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en EliminarEdictoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
