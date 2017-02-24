package es.novasoft.sitae.comun.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.FacebookService;
import es.novasoft.comun.socialservice.GooglePlusService;
import es.novasoft.comun.socialservice.GoogleShortenerService;
import es.novasoft.comun.socialservice.SocialPost;
import es.novasoft.comun.socialservice.TwitterService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.PublicacionRedesSociales;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.PublicacionRedesSocialesService;

class PublicacionRedes implements Runnable {
	private static final Log	log	= LogFactory.getLog(PublicacionRedes.class);
	private final Edicto	 edicto;
	
	public PublicacionRedes(Edicto edicto) {
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
		String urlShort = null;
		try {
			String url = UtilUrlWeb.getUrlBase(edicto.getOrganismo(),
			        "/MuestraInformacionEdictoPublicoFrontAction.do?accion=busquedaAvanzada&grupoNavegacion=0&servicioNavegacion=-4&idEdictoSeleccionado=" + edicto.getIdEdicto());
			urlShort = googleShortenerService.acortarURL(url);
			edicto.setUrlAcortada(urlShort);
			// edictoService.attachDirty(edicto);
		} catch (Exception e) {
			log.error("Error obteniendo url acortada ", e);
			return;
		}
		
		SocialPost socialPost = new SocialPost();
		socialPost.setTitulo(edicto.getTitulo());
		socialPost.setDescripcion(edicto.getDescripcion());
		socialPost.setUrl(urlShort);
		socialPost.setHashTags(edicto.getHashtags());
		socialPost.setUrlImg(urlShort);
		socialPost.setDominio(edicto.getOrganismo().getDominio());
		String urlImg = UtilUrlWeb.getUrlBase(edicto.getOrganismo(), "/" + Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS) + "/" + edicto.getOrganismo().getCif() + "/"
		        + edicto.getOrganismo().getNombreImagen());
		socialPost.setUrlImg(null);
		try {
			if (organismo.getFacebook() != null) {
				String resultadoFacebook = facebookService.publicPost(socialPost, organismo.getFacebook().getTokenCuenta());
				log.info("Resultado de publicar en facebook: " + resultadoFacebook);
				publicacion.setFacebook(resultadoFacebook);
			}
		} catch (Exception e) {
			log.error("Se ha producido un error publicando en Facebook", e);
		}
		
		try {
			if (organismo.getTwitter() != null) {
				Long resultadoTwitter = twitterService.publicPost(socialPost, organismo.getTwitter().getIdCuenta(), organismo.getTwitter().getTokenCuenta());
				log.info("Resultado de publicar en twitter: " + resultadoTwitter);
				publicacion.setTwitter(resultadoTwitter);
			}
		} catch (Exception e) {
			log.error("Se ha producido un error publicando en Twitter", e);
		}
		
		try {
			if (organismo.getGoogle() != null) {
				String resultadoGoogle = googlePlusService.publicPost(socialPost, organismo.getGoogle().getTokenCuenta(), organismo.getGoogle().getIdCuenta());
				log.info("Resultado de publicar en googlePlus: " + resultadoGoogle);
				publicacion.setGooglePlus(resultadoGoogle);
			}
		} catch (Exception e) {
			log.error("Se ha producido un error publicando en Google", e);
		}
		try {
			publicacionRRSSService.save(publicacion);
			edicto.setPublicacionRedesSociales(publicacion);
			edictoService.attachDirty(edicto);
		} catch (ServiceException e1) {
			log.error("Se ha producido un error guardando el resultado de la publicacion en redes sociales", e1);
		}
		
	}
}
