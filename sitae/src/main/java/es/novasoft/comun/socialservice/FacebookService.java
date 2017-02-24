package es.novasoft.comun.socialservice;

import java.net.URL;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookService {

	private final Log log = LogFactory.getLog(this.getClass());

	private String idAplicacion;

	private String claveSecreta;

	private String permisos;

	private String urlCallback;

	private final HashMap<String, FacebookSession> facebookSesionHash = new HashMap<String, FacebookSession>();

	public String getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getClaveSecreta() {
		return claveSecreta;
	}

	public void setClaveSecreta(String claveSecreta) {
		this.claveSecreta = claveSecreta;
	}

	public String getPermisos() {
		return permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	public Facebook getInstancia() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthAppId(idAplicacion).setOAuthAppSecret(claveSecreta).setOAuthPermissions(permisos);

		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();

		return facebook;
	}

	public String publicPost(SocialPost post, String token) {
		String idResultado = null;
		try {
			Facebook facebook = getInstancia();
			AccessToken accestoken = new AccessToken(token, null);
			facebook.setOAuthAccessToken(accestoken);
			PostUpdate postFacebook = new PostUpdate(new URL(post.getUrl())).name(post.getTitulo()).description(post.getDescripcion());
			if (post.getUrlImg() != null && !post.equals("")) {
				postFacebook.picture(new URL(post.getUrlImg()));
			}
			postFacebook.caption(post.getDominio());
			idResultado = facebook.postFeed(postFacebook);
		} catch (Exception e) {
			log.error("Error Publicando en Facebook", e);
			return null;
		}
		return idResultado;
	}

	public Boolean deletePost(String id, String token) {
		try {
			Facebook facebook = getInstancia();
			AccessToken accestoken = new AccessToken(token, null);
			facebook.setOAuthAccessToken(accestoken);
			return facebook.deletePost(id);
		} catch (FacebookException e) {
			return Boolean.FALSE;
		}

	}

	public void put(String key, FacebookSession facebook) {
		facebookSesionHash.put(key, facebook);
	}

	public FacebookSession obtener(String key) {
		FacebookSession facebook = facebookSesionHash.get(key);
		return facebook;
	}

	public FacebookSession sacar(String key) {
		FacebookSession facebook = facebookSesionHash.get(key);
		if (facebook != null) {
			facebookSesionHash.remove(key);
		}

		return facebook;
	}

	public String getUrlCallback() {
		return urlCallback;
	}

	public void setUrlCallback(String urlCallback) {
		this.urlCallback = urlCallback;
	}

}
