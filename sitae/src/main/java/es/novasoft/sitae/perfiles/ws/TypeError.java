/**
 * TypeError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class TypeError  implements java.io.Serializable {
    private java.lang.String COD_ERROR;

    private java.lang.String DESCRIPCION_ES;

    private java.lang.String DESCRIPCION_VA;

    public TypeError() {
    }

    public TypeError(
           java.lang.String COD_ERROR,
           java.lang.String DESCRIPCION_ES,
           java.lang.String DESCRIPCION_VA) {
           this.COD_ERROR = COD_ERROR;
           this.DESCRIPCION_ES = DESCRIPCION_ES;
           this.DESCRIPCION_VA = DESCRIPCION_VA;
    }


    /**
     * Gets the COD_ERROR value for this TypeError.
     * 
     * @return COD_ERROR
     */
    public java.lang.String getCOD_ERROR() {
        return COD_ERROR;
    }


    /**
     * Sets the COD_ERROR value for this TypeError.
     * 
     * @param COD_ERROR
     */
    public void setCOD_ERROR(java.lang.String COD_ERROR) {
        this.COD_ERROR = COD_ERROR;
    }


    /**
     * Gets the DESCRIPCION_ES value for this TypeError.
     * 
     * @return DESCRIPCION_ES
     */
    public java.lang.String getDESCRIPCION_ES() {
        return DESCRIPCION_ES;
    }


    /**
     * Sets the DESCRIPCION_ES value for this TypeError.
     * 
     * @param DESCRIPCION_ES
     */
    public void setDESCRIPCION_ES(java.lang.String DESCRIPCION_ES) {
        this.DESCRIPCION_ES = DESCRIPCION_ES;
    }


    /**
     * Gets the DESCRIPCION_VA value for this TypeError.
     * 
     * @return DESCRIPCION_VA
     */
    public java.lang.String getDESCRIPCION_VA() {
        return DESCRIPCION_VA;
    }


    /**
     * Sets the DESCRIPCION_VA value for this TypeError.
     * 
     * @param DESCRIPCION_VA
     */
    public void setDESCRIPCION_VA(java.lang.String DESCRIPCION_VA) {
        this.DESCRIPCION_VA = DESCRIPCION_VA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TypeError)) return false;
        TypeError other = (TypeError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.COD_ERROR==null && other.getCOD_ERROR()==null) || 
             (this.COD_ERROR!=null &&
              this.COD_ERROR.equals(other.getCOD_ERROR()))) &&
            ((this.DESCRIPCION_ES==null && other.getDESCRIPCION_ES()==null) || 
             (this.DESCRIPCION_ES!=null &&
              this.DESCRIPCION_ES.equals(other.getDESCRIPCION_ES()))) &&
            ((this.DESCRIPCION_VA==null && other.getDESCRIPCION_VA()==null) || 
             (this.DESCRIPCION_VA!=null &&
              this.DESCRIPCION_VA.equals(other.getDESCRIPCION_VA())));
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
        if (getCOD_ERROR() != null) {
            _hashCode += getCOD_ERROR().hashCode();
        }
        if (getDESCRIPCION_ES() != null) {
            _hashCode += getDESCRIPCION_ES().hashCode();
        }
        if (getDESCRIPCION_VA() != null) {
            _hashCode += getDESCRIPCION_VA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "typeError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COD_ERROR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COD_ERROR"));
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
