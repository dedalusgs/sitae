package es.novasoft.sitae.perfiles.publico.visualizarEdictoUltimos.forms;

import java.util.List;

import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;

public class VisualizarEdictoPublicoUltimosForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List<ObjetoEdictoVisualizar> listaPublicados;

	public VisualizarEdictoPublicoUltimosForm() {
	}

	public List<ObjetoEdictoVisualizar> getListaPublicados() {
		return listaPublicados;
	}

	public void setListaPublicados(List<ObjetoEdictoVisualizar> listaPublicados) {
		this.listaPublicados = listaPublicados;
	}

}
