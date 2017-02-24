package es.novasoft.sitae.perfiles.adminLocal.social.facebook;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.FacebookService;
import es.novasoft.comun.socialservice.FacebookSession;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RedSocial;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RedSocialService;
import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.Permission;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;

public class CallBackFacebookAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cif = (String) request.getSession().getAttribute("cif");

		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		RedSocialService redSocialService = (RedSocialService) Factory.getBean(ServiceConstants.REDSOCIAL_BEAN_NAME);
		FacebookService facebookService = (FacebookService) Factory.getBean(ServiceConstants.FACEBOOK_BEAN_NAME);

		String idSeleccionado = request.getParameter("idSeleccionado");
		HttpSession session = request.getSession();
		String recarga = request.getParameter("recarga");
		String facebookToken = request.getParameter("facebookToken");

		if (facebookToken == null) {
			facebookToken = (String) session.getAttribute("facebookToken");
		}

		if (facebookToken != null && !facebookToken.equals("")) {

			FacebookSession facebookSesion = facebookService.obtener(facebookToken);
			Facebook facebook = facebookSesion.getFacebook();
			Organismo organismo = facebookSesion.getOrganismo();
			if (facebookSesion.isSinValidar()) {
				String oauthCode = request.getParameter("code");
				if (oauthCode != null && !oauthCode.equals("")) {
					ArrayList<RedSocial> listaCuentas = new ArrayList<RedSocial>();
					try {
						AccessToken token = facebook.getOAuthAccessToken(oauthCode);
						List<Permission> permisos = facebook.getPermissions();
						facebookSesion.setUsuarioAprobado();
						return forward(request, mapping, ActionBase.SUCCESS_KEY);
					} catch (Exception e) {
						facebookSesion.setUsuarioNoAprobado();
						return forward(request, mapping, ActionBase.SUCCESS_KEY);
					}
				} else {
					if (recarga == null) {
						return forward(request, mapping, ActionBase.SUCCESS_KEY);
					} else {
						facebookService.sacar(facebookToken);
						session.setAttribute("facebookToken", null);
						request.setAttribute("errorFacebook", "noConcededido");
						return forward(request, mapping, ActionBase.ERROR_KEY);
					}
				}
			} else if (facebookSesion.isUsuarioAprobado()) {
				if (idSeleccionado == null || idSeleccionado.equals("")) {

					ArrayList<RedSocial> listaCuentas = new ArrayList<RedSocial>();
					User user = facebook.getMe();
					URL url = facebook.getPagePictureURL();
					RedSocial usuario = new RedSocial();
					usuario.setTokenCuenta(facebook.getOAuthAccessToken().getToken());
					usuario.setIdCuenta(user.getId());
					usuario.setNombre(user.getName());
					usuario.setTipo(RedSocial.TIPO_FACEBOOK);
					usuario.setUrlImgUser(facebook.getPagePictureURL().toString());
					usuario.setUrlUser(facebook.getPage().getLink().toString());
					listaCuentas.add(usuario);

					ResponseList<Account> listaPage = facebook.getAccounts();
					if (listaPage.size() > 0) {
						for (Account account : listaPage) {
							facebook.setOAuthAccessToken(new AccessToken(account.getAccessToken(), null));
							URL url2 = facebook.getPagePictureURL();
							RedSocial redsocial = new RedSocial();
							redsocial.setTokenCuenta(account.getAccessToken());
							redsocial.setIdCuenta(account.getId());
							redsocial.setNombre(account.getName());
							redsocial.setTipo(RedSocial.TIPO_FACEBOOK);
							redsocial.setUrlImgUser(facebook.getPagePictureURL().toString());
							redsocial.setUrlUser(facebook.getPage().getLink().toString());
							listaCuentas.add(redsocial);
						}

						session.setAttribute("listadoCuentas", listaCuentas);
						return forward(request, mapping, ActionBase.SUCCESS_KEY_2);
					} else {
						if (organismo.getFacebook() != null) {
							redSocialService.delete(organismo.getFacebook());
						}
						facebookService.sacar(facebookToken);
						session.setAttribute("facebookToken", null);
						redSocialService.delete(organismo.getFacebook());
						redSocialService.attachDirty(usuario);
						organismo.setFacebook(usuario);
						organismoService.attachDirty(organismo);
						return forward(request, mapping, ActionBase.SUCCESS_KEY_3);
					}
				} else {
					ArrayList<RedSocial> lista = (ArrayList<RedSocial>) session.getAttribute("listadoCuentas");
					RedSocial redSocialSeleccionada = null;
					for (RedSocial redSocial : lista) {
						if (redSocial.getIdCuenta().equals(idSeleccionado)) {
							redSocialSeleccionada = redSocial;
						}
					}
					if (redSocialSeleccionada == null) {
						return forward(request, mapping, ActionBase.ERROR_KEY);
					}

					facebookService.sacar(facebookToken);
					session.setAttribute("facebookToken", null);
					if (organismo.getFacebook() != null) {
						redSocialService.delete(organismo.getFacebook());
					}
					redSocialService.attachDirty(redSocialSeleccionada);
					organismo.setFacebook(redSocialSeleccionada);
					organismoService.attachDirty(organismo);
					return forward(request, mapping, ActionBase.SUCCESS_KEY_3);
				}

			} else if (facebookSesion.isUsuarioNoAprobado()) {
				facebookService.sacar(facebookToken);
				session.setAttribute("facebookToken", null);
				return forward(request, mapping, ActionBase.ERROR_KEY);
			}

		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
