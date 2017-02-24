package es.novasoft.sitae.comun.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.FacebookService;
import es.novasoft.comun.socialservice.GooglePlusService;
import es.novasoft.comun.socialservice.GoogleShortenerService;
import es.novasoft.comun.socialservice.TwitterService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.PublicacionRedesSociales;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.PublicacionRedesSocialesService;

class DesPublicacionRedes implements Runnable {
	private static final Log	log	= LogFactory.getLog(DesPublicacionRedes.class);
	private final Edicto	 edicto;
	
	public DesPublicacionRedes(Edicto edicto) {
		this.edicto = edicto;
	}
	
	public void run() {
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		GoogleShortenerService googleShortenerService = (GoogleShortenerService) Factory.getBean(ServiceConstants.GOOGLESHORTENER_BEAN_NAME);
		FacebookService facebookService = (FacebookService) Factory.getBean(ServiceConstants.FACEBOOK_BEAN_NAME);
		TwitterService twitterService = (TwitterService) Factory.getBean(ServiceConstants.TWITTER_BEAN_NAME);
		GooglePlusService googlePlusService = (GooglePlusService) Factory.getBean(ServiceConstants.GOOGLEPLUS_BEAN_NAME);
		PublicacionRedesSocialesService publicacionRRSSService = (PublicacionRedesSocialesService) Factory.getBean(ServiceConstants.PUBLICACION_REDES_SOCIALES_BEAN_NAME);
		PublicacionRedesSociales publicacion = new PublicacionRedesSociales();
		Organismo organismo = edicto.getOrganismo();
		
		PublicacionRedesSociales publicacionRRDD = edicto.getPublicacionRedesSociales();
		try {
			if (publicacionRRDD.getFacebook() != null && organismo.getFacebook() != null) {
				Boolean resultadoFacebook = facebookService.deletePost(publicacionRRDD.getFacebook(), organismo.getFacebook().getTokenCuenta());
				log.info("Resultado de despublicar en facebook: " + resultadoFacebook);
			}
		} catch (Exception e) {
			log.error("Se ha producido un error despublicando en Facebook", e);
		}
		
		try {
			if (publicacionRRDD.getTwitter() != null && organismo.getTwitter() != null) {
				Long resultadoTwitter = twitterService.deletePost(publicacionRRDD.getTwitter(), organismo.getTwitter().getIdCuenta(), organismo.getTwitter().getTokenCuenta());
				log.info("Resultado de despublicar en twitter: " + resultadoTwitter);
			}
		} catch (Exception e) {
			log.error("Se ha producido un error despublicando en Twitter", e);
		}
		
		try {
			if (publicacionRRDD.getGooglePlus() != null && organismo.getGoogle() != null) {
				String resultadoGoogle = googlePlusService.deletePost(publicacionRRDD.getGooglePlus(), organismo.getGoogle().getTokenCuenta(), organismo.getGoogle().getIdCuenta());
				log.info("Resultado de despublicar en googlePlus: " + resultadoGoogle);
			}
		} catch (Exception e) {
			log.error("Se ha producido un error despublicando en Google", e);
		}
		
	}
}
