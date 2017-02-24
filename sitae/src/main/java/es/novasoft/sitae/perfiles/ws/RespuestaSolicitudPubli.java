/**
 * RespuestaSolicitudPubli.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class RespuestaSolicitudPubli  implements java.io.Serializable {
    private java.lang.String ID_ANUNCIO;

    private java.util.Date FECHA_INICIO;

    private java.util.Date FECHA_FIN;

    public RespuestaSolicitudPubli() {
    }

    public RespuestaSolicitudPubli(
           java.lang.String ID_ANUNCIO,
           java.util.Date FECHA_INICIO,
           java.util.Date FECHA_FIN) {
           this.ID_ANUNCIO = ID_ANUNCIO;
           this.FECHA_INICIO = FECHA_INICIO;
           this.FECHA_FIN = FECHA_FIN;
    }


    /**
     * Gets the ID_ANUNCIO value for this RespuestaSolicitudPubli.
     * 
     * @return ID_ANUNCIO
     */
    public java.lang.String getID_ANUNCIO() {
        return ID_ANUNCIO;
    }


    /**
     * Sets the ID_ANUNCIO value for this RespuestaSolicitudPubli.
     * 
     * @param ID_ANUNCIO
     */
    public void setID_ANUNCIO(java.lang.String ID_ANUNCIO) {
        this.ID_ANUNCIO = ID_ANUNCIO;
    }


    /**
     * Gets the FECHA_INICIO value for this RespuestaSolicitudPubli.
     * 
     * @return FECHA_INICIO
     */
    public java.util.Date getFECHA_INICIO() {
        return FECHA_INICIO;
    }


    /**
     * Sets the FECHA_INICIO value for this RespuestaSolicitudPubli.
     * 
     * @param FECHA_INICIO
     */
    public void setFECHA_INICIO(java.util.Date FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }


    /**
     * Gets the FECHA_FIN value for this RespuestaSolicitudPubli.
     * 
     * @return FECHA_FIN
     */
    public java.util.Date getFECHA_FIN() {
        return FECHA_FIN;
    }


    /**
     * Sets the FECHA_FIN value for this RespuestaSolicitudPubli.
     * 
     * @param FECHA_FIN
     */
    public void setFECHA_FIN(java.util.Date FECHA_FIN) {
        this.FECHA_FIN = FECHA_FIN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaSolicitudPubli)) return false;
        RespuestaSolicitudPubli other = (RespuestaSolicitudPubli) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_ANUNCIO==null && other.getID_ANUNCIO()==null) || 
             (this.ID_ANUNCIO!=null &&
              this.ID_ANUNCIO.equals(other.getID_ANUNCIO()))) &&
            ((this.FECHA_INICIO==null && other.getFECHA_INICIO()==null) || 
             (this.FECHA_INICIO!=null &&
              this.FECHA_INICIO.equals(other.getFECHA_INICIO()))) &&
            ((this.FECHA_FIN==null && other.getFECHA_FIN()==null) || 
             (this.FECHA_FIN!=null &&
              this.FECHA_FIN.equals(other.getFECHA_FIN())));
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
        if (getID_ANUNCIO() != null) {
            _hashCode += getID_ANUNCIO().hashCode();
        }
        if (getFECHA_INICIO() != null) {
            _hashCode += getFECHA_INICIO().hashCode();
        }
        if (getFECHA_FIN() != null) {
            _hashCode += getFECHA_FIN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaSolicitudPubli.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "respuestaSolicitudPubli"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_ANUNCIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID_ANUNCIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FECHA_INICIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA_INICIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FECHA_FIN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FECHA_FIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
