package es.novasoft.sitae.perfiles.publico.interesados.form;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.InteresadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class BajaSuscripcionForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private String correo;
	private String captcha;
	private final String captchaPublicKey;
	private final String captchaPrivateKey;

	public BajaSuscripcionForm() {
		captchaPublicKey = Constantes.getPropiedad(Constantes.CAPTCHA_PUBLIC_KEY);
		captchaPrivateKey = Constantes.getPropiedad(Constantes.CAPTCHA_PRIVATE_KEY);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		InteresadoService interesadoService = (InteresadoService) Factory.getBean(ServiceConstants.INTERESADO_BEAN_NAME);
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		ActionErrors errors = new ActionErrors();
		if (correo == null || correo.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosusuario.email")));
		} else if (!ValidatorUtils.isEmail(correo)) {
			errors.add(null, new ActionMessage("errors.email"));
		} else {
			Interesado interesado = null;
			try {
				String cifOrganismo = (String) request.getSession().getAttribute("cif");
				Organismo org = (Organismo) organismoService.findByCif(cifOrganismo).get(0);
				interesado = interesadoService.findByEmailOrganismoActivo(correo, org, Boolean.TRUE);
			} catch (Exception e) {
				errors.add(null, new ActionMessage("error.usuarioNoExiste"));
				e.printStackTrace();
			}
			if (interesado == null) {
				errors.add(null, new ActionMessage("error.usuarioNoExiste"));
			}
		}

		ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(captchaPublicKey, captchaPrivateKey, false);
		ReCaptchaResponse response = captcha.checkAnswer(request.getRemoteAddr(), request.getParameter("recaptcha_challenge_field"), request.getParameter("recaptcha_response_field"));
		if (!response.isValid()) {
			errors.add(null, new ActionMessage("error.captcha"));
			captcha = null;
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	private Boolean validarCaptcha(HttpServletRequest request) {

		ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(captchaPublicKey, captchaPrivateKey, false);
		ReCaptchaResponse response = captcha.checkAnswer(request.getRemoteAddr(), request.getParameter("recaptcha_challenge_field"), request.getParameter("recaptcha_response_field"));
		if (response.isValid()) {
			return true;
		} else {
			return false;
		}
	}

}
