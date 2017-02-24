package es.novasoft.sitae.business.objects;

import java.util.Date;

/**
 * Organismo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Organismo implements java.io.Serializable, Comparable{

	private static final long serialVersionUID = 1L;

	private Integer idOrg;

	private String nombre;

	private String cif;

	private String direccion;

	private String telefono;

	private String fax;

	private String email;

	private String codigo;

	private Integer cont_edicto;

	private Date fecha_edicto;

	private Integer tema;

	private String nombreImagen;

	private byte[] imagen;

	private String nombreVa;

	private String direccionVa;

	private String dominio;

	private String aliasSello;
	
	private RedSocial facebook;
	
	private RedSocial google;
	
	private RedSocial twitter;
	
	// Constructors

	public String getAliasSello() {
		return aliasSello;
	}

	public void setAliasSello(String aliasSello) {
		this.aliasSello = aliasSello;
	}

	/** default constructor */
	public Organismo() {
	}

	/** minimal constructor */
	public Organismo(String nombre, String cif, String direccion,
			String telefono, String fax, String email, byte[] imagen,
			String codigo) {
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fax = fax;
		this.email = email;
		this.imagen = imagen;
		this.codigo = codigo;
	}
	
	public int compareTo(Object o) {
        Organismo organismo = (Organismo)o;       
            return this.nombre.compareToIgnoreCase(organismo.nombre);
    }

	// Property accessors



	public Integer getIdOrg() {
		return this.idOrg;
	}

	public void setIdOrg(Integer idOrg) {
		this.idOrg = idOrg;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCont_edicto() {
		return cont_edicto;
	}

	public void setCont_edicto(Integer cont_edicto) {
		this.cont_edicto = cont_edicto;
	}

	public Date getFecha_edicto() {
		return fecha_edicto;
	}

	public void setFecha_edicto(Date fecha_edicto) {
		this.fecha_edicto = fecha_edicto;
	}

	public Integer getTema() {
		return tema;
	}

	public void setTema(Integer tema) {
		this.tema = tema;
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