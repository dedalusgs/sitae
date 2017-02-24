package es.novasoft.sitae.login.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.OrganismoVisualizar;
import es.novasoft.sitae.login.service.SafeService;
//import com.cv.xaloc.security.SessionBean;
//import com.cv.xaloc.security.DatosCertificado;

public class EntrarConCertificadoDoAction extends ActionBase {

	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		SafeService clienteSafe = (SafeService) Factory.getBean("ServicioSafe");

		Log log = LogFactory.getLog(EntrarConCertificadoDoAction.class);

		String certificado = request.getParameter("certificado");
		String redirectUrl = request.getParameter("redirectUrl");

		// -- Validamos el UUID
		String loginUUID = (String) request.getSession().getAttribute("loginUUID");
		String uuid = request.getParameter("uuid");

		OrganismoVisualizar entidad = (OrganismoVisualizar) request.getSession().getAttribute("organismoSesion");
		String idEntidad = entidad.getCodigo();

		String resultado = clienteSafe.validarCertificadoNIF(entidad, certificado);
		log.warn("El resultado de Safe es: " + resultado);
		log.info("entrarCertificado");
		log.debug("redirectUrl: " + redirectUrl);

		if (resultado == null) {
			log.error("Petición no válida realizada a Safe:");
			request.getSession().setAttribute("valuerror", "ERR_USU_PETICION_V"); // OJOOOO!!!
			request.getSession().setAttribute("causerror", "ERR_USU_PETICION_C"); // OJOOO!!!

			return mapping.findForward(Constantes.ERROR);
		}

		else { // if (ret != null)

			request.setAttribute("nif", resultado);

			request.getSession().setAttribute("nif", resultado);

			// END - EMB - numero de notificaciones en session

		}

		return mapping.findForward(Constantes.SUCCESS);

	}

}
