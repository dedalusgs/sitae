package es.novasoft.comun.listeners;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FileUtil;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class DocumentGeneratorListener implements ServletContextListener {

	private static Log log = LogFactory.getLog(DocumentGeneratorListener.class);

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			log.debug("Iniciado la generacion de documentos");
			log.debug("Generando las imagenes para los organismos");
			log.debug("Aseguramos que todos los organismos estén activos");
			OrganismoService organismoService = (OrganismoService) Factory
					.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
			List organismos = organismoService.findAll();
			Iterator iterator = organismos.iterator();

			while (iterator.hasNext()) {
				Organismo organismo = (Organismo) iterator.next();
				log.debug("Generando imagen del " + organismo.getNombre() + "");
				if (organismo.getImagen() != null) {
					ServletContext contexto = servletContextEvent
							.getServletContext();
					String rutaEscudo = contexto.getRealPath(Constantes
							.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
							+ File.separator + organismo.getCif());
					FileUtil.guardarArchivoFileSystem(organismo.getImagen(),
							organismo.getNombreImagen(), rutaEscudo);
				}
			}
			log.debug("Se han generado las imagenes para los organismos");
			organismoService = null;
			log.debug("Fin de la generacion de documentos");
			


			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Se ha producdo un error al generar los documentos:" + e);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
