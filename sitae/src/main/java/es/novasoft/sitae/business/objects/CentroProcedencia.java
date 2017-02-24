package es.novasoft.sitae.business.objects;

// default package

/**
 * CentroProcedencia entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CentroProcedencia implements java.io.Serializable {
	
	// Fields
	
	private Integer	idCentro;
	
	// private Organismo organismo;
	
	private String	nombre;
	
	private String	descripcion;
	
	public static String removeCharacter(String input) {
		// Cadena de caracteres original a sustituir.
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		String output = input;
		for (int i = 0; i < original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			output = output.replace(original.charAt(i), ascii.charAt(i));
		}// for i
		return output;
	}
	
	// Constructors
	
	/** default constructor */
	public CentroProcedencia() {
	}
	
	/** minimal constructor */
	public CentroProcedencia(String nombre) {
		this.nombre = nombre;
	}
	
	// /** full constructor */
	// public CentroProcedencia(Organismo organismo, String nombre) {
	// this.organismo = organismo;
	// this.nombre = nombre;
	// }
	
	// Property accessors
	
	public Integer getIdCentro() {
		return this.idCentro;
	}
	
	public void setIdCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}
	
	// public Organismo getOrganismo() {
	// return this.organismo;
	// }
	//
	// public void setOrganismo(Organismo organismo) {
	// this.organismo = organismo;
	// }
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNombreCarpeta() {
		return this.nombre;
		/*
		 * String normalized = removeCharacter(this.nombre); Pattern pattern =
		 * Pattern.compile("\\p{IsM}");
		 * normalized=normalized.replaceAll(" ","_"); return
		 * pattern.matcher(normalized).replaceAll("");
		 */
	}
	
}