package es.novasoft.sitae.perfiles.adminGlobal.modificarOrganismoExterno.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;

public class ModificarOrganismoExternoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private OrganismoExterno organismoExterno;

	public OrganismoExterno getOrganismoExterno() {
		return organismoExterno;
	}

	public void setOrganismoExterno(OrganismoExterno organismoExterno) {
		this.organismoExterno = organismoExterno;
	}

	public ModificarOrganismoExternoForm() {

		this.organismoExterno = new OrganismoExterno();
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		String cifAntiguo = (String) request.getSession().getAttribute("CIF");

		OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory
				.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);

		if (organismoExterno.getCif().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.cif")));
		} else {
			if (organismoExterno.getCif().length() >= Constantes.TAMANIO_MAX) {
				errors
						.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datosorganismo.cif")));
			} else {
				if (!ValidatorUtils.esCIF(organismoExterno.getCif())) {
					errors.add(null, new ActionMessage("errors.Cif"));
				} else {
					List listaOrganismos;
					try {
						listaOrganismos = organismoExternoService
								.findByCif(organismoExterno.getCif());
						if (!listaOrganismos.isEmpty()
								&& !cifAntiguo
										.equals(organismoExterno.getCif())) {
							errors.add(null, new ActionMessage(
									"errors.cifRepetido"));
						}

					} catch (DAOException e) {
						e.printStackTrace();
					}

				}
			}
		}

		if (organismoExterno.getNombre().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.nombre")));
		} else {
			if (organismoExterno.getNombre().length() >= Constantes.TAMANIO_MAX_NOMBRE)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.nombre")));
		}

		if (organismoExterno.getDireccion().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.direccion")));
		} else {
			if (organismoExterno.getDireccion().length() >= Constantes.TAMANIO_MAX)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.direccion")));
		}

		if (organismoExterno.getTelefono().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.telefono")));
		} else if (!ValidatorUtils.isTelefono(organismoExterno.getTelefono(),
				true, true, "")) {
			errors.add(null, new ActionMessage("errors.telefono"));
		}

		if (organismoExterno.getFax().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.fax")));
		} else if (!ValidatorUtils.isTelefono(organismoExterno.getFax(), true,
				true, "")) {
			errors.add(null, new ActionMessage("errors.fax"));
		}

		if (organismoExterno.getEmail().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.email")));
		} else if (!ValidatorUtils.isEmail(organismoExterno.getEmail())) {
			errors.add(null, new ActionMessage("errors.email"));
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

}
