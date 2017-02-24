/**
 * FilterResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.gse.bl.wsappclient.type;

public class FilterResponse  implements java.io.Serializable {
    private com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[] arrayOfUuid;

    private com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors;

    public FilterResponse() {
    }

    public FilterResponse(
           com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[] arrayOfUuid,
           com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors) {
           this.arrayOfUuid = arrayOfUuid;
           this.errors = errors;
    }


    /**
     * Gets the arrayOfUuid value for this FilterResponse.
     * 
     * @return arrayOfUuid
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[] getArrayOfUuid() {
        return arrayOfUuid;
    }


    /**
     * Sets the arrayOfUuid value for this FilterResponse.
     * 
     * @param arrayOfUuid
     */
    public void setArrayOfUuid(com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[] arrayOfUuid) {
        this.arrayOfUuid = arrayOfUuid;
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid getArrayOfUuid(int i) {
        return this.arrayOfUuid[i];
    }

    public void setArrayOfUuid(int i, com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid _value) {
        this.arrayOfUuid[i] = _value;
    }


    /**
     * Gets the errors value for this FilterResponse.
     * 
     * @return errors
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this FilterResponse.
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
        if (!(obj instanceof FilterResponse)) return false;
        FilterResponse other = (FilterResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayOfUuid==null && other.getArrayOfUuid()==null) || 
             (this.arrayOfUuid!=null &&
              java.util.Arrays.equals(this.arrayOfUuid, other.getArrayOfUuid()))) &&
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
        if (getArrayOfUuid() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfUuid());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfUuid(), i);
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
        new org.apache.axis.description.TypeDesc(FilterResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">FilterResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfUuid");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfUuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentUuid"));
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
