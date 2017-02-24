/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: ObjetoEdictoVisualizar.java
 * Creado: 30-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.utils;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjetoEdictoVisualizar.
 */
public class ObjetoEdictoVisualizar implements Serializable,
		Comparable<ObjetoEdictoVisualizar> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;

	/** The titulo. */
	private String titulo;

	/** The estado. */
	private String estado;

	/** The id estado. */
	private String idEstado;

	/** The publicador centro procencia. */
	private boolean publicadorCentroProcencia;

	/** The publicador asignado. */
	private boolean publicadorAsignado;

	/**
	 * Checks if is publicador asignado.
	 * 
	 * @return true, if is publicador asignado
	 */
	public boolean isPublicadorAsignado() {
		return publicadorAsignado;
	}

	public void setPublicadorAsignado(boolean publicadorAsignado) {
		this.publicadorAsignado = publicadorAsignado;
	}

	private String fechaRedaccion;

	/** The fecha publicacion. */
	private String fechaPublicacion;

	/** The fecha retirada. */
	private String fechaRetirada;

	/** The fecha retirada propuesta. */
	private String fechaRetiradaPropuesta;

	/** The codigo. */
	private String codigo;

	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the fecha retirada propuesta.
	 * 
	 * @return the fecha retirada propuesta
	 */
	public String getFechaRetiradaPropuesta() {
		return fechaRetiradaPropuesta;
	}

	/**
	 * Sets the fecha retirada propuesta.
	 * 
	 * @param fechaRetiradaPropuesta
	 *            the new fecha retirada propuesta
	 */
	public void setFechaRetiradaPropuesta(String fechaRetiradaPropuesta) {
		this.fechaRetiradaPropuesta = fechaRetiradaPropuesta;
	}

	/**
	 * Gets the fecha retirada.
	 * 
	 * @return the fecha retirada
	 */
	public String getFechaRetirada() {
		return fechaRetirada;
	}

	/**
	 * Sets the fecha retirada.
	 * 
	 * @param fechaRetirada
	 *            the new fecha retirada
	 */
	public void setFechaRetirada(String fechaRetirada) {
		this.fechaRetirada = fechaRetirada;
	}

	/** The nombre centro. */
	private String nombreCentro;

	/** The tipo edicto. */
	private String tipoEdicto;

	/** The publicado. */
	private boolean publicado;

	/** The url. */
	private String url;

	/** The nombre organismo externo. */
	private String nombreOrganismoExterno;

	/** The descripcion. */
	private String descripcion;

	/** The contenido. */
	private String contenido;

	private Boolean bloqueo;

	/**
	 * Gets the contenido.
	 * 
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Sets the contenido.
	 * 
	 * @param contenido
	 *            the new contenido
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Gets the descripcion corta.
	 * 
	 * @return the descripcion corta
	 */
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

	/**
	 * Gets the descripcion.
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 * 
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Instantiates a new objeto edicto visualizar.
	 * 
	 * @param publicado
	 *            the publicado
	 */
	public ObjetoEdictoVisualizar(boolean publicado) {

		this.publicado = publicado;
	}

	/**
	 * Instantiates a new objeto edicto visualizar.
	 */
	public ObjetoEdictoVisualizar() {

		this.publicado = false;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the nombre centro.
	 * 
	 * @return the nombre centro
	 */
	public String getNombreCentro() {
		return nombreCentro;
	}

	/**
	 * Sets the nombre centro.
	 * 
	 * @param nombreCentro
	 *            the new nombre centro
	 */
	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	/**
	 * Gets the tipo edicto.
	 * 
	 * @return the tipo edicto
	 */
	public String getTipoEdicto() {
		return tipoEdicto;
	}

	/**
	 * Sets the tipo edicto.
	 * 
	 * @param tipoEdicto
	 *            the new tipo edicto
	 */
	public void setTipoEdicto(String tipoEdicto) {
		this.tipoEdicto = tipoEdicto;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the estado.
	 * 
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 * 
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Gets the fecha redaccion.
	 * 
	 * @return the fecha redaccion
	 */
	public String getFechaRedaccion() {
		return fechaRedaccion;
	}

	/**
	 * Sets the fecha redaccion.
	 * 
	 * @param fechaRedaccion
	 *            the new fecha redaccion
	 */
	public void setFechaRedaccion(String fechaRedaccion) {
		this.fechaRedaccion = fechaRedaccion;
	}

	/**
	 * Gets the fecha publicacion.
	 * 
	 * @return the fecha publicacion
	 */
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * Sets the fecha publicacion.
	 * 
	 * @param fechaPublicacion
	 *            the new fecha publicacion
	 */
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * Checks if is publicado.
	 * 
	 * @return true, if is publicado
	 */
	public boolean isPublicado() {
		return publicado;
	}

	/**
	 * Gets the publicado.
	 * 
	 * @return the publicado
	 */
	public boolean getPublicado() {
		return publicado;
	}

	/**
	 * Sets the publicado.
	 * 
	 * @param publicado
	 *            the new publicado
	 */
	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	// Para ordenar por idVivienda (Preferencia de la vivienda)
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ObjetoEdictoVisualizar o) {
		return titulo.compareTo(o.getTitulo());
	}

	/**
	 * Gets the id estado.
	 * 
	 * @return the id estado
	 */
	public String getIdEstado() {
		return idEstado;
	}

	/**
	 * Sets the id estado.
	 * 
	 * @param idEstado
	 *            the new id estado
	 */
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	/**
	 * Checks if is publicador centro procencia.
	 * 
	 * @return true, if is publicador centro procencia
	 */
	public boolean isPublicadorCentroProcencia() {
		return publicadorCentroProcencia;
	}

	/**
	 * Sets the publicador centro procencia.
	 * 
	 * @param publicadorCentroProcencia
	 *            the new publicador centro procencia
	 */
	public void setPublicadorCentroProcencia(boolean publicadorCentroProcencia) {
		this.publicadorCentroProcencia = publicadorCentroProcencia;
	}

	/**
	 * Gets the nombre organismo externo.
	 * 
	 * @return the nombre organismo externo
	 */
	public String getNombreOrganismoExterno() {
		return nombreOrganismoExterno;
	}

	/**
	 * Sets the nombre organismo externo.
	 * 
	 * @param nombreOrganismoExterno
	 *            the new nombre organismo externo
	 */
	public void setNombreOrganismoExterno(String nombreOrganismoExterno) {
		this.nombreOrganismoExterno = nombreOrganismoExterno;
	}

	/**
	 * @param b
	 */
	public void setBloqueado(boolean b) {
		this.bloqueo = b;

	}

	public Boolean getBloqueado() {
		return this.bloqueo;
	}

}
