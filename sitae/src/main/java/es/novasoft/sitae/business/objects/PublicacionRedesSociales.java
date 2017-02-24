package es.novasoft.sitae.business.objects;

import java.io.Serializable;

public class PublicacionRedesSociales implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long	      id;
    private String	    facebook;
    private Long	      twitter;
    private String	    googlePlus;

    public PublicacionRedesSociales() {

    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getFacebook() {
	return this.facebook;
    }

    public void setFacebook(String facebook) {
	this.facebook = facebook;
    }

    public Long getTwitter() {
	return this.twitter;
    }

    public void setTwitter(Long twitter) {
	this.twitter = twitter;
    }

    public String getGooglePlus() {
	return this.googlePlus;
    }

    public void setGooglePlus(String googlePlus) {
	this.googlePlus = googlePlus;
    }

}
