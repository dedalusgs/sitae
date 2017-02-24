package es.novasoft.sitae.business.objects;

import java.io.Serializable;

public class RedSocial implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -576223912332135597L;
    public static String      TIPO_FACEBOOK    = "Facebook";
    public static String      TIPO_TWITTER     = "Twitter";
    public static String      TIPO_GOOGLE      = "Google";
    private Long	      Id;

    private String	    tipo;

    private String	    idCuenta;

    private String	    tokenCuenta;

    private String	    Nombre;

    private String	    urlImgUser;

    private String	    urlUser;

    public Long getId() {
	return this.Id;
    }

    public void setId(Long id) {
	this.Id = id;
    }

    public String getTipo() {
	return this.tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    public String getIdCuenta() {
	return this.idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
	this.idCuenta = idCuenta;
    }

    public String getTokenCuenta() {
	return this.tokenCuenta;
    }

    public void setTokenCuenta(String tokenCuenta) {
	this.tokenCuenta = tokenCuenta;
    }

    public String getNombre() {
	return this.Nombre;
    }

    public void setNombre(String nombre) {
	this.Nombre = nombre;
    }

    public String getUrlImgUser() {
	return this.urlImgUser;
    }

    public void setUrlImgUser(String urlImgUser) {
	this.urlImgUser = urlImgUser;
    }

    public String getUrlUser() {
	return this.urlUser;
    }

    public void setUrlUser(String urlUser) {
	this.urlUser = urlUser;
    }

}
