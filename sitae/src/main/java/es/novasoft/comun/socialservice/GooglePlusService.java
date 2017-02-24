package es.novasoft.comun.socialservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.Plus.Moments.Remove;
import com.google.api.services.plus.model.ItemScope;
import com.google.api.services.plus.model.Moment;

public class GooglePlusService {

	/** Directory to store user credentials. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".store/plus_sample");

	/**
	 * Global instance of the {@link DataStoreFactory}. The best practice is to
	 * make it a single globally shared instance across your application.
	 */
	private static FileDataStoreFactory dataStoreFactory;

	/*
	 * Default HTTP transport to use to make HTTP requests.
	 */
	private static final HttpTransport TRANSPORT = new NetHttpTransport();

	/*
	 * Default JSON factory to use to deserialize JSON.
	 */
	private static final JacksonFactory JSON_FACTORY = new JacksonFactory();

	private final Log log = LogFactory.getLog(this.getClass());

	private String consumerKey;

	private String consumerSecret;

	private String appName;

	private String urlCallBack;

	private final HashMap<String, GooglePlusSession> googleSesionHash = new HashMap<String, GooglePlusSession>();

	public GooglePlusService() {

	}

	public String getUrlCallBack() {
		return urlCallBack;
	}

	public void setUrlCallBack(String urlCallBack) {
		this.urlCallBack = urlCallBack;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getURLAutentication(String state) {
		String url = null;
		url = new GoogleBrowserClientRequestUrl(consumerKey, urlCallBack + "", Arrays.asList("https://www.googleapis.com/auth/plus.login", "https://www.googleapis.com/auth/plus.me",
				"https://www.googleapis.com/auth/userinfo.email", "https://www.googleapis.com/auth/userinfo.profile")).setState(state).set("access_type", "offline")
				.set("request_visible_actions", "http://schemas.google.com/AddActivity").setResponseTypes(Arrays.asList("code")).setApprovalPrompt("force").build();
		return url;
	}

	public GoogleTokenResponse getGoogleTokenResponse(String code) {
		String GLASS_SCOPE = "https://www.googleapis.com/auth/plus.me";

		try {
			dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);

			GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(TRANSPORT, JSON_FACTORY, consumerKey, consumerSecret, Arrays.asList(
					"https://www.googleapis.com/auth/plus.login", "https://www.googleapis.com/auth/plus.me")).setAccessType("offline").setDataStoreFactory(dataStoreFactory).build();
			GoogleTokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(urlCallBack).execute();
			// HttpClient httpClientDefault1 = new DefaultHttpClient();
			//
			// HttpPost httpPost = new
			// HttpPost("https://accounts.google.com/o/oauth2/token");
			// httpPost.setHeader("Content-type",
			// "application/x-www-form-urlencoded");
			//
			// ArrayList<NameValuePair> nameValuePair = new
			// ArrayList<NameValuePair>();
			// nameValuePair.add(new BasicNameValuePair("code", code));
			// nameValuePair.add(new BasicNameValuePair("client_id",
			// consumerKey));
			// nameValuePair.add(new BasicNameValuePair("client_secret",
			// consumerSecret));
			// nameValuePair.add(new BasicNameValuePair("client_id",
			// consumerKey));
			// nameValuePair.add(new BasicNameValuePair("redirect_uri",
			// "http://www.sitae.es:8080/sitaedes/GoogleCallbackAction.do"));
			// nameValuePair.add(new BasicNameValuePair("grant_type",
			// "authorization_code"));
			// httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
			//
			// HttpResponse httpRespnse = httpClientDefault1.execute(httpPost);
			// String content2 = EntityUtils.toString(httpPost.getEntity());
			// // JsonObject json = new JsonObject();;
			// // json.addProperty("code", code);
			// // json.addProperty("client_id", consumerKey);
			// // json.addProperty("client_secret", consumerSecret);
			// // json.addProperty("redirect_uri",
			// // "http://www.sitae.es:8080/sitaedes/GoogleCallbackAction.do");
			// // json.addProperty("grant_type", "authorization_code");
			// // HttpPost
			// // JsonHttpContent content = new JsonHttpContent(JSON_FACTORY,
			// // json);
			// //
			// // HttpRequest request =
			// // TRANSPORT.createRequestFactory().buildPostRequest(new
			// // GenericUrl("https://accounts.google.com/o/oauth2/token"),
			// // content);
			// // HttpResponse response = request.execute();
			// String content = EntityUtils.toString(httpRespnse.getEntity());
			// GoogleTokenResponse token =
			// JSON_FACTORY.fromInputStream(httpRespnse.getEntity().getContent(),
			// GoogleTokenResponse.class);
			return tokenResponse;
		} catch (IOException e) {
			return null;
		}
	}

	public GoogleTokenResponse getGoogleTokenResponse2(String code) {

		try {
			ArrayList<String> array = new ArrayList<String>();

			GoogleAuthorizationCodeTokenRequest authorization = new GoogleAuthorizationCodeTokenRequest(TRANSPORT, JSON_FACTORY, consumerKey, consumerSecret, code, "postmessage");
			authorization.setScopes(array);
			authorization.setGrantType("authorization_code");
			authorization.setRedirectUri("http://www.sitae.es:8080/sitaedes/GoogleCallbackAction.do");
			return authorization.execute();
		} catch (IOException e) {
			return null;
		}
	}

	public Plus getPlusService(String tokenData) {
		GoogleCredential credential;
		try {
			credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY).setTransport(TRANSPORT).setClientSecrets(consumerKey, consumerSecret).build();
			credential.setFromTokenResponse(JSON_FACTORY.fromString(tokenData, GoogleTokenResponse.class));
			String accesToken = credential.getAccessToken();
			// Create a new authorized API client.
			Plus service = new Plus.Builder(TRANSPORT, JSON_FACTORY, credential).setApplicationName(appName).build();
			return service;
		} catch (IOException e) {
			return null;
		}
	}

	public Plus getPlusService2(String refreshToken) {
		GoogleCredential credential;
		try {
			credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY).setTransport(TRANSPORT).setClientSecrets(consumerKey, consumerSecret).build();
			credential.setRefreshToken(refreshToken);
			// Create a new authorized API client.
			Plus service = new Plus.Builder(TRANSPORT, JSON_FACTORY, credential).setApplicationName(appName).build();
			return service;
		} catch (Exception e) {
			return null;
		}
	}

	public String publicPost(SocialPost post, String token, String userId) {
		String idResultado = null;
		try {

			GoogleRefreshTokenRequest aut = new GoogleRefreshTokenRequest(TRANSPORT, JSON_FACTORY, token, consumerKey, consumerSecret).setGrantType("refresh_token");
			GoogleTokenResponse tokenResponse = aut.execute();

			// authorization

			// set up global Plus instance
			Plus plus = getPlusService(tokenResponse.toString());

			Moment moment = new Moment();

			ItemScope itemScope = new ItemScope();

			moment.setType("http://schemas.google.com/AddActivity");
			itemScope.setType("http://schemas.google.com/AddActivity");
			itemScope.setName(post.getTitulo());
			itemScope.setDescription(post.getDescripcion());
			itemScope.setId("target-id-1");
			itemScope.setImage(post.getUrlImg());
			itemScope.setContentUrl(post.getUrl());
			moment.setTarget(itemScope);

			Moment momentResult;

			momentResult = plus.moments().insert(userId, "vault", moment).execute();
			idResultado = momentResult.getId();
		} catch (IOException e) {
			log.error("Error publicando en google Plus", e);
			return null;
		}
		return idResultado;

	}

	public String deletePost(String id, String token, String userId) {
		String idResultado = null;
		try {

			GoogleRefreshTokenRequest aut = new GoogleRefreshTokenRequest(TRANSPORT, JSON_FACTORY, token, consumerKey, consumerSecret).setGrantType("refresh_token");
			GoogleTokenResponse tokenResponse = aut.execute();
			Plus plus = getPlusService(tokenResponse.toString());
			Remove remove = plus.moments().remove(id);
			idResultado = remove.getId();
		} catch (IOException e) {
			log.error("Error publicando en google Plus", e);
			return null;
		}
		return idResultado;

	}

	public Boolean publicPost2(SocialPost post, String token, String userId) {

		GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY).setTransport(TRANSPORT).setClientSecrets(consumerKey, consumerSecret).build();
		credential.setAccessToken(token);
		Plus plusService = new Plus.Builder(TRANSPORT, JSON_FACTORY, credential).setApplicationName(appName).build();

		Moment moment = new Moment();
		moment.setType("http://schemas.google.com/AddActivity");
		ItemScope itemScope = new ItemScope();
		itemScope.setId(userId);
		itemScope.setType("http://schemas.google.com/AddActivity");
		itemScope.setName(post.getTitulo());
		itemScope.setDescription(post.getDescripcion());
		// itemScope.setUrl(post.getUrl());
		itemScope.setImage(post.getUrlImg());
		moment.setTarget(itemScope);

		Moment momentResult;
		try {
			momentResult = plusService.moments().insert(userId, "vault", moment).execute();
		} catch (IOException e) {
			log.error("Error publicando en google Plus", e);
			return false;
		}
		if (momentResult != null) {
			return true;
		} else {
			return false;
		}
	}

	public void put(String key, GooglePlusSession googleplusSesion) {
		googleSesionHash.put(key, googleplusSesion);
	}

	public GooglePlusSession obtener(String key) {
		GooglePlusSession googleplusSesion = googleSesionHash.get(key);
		return googleplusSesion;
	}

	public GooglePlusSession sacar(String key) {
		GooglePlusSession googleplusSesion = googleSesionHash.get(key);
		if (googleplusSesion != null) {
			googleSesionHash.remove(key);
		}

		return googleplusSesion;
	}
}
