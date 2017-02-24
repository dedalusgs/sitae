package es.novasoft.sitae.perfiles.adminLocal.crearUsuarios.forms;

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
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioExterno;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class CrearUsuariosForm extends FormBase {
    
    private static final long serialVersionUID = 1L;
    
    private List	      listaCentros;
    
    private List	      listaPerfil;
    
    private Usuario	   usuario;
    
    private Integer	   opcionPerfil;
    
    private Integer	   opcionCentro;
    
    private String	    cif;
    
    private boolean	   externo;
    
    private boolean	   desactivarCampos;
    
    private UsuarioExterno    usuarioExterno;
    
    public UsuarioExterno getUsuarioExterno() {
	return this.usuarioExterno;
    }
    
    public void setUsuarioExterno(UsuarioExterno usuarioExterno) {
	this.usuarioExterno = usuarioExterno;
    }
    
    public CrearUsuariosForm() {
	
	this.usuario = new Usuario();
	this.usuarioExterno = new UsuarioExterno();
	this.opcionCentro = -1;
	this.opcionPerfil = 4;
	this.desactivarCampos = true;
	
    }
    
    public String getCif() {
	return this.cif;
    }
    
    public void setCif(String cif) {
	this.cif = cif;
    }
    
    public List getListaCentros() {
	return this.listaCentros;
    }
    
    public void setListaCentros(List listaCentros) {
	this.listaCentros = listaCentros;
    }
    
    public List getListaPerfil() {
	return this.listaPerfil;
    }
    
    public void setListaPerfil(List listaPerfil) {
	this.listaPerfil = listaPerfil;
    }
    
    public Integer getOpcionPerfil() {
	return this.opcionPerfil;
    }
    
    public void setOpcionPerfil(Integer opcionPerfil) {
	this.opcionPerfil = opcionPerfil;
    }
    
    public Integer getOpcionCentro() {
	return this.opcionCentro;
    }
    
    public void setOpcionCentro(Integer opcionCentro) {
	this.opcionCentro = opcionCentro;
    }
    
    public boolean isExterno() {
	return this.externo;
    }
    
    public void setExterno(boolean externo) {
	this.externo = externo;
    }
    
    public Usuario getUsuario() {
	return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
	
	this.setExterno(false);
	
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	
	UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);
	
	ActionErrors errors = new ActionErrors();
	try {
	    if (this.usuario.isInterno()) {
		request.getSession().setAttribute("statusBusqueda", "N");
		// validamos usuario externo
		if (this.usuario.getNumDocumento() == null || this.usuario.getNumDocumento().equals("")) {
		    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.nombreUsuario")));
		} else if (this.usuario.getNumDocumento().length() >= 10) {
		    errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.nombreUsuario")));
		}

		if (errors.isEmpty()) {
		    List listaUsuarios = new ArrayList();
		    listaUsuarios = usuarioService.findByNumeroDocumento(this.usuario.getNumDocumento());
		    if (!listaUsuarios.isEmpty()) {
			errors.add(null, new ActionMessage("errors.usuarioExiste"));
		    }
		}
		
		if (errors.isEmpty()) {
		    
		    String cif = (String) request.getSession().getAttribute("cif");
		    String dni = this.usuario.getNumDocumento();
		    List perfiles = new ArrayList();
		    
		    Perfil perfil = new Perfil();
		    perfil.setIdPerfil(Constantes.REDACTOR);
		    perfiles.add(perfil);
		    
		    perfil = new Perfil();
		    perfil.setIdPerfil(Constantes.PUBLICADOR);
		    perfiles.add(perfil);
		    
		    perfil = new Perfil();
		    perfil.setIdPerfil(Constantes.ADMIN_LOCAL);
		    perfiles.add(perfil);
		    
		    List listaRelacion;
		    
		    listaRelacion = relacionUsuOrgCentroPerfService.findByOrgNifIncluyendoPerfiles(cif, dni, perfiles);
		    
		    if (!listaRelacion.isEmpty()) {
			errors.add(null, new ActionMessage("errors.usuarioAsociadoOrganismo", null));
		    }
		}
		if (this.usuario.getNombre() == null || this.usuario.getNombre().equals("")) {
		    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "organismoExterno.aplicacion")));
		} else if (this.usuario.getNombre().length() >= 20) {
		    errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "organismoExterno.aplicacion")));
		}
		if (this.usuarioExterno.getPassword() == null || this.usuarioExterno.getPassword().equals("")) {
		    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.password")));
		} else {
		    if (this.usuarioExterno.getPassword().length() >= 20) {
			errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.password")));
		    }
		}
		
		if (this.usuario.getEmail() == null || this.usuario.getEmail().equals("")) {
		    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.email")));
		} else if (!ValidatorUtils.isEmail(this.usuario.getEmail())) {
		    errors.add(null, new ActionMessage("errors.email"));
		}
		if (this.opcionPerfil == null || this.opcionPerfil.toString().equals("")) {
		    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.perfil")));
		}
		
		if (this.opcionPerfil.toString().equals("3") && (this.opcionCentro.toString().equals("-1") || this.opcionCentro.toString().equals(""))) {
		    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.centro")));
		}
		
	    } else {
		String accion = request.getParameter("accion");
		if (accion != null && !accion.equals("")) {
		    if (accion.equals("buscar")) {
			request.getSession().setAttribute("statusBusqueda", "N");
			if (this.usuario.getNumDocumento() == null || this.usuario.getNumDocumento().equals("")) {
			    errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
			} else {
			    if (this.usuario.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
				errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
			    } else {
				if (!ValidatorUtils.esNIF(this.usuario.getNumDocumento())) {
				    
				    errors.add(null, new ActionMessage("errors.Nif"));
				} else {
				    
				    List listaUsuarios = new ArrayList();
				    listaUsuarios = usuarioService.findByNumeroDocumento(this.usuario.getNumDocumento().toUpperCase());
				    if (!listaUsuarios.isEmpty()) {
					Usuario usuario = (Usuario) listaUsuarios.get(0);
					String cif = (String) request.getSession().getAttribute("cif");
					String dni = usuario.getNumDocumento();
					List perfiles = new ArrayList();
					
					Perfil perfil = new Perfil();
					perfil.setIdPerfil(Constantes.REDACTOR);
					perfiles.add(perfil);
					
					perfil = new Perfil();
					perfil.setIdPerfil(Constantes.PUBLICADOR);
					perfiles.add(perfil);
					
					perfil = new Perfil();
					perfil.setIdPerfil(Constantes.ADMIN_LOCAL);
					perfiles.add(perfil);
					
					List listaRelacion = relacionUsuOrgCentroPerfService.findByOrgNifIncluyendoPerfiles(cif, dni, perfiles);
					if (!listaRelacion.isEmpty()) {
					    errors.add(null, new ActionMessage("errors.usuarioAsociadoOrganismo", null));
					} else {
					    setUsuario(usuario);
					    request.getSession().setAttribute("statusBusqueda", "S");
					    this.setDesactivarCampos(false);
					}
				    } else {
					request.getSession().setAttribute("statusBusqueda", "S");
					this.setDesactivarCampos(false);
				    }
				}
			    }
			    
			}
			
		    }
		} else {
		    
		    if (this.usuario.getNumDocumento() == null || this.usuario.getNumDocumento().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
		    } else {
			if (this.usuario.getNumDocumento().length() >= Constantes.TAMANIO_MAX) {
			    errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.NIF")));
			} else {
			    if (!ValidatorUtils.esNIF(this.usuario.getNumDocumento())) {
				errors.add(null, new ActionMessage("errors.Nif"));
			    } else {
				List listaUsuarios = new ArrayList();
				listaUsuarios = usuarioService.findByNumeroDocumento(this.usuario.getNumDocumento());
				if (!listaUsuarios.isEmpty()) {
				    Usuario usuario = (Usuario) listaUsuarios.get(0);
				    String cif = (String) request.getSession().getAttribute("cif");
				    String dni = usuario.getNumDocumento();
				    
				    List perfiles = new ArrayList();
				    
				    Perfil perfil = new Perfil();
				    perfil.setIdPerfil(Constantes.REDACTOR);
				    perfiles.add(perfil);
				    
				    perfil = new Perfil();
				    perfil.setIdPerfil(Constantes.PUBLICADOR);
				    perfiles.add(perfil);
				    
				    perfil = new Perfil();
				    perfil.setIdPerfil(Constantes.ADMIN_LOCAL);
				    perfiles.add(perfil);
				    
				    List listaRelacion = relacionUsuOrgCentroPerfService.findByOrgNifIncluyendoPerfiles(cif, dni, perfiles);
				    if (!listaRelacion.isEmpty()) {
					errors.add(null, new ActionMessage("errors.usuarioAsociadoOrganismo", null));
				    }
				}
			    }
			}
		    }
		    
		    if (this.usuario.getNombre() == null || this.usuario.getNombre().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.nombre")));
		    } else {
			if (this.usuario.getNombre().length() >= Constantes.TAMANIO_MAX) {
			    errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.nombre")));
			}
		    }
		    
		    if (this.usuario.getApellido1() == null || this.usuario.getApellido1().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.apellido1")));
		    } else {
			if (this.usuario.getApellido1().length() >= Constantes.TAMANIO_MAX) {
			    errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.apellido1")));
			}
		    }
		    
		    if (this.usuario.getApellido2() == null || this.usuario.getApellido2().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.apellido2")));
		    } else {
			if (this.usuario.getApellido2().length() >= Constantes.TAMANIO_MAX) {
			    errors.add(null, new ActionMessage("errors.maxlength", LenguajeUtil.getMensaje(request, "datosusuario.apellido2")));
			}
		    }
		    
		    if (this.usuario.getTelefono() == null || this.usuario.getTelefono().equals("")) {
			
		    } else if (!ValidatorUtils.isTelefono(this.usuario.getTelefono(), true, true, "")) {
			errors.add(null, new ActionMessage("errors.telefono"));
		    }
		    
		    if (this.usuario.getEmail() == null || this.usuario.getEmail().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.email")));
		    } else if (!ValidatorUtils.isEmail(this.usuario.getEmail())) {
			errors.add(null, new ActionMessage("errors.email"));
		    }
		    
		    if (this.opcionPerfil == null || this.opcionPerfil.toString().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.perfil")));
		    }
		    
		    if (this.opcionPerfil.toString().equals("3") && (this.opcionCentro.toString().equals("-1") || this.opcionCentro.toString().equals(""))) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.centro")));
		    }
		    
		    request.setAttribute("validaCampos", "si");
		}
	    }
	} catch (ServiceException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	if (!errors.isEmpty()) {
	    request.setAttribute("numeroErrores", errors.size());
	}
	return errors;
	
    }
    
    public boolean isDesactivarCampos() {
	return this.desactivarCampos;
    }
    
    public void setDesactivarCampos(boolean desactivarCampos) {
	this.desactivarCampos = desactivarCampos;
    }
    
}
