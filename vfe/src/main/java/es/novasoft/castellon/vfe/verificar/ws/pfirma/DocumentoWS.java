/**
 * DocumentoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.pfirma;

public class DocumentoWS  implements java.io.Serializable {
    private java.lang.String cHASH;

    private java.lang.String dARCHIVO;

    private java.lang.String dMIME;

    private java.util.Calendar fCREACION;

    private java.util.Calendar fMODIFICACION;

    private java.math.BigDecimal nTAMANIO;

    private java.lang.String pETCHASH;

    private java.lang.String tDOCCTIPODOCUMENTO;

    public DocumentoWS() {
    }

    public DocumentoWS(
           java.lang.String CHASH,
           java.lang.String DARCHIVO,
           java.lang.String DMIME,
           java.util.Calendar FCREACION,
           java.util.Calendar FMODIFICACION,
           java.math.BigDecimal NTAMANIO,
           java.lang.String PETCHASH,
           java.lang.String TDOCCTIPODOCUMENTO) {
           this.cHASH = CHASH;
           this.dARCHIVO = DARCHIVO;
           this.dMIME = DMIME;
           this.fCREACION = FCREACION;
           this.fMODIFICACION = FMODIFICACION;
           this.nTAMANIO = NTAMANIO;
           this.pETCHASH = PETCHASH;
           this.tDOCCTIPODOCUMENTO = TDOCCTIPODOCUMENTO;
    }


    /**
     * Gets the CHASH value for this DocumentoWS.
     * 
     * @return CHASH
     */
    public java.lang.String getCHASH() {
        return cHASH;
    }


    /**
     * Sets the CHASH value for this DocumentoWS.
     * 
     * @param CHASH
     */
    public void setCHASH(java.lang.String CHASH) {
        this.cHASH = CHASH;
    }


    /**
     * Gets the DARCHIVO value for this DocumentoWS.
     * 
     * @return DARCHIVO
     */
    public java.lang.String getDARCHIVO() {
        return dARCHIVO;
    }


    /**
     * Sets the DARCHIVO value for this DocumentoWS.
     * 
     * @param DARCHIVO
     */
    public void setDARCHIVO(java.lang.String DARCHIVO) {
        this.dARCHIVO = DARCHIVO;
    }


    /**
     * Gets the DMIME value for this DocumentoWS.
     * 
     * @return DMIME
     */
    public java.lang.String getDMIME() {
        return dMIME;
    }


    /**
     * Sets the DMIME value for this DocumentoWS.
     * 
     * @param DMIME
     */
    public void setDMIME(java.lang.String DMIME) {
        this.dMIME = DMIME;
    }


    /**
     * Gets the FCREACION value for this DocumentoWS.
     * 
     * @return FCREACION
     */
    public java.util.Calendar getFCREACION() {
        return fCREACION;
    }


    /**
     * Sets the FCREACION value for this DocumentoWS.
     * 
     * @param FCREACION
     */
    public void setFCREACION(java.util.Calendar FCREACION) {
        this.fCREACION = FCREACION;
    }


    /**
     * Gets the FMODIFICACION value for this DocumentoWS.
     * 
     * @return FMODIFICACION
     */
    public java.util.Calendar getFMODIFICACION() {
        return fMODIFICACION;
    }


    /**
     * Sets the FMODIFICACION value for this DocumentoWS.
     * 
     * @param FMODIFICACION
     */
    public void setFMODIFICACION(java.util.Calendar FMODIFICACION) {
        this.fMODIFICACION = FMODIFICACION;
    }


    /**
     * Gets the NTAMANIO value for this DocumentoWS.
     * 
     * @return NTAMANIO
     */
    public java.math.BigDecimal getNTAMANIO() {
        return nTAMANIO;
    }


    /**
     * Sets the NTAMANIO value for this DocumentoWS.
     * 
     * @param NTAMANIO
     */
    public void setNTAMANIO(java.math.BigDecimal NTAMANIO) {
        this.nTAMANIO = NTAMANIO;
    }


    /**
     * Gets the PETCHASH value for this DocumentoWS.
     * 
     * @return PETCHASH
     */
    public java.lang.String getPETCHASH() {
        return pETCHASH;
    }


    /**
     * Sets the PETCHASH value for this DocumentoWS.
     * 
     * @param PETCHASH
     */
    public void setPETCHASH(java.lang.String PETCHASH) {
        this.pETCHASH = PETCHASH;
    }


    /**
     * Gets the TDOCCTIPODOCUMENTO value for this DocumentoWS.
     * 
     * @return TDOCCTIPODOCUMENTO
     */
    public java.lang.String getTDOCCTIPODOCUMENTO() {
        return tDOCCTIPODOCUMENTO;
    }


    /**
     * Sets the TDOCCTIPODOCUMENTO value for this DocumentoWS.
     * 
     * @param TDOCCTIPODOCUMENTO
     */
    public void setTDOCCTIPODOCUMENTO(java.lang.String TDOCCTIPODOCUMENTO) {
        this.tDOCCTIPODOCUMENTO = TDOCCTIPODOCUMENTO;
    }

    private java.lang.Object equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoWS)) return false;
        DocumentoWS other = (DocumentoWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (equalsCalc != null) {
            return (equalsCalc == obj);
        }
        equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cHASH==null && other.getCHASH()==null) || 
             (this.cHASH!=null &&
              this.cHASH.equals(other.getCHASH()))) &&
            ((this.dARCHIVO==null && other.getDARCHIVO()==null) || 
             (this.dARCHIVO!=null &&
              this.dARCHIVO.equals(other.getDARCHIVO()))) &&
            ((this.dMIME==null && other.getDMIME()==null) || 
             (this.dMIME!=null &&
              this.dMIME.equals(other.getDMIME()))) &&
            ((this.fCREACION==null && other.getFCREACION()==null) || 
             (this.fCREACION!=null &&
              this.fCREACION.equals(other.getFCREACION()))) &&
            ((this.fMODIFICACION==null && other.getFMODIFICACION()==null) || 
             (this.fMODIFICACION!=null &&
              this.fMODIFICACION.equals(other.getFMODIFICACION()))) &&
            ((this.nTAMANIO==null && other.getNTAMANIO()==null) || 
             (this.nTAMANIO!=null &&
              this.nTAMANIO.equals(other.getNTAMANIO()))) &&
            ((this.pETCHASH==null && other.getPETCHASH()==null) || 
             (this.pETCHASH!=null &&
              this.pETCHASH.equals(other.getPETCHASH()))) &&
            ((this.tDOCCTIPODOCUMENTO==null && other.getTDOCCTIPODOCUMENTO()==null) || 
             (this.tDOCCTIPODOCUMENTO!=null &&
              this.tDOCCTIPODOCUMENTO.equals(other.getTDOCCTIPODOCUMENTO())));
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
        if (getCHASH() != null) {
            _hashCode += getCHASH().hashCode();
        }
        if (getDARCHIVO() != null) {
            _hashCode += getDARCHIVO().hashCode();
        }
        if (getDMIME() != null) {
            _hashCode += getDMIME().hashCode();
        }
        if (getFCREACION() != null) {
            _hashCode += getFCREACION().hashCode();
        }
        if (getFMODIFICACION() != null) {
            _hashCode += getFMODIFICACION().hashCode();
        }
        if (getNTAMANIO() != null) {
            _hashCode += getNTAMANIO().hashCode();
        }
        if (getPETCHASH() != null) {
            _hashCode += getPETCHASH().hashCode();
        }
        if (getTDOCCTIPODOCUMENTO() != null) {
            _hashCode += getTDOCCTIPODOCUMENTO().hashCode();
        }
        hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoWS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.pfirma", "DocumentoWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CHASH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CHASH"));
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
        elemField.setFieldName("DMIME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DMIME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FCREACION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FCREACION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FMODIFICACION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FMODIFICACION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NTAMANIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NTAMANIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PETCHASH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PETCHASH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TDOCCTIPODOCUMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TDOCCTIPODOCUMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
