/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: LoginConCertificadoDoAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.admin.usuario.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.castellon.vfe.admin.usuario.forms.AdminGestionUsuarioForm;
import es.novasoft.castellon.vfe.business.objects.Usuario;
import es.novasoft.castellon.vfe.business.services.interfaz.UsuarioService;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginConCertificadoDoAction.
 */
public class AdminGestionUsuarioAction extends ActionBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.novasoft.comun.struts.ActionBase#executeAction(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */

	/** The usuario service. */
	private UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String forwardKey = ActionBase.SUCCESS_KEY;

		ActionErrors errors = new ActionErrors();

		if (!errors.isEmpty()) {
			request.setAttribute("errores", errors);
			forwardKey = ActionBase.ERROR_KEY;
		} else {

		}

		return forward(request, mapping, forwardKey);

	}

	/**
	 * Check autenticacion. Primero comprueba que el usuario exista. Luego
	 * prueba la contrase�a.
	 * 
	 */
	private boolean checkUser(String usuario, String password) {
		// TODO Auto-generated method stub

		Usuario user;
		
		try {
			user = usuarioService.findFromUser(usuario);

			if (password.equals(user.getPassword())) {
				return true;
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return false;
	}
}
