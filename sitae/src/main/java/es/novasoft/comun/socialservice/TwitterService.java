package es.novasoft.comun.socialservice;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterService {
	private String consumerKey;

	private String consumerSecret;

	private final Log log = LogFactory.getLog(this.getClass());
	private HashMap<String, TwitterSession> twitterSesion;

	public TwitterService() {
		twitterSesion = new HashMap<String, TwitterSession>();
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

	public Twitter getInstancia() {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(consumerKey);
		builder.setOAuthConsumerSecret(consumerSecret);
		Configuration configuration = builder.build();
		TwitterFactory factory = new TwitterFactory(configuration);
		Twitter twitter = factory.getInstance();
		return twitter;
	}

	public Twitter getInstancia(String accessToken, String accessTokensecret) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(consumerKey);
		builder.setOAuthConsumerSecret(consumerSecret);
		builder.setOAuthAccessToken(accessToken);
		builder.setOAuthAccessTokenSecret(accessTokensecret);
		Configuration configuration = builder.build();
		TwitterFactory factory = new TwitterFactory(configuration);
		Twitter twitter = factory.getInstance();
		return twitter;
	}

	public HashMap<String, TwitterSession> getTwitterSesion() {
		return twitterSesion;
	}

	public void setTwitterSesion(HashMap<String, TwitterSession> twitterSesion) {
		this.twitterSesion = twitterSesion;
	}

	public void put(String key, TwitterSession twitter) {

		twitterSesion.put(key, twitter);

	}

	public TwitterSession obtener(String key) {
		TwitterSession twitter = twitterSesion.get(key);
		return twitter;
	}

	public TwitterSession sacar(String key) {
		TwitterSession twitter = twitterSesion.get(key);
		if (twitter != null) {
			twitterSesion.remove(key);
		}

		return twitter;
	}

	public Long publicPost(SocialPost post, String token, String secretToken) {

		Twitter twitter = getInstancia(token, secretToken);
		Long idTweet = null;
		int maxCaracter = 140 - (post.getUrl().length() + post.getHashTags().length() + 1);
		String titulo = post.getTitulo();
		if (titulo.length() > maxCaracter) {
			titulo = titulo.substring(0, maxCaracter - 1);
		}
		try {
			idTweet = (twitter.updateStatus(titulo + " " + post.getUrl() + " " + post.getHashTags())).getId();

		} catch (TwitterException e) {
			log.error("Error al publicar Twitter ", e);
			return null;
		}
		return idTweet;
	}

	public Long deletePost(Long id, String token, String secretToken) {

		Twitter twitter = getInstancia(token, secretToken);
		Long idTweet = null;
		Status status = null;

		try {
			status = (twitter.destroyStatus(id.longValue()));

		} catch (TwitterException e) {
			log.error("Error al publicar Twitter ", e);
			return null;
		}
		return status.getId();
	}
}
