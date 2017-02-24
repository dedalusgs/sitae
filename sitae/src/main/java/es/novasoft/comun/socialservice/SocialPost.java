package es.novasoft.comun.socialservice;

/**
 * @author dabel
 * 
 */
public class SocialPost {

	private String url;
	private String titulo;
	private String urlImg;
	private String Descripcion;
	private String hashTags;
	private String dominio;

	public String getHashTags() {
		return hashTags;
	}

	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}

	public SocialPost() {
		url = "";
		titulo = "";
		urlImg = "";
		Descripcion = "";
		hashTags = "";
		dominio = "";
	}

	public SocialPost(String url, String titulo, String urlImg, String descripcion) {
		super();
		this.url = url;
		this.titulo = titulo;
		this.urlImg = urlImg;
		Descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

}
