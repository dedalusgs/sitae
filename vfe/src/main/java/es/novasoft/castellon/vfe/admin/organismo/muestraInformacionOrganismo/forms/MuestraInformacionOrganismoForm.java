package es.novasoft.castellon.vfe.admin.organismo.muestraInformacionOrganismo.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.TemaVisualizar;

public class MuestraInformacionOrganismoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevalistaOrganismos = new ArrayList();

	private Organismo organismo;

	private String imagenActual;

	private List<TemaVisualizar> listaTemas;

	public String getImagenActual() {

		String imagen = "./img/escudo.png";
		if (organismo.getNombreImagen() != null) {
			imagen = "."
					+ Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
					+ "/" + organismo.getCodigo() + "/"
					+ organismo.getNombreImagen();
		}
		imagenActual = imagen;
		return imagenActual;
	}

	public void setImagenActual(String imagenActual) {
		this.imagenActual = imagenActual;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	public List getNuevalistaOrganismos() {
		return nuevalistaOrganismos;
	}

	public void setNuevalistaOrganismos(List nuevalistaOrganismos) {
		this.nuevalistaOrganismos = nuevalistaOrganismos;
	}

	public MuestraInformacionOrganismoForm() {

		this.organismo = new Organismo();
	}

	public List<TemaVisualizar> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<TemaVisualizar> listaTemas) {
		this.listaTemas = listaTemas;
	}

}
