/**
 * ContentDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.csv;

public class ContentDocument implements java.io.Serializable {
	private byte[] content;

	private java.lang.String name;

	private java.lang.String mimeType;

	public ContentDocument() {
	}

	public ContentDocument(byte[] content, java.lang.String name,
			java.lang.String mimeType) {
		this.content = content;
		this.name = name;
		this.mimeType = mimeType;
	}

	/**
	 * Gets the content value for this ContentDocument.
	 * 
	 * @return content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * Sets the content value for this ContentDocument.
	 * 
	 * @param content
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	/**
	 * Gets the name value for this ContentDocument.
	 * 
	 * @return name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Sets the name value for this ContentDocument.
	 * 
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Gets the mimeType value for this ContentDocument.
	 * 
	 * @return mimeType
	 */
	public java.lang.String getMimeType() {
		return mimeType;
	}

	/**
	 * Sets the mimeType value for this ContentDocument.
	 * 
	 * @param mimeType
	 */
	public void setMimeType(java.lang.String mimeType) {
		this.mimeType = mimeType;
	}

	private java.lang.Object equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof ContentDocument))
			return false;
		ContentDocument other = (ContentDocument) obj;
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
				&& ((this.content == null && other.getContent() == null) || (this.content != null && java.util.Arrays
						.equals(this.content, other.getContent())))
				&& ((this.name == null && other.getName() == null) || (this.name != null && this.name
						.equals(other.getName())))
				&& ((this.mimeType == null && other.getMimeType() == null) || (this.mimeType != null && this.mimeType
						.equals(other.getMimeType())));
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
			for (int i = 0; i < java.lang.reflect.Array.getLength(getContent()); i++) {
				java.lang.Object obj = java.lang.reflect.Array.get(
						getContent(), i);
				if (obj != null && !obj.getClass().isArray()) {
					_hashCode += obj.hashCode();
				}
			}
		}
		if (getName() != null) {
			_hashCode += getName().hashCode();
		}
		if (getMimeType() != null) {
			_hashCode += getMimeType().hashCode();
		}
		hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			ContentDocument.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocument"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("content");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "content"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
		elemField.setFieldName("mimeType");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"urn:castellon:sigex:alfresco:type:v1.0.0", "mimeType"));
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
