package es.novasoft.sitae.cron;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import alfresco.sigex.castellon.AssertionResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.GeneradorClavesUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.comun.utils.UtilRedesSociales;

public class PublicacionJob extends QuartzJobBean {
	
	private int	             timeout;
	private boolean	         realizada;
	private boolean	         aceptada;
	
	private static final Log	log	          = LogFactory.getLog(PublicacionJob.class);
	
	EdictoService	         edictoService	  = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	EstadoService	         estadoService	  = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	OrganismoService	     organismoService	= (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	/**
	 * Setter called after the ExampleJob is instantiated with the value from
	 * the JobDetailBean (5)
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		
		publicarEdictosPendientes();
		// resolverPortafirmas();
	}
	
	private void publicarEdictosPendientes() {
		// TODO Auto-generated method stub
		
		try {
			Estado estadoPendientePublicacion = estadoService.findById(Constantes.PENDIENTE_PUBLICACION);
			List listaEdictos;
			Edicto edicto;
			Date fechaActual = new Date();
			
			listaEdictos = edictoService.findByIdEstado(estadoPendientePublicacion.getIdEstado());
			System.out.println("edictos pendientes de publicacion: " + listaEdictos.size());
			Iterator iter = listaEdictos.iterator();
			while (iter.hasNext()) {
				edicto = (Edicto) iter.next();
				if (checkFecha(edicto, fechaActual)) {
					edicto = UtilPublicar.publicar(edicto);
				}
				edictoService.attachDirty(edicto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkFecha(Edicto edicto, Date fechaActual) {
		boolean check = false;
		
		SimpleDateFormat sdf;
		sdf = FechasUtil.getSimpleDateFormat(FechasUtil.typeSdfDate);
		
		log.debug("Fecha publicacion propuesta: " + sdf.format(edicto.getFechaPublicacionPropuesta()));
		
		log.debug("Fecha Actual: " + sdf.format(fechaActual));
		log.debug("Diferencia de dias - "
		        + FechasUtil.getDifferenceByDays(FechasUtil.convertStringToDate(sdf.format(fechaActual), FechasUtil.typeSdfDate),
		                FechasUtil.convertStringToDate(sdf.format(edicto.getFechaPublicacionPropuesta()), FechasUtil.typeSdfDate)));
		
		if (FechasUtil.getDifferenceByDays(FechasUtil.convertStringToDate(sdf.format(fechaActual), FechasUtil.typeSdfDate),
		        FechasUtil.convertStringToDate(sdf.format(edicto.getFechaPublicacionPropuesta()), FechasUtil.typeSdfDate)) == 0) {
			check = true;
		}
		return check;
	}
	
	private void resolverPortafirmas() {
		
		try {
			Estado estadoPendienteFirma = estadoService.findById(Constantes.PENDIENTE_FIRMA);
			Estado estadoRechazadaFirma = estadoService.findById(Constantes.RECHAZADO_FIRMA);
			List listaEdictos;
			Edicto edicto;
			Date fecha = new Date();
			
			log.debug("antes del dao");
			listaEdictos = edictoService.findByIdEstado(estadoPendienteFirma.getIdEstado());
			log.debug("edictos pendientes de firma: " + listaEdictos.size());
			Iterator iter = listaEdictos.iterator();
			while (iter.hasNext()) {
				realizada = false;
				aceptada = false;
				edicto = (Edicto) iter.next();
				checkPortafirmas(edicto);
				
				if (realizada == true) {
					if (aceptada == true) {
						edicto = UtilPublicar.publicar(edicto);
					} else {
						edicto.setEstado(estadoRechazadaFirma);
					}
					edictoService.attachDirty(edicto);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Edicto publicarEdicto(Edicto edicto) throws ServiceException {
		
		/* Ha publicado y tiene permisos para publicar */
		Date fechaActual = new Date();
		edicto.setFechaPublicacion(fechaActual);
		Estado estado = null;
		Organismo organismo = organismoService.findById(edicto.getOrganismo().getIdOrg());
		Integer contador_edicto = organismo.getCont_edicto();
		Date fecha_edicto = organismo.getFecha_edicto();
		
		estado = estadoService.findById(Constantes.PUBLICADO);
		edicto.setEstado(estado);
		
		int anyoFechaEdictoOrganismo = FechasUtil.getYearByDate(fecha_edicto);
		int anyoFechaActual = FechasUtil.getYearByDate(fechaActual);
		String anyoFechaActualString = String.valueOf(anyoFechaActual);
		if (anyoFechaActual > anyoFechaEdictoOrganismo) {
			contador_edicto = 0;
			organismo.setFecha_edicto(new Date());
		}
		String claveGenerada = null;
		try {
			claveGenerada = GeneradorClavesUtil.generarClaveEdictoCodigo(organismo.getCodigo(), anyoFechaActualString, contador_edicto.toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contador_edicto++;
		edicto.setCodigo(claveGenerada);
		
		edictoService.attachDirty(edicto);
		
		String url = organismo.getDominio();
		String protocolo = Constantes.getPropiedad(Constantes.PROTOCOLO);
		
		String nombreApp = Constantes.getPropiedad(Constantes.NOMBRE_APP);
		url = protocolo + "://" + url + "/" + nombreApp + "/DescargarAnuncio.do?codigo=" + claveGenerada;
		
		try {
			String urlCertificadoPublicacion = UtilPublicar.obtenerUrlCertificado(url, claveGenerada);
			
			if (urlCertificadoPublicacion != null && !urlCertificadoPublicacion.equals("")) {
				log.debug("urlCertificadoPublicacion : " + urlCertificadoPublicacion);
				edicto.setUrl(urlCertificadoPublicacion);
				edicto.setEstado(estado);
				edicto.setCodigo(claveGenerada);
				if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO) {
					String endpoint = Constantes.getPropiedad("endPointALFRESCO");
					IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
					IMuleRDWS alfrescoWS = locator.getIMuleRDWSPort(new URL(endpoint));
					AssertionResponse asresp = alfrescoWS.publicDraftEdictRDWS(edicto.getOrganismo().getCodigo(), edicto.getIdEdicto().toString(), edicto.getCodigo(), edicto
					        .getCentro().getNombreCarpeta(), edicto.getTipoEdicto().getNombre(), edicto.getTitulo());
					log.info("Message Alfresco : " + asresp.getMessage());
				}
				
				Date fRetirada = FechasUtil.addDaysZeroHour(edicto.getFechaRetiradaPropuesta(), 0);
				if (edicto.getRedesSociales().equals("SI")) {
					UtilRedesSociales.publicarRedesSociales(edicto);
				}
				if (edicto.getListaCorreo().equals("SI")) {
					UtilRedesSociales.publicarListaCorreo(edicto);
				}
				edicto.setFechaRetiradaPropuesta(fRetirada);
				
				edictoService.attachDirty(edicto);
				
				organismo.setCont_edicto(contador_edicto);
				organismoService.attachDirty(organismo);
			} else {
				
				estado = estadoService.findById(Constantes.PENDIENTE_PUBLICACION);
				edicto.setEstado(estado);
				edicto.setCodigo("");
				edictoService.attachDirty(edicto);
			}
			
		} catch (Exception e) {
			
			estado = estadoService.findById(Constantes.PENDIENTE_PUBLICACION);
			edicto.setEstado(estado);
			edicto.setCodigo("");
			edictoService.attachDirty(edicto);
			
			e.printStackTrace();
		}
		
		organismo.setCont_edicto(contador_edicto);
		organismoService.attachDirty(organismo);
		
		return edicto;
	}
	
	private void checkPortafirmas(Edicto edicto) {
		// TODO Auto-generated method stub
		log.debug("El edicto " + edicto.getIdEdicto() + " no esta firmado en portafirmas");
		realizada = true;
		aceptada = true;
	}
	
}
