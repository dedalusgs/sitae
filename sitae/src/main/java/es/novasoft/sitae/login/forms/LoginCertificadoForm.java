package es.novasoft.sitae.login.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.Usuario;

public class LoginCertificadoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private String nombreUsuario;

	private boolean administradorGlobal = false;

	private List funcionalidadesAdministradorGlobal;

	private boolean administradorLocal = false;

	private List funcionalidadesAdministradorLocal;

	private boolean publicador = false;

	private List funcionalidadesPublicador;

	private boolean redactor = false;

	private List funcionalidadesRedactor;

	private boolean registrado = false;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public boolean isAdministradorGlobal() {
		return administradorGlobal;
	}

	public void setAdministradorGlobal(boolean administradorGlobal) {
		this.administradorGlobal = administradorGlobal;
	}

	public boolean isAdministradorLocal() {
		return administradorLocal;
	}

	public void setAdministradorLocal(boolean administradorLocal) {
		this.administradorLocal = administradorLocal;
	}

	public boolean isPublicador() {
		return publicador;
	}

	public void setPublicador(boolean publicador) {
		this.publicador = publicador;
	}

	public boolean isRedactor() {
		return redactor;
	}

	public void setRedactor(boolean redactor) {
		this.redactor = redactor;
	}

	public List getFuncionalidadesAdministradorGlobal() {
		return funcionalidadesAdministradorGlobal;
	}

	public void setFuncionalidadesAdministradorGlobal(
			List funcionalidadesAdministradorGlobal) {
		this.funcionalidadesAdministradorGlobal = funcionalidadesAdministradorGlobal;
	}

	public List getFuncionalidadesAdministradorLocal() {
		return funcionalidadesAdministradorLocal;
	}

	public void setFuncionalidadesAdministradorLocal(
			List funcionalidadesAdministradorLocal) {
		this.funcionalidadesAdministradorLocal = funcionalidadesAdministradorLocal;
	}

	public List getFuncionalidadesPublicador() {
		return funcionalidadesPublicador;
	}

	public void setFuncionalidadesPublicador(List funcionalidadesPublicador) {
		this.funcionalidadesPublicador = funcionalidadesPublicador;
	}

	public List getFuncionalidadesRedactor() {
		return funcionalidadesRedactor;
	}

	public void setFuncionalidadesRedactor(List funcionalidadesRedactor) {
		this.funcionalidadesRedactor = funcionalidadesRedactor;
	}

	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuario = usuario;
	}
}
