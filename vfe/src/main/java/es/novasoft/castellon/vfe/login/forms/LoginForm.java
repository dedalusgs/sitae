/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: LoginCertificadoForm.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.login.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginCertificadoForm.
 */
public class LoginForm extends FormBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nombre usuario. */
	private String usuario;

	/** The password */
	private String password;

	private boolean registrado;
	
	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.ServletRequest)
	 */

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {


		ActionErrors errors = new ActionErrors();

		if (usuario== null || usuario.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "acceso.usuario")));
		}

		if (password== null || password.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "acceso.password")));
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

}
