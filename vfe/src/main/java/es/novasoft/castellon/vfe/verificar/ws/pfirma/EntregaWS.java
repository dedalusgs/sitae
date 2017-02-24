/**
 * EntregaWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.pfirma;

public class EntregaWS  implements java.io.Serializable {
    private java.lang.String cESTADO;

    private java.lang.String cTRANSACTIONID;

    private java.lang.String dARCHIVO;

    private java.lang.String dESTCDNI;

    private java.lang.String dOCCHASH;

    private java.util.Calendar fESTADO;

    public EntregaWS() {
    }

    public EntregaWS(
           java.lang.String CESTADO,
           java.lang.String CTRANSACTIONID,
           java.lang.String DARCHIVO,
           java.lang.String DESTCDNI,
           java.lang.String DOCCHASH,
           java.util.Calendar FESTADO) {
           this.cESTADO = CESTADO;
           this.cTRANSACTIONID = CTRANSACTIONID;
           this.dARCHIVO = DARCHIVO;
           this.dESTCDNI = DESTCDNI;
           this.dOCCHASH = DOCCHASH;
           this.fESTADO = FESTADO;
    }


    /**
     * Gets the CESTADO value for this EntregaWS.
     * 
     * @return CESTADO
     */
    public java.lang.String getCESTADO() {
        return cESTADO;
    }


    /**
     * Sets the CESTADO value for this EntregaWS.
     * 
     * @param CESTADO
     */
    public void setCESTADO(java.lang.String CESTADO) {
        this.cESTADO = CESTADO;
    }


    /**
     * Gets the CTRANSACTIONID value for this EntregaWS.
     * 
     * @return CTRANSACTIONID
     */
    public java.lang.String getCTRANSACTIONID() {
        return cTRANSACTIONID;
    }


    /**
     * Sets the CTRANSACTIONID value for this EntregaWS.
     * 
     * @param CTRANSACTIONID
     */
    public void setCTRANSACTIONID(java.lang.String CTRANSACTIONID) {
        this.cTRANSACTIONID = CTRANSACTIONID;
    }


    /**
     * Gets the DARCHIVO value for this EntregaWS.
     * 
     * @return DARCHIVO
     */
    public java.lang.String getDARCHIVO() {
        return dARCHIVO;
    }


    /**
     * Sets the DARCHIVO value for this EntregaWS.
     * 
     * @param DARCHIVO
     */
    public void setDARCHIVO(java.lang.String DARCHIVO) {
        this.dARCHIVO = DARCHIVO;
    }


    /**
     * Gets the DESTCDNI value for this EntregaWS.
     * 
     * @return DESTCDNI
     */
    public java.lang.String getDESTCDNI() {
        return dESTCDNI;
    }


    /**
     * Sets the DESTCDNI value for this EntregaWS.
     * 
     * @param DESTCDNI
     */
    public void setDESTCDNI(java.lang.String DESTCDNI) {
        this.dESTCDNI = DESTCDNI;
    }


    /**
     * Gets the DOCCHASH value for this EntregaWS.
     * 
     * @return DOCCHASH
     */
    public java.lang.String getDOCCHASH() {
        return dOCCHASH;
    }


    /**
     * Sets the DOCCHASH value for this EntregaWS.
     * 
     * @param DOCCHASH
     */
    public void setDOCCHASH(java.lang.String DOCCHASH) {
        this.dOCCHASH = DOCCHASH;
    }


    /**
     * Gets the FESTADO value for this EntregaWS.
     * 
     * @return FESTADO
     */
    public java.util.Calendar getFESTADO() {
        return fESTADO;
    }


    /**
     * Sets the FESTADO value for this EntregaWS.
     * 
     * @param FESTADO
     */
    public void setFESTADO(java.util.Calendar FESTADO) {
        this.fESTADO = FESTADO;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntregaWS)) return false;
        EntregaWS other = (EntregaWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (equalsCalc != null) {
            return (equalsCalc == obj);
        }
        equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cESTADO==null && other.getCESTADO()==null) || 
             (this.cESTADO!=null &&
              this.cESTADO.equals(other.getCESTADO()))) &&
            ((this.cTRANSACTIONID==null && other.getCTRANSACTIONID()==null) || 
             (this.cTRANSACTIONID!=null &&
              this.cTRANSACTIONID.equals(other.getCTRANSACTIONID()))) &&
            ((this.dARCHIVO==null && other.getDARCHIVO()==null) || 
             (this.dARCHIVO!=null &&
              this.dARCHIVO.equals(other.getDARCHIVO()))) &&
            ((this.dESTCDNI==null && other.getDESTCDNI()==null) || 
             (this.dESTCDNI!=null &&
              this.dESTCDNI.equals(other.getDESTCDNI()))) &&
            ((this.dOCCHASH==null && other.getDOCCHASH()==null) || 
             (this.dOCCHASH!=null &&
              this.dOCCHASH.equals(other.getDOCCHASH()))) &&
            ((this.fESTADO==null && other.getFESTADO()==null) || 
             (this.fESTADO!=null &&
              this.fESTADO.equals(other.getFESTADO())));
        equalsCalc = null;
        return _equals;
    }

    private boolean hashCodeCalc = false;
    public synchronized int hashCode() {
        if (hashCodeCalc) {
            return 0;
        }
        hashCodeCalc = true;
        int _hashCode = 1;
        if (getCESTADO() != null) {
            _hashCode += getCESTADO().hashCode();
        }
        if (getCTRANSACTIONID() != null) {
            _hashCode += getCTRANSACTIONID().hashCode();
        }
        if (getDARCHIVO() != null) {
            _hashCode += getDARCHIVO().hashCode();
        }
        if (getDESTCDNI() != null) {
            _hashCode += getDESTCDNI().hashCode();
        }
        if (getDOCCHASH() != null) {
            _hashCode += getDOCCHASH().hashCode();
        }
        if (getFESTADO() != null) {
            _hashCode += getFESTADO().hashCode();
        }
        hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntregaWS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.pfirma", "EntregaWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CESTADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CESTADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CTRANSACTIONID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CTRANSACTIONID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DARCHIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DARCHIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESTCDNI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DESTCDNI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCCHASH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DOCCHASH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FESTADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FESTADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
