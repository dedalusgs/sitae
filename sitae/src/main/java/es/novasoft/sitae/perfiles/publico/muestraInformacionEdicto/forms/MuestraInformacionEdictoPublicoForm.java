package es.novasoft.sitae.perfiles.publico.muestraInformacionEdicto.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.sitae.business.objects.Edicto;

public class MuestraInformacionEdictoPublicoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Edicto edicto;

	private String nombreRedactor;

	private String fechaRedaccion;

	private String nombrePublicador;
	
	private String nombreDespublicador;

	private String fechaPublicacion;

	private String fechaPropuestaRetirada;
	
	private List<ObjetoEdictoVisualizar> listaEdictosRelacionados;
	
	public String getFechaPropuestaRetirada() {
		return fechaPropuestaRetirada;
	}

	public void setFechaPropuestaRetirada(String fechaPropuestaRetirada) {
		this.fechaPropuestaRetirada = fechaPropuestaRetirada;
	}

	private String fechaRetirada;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getFechaRetirada() {
		return fechaRetirada;
	}

	public void setFechaRetirada(String fechaRetirada) {
		this.fechaRetirada = fechaRetirada;
	}

	public String getNombrePublicador() {
		return nombrePublicador;
	}

	public void setNombrePublicador(String nombrePublicador) {
		this.nombrePublicador = nombrePublicador;
	}

	public String getFechaRedaccion() {
		return fechaRedaccion;
	}

	public void setFechaRedaccion(String fechaRedaccion) {
		this.fechaRedaccion = fechaRedaccion;
	}

	public void setEdicto(Edicto edicto) {
		this.edicto = edicto;
	}

	public String getNombreRedactor() {
		return nombreRedactor;
	}

	public void setNombreRedactor(String nombreRedactor) {
		this.nombreRedactor = nombreRedactor;
	}

	public Edicto getEdicto() {
		return edicto;
	}

	public MuestraInformacionEdictoPublicoForm() {

		this.edicto = new Edicto();
		this.nombrePublicador = "";
		this.fechaPublicacion = "";
		this.fechaRetirada = "";

	}

	public String getNombreDespublicador() {
		return nombreDespublicador;
	}

	public void setNombreDespublicador(String nombreDespublicador) {
		this.nombreDespublicador = nombreDespublicador;
	}

	public List getListaEdictosRelacionados() {
		return listaEdictosRelacionados;
	}

	public void setListaEdictosRelacionados(List listaEdictosRelacionados) {
		this.listaEdictosRelacionados = listaEdictosRelacionados;
	}
}
