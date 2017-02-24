/**
 * PeticionDocumentoCSV.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.ws;

public class PeticionDocumentoCSV  implements java.io.Serializable {
    private java.lang.String contrasenia;

    private java.lang.String csv;

    private java.lang.String idAyto;

    private java.lang.String idDocumento;

    private java.lang.String usuario;

    public PeticionDocumentoCSV() {
    }

    public PeticionDocumentoCSV(
           java.lang.String contrasenia,
           java.lang.String csv,
           java.lang.String idAyto,
           java.lang.String idDocumento,
           java.lang.String usuario) {
           this.contrasenia = contrasenia;
           this.csv = csv;
           this.idAyto = idAyto;
           this.idDocumento = idDocumento;
           this.usuario = usuario;
    }


    /**
     * Gets the contrasenia value for this PeticionDocumentoCSV.
     * 
     * @return contrasenia
     */
    public java.lang.String getContrasenia() {
        return contrasenia;
    }


    /**
     * Sets the contrasenia value for this PeticionDocumentoCSV.
     * 
     * @param contrasenia
     */
    public void setContrasenia(java.lang.String contrasenia) {
        this.contrasenia = contrasenia;
    }


    /**
     * Gets the csv value for this PeticionDocumentoCSV.
     * 
     * @return csv
     */
    public java.lang.String getCsv() {
        return csv;
    }


    /**
     * Sets the csv value for this PeticionDocumentoCSV.
     * 
     * @param csv
     */
    public void setCsv(java.lang.String csv) {
        this.csv = csv;
    }


    /**
     * Gets the idAyto value for this PeticionDocumentoCSV.
     * 
     * @return idAyto
     */
    public java.lang.String getIdAyto() {
        return idAyto;
    }


    /**
     * Sets the idAyto value for this PeticionDocumentoCSV.
     * 
     * @param idAyto
     */
    public void setIdAyto(java.lang.String idAyto) {
        this.idAyto = idAyto;
    }


    /**
     * Gets the idDocumento value for this PeticionDocumentoCSV.
     * 
     * @return idDocumento
     */
    public java.lang.String getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this PeticionDocumentoCSV.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(java.lang.String idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the usuario value for this PeticionDocumentoCSV.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this PeticionDocumentoCSV.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeticionDocumentoCSV)) return false;
        PeticionDocumentoCSV other = (PeticionDocumentoCSV) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contrasenia==null && other.getContrasenia()==null) || 
             (this.contrasenia!=null &&
              this.contrasenia.equals(other.getContrasenia()))) &&
            ((this.csv==null && other.getCsv()==null) || 
             (this.csv!=null &&
              this.csv.equals(other.getCsv()))) &&
            ((this.idAyto==null && other.getIdAyto()==null) || 
             (this.idAyto!=null &&
              this.idAyto.equals(other.getIdAyto()))) &&
            ((this.idDocumento==null && other.getIdDocumento()==null) || 
             (this.idDocumento!=null &&
              this.idDocumento.equals(other.getIdDocumento()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
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
        if (getContrasenia() != null) {
            _hashCode += getContrasenia().hashCode();
        }
        if (getCsv() != null) {
            _hashCode += getCsv().hashCode();
        }
        if (getIdAyto() != null) {
            _hashCode += getIdAyto().hashCode();
        }
        if (getIdDocumento() != null) {
            _hashCode += getIdDocumento().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeticionDocumentoCSV.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "PeticionDocumentoCSV"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrasenia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "contrasenia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "csv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAyto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "idAyto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "idDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "usuario"));
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
