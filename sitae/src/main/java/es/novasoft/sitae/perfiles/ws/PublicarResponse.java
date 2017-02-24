/**
 * PublicarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class PublicarResponse  implements java.io.Serializable {
    private es.novasoft.sitae.perfiles.ws.RespuestaSolicitudPubli respuestaSolicitudPubli;

    private es.novasoft.sitae.perfiles.ws.TypeError[] instanciaSolicitud;

    public PublicarResponse() {
    }

    public PublicarResponse(
           es.novasoft.sitae.perfiles.ws.RespuestaSolicitudPubli respuestaSolicitudPubli,
           es.novasoft.sitae.perfiles.ws.TypeError[] instanciaSolicitud) {
           this.respuestaSolicitudPubli = respuestaSolicitudPubli;
           this.instanciaSolicitud = instanciaSolicitud;
    }


    /**
     * Gets the respuestaSolicitudPubli value for this PublicarResponse.
     * 
     * @return respuestaSolicitudPubli
     */
    public es.novasoft.sitae.perfiles.ws.RespuestaSolicitudPubli getRespuestaSolicitudPubli() {
        return respuestaSolicitudPubli;
    }


    /**
     * Sets the respuestaSolicitudPubli value for this PublicarResponse.
     * 
     * @param respuestaSolicitudPubli
     */
    public void setRespuestaSolicitudPubli(es.novasoft.sitae.perfiles.ws.RespuestaSolicitudPubli respuestaSolicitudPubli) {
        this.respuestaSolicitudPubli = respuestaSolicitudPubli;
    }


    /**
     * Gets the instanciaSolicitud value for this PublicarResponse.
     * 
     * @return instanciaSolicitud
     */
    public es.novasoft.sitae.perfiles.ws.TypeError[] getInstanciaSolicitud() {
        return instanciaSolicitud;
    }


    /**
     * Sets the instanciaSolicitud value for this PublicarResponse.
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
            ((this.respuestaSolicitudPubli==null && other.getRespuestaSolicitudPubli()==null) || 
             (this.respuestaSolicitudPubli!=null &&
              this.respuestaSolicitudPubli.equals(other.getRespuestaSolicitudPubli()))) &&
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
        if (getRespuestaSolicitudPubli() != null) {
            _hashCode += getRespuestaSolicitudPubli().hashCode();
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">publicarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaSolicitudPubli");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuestaSolicitudPubli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "respuestaSolicitudPubli"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanciaSolicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instanciaSolicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "typeError"));
        elemField.setMinOccurs(0);
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
