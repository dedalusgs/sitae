package es.novasoft.social;

import junit.framework.TestCase;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.socialservice.FacebookService;
import es.novasoft.comun.socialservice.GooglePlusService;
import es.novasoft.comun.socialservice.GoogleShortenerService;
import es.novasoft.comun.socialservice.SocialPost;
import es.novasoft.comun.socialservice.TwitterService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.comun.utils.UtilUrlWeb;

public class PublicarGooglePlus extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPublicPost() {
		try {
			EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
			GoogleShortenerService googleShortenerService = (GoogleShortenerService) Factory.getBean(ServiceConstants.GOOGLESHORTENER_BEAN_NAME);
			FacebookService facebookService = (FacebookService) Factory.getBean(ServiceConstants.FACEBOOK_BEAN_NAME);
			TwitterService twitterService = (TwitterService) Factory.getBean(ServiceConstants.TWITTER_BEAN_NAME);
			GooglePlusService googlePlusService = (GooglePlusService) Factory.getBean(ServiceConstants.GOOGLEPLUS_BEAN_NAME);
			Edicto edicto = edictoService.findById(null);
			
			Organismo organismo = edicto.getOrganismo();
			String url = UtilUrlWeb.getUrlBase(edicto.getOrganismo(), "/MuestraInformacionEdictoPublicoFrontAction.do?idEdictoSeleccionado=" + edicto.getIdEdicto());
			String urlShort = googleShortenerService.acortarURL(url);
			edicto.setUrlAcortada(urlShort);
			edictoService.attachDirty(edicto);
			
			SocialPost socialPost = new SocialPost();
			socialPost.setTitulo(edicto.getTitulo());
			socialPost.setDescripcion(edicto.getDescripcion());
			socialPost.setUrl(urlShort);
			
			String urlImg = UtilUrlWeb.getUrlBase(edicto.getOrganismo(), "/" + Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS) + "/" + edicto.getOrganismo().getCif()
			        + "/" + edicto.getOrganismo().getNombreImagen());
			socialPost.setUrlImg(urlImg);
			
			String resultadoGoogle = googlePlusService.publicPost(socialPost, organismo.getTwitter().getTokenCuenta(), organismo.getGoogle().getIdCuenta());
		} catch (Exception e) {
			fail(e.getMessage() + " " + e.getStackTrace());
			
		}
	}
}
