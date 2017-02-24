package es.novasoft.sitae.business.objects;

public class Configuracion implements java.io.Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;
	
	protected String	      parametro;
	protected String	      valor;
	protected String	      descripcion;
	protected String	      encriptada;
	
	public String getParametro() {
		return parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEncriptada() {
		return encriptada;
	}
	
	public void setEncriptada(String encriptada) {
		this.encriptada = encriptada;
	}
	
}
