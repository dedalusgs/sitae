/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: ResetForm.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class ResetForm.
 */
public class ResetForm {

	/**
	 * Instantiates a new reset form.
	 */
	public ResetForm() {

	}

	/**
	 * Removes the bean.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param request
	 *            the request
	 */
	public static void removeBean(ActionMapping mapping,
			HttpServletRequest request) {
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope())) {
				request.removeAttribute(mapping.getAttribute());
			} else {
				HttpSession session = request.getSession();
				session.removeAttribute(mapping.getAttribute());
			}
		}

	}

}