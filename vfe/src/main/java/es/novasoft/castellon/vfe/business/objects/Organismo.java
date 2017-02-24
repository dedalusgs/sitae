/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: Organismo.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.castellon.vfe.business.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.novasoft.comun.utils.TemaVisualizar;

// TODO: Auto-generated Javadoc
/**
 * Organismo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Organismo implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id org. */
	private Integer idOrg;

	/** The nombre. */
	private String nombre;

	/** The direccion. */
	private String direccion;

	/** The telefono. */
	private String telefono;

	/** The fax. */
	private String fax;

	/** The email. */
	private String email;

	/** The codigo. */
	private String codigo;

	/** The tema. */
	private Integer codTema;

	private String tema;

	/** The nombre imagen. */
	private String nombreImagen;

	/** The imagen. */
	private byte[] imagen;

	/** The nombre va. */
	private String nombreVa;

	/** The direccion va. */
	private String direccionVa;

	/** The dominio. */
	private String dominio;

	// Constructors

	/**
	 * default constructor.
	 */
	public Organismo() {
	}

	/**
	 * minimal constructor.
	 * 
	 * @param nombre
	 *            the nombre
	 * @param cif
	 *            the cif
	 * @param direccion
	 *            the direccion
	 * @param telefono
	 *            the telefono
	 * @param fax
	 *            the fax
	 * @param email
	 *            the email
	 * @param imagen
	 *            the imagen
	 * @param codigo
	 *            the codigo
	 */
	public Organismo(String nombre, String direccion, String telefono,
			String fax, String email, byte[] imagen, String codigo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fax = fax;
		this.email = email;
		this.imagen = imagen;
		this.codigo = codigo;
	}

	// Property accessors

	/**
	 * Gets the id org.
	 * 
	 * @return the id org
	 */
	public Integer getIdOrg() {
		return this.idOrg;
	}

	/**
	 * Sets the id org.
	 * 
	 * @param idOrg
	 *            the new id org
	 */
	public void setIdOrg(Integer idOrg) {
		this.idOrg = idOrg;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the direccion.
	 * 
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Sets the direccion.
	 * 
	 * @param direccion
	 *            the new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Gets the telefono.
	 * 
	 * @return the telefono
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * Sets the telefono.
	 * 
	 * @param telefono
	 *            the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets the fax.
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * Sets the fax.
	 * 
	 * @param fax
	 *            the new fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the nombre imagen.
	 * 
	 * @return the nombre imagen
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}

	/**
	 * Sets the nombre imagen.
	 * 
	 * @param nombreImagen
	 *            the new nombre imagen
	 */
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	/**
	 * Gets the imagen.
	 * 
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * Sets the imagen.
	 * 
	 * @param imagen
	 *            the new imagen
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

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


	public Integer getCodTema() {
		return codTema;
	}

	public void setCodTema(Integer codTema) {
		this.codTema = codTema;

	}

	public String getTema() {
		if (this.getCodTema() == null) {
			return "verde";
		} else {
			if (this.getCodTema() == 1) {
				return "verde";
			} else {
				if (this.getCodTema() == 2) {
					return "azul";
				} else {
					if (this.getCodTema() == 3) {
						return "naranja";
					} else {
						return "verde";
					}

				}
			}
		}
	}

	/**
	 * Gets the nombre va.
	 * 
	 * @return the nombre va
	 */
	public String getNombreVa() {
		return nombreVa;
	}

	/**
	 * Sets the nombre va.
	 * 
	 * @param nombreVa
	 *            the new nombre va
	 */
	public void setNombreVa(String nombreVa) {
		this.nombreVa = nombreVa;
	}

	/**
	 * Gets the direccion va.
	 * 
	 * @return the direccion va
	 */
	public String getDireccionVa() {
		return direccionVa;
	}

	/**
	 * Sets the direccion va.
	 * 
	 * @param direccionVa
	 *            the new direccion va
	 */
	public void setDireccionVa(String direccionVa) {
		this.direccionVa = direccionVa;
	}

	/**
	 * Gets the dominio.
	 * 
	 * @return the dominio
	 */
	public String getDominio() {
		return dominio;
	}

	/**
	 * Sets the dominio.
	 * 
	 * @param dominio
	 *            the new dominio
	 */
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public static List<TemaVisualizar> rellenarTemas() {
		List listaTemas = new ArrayList();
		TemaVisualizar temaVisualizar = new TemaVisualizar();
		temaVisualizar.setId(1);
		temaVisualizar.setNombre("Verde");
		listaTemas.add(temaVisualizar);
		temaVisualizar = new TemaVisualizar();
		temaVisualizar.setId(2);
		temaVisualizar.setNombre("Azul");
		listaTemas.add(temaVisualizar);
		temaVisualizar = new TemaVisualizar();
		temaVisualizar.setId(3);
		temaVisualizar.setNombre("Naranja");
		listaTemas.add(temaVisualizar);
		return listaTemas;
	}
}