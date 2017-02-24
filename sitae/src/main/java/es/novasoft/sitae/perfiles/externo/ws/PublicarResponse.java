/**
 * PublicarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.externo.ws;

public class PublicarResponse  implements java.io.Serializable {
    private java.lang.String[] idAnuncio;

    private es.novasoft.sitae.perfiles.externo.ws.TypeError[] instanciaSolicitud;

    public PublicarResponse() {
    }

    public PublicarResponse(
           java.lang.String[] idAnuncio,
           es.novasoft.sitae.perfiles.externo.ws.TypeError[] instanciaSolicitud) {
           this.idAnuncio = idAnuncio;
           this.instanciaSolicitud = instanciaSolicitud;
    }


    /**
     * Gets the idAnuncio value for this PublicarResponse.
     * 
     * @return idAnuncio
     */
    public java.lang.String[] getIdAnuncio() {
        return idAnuncio;
    }


    /**
     * Sets the idAnuncio value for this PublicarResponse.
     * 
     * @param idAnuncio
     */
    public void setIdAnuncio(java.lang.String[] idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public java.lang.String getIdAnuncio(int i) {
        return this.idAnuncio[i];
    }

    public void setIdAnuncio(int i, java.lang.String _value) {
        this.idAnuncio[i] = _value;
    }


    /**
     * Gets the instanciaSolicitud value for this PublicarResponse.
     * 
     * @return instanciaSolicitud
     */
    public es.novasoft.sitae.perfiles.externo.ws.TypeError[] getInstanciaSolicitud() {
        return instanciaSolicitud;
    }


    /**
     * Sets the instanciaSolicitud value for this PublicarResponse.
     * 
     * @param instanciaSolicitud
     */
    public void setInstanciaSolicitud(es.novasoft.sitae.perfiles.externo.ws.TypeError[] instanciaSolicitud) {
        this.instanciaSolicitud = instanciaSolicitud;
    }

    public es.novasoft.sitae.perfiles.externo.ws.TypeError getInstanciaSolicitud(int i) {
        return this.instanciaSolicitud[i];
    }

    public void setInstanciaSolicitud(int i, es.novasoft.sitae.perfiles.externo.ws.TypeError _value) {
        this.instanciaSolicitud[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PublicarResponse)) return false;
        PublicarResponse other = (PublicarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idAnuncio==null && other.getIdAnuncio()==null) || 
             (this.idAnuncio!=null &&
              java.util.Arrays.equals(this.idAnuncio, other.getIdAnuncio()))) &&
            ((this.instanciaSolicitud==null && other.getInstanciaSolicitud()==null) || 
             (this.instanciaSolicitud!=null &&
              java.util.Arrays.equals(this.instanciaSolicitud, other.getInstanciaSolicitud())));
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
        if (getIdAnuncio() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdAnuncio());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdAnuncio(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInstanciaSolicitud() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInstanciaSolicitud());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInstanciaSolicitud(), i);
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
        new org.apache.axis.description.TypeDesc(PublicarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ttdev.com/ss", ">publicarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAnuncio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAnuncio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanciaSolicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instanciaSolicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ttdev.com/ss", "typeError"));
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
