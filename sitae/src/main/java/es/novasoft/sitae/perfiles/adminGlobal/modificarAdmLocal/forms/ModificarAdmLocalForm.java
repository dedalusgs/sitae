package es.novasoft.sitae.perfiles.adminGlobal.modificarAdmLocal.forms;

import java.util.Iterator;
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
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class ModificarAdmLocalForm extends FormBase {
	
	private static final long	serialVersionUID	= 1L;
	
	private Usuario	          usuario;
	
	private List	          listaOrganismos;
	
	private String	          opcionOrganismo;
	
	private List	          listaOrganismosAsignados;
	
	private boolean	          administradorGlobal;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public ModificarAdmLocalForm() {
		
		this.usuario = new Usuario();
		this.opcionOrganismo = "";
		this.administradorGlobal = false;
	}
	
	public List getListaOrganismos() {
		return listaOrganismos;
	}
	
	public void setListaOrganismos(List listaOrganismos) {
		this.listaOrganismos = listaOrganismos;
	}
	
	public List getListaOrganismosAsignados() {
		return listaOrganismosAsignados;
	}
	
	public void setListaOrganismosAsignados(List listaOrganismosAsignados) {
		this.listaOrganismosAsignados = listaOrganismosAsignados;
	}
	
	public String getOpcionOrganismo() {
		return opcionOrganismo;
	}
	
	public void setOpcionOrganismo(String opcionOrganismo) {
		this.opcionOrganismo = opcionOrganismo;
	}
	
	/**
	 * Función para validar el alta de Organismo
	 */
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		PerfilService perfilService = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		ActionErrors errors = new ActionErrors();
		
		String dniAntiguo = (String) request.getSession().getAttribute("DNI");
		
		UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
		// Validamos los datos al pulsar el boton de guardar.
		if (request.getParameter("accion") == null) {
			
			if (usuario.getNombre().equals("")) {
				errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.nombre")));
			} else {
				if (usuario.getNombre().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.nombre")));
			}
			
			if (usuario.getNumDocumento().equals("")) {
				errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
			} else {
				if (usuario.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
					errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
				} else {
					if (!ValidatorUtils.esNIF(usuario.getNumDocumento())) {
						errors.add(null, new ActionMessage("errors.Nif"));
					} else {
						List listaUsuarios;
						try {
							listaUsuarios = usuarioService.findByNumeroDocumento(usuario.getNumDocumento());
							
							if (!listaUsuarios.isEmpty() && !dniAntiguo.equals(usuario.getNumDocumento())) {
								errors.add(null, new ActionMessage("errors.dniExistente"));
							}
						} catch (ServiceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			if (usuario.getApellido1().equals("")) {
				errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.apellido1")));
			} else {
				if (usuario.getApellido1().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.apellido1")));
			}
			
			if (usuario.getApellido2().equals("")) {
				errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.apellido2")));
			} else {
				if (usuario.getApellido2().length() >= Constantes.TAMANIO_MAX)
					errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.apellido2")));
			}
			
			if (usuario.getTelefono().equals("")) {
				
			} else if (!ValidatorUtils.isTelefono(usuario.getTelefono(), true, true, "")) {
				errors.add(null, new ActionMessage("errors.telefono"));
			}
			
			if (usuario.getEmail().equals("")) {
				errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.email")));
			} else if (!ValidatorUtils.isEmail(usuario.getEmail())) {
				errors.add(null, new ActionMessage("errors.email"));
			}
			String administradorGlobal = (String) request.getParameter("administradorGlobal");
			
			if (administradorGlobal == null) {
				List listaPerfiles;
				try {
					listaPerfiles = relacionUsuOrgCentroPerfService.findByUsuPerf(usuario.getNumDocumento(), String.valueOf(Constantes.ADMIN_LOCAL));
					
					if (listaPerfiles.isEmpty()) {
						errors.add(null, new ActionMessage("errors.organismoAdministradorGlobal"));
					}
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else {
			
			// Validamos si el organismo que vamos a eliminar esta asociado
			// algun edicto que este en cualquiera de las fases de publicacion.
			
			if (request.getParameter("accion").equals("del")) {
				String dni = (String) request.getSession().getAttribute("DNI");
				List listaUsuarios;
				try {
					listaUsuarios = usuarioService.findByNumeroDocumento(dni);
					
					if (!listaUsuarios.isEmpty()) {
						Usuario usuario = (Usuario) listaUsuarios.get(0);
						String idOrgSelecionado = request.getParameter("idOrgSelecionado");
						Integer idInteger = Integer.parseInt(idOrgSelecionado);
						List centrosDeProcedencia = centroProcedenciaService.findAll();
						if (!centrosDeProcedencia.isEmpty()) {
							Iterator it = centrosDeProcedencia.iterator();
							while (it.hasNext()) {
								CentroProcedencia centroProcedencia = (CentroProcedencia) it.next();
								List listaEdictos = edictoService.findByCentroYEstadosExPRYPubORed(centroProcedencia.getIdCentro(), usuario.getIdUsuario());
								if (!listaEdictos.isEmpty()) {
									errors.add(null, new ActionMessage("errors.edictosAsociadoOrganismo"));
									break;
								}
							}
						}
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
	
	public boolean isAdministradorGlobal() {
		return administradorGlobal;
	}
	
	public void setAdministradorGlobal(boolean administradorGlobal) {
		this.administradorGlobal = administradorGlobal;
	}
	
}
