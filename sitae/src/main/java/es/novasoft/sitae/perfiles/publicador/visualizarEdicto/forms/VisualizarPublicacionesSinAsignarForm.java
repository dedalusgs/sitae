package es.novasoft.sitae.perfiles.publicador.visualizarEdicto.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;

public class VisualizarPublicacionesSinAsignarForm extends FormBase {

	private static final long serialVersionUID = 1L;

	// private List listaEstados;
	private List listaEdictos;

	// private List listaCentros;
	private List<ObjetoEdictoVisualizar> listaPublicados;

	private List listEdictosVisualizar;

	// private List listaTiposEdictos;
	// private String fechaRedaccion;
	// private Integer opcionTipoEdicto;
	// private Integer opcionCentro;
	// private Integer opcionEstado;
	// private boolean historico;
	// private String titulo;

	public VisualizarPublicacionesSinAsignarForm() {

		/*
		 * this.fechaRedaccion = ""; this.opcionCentro = -1;
		 * this.opcionTipoEdicto = -1; this.opcionEstado = -1; this.titulo="";
		 */

	}

	/*
	 * public String getTitulo() { return titulo; }
	 * 
	 * public void setTitulo(String titulo) { this.titulo = titulo; }
	 * 
	 * public boolean isHistorico() { return historico; }
	 * 
	 * public void setHistorico(boolean historico) { this.historico = historico; }
	 * 
	 * public List getListaEstados() { return listaEstados; }
	 * 
	 * public void setListaEstados(List listaEstados) { this.listaEstados =
	 * listaEstados; }
	 * 
	 * public Integer getOpcionEstado() { return opcionEstado; }
	 * 
	 * public void setOpcionEstado(Integer opcionEstado) { this.opcionEstado =
	 * opcionEstado; }
	 */

	public List getListEdictosVisualizar() {
		return listEdictosVisualizar;
	}

	public void setListEdictosVisualizar(List listEdictosVisualizar) {
		this.listEdictosVisualizar = listEdictosVisualizar;
	}

	/*
	 * public List getListaCentros() { return listaCentros; }
	 * 
	 * public void setListaCentros(List listaCentros) { this.listaCentros =
	 * listaCentros; }
	 * 
	 * public List getListaTiposEdictos() { return listaTiposEdictos; }
	 * 
	 * public void setListaTiposEdictos(List listaTiposEdictos) {
	 * this.listaTiposEdictos = listaTiposEdictos; }
	 * 
	 * public String getFechaRedaccion() { return fechaRedaccion; }
	 * 
	 * public void setFechaRedaccion(String fechaRedaccion) {
	 * this.fechaRedaccion = fechaRedaccion; }
	 * 
	 * public Integer getOpcionTipoEdicto() { return opcionTipoEdicto; }
	 * 
	 * public void setOpcionTipoEdicto(Integer opcionTipoEdicto) {
	 * this.opcionTipoEdicto = opcionTipoEdicto; }
	 * 
	 * public Integer getOpcionCentro() { return opcionCentro; }
	 * 
	 * public void setOpcionCentro(Integer opcionCentro) { this.opcionCentro =
	 * opcionCentro; }
	 */

	public List<ObjetoEdictoVisualizar> getListaPublicados() {
		return listaPublicados;
	}

	public void setListaPublicados(List<ObjetoEdictoVisualizar> listaPublicados) {
		this.listaPublicados = listaPublicados;
	}

	public List getListaEdictos() {
		return listaEdictos;
	}

	public void setListaEdictos(List listaEdictos) {
		this.listaEdictos = listaEdictos;
	}

	/*
	 * public void reset(ActionMapping mapping,HttpServletRequest request) {
	 * 
	 * this.setHistorico(false);
	 *  }
	 */

}
