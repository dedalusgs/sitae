package es.novasoft.sitae.cron;

import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import alfresco.sigex.castellon.ContentDocumentRequest;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.comun.utils.UtilRedesSociales;

public class BajaPublicacionJob extends QuartzJobBean {

	/**
	 * Setter called after the ExampleJob is instantiated with the value from
	 * the JobDetailBean (5)
	 */

	private static final Log log = LogFactory.getLog(BajaPublicacionJob.class);

	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {

		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);

		try {
			Estado estadoRetirado = estadoService.findById(Constantes.RETIRADO);
			List listaEdictos;
			Edicto edicto;

			Date fecha = new Date();

			listaEdictos = edictoService.findByFechaRetiradaPropuesta(FechasUtil.convertDateToString(fecha, FechasUtil.typeSdfDate));
			log.debug("edictos retirados: " + listaEdictos.size());
			Iterator<Edicto> iter = listaEdictos.iterator();
			while (iter.hasNext()) {
				UtilPublicar.bajaPublicacion(iter.next());

			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}
}
