/**
 * CancelarSolicitudPublicacionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class CancelarSolicitudPublicacionResponse  implements java.io.Serializable {
    private java.lang.String correcto;

    private es.novasoft.sitae.perfiles.ws.TypeError[] instanciaSolicitud;

    public CancelarSolicitudPublicacionResponse() {
    }

    public CancelarSolicitudPublicacionResponse(
           java.lang.String correcto,
           es.novasoft.sitae.perfiles.ws.TypeError[] instanciaSolicitud) {
           this.correcto = correcto;
           this.instanciaSolicitud = instanciaSolicitud;
    }


    /**
     * Gets the correcto value for this CancelarSolicitudPublicacionResponse.
     * 
     * @return correcto
     */
    public java.lang.String getCorrecto() {
        return correcto;
    }


    /**
     * Sets the correcto value for this CancelarSolicitudPublicacionResponse.
     * 
     * @param correcto
     */
    public void setCorrecto(java.lang.String correcto) {
        this.correcto = correcto;
    }


    /**
     * Gets the instanciaSolicitud value for this CancelarSolicitudPublicacionResponse.
     * 
     * @return instanciaSolicitud
     */
    public es.novasoft.sitae.perfiles.ws.TypeError[] getInstanciaSolicitud() {
        return instanciaSolicitud;
    }


    /**
     * Sets the instanciaSolicitud value for this CancelarSolicitudPublicacionResponse.
     * 
     * @param instanciaSolicitud
     */
    public void setInstanciaSolicitud(es.novasoft.sitae.perfiles.ws.TypeError[] instanciaSolicitud) {
        this.instanciaSolicitud = instanciaSolicitud;
    }

    public es.novasoft.sitae.perfiles.ws.TypeError getInstanciaSolicitud(int i) {
        return this.instanciaSolicitud[i];
    }

    public void setInstanciaSolicitud(int i, es.novasoft.sitae.perfiles.ws.TypeError _value) {
        this.instanciaSolicitud[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelarSolicitudPublicacionResponse)) return false;
        CancelarSolicitudPublicacionResponse other = (CancelarSolicitudPublicacionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.correcto==null && other.getCorrecto()==null) || 
             (this.correcto!=null &&
              this.correcto.equals(other.getCorrecto()))) &&
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
        if (getCorrecto() != null) {
            _hashCode += getCorrecto().hashCode();
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
        new org.apache.axis.description.TypeDesc(CancelarSolicitudPublicacionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">cancelarSolicitudPublicacionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correcto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correcto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanciaSolicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instanciaSolicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "typeError"));
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
