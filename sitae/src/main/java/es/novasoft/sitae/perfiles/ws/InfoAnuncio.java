/**
 * InfoAnuncio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class InfoAnuncio implements java.io.Serializable {
    private java.lang.String     ID_ANUNCIO;

    private java.lang.String     COD_ANUNCIO;

    private java.lang.String     TITULO_ES;

    private java.lang.String     TITULO_VA;

    private java.lang.String     COD_ORGANISMO;

    private java.lang.String     DESCRIPCION_ES;

    private java.lang.String     DESCRIPCION_VA;

    private java.lang.String     AREA_PROCEDENCIA;

    private java.lang.String     ORGANISMO_EXTERNO;

    private java.lang.String     TIPO_ANUNCIO;

    private java.lang.String     NUM_EXP;

    private java.lang.String     NOMBRE_DOC_ANUNCIO;

    private java.lang.String     ANUNCIO_FICHERO;

    private java.lang.String     NOMBRE_DILIGENCIA_ANUNCIO;

    private java.lang.String     DILIGENCIA_FICHERO;

    private java.lang.String     NOMBRE_FIRMA_DILIGENCIA;

    private java.lang.String     FIRMA_DILIGENCIA_FICHERO;

    private java.lang.String     NOMBRE_CERTIFICADO_PUBLICACION;

    private java.lang.String     CERTIFICADO_PUBLICACION_FICHERO;

    private java.util.Date       FECHA_PUBLICACION;

    private java.util.Date       FECHA_PUBLICACON_ESTIMADA;

    private java.util.Date       FECHA_RETIRADA;

    private java.util.Date       FECHA_RETIRADA_ESTIMADA;

    private java.math.BigInteger DIAS_PUBLICACION;

    private java.lang.String     ESTADO;

    private java.lang.String     TIPO_CONT_DIAS;

    private java.lang.String     REDES_SOCIALES;

    private java.lang.String     LISTA_CORREO;

    public InfoAnuncio() {
	this.ID_ANUNCIO = "";
	this.COD_ANUNCIO = "";
	this.TITULO_ES = "";
	this.TITULO_VA = "";
	this.COD_ORGANISMO = "";
	this.DESCRIPCION_ES = "";
	this.DESCRIPCION_VA = "";
	this.AREA_PROCEDENCIA = "";
	this.ORGANISMO_EXTERNO = "";
	this.TIPO_ANUNCIO = "";
	this.NUM_EXP = "";
	this.NOMBRE_DOC_ANUNCIO = "";
	this.ANUNCIO_FICHERO = "";
	this.NOMBRE_DILIGENCIA_ANUNCIO = "";
	this.DILIGENCIA_FICHERO = "";
	this.NOMBRE_FIRMA_DILIGENCIA = "";
	this.FIRMA_DILIGENCIA_FICHERO = "";
	this.NOMBRE_CERTIFICADO_PUBLICACION = "";
	this.CERTIFICADO_PUBLICACION_FICHERO = "";
	this.FECHA_PUBLICACION = this.FECHA_PUBLICACION = null;
	this.FECHA_PUBLICACON_ESTIMADA = this.FECHA_PUBLICACON_ESTIMADA = null;
	this.FECHA_RETIRADA = this.FECHA_RETIRADA = null;
	this.FECHA_RETIRADA_ESTIMADA = this.FECHA_RETIRADA_ESTIMADA = null;
	this.DIAS_PUBLICACION = null;
	this.ESTADO = "";
	this.TIPO_CONT_DIAS = "";
	this.REDES_SOCIALES = "";
	this.LISTA_CORREO = "";
    }

    public InfoAnuncio(java.lang.String ID_ANUNCIO, java.lang.String COD_ANUNCIO, java.lang.String TITULO_ES, java.lang.String TITULO_VA, java.lang.String COD_ORGANISMO,
	    java.lang.String DESCRIPCION_ES, java.lang.String DESCRIPCION_VA, java.lang.String AREA_PROCEDENCIA, java.lang.String ORGANISMO_EXTERNO, java.lang.String TIPO_ANUNCIO,
	    java.lang.String NUM_EXP, java.lang.String NOMBRE_DOC_ANUNCIO, java.lang.String ANUNCIO_FICHERO, java.lang.String NOMBRE_DILIGENCIA_ANUNCIO, java.lang.String DILIGENCIA_FICHERO,
	    java.lang.String NOMBRE_FIRMA_DILIGENCIA, java.lang.String FIRMA_DILIGENCIA_FICHERO, java.lang.String NOMBRE_CERTIFICADO_PUBLICACION, java.lang.String CERTIFICADO_PUBLICACION_FICHERO,
	    java.util.Date FECHA_PUBLICACION, java.util.Date FECHA_PUBLICACON_ESTIMADA, java.util.Date FECHA_RETIRADA, java.util.Date FECHA_RETIRADA_ESTIMADA, java.math.BigInteger DIAS_PUBLICACION,
	    java.lang.String ESTADO, java.lang.String TIPO_CONT_DIAS, java.lang.String REDES_SOCIALES, java.lang.String LISTA_CORREO) {
	this.ID_ANUNCIO = ID_ANUNCIO;
	this.COD_ANUNCIO = COD_ANUNCIO;
	this.TITULO_ES = TITULO_ES;
	this.TITULO_VA = TITULO_VA;
	this.COD_ORGANISMO = COD_ORGANISMO;
	this.DESCRIPCION_ES = DESCRIPCION_ES;
	this.DESCRIPCION_VA = DESCRIPCION_VA;
	this.AREA_PROCEDENCIA = AREA_PROCEDENCIA;
	this.ORGANISMO_EXTERNO = ORGANISMO_EXTERNO;
	this.TIPO_ANUNCIO = TIPO_ANUNCIO;
	this.NUM_EXP = NUM_EXP;
	this.NOMBRE_DOC_ANUNCIO = NOMBRE_DOC_ANUNCIO;
	this.ANUNCIO_FICHERO = ANUNCIO_FICHERO;
	this.NOMBRE_DILIGENCIA_ANUNCIO = NOMBRE_DILIGENCIA_ANUNCIO;
	this.DILIGENCIA_FICHERO = DILIGENCIA_FICHERO;
	this.NOMBRE_FIRMA_DILIGENCIA = NOMBRE_FIRMA_DILIGENCIA;
	this.FIRMA_DILIGENCIA_FICHERO = FIRMA_DILIGENCIA_FICHERO;
	this.NOMBRE_CERTIFICADO_PUBLICACION = NOMBRE_CERTIFICADO_PUBLICACION;
	this.CERTIFICADO_PUBLICACION_FICHERO = CERTIFICADO_PUBLICACION_FICHERO;
	this.FECHA_PUBLICACION = FECHA_PUBLICACION;
	this.FECHA_PUBLICACON_ESTIMADA = FECHA_PUBLICACON_ESTIMADA;
	this.FECHA_RETIRADA = FECHA_RETIRADA;
	this.FECHA_RETIRADA_ESTIMADA = FECHA_RETIRADA_ESTIMADA;
	this.DIAS_PUBLICACION = DIAS_PUBLICACION;
	this.ESTADO = ESTADO;
	this.TIPO_CONT_DIAS = TIPO_CONT_DIAS;
	this.REDES_SOCIALES = REDES_SOCIALES;
	this.LISTA_CORREO = LISTA_CORREO;
    }

    /**
     * Gets the ID_ANUNCIO value for this InfoAnuncio.
     *
     * @return ID_ANUNCIO
     */
    public java.lang.String getID_ANUNCIO() {
	return this.ID_ANUNCIO;
    }

    /**
     * Sets the ID_ANUNCIO value for this InfoAnuncio.
     *
     * @param ID_ANUNCIO
     */
    public void setID_ANUNCIO(java.lang.String ID_ANUNCIO) {
	if (ID_ANUNCIO != null) {
	    this.ID_ANUNCIO = ID_ANUNCIO;
	}
    }

    /**
     * Gets the COD_ANUNCIO value for this InfoAnuncio.
     *
     * @return COD_ANUNCIO
     */
    public java.lang.String getCOD_ANUNCIO() {
	return this.COD_ANUNCIO;
    }

    /**
     * Sets the COD_ANUNCIO value for this InfoAnuncio.
     *
     * @param COD_ANUNCIO
     */
    public void setCOD_ANUNCIO(java.lang.String COD_ANUNCIO) {
	if (COD_ANUNCIO != null) {
	    this.COD_ANUNCIO = COD_ANUNCIO;
	}
    }

    /**
     * Gets the TITULO_ES value for this InfoAnuncio.
     *
     * @return TITULO_ES
     */
    public java.lang.String getTITULO_ES() {
	return this.TITULO_ES;
    }

    /**
     * Sets the TITULO_ES value for this InfoAnuncio.
     *
     * @param TITULO_ES
     */
    public void setTITULO_ES(java.lang.String TITULO_ES) {
	if (TITULO_ES != null) {
	    this.TITULO_ES = TITULO_ES;
	}
    }

    /**
     * Gets the TITULO_VA value for this InfoAnuncio.
     *
     * @return TITULO_VA
     */
    public java.lang.String getTITULO_VA() {
	return this.TITULO_VA;
    }

    /**
     * Sets the TITULO_VA value for this InfoAnuncio.
     *
     * @param TITULO_VA
     */
    public void setTITULO_VA(java.lang.String TITULO_VA) {
	if (TITULO_VA != null) {
	    this.TITULO_VA = TITULO_VA;
	}
    }

    /**
     * Gets the COD_ORGANISMO value for this InfoAnuncio.
     *
     * @return COD_ORGANISMO
     */
    public java.lang.String getCOD_ORGANISMO() {
	return this.COD_ORGANISMO;
    }

    /**
     * Sets the COD_ORGANISMO value for this InfoAnuncio.
     *
     * @param COD_ORGANISMO
     */
    public void setCOD_ORGANISMO(java.lang.String COD_ORGANISMO) {
	if (COD_ORGANISMO != null) {
	    this.COD_ORGANISMO = COD_ORGANISMO;
	}
    }

    /**
     * Gets the DESCRIPCION_ES value for this InfoAnuncio.
     *
     * @return DESCRIPCION_ES
     */
    public java.lang.String getDESCRIPCION_ES() {
	return this.DESCRIPCION_ES;
    }

    /**
     * Sets the DESCRIPCION_ES value for this InfoAnuncio.
     *
     * @param DESCRIPCION_ES
     */
    public void setDESCRIPCION_ES(java.lang.String DESCRIPCION_ES) {
	if (DESCRIPCION_ES != null) {
	    this.DESCRIPCION_ES = DESCRIPCION_ES;
	}
    }

    /**
     * Gets the DESCRIPCION_VA value for this InfoAnuncio.
     *
     * @return DESCRIPCION_VA
     */
    public java.lang.String getDESCRIPCION_VA() {

	return this.DESCRIPCION_VA;
    }

    /**
     * Sets the DESCRIPCION_VA value for this InfoAnuncio.
     *
     * @param DESCRIPCION_VA
     */
    public void setDESCRIPCION_VA(java.lang.String DESCRIPCION_VA) {
	if (DESCRIPCION_VA != null) {
	    this.DESCRIPCION_VA = DESCRIPCION_VA;
	}
    }

    /**
     * Gets the AREA_PROCEDENCIA value for this InfoAnuncio.
     *
     * @return AREA_PROCEDENCIA
     */
    public java.lang.String getAREA_PROCEDENCIA() {

	return this.AREA_PROCEDENCIA;
    }

    /**
     * Sets the AREA_PROCEDENCIA value for this InfoAnuncio.
     *
     * @param AREA_PROCEDENCIA
     */
    public void setAREA_PROCEDENCIA(java.lang.String AREA_PROCEDENCIA) {
	if (AREA_PROCEDENCIA != null) {
	    this.AREA_PROCEDENCIA = AREA_PROCEDENCIA;
	}
    }

    /**
     * Gets the ORGANISMO_EXTERNO value for this InfoAnuncio.
     *
     * @return ORGANISMO_EXTERNO
     */
    public java.lang.String getORGANISMO_EXTERNO() {
	return this.ORGANISMO_EXTERNO;
    }

    /**
     * Sets the ORGANISMO_EXTERNO value for this InfoAnuncio.
     *
     * @param ORGANISMO_EXTERNO
     */
    public void setORGANISMO_EXTERNO(java.lang.String ORGANISMO_EXTERNO) {
	if (ORGANISMO_EXTERNO != null) {
	    this.ORGANISMO_EXTERNO = ORGANISMO_EXTERNO;
	}
    }

    /**
     * Gets the TIPO_ANUNCIO value for this InfoAnuncio.
     *
     * @return TIPO_ANUNCIO
     */
    public java.lang.String getTIPO_ANUNCIO() {
	return this.TIPO_ANUNCIO;
    }

    /**
     * Sets the TIPO_ANUNCIO value for this InfoAnuncio.
     *
     * @param TIPO_ANUNCIO
     */
    public void setTIPO_ANUNCIO(java.lang.String TIPO_ANUNCIO) {
	if (TIPO_ANUNCIO != null) {
	    this.TIPO_ANUNCIO = TIPO_ANUNCIO;
	}
    }

    /**
     * Gets the NUM_EXP value for this InfoAnuncio.
     *
     * @return NUM_EXP
     */
    public java.lang.String getNUM_EXP() {
	return this.NUM_EXP;
    }

    /**
     * Sets the NUM_EXP value for this InfoAnuncio.
     *
     * @param NUM_EXP
     */
    public void setNUM_EXP(java.lang.String NUM_EXP) {
	if (NUM_EXP != null) {
	    this.NUM_EXP = NUM_EXP;
	}
    }

    /**
     * Gets the NOMBRE_DOC_ANUNCIO value for this InfoAnuncio.
     *
     * @return NOMBRE_DOC_ANUNCIO
     */
    public java.lang.String getNOMBRE_DOC_ANUNCIO() {
	return this.NOMBRE_DOC_ANUNCIO;
    }

    /**
     * Sets the NOMBRE_DOC_ANUNCIO value for this InfoAnuncio.
     *
     * @param NOMBRE_DOC_ANUNCIO
     */
    public void setNOMBRE_DOC_ANUNCIO(java.lang.String NOMBRE_DOC_ANUNCIO) {
	if (NOMBRE_DOC_ANUNCIO != null) {
	    this.NOMBRE_DOC_ANUNCIO = NOMBRE_DOC_ANUNCIO;
	}
    }

    /**
     * Gets the ANUNCIO_FICHERO value for this InfoAnuncio.
     *
     * @return ANUNCIO_FICHERO
     */
    public java.lang.String getANUNCIO_FICHERO() {

	return this.ANUNCIO_FICHERO;
    }

    /**
     * Sets the ANUNCIO_FICHERO value for this InfoAnuncio.
     *
     * @param ANUNCIO_FICHERO
     */
    public void setANUNCIO_FICHERO(java.lang.String ANUNCIO_FICHERO) {
	if (ANUNCIO_FICHERO != null) {
	    this.ANUNCIO_FICHERO = ANUNCIO_FICHERO;
	}
    }

    /**
     * Gets the NOMBRE_DILIGENCIA_ANUNCIO value for this InfoAnuncio.
     *
     * @return NOMBRE_DILIGENCIA_ANUNCIO
     */
    public java.lang.String getNOMBRE_DILIGENCIA_ANUNCIO() {
	return this.NOMBRE_DILIGENCIA_ANUNCIO;
    }

    /**
     * Sets the NOMBRE_DILIGENCIA_ANUNCIO value for this InfoAnuncio.
     *
     * @param NOMBRE_DILIGENCIA_ANUNCIO
     */
    public void setNOMBRE_DILIGENCIA_ANUNCIO(java.lang.String NOMBRE_DILIGENCIA_ANUNCIO) {
	if (NOMBRE_DILIGENCIA_ANUNCIO != null) {
	    this.NOMBRE_DILIGENCIA_ANUNCIO = NOMBRE_DILIGENCIA_ANUNCIO;
	}
    }

    /**
     * Gets the DILIGENCIA_FICHERO value for this InfoAnuncio.
     *
     * @return DILIGENCIA_FICHERO
     */
    public java.lang.String getDILIGENCIA_FICHERO() {
	return this.DILIGENCIA_FICHERO;
    }

    /**
     * Sets the DILIGENCIA_FICHERO value for this InfoAnuncio.
     *
     * @param DILIGENCIA_FICHERO
     */
    public void setDILIGENCIA_FICHERO(java.lang.String DILIGENCIA_FICHERO) {
	if (DILIGENCIA_FICHERO != null) {
	    this.DILIGENCIA_FICHERO = DILIGENCIA_FICHERO;
	}
    }

    /**
     * Gets the NOMBRE_FIRMA_DILIGENCIA value for this InfoAnuncio.
     *
     * @return NOMBRE_FIRMA_DILIGENCIA
     */
    public java.lang.String getNOMBRE_FIRMA_DILIGENCIA() {

	return this.NOMBRE_FIRMA_DILIGENCIA;
    }

    /**
     * Sets the NOMBRE_FIRMA_DILIGENCIA value for this InfoAnuncio.
     *
     * @param NOMBRE_FIRMA_DILIGENCIA
     */
    public void setNOMBRE_FIRMA_DILIGENCIA(java.lang.String NOMBRE_FIRMA_DILIGENCIA) {
	if (NOMBRE_FIRMA_DILIGENCIA != null) {
	    this.NOMBRE_FIRMA_DILIGENCIA = NOMBRE_FIRMA_DILIGENCIA;
	}
    }

    /**
     * Gets the FIRMA_DILIGENCIA_FICHERO value for this InfoAnuncio.
     *
     * @return FIRMA_DILIGENCIA_FICHERO
     */
    public java.lang.String getFIRMA_DILIGENCIA_FICHERO() {
	return this.FIRMA_DILIGENCIA_FICHERO;
    }

    /**
     * Sets the FIRMA_DILIGENCIA_FICHERO value for this InfoAnuncio.
     *
     * @param FIRMA_DILIGENCIA_FICHERO
     */
    public void setFIRMA_DILIGENCIA_FICHERO(java.lang.String FIRMA_DILIGENCIA_FICHERO) {
	if (FIRMA_DILIGENCIA_FICHERO != null) {
	    this.FIRMA_DILIGENCIA_FICHERO = FIRMA_DILIGENCIA_FICHERO;
	}
    }

    /**
     * Gets the NOMBRE_CERTIFICADO_PUBLICACION value for this InfoAnuncio.
     *
     * @return NOMBRE_CERTIFICADO_PUBLICACION
     */
    public java.lang.String getNOMBRE_CERTIFICADO_PUBLICACION() {
	return this.NOMBRE_CERTIFICADO_PUBLICACION;
    }

    /**
     * Sets the NOMBRE_CERTIFICADO_PUBLICACION value for this InfoAnuncio.
     *
     * @param NOMBRE_CERTIFICADO_PUBLICACION
     */
    public void setNOMBRE_CERTIFICADO_PUBLICACION(java.lang.String NOMBRE_CERTIFICADO_PUBLICACION) {
	if (NOMBRE_CERTIFICADO_PUBLICACION != null) {
	    this.NOMBRE_CERTIFICADO_PUBLICACION = NOMBRE_CERTIFICADO_PUBLICACION;
	}
    }

    /**
     * Gets the CERTIFICADO_PUBLICACION_FICHERO value for this InfoAnuncio.
     *
     * @return CERTIFICADO_PUBLICACION_FICHERO
     */
    public java.lang.String getCERTIFICADO_PUBLICACION_FICHERO() {
	return this.CERTIFICADO_PUBLICACION_FICHERO;
    }

    /**
     * Sets the CERTIFICADO_PUBLICACION_FICHERO value for this InfoAnuncio.
     *
     * @param CERTIFICADO_PUBLICACION_FICHERO
     */
    public void setCERTIFICADO_PUBLICACION_FICHERO(java.lang.String CERTIFICADO_PUBLICACION_FICHERO) {
	if (CERTIFICADO_PUBLICACION_FICHERO != null) {
	    this.CERTIFICADO_PUBLICACION_FICHERO = CERTIFICADO_PUBLICACION_FICHERO;
	}
    }

    /**
     * Gets the FECHA_PUBLICACION value for this InfoAnuncio.
     *
     * @return FECHA_PUBLICACION
     */
    public java.util.Date getFECHA_PUBLICACION() {
	return this.FECHA_PUBLICACION;
    }

    /**
     * Sets the FECHA_PUBLICACION value for this InfoAnuncio.
     *
     * @param FECHA_PUBLICACION
     */
    public void setFECHA_PUBLICACION(java.util.Date FECHA_PUBLICACION) {
	if (FECHA_PUBLICACION != null) {
	    this.FECHA_PUBLICACION = FECHA_PUBLICACION;
	}
    }

    /**
     * Gets the FECHA_PUBLICACON_ESTIMADA value for this InfoAnuncio.
     *
     * @return FECHA_PUBLICACON_ESTIMADA
     */
    public java.util.Date getFECHA_PUBLICACON_ESTIMADA() {
	return this.FECHA_PUBLICACON_ESTIMADA;
    }

    /**
     * Sets the FECHA_PUBLICACON_ESTIMADA value for this InfoAnuncio.
     *
     * @param FECHA_PUBLICACON_ESTIMADA
     */
    public void setFECHA_PUBLICACON_ESTIMADA(java.util.Date FECHA_PUBLICACON_ESTIMADA) {
	if (FECHA_PUBLICACON_ESTIMADA != null) {
	    this.FECHA_PUBLICACON_ESTIMADA = FECHA_PUBLICACON_ESTIMADA;
	}
    }

    /**
     * Gets the FECHA_RETIRADA value for this InfoAnuncio.
     *
     * @return FECHA_RETIRADA
     */
    public java.util.Date getFECHA_RETIRADA() {
	return this.FECHA_RETIRADA;
    }

    /**
     * Sets the FECHA_RETIRADA value for this InfoAnuncio.
     *
     * @param FECHA_RETIRADA
     */
    public void setFECHA_RETIRADA(java.util.Date FECHA_RETIRADA) {
	if (FECHA_RETIRADA != null) {
	    this.FECHA_RETIRADA = FECHA_RETIRADA;
	}
    }

    /**
     * Gets the FECHA_RETIRADA_ESTIMADA value for this InfoAnuncio.
     *
     * @return FECHA_RETIRADA_ESTIMADA
     */
    public java.util.Date getFECHA_RETIRADA_ESTIMADA() {
	return this.FECHA_RETIRADA_ESTIMADA;
    }

    /**
     * Sets the FECHA_RETIRADA_ESTIMADA value for this InfoAnuncio.
     *
     * @param FECHA_RETIRADA_ESTIMADA
     */
    public void setFECHA_RETIRADA_ESTIMADA(java.util.Date FECHA_RETIRADA_ESTIMADA) {
	if (FECHA_RETIRADA_ESTIMADA != null) {
	    this.FECHA_RETIRADA_ESTIMADA = FECHA_RETIRADA_ESTIMADA;
	}
    }

    /**
     * Gets the DIAS_PUBLICACION value for this InfoAnuncio.
     *
     * @return DIAS_PUBLICACION
     */
    public java.math.BigInteger getDIAS_PUBLICACION() {
	return this.DIAS_PUBLICACION;
    }

    /**
     * Sets the DIAS_PUBLICACION value for this InfoAnuncio.
     *
     * @param DIAS_PUBLICACION
     */
    public void setDIAS_PUBLICACION(java.math.BigInteger DIAS_PUBLICACION) {
	if (DIAS_PUBLICACION != null) {
	    this.DIAS_PUBLICACION = DIAS_PUBLICACION;
	}
    }

    /**
     * Gets the ESTADO value for this InfoAnuncio.
     *
     * @return ESTADO
     */
    public java.lang.String getESTADO() {
	return this.ESTADO;
    }

    /**
     * Sets the ESTADO value for this InfoAnuncio.
     *
     * @param ESTADO
     */
    public void setESTADO(java.lang.String ESTADO) {
	if (ESTADO != null) {
	    this.ESTADO = ESTADO;
	}
    }

    /**
     * Gets the TIPO_CONT_DIAS value for this InfoAnuncio.
     *
     * @return TIPO_CONT_DIAS
     */
    public java.lang.String getTIPO_CONT_DIAS() {
	return this.TIPO_CONT_DIAS;
    }

    /**
     * Sets the TIPO_CONT_DIAS value for this InfoAnuncio.
     *
     * @param TIPO_CONT_DIAS
     */
    public void setTIPO_CONT_DIAS(java.lang.String TIPO_CONT_DIAS) {
	if (TIPO_CONT_DIAS != null) {
	    this.TIPO_CONT_DIAS = TIPO_CONT_DIAS;
	}
    }

    /**
     * Gets the REDES_SOCIALES value for this InfoAnuncio.
     *
     * @return REDES_SOCIALES
     */
    public java.lang.String getREDES_SOCIALES() {
	return this.REDES_SOCIALES;
    }

    /**
     * Sets the REDES_SOCIALES value for this InfoAnuncio.
     *
     * @param REDES_SOCIALES
     */
    public void setREDES_SOCIALES(java.lang.String REDES_SOCIALES) {
	if (REDES_SOCIALES == null) {
	    this.REDES_SOCIALES = "NO";
	} else {
	    this.REDES_SOCIALES = REDES_SOCIALES;
	}
    }

    /**
     * Gets the LISTA_CORREO value for this InfoAnuncio.
     *
     * @return LISTA_CORREO
     */
    public java.lang.String getLISTA_CORREO() {
	return this.LISTA_CORREO;
    }

    /**
     * Sets the LISTA_CORREO value for this InfoAnuncio.
     *
     * @param LISTA_CORREO
     */
    public void setLISTA_CORREO(java.lang.String LISTA_CORREO) {
	if (LISTA_CORREO == null) {
	    this.LISTA_CORREO = "NO";
	} else {
	    this.LISTA_CORREO = LISTA_CORREO;
	}
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
	if (!(obj instanceof InfoAnuncio)) {
	    return false;
	}
	InfoAnuncio other = (InfoAnuncio) obj;
	if (obj == null) {
	    return false;
	}
	if (this == obj) {
	    return true;
	}
	if (this.__equalsCalc != null) {
	    return (this.__equalsCalc == obj);
	}
	this.__equalsCalc = obj;
	boolean _equals;
	_equals = true
		&& ((this.ID_ANUNCIO == null && other.getID_ANUNCIO() == null) || (this.ID_ANUNCIO != null && this.ID_ANUNCIO.equals(other.getID_ANUNCIO())))
		&& ((this.COD_ANUNCIO == null && other.getCOD_ANUNCIO() == null) || (this.COD_ANUNCIO != null && this.COD_ANUNCIO.equals(other.getCOD_ANUNCIO())))
		&& ((this.TITULO_ES == null && other.getTITULO_ES() == null) || (this.TITULO_ES != null && this.TITULO_ES.equals(other.getTITULO_ES())))
		&& ((this.TITULO_VA == null && other.getTITULO_VA() == null) || (this.TITULO_VA != null && this.TITULO_VA.equals(other.getTITULO_VA())))
		&& ((this.COD_ORGANISMO == null && other.getCOD_ORGANISMO() == null) || (this.COD_ORGANISMO != null && this.COD_ORGANISMO.equals(other.getCOD_ORGANISMO())))
		&& ((this.DESCRIPCION_ES == null && other.getDESCRIPCION_ES() == null) || (this.DESCRIPCION_ES != null && this.DESCRIPCION_ES.equals(other.getDESCRIPCION_ES())))
		&& ((this.DESCRIPCION_VA == null && other.getDESCRIPCION_VA() == null) || (this.DESCRIPCION_VA != null && this.DESCRIPCION_VA.equals(other.getDESCRIPCION_VA())))
		&& ((this.AREA_PROCEDENCIA == null && other.getAREA_PROCEDENCIA() == null) || (this.AREA_PROCEDENCIA != null && this.AREA_PROCEDENCIA.equals(other.getAREA_PROCEDENCIA())))
		&& ((this.ORGANISMO_EXTERNO == null && other.getORGANISMO_EXTERNO() == null) || (this.ORGANISMO_EXTERNO != null && this.ORGANISMO_EXTERNO.equals(other.getORGANISMO_EXTERNO())))
		&& ((this.TIPO_ANUNCIO == null && other.getTIPO_ANUNCIO() == null) || (this.TIPO_ANUNCIO != null && this.TIPO_ANUNCIO.equals(other.getTIPO_ANUNCIO())))
		&& ((this.NUM_EXP == null && other.getNUM_EXP() == null) || (this.NUM_EXP != null && this.NUM_EXP.equals(other.getNUM_EXP())))
		&& ((this.NOMBRE_DOC_ANUNCIO == null && other.getNOMBRE_DOC_ANUNCIO() == null) || (this.NOMBRE_DOC_ANUNCIO != null && this.NOMBRE_DOC_ANUNCIO.equals(other.getNOMBRE_DOC_ANUNCIO())))
		&& ((this.ANUNCIO_FICHERO == null && other.getANUNCIO_FICHERO() == null) || (this.ANUNCIO_FICHERO != null && this.ANUNCIO_FICHERO.equals(other.getANUNCIO_FICHERO())))
		&& ((this.NOMBRE_DILIGENCIA_ANUNCIO == null && other.getNOMBRE_DILIGENCIA_ANUNCIO() == null) || (this.NOMBRE_DILIGENCIA_ANUNCIO != null && this.NOMBRE_DILIGENCIA_ANUNCIO.equals(other
			.getNOMBRE_DILIGENCIA_ANUNCIO())))
		&& ((this.DILIGENCIA_FICHERO == null && other.getDILIGENCIA_FICHERO() == null) || (this.DILIGENCIA_FICHERO != null && this.DILIGENCIA_FICHERO.equals(other.getDILIGENCIA_FICHERO())))
		&& ((this.NOMBRE_FIRMA_DILIGENCIA == null && other.getNOMBRE_FIRMA_DILIGENCIA() == null) || (this.NOMBRE_FIRMA_DILIGENCIA != null && this.NOMBRE_FIRMA_DILIGENCIA.equals(other
			.getNOMBRE_FIRMA_DILIGENCIA())))
		&& ((this.FIRMA_DILIGENCIA_FICHERO == null && other.getFIRMA_DILIGENCIA_FICHERO() == null) || (this.FIRMA_DILIGENCIA_FICHERO != null && this.FIRMA_DILIGENCIA_FICHERO.equals(other
			.getFIRMA_DILIGENCIA_FICHERO())))
		&& ((this.NOMBRE_CERTIFICADO_PUBLICACION == null && other.getNOMBRE_CERTIFICADO_PUBLICACION() == null) || (this.NOMBRE_CERTIFICADO_PUBLICACION != null && this.NOMBRE_CERTIFICADO_PUBLICACION
			.equals(other.getNOMBRE_CERTIFICADO_PUBLICACION())))
		&& ((this.CERTIFICADO_PUBLICACION_FICHERO == null && other.getCERTIFICADO_PUBLICACION_FICHERO() == null) || (this.CERTIFICADO_PUBLICACION_FICHERO != null && this.CERTIFICADO_PUBLICACION_FICHERO
			.equals(other.getCERTIFICADO_PUBLICACION_FICHERO())))
		&& ((this.FECHA_PUBLICACION == null && other.getFECHA_PUBLICACION() == null) || (this.FECHA_PUBLICACION != null && this.FECHA_PUBLICACION.equals(other.getFECHA_PUBLICACION())))
		&& ((this.FECHA_PUBLICACON_ESTIMADA == null && other.getFECHA_PUBLICACON_ESTIMADA() == null) || (this.FECHA_PUBLICACON_ESTIMADA != null && this.FECHA_PUBLICACON_ESTIMADA.equals(other
			.getFECHA_PUBLICACON_ESTIMADA())))
		&& ((this.FECHA_RETIRADA == null && other.getFECHA_RETIRADA() == null) || (this.FECHA_RETIRADA != null && this.FECHA_RETIRADA.equals(other.getFECHA_RETIRADA())))
		&& ((this.FECHA_RETIRADA_ESTIMADA == null && other.getFECHA_RETIRADA_ESTIMADA() == null) || (this.FECHA_RETIRADA_ESTIMADA != null && this.FECHA_RETIRADA_ESTIMADA.equals(other
			.getFECHA_RETIRADA_ESTIMADA())))
		&& ((this.DIAS_PUBLICACION == null && other.getDIAS_PUBLICACION() == null) || (this.DIAS_PUBLICACION != null && this.DIAS_PUBLICACION.equals(other.getDIAS_PUBLICACION())))
		&& ((this.ESTADO == null && other.getESTADO() == null) || (this.ESTADO != null && this.ESTADO.equals(other.getESTADO())))
		&& ((this.TIPO_CONT_DIAS == null && other.getTIPO_CONT_DIAS() == null) || (this.TIPO_CONT_DIAS != null && this.TIPO_CONT_DIAS.equals(other.getTIPO_CONT_DIAS())))
		&& ((this.REDES_SOCIALES == null && other.getREDES_SOCIALES() == null) || (this.REDES_SOCIALES != null && this.REDES_SOCIALES.equals(other.getREDES_SOCIALES())))
		&& ((this.LISTA_CORREO == null && other.getLISTA_CORREO() == null) || (this.LISTA_CORREO != null && this.LISTA_CORREO.equals(other.getLISTA_CORREO())));
	this.__equalsCalc = null;
	return _equals;
    }

    private boolean __hashCodeCalc = false;

    public synchronized int hashCode() {
	if (this.__hashCodeCalc) {
	    return 0;
	}
	this.__hashCodeCalc = true;
	int _hashCode = 1;
	if (getID_ANUNCIO() != null) {
	    _hashCode += getID_ANUNCIO().hashCode();
	}
	if (getCOD_ANUNCIO() != null) {
	    _hashCode += getCOD_ANUNCIO().hashCode();
	}
	if (getTITULO_ES() != null) {
	    _hashCode += getTITULO_ES().hashCode();
	}
	if (getTITULO_VA() != null) {
	    _hashCode += getTITULO_VA().hashCode();
	}
	if (getCOD_ORGANISMO() != null) {
	    _hashCode += getCOD_ORGANISMO().hashCode();
	}
	if (getDESCRIPCION_ES() != null) {
	    _hashCode += getDESCRIPCION_ES().hashCode();
	}
	if (getDESCRIPCION_VA() != null) {
	    _hashCode += getDESCRIPCION_VA().hashCode();
	}
	if (getAREA_PROCEDENCIA() != null) {
	    _hashCode += getAREA_PROCEDENCIA().hashCode();
	}
	if (getORGANISMO_EXTERNO() != null) {
	    _hashCode += getORGANISMO_EXTERNO().hashCode();
	}
	if (getTIPO_ANUNCIO() != null) {
	    _hashCode += getTIPO_ANUNCIO().hashCode();
	}
	if (getNUM_EXP() != null) {
	    _hashCode += getNUM_EXP().hashCode();
	}
	if (getNOMBRE_DOC_ANUNCIO() != null) {
	    _hashCode += getNOMBRE_DOC_ANUNCIO().hashCode();
	}
	if (getANUNCIO_FICHERO() != null) {
	    _hashCode += getANUNCIO_FICHERO().hashCode();
	}
	if (getNOMBRE_DILIGENCIA_ANUNCIO() != null) {
	    _hashCode += getNOMBRE_DILIGENCIA_ANUNCIO().hashCode();
	}
	if (getDILIGENCIA_FICHERO() != null) {
	    _hashCode += getDILIGENCIA_FICHERO().hashCode();
	}
	if (getNOMBRE_FIRMA_DILIGENCIA() != null) {
	    _hashCode += getNOMBRE_FIRMA_DILIGENCIA().hashCode();
	}
	if (getFIRMA_DILIGENCIA_FICHERO() != null) {
	    _hashCode += getFIRMA_DILIGENCIA_FICHERO().hashCode();
	}
	if (getNOMBRE_CERTIFICADO_PUBLICACION() != null) {
	    _hashCode += getNOMBRE_CERTIFICADO_PUBLICACION().hashCode();
	}
	if (getCERTIFICADO_PUBLICACION_FICHERO() != null) {
	    _hashCode += getCERTIFICADO_PUBLICACION_FICHERO().hashCode();
	}
	if (getFECHA_PUBLICACION() != null) {
	    _hashCode += getFECHA_PUBLICACION().hashCode();
	}
	if (getFECHA_PUBLICACON_ESTIMADA() != null) {
	    _hashCode += getFECHA_PUBLICACON_ESTIMADA().hashCode();
	}
	if (getFECHA_RETIRADA() != null) {
	    _hashCode += getFECHA_RETIRADA().hashCode();
	}
	if (getFECHA_RETIRADA_ESTIMADA() != null) {
	    _hashCode += getFECHA_RETIRADA_ESTIMADA().hashCode();
	}
	if (getDIAS_PUBLICACION() != null) {
	    _hashCode += getDIAS_PUBLICACION().hashCode();
	}
	if (getESTADO() != null) {
	    _hashCode += getESTADO().hashCode();
	}
	if (getTIPO_CONT_DIAS() != null) {
	    _hashCode += getTIPO_CONT_DIAS().hashCode();
	}
	if (getREDES_SOCIALES() != null) {
	    _hashCode += getREDES_SOCIALES().hashCode();
	}
	if (getLISTA_CORREO() != null) {
	    _hashCode += getLISTA_CORREO().hashCode();
	}
	this.__hashCodeCalc = false;
	return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(InfoAnuncio.class, true);

    static {
	typeDesc.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "infoAnuncio"));
	org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("ID_ANUNCIO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "ID_ANUNCIO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("COD_ANUNCIO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "COD_ANUNCIO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("TITULO_ES");
	elemField.setXmlName(new javax.xml.namespace.QName("", "TITULO_ES"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("TITULO_VA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "TITULO_VA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("COD_ORGANISMO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "COD_ORGANISMO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("DESCRIPCION_ES");
	elemField.setXmlName(new javax.xml.namespace.QName("", "DESCRIPCION_ES"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("DESCRIPCION_VA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "DESCRIPCION_VA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("AREA_PROCEDENCIA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "AREA_PROCEDENCIA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("ORGANISMO_EXTERNO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "ORGANISMO_EXTERNO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("TIPO_ANUNCIO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "TIPO_ANUNCIO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("NUM_EXP");
	elemField.setXmlName(new javax.xml.namespace.QName("", "NUM_EXP"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("NOMBRE_DOC_ANUNCIO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE_DOC_ANUNCIO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("ANUNCIO_FICHERO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "ANUNCIO_FICHERO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("NOMBRE_DILIGENCIA_ANUNCIO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE_DILIGENCIA_ANUNCIO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("DILIGENCIA_FICHERO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "DILIGENCIA_FICHERO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("NOMBRE_FIRMA_DILIGENCIA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE_FIRMA_DILIGENCIA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("FIRMA_DILIGENCIA_FICHERO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "FIRMA_DILIGENCIA_FICHERO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("NOMBRE_CERTIFICADO_PUBLICACION");
	elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE_CERTIFICADO_PUBLICACION"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("CERTIFICADO_PUBLICACION_FICHERO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "CERTIFICADO_PUBLICACION_FICHERO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("FECHA_PUBLICACION");
	elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA_PUBLICACION"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
	elemField.setMinOccurs(0);
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("FECHA_PUBLICACON_ESTIMADA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA_PUBLICACON_ESTIMADA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
	elemField.setMinOccurs(0);
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("FECHA_RETIRADA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA_RETIRADA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
	elemField.setMinOccurs(0);
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("FECHA_RETIRADA_ESTIMADA");
	elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA_RETIRADA_ESTIMADA"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
	elemField.setMinOccurs(0);
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("DIAS_PUBLICACION");
	elemField.setXmlName(new javax.xml.namespace.QName("", "DIAS_PUBLICACION"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("ESTADO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "ESTADO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("TIPO_CONT_DIAS");
	elemField.setXmlName(new javax.xml.namespace.QName("", "TIPO_CONT_DIAS"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("REDES_SOCIALES");
	elemField.setXmlName(new javax.xml.namespace.QName("", "REDES_SOCIALES"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
	elemField = new org.apache.axis.description.ElementDesc();
	elemField.setFieldName("LISTA_CORREO");
	elemField.setXmlName(new javax.xml.namespace.QName("", "LISTA_CORREO"));
	elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	elemField.setNillable(false);
	typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
	return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
	return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
	return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
    }

}
