/**
 * AutenticaUsuarioWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.muleSAFE.interfaces;

public class AutenticaUsuarioWS  implements java.io.Serializable {
    private java.lang.String idEntidadLocal;

    private java.lang.String xmlAut;

    public AutenticaUsuarioWS() {
    }

    public AutenticaUsuarioWS(
           java.lang.String idEntidadLocal,
           java.lang.String xmlAut) {
           this.idEntidadLocal = idEntidadLocal;
           this.xmlAut = xmlAut;
    }


    /**
     * Gets the idEntidadLocal value for this AutenticaUsuarioWS.
     * 
     * @return idEntidadLocal
     */
    public java.lang.String getIdEntidadLocal() {
        return idEntidadLocal;
    }


    /**
     * Sets the idEntidadLocal value for this AutenticaUsuarioWS.
     * 
     * @param idEntidadLocal
     */
    public void setIdEntidadLocal(java.lang.String idEntidadLocal) {
        this.idEntidadLocal = idEntidadLocal;
    }


    /**
     * Gets the xmlAut value for this AutenticaUsuarioWS.
     * 
     * @return xmlAut
     */
    public java.lang.String getXmlAut() {
        return xmlAut;
    }


    /**
     * Sets the xmlAut value for this AutenticaUsuarioWS.
     * 
     * @param xmlAut
     */
    public void setXmlAut(java.lang.String xmlAut) {
        this.xmlAut = xmlAut;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutenticaUsuarioWS)) return false;
        AutenticaUsuarioWS other = (AutenticaUsuarioWS) obj;
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
            ((this.xmlAut==null && other.getXmlAut()==null) || 
             (this.xmlAut!=null &&
              this.xmlAut.equals(other.getXmlAut())));
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
        if (getXmlAut() != null) {
            _hashCode += getXmlAut().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutenticaUsuarioWS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://interfaces.muleSAFE.xaloc.cv.com/", "autenticaUsuarioWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEntidadLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEntidadLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlAut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xmlAut"));
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
