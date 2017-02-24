package es.novasoft.sitae.perfiles.adminLocal.altaFestivo.forms;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;

public class AltaFestivoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Festivo festivo;
	
	private String nombre;
	
	private String mes;
		
	private String dia;
	
	private List listaDeDias;
	
	
	public AltaFestivoForm(){
		super();
		festivo=new Festivo();
		mes="0";
		dia="1";
	}

	public Festivo getFestivo() {
		return festivo;
	}



	public void setFestivo(Festivo festivo) {
		this.festivo = festivo;
		this.nombre=festivo.getNombre();
		Calendar  fecha = new GregorianCalendar();
		fecha.setTime(festivo.getFecha());
		this.mes=Integer.toString(fecha.get(Calendar.MONTH));
		this.dia=Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
	}



	public List getListaDeDias() {
		return listaDeDias;
	}

	public void setListaDeDias(List listaDeDias) {
		this.listaDeDias = listaDeDias;
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getMes() {
		return mes;
	}



	public void setMes(String mes) {
		this.mes = mes;
	}



	public String getDia() {
		return dia;
	}



	public void setDia(String dia) {
		this.dia = dia;
	}



	/**
	 * Función para validar el alta de Festivo
	 */
 
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		FestivoService festivoService = (FestivoService) Factory
				.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);

		// Comprobar si Nombre vacio
		if (nombre.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "festivo.nombre")));
		} else {
			if (nombre.length() >= Constantes.TAMANIO_MAX_NOMBRE_FESTIVO) {
				errors
						.add(null, new ActionMessage("errors.maxlength",
								LenguajeUtil.getMensaje(request,
										"festivo.nombre")));
			}

		}
		Integer mesAux=null;
		Integer diaAux=null;
		if (mes.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "festivo.mes")));
		} else {
			
			try {
				 mesAux=Integer.parseInt(mes);
			}catch  (NumberFormatException e) {
				errors.add(null, new ActionMessage("errors.maxlength2",
						LenguajeUtil.getMensaje(request,
								"festivo.mes"), "3"));
			}
			
		}
		
		if (dia.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "festivo.dia")));
		} else {
			
			try {
				 diaAux=Integer.parseInt(dia);
			}catch  (NumberFormatException e) {
				errors.add(null, new ActionMessage("errors.maxlength2",
						LenguajeUtil.getMensaje(request,
								"festivo.dia"), "3"));
			}
			
		}
		
		Calendar calendar = new GregorianCalendar();
		calendar.setLenient(false);
		Integer anioAux=(Integer)request.getSession().getAttribute("anio");
		try {
			calendar.set(Calendar.MONTH, mesAux);
			calendar.set(Calendar.DAY_OF_MONTH, diaAux);
			calendar.set(Calendar.YEAR, anioAux);
		}catch (java.lang.IllegalArgumentException e) {
			errors.add(null, new ActionMessage("errors.fecha_incorrecto"));
		 }
				

		request.setAttribute("numeroErrores", errors.size());
		if (errors.size()==0){
			this.festivo.setNombre(nombre);
			this.festivo.setFechaString(diaAux+"/"+(mesAux+1)+"/"+anioAux);
		}
		return errors;

	}

}
