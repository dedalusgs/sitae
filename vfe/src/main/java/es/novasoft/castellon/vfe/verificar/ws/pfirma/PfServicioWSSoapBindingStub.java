/**
 * PfServicioWSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.novasoft.castellon.vfe.verificar.ws.pfirma;

public class PfServicioWSSoapBindingStub extends org.apache.axis.client.Stub
		implements
		es.novasoft.castellon.vfe.verificar.ws.pfirma.PfServicioWS_PortType {
	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] operations;

	static {
		operations = new org.apache.axis.description.OperationDesc[29];
		initOperationDesc1();
		initOperationDesc2();
		initOperationDesc3();
	}

	private static void initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("actualizarPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "chash"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "aplicacion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "firmaCascada"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "boolean"),
				boolean.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "firmaOrdenada"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "boolean"),
				boolean.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "notificaEmail"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "boolean"),
				boolean.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "notificaMovil"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "boolean"),
				boolean.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "notificaAviso"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "boolean"),
				boolean.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "fInicio"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "dateTime"),
				java.util.Calendar.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "fCaducidad"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "dateTime"),
				java.util.Calendar.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "remitenteNombre"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "remitenteEmail"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "remitenteMovil"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dReferencia"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dAsunto"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "nPrioridad"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "decimal"),
				java.math.BigDecimal.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "usuario"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "petChash"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "tTexto"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"actualizarPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarDestinatariosPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_tns1_UsuarioWS"));
		oper
				.setReturnClass(es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarDestinatariosPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarDocumentosPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_tns1_DocumentoWS"));
		oper
				.setReturnClass(es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarDocumentosPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarEntregasPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_tns1_EntregaWS"));
		oper
				.setReturnClass(es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarEntregasPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarNotificacionesPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_soapenc_string"));
		oper.setReturnClass(java.lang.String[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarNotificacionesPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName("http://ws.pfirma",
				"PeticionWS"));
		oper
				.setReturnClass(es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[5] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarUsuario");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dni"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName("http://ws.pfirma",
				"UsuarioWS"));
		oper
				.setReturnClass(es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarUsuarioReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[6] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("descargarDocumento");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "documento"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "base64Binary"));
		oper.setReturnClass(byte[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"descargarDocumentoReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[7] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("descargarPKCS7");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "documento"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "idTransaccion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "base64Binary"));
		oper.setReturnClass(byte[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"descargarPKCS7Return"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[8] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("eliminarDestinatarioPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dni"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"eliminarDestinatarioPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[9] = oper;

	}

	private static void initOperationDesc2() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("eliminarDocumentoPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "documento"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"eliminarDocumentoPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[10] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("eliminarNotificacionPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "estado"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"eliminarNotificacionPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[11] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("entregadaPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "boolean"));
		oper.setReturnClass(boolean.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"entregadaPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[12] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("entregarPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"entregarPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[13] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("insertarDestinatarioPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dni"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"insertarDestinatarioPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[14] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("insertarDocumentoPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "tipoDoc"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "nombreDoc"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "tipoMime"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "documento"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "base64Binary"),
				byte[].class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		oper.setReturnClass(java.lang.String.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"insertarDocumentoPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[15] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("insertarNotificacionPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "estado"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"insertarNotificacionPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[16] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("insertarPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "usuario"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		oper.setReturnClass(java.lang.String.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"insertarPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[17] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("valoresEstados");
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_soapenc_string"));
		oper.setReturnClass(java.lang.String[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"valoresEstadosReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[18] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("valoresTiposDocumento");
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_soapenc_string"));
		oper.setReturnClass(java.lang.String[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"valoresTiposDocumentoReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[19] = oper;

	}

	private static void initOperationDesc3() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("documentoAccion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "hashDoc"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "estado"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "accion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "tipo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"documentoAccionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[20] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("cambiarDestinatario");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "hashPeticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dniOrigen"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dniDestino"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "nombre"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "apellido1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "apellido2"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "nuevo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"cambiarDestinatarioReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[21] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("consultarObservacionesEntrega");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "hashDoc"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "dni"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		oper.setReturnClass(java.lang.String.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"consultarObservacionesEntregaReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[22] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("insertarDestinatarioPet");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "usuario"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://ws.pfirma", "UsuarioWS"),
				es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"insertarDestinatarioPetReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[23] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("eliminarDestinatarioPet");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "usuario"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://ws.pfirma", "UsuarioWS"),
				es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"eliminarDestinatarioPetReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[24] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("cambiarDestinatarioPet");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "hashPeticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "usuarioOrigen"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://ws.pfirma", "UsuarioWS"),
				es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "usuarioDestino"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://ws.pfirma", "UsuarioWS"),
				es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "nuevo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"cambiarDestinatarioPetReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[25] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("eliminarPeticion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "peticion"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "long"));
		oper.setReturnClass(long.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"eliminarPeticionReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[26] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("obtenerListaUsuarios");
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://client.pfirma", "ArrayOf_tns1_UsuarioWS"));
		oper
				.setReturnClass(es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"obtenerListaUsuariosReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[27] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("obtenerIdTransaccion");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "documento"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "double"));
		oper.setReturnClass(double.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"obtenerIdTransacciontReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		operations[28] = oper;

	}

	public PfServicioWSSoapBindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public PfServicioWSSoapBindingStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public PfServicioWSSoapBindingStub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
		java.lang.Class cls;
		javax.xml.namespace.QName qName;
		javax.xml.namespace.QName qName2;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
		qName = new javax.xml.namespace.QName("http://client.pfirma",
				"ArrayOf_soapenc_string");
		cachedSerQNames.add(qName);
		cls = java.lang.String[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://schemas.xmlsoap.org/soap/encoding/", "string");
		qName2 = null;
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName("http://client.pfirma",
				"ArrayOf_tns1_DocumentoWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName("http://ws.pfirma", "DocumentoWS");
		qName2 = null;
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName("http://client.pfirma",
				"ArrayOf_tns1_EntregaWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName("http://ws.pfirma", "EntregaWS");
		qName2 = null;
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName("http://client.pfirma",
				"ArrayOf_tns1_UsuarioWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName("http://ws.pfirma", "UsuarioWS");
		qName2 = null;
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName("http://ws.pfirma", "DocumentoWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://ws.pfirma", "EntregaWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://ws.pfirma", "PeticionWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://ws.pfirma", "UsuarioWS");
		cachedSerQNames.add(qName);
		cls = es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected org.apache.axis.client.Call createCall()
			throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call
							.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
					_call
							.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames
								.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class sf = (java.lang.Class) cachedSerFactories
									.get(i);
							java.lang.Class df = (java.lang.Class) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault(
					"Failure trying to get the Call object", _t);
		}
	}

	public long actualizarPeticion(java.lang.String chash,
			java.lang.String aplicacion, boolean firmaCascada,
			boolean firmaOrdenada, boolean notificaEmail,
			boolean notificaMovil, boolean notificaAviso,
			java.util.Calendar fInicio, java.util.Calendar fCaducidad,
			java.lang.String remitenteNombre, java.lang.String remitenteEmail,
			java.lang.String remitenteMovil, java.lang.String dReferencia,
			java.lang.String dAsunto, java.math.BigDecimal nPrioridad,
			java.lang.String usuario, java.lang.String petChash,
			java.lang.String tTexto) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "actualizarPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { chash, aplicacion,
							Boolean.valueOf(firmaCascada),
							Boolean.valueOf(firmaOrdenada),
							Boolean.valueOf(notificaEmail),
							Boolean.valueOf(notificaMovil),
							Boolean.valueOf(notificaAviso), fInicio,
							fCaducidad, remitenteNombre, remitenteEmail,
							remitenteMovil, dReferencia, dAsunto, nPrioridad,
							usuario, petChash, tTexto });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[] consultarDestinatariosPeticion(
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarDestinatariosPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[] consultarDocumentosPeticion(
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarDocumentosPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									es.novasoft.castellon.vfe.verificar.ws.pfirma.DocumentoWS[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[] consultarEntregasPeticion(
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[3]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarEntregasPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									es.novasoft.castellon.vfe.verificar.ws.pfirma.EntregaWS[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String[] consultarNotificacionesPeticion(
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[4]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarNotificacionesPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String[]) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS consultarPeticion(
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[5]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS) _resp;
				} catch (java.lang.Exception _exception) {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									es.novasoft.castellon.vfe.verificar.ws.pfirma.PeticionWS.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS consultarUsuario(
			java.lang.String dni) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[6]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarUsuario"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { dni });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS) _resp;
				} catch (java.lang.Exception _exception) {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public byte[] descargarDocumento(java.lang.String documento)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[7]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "descargarDocumento"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { documento });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (byte[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (byte[]) org.apache.axis.utils.JavaUtils.convert(
							_resp, byte[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public byte[] descargarPKCS7(java.lang.String documento,
			java.lang.String idTransaccion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[8]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "descargarPKCS7"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					documento, idTransaccion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (byte[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (byte[]) org.apache.axis.utils.JavaUtils.convert(
							_resp, byte[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long eliminarDestinatarioPeticion(java.lang.String dni,
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[9]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "eliminarDestinatarioPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] { dni,
					peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long eliminarDocumentoPeticion(java.lang.String documento)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[10]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "eliminarDocumentoPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { documento });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long eliminarNotificacionPeticion(java.lang.String peticion,
			java.lang.String estado) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[11]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "eliminarNotificacionPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					peticion, estado });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public boolean entregadaPeticion(java.lang.String peticion)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[12]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "entregadaPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Boolean) _resp).booleanValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils
							.convert(_resp, boolean.class)).booleanValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long entregarPeticion(java.lang.String peticion)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[13]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "entregarPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long insertarDestinatarioPeticion(java.lang.String dni,
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[14]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "insertarDestinatarioPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] { dni,
					peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String insertarDocumentoPeticion(
			java.lang.String peticion, java.lang.String tipoDoc,
			java.lang.String nombreDoc, java.lang.String tipoMime,
			byte[] documento) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[15]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "insertarDocumentoPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					peticion, tipoDoc, nombreDoc, tipoMime, documento });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long insertarNotificacionPeticion(java.lang.String peticion,
			java.lang.String estado) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[16]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "insertarNotificacionPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					peticion, estado });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String insertarPeticion(java.lang.String usuario)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[17]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "insertarPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { usuario });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String[] valoresEstados() throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[18]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "valoresEstados"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String[]) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String[] valoresTiposDocumento()
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[19]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "valoresTiposDocumento"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String[]) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long documentoAccion(java.lang.String hashDoc,
			java.lang.String estado, java.lang.String accion,
			java.lang.String tipo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[20]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "documentoAccion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					hashDoc, estado, accion, tipo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long cambiarDestinatario(java.lang.String hashPeticion,
			java.lang.String dniOrigen, java.lang.String dniDestino,
			java.lang.String nombre, java.lang.String apellido1,
			java.lang.String apellido2, java.lang.String nuevo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[21]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "cambiarDestinatario"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					hashPeticion, dniOrigen, dniDestino, nombre, apellido1,
					apellido2, nuevo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String consultarObservacionesEntrega(
			java.lang.String hashDoc, java.lang.String dni)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[22]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "consultarObservacionesEntrega"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					hashDoc, dni });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long insertarDestinatarioPet(
			es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuario,
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[23]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "insertarDestinatarioPet"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					usuario, peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long eliminarDestinatarioPet(
			es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuario,
			java.lang.String peticion) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[24]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "eliminarDestinatarioPet"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					usuario, peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long cambiarDestinatarioPet(
			java.lang.String hashPeticion,
			es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuarioOrigen,
			es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS usuarioDestino,
			java.lang.String nuevo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[25]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "cambiarDestinatarioPet"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					hashPeticion, usuarioOrigen, usuarioDestino, nuevo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public long eliminarPeticion(java.lang.String peticion)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[26]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "eliminarPeticion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { peticion });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Long) _resp).longValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Long) org.apache.axis.utils.JavaUtils
							.convert(_resp, long.class)).longValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[] obtenerListaUsuarios()
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[27]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "obtenerListaUsuarios"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									es.novasoft.castellon.vfe.verificar.ws.pfirma.UsuarioWS[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public double obtenerIdTransaccion(java.lang.String documento)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(operations[28]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://DefaultNamespace", "obtenerIdTransaccion"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { documento });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((java.lang.Double) _resp).doubleValue();
				} catch (java.lang.Exception _exception) {
					return ((java.lang.Double) org.apache.axis.utils.JavaUtils
							.convert(_resp, double.class)).doubleValue();
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
