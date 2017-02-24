package es.novasoft.comun.utils;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.RedSocial;
import es.novasoft.sitae.comun.utils.UtilUrlWeb;

public class OrganismoVisualizar implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int HTTP_PORT = 80;

	private static final int HTTPS_PORT = 443;

	private String nombre;

	private String nombreVa;

	private String cif;

	private String direccion;

	private String direccionVa;

	private String telefono;

	private String fax;

	private String email;

	private String imagen;

	private String tema;

	private String codigo;

	private String dominio;

	private String url;

	private RedSocial facebook;

	private RedSocial google;

	private RedSocial twitter;

	public OrganismoVisualizar(Organismo organismo) {
		rellenarOrganismo(organismo);

	}

	public OrganismoVisualizar(Organismo organismo, HttpServletRequest request) {
		rellenarOrganismo(organismo);
		url = UtilUrlWeb.getUrlBase(organismo, "");

	}

	private void rellenarOrganismo(Organismo organismo) {
		if (organismo.getNombre() == null) {
			nombre = "";
		} else {
			nombre = organismo.getNombre();
		}

		if (organismo.getNombreVa() == null) {
			nombreVa = "";
		} else {
			nombreVa = organismo.getNombreVa();
		}

		if (organismo.getCif() == null) {
			cif = "";
		} else {
			cif = organismo.getCif();
		}
		if (organismo.getDireccion() == null) {
			direccion = "";
		} else {
			direccion = organismo.getDireccion();
		}

		if (organismo.getDireccionVa() == null) {
			direccionVa = "";
		} else {
			direccionVa = organismo.getDireccionVa();
		}
		if (organismo.getTelefono() == null) {
			telefono = "";
		} else {
			telefono = organismo.getTelefono();
		}
		if (organismo.getFax() == null) {
			fax = "";
		} else {
			fax = organismo.getFax();
		}
		if (organismo.getEmail() == null) {
			email = "";
		} else {
			email = organismo.getEmail();
		}
		if (organismo.getImagen() == null) {
			imagen = "img/escudo.png";
		} else {
			imagen = "." + Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS) + "/" + organismo.getCif() + "/" + organismo.getNombreImagen();
		}

		if (organismo.getTema() == null) {
			tema = "verde";
		} else {
			if (organismo.getTema() == 1) {
				tema = "verde";
			} else {
				if (organismo.getTema() == 2) {
					tema = "azul";
				} else {
					if (organismo.getTema() == 3) {
						tema = "naranja";
					} else {
						tema = "verde";
					}

				}
			}
		}
		if (organismo.getCodigo() == null) {
			codigo = "";
		} else {
			codigo = organismo.getCodigo();
		}

		if (organismo.getDominio() == null) {
			dominio = "";
		} else {
			dominio = organismo.getDominio();
		}
		facebook = organismo.getFacebook();
		twitter = organismo.getTwitter();
		google = organismo.getGoogle();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreVa() {
		return nombreVa;
	}

	public void setNombreVa(String nombreVa) {
		this.nombreVa = nombreVa;
	}

	public String getDireccionVa() {
		return direccionVa;
	}

	public void setDireccionVa(String direccionVa) {
		this.direccionVa = direccionVa;
	}

	/*
	 * public void setRequestToUrl(String protocol, int port, String contextPath
	 * ) {
	 * 
	 * if (protocol.startsWith("HTTP/") == true) {
	 * 
	 * switch (port) {
	 * 
	 * case HTTP_PORT:
	 * 
	 * this.url = "http://" + this.dominio + contextPath;
	 * 
	 * default:
	 * 
	 * this.url = "http://" + this.dominio + ":" + port + contextPath; } }
	 * 
	 * else if (protocol.startsWith("HTTPS/") == true) {
	 * 
	 * switch (port) {
	 * 
	 * case HTTPS_PORT:
	 * 
	 * this.url = "https://" + this.dominio + contextPath;
	 * 
	 * default:
	 * 
	 * this.url = "https://" + this.dominio + ":" + port + contextPath; } } }
	 */
	/*
	 * public String getUrlIndexJSP() { return this.getUrl() +
	 * "/InitDoAction.do?codigoOrganismo="+this.getCodigo(); }
	 */

	public String getUrlIndexJSP() {
		return this.getDominio() + "/InitDoAction.do?codigoOrganismo=" + this.getCodigo();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public RedSocial getFacebook() {
		return facebook;
	}

	public void setFacebook(RedSocial facebook) {
		this.facebook = facebook;
	}

	public RedSocial getGoogle() {
		return google;
	}

	public void setGoogle(RedSocial google) {
		this.google = google;
	}

	public RedSocial getTwitter() {
		return twitter;
	}

	public void setTwitter(RedSocial twitter) {
		this.twitter = twitter;
	}

}
