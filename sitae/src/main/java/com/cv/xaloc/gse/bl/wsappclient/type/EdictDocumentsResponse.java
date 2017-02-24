/**
 * EdictDocumentsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.gse.bl.wsappclient.type;

public class EdictDocumentsResponse  implements java.io.Serializable {
    private com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument[] arrayOfDocuments;

    private com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors;

    public EdictDocumentsResponse() {
    }

    public EdictDocumentsResponse(
           com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument[] arrayOfDocuments,
           com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors) {
           this.arrayOfDocuments = arrayOfDocuments;
           this.errors = errors;
    }


    /**
     * Gets the arrayOfDocuments value for this EdictDocumentsResponse.
     * 
     * @return arrayOfDocuments
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument[] getArrayOfDocuments() {
        return arrayOfDocuments;
    }


    /**
     * Sets the arrayOfDocuments value for this EdictDocumentsResponse.
     * 
     * @param arrayOfDocuments
     */
    public void setArrayOfDocuments(com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument[] arrayOfDocuments) {
        this.arrayOfDocuments = arrayOfDocuments;
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument getArrayOfDocuments(int i) {
        return this.arrayOfDocuments[i];
    }

    public void setArrayOfDocuments(int i, com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument _value) {
        this.arrayOfDocuments[i] = _value;
    }


    /**
     * Gets the errors value for this EdictDocumentsResponse.
     * 
     * @return errors
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this EdictDocumentsResponse.
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
        if (!(obj instanceof EdictDocumentsResponse)) return false;
        EdictDocumentsResponse other = (EdictDocumentsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayOfDocuments==null && other.getArrayOfDocuments()==null) || 
             (this.arrayOfDocuments!=null &&
              java.util.Arrays.equals(this.arrayOfDocuments, other.getArrayOfDocuments()))) &&
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
        if (getArrayOfDocuments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfDocuments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfDocuments(), i);
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
        new org.apache.axis.description.TypeDesc(EdictDocumentsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">EdictDocumentsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfDocuments");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfDocuments"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "EdictDocument"));
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
