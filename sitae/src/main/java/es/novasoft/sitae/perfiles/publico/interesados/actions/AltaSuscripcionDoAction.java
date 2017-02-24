package es.novasoft.sitae.perfiles.publico.interesados.actions;

import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.HashUtil;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.InteresadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.perfiles.publico.interesados.form.SuscripcionForm;

public class AltaSuscripcionDoAction extends ActionBase {

	private static Log log = LogFactory.getLog(AltaSuscripcionDoAction.class);
	OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	InteresadoService interesadoService = (InteresadoService) Factory.getBean(ServiceConstants.INTERESADO_BEAN_NAME);

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			SuscripcionForm formulario = (SuscripcionForm) form;
			String cifOrganismo = (String) request.getSession().getAttribute("cif");
			Organismo org = (Organismo) organismoService.findByCif(cifOrganismo).get(0);
			Interesado interesado = interesadoService.findByEmailOrganismoActivo(formulario.getCorreo(), org, null);
			if (interesado == null) {
				interesado = new Interesado();
			}
			interesado.setBooleanActivo(false);
			interesado.setOrganismo(org);
			Date fecha = new Date();
			interesado.setCodigo(HashUtil.calcularSHAString(Long.toString(fecha.getTime())));
			interesado.setFechaModificacion(fecha);
			if (interesado.getFechaCreacion() == null) {
				interesado.setFechaCreacion(fecha);
			}
			interesado.setEmail(formulario.getCorreo());
			interesadoService.attachDirty(interesado);
			Boolean resultadoPositivo = enviarNotificacion(interesado, request);
			if (!resultadoPositivo) {
				log.error("Error en al notificar al interesado " + interesado.getEmail());
			}

			ResetForm.removeBean(mapping, request);
			return mapping.findForward(ActionBase.SUCCESS_KEY);
		} catch (Exception e) {
			log.error("Error consultando o modificando la bbdd de interesados", e);
			return mapping.findForward(ActionBase.ERROR_KEY);
		}

	}

	private Boolean enviarNotificacion(Interesado interesado, HttpServletRequest request) {
		MailUtils correo = new MailUtils();

		ResourceBundle mailconfig = ResourceBundle.getBundle("mailconfig");

		String asunto = mailconfig.getString("asuntoConfirmacionAlta");

		String mensaje1 = mailconfig.getString("mensajeConfirmacionAlta1");
		String mensaje2 = mailconfig.getString("mensajeConfirmacionAlta2");
		String mensaje3 = mailconfig.getString("mensajeConfirmacionAlta3");

		String mensaje1Va = mailconfig.getString("mensajeConfirmacionAlta1Va");
		String mensaje2Va = mailconfig.getString("mensajeConfirmacionAlta2Va");
		String mensaje3Va = mailconfig.getString("mensajeConfirmacionAlta3Va");
		String protocolo = Constantes.getPropiedad(Constantes.PROTOCOLO);
		String baseUrl = protocolo + "://" + request.getServerName() + request.getContextPath();
		String url = baseUrl + "/ConfirmarSuscripcionDo.do?codigoActivacion=" + interesado.getCodigo() + "&grupoNavegacion=5&servicioNavegacion=-5";
		String url2 = "<p><a href='" + url + "'>" + url + "</a></p>";

		String urlBaja = baseUrl + "/BajaSuscripcionFront.do?grupoNavegacion=5&servicioNavegacion=-5";
		String urlBaja2 = "<p><a href='" + urlBaja + "'>" + baseUrl + "/BajaSuscripcionFront.do</a></p>";

		String mensajeTotal = "<html><head><style type='text/css'>* {font-family: Verdana} </style></head><body><p style='font-size:bold' >" + interesado.getOrganismo().getNombre() + "</p>";
		mensajeTotal += mensaje1 + url2 + mensaje2 + "<br/><br/>" + mensaje3 + urlBaja2;
		mensajeTotal += "<br/><hr/>";
		mensajeTotal += "<p>" + interesado.getOrganismo().getNombreVa() + "</p>";
		mensajeTotal += mensaje1Va + url2 + mensaje2Va + mensaje3Va + urlBaja2;
		mensajeTotal += "</body></html>";
		int resultado = correo.notificar(null, null, interesado.getEmail(), asunto, mensajeTotal);

		if (resultado == 0) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
}
