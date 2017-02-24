/**
 * PeticionRegistro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.ws;

public class PeticionRegistro  implements java.io.Serializable {
    private java.lang.String contrasenia;

    private java.lang.String csv;

    private java.lang.String idDocumento;

    private java.lang.String idFirma;

    private java.lang.String idMunicipio;

    private java.lang.String nombreDocumento;

    private java.lang.String nombreFirma;

    private java.lang.String tipoDocumento;

    private java.lang.String tipoFirma;

    private java.lang.String usuario;

    public PeticionRegistro() {
    }

    public PeticionRegistro(
           java.lang.String contrasenia,
           java.lang.String csv,
           java.lang.String idDocumento,
           java.lang.String idFirma,
           java.lang.String idMunicipio,
           java.lang.String nombreDocumento,
           java.lang.String nombreFirma,
           java.lang.String tipoDocumento,
           java.lang.String tipoFirma,
           java.lang.String usuario) {
           this.contrasenia = contrasenia;
           this.csv = csv;
           this.idDocumento = idDocumento;
           this.idFirma = idFirma;
           this.idMunicipio = idMunicipio;
           this.nombreDocumento = nombreDocumento;
           this.nombreFirma = nombreFirma;
           this.tipoDocumento = tipoDocumento;
           this.tipoFirma = tipoFirma;
           this.usuario = usuario;
    }


    /**
     * Gets the contrasenia value for this PeticionRegistro.
     * 
     * @return contrasenia
     */
    public java.lang.String getContrasenia() {
        return contrasenia;
    }


    /**
     * Sets the contrasenia value for this PeticionRegistro.
     * 
     * @param contrasenia
     */
    public void setContrasenia(java.lang.String contrasenia) {
        this.contrasenia = contrasenia;
    }


    /**
     * Gets the csv value for this PeticionRegistro.
     * 
     * @return csv
     */
    public java.lang.String getCsv() {
        return csv;
    }


    /**
     * Sets the csv value for this PeticionRegistro.
     * 
     * @param csv
     */
    public void setCsv(java.lang.String csv) {
        this.csv = csv;
    }


    /**
     * Gets the idDocumento value for this PeticionRegistro.
     * 
     * @return idDocumento
     */
    public java.lang.String getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this PeticionRegistro.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(java.lang.String idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the idFirma value for this PeticionRegistro.
     * 
     * @return idFirma
     */
    public java.lang.String getIdFirma() {
        return idFirma;
    }


    /**
     * Sets the idFirma value for this PeticionRegistro.
     * 
     * @param idFirma
     */
    public void setIdFirma(java.lang.String idFirma) {
        this.idFirma = idFirma;
    }


    /**
     * Gets the idMunicipio value for this PeticionRegistro.
     * 
     * @return idMunicipio
     */
    public java.lang.String getIdMunicipio() {
        return idMunicipio;
    }


    /**
     * Sets the idMunicipio value for this PeticionRegistro.
     * 
     * @param idMunicipio
     */
    public void setIdMunicipio(java.lang.String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }


    /**
     * Gets the nombreDocumento value for this PeticionRegistro.
     * 
     * @return nombreDocumento
     */
    public java.lang.String getNombreDocumento() {
        return nombreDocumento;
    }


    /**
     * Sets the nombreDocumento value for this PeticionRegistro.
     * 
     * @param nombreDocumento
     */
    public void setNombreDocumento(java.lang.String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }


    /**
     * Gets the nombreFirma value for this PeticionRegistro.
     * 
     * @return nombreFirma
     */
    public java.lang.String getNombreFirma() {
        return nombreFirma;
    }


    /**
     * Sets the nombreFirma value for this PeticionRegistro.
     * 
     * @param nombreFirma
     */
    public void setNombreFirma(java.lang.String nombreFirma) {
        this.nombreFirma = nombreFirma;
    }


    /**
     * Gets the tipoDocumento value for this PeticionRegistro.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this PeticionRegistro.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the tipoFirma value for this PeticionRegistro.
     * 
     * @return tipoFirma
     */
    public java.lang.String getTipoFirma() {
        return tipoFirma;
    }


    /**
     * Sets the tipoFirma value for this PeticionRegistro.
     * 
     * @param tipoFirma
     */
    public void setTipoFirma(java.lang.String tipoFirma) {
        this.tipoFirma = tipoFirma;
    }


    /**
     * Gets the usuario value for this PeticionRegistro.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this PeticionRegistro.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeticionRegistro)) return false;
        PeticionRegistro other = (PeticionRegistro) obj;
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
            ((this.idDocumento==null && other.getIdDocumento()==null) || 
             (this.idDocumento!=null &&
              this.idDocumento.equals(other.getIdDocumento()))) &&
            ((this.idFirma==null && other.getIdFirma()==null) || 
             (this.idFirma!=null &&
              this.idFirma.equals(other.getIdFirma()))) &&
            ((this.idMunicipio==null && other.getIdMunicipio()==null) || 
             (this.idMunicipio!=null &&
              this.idMunicipio.equals(other.getIdMunicipio()))) &&
            ((this.nombreDocumento==null && other.getNombreDocumento()==null) || 
             (this.nombreDocumento!=null &&
              this.nombreDocumento.equals(other.getNombreDocumento()))) &&
            ((this.nombreFirma==null && other.getNombreFirma()==null) || 
             (this.nombreFirma!=null &&
              this.nombreFirma.equals(other.getNombreFirma()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.tipoFirma==null && other.getTipoFirma()==null) || 
             (this.tipoFirma!=null &&
              this.tipoFirma.equals(other.getTipoFirma()))) &&
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
        if (getIdDocumento() != null) {
            _hashCode += getIdDocumento().hashCode();
        }
        if (getIdFirma() != null) {
            _hashCode += getIdFirma().hashCode();
        }
        if (getIdMunicipio() != null) {
            _hashCode += getIdMunicipio().hashCode();
        }
        if (getNombreDocumento() != null) {
            _hashCode += getNombreDocumento().hashCode();
        }
        if (getNombreFirma() != null) {
            _hashCode += getNombreFirma().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        if (getTipoFirma() != null) {
            _hashCode += getTipoFirma().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeticionRegistro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "PeticionRegistro"));
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
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "idDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFirma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "idFirma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMunicipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "idMunicipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "nombreDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFirma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "nombreFirma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "tipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoFirma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.vfe.castellon.novasoft.es", "tipoFirma"));
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
