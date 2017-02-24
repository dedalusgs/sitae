package es.novasoft.sitae.perfiles.adminLocal.modificarCentro.forms;

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
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;

public class ModificarCentroForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private CentroProcedencia centro;

	private String nombreAuxiliar;

	public CentroProcedencia getCentro() {
		return centro;
	}

	public void setCentro(CentroProcedencia centro) {
		this.centro = centro;

		this.nombreAuxiliar = centro.getNombre();
	}

	public ModificarCentroForm() {

		this.centro = new CentroProcedencia();
	}

	/**
	 * Función para validar el alta de Centro
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		CentroProcedenciaService centroService = (CentroProcedenciaService) Factory
				.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

		List listaCentro2;

		if (centro.getNombre().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datoscentro.nombre")));
		} else {
			if (centro.getNombre().length() >= Constantes.TAMANIO_MAX_NOMBRE) {
				errors
						.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datoscentro.nombre")));
			} else {
				try {
					listaCentro2 = centroService.findByNombre(centro
							.getNombre());

					if ((!listaCentro2.isEmpty())) {
						// Se comprueba que el nombre modificado no este
						// repetido, a
						// no ser que sea el mismo que se esta modificando
						if (!centro.getNombre().equals(this.nombreAuxiliar))
							errors.add(null, new ActionMessage(
									"errors.centroExistente", LenguajeUtil
											.getMensaje(request,
													"datoscentro.nombre")));
					}
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (centro.getDescripcion().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datoscentro.descripcion")));
		} else {
			if (centro.getDescripcion().length() >= Constantes.TAMANIO_MAX_DESCRIPCION)
				errors.add(null, new ActionMessage("errors.maxlength2",
						LenguajeUtil.getMensaje(request,
								"datoscentro.descripcion"), "1024"));
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	public String getNombreAuxiliar() {
		return nombreAuxiliar;
	}

	public void setNombreAuxiliar(String nombreAuxiliar) {
		this.nombreAuxiliar = nombreAuxiliar;
	}

}
