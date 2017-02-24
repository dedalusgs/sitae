/**
 * Autor: ggomez - Novasoft - Jaén (2011) 
 * Archivo: InitSession.java
 * Creado: 15/06/2011
 * Version: 1.0
 * Descripcion:
 * 
 * Esta clase 
 */
package es.novasoft.castellon.vfe.init;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;

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
		String idOrg = String.valueOf(organismo.getIdOrg());
		request.getSession().setAttribute("idOrg", idOrg);
		request.getSession().setAttribute("organismoSesion", organismo);
		request.getSession().setAttribute("rutaEscudo", "."
				+ Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
				+ "/" + organismo.getCodigo() + "/"
				+ organismo.getNombreImagen());
	}

	/**
	 * @param request
	 */
	private static void grabarLocaleEnSesion(HttpServletRequest request) {

		if (request.getParameter("lenguaje") != null
				&& !request.getParameter("lenguaje").equals("")) {
			request.getSession().setAttribute(Globals.LOCALE_KEY,
					getLanguage(request.getParameter("lenguaje")));
		} else {
			HttpSession sesion = request.getSession();
			if (sesion.getAttribute("lenguajeCambiado") == null
					|| sesion.getAttribute("lenguajeCambiado").equals("")) {
				request.getSession().setAttribute(Globals.LOCALE_KEY,
						getLanguage("es"));
			}
		}

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
			return Constantes.VALENCIANO;
		} else if (idioma.equals("en")) {
			return Constantes.INGLES;
		}

		return Constantes.ESPANYOL;
	}

	/**
	 * Grabar dia en sesion.
	 * 
	 * @param sesion
	 *            the request
	 */
	private static void grabarDiaEnSesion(HttpSession sesion) {
		Locale locale = Constantes.VALENCIANO;
		DateFormat formatter = new SimpleDateFormat(
				"EEEE, dd 'de' MMMM 'de' yyyy ", locale);
		String fechaSesion = formatter.format(new Date());
		sesion.setAttribute("fechaSesionVA", fechaSesion);

		locale = Constantes.ESPANYOL;
		formatter = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy ",
				locale);
		fechaSesion = formatter.format(new Date());
		sesion.setAttribute("fechaSesionES", fechaSesion);

		locale = Constantes.INGLES;
		formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy ", locale);
		fechaSesion = formatter.format(new Date());
		sesion.setAttribute("fechaSesionEN", fechaSesion);

	}

	/**
	 * Devuelve el organismo que concuerde con el host de la url. Si no
	 * encuentra ninguna coincidencia con al host devuelve el primer organismo
	 * de la base de datos. Devuelve null si no hay ningún organismo en la base
	 * de datos.
	 * 
	 * @param request
	 * @return
	 */
	private static Organismo getOrganismo(HttpServletRequest request) {
		Organismo organismoEncontrado = null;
		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		try {
			String serverName = request.getServerName();

			List<Organismo> listadoOrganismos = (List<Organismo>) organismoService
					.findAll();
			for (Organismo organismo : listadoOrganismos) {
				String dominio = organismo.getDominio();
				if (dominio.equals(serverName)) {
					organismoEncontrado = organismo;
					break;
				}
			}

			if (organismoEncontrado == null && !listadoOrganismos.isEmpty()) {
				organismoEncontrado = listadoOrganismos.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return organismoEncontrado;
	}
}
