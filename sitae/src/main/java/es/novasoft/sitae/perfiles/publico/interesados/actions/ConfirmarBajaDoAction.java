package es.novasoft.sitae.perfiles.publico.interesados.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.services.interfaz.InteresadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class ConfirmarBajaDoAction extends ActionBase {

	private static Log log = LogFactory.getLog(ConfirmarBajaDoAction.class);
	private final InteresadoService interesadoService = (InteresadoService) Factory.getBean(ServiceConstants.INTERESADO_BEAN_NAME);
	OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String resultado = ActionBase.ERROR_KEY;
		try {
			String codigoActivacion = request.getParameter("codigoActivacion");

			if (codigoActivacion == null) {
				resultado = ActionBase.ERROR_KEY;
			} else {

				java.util.List<Interesado> interesados = interesadoService.findByProperty("codigo", codigoActivacion);

				Interesado interesado = null;
				if (interesados.size() > 0) {
					interesado = interesados.get(0);
					if (interesado.activo()) {
						interesado.setBooleanActivo(Boolean.FALSE);
						interesado.setCodigo(null);
						interesado.setFechaModificacion(new Date());
						interesadoService.attachDirty(interesado);
						resultado = ActionBase.SUCCESS_KEY;
					} else {
						resultado = ActionBase.ERROR_KEY;
					}

				} else {
					resultado = ActionBase.ERROR_KEY;
				}
			}

		} catch (Exception e) {
			log.error("Error consultando o modificando la bbdd de interesados", e);
			resultado = ActionBase.ERROR_KEY;
		}
		return mapping.findForward(resultado);
	}
}
