/**
 * CreationDocumentUUIDResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package alfresco.sigex.castellon;

public class CreationDocumentUUIDResponse  implements java.io.Serializable {
    private java.lang.String uuid;

    private alfresco.sigex.castellon.DocumentUuid[] arrayOfSigner;

    private alfresco.sigex.castellon.AlfrescoError[] errors;

    public CreationDocumentUUIDResponse() {
    }

    public CreationDocumentUUIDResponse(
           java.lang.String uuid,
           alfresco.sigex.castellon.DocumentUuid[] arrayOfSigner,
           alfresco.sigex.castellon.AlfrescoError[] errors) {
           this.uuid = uuid;
           this.arrayOfSigner = arrayOfSigner;
           this.errors = errors;
    }


    /**
     * Gets the uuid value for this CreationDocumentUUIDResponse.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this CreationDocumentUUIDResponse.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }


    /**
     * Gets the arrayOfSigner value for this CreationDocumentUUIDResponse.
     * 
     * @return arrayOfSigner
     */
    public alfresco.sigex.castellon.DocumentUuid[] getArrayOfSigner() {
        return arrayOfSigner;
    }


    /**
     * Sets the arrayOfSigner value for this CreationDocumentUUIDResponse.
     * 
     * @param arrayOfSigner
     */
    public void setArrayOfSigner(alfresco.sigex.castellon.DocumentUuid[] arrayOfSigner) {
        this.arrayOfSigner = arrayOfSigner;
    }

    public alfresco.sigex.castellon.DocumentUuid getArrayOfSigner(int i) {
        return this.arrayOfSigner[i];
    }

    public void setArrayOfSigner(int i, alfresco.sigex.castellon.DocumentUuid _value) {
        this.arrayOfSigner[i] = _value;
    }


    /**
     * Gets the errors value for this CreationDocumentUUIDResponse.
     * 
     * @return errors
     */
    public alfresco.sigex.castellon.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this CreationDocumentUUIDResponse.
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
        if (!(obj instanceof CreationDocumentUUIDResponse)) return false;
        CreationDocumentUUIDResponse other = (CreationDocumentUUIDResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid()))) &&
            ((this.arrayOfSigner==null && other.getArrayOfSigner()==null) || 
             (this.arrayOfSigner!=null &&
              java.util.Arrays.equals(this.arrayOfSigner, other.getArrayOfSigner()))) &&
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
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        if (getArrayOfSigner() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOfSigner());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOfSigner(), i);
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
        new org.apache.axis.description.TypeDesc(CreationDocumentUUIDResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfSigner");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
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
