package es.novasoft.sitae.business.objects;

import java.io.Serializable;
import java.util.Date;

public class Interesado implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long	      id;
    private String	    email;
    private String	    activo;
    private String	    codigo;
    private Date	      fechaCreacion;
    private Date	      fechaModificacion;
    private Organismo	 organismo;

    public Interesado() {
	// TODO Auto-generated constructor stub
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getActivo() {
	return this.activo;
    }

    public void setActivo(String activo) {
	this.activo = activo;
    }

    public String getCodigo() {
	return this.codigo;
    }

    public void setCodigo(String codigo) {
	this.codigo = codigo;
    }

    public Date getFechaCreacion() {
	return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
	return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
	this.fechaModificacion = fechaModificacion;
    }

    public Boolean activo() {
	if (this.activo.equals("S")) {
	    return true;
	} else {
	    return false;
	}
    }

    public void setBooleanActivo(Boolean act) {
	if (act.equals(true)) {
	    this.activo = "S";
	} else {
	    this.activo = "N";
	}

    }

    public Organismo getOrganismo() {
	return this.organismo;
    }

    public void setOrganismo(Organismo organismo) {
	this.organismo = organismo;
    }

}
