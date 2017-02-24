/**
 * AutenticaUsuarioLDAPWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.muleSAFE.interfaces;

public class AutenticaUsuarioLDAPWS  implements java.io.Serializable {
    private java.lang.String idEntidadLocal;

    private java.lang.String xmlAutLDAP;

    public AutenticaUsuarioLDAPWS() {
    }

    public AutenticaUsuarioLDAPWS(
           java.lang.String idEntidadLocal,
           java.lang.String xmlAutLDAP) {
           this.idEntidadLocal = idEntidadLocal;
           this.xmlAutLDAP = xmlAutLDAP;
    }


    /**
     * Gets the idEntidadLocal value for this AutenticaUsuarioLDAPWS.
     * 
     * @return idEntidadLocal
     */
    public java.lang.String getIdEntidadLocal() {
        return idEntidadLocal;
    }


    /**
     * Sets the idEntidadLocal value for this AutenticaUsuarioLDAPWS.
     * 
     * @param idEntidadLocal
     */
    public void setIdEntidadLocal(java.lang.String idEntidadLocal) {
        this.idEntidadLocal = idEntidadLocal;
    }


    /**
     * Gets the xmlAutLDAP value for this AutenticaUsuarioLDAPWS.
     * 
     * @return xmlAutLDAP
     */
    public java.lang.String getXmlAutLDAP() {
        return xmlAutLDAP;
    }


    /**
     * Sets the xmlAutLDAP value for this AutenticaUsuarioLDAPWS.
     * 
     * @param xmlAutLDAP
     */
    public void setXmlAutLDAP(java.lang.String xmlAutLDAP) {
        this.xmlAutLDAP = xmlAutLDAP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutenticaUsuarioLDAPWS)) return false;
        AutenticaUsuarioLDAPWS other = (AutenticaUsuarioLDAPWS) obj;
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
            ((this.xmlAutLDAP==null && other.getXmlAutLDAP()==null) || 
             (this.xmlAutLDAP!=null &&
              this.xmlAutLDAP.equals(other.getXmlAutLDAP())));
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
        if (getXmlAutLDAP() != null) {
            _hashCode += getXmlAutLDAP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutenticaUsuarioLDAPWS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://interfaces.muleSAFE.xaloc.cv.com/", "autenticaUsuarioLDAPWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEntidadLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEntidadLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlAutLDAP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xmlAutLDAP"));
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
