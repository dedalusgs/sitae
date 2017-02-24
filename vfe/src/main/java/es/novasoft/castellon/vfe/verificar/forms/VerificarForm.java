package es.novasoft.castellon.vfe.verificar.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import nl.captcha.Captcha;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.verificar.ws.IVerificaService;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;

public class VerificarForm extends FormBase {

	private String codigo;
	private String captcha;
	private IVerificaService verificador;
	private static final Log LOGGER = LogFactory.getLog(VerificarForm.class);

	public IVerificaService getVerificador() {
		return verificador;
	}

	public void setVerificador(IVerificaService verificador) {
		this.verificador = verificador;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/**
	 * Funcion para validar el formulario de codigo
	 */

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (codigo == null || codigo.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datos.codigo")));
		}

		if (captcha == null || captcha.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datos.captcha")));
		} else {
			Captcha captchaImg = (Captcha) request.getSession().getAttribute(Captcha.NAME);
			if (!captchaImg.isCorrect(captcha)) {
				request.getSession().setAttribute(Captcha.NAME, null);
				errors.add(null, new ActionMessage("errors.captcha", LenguajeUtil.getMensaje(request, "datos.captcha")));
			}
		}

		if (errors.isEmpty()) {
			ArrayList<IVerificaService> verificadores = (ArrayList<IVerificaService>) Factory.getBean(ServiceConstants.VERIFICADORES_BEAN_NAME);
			boolean codigoValidado = false;
			for (int i = 0; i < verificadores.size(); i++) {
				IVerificaService verificador = verificadores.get(i);

				if (verificador.checkCodigo(getCodigo(), (Organismo) request.getSession().getAttribute("organismoSesion"))) {
					LOGGER.debug("CODIGO correcto con el verificador : " + verificador.toString());
					setVerificador(verificador);
					codigoValidado = true;
				}
			}
			if (!codigoValidado) {
				errors.add(null, new ActionMessage("errors.codigo"));
			}
		}
		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}
}
