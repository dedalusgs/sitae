/**
 * ConsultarAnuncioResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.sitae.perfiles.ws;

public class ConsultarAnuncioResponse implements java.io.Serializable {
	private es.novasoft.sitae.perfiles.ws.InfoAnuncio	datosAnuncio;
	
	private es.novasoft.sitae.perfiles.ws.TypeError[]	instanciaSolicitud;
	
	public ConsultarAnuncioResponse() {
	}
	
	public ConsultarAnuncioResponse(es.novasoft.sitae.perfiles.ws.InfoAnuncio datosAnuncio, es.novasoft.sitae.perfiles.ws.TypeError[] instanciaSolicitud) {
		this.datosAnuncio = datosAnuncio;
		this.instanciaSolicitud = instanciaSolicitud;
	}
	
	/**
	 * Gets the datosAnuncio value for this ConsultarAnuncioResponse.
	 *
	 * @return datosAnuncio
	 */
	public es.novasoft.sitae.perfiles.ws.InfoAnuncio getDatosAnuncio() {
		return this.datosAnuncio;
	}
	
	/**
	 * Sets the datosAnuncio value for this ConsultarAnuncioResponse.
	 *
	 * @param datosAnuncio
	 */
	public void setDatosAnuncio(es.novasoft.sitae.perfiles.ws.InfoAnuncio datosAnuncio) {
		this.datosAnuncio = datosAnuncio;
	}
	
	/**
	 * Gets the instanciaSolicitud value for this ConsultarAnuncioResponse.
	 *
	 * @return instanciaSolicitud
	 */
	public es.novasoft.sitae.perfiles.ws.TypeError[] getInstanciaSolicitud() {
		return this.instanciaSolicitud;
	}
	
	/**
	 * Sets the instanciaSolicitud value for this ConsultarAnuncioResponse.
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
	
	private java.lang.Object	__equalsCalc	= null;
	
	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof ConsultarAnuncioResponse)) {
			return false;
		}
		ConsultarAnuncioResponse other = (ConsultarAnuncioResponse) obj;
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.__equalsCalc != null) {
			return (this.__equalsCalc == obj);
		}
		this.__equalsCalc = obj;
		boolean _equals;
		_equals = true
		        && ((this.datosAnuncio == null && other.getDatosAnuncio() == null) || (this.datosAnuncio != null && this.datosAnuncio.equals(other.getDatosAnuncio())))
		        && ((this.instanciaSolicitud == null && other.getInstanciaSolicitud() == null) || (this.instanciaSolicitud != null && java.util.Arrays.equals(
		                this.instanciaSolicitud, other.getInstanciaSolicitud())));
		this.__equalsCalc = null;
		return _equals;
	}
	
	private boolean	__hashCodeCalc	= false;
	
	public synchronized int hashCode() {
		if (this.__hashCodeCalc) {
			return 0;
		}
		this.__hashCodeCalc = true;
		int _hashCode = 1;
		if (getDatosAnuncio() != null) {
			_hashCode += getDatosAnuncio().hashCode();
		}
		if (getInstanciaSolicitud() != null) {
			for (int i = 0; i < java.lang.reflect.Array.getLength(getInstanciaSolicitud()); i++) {
				java.lang.Object obj = java.lang.reflect.Array.get(getInstanciaSolicitud(), i);
				if (obj != null && !obj.getClass().isArray()) {
					_hashCode += obj.hashCode();
				}
			}
		}
		this.__hashCodeCalc = false;
		return _hashCode;
	}
	
	// Type metadata
	private static org.apache.axis.description.TypeDesc	typeDesc	= new org.apache.axis.description.TypeDesc(ConsultarAnuncioResponse.class, true);
	
	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", ">consultarAnuncioResponse"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("datosAnuncio");
		elemField.setXmlName(new javax.xml.namespace.QName("", "datosAnuncio"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "infoAnuncio"));
		elemField.setNillable(false);
		elemField.setMinOccurs(0);
		elemField.setMaxOccurs(1);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("instanciaSolicitud");
		elemField.setXmlName(new javax.xml.namespace.QName("", "instanciaSolicitud"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://novasoft.es/sitae/perfiles/ws", "typeError"));
		elemField.setNillable(false);
		elemField.setMinOccurs(0);
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
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}
	
	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}
	
}
