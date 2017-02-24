package es.novasoft.sitae.perfiles.adminGlobal.altaAdmLocal.forms;

import java.util.ArrayList;
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
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class AltaAdmLocalForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List<Organismo> listaOrganismos;

	private String opcion;

	private Usuario usuario;

	private boolean administradorGlobal;

	private boolean desactivarCampos;

	public AltaAdmLocalForm() {

		this.usuario = new Usuario();
		this.opcion = "";
		this.administradorGlobal = false;
		this.desactivarCampos = true;
	}

	public List<Organismo> getListaOrganismos() {
		return listaOrganismos;
	}

	public void setListaOrganismos(List<Organismo> listaOrganismos) {
		this.listaOrganismos = listaOrganismos;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAdministradorGlobal() {
		return administradorGlobal;
	}

	public void setAdministradorGlobal(boolean administradorGlobal) {
		this.administradorGlobal = administradorGlobal;
	}

	/**
	 * Función para validar el formulario
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		PerfilService perfilService = (PerfilService) Factory
				.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		ActionErrors errors = new ActionErrors();

		String accion = (String) request.getParameter("accion");
		if (accion != null && !accion.equals("")) {
			request.getSession().setAttribute("statusBusqueda", "N");
			if (accion.equals("buscar")) {
				try {
					request.getSession().setAttribute("statusBusqueda", "N");
					if (usuario.getNumDocumento() == null
							|| usuario.getNumDocumento().equals("")) {
						errors.add(null, new ActionMessage("errors.required",
								LenguajeUtil.getMensaje(request,
										"datosusuario.NIF")));
					} else {
						if (usuario.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
							errors.add(null, new ActionMessage(
									"errors.maxlength", LenguajeUtil
											.getMensaje(request,
													"datosusuario.NIF")));
						} else {
							if (!ValidatorUtils
									.esNIF(usuario.getNumDocumento())) {

								errors.add(null,
										new ActionMessage("errors.Nif"));
							} else {

								// this.getUsuario().setNombre("");
								// this.getUsuario().setApellido1("");
								// this.getUsuario().setApellido2("");
								// this.getUsuario().setEmail("");
								// this.getUsuario().setMovil("");
								// this.getUsuario().setTelefono("");
								// this.setOpcionPerfil(new Integer("1"));
								// this.setOpcionCentro(new Integer("-1"));

								List listaUsuarios = new ArrayList();

								listaUsuarios = usuarioService
										.findByNumeroDocumento(this.usuario
												.getNumDocumento().toUpperCase());

								if (!listaUsuarios.isEmpty()) {
									Usuario usuario = (Usuario) listaUsuarios
											.get(0);
									String dni = usuario.getNumDocumento();
									List listaRelacionAdministradorGlobal = relacionUsuOrgCentroPerfService
											.findByUsuPerf(
													dni,
													String
															.valueOf(Constantes.ADMIN_GLOBAL));
									List listaRelacionAdministradorLocal = relacionUsuOrgCentroPerfService
											.findByUsuPerf(
													dni,
													String
															.valueOf(Constantes.ADMIN_LOCAL));
									if (!listaRelacionAdministradorGlobal
											.isEmpty()
											|| !listaRelacionAdministradorLocal
													.isEmpty()) {
										errors.add(null, new ActionMessage(
												"errors.usuarioExistente"));
									} else {
										setUsuario(usuario);
										request.getSession().setAttribute(
												"statusBusqueda", "S");
										this.setDesactivarCampos(false);
									}
								} else {
									request.getSession().setAttribute(
											"statusBusqueda", "S");
									this.setDesactivarCampos(false);
								}
							}
						}
					}
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			if (usuario.getNumDocumento() == null
					|| usuario.getNumDocumento().equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
			} else {
				if (usuario.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil
									.getMensaje(request, "datosusuario.NIF")));
				} else {
					if (!ValidatorUtils.esNIF(usuario.getNumDocumento())) {
						errors.add(null, new ActionMessage("errors.Nif"));
					}
				}
			}

			if (usuario.getNombre() == null || usuario.getNombre().equals("")) {
				errors.add(null,
						new ActionMessage("errors.required", LenguajeUtil
								.getMensaje(request, "datosusuario.nombre")));
			} else {
				if (usuario.getNombre().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.nombre")));
			}

			if (usuario.getApellido1() == null
					|| usuario.getApellido1().equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request,
								"datosusuario.apellido1")));
			} else {
				if (usuario.getApellido1().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.apellido1")));
			}

			if (usuario.getApellido2() == null
					|| usuario.getApellido2().equals("")) {
				errors.add(null, new ActionMessage("errors.required",
						LenguajeUtil.getMensaje(request,
								"datosusuario.apellido2")));
			} else {
				if (usuario.getApellido2().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength",
							LenguajeUtil.getMensaje(request,
									"datosusuario.apellido2")));
			}

			if (usuario.getTelefono() == null
					|| usuario.getTelefono().equals("")) {
				
			} else if (!ValidatorUtils.isTelefono(usuario.getTelefono(), true,
					true, "")) {
				errors.add(null, new ActionMessage("errors.telefono"));
			}

			if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
				errors
						.add(null, new ActionMessage("errors.required",
								LenguajeUtil.getMensaje(request,
										"datosusuario.email")));
			} else if (!ValidatorUtils.isEmail(usuario.getEmail())) {
				errors.add(null, new ActionMessage("errors.email"));
			}

			if ((opcion == null || opcion.equals(""))
					&& this.administradorGlobal == false) {
				errors.add(null, new ActionMessage(
						"errors.organismoAdministradorGlobal"));
			}
			
			List listaRelacionAdministradorGlobal;
			try {
				listaRelacionAdministradorGlobal = relacionUsuOrgCentroPerfService
						.findByUsuPerf(this.usuario.getNumDocumento(), String
								.valueOf(Constantes.ADMIN_GLOBAL));
			
			List listaRelacionAdministradorLocal = relacionUsuOrgCentroPerfService
					.findByUsuPerf(this.usuario.getNumDocumento(), String
							.valueOf(Constantes.ADMIN_LOCAL));
			if (!listaRelacionAdministradorGlobal.isEmpty()
					|| !listaRelacionAdministradorLocal.isEmpty()) {
				errors.add(null, new ActionMessage("errors.usuarioExistente"));
			}
			if (opcion != null && !opcion.equals("")) {
				List listaRelacionPublicador = relacionUsuOrgCentroPerfService
						.findByOrgUsuPerf(opcion, this.usuario
								.getNumDocumento(), String
								.valueOf(Constantes.PUBLICADOR));
				List listaRelacionRedactor = relacionUsuOrgCentroPerfService
						.findByOrgUsuPerf(opcion, this.usuario
								.getNumDocumento(), String
								.valueOf(Constantes.REDACTOR));

				if (!listaRelacionPublicador.isEmpty()
						|| !listaRelacionRedactor.isEmpty()) {
					errors.add(null, new ActionMessage(
							"errors.usuarioExisteOrganismo"));
				}
			}
			request.setAttribute("validaCampos", "si");
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;
	}

	public boolean isDesactivarCampos() {
		return desactivarCampos;
	}

	public void setDesactivarCampos(boolean desactivarCampos) {
		this.desactivarCampos = desactivarCampos;
	}

}
