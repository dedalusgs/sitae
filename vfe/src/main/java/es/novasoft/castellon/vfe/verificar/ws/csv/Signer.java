/**
 * Signer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.csv;

public class Signer implements java.io.Serializable {

	private ContentDocument content;

	private java.lang.String type;

	private java.lang.String anagram;

	private java.lang.String nif;

	private java.lang.String name;

	private java.lang.String job;

	private java.lang.String date;

	private java.lang.String idAplication;

	private java.lang.String server;

	private java.lang.String idTransaction;

	private java.lang.String signerData;

	public Signer() {
	}

	public Signer(ContentDocument content, java.lang.String type,
			java.lang.String anagram, java.lang.String nif,
			java.lang.String name, java.lang.String job, java.lang.String date,
			java.lang.String idAplication, java.lang.String server,
			java.lang.String idTransaction, java.lang.String signerData) {
		this.content = content;
		this.type = type;
		this.anagram = anagram;
		this.nif = nif;
		this.name = name;
		this.job = job;
		this.date = date;
		this.idAplication = idAplication;
		this.server = server;
		this.idTransaction = idTransaction;
		this.signerData = signerData;
	}

	/**
	 * Gets the content value for this Signer.
	 * 
	 * @return content
	 */
	public ContentDocument getContent() {
		return content;
	}

	/**
	 * Sets the content value for this Signer.
	 * 
	 * @param content
	 */
	public void setContent(ContentDocument content) {
		this.content = content;
	}

	/**
	 * Gets the type value for this Signer.
	 * 
	 * @return type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Sets the type value for this Signer.
	 * 
	 * @param type
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * Gets the anagram value for this Signer.
	 * 
	 * @return anagram
	 */
	public java.lang.String getAnagram() {
		return anagram;
	}

	/**
	 * Sets the anagram value for this Signer.
	 * 
	 * @param anagram
	 */
	public void setAnagram(java.lang.String anagram) {
		this.anagram = anagram;
	}

	/**
	 * Gets the nif value for this Signer.
	 * 
	 * @return nif
	 */
	public java.lang.String getNif() {
		return nif;
	}

	/**
	 * Sets the nif value for this Signer.
	 * 
	 * @param nif
	 */
	public void setNif(java.lang.String nif) {
		this.nif = nif;
	}

	/**
	 * Gets the name value for this Signer.
	 * 
	 * @return name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Sets the name value for this Signer.
	 * 
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Gets the job value for this Signer.
	 * 
	 * @return job
	 */
	public java.lang.String getJob() {
		return job;
	}

	/**
	 * Sets the job value for this Signer.
	 * 
	 * @param job
	 */
	public void setJob(java.lang.String job) {
		this.job = job;
	}

	/**
	 * Gets the date value for this Signer.
	 * 
	 * @return date
	 */
	public java.lang.String getDate() {
		return date;
	}

	/**
	 * Sets the date value for this Signer.
	 * 
	 * @param date
	 */
	public void setDate(java.lang.String date) {
		this.date = date;
	}

	/**
	 * Gets the idAplication value for this Signer.
	 * 
	 * @return idAplication
	 */
	public java.lang.String getIdAplication() {
		return idAplication;
	}

	/**
	 * Sets the idAplication value for this Signer.
	 * 
	 * @param idAplication
	 */
	public void setIdAplication(java.lang.String idAplication) {
		this.idAplication = idAplication;
	}

	/**
	 * Gets the server value for this Signer.
	 * 
	 * @return server
	 */
	public java.lang.String getServer() {
		return server;
	}

	/**
	 * Sets the server value for this Signer.
	 * 
	 * @param server
	 */
	public void setServer(java.lang.String server) {
		this.server = server;
	}

	/**
	 * Gets the idTransaction value for this Signer.
	 * 
	 * @return idTransaction
	 */
	public java.lang.String getIdTransaction() {
		return idTransaction;
	}

	/**
	 * Sets the idTransaction value for this Signer.
	 * 
	 * @param idTransaction
	 */
	public void setIdTransaction(java.lang.String idTransaction) {
		this.idTransaction = idTransaction;
	}

	/**
	 * Gets the signerData value for this Signer.
	 * 
	 * @return signerData
	 */
	public java.lang.String getSignerData() {
		return signerData;
	}

	/**
	 * Sets the signerData value for this Signer.
	 * 
	 * @param signerData
	 */
	public void setSignerData(java.lang.String signerData) {
		this.signerData = signerData;
	}

	private java.lang.Object equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Signer))
			return false;
		Signer other = (Signer) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (equalsCalc != null) {
			return (equalsCalc == obj);
		}
		equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.content == null && other.getContent() == null) || (this.content != null && this.content
						.equals(other.getContent())))
				&& ((this.type == null && other.getType() == null) || (this.type != null && this.type
						.equals(other.getType())))
				&& ((this.anagram == null && other.getAnagram() == null) || (this.anagram != null && this.anagram
						.equals(other.getAnagram())))
				&& ((this.nif == null && other.getNif() == null) || (this.nif != null && this.nif
						.equals(other.getNif())))
				&& ((this.name == null && other.getName() == null) || (this.name != null && this.name
						.equals(other.getName())))
				&& ((this.job == null && other.getJob() == null) || (this.job != null && this.job
						.equals(other.getJob())))
				&& ((this.date == null && other.getDate() == null) || (this.date != null && this.date
						.equals(other.getDate())))
				&& ((this.idAplication == null && other.getIdAplication() == null) || (this.idAplication != null && this.idAplication
						.equals(other.getIdAplication())))
				&& ((this.server == null && other.getServer() == null) || (this.server != null && this.server
						.equals(other.getServer())))
				&& ((this.idTransaction == null && other.getIdTransaction() == null) || (this.idTransaction != null && this.idTransaction
						.equals(other.getIdTransaction())))
				&& ((this.signerData == null && other.getSignerData() == null) || (this.signerData != null && this.signerData
						.equals(other.getSignerData())));
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
		if (getContent() != null) {
			_hashCode += getContent().hashCode();
		}
		if (getType() != null) {
			_hashCode += getType().hashCode();
		}
		if (getAnagram() != null) {
			_hashCode += getAnagram().hashCode();
		}
		if (getNif() != null) {
			_hashCode += getNif().hashCode();
		}
		if (getName() != null) {
			_hashCode += getName().hashCode();
		}
		if (getJob() != null) {
			_hashCode += getJob().hashCode();
		}
		if (getDate() != null) {
			_hashCode += getDate().hashCode();
		}
		if (getIdAplication() != null) {
			_hashCode += getIdAplication().hashCode();
		}
		if (getServer() != null) {
			_hashCode += getServer().hashCode();
		}
		if (getIdTransaction() != null) {
			_hashCode += getIdTransaction().hashCode();
		}
		if (getSignerData() != null) {
			_hashCode += getSignerData().hashCode();
		}
		hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			Signer.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "Signer"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("content");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "content"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocument"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("type");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "type"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("anagram");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "anagram"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("nif");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "nif"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("name");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "name"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("job");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "job"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("date");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "date"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("idAplication");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "idAplication"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("server");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "server"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("idTransaction");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "idTransaction"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("signerData");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "signerData"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
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
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}
