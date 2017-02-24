package es.novasoft.comun.utils;

import java.io.Serializable;

public class ObjetoEdictoVisualizar implements Serializable,
		Comparable<ObjetoEdictoVisualizar> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String titulo;

	private String estado;

	private String idEstado;

	private boolean publicadorCentroProcencia;
	
	private boolean publicadorAsignado;

	public boolean isPublicadorAsignado() {
		return publicadorAsignado;
	}

	public void setPublicadorAsignado(boolean publicadorAsignado) {
		this.publicadorAsignado = publicadorAsignado;
	}

	private String fechaRedaccion;

	private String fechaPublicacion;
	
	private String fechaRetirada;
	
	private String fechaRetiradaPropuesta;

	private String codigo;
	private String tipoExposicion;
	private Integer diasPublicacion;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFechaRetiradaPropuesta() {
		return fechaRetiradaPropuesta;
	}

	public void setFechaRetiradaPropuesta(String fechaRetiradaPropuesta) {
		this.fechaRetiradaPropuesta = fechaRetiradaPropuesta;
	}

	public String getFechaRetirada() {
		return fechaRetirada;
	}

	public void setFechaRetirada(String fechaRetirada) {
		this.fechaRetirada = fechaRetirada;
	}

	private String nombreCentro;

	private String tipoEdicto;

	private boolean publicado;

	private String url;

	private String nombreOrganismoExterno;

	private String descripcion;
	
	private String contenido;

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDescripcionCorta() {
		String descripcionCorta = "";
		if (this.descripcion != null && !this.descripcion.equals("")) {
			if (this.descripcion.length() > 60) {
				descripcionCorta = this.descripcion.substring(0, 60);
				descripcionCorta = descripcionCorta + "...";
			} else {
				descripcionCorta = descripcion;
			}
		}
		return descripcionCorta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ObjetoEdictoVisualizar(boolean publicado) {

		this.publicado = publicado;
	}

	public ObjetoEdictoVisualizar() {

		this.publicado = false;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getTipoEdicto() {
		return tipoEdicto;
	}

	public void setTipoEdicto(String tipoEdicto) {
		this.tipoEdicto = tipoEdicto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaRedaccion() {
		return fechaRedaccion;
	}

	public void setFechaRedaccion(String fechaRedaccion) {
		this.fechaRedaccion = fechaRedaccion;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public boolean getPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	// Para ordenar por idVivienda (Preferencia de la vivienda)
	public int compareTo(ObjetoEdictoVisualizar o) {
		return this.titulo.compareTo(o.getTitulo());
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public boolean isPublicadorCentroProcencia() {
		return publicadorCentroProcencia;
	}

	public void setPublicadorCentroProcencia(boolean publicadorCentroProcencia) {
		this.publicadorCentroProcencia = publicadorCentroProcencia;
	}

	public String getNombreOrganismoExterno() {
		return nombreOrganismoExterno;
	}

	public void setNombreOrganismoExterno(String nombreOrganismoExterno) {
		this.nombreOrganismoExterno = nombreOrganismoExterno;
	}

	public String getTipoExposion() {
		return tipoExposicion;
	}

	public void setTipoExposicion(String tipoPublicacion) {
		this.tipoExposicion = tipoPublicacion;
	}

	public Integer getDiasPublicacion() {
		return diasPublicacion;
	}

	public void setDiasPublicacion(Integer diasPublicacion) {
		this.diasPublicacion = diasPublicacion;
	}
	
	

}
