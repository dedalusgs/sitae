/**
 * Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.ws.sta;

public class Response  implements java.io.Serializable {
    private byte[] content;

    private es.novasoft.sitae.ws.sta.StampError[] stampError;

    public Response() {
    }

    public Response(
           byte[] content,
           es.novasoft.sitae.ws.sta.StampError[] stampError) {
           this.content = content;
           this.stampError = stampError;
    }


    /**
     * Gets the content value for this Response.
     * 
     * @return content
     */
    public byte[] getContent() {
        return content;
    }


    /**
     * Sets the content value for this Response.
     * 
     * @param content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }


    /**
     * Gets the stampError value for this Response.
     * 
     * @return stampError
     */
    public es.novasoft.sitae.ws.sta.StampError[] getStampError() {
        return stampError;
    }


    /**
     * Sets the stampError value for this Response.
     * 
     * @param stampError
     */
    public void setStampError(es.novasoft.sitae.ws.sta.StampError[] stampError) {
        this.stampError = stampError;
    }

    public es.novasoft.sitae.ws.sta.StampError getStampError(int i) {
        return this.stampError[i];
    }

    public void setStampError(int i, es.novasoft.sitae.ws.sta.StampError _value) {
        this.stampError[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Response)) return false;
        Response other = (Response) obj;
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
            ((this.stampError==null && other.getStampError()==null) || 
             (this.stampError!=null &&
              java.util.Arrays.equals(this.stampError, other.getStampError())));
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
        if (getStampError() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStampError());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStampError(), i);
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
        new org.apache.axis.description.TypeDesc(Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:es:castellon:sigex:stampservice:types:v1.0", ">Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:es:castellon:sigex:stampservice:types:v1.0", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stampError");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:es:castellon:sigex:stampservice:types:v1.0", "stampError"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:es:castellon:sigex:stampservice:types:v1.0", "StampError"));
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
