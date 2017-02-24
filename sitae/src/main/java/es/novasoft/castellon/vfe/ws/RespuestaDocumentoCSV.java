/**
 * RespuestaDocumentoCSV.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.ws;

public class RespuestaDocumentoCSV  implements java.io.Serializable {
    private java.lang.String codigoERROR;

    private byte[] documento;

    private java.lang.String mensajeError;

    public RespuestaDocumentoCSV() {
    }

    public RespuestaDocumentoCSV(
           java.lang.String codigoERROR,
           byte[] documento,
           java.lang.String mensajeError) {
           this.codigoERROR = codigoERROR;
           this.documento = documento;
           this.mensajeError = mensajeError;
    }


    /**
     * Gets the codigoERROR value for this RespuestaDocumentoCSV.
     * 
     * @return codigoERROR
     */
    public java.lang.String getCodigoERROR() {
        return codigoERROR;
    }


    /**
     * Sets the codigoERROR value for this RespuestaDocumentoCSV.
     * 
     * @param codigoERROR
     */
    public void setCodigoERROR(java.lang.String codigoERROR) {
        this.codigoERROR = codigoERROR;
    }


    /**
     * Gets the documento value for this RespuestaDocumentoCSV.
     * 
     * @return documento
     */
    public byte[] getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this RespuestaDocumentoCSV.
     * 
     * @param documento
     */
    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }


    /**
     * Gets the mensajeError value for this RespuestaDocumentoCSV.
     * 
     * @return mensajeError
     */
    public java.lang.String getMensajeError() {
        return mensajeError;
    }


    /**
     * Sets the mensajeError value for this RespuestaDocumentoCSV.
     * 
     * @param mensajeError
     */
    public void setMensajeError(java.lang.String mensajeError) {
        this.mensajeError = mensajeError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaDocumentoCSV)) return false;
        RespuestaDocumentoCSV other = (RespuestaDocumentoCSV) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoERROR==null && other.getCodigoERROR()==null) || 
             (this.codigoERROR!=null &&
              this.codigoERROR.equals(other.getCodigoERROR()))) &&
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              java.util.Arrays.equals(this.documento, other.getDocumento()))) &&
            ((this.mensajeError==null && other.getMensajeError()==null) || 
             (this.mensajeError!=null &&
              this.mensajeError.equals(other.getMensajeError())));
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
        if (getCodigoERROR() != null) {
            _hashCode += getCodigoERROR().hashCode();
        }
        if (getDocumento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMensajeError() != null) {
            _hashCode += getMensajeError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaDocumentoCSV.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "RespuestaDocumentoCSV"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoERROR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "codigoERROR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajeError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "mensajeError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
