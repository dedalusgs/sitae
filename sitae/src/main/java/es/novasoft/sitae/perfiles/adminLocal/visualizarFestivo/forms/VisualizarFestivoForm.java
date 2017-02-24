package es.novasoft.sitae.perfiles.adminLocal.visualizarFestivo.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Festivo;

public class VisualizarFestivoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List diasFestivosLocales = new ArrayList();
	
	private List diasFestivosNacionales = new ArrayList();
	
	private List listadoAnios = new ArrayList();

	private Festivo festivo;
	
	private Integer anio;

	public VisualizarFestivoForm(){
		super();
	}
	
	public List getDiasFestivosLocales() {
		return diasFestivosLocales;
	}

	public void setDiasFestivosLocales(List diasFestivosLocales) {
		this.diasFestivosLocales = diasFestivosLocales;
	}

	public List getDiasFestivosNacionales() {
		return diasFestivosNacionales;
	}

	public void setDiasFestivosNacionales(List diasFestivosNacionales) {
		this.diasFestivosNacionales = diasFestivosNacionales;
	}

	public Festivo getFestivo() {
		return festivo;
	}

	public void setFestivo(Festivo festivo) {
		this.festivo = festivo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public List getListadoAnios() {
		return listadoAnios;
	}

	public void setListadoAnios(List listadoAnios) {
		this.listadoAnios = listadoAnios;
	}

	
	
}
