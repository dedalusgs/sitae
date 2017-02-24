package es.novasoft.sitae.cron;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import afirmaws.services.FirmaUtil;
import es.accv.arangi.signature.XAdESXLSignature;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;

public class RefirmadoJob extends QuartzJobBean {
	
	/**
	 * Setter called after the ExampleJob is instantiated with the value from
	 * the JobDetailBean (5)
	 */
	
	private static final Log	log	= LogFactory.getLog(RefirmadoJob.class);
	
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
		
		try {
			Date fechaActual = FechasUtil.getCurrentDate();
			Date dentroDeUnMes = FechasUtil.addDays(fechaActual, 31);
			int cantidad = edictoService.edictoConFirmaPosteriorACount(dentroDeUnMes);
			if (cantidad > 0) {
				int totalPaginas = cantidad / 10;
				if ((cantidad % 10) != 0) {
					totalPaginas++;
				}
				for (int i = 1; i <= totalPaginas; i++) {
					List listado = edictoService.edictoConFirmaPosteriorA(dentroDeUnMes, i, 10);
					for (int j = 0; j < listado.size(); j++) {
						Edicto edicto = (Edicto) listado.get(j);
						XAdESXLSignature firma = FirmaUtil.promocionarFirmaXadesXL(edicto.getFirmaDiligenciaString());
						Date date = firma.getTimeStampCertificateExpiration();
						edicto.setCaducidadFirma(date);
						edictoService.actualizar(edicto);
						log.info("actualizada firma edicto: " + edicto.getCodigo());
					}
					
				}
				
			}
			
		} catch (Exception e) {
			log.error(e, e);
		}
	}
}
