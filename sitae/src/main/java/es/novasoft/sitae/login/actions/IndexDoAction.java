package es.novasoft.sitae.login.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.OrganismoVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.login.forms.IndexForm;

public class IndexDoAction extends ActionBase {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Locale locale = null;
		if (request.getParameter("lenguaje") != null
				&& !request.getParameter("lenguaje").equals("")) {
			locale = getLanguage(request.getParameter("lenguaje"));
		} else {
			locale = getLanguage("es");
		}

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		IndexForm formulario = (IndexForm) form;

		List<Organismo> organismos = organismoService.findAll();
		List<OrganismoVisualizar> organismosVisualizar = new ArrayList();

		Iterator it = organismos.iterator();

		while (it.hasNext()) {
			Organismo organismo = (Organismo) it.next();
			OrganismoVisualizar organismoVisualizar = new OrganismoVisualizar(
					organismo);
			/*
			 * String protocol = request.getProtocol(); int serverPort =
			 * request.getServerPort(); String contextPath =
			 * request.getContextPath();
			 * organismoVisualizar.setRequestToUrl(protocol, serverPort,
			 * contextPath);
			 */
			organismosVisualizar.add(organismoVisualizar);
		}
		formulario.setOrganismos(organismosVisualizar);
		grabarDiaEnSesion(request);
		return mapping.findForward(Constantes.SUCCESS);

	}

	private Locale getLanguage(String idioma) {
		if (idioma.equals("va")) {
			return new Locale("va", "ES");
		}
		return new Locale("es", "ES");
	}

	private void grabarDiaEnSesion(HttpServletRequest request) {
		Locale locale = new Locale("ca", "ES");
		DateFormat formatter = new SimpleDateFormat(
				"EEEE, dd 'de' MMMM 'de' yyyy ", locale);
		String fechaSesion = formatter.format(new Date());
		request.getSession().setAttribute("fechaSesionVA", fechaSesion);
		locale = new Locale("es", "ES");
		formatter = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy ",
				locale);
		fechaSesion = formatter.format(new Date());
		request.getSession().setAttribute("fechaSesionES", fechaSesion);
	}
}
