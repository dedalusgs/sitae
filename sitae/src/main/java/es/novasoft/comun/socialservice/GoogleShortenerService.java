package es.novasoft.comun.socialservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.UrlshortenerRequestInitializer;
import com.google.api.services.urlshortener.model.Url;

public class GoogleShortenerService {
	private static final Log	        log	         = LogFactory.getLog(GoogleShortenerService.class);
	
	private String	                    clientId;
	
	private String	                    clientSecret;
	
	private String	                    appName;
	
	private static final HttpTransport	TRANSPORT	 = new NetHttpTransport();
	
	private static final JacksonFactory	JSON_FACTORY	= new JacksonFactory();
	
	public GoogleShortenerService() {
		// TODO Auto-generated constructor stub
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getClientSecret() {
		return clientSecret;
	}
	
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	public String getAppName() {
		return appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	public static final String	GOOGLE_SHORTENER_URL	= "https://www.googleapis.com/urlshortener/v1/url?key=API_key";
	
	public String acortarURL(String urllong) {
		
		GoogleClientSecrets clientSecrets;
		try {
			// log.info("Input " +
			// Thread.currentThread().getContextClassLoader().getResourceAsStream("client_secret.apps.googleusercontent.com.json").toString());
			// InputStreamReader input = new
			// InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("/client_secret.apps.googleusercontent.com.json"));
			//
			// clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, input);
			//
			// Set<String> scopes = new HashSet<String>();
			//
			// scopes.add(UrlshortenerScopes.URLSHORTENER);
			// GoogleAuthorizationCodeFlow flow = new
			// GoogleAuthorizationCodeFlow.Builder(TRANSPORT, JSON_FACTORY,
			// clientSecrets, scopes).build();
			// Credential credenciales = new
			// GoogleCredential.Builder().setJsonFactory(JSON_FACTORY).setTransport(TRANSPORT).setClientSecrets(clientId,
			// clientSecret).build();
			// Urlshortener client = new Urlshortener.Builder(TRANSPORT,
			// JSON_FACTORY, credenciales).setApplicationName(appName).build();
			//
			// // GoogleClientSecrets clientSecrets = new GoogleClientSecrets();
			// // Details detail = new Details();
			// // detail.setClientId(clientId);
			// // detail.setClientSecret(clientSecret);
			// // clientSecrets.setInstalled(detail);
			// // Set<String> scopes = new HashSet<String>();
			// // scopes.add(UrlshortenerScopes.URLSHORTENER);
			// // log.info("clientID: " + clientId + "    ClientSecret: " +
			// // clientSecret);
			// // GoogleAuthorizationCodeFlow flow = new
			// // GoogleAuthorizationCodeFlow.Builder(TRANSPORT, JSON_FACTORY,
			// // clientSecrets, scopes).build();
			// // Credential credenciales = new
			// //
			// GoogleCredential.Builder().setJsonFactory(JSON_FACTORY).setTransport(TRANSPORT).setClientSecrets(clientId,
			// // clientSecret).build();
			// // Urlshortener client = new Urlshortener.Builder(TRANSPORT,
			// // JSON_FACTORY,
			// credenciales).setApplicationName(appName).build();
			// Url urlShort = new Url();
			// urlShort.setLongUrl(url);
			//
			// urlShort = client.url().insert(urlShort).execute();
			// return urlShort.getId();
			//
			
			UrlshortenerRequestInitializer shortener = new UrlshortenerRequestInitializer(clientId);
			HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			JsonFactory jsonFactory = new JacksonFactory();
			
			Urlshortener service = new Urlshortener.Builder(httpTransport, jsonFactory, null).setUrlshortenerRequestInitializer(shortener)
			        .setApplicationName("urlshortener-application-example/1.0").build();
			Url url = new Url().setLongUrl(urllong);
			Url result = service.url().insert(url).execute();
			return result.getId();
		} catch (Exception e) {
			return urllong;
		}
		
		// } catch (IOException e) {
		// log.error("Error al acortar url", e);
		// return null;
		// }
	}
	
}
