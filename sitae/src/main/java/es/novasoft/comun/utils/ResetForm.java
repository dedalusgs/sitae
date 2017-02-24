package es.novasoft.comun.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMapping;

public class ResetForm {

	public ResetForm() {

	}

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