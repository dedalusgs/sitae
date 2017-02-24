package es.novasoft.sitae.lenguaje.actions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.lenguaje.forms.CambiarLenguajeForm;

public class CambiarLenguajeDoAction extends ActionBase {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CambiarLenguajeForm cambiarLenguajeForm = null;
		cambiarLenguajeForm = (CambiarLenguajeForm) form;
		request.getSession().setAttribute(Globals.LOCALE_KEY,
				getLanguage(cambiarLenguajeForm.getIdioma()));
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	private Locale getLanguage(String idioma) {
		if (idioma.equals("va")) {
			return new Locale("va", "ES");
		}
		return new Locale("es", "ES");
	}
}
