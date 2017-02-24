/**
 * ArrayOfDocumentVersion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package alfresco.sigex.castellon;

public class ArrayOfDocumentVersion  implements java.io.Serializable {
    private alfresco.sigex.castellon.DocumentVersion[] arrayOfDocumentVersion;

    private alfresco.sigex.castellon.AlfrescoError[] errors;

    public ArrayOfDocumentVersion() {
    }

    public ArrayOfDocumentVersion(
           alfresco.sigex.castellon.DocumentVersion[] arrayOfDocumentVersion,
           alfresco.sigex.castellon.AlfrescoError[] errors) {
           this.arrayOfDocumentVersion = arrayOfDocumentVersion;
           this.errors = errors;
    }


    /**
     * Gets the arrayOfDocumentVersion value for this ArrayOfDocumentVersion.
     * 
     * @return arrayOfDocumentVersion
     */
    public alfresco.sigex.castellon.DocumentVersion[] getArrayOfDocumentVersion() {
        return arrayOfDocumentVersion;
    }


    /**
     * Sets the arrayOfDocumentVersion value for this ArrayOfDocumentVersion.
     * 
     * @param arrayOfDocumentVersion
     */
    public void setArrayOfDocumentVersion(alfresco.sigex.castellon.DocumentVersion[] arrayOfDocumentVersion) {
        this.arrayOfDocumentVersion = arrayOfDocumentVersion;
    }

    public alfresco.sigex.castellon.DocumentVersion getArrayOfDocumentVersion(int i) {
        return this.arrayOfDocumentVersion[i];
    }

    public void setArrayOfDocumentVersion(int i, alfresco.sigex.castellon.DocumentVersion _value) {
        this.arrayOfDocumentVersion[i] = _value;
    }


    /**
     * Gets the errors value for this ArrayOfDocumentVersion.
     * 
     * @return errors
     */
    public alfresco.sigex.castellon.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this ArrayOfDocumentVersion.
     * 
     * @param errors
     */
    public void setErrors(alfresco.sigex.castellon.AlfrescoError[] errors) {
        this.errors = errors;
    }

    public alfresco.sigex.castellon.AlfrescoError getErrors(int i) {
        return this.errors[i];
    }

    public void setErrors(int i, alfresco.sigex.castellon.AlfrescoError _value) {
        this.errors[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDocumentVersion)) return false;
        ArrayOfDocumentVersion other = (ArrayOfDocumentVersion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayOfDocumentVersion==null && other.getArrayOfDocumentVersion()==null) || 
             (this.arrayOfDocumentVersion!=null &&
              java.util.Arrays.equals(this.arrayOfDocumentVersion, other.getArrayOfDocumentVersion()))) &&
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              java.util.Arrays.equals(this.errors, other.getErrors())));
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
        if (getArrayOfDocumentVersion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfDocumentVersion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfDocumentVersion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfDocumentVersion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfDocumentVersion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfDocumentVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfDocumentVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentVersion"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AlfrescoError"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
