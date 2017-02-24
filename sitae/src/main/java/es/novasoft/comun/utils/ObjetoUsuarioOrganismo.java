package es.novasoft.comun.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.novasoft.sitae.business.objects.Organismo;

public class ObjetoUsuarioOrganismo implements Serializable,
		Comparable<ObjetoUsuarioOrganismo> {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombreUsuario;

	private String numDocumento;

	private String email;

	private boolean administrador;

	private List organismos = new ArrayList();

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public List getOrganismos() {
		return organismos;
	}

	public void setOrganismos(List organismos) {
		this.organismos = organismos;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ObjetoUsuarioOrganismo() {
		super();
	}

	public ObjetoUsuarioOrganismo(String nombreUsuario, String numDocumento) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.numDocumento = numDocumento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	// Para ordenar por organismos 
	public int compareTo(ObjetoUsuarioOrganismo o) {
		if (o.getOrganismos().isEmpty()) return 1;
		if (this.getOrganismos().isEmpty()) return -1;
		return ((Organismo) this.getOrganismos().get(0)).compareTo(o.getOrganismos().get(0));
	}

}
