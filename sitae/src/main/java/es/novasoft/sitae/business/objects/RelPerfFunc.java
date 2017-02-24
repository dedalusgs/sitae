package es.novasoft.sitae.business.objects;

public class RelPerfFunc implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRelacion;

	private Funcionalidad funcionalidad;

	private Perfil perfil;

	// Constructors

	/** default constructor */
	public RelPerfFunc() {
	}

	/** full constructor */
	public RelPerfFunc(Funcionalidad funcionalidad, Perfil perfil) {
		this.funcionalidad = funcionalidad;
		this.perfil = perfil;
	}

	// Property accessors

	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
