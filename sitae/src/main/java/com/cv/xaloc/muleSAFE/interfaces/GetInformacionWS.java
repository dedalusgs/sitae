/**
 * GetInformacionWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.muleSAFE.interfaces;

public class GetInformacionWS  implements java.io.Serializable {
    private java.lang.String idEntidadLocal;

    private java.lang.String xmlGetInformacion;

    public GetInformacionWS() {
    }

    public GetInformacionWS(
           java.lang.String idEntidadLocal,
           java.lang.String xmlGetInformacion) {
           this.idEntidadLocal = idEntidadLocal;
           this.xmlGetInformacion = xmlGetInformacion;
    }


    /**
     * Gets the idEntidadLocal value for this GetInformacionWS.
     * 
     * @return idEntidadLocal
     */
    public java.lang.String getIdEntidadLocal() {
        return idEntidadLocal;
    }


    /**
     * Sets the idEntidadLocal value for this GetInformacionWS.
     * 
     * @param idEntidadLocal
     */
    public void setIdEntidadLocal(java.lang.String idEntidadLocal) {
        this.idEntidadLocal = idEntidadLocal;
    }


    /**
     * Gets the xmlGetInformacion value for this GetInformacionWS.
     * 
     * @return xmlGetInformacion
     */
    public java.lang.String getXmlGetInformacion() {
        return xmlGetInformacion;
    }


    /**
     * Sets the xmlGetInformacion value for this GetInformacionWS.
     * 
     * @param xmlGetInformacion
     */
    public void setXmlGetInformacion(java.lang.String xmlGetInformacion) {
        this.xmlGetInformacion = xmlGetInformacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetInformacionWS)) return false;
        GetInformacionWS other = (GetInformacionWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idEntidadLocal==null && other.getIdEntidadLocal()==null) || 
             (this.idEntidadLocal!=null &&
              this.idEntidadLocal.equals(other.getIdEntidadLocal()))) &&
            ((this.xmlGetInformacion==null && other.getXmlGetInformacion()==null) || 
             (this.xmlGetInformacion!=null &&
              this.xmlGetInformacion.equals(other.getXmlGetInformacion())));
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
        if (getIdEntidadLocal() != null) {
            _hashCode += getIdEntidadLocal().hashCode();
        }
        if (getXmlGetInformacion() != null) {
            _hashCode += getXmlGetInformacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInformacionWS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://interfaces.muleSAFE.xaloc.cv.com/", "getInformacionWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEntidadLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEntidadLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlGetInformacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xmlGetInformacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
