/**
 * MetadataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.gse.bl.wsappclient.type;

public class MetadataResponse  implements java.io.Serializable {
    private com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata;

    private com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors;

    public MetadataResponse() {
    }

    public MetadataResponse(
           com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata,
           com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors) {
           this.arrayOfMetadata = arrayOfMetadata;
           this.errors = errors;
    }


    /**
     * Gets the arrayOfMetadata value for this MetadataResponse.
     * 
     * @return arrayOfMetadata
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] getArrayOfMetadata() {
        return arrayOfMetadata;
    }


    /**
     * Sets the arrayOfMetadata value for this MetadataResponse.
     * 
     * @param arrayOfMetadata
     */
    public void setArrayOfMetadata(com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata) {
        this.arrayOfMetadata = arrayOfMetadata;
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.Metadata getArrayOfMetadata(int i) {
        return this.arrayOfMetadata[i];
    }

    public void setArrayOfMetadata(int i, com.cv.xaloc.gse.bl.wsappclient.type.Metadata _value) {
        this.arrayOfMetadata[i] = _value;
    }


    /**
     * Gets the errors value for this MetadataResponse.
     * 
     * @return errors
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this MetadataResponse.
     * 
     * @param errors
     */
    public void setErrors(com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors) {
        this.errors = errors;
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError getErrors(int i) {
        return this.errors[i];
    }

    public void setErrors(int i, com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError _value) {
        this.errors[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetadataResponse)) return false;
        MetadataResponse other = (MetadataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayOfMetadata==null && other.getArrayOfMetadata()==null) || 
             (this.arrayOfMetadata!=null &&
              java.util.Arrays.equals(this.arrayOfMetadata, other.getArrayOfMetadata()))) &&
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
        if (getArrayOfMetadata() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfMetadata());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfMetadata(), i);
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
        new org.apache.axis.description.TypeDesc(MetadataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">MetadataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfMetadata");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfMetadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "Metadata"));
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
