/**
 * DocumentPlace.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package alfresco.sigex.castellon;

public class DocumentPlace  implements java.io.Serializable {
    private java.lang.String entity;

    private java.lang.String orgUnit;

    private java.lang.String documentType;

    private java.lang.String procedure;

    private java.lang.String year;

    private java.lang.String month;

    private java.lang.String expNumber;

    private java.lang.String type;

    private java.lang.String registerNumber;

    private alfresco.sigex.castellon.AlfrescoError[] errors;

    public DocumentPlace() {
    }

    public DocumentPlace(
           java.lang.String entity,
           java.lang.String orgUnit,
           java.lang.String documentType,
           java.lang.String procedure,
           java.lang.String year,
           java.lang.String month,
           java.lang.String expNumber,
           java.lang.String type,
           java.lang.String registerNumber,
           alfresco.sigex.castellon.AlfrescoError[] errors) {
           this.entity = entity;
           this.orgUnit = orgUnit;
           this.documentType = documentType;
           this.procedure = procedure;
           this.year = year;
           this.month = month;
           this.expNumber = expNumber;
           this.type = type;
           this.registerNumber = registerNumber;
           this.errors = errors;
    }


    /**
     * Gets the entity value for this DocumentPlace.
     * 
     * @return entity
     */
    public java.lang.String getEntity() {
        return entity;
    }


    /**
     * Sets the entity value for this DocumentPlace.
     * 
     * @param entity
     */
    public void setEntity(java.lang.String entity) {
        this.entity = entity;
    }


    /**
     * Gets the orgUnit value for this DocumentPlace.
     * 
     * @return orgUnit
     */
    public java.lang.String getOrgUnit() {
        return orgUnit;
    }


    /**
     * Sets the orgUnit value for this DocumentPlace.
     * 
     * @param orgUnit
     */
    public void setOrgUnit(java.lang.String orgUnit) {
        this.orgUnit = orgUnit;
    }


    /**
     * Gets the documentType value for this DocumentPlace.
     * 
     * @return documentType
     */
    public java.lang.String getDocumentType() {
        return documentType;
    }


    /**
     * Sets the documentType value for this DocumentPlace.
     * 
     * @param documentType
     */
    public void setDocumentType(java.lang.String documentType) {
        this.documentType = documentType;
    }


    /**
     * Gets the procedure value for this DocumentPlace.
     * 
     * @return procedure
     */
    public java.lang.String getProcedure() {
        return procedure;
    }


    /**
     * Sets the procedure value for this DocumentPlace.
     * 
     * @param procedure
     */
    public void setProcedure(java.lang.String procedure) {
        this.procedure = procedure;
    }


    /**
     * Gets the year value for this DocumentPlace.
     * 
     * @return year
     */
    public java.lang.String getYear() {
        return year;
    }


    /**
     * Sets the year value for this DocumentPlace.
     * 
     * @param year
     */
    public void setYear(java.lang.String year) {
        this.year = year;
    }


    /**
     * Gets the month value for this DocumentPlace.
     * 
     * @return month
     */
    public java.lang.String getMonth() {
        return month;
    }


    /**
     * Sets the month value for this DocumentPlace.
     * 
     * @param month
     */
    public void setMonth(java.lang.String month) {
        this.month = month;
    }


    /**
     * Gets the expNumber value for this DocumentPlace.
     * 
     * @return expNumber
     */
    public java.lang.String getExpNumber() {
        return expNumber;
    }


    /**
     * Sets the expNumber value for this DocumentPlace.
     * 
     * @param expNumber
     */
    public void setExpNumber(java.lang.String expNumber) {
        this.expNumber = expNumber;
    }


    /**
     * Gets the type value for this DocumentPlace.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this DocumentPlace.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the registerNumber value for this DocumentPlace.
     * 
     * @return registerNumber
     */
    public java.lang.String getRegisterNumber() {
        return registerNumber;
    }


    /**
     * Sets the registerNumber value for this DocumentPlace.
     * 
     * @param registerNumber
     */
    public void setRegisterNumber(java.lang.String registerNumber) {
        this.registerNumber = registerNumber;
    }


    /**
     * Gets the errors value for this DocumentPlace.
     * 
     * @return errors
     */
    public alfresco.sigex.castellon.AlfrescoError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this DocumentPlace.
     * 
     * @param errors
     */
    public void setErrors(alfresco.sigex.castellon.AlfrescoError[] errors) {
        this.errors = errors;
    }

    public alfresco.sigex.castellon.AlfrescoError getErrors(int i) {
        return this.errors[i];
    }

    public void setErrors(int i, alfresco.sigex.castellon.AlfrescoError _value) {
        this.errors[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentPlace)) return false;
        DocumentPlace other = (DocumentPlace) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entity==null && other.getEntity()==null) || 
             (this.entity!=null &&
              this.entity.equals(other.getEntity()))) &&
            ((this.orgUnit==null && other.getOrgUnit()==null) || 
             (this.orgUnit!=null &&
              this.orgUnit.equals(other.getOrgUnit()))) &&
            ((this.documentType==null && other.getDocumentType()==null) || 
             (this.documentType!=null &&
              this.documentType.equals(other.getDocumentType()))) &&
            ((this.procedure==null && other.getProcedure()==null) || 
             (this.procedure!=null &&
              this.procedure.equals(other.getProcedure()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.expNumber==null && other.getExpNumber()==null) || 
             (this.expNumber!=null &&
              this.expNumber.equals(other.getExpNumber()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.registerNumber==null && other.getRegisterNumber()==null) || 
             (this.registerNumber!=null &&
              this.registerNumber.equals(other.getRegisterNumber()))) &&
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
        if (getEntity() != null) {
            _hashCode += getEntity().hashCode();
        }
        if (getOrgUnit() != null) {
            _hashCode += getOrgUnit().hashCode();
        }
        if (getDocumentType() != null) {
            _hashCode += getDocumentType().hashCode();
        }
        if (getProcedure() != null) {
            _hashCode += getProcedure().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getExpNumber() != null) {
            _hashCode += getExpNumber().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getRegisterNumber() != null) {
            _hashCode += getRegisterNumber().hashCode();
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
        new org.apache.axis.description.TypeDesc(DocumentPlace.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DocumentPlace"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "entity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "orgUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "documentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procedure");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "procedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "expNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "registerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
