/**
 * Autor: ggomez - Novasoft - Jaén (2011) 
 * Archivo: InitSession.java
 * Creado: 15/06/2011
 * Version: 1.0
 * Descripcion:
 * 
 * Esta clase 
 */
package es.novasoft.sitae.init;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.OrganismoVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

/**
 * @author ggomez
 * 
 */
public final class InitSession {

	public static void doInit(HttpServletRequest request) {

		HttpSession sesion = request.getSession(true);

		grabarDiaEnSesion(sesion);

		grabarLocaleEnSesion(request);

		grabarOrganismoEnSesion(request);
	}

	public static void doReinit(HttpServletRequest request) {

		HttpSession sesion = request.getSession();
		if (sesion != null) {
			sesion.invalidate();
		}

		doInit(request);
	}

	/**
	 * @param sesion
	 *            El organismo se obtiene del nombre del host.
	 */
	private static void grabarOrganismoEnSesion(HttpServletRequest request) {
		Organismo organismo = getOrganismo(request);
		String cif = organismo.getCif();
		request.getSession().setAttribute("cif", cif);
		OrganismoVisualizar OrganismoVisualizar = new OrganismoVisualizar(organismo, request);
		request.getSession().setAttribute("organismoSesion", OrganismoVisualizar);

	}

	/**
	 * @param request
	 */
	private static void grabarLocaleEnSesion(HttpServletRequest request) {
		Locale locale = null;
		if (request.getParameter("lenguaje") != null && !request.getParameter("lenguaje").equals("")) {
			locale = getLanguage(request.getParameter("lenguaje"));
		} else {
			locale = getLanguage("es");
		}

		request.getSession().setAttribute(Globals.LOCALE_KEY, locale);

	}

	/**
	 * Gets the language.
	 * 
	 * @param idioma
	 *            the idioma
	 * @return the language
	 */
	private static Locale getLanguage(String idioma) {
		if (idioma.equals("va")) {
			return new Locale("va", "ES");
		}
		return new Locale("es", "ES");
	}

	/**
	 * Grabar dia en sesion.
	 * 
	 * @param sesion
	 *            the request
	 */
	private static void grabarDiaEnSesion(HttpSession sesion) {
		Locale locale = new Locale("ca", "ES");
		DateFormat formatter = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy ", locale);
		String fechaSesion = formatter.format(new Date());
		sesion.setAttribute("fechaSesionVA", fechaSesion);
		locale = new Locale("es", "ES");
		formatter = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy ", locale);
		fechaSesion = formatter.format(new Date());
		sesion.setAttribute("fechaSesionES", fechaSesion);
	}

	/**
	 * @param request
	 * @return
	 */
	private static Organismo getOrganismo(HttpServletRequest request) {
		Organismo organismoEncontrado = null;
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		try {
			String serverName = request.getServerName();
			System.out.println("serverName :" + serverName);
			@SuppressWarnings("unchecked")
			List<Organismo> listadoOrganismos = organismoService.findAll();
			for (Organismo organismo : listadoOrganismos) {
				String dominio = organismo.getDominio();
				if (dominio.contains(serverName)) {
					organismoEncontrado = organismo;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return organismoEncontrado;
	}
}
