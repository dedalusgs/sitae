package es.novasoft.sitae.business.objects;

// default package

/**
 * RelacionUsuOrgCentroPerf entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RelacionUsuOrgCentroPerf implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRelacion;

	private CentroProcedencia centroProcedencia;

	private Perfil perfil;

	private String usuario;

	private String organismo;

	// Constructors

	/** default constructor */
	public RelacionUsuOrgCentroPerf() {
	}

	/** full constructor */
	public RelacionUsuOrgCentroPerf(CentroProcedencia centroProcedencia,
			Perfil perfil, String usuario, String organismo) {
		this.centroProcedencia = centroProcedencia;
		this.perfil = perfil;
		this.usuario = usuario;
		this.organismo = organismo;
	}

	// Property accessors

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public CentroProcedencia getCentroProcedencia() {
		return this.centroProcedencia;
	}

	public void setCentroProcedencia(CentroProcedencia centroProcedencia) {
		this.centroProcedencia = centroProcedencia;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getOrganismo() {
		return this.organismo;
	}

	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}

}