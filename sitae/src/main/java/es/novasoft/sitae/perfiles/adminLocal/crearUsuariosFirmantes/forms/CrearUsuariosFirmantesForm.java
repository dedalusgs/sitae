package es.novasoft.sitae.perfiles.adminLocal.crearUsuariosFirmantes.forms;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;

public class CrearUsuariosFirmantesForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private UsuarioFirmante usuarioFirmante;

	private String cif;

	private boolean desactivarCampos;

	public CrearUsuariosFirmantesForm() {
		usuarioFirmante = new UsuarioFirmante();
		desactivarCampos = true;

	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public UsuarioFirmante getUsuarioFirmante() {
		return usuarioFirmante;
	}

	public void setUsuarioFirmante(UsuarioFirmante usuarioFirmante) {
		this.usuarioFirmante = usuarioFirmante;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		UsuarioFirmanteService usuarioFirmanteService = (UsuarioFirmanteService) Factory
				.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		String cif = (String) request.getSession().getAttribute("cif");
		List listaOrganismos = null;
		try {
			listaOrganismos = organismoService.findByCif(cif);
		} catch (DAOException daoExcepcion) {
		}
		Organismo organismo = (Organismo) listaOrganismos.get(0);
		List listaUsuariosFirmantes = new ArrayList();

		ActionErrors errors = new ActionErrors();

		String accion = (String) request.getParameter("accion");
		if (accion != null && !accion.equals("")) {

			if (accion.equals("buscar")) {
				request.getSession().setAttribute("statusBusqueda", "N");
				this.getUsuarioFirmante().setNombre("");
				this.getUsuarioFirmante().setApellido1("");
				this.getUsuarioFirmante().setApellido2("");
				this.getUsuarioFirmante().setCargo("");

				if (usuarioFirmante.getNumDocumento() == null
						|| usuarioFirmante.getNumDocumento().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil
									.getMensaje(request, "datosusuario.NIF")));
				} else {
					if (usuarioFirmante.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
						errors.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datosusuario.NIF")));
					} else {
						if (!ValidatorUtils.esNIF(usuarioFirmante
								.getNumDocumento())) {
							errors.add(null, new ActionMessage("errors.Nif"));
						} else {
							try {
								listaUsuariosFirmantes = usuarioFirmanteService
										.findByIdOrgNumeroDocumento(organismo
												.getIdOrg(), this.usuarioFirmante
												.getNumDocumento());
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (!listaUsuariosFirmantes.isEmpty()) {
								errors
										.add(
												null,
												new ActionMessage(
														"errors.usuarioFirmanteOrganismo",
														null));
							} else {
								request.getSession().setAttribute(
										"statusBusqueda", "S");
								this.setDesactivarCampos(false);
							}
						}
					}
				}
			}
		} else {

			if (usuarioFirmante.getNumDocumento() == null
					|| usuarioFirmante.getNumDocumento().equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
			} else {
				if (usuarioFirmante.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil
									.getMensaje(request, "datosusuario.NIF")));
				} else {
					if (!ValidatorUtils
							.esNIF(usuarioFirmante.getNumDocumento())) {
						errors.add(null, new ActionMessage("errors.Nif"));
					} else {
						try {
							listaUsuariosFirmantes = usuarioFirmanteService
									.findByIdOrgNumeroDocumento(organismo
											.getIdOrg(), this.usuarioFirmante
											.getNumDocumento());
						} catch (ServiceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (!listaUsuariosFirmantes.isEmpty()) {
							errors.add(null, new ActionMessage(
									"errors.usuarioFirmanteOrganismo", null));
						}
					}
				}
			}

			if (usuarioFirmante.getNombre() == null
					|| usuarioFirmante.getNombre().equals("")) {
				errors.add(null,
						new ActionMessage("errors.required", LenguajeUtil
								.getMensaje(request, "datosusuario.nombre")));
			} else {
				if (usuarioFirmante.getNombre().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.nombre")));
			}

			if (usuarioFirmante.getApellido1() == null
					|| usuarioFirmante.getApellido1().equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request,
								"datosusuario.apellido1")));
			} else {
				if (usuarioFirmante.getApellido1().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.apellido1")));
			}

			if (usuarioFirmante.getApellido2() == null
					|| usuarioFirmante.getApellido2().equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request,
								"datosusuario.apellido2")));
			} else {
				if (usuarioFirmante.getApellido2().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.apellido2")));
			}

			if (usuarioFirmante.getCargo() == null
					|| usuarioFirmante.getCargo().equals("")) {
				errors
						.add(null, new ActionMessage("errors.required",
								LenguajeUtil.getMensaje(request,
										"datosusuario.cargo")));
			} else {
				if (usuarioFirmante.getCargo().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.cargo")));
			}
		}
		return errors;
	}

	public boolean isDesactivarCampos() {
		return desactivarCampos;
	}

	public void setDesactivarCampos(boolean desactivarCampos) {
		this.desactivarCampos = desactivarCampos;
	}

}
