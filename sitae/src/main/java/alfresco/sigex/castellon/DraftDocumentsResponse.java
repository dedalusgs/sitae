/**
 * DraftDocumentsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package alfresco.sigex.castellon;

public class DraftDocumentsResponse  implements java.io.Serializable {
    private alfresco.sigex.castellon.DocumentUuid[] arrayOfRequestDocuments;

    private alfresco.sigex.castellon.DocumentUuid[] arrayOfAssociatedDocuments;

    private alfresco.sigex.castellon.AlfrescoError[] errors;

    public DraftDocumentsResponse() {
    }

    public DraftDocumentsResponse(
           alfresco.sigex.castellon.DocumentUuid[] arrayOfRequestDocuments,
           alfresco.sigex.castellon.DocumentUuid[] arrayOfAssociatedDocuments,
           alfresco.sigex.castellon.AlfrescoError[] errors) {
           this.arrayOfRequestDocuments = arrayOfRequestDocuments;
           this.arrayOfAssociatedDocuments = arrayOfAssociatedDocuments;
           this.errors = errors;
    }


    /**
     * Gets the arrayOfRequestDocuments value for this DraftDocumentsResponse.
     * 
     * @return arrayOfRequestDocuments
     */
    public alfresco.sigex.castellon.DocumentUuid[] getArrayOfRequestDocuments() {
        return arrayOfRequestDocuments;
    }


    /**
     * Sets the arrayOfRequestDocuments value for this DraftDocumentsResponse.
     * 
     * @param arrayOfRequestDocuments
     */
    public void setArrayOfRequestDocuments(alfresco.sigex.castellon.DocumentUuid[] arrayOfRequestDocuments) {
        this.arrayOfRequestDocuments = arrayOfRequestDocuments;
    }

    public alfresco.sigex.castellon.DocumentUuid getArrayOfRequestDocuments(int i) {
        return this.arrayOfRequestDocuments[i];
    }

    public void setArrayOfRequestDocuments(int i, alfresco.sigex.castellon.DocumentUuid _value) {
        this.arrayOfRequestDocuments[i] = _value;
    }


    /**
     * Gets the arrayOfAssociatedDocuments value for this DraftDocumentsResponse.
     * 
     * @return arrayOfAssociatedDocuments
     */
    public alfresco.sigex.castellon.DocumentUuid[] getArrayOfAssociatedDocuments() {
        return arrayOfAssociatedDocuments;
    }


    /**
     * Sets the arrayOfAssociatedDocuments value for this DraftDocumentsResponse.
     * 
     * @param arrayOfAssociatedDocuments
     */
    public void setArrayOfAssociatedDocuments(alfresco.sigex.castellon.DocumentUuid[] arrayOfAssociatedDocuments) {
        this.arrayOfAssociatedDocuments = arrayOfAssociatedDocuments;
    }

    public alfresco.sigex.castellon.DocumentUuid getArrayOfAssociatedDocuments(int i) {
        return this.arrayOfAssociatedDocuments[i];
    }

    public void setArrayOfAssociatedDocuments(int i, alfresco.sigex.castellon.DocumentUuid _value) {
        this.arrayOfAssociatedDocuments[i] = _value;
    }


    /**
     * Gets the errors value for this DraftDocumentsResponse.
     * 
     * @return errors
     */
    public alfresco.sigex.castellon.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this DraftDocumentsResponse.
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
        if (!(obj instanceof DraftDocumentsResponse)) return false;
        DraftDocumentsResponse other = (DraftDocumentsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayOfRequestDocuments==null && other.getArrayOfRequestDocuments()==null) || 
             (this.arrayOfRequestDocuments!=null &&
              java.util.Arrays.equals(this.arrayOfRequestDocuments, other.getArrayOfRequestDocuments()))) &&
            ((this.arrayOfAssociatedDocuments==null && other.getArrayOfAssociatedDocuments()==null) || 
             (this.arrayOfAssociatedDocuments!=null &&
              java.util.Arrays.equals(this.arrayOfAssociatedDocuments, other.getArrayOfAssociatedDocuments()))) &&
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
        if (getArrayOfRequestDocuments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfRequestDocuments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfRequestDocuments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayOfAssociatedDocuments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfAssociatedDocuments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfAssociatedDocuments(), i);
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
        new org.apache.axis.description.TypeDesc(DraftDocumentsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DraftDocumentsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfRequestDocuments");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfRequestDocuments"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentUuid"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfAssociatedDocuments");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfAssociatedDocuments"));
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
