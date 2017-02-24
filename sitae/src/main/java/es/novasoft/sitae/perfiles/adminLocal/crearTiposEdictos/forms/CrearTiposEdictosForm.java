package es.novasoft.sitae.perfiles.adminLocal.crearTiposEdictos.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;

public class CrearTiposEdictosForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private TipoEdicto tipoEdicto;

	public CrearTiposEdictosForm() {

		tipoEdicto = new TipoEdicto();
	}

	public TipoEdicto getTipoEdicto() {
		return tipoEdicto;
	}

	public void setTipoEdicto(TipoEdicto tipoEdicto) {
		this.tipoEdicto = tipoEdicto;
	}

	/**
	 * Función para validar el formulario
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory
				.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);

		ActionErrors errors = new ActionErrors();

		String nombre = tipoEdicto.getNombre();

		String cif = (String) request.getSession().getAttribute("cif");

		List listaEdictos;
		try {
			listaEdictos = tipoEdictoService.findByNombreCif(nombre, cif);

			if (nombre.equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request,
								"datostipoedicto.nombre")));
			} else {
				if (nombre.length() >= Constantes.TAMANIO_MAX_NOMBRE) {
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datostipoedicto.nombre")));
				} else {
					if (!listaEdictos.isEmpty()) {
						errors.add(null, new ActionMessage(
								"errors.tipoEdictoExistente"));
					}
				}
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("numeroErrores", errors.size());

		return errors;
	}

}
