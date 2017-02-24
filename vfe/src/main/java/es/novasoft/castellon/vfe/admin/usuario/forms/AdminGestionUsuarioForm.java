/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: LoginCertificadoForm.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.admin.usuario.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.FormBase;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginCertificadoForm.
 */
public class AdminGestionUsuarioForm extends FormBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nombre usuario. */
	private String usuario;

	/** The password */
	private String oldPassword;

	private String newPassword;
	
	private String newPasswordCopy;
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordCopy() {
		return newPasswordCopy;
	}

	public void setNewPasswordCopy(String newPasswordCopy) {
		this.newPasswordCopy = newPasswordCopy;
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


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.ServletRequest)
	 */

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {


		ActionErrors errors = new ActionErrors();

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

}
