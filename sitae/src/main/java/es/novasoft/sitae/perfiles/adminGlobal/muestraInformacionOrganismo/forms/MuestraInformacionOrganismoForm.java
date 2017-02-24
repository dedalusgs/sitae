package es.novasoft.sitae.perfiles.adminGlobal.muestraInformacionOrganismo.forms;

import java.util.ArrayList;
import java.util.List;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.TemaVisualizar;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Usuario;

public class MuestraInformacionOrganismoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List nuevalistaOrganismos = new ArrayList();

	private Organismo organismo;

	private List listaUsuarios;

	private String imagenActual;

	private List<TemaVisualizar> listaTemas;

	public String getImagenActual() {

		String imagen = "./img/escudo.png";
		if (organismo.getNombreImagen() != null) {
			imagen = "."
					+ Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
					+ "/" + organismo.getCif() + "/"
					+ organismo.getNombreImagen();
		}
		imagenActual = imagen;
		return imagenActual;
	}

	public void setImagenActual(String imagenActual) {
		this.imagenActual = imagenActual;
	}

	public List getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {

		this.listaUsuarios = new ArrayList<Usuario>();
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
