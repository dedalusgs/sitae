/**
 * InformacionCertificadoPublicacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservice.fandango.accv.es;

public class InformacionCertificadoPublicacion implements java.io.Serializable {
	private boolean activo;

	private java.lang.String fecha;

	private boolean revisable;

	private java.lang.String titulo;

	private java.lang.String urlCertificadoPublicacion;

	private java.lang.String urlDocumento;

	public InformacionCertificadoPublicacion() {
	}

	public InformacionCertificadoPublicacion(boolean activo,
			java.lang.String fecha, boolean revisable, java.lang.String titulo,
			java.lang.String urlCertificadoPublicacion,
			java.lang.String urlDocumento) {
		this.activo = activo;
		this.fecha = fecha;
		this.revisable = revisable;
		this.titulo = titulo;
		this.urlCertificadoPublicacion = urlCertificadoPublicacion;
		this.urlDocumento = urlDocumento;
	}

	/**
	 * Gets the activo value for this InformacionCertificadoPublicacion.
	 * 
	 * @return activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Sets the activo value for this InformacionCertificadoPublicacion.
	 * 
	 * @param activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the fecha value for this InformacionCertificadoPublicacion.
	 * 
	 * @return fecha
	 */
	public java.lang.String getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha value for this InformacionCertificadoPublicacion.
	 * 
	 * @param fecha
	 */
	public void setFecha(java.lang.String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the revisable value for this InformacionCertificadoPublicacion.
	 * 
	 * @return revisable
	 */
	public boolean isRevisable() {
		return revisable;
	}

	/**
	 * Sets the revisable value for this InformacionCertificadoPublicacion.
	 * 
	 * @param revisable
	 */
	public void setRevisable(boolean revisable) {
		this.revisable = revisable;
	}

	/**
	 * Gets the titulo value for this InformacionCertificadoPublicacion.
	 * 
	 * @return titulo
	 */
	public java.lang.String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo value for this InformacionCertificadoPublicacion.
	 * 
	 * @param titulo
	 */
	public void setTitulo(java.lang.String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the urlCertificadoPublicacion value for this
	 * InformacionCertificadoPublicacion.
	 * 
	 * @return urlCertificadoPublicacion
	 */
	public java.lang.String getUrlCertificadoPublicacion() {
		return urlCertificadoPublicacion;
	}

	/**
	 * Sets the urlCertificadoPublicacion value for this
	 * InformacionCertificadoPublicacion.
	 * 
	 * @param urlCertificadoPublicacion
	 */
	public void setUrlCertificadoPublicacion(
			java.lang.String urlCertificadoPublicacion) {
		this.urlCertificadoPublicacion = urlCertificadoPublicacion;
	}

	/**
	 * Gets the urlDocumento value for this InformacionCertificadoPublicacion.
	 * 
	 * @return urlDocumento
	 */
	public java.lang.String getUrlDocumento() {
		return urlDocumento;
	}

	/**
	 * Sets the urlDocumento value for this InformacionCertificadoPublicacion.
	 * 
	 * @param urlDocumento
	 */
	public void setUrlDocumento(java.lang.String urlDocumento) {
		this.urlDocumento = urlDocumento;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof InformacionCertificadoPublicacion))
			return false;
		InformacionCertificadoPublicacion other = (InformacionCertificadoPublicacion) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& this.activo == other.isActivo()
				&& ((this.fecha == null && other.getFecha() == null) || (this.fecha != null && this.fecha
						.equals(other.getFecha())))
				&& this.revisable == other.isRevisable()
				&& ((this.titulo == null && other.getTitulo() == null) || (this.titulo != null && this.titulo
						.equals(other.getTitulo())))
				&& ((this.urlCertificadoPublicacion == null && other
						.getUrlCertificadoPublicacion() == null) || (this.urlCertificadoPublicacion != null && this.urlCertificadoPublicacion
						.equals(other.getUrlCertificadoPublicacion())))
				&& ((this.urlDocumento == null && other.getUrlDocumento() == null) || (this.urlDocumento != null && this.urlDocumento
						.equals(other.getUrlDocumento())));
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
		_hashCode += (isActivo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
		if (getFecha() != null) {
			_hashCode += getFecha().hashCode();
		}
		_hashCode += (isRevisable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
		if (getTitulo() != null) {
			_hashCode += getTitulo().hashCode();
		}
		if (getUrlCertificadoPublicacion() != null) {
			_hashCode += getUrlCertificadoPublicacion().hashCode();
		}
		if (getUrlDocumento() != null) {
			_hashCode += getUrlDocumento().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			InformacionCertificadoPublicacion.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"urn:es.accv.fandango.webservice",
				"InformacionCertificadoPublicacion"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("activo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "activo"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "boolean"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("fecha");
		elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("revisable");
		elemField.setXmlName(new javax.xml.namespace.QName("", "revisable"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "boolean"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("titulo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "titulo"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("urlCertificadoPublicacion");
		elemField.setXmlName(new javax.xml.namespace.QName("",
				"urlCertificadoPublicacion"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("urlDocumento");
		elemField.setXmlName(new javax.xml.namespace.QName("", "urlDocumento"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
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
