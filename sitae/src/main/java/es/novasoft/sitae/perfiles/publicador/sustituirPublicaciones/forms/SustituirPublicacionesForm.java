package es.novasoft.sitae.perfiles.publicador.sustituirPublicaciones.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.sitae.business.objects.Edicto;

public class SustituirPublicacionesForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List listaCentros;

	private List<ObjetoEdictoVisualizar> listaRelacionados;
	
	private List<ObjetoEdictoVisualizar> listaPublicados;

	private List listEdictosVisualizar;

	private List listaTiposEdictos;
	
	private List listaOrganismosExternos;

	public List getListaOrganismosExternos() {
		return listaOrganismosExternos;
	}

	public void setListaOrganismosExternos(List listaOrganismosExternos) {
		this.listaOrganismosExternos = listaOrganismosExternos;
	}

	private String fechaPublicacionInicio;

	private String fechaPublicacionFin;

	private Integer opcionTipoEdicto;

	private Integer opcionCentro;

	private boolean historico;

	private String titulo;

	private String descripcion;
	
	private String contenido;

	private Integer opcionOrganismoExterno;
	
	private String accion;

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Integer getOpcionOrganismoExterno() {
		return opcionOrganismoExterno;
	}

	public void setOpcionOrganismoExterno(Integer opcionOrganismoExterno) {
		this.opcionOrganismoExterno = opcionOrganismoExterno;
	}

	private Integer idEdictoSust;
	
	private String numeroExpediente; 
	

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public SustituirPublicacionesForm() {

		this.fechaPublicacionInicio = "";
		this.fechaPublicacionFin = "";
		this.opcionCentro = -1;
		this.opcionTipoEdicto = -1;
		this.titulo = "";
		this.descripcion = "";

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHistorico() {
		return historico;
	}

	public void setHistorico(boolean historico) {
		this.historico = historico;
	}

	public List getListEdictosVisualizar() {
		return listEdictosVisualizar;
	}

	public void setListEdictosVisualizar(List listEdictosVisualizar) {
		this.listEdictosVisualizar = listEdictosVisualizar;
	}

	public List getListaCentros() {
		return listaCentros;
	}

	public void setListaCentros(List listaCentros) {
		this.listaCentros = listaCentros;
	}

	public List getListaTiposEdictos() {
		return listaTiposEdictos;
	}

	public void setListaTiposEdictos(List listaTiposEdictos) {
		this.listaTiposEdictos = listaTiposEdictos;
	}

	public String getFechaPublicacionInicio() {
		return fechaPublicacionInicio;
	}

	public void setFechaPublicacionInicio(String fechaPublicacionInicio) {
		this.fechaPublicacionInicio = fechaPublicacionInicio;
	}

	public String getFechaPublicacionFin() {
		return fechaPublicacionFin;
	}

	public void setFechaPublicacionFin(String fechaPublicacionFin) {
		this.fechaPublicacionFin = fechaPublicacionFin;
	}

	public Integer getOpcionTipoEdicto() {
		return opcionTipoEdicto;
	}

	public void setOpcionTipoEdicto(Integer opcionTipoEdicto) {
		this.opcionTipoEdicto = opcionTipoEdicto;
	}

	public Integer getOpcionCentro() {
		return opcionCentro;
	}

	public void setOpcionCentro(Integer opcionCentro) {
		this.opcionCentro = opcionCentro;
	}

	public List<ObjetoEdictoVisualizar> getListaPublicados() {
		return listaPublicados;
	}

	public void setListaPublicados(List<ObjetoEdictoVisualizar> listaPublicados) {
		this.listaPublicados = listaPublicados;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.setHistorico(false);

	}

	public List<ObjetoEdictoVisualizar> getListaRelacionados() {
		return listaRelacionados;
	}

	public void setListaRelacionados(List<ObjetoEdictoVisualizar> listaRelacionados) {
		this.listaRelacionados = listaRelacionados;
	}

	public Integer getIdEdictoSust() {
		return idEdictoSust;
	}

	public void setIdEdictoSust(Integer idEdictoSust) {
		this.idEdictoSust = idEdictoSust;
	}
}
