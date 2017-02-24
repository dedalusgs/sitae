package es.novasoft.sitae.perfiles.publico.interesados.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.perfiles.publico.interesados.form.SuscripcionForm;

public class BajaSuscripcionFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String captchaPublicKey = Constantes.getPropiedad(Constantes.CAPTCHA_PUBLIC_KEY);
		String captchaPrivateKey = Constantes.getPropiedad(Constantes.CAPTCHA_PRIVATE_KEY);

		if (captchaPublicKey == null || captchaPrivateKey == null) {
			return forward(request, mapping, ActionBase.ERROR_KEY);
		} else {
			request.setAttribute("captchaPublicKey", captchaPublicKey);
			request.setAttribute("captchaPrivateKey", captchaPrivateKey);
			request.setAttribute("AltaSuscripcionForm", new SuscripcionForm());
			return forward(request, mapping, ActionBase.SUCCESS_KEY);
		}

	}

}
