package es.novasoft.sitae.perfiles.adminLocal.modificarUsuarios.forms;

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
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class ModificarUsuariosForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private List listaCentrosProcedencia;

	private List listaCentros;

	private List listaPerfil;

	private Integer opcionPerfil;

	private String opcionCentro;

	private List listaCentrosProcedenciaAsignados;

	private String passwordActual;

	public String getPasswordActual() {
		return passwordActual;
	}

	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}

	private String passwordNuevo;

	public String getPasswordNuevo() {
		return passwordNuevo;
	}

	public void setPasswordNuevo(String passwordNuevo) {
		this.passwordNuevo = passwordNuevo;
	}

	private UsuarioExterno usuarioExterno;

	public UsuarioExterno getUsuarioExterno() {
		return usuarioExterno;
	}

	public void setUsuarioExterno(UsuarioExterno usuarioExterno) {
		this.usuarioExterno = usuarioExterno;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ModificarUsuariosForm() {

		this.usuario = new Usuario();
		this.opcionCentro = "";
		this.opcionPerfil = 4;

	}

	public List getListaCentrosProcedencia() {
		return listaCentrosProcedencia;
	}

	public void setListaCentrosProcedencia(List listaCentrosProcedencia) {
		this.listaCentrosProcedencia = listaCentrosProcedencia;
	}

	public String getOpcionCentro() {
		return opcionCentro;
	}

	public void setOpcionCentro(String opcionCentro) {
		this.opcionCentro = opcionCentro;
	}

	/**
	 * Función para validar el alta de Organismo
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		PerfilService perfilService = (PerfilService) Factory
				.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
				.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		EdictoService edictoService = (EdictoService) Factory
				.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory
				.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		ActionErrors errors = new ActionErrors();

		UsuarioService usuarioService = (UsuarioService) Factory
				.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		// Validamos los datos al pulsar el boton de guardar.

		if (request.getParameter("accion") == null) {
			if (usuario.isInterno()) {

				if ((this.passwordNuevo != null && !this.passwordNuevo
						.equals(""))
						|| (this.passwordActual != null && !this.passwordActual
								.equals(""))) {
					if (this.passwordActual == null
							|| this.passwordActual.equals("")) {
						errors.add(null, new ActionMessage("errors.required",
								LenguajeUtil.getMensaje(request,
										"datosusuario.passwordActual")));
					} else {
						if (this.passwordActual.length() >= Constantes.TAMANIO_MAX)
							errors.add(null, new ActionMessage(
									"errors.maxlength",
									LenguajeUtil.getMensaje(request,
											"datosusuario.passwordActual")));

						if (!this.passwordActual.equals(usuarioExterno
								.getPassword())) {
							errors.add(null, new ActionMessage(
									"errors.passwordInvalido"));
						}
					}

					if (this.passwordNuevo == null
							|| this.passwordNuevo.equals("")) {
						errors.add(null, new ActionMessage("errors.required",
								LenguajeUtil.getMensaje(request,
										"datosusuario.passwordNuevo")));
					} else {
						if (this.passwordNuevo.length() >= Constantes.TAMANIO_MAX)
							errors.add(null, new ActionMessage(
									"errors.maxlength",
									LenguajeUtil.getMensaje(request,
											"datosusuario.passwordNuevo")));
					}
				} else {
					passwordNuevo = "";
					passwordActual = "";
				}
				if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.email")));
				} else if (!ValidatorUtils.isEmail(usuario.getEmail())) {
					errors.add(null, new ActionMessage("errors.email"));
				}

				if (opcionPerfil == null || opcionPerfil.toString().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.perfil")));
				}

			} else {
				if (usuario.getNombre().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.nombre")));
				} else {
					if (usuario.getNombre().length() >= Constantes.TAMANIO_MAX)
						errors.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datosusuario.nombre")));
				}

				if (usuario.getApellido1().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.apellido1")));
				} else {
					if (usuario.getApellido1().length() >= Constantes.TAMANIO_MAX)
						errors.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datosusuario.apellido1")));
				}

				if (usuario.getApellido2().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.apellido2")));
				} else {
					if (usuario.getApellido2().length() >= Constantes.TAMANIO_MAX)
						errors.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"datosusuario.apellido2")));
				}

				if (usuario.getTelefono().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.telefono")));
				} else if (!ValidatorUtils.isTelefono(usuario.getTelefono(),
						true, true, "")) {
					errors.add(null, new ActionMessage("errors.telefono"));
				}

				if (usuario.getEmail().equals("")) {
					errors.add(null, new ActionMessage("errors.required",
							LenguajeUtil.getMensaje(request,
									"datosusuario.email")));
				} else if (!ValidatorUtils.isEmail(usuario.getEmail())) {
					errors.add(null, new ActionMessage("errors.email"));
				}

				if (this.getOpcionPerfil() == null) {
					errors.add(null, new ActionMessage("errors.required",
							"La opcion es requerida"));
				} else {
					if (this.getOpcionPerfil().intValue() == Constantes.PUBLICADOR) {
						if (this.getOpcionCentro().equals("-1")) {
							errors.add(null, new ActionMessage(
									"errors.required", LenguajeUtil.getMensaje(
											request, "datosusuario.centro")));
						}
					}
				}
			}
		} else {

			if (request.getParameter("accion").equals("del")) {
				String dni = (String) request.getSession().getAttribute(
						"ModificarUsuariosDNI");
				List listaUsuarios;
				try {
					listaUsuarios = usuarioService.findByNumeroDocumento(dni);

					Usuario usuario = (Usuario) listaUsuarios.get(0);
					String idRelacionado = request
							.getParameter("idCentroSelecionado");
					Integer idInteger = Integer.parseInt(idRelacionado);
					CentroProcedencia centroProcedencia = centroProcedenciaService
							.findById(idInteger);
					List listaEdictos = edictoService
							.findByCentroYEstadosExPRYPubORed(centroProcedencia
									.getIdCentro(), usuario.getIdUsuario());
					if (listaEdictos.size() != 0) {
						errors.add(null, new ActionMessage(
								"errors.edictosAsociadoCentro"));
					}
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	public List getListaCentrosProcedenciaAsignados() {
		return listaCentrosProcedenciaAsignados;
	}

	public void setListaCentrosProcedenciaAsignados(
			List listaCentrosProcedenciaAsignados) {
		this.listaCentrosProcedenciaAsignados = listaCentrosProcedenciaAsignados;
	}

	public List getListaCentros() {
		return listaCentros;
	}

	public void setListaCentros(List listaCentros) {
		this.listaCentros = listaCentros;
	}

	public List getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	public Integer getOpcionPerfil() {
		return opcionPerfil;
	}

	public void setOpcionPerfil(Integer opcionPerfil) {
		this.opcionPerfil = opcionPerfil;
	}

}
