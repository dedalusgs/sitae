package es.novasoft.sitae.perfiles.adminGlobal.estadisticasPublicacion.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class EstadisticasPublicacionForm extends FormBase {
	
	private static final long	serialVersionUID	= 1L;
	
	private List	          listaOrganismos;
	
	private String	          fechaInicio;
	
	private String	          fechaFin;
	
	private String	          opcionOrganismo;
	
	private String	          urlImageChart;
	
	private String	          urlImageChartExtern;
	
	public List getListaOrganismos() {
		return listaOrganismos;
	}
	
	public void setListaOrganismos(List listaOrganismos) {
		this.listaOrganismos = listaOrganismos;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getOpcionOrganismo() {
		return opcionOrganismo;
	}
	
	public void setOpcionOrganismo(String opcionOrganismo) {
		this.opcionOrganismo = opcionOrganismo;
	}
	
	public String getUrlImageChart() {
		return urlImageChart;
	}
	
	public void setUrlImageChart(String urlImageChart) {
		this.urlImageChart = urlImageChart;
	}
	
	public String getUrlImageChartExtern() {
		return urlImageChartExtern;
	}
	
	public void setUrlImageChartExtern(String urlImageChartExtern) {
		this.urlImageChartExtern = urlImageChartExtern;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		
		List listaOrganismo;
		
		ActionErrors errors = new ActionErrors();
		
		if (this.fechaInicio.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "estadisticas.fechaInicio")));
		} else {
			if ((!ValidatorUtils.validaFecha(this.fechaInicio, LenguajeUtil.getMensaje(request, "estadisticas.fechaInicio"), true))) {
				errors.add(null, new ActionMessage("errors.fecha_formato", LenguajeUtil.getMensaje(request, "estadisticas.fechaInicio")));
			}
		}
		
		if (this.fechaFin.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "estadisticas.fechaFin")));
		} else {
			if ((!ValidatorUtils.validaFecha(this.fechaFin, LenguajeUtil.getMensaje(request, "estadisticas.fechaFin"), true))) {
				errors.add(null, new ActionMessage("errors.fecha_formato", LenguajeUtil.getMensaje(request, "estadisticas.fechaFin")));
			}
		}
		
		if (this.fechaInicio != null && this.fechaFin != null && !this.fechaFin.equals("") && !this.fechaInicio.equals("")) {
			
			if (FechasUtil.compareDates(FechasUtil.convertStringToDate(this.fechaFin, 0), FechasUtil.convertStringToDate(this.fechaInicio, 0))) {
				errors.add(
				        null,
				        new ActionMessage("errors.fecha_exceso", LenguajeUtil.getMensaje(request, "estadisticas.fechaFin"), LenguajeUtil.getMensaje(request,
				                "estadisticas.fechaInicio")));
			}
		}
		
		request.setAttribute("numeroErrores", errors.size());
		
		return errors;
	}
	
}
