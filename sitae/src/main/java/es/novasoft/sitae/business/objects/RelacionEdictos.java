package es.novasoft.sitae.business.objects;

public class RelacionEdictos implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idRelacion;
	private Edicto edicto1;
	private Edicto edicto2;
	
	public Integer getIdRelacion() {
		return idRelacion;
	}
	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}
	public Edicto getEdicto1() {
		return edicto1;
	}
	public void setEdicto1(Edicto edicto1) {
		this.edicto1 = edicto1;
	}
	public Edicto getEdicto2() {
		return edicto2;
	}
	public void setEdicto2(Edicto edicto2) {
		this.edicto2 = edicto2;
	}
	public RelacionEdictos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
