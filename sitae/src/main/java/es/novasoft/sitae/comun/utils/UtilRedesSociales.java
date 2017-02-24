package es.novasoft.sitae.comun.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.comun.utils.listacorreo.PublicarListaCorreo;

public class UtilRedesSociales {
	
	private static final Log	           log	     = LogFactory.getLog(UtilRedesSociales.class);
	
	private static SimpleAsyncTaskExecutor	executor	= new SimpleAsyncTaskExecutor();
	
	public UtilRedesSociales() {
		
	}
	
	public static void publicarRedesSociales(Edicto edicto) throws ServiceException {
		log.info("LLamada a publicar en redes sociales asincronamente");
		executor.execute(new PublicacionRedes(edicto));
	}
	
	public static void publicarListaCorreo(Edicto edicto) throws ServiceException {
		log.info("LLamada a publicar lista de correo asincronamente");
		executor.execute(new PublicarListaCorreo(edicto));
	}
	
	public static void despublicarRedesSociales(Edicto edicto) throws ServiceException {
		log.info("LLamada a despublicar redes sociales asincronamente");
		executor.execute(new DesPublicacionRedes(edicto));
	}
}
