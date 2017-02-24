/**
 * CancelarSolicitudRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.externo.ws;

public class CancelarSolicitudRequest  implements java.io.Serializable {
    private java.lang.String NOMBRE_USUARIO;

    private java.lang.String PASSWORD_USUARIO;

    private java.lang.String COD_ORGANISMO;

    private java.lang.String ID_ANUNCIO;

    public CancelarSolicitudRequest() {
    }

    public CancelarSolicitudRequest(
           java.lang.String NOMBRE_USUARIO,
           java.lang.String PASSWORD_USUARIO,
           java.lang.String COD_ORGANISMO,
           java.lang.String ID_ANUNCIO) {
           this.NOMBRE_USUARIO = NOMBRE_USUARIO;
           this.PASSWORD_USUARIO = PASSWORD_USUARIO;
           this.COD_ORGANISMO = COD_ORGANISMO;
           this.ID_ANUNCIO = ID_ANUNCIO;
    }


    /**
     * Gets the NOMBRE_USUARIO value for this CancelarSolicitudRequest.
     * 
     * @return NOMBRE_USUARIO
     */
    public java.lang.String getNOMBRE_USUARIO() {
        return NOMBRE_USUARIO;
    }


    /**
     * Sets the NOMBRE_USUARIO value for this CancelarSolicitudRequest.
     * 
     * @param NOMBRE_USUARIO
     */
    public void setNOMBRE_USUARIO(java.lang.String NOMBRE_USUARIO) {
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
    }


    /**
     * Gets the PASSWORD_USUARIO value for this CancelarSolicitudRequest.
     * 
     * @return PASSWORD_USUARIO
     */
    public java.lang.String getPASSWORD_USUARIO() {
        return PASSWORD_USUARIO;
    }


    /**
     * Sets the PASSWORD_USUARIO value for this CancelarSolicitudRequest.
     * 
     * @param PASSWORD_USUARIO
     */
    public void setPASSWORD_USUARIO(java.lang.String PASSWORD_USUARIO) {
        this.PASSWORD_USUARIO = PASSWORD_USUARIO;
    }


    /**
     * Gets the COD_ORGANISMO value for this CancelarSolicitudRequest.
     * 
     * @return COD_ORGANISMO
     */
    public java.lang.String getCOD_ORGANISMO() {
        return COD_ORGANISMO;
    }


    /**
     * Sets the COD_ORGANISMO value for this CancelarSolicitudRequest.
     * 
     * @param COD_ORGANISMO
     */
    public void setCOD_ORGANISMO(java.lang.String COD_ORGANISMO) {
        this.COD_ORGANISMO = COD_ORGANISMO;
    }


    /**
     * Gets the ID_ANUNCIO value for this CancelarSolicitudRequest.
     * 
     * @return ID_ANUNCIO
     */
    public java.lang.String getID_ANUNCIO() {
        return ID_ANUNCIO;
    }


    /**
     * Sets the ID_ANUNCIO value for this CancelarSolicitudRequest.
     * 
     * @param ID_ANUNCIO
     */
    public void setID_ANUNCIO(java.lang.String ID_ANUNCIO) {
        this.ID_ANUNCIO = ID_ANUNCIO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelarSolicitudRequest)) return false;
        CancelarSolicitudRequest other = (CancelarSolicitudRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.NOMBRE_USUARIO==null && other.getNOMBRE_USUARIO()==null) || 
             (this.NOMBRE_USUARIO!=null &&
              this.NOMBRE_USUARIO.equals(other.getNOMBRE_USUARIO()))) &&
            ((this.PASSWORD_USUARIO==null && other.getPASSWORD_USUARIO()==null) || 
             (this.PASSWORD_USUARIO!=null &&
              this.PASSWORD_USUARIO.equals(other.getPASSWORD_USUARIO()))) &&
            ((this.COD_ORGANISMO==null && other.getCOD_ORGANISMO()==null) || 
             (this.COD_ORGANISMO!=null &&
              this.COD_ORGANISMO.equals(other.getCOD_ORGANISMO()))) &&
            ((this.ID_ANUNCIO==null && other.getID_ANUNCIO()==null) || 
             (this.ID_ANUNCIO!=null &&
              this.ID_ANUNCIO.equals(other.getID_ANUNCIO())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNOMBRE_USUARIO() != null) {
            _hashCode += getNOMBRE_USUARIO().hashCode();
        }
        if (getPASSWORD_USUARIO() != null) {
            _hashCode += getPASSWORD_USUARIO().hashCode();
        }
        if (getCOD_ORGANISMO() != null) {
            _hashCode += getCOD_ORGANISMO().hashCode();
        }
        if (getID_ANUNCIO() != null) {
            _hashCode += getID_ANUNCIO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelarSolicitudRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ttdev.com/ss", "cancelarSolicitudRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOMBRE_USUARIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE_USUARIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PASSWORD_USUARIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PASSWORD_USUARIO"));
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
        elemField.setFieldName("ID_ANUNCIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID_ANUNCIO"));
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
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
