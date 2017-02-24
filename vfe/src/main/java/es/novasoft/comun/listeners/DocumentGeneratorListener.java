/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: DocumentGeneratorListener.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.listeners;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FileUtil;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving documentGenerator events. The class that
 * is interested in processing a documentGenerator event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * <code>addDocumentGeneratorListener<code> method. When
 * the documentGenerator event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see DocumentGeneratorEvent
 */
public class DocumentGeneratorListener implements ServletContextListener {

	/** The log. */
	private static Log log = LogFactory.getLog(DocumentGeneratorListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			log.debug("Iniciado la generacion de documentos");
			log.debug("Generando las imagenes para los organismos");
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
							+ File.separator + organismo.getCodigo());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @seejavax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
