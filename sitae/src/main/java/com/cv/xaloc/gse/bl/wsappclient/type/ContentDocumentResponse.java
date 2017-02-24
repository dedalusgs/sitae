/**
 * ContentDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.gse.bl.wsappclient.type;

public class ContentDocumentResponse  implements java.io.Serializable {
    private byte[] content;

    private java.lang.String name;

    private java.lang.String mimeType;

    private com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner;

    private com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors;

    public ContentDocumentResponse() {
    }

    public ContentDocumentResponse(
           byte[] content,
           java.lang.String name,
           java.lang.String mimeType,
           com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner,
           com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] errors) {
           this.content = content;
           this.name = name;
           this.mimeType = mimeType;
           this.arrayOfSigner = arrayOfSigner;
           this.errors = errors;
    }


    /**
     * Gets the content value for this ContentDocumentResponse.
     * 
     * @return content
     */
    public byte[] getContent() {
        return content;
    }


    /**
     * Sets the content value for this ContentDocumentResponse.
     * 
     * @param content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }


    /**
     * Gets the name value for this ContentDocumentResponse.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ContentDocumentResponse.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the mimeType value for this ContentDocumentResponse.
     * 
     * @return mimeType
     */
    public java.lang.String getMimeType() {
        return mimeType;
    }


    /**
     * Sets the mimeType value for this ContentDocumentResponse.
     * 
     * @param mimeType
     */
    public void setMimeType(java.lang.String mimeType) {
        this.mimeType = mimeType;
    }


    /**
     * Gets the arrayOfSigner value for this ContentDocumentResponse.
     * 
     * @return arrayOfSigner
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.Signer[] getArrayOfSigner() {
        return arrayOfSigner;
    }


    /**
     * Sets the arrayOfSigner value for this ContentDocumentResponse.
     * 
     * @param arrayOfSigner
     */
    public void setArrayOfSigner(com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) {
        this.arrayOfSigner = arrayOfSigner;
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.Signer getArrayOfSigner(int i) {
        return this.arrayOfSigner[i];
    }

    public void setArrayOfSigner(int i, com.cv.xaloc.gse.bl.wsappclient.type.Signer _value) {
        this.arrayOfSigner[i] = _value;
    }


    /**
     * Gets the errors value for this ContentDocumentResponse.
     * 
     * @return errors
     */
    public com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this ContentDocumentResponse.
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
        if (!(obj instanceof ContentDocumentResponse)) return false;
        ContentDocumentResponse other = (ContentDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              java.util.Arrays.equals(this.content, other.getContent()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.mimeType==null && other.getMimeType()==null) || 
             (this.mimeType!=null &&
              this.mimeType.equals(other.getMimeType()))) &&
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
        if (getContent() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContent());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContent(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getMimeType() != null) {
            _hashCode += getMimeType().hashCode();
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
        new org.apache.axis.description.TypeDesc(ContentDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mimeType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "mimeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOfSigner");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "Signer"));
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
