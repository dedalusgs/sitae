package es.novasoft.sitae.business.objects;

import java.util.Date;

import es.novasoft.comun.utils.FechasUtil;



public class Festivo implements java.io.Serializable{
	protected Integer id;
	protected String nombre;
	protected Organismo organismo;
	protected Date fecha;
	
	public Festivo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public String  getFechaString() {
		return FechasUtil.convertDateToString(this.fecha, FechasUtil.typeSdfDate);
	}

	public void setFechaString(String fecha) {
		
		this.fecha = FechasUtil.convertStringToDate(fecha, FechasUtil.typeSdfDate);
	}

	public Festivo(String nombre, Organismo organismo, Date fecha) {
		super();
		this.nombre = nombre;
		this.organismo = organismo;
		this.fecha = fecha;
		this.id=null;
	}

	
	

}
