package es.novasoft.sitae.perfiles.redactor.muestraInformacionEdicto.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.sitae.business.objects.Edicto;

public class MuestraInformacionEdictoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Edicto edicto;

	private String nombreRedactor;

	private String fechaRedaccion;

	private String fechaUltimaModificacion;

	private String nombrePublicador;
	
	private String nombreDespublicador;

	private String fechaPublicacion;

	private String fechaRetirada;

	private String fechaPublicacionPropuesta;

	private String fechaRetiradaPropuesta;

	private String diasPublicados;

	private String id;

	private List<ObjetoEdictoVisualizar> listaEdictosRelacionados;
	
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

	public String getDiasPublicados() {
		return diasPublicados;
	}

	public void setDiasPublicados(String diasPublicados) {
		this.diasPublicados = diasPublicados;
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

	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
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

	public String getFechaPublicacionPropuesta() {
		return fechaPublicacionPropuesta;
	}

	public void setFechaPublicacionPropuesta(String fechaPublicacionPropuesta) {
		this.fechaPublicacionPropuesta = fechaPublicacionPropuesta;
	}

	public String getFechaRetiradaPropuesta() {
		return fechaRetiradaPropuesta;
	}

	public void setFechaRetiradaPropuesta(String fechaRetiradaPropuesta) {
		this.fechaRetiradaPropuesta = fechaRetiradaPropuesta;
	}

	public MuestraInformacionEdictoForm() {

		this.edicto = new Edicto();
		this.nombrePublicador = "";
		this.fechaPublicacion = "";
		this.fechaRetirada = "";
		this.fechaUltimaModificacion = "";
		this.fechaPublicacionPropuesta = "";
		this.fechaRetiradaPropuesta = "";
		this.diasPublicados = "";
	}

	public String getNombreDespublicador() {
		return nombreDespublicador;
	}

	public void setNombreDespublicador(String nombreDespublicador) {
		this.nombreDespublicador = nombreDespublicador;
	}

	public List<ObjetoEdictoVisualizar> getListaEdictosRelacionados() {
		return listaEdictosRelacionados;
	}

	public void setListaEdictosRelacionados(
			List<ObjetoEdictoVisualizar> listaEdictosRelacionados) {
		this.listaEdictosRelacionados = listaEdictosRelacionados;
	}

}
