package es.novasoft.sitae.ajax;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.comun.utils.UtilPublicar;

public class AjaxSitae {
	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	FestivoService festivoService = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	private static final Log log = LogFactory.getLog(UtilPublicar.class);
	public AjaxSitae() {
     

	}
	
	public String calcularFechaFinPublicacion(String fechaInicio, Integer numDias,String tipo){
		 WebContext wctx = WebContextFactory.get();
		
		Date fecha=FechasUtil.convertStringToDate(fechaInicio, FechasUtil.typeSdfDate);
		String cif=(String)wctx.getSession().getAttribute("cif");
		Organismo organismo;
		Date fRetirada;
		try {
			organismo = (Organismo) organismoService.findByCif(cif).get(0);
			fRetirada=festivoService.obtenerFechaFinPublicacion(fecha, organismo,numDias, tipo);
		
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
			return "ERROR";
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return "ERROR";
		}
		
		log.info("Peticion Ajax fecha fin publicacion realizada con éxito");
		String fechaFinal=FechasUtil.convertDateToString(fRetirada,FechasUtil.typeSdfDate);
		return fechaFinal;
	}
	
	
	
	public String calcularDiasPublicacion(String fechaInicio, String fechaFin, String tipo){
		 WebContext wctx = WebContextFactory.get();
			
			Date fechaIni=FechasUtil.convertStringToDate(fechaInicio, FechasUtil.typeSdfDate);
			Date fechaF=FechasUtil.convertStringToDate(fechaFin, FechasUtil.typeSdfDate);
			String cif=(String)wctx.getSession().getAttribute("cif");
			Organismo organismo;
			Integer numDias;
			try { 
				organismo = (Organismo) organismoService.findByCif(cif).get(0);
				numDias=festivoService.obtenerDiasPublicacion(fechaIni,fechaF, organismo, tipo);
			
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				return "ERROR";
			} catch (ServiceException e) {
				log.error(e.getMessage(), e);
				return "ERROR";
			}
			
			log.info("Peticion Ajax fecha fin publicacion realizada con éxito");
			
			return numDias.toString();
	}
}
