package es.novasoft.sitae.ws.fandango;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.accv.fandango.services.CertificacionPublicacion.ACCVFandangoClientImpl;
import es.novasoft.sitae.comun.utils.UtilPublicar;

public class FandangoServiceFactory {
	private static final Log log = LogFactory.getLog(FandangoServiceFactory.class);
	private MuleFandangoClientImpl servicioMule;
	private ACCVFandangoClientImpl servicioFandango;
	private String seleccion ;
	
	public MuleFandangoClientImpl getServicioMule() {
		return servicioMule;
	}
	public void setServicioMule(MuleFandangoClientImpl servicioMule) {
		this.servicioMule = servicioMule;
	}
	public ACCVFandangoClientImpl getServicioFandango() {
		return servicioFandango;
	}
	public void setServicioFandango(ACCVFandangoClientImpl servicioFandango) {
		this.servicioFandango = servicioFandango;
	}
	public String getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}
	
	public FandangoClient getInstance(){
		
		if (seleccion ==null ){
			log.warn("No se ha especificado ningún servicio de Fandango y se ha seleccionado el servicio a través del Bus de Integración.Recuerde debe escribir 'fandangoBus' o 'fandangoDirecto' en el fichero applicationContextDao.xml");
			return servicioMule;
		}else{
			
			if (seleccion.equals("fandangoDirecto")){
				log.info("Se ha configurado el servicio del Fandango apuntando directamente a la ACCV");
			    return servicioFandango;	
			}else if  (seleccion.equals("fandangoBus")){
				log.info("Se ha configurado el servicio del Fandango apuntando al Bus de Integración");
			    return servicioMule;	
			}else {
				log.warn("No se ha especificado correctamente el servicio de Fandango y se ha seleccionado el servicio a través del Bus de Integración. Recuerde debe escribir 'fandangoBus' o 'fandangoDirecto' en el fichero applicationContextDao.xml");
				return servicioMule;
			}
			
			
		}
		
		
		
	}
	

}
