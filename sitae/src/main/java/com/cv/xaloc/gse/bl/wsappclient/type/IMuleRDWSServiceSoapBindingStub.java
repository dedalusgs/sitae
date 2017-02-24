/**
 * IMuleRDWSServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.gse.bl.wsappclient.type;

public class IMuleRDWSServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.cv.xaloc.gse.bl.wsappclient.type.IMuleRDWS {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[45];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "content"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDraftEdictDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "draftCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "signed"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSignerRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "signerUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentSignerResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentSignerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("replaceDraftEdictRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "draftCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "signed"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentPlace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DocumentPlace"), com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfMetadata"), com.cv.xaloc.gse.bl.wsappclient.type.Metadata[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfMetadata"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "content"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">SearchResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "SearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchFoldersRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentPlace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DocumentPlace"), com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfMetadata"), com.cv.xaloc.gse.bl.wsappclient.type.Metadata[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfMetadata"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">SearchResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "SearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteFolderRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FolderUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("existDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ExistDocumentResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ExistDocumentResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDocumentExpAndSignerRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EntityLocal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgUnit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Procedure"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ExpNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("documentTransformRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "format"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDraftDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("filterDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfDocuments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfDocuments"), com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfDocuments"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfMetadata"), com.cv.xaloc.gse.bl.wsappclient.type.Metadata[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfMetadata"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">FilterResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "FilterResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createSignerRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createEdictAssociatedDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteDocumentMetadata");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createTemplateDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EntityLocal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgUnit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Procedure"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentMetadata");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">MetadataResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "MetadataResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("copyDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentPlace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DocumentPlace"), com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createCollatedDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createAssociatedDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("renameFolderRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "documentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersonalDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">PersonalDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "PersonalDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDiligenceEdictRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">EdictDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "EdictDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("publicDraftEdictRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "draftCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "title"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDocumentRegAndSignerRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EntityLocal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "registerType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "registerNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteDraftEdictRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "draftCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("unsubscribeEdictRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEdictAssociatedDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">EdictDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "EdictDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentWithoutContentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTemplateDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EntityLocal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgUnit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Procedure"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentWithoutSignerResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentWithoutSignerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEdictDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">EdictDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "EdictDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentVersionsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfDocumentVersion"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfDocumentVersion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchEdictDocuments");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "edictType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "title"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "content"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startPublicationDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endPublicationdate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "unsubscribed"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">SearchResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "SearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setDocumentMetadata");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfMetadata"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfMetadata"), com.cv.xaloc.gse.bl.wsappclient.type.Metadata[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfMetadata"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createSignerWithUuidRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "documentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationSignerResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationSignerResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentWithoutContentAndSignerRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDocumentExpRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EntityLocal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgUnit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Procedure"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ExpNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCollatedDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CollatedDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CollatedDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDraftDocumentsRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DraftDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DraftDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDraftEdictRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "entity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "draftCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">EdictDocumentsResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "EdictDocumentsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("moveDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentPlace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DocumentPlace"), com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AssertionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DocumentUuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createDocumentRegRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EntityLocal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "registerType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "registerNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createPersonalDocumentRDWS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ident"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Document"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocumentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest"), com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ArrayOfSigner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner"), com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse"));
        oper.setReturnClass(com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "CreationDocumentUUIDResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

    }

    public IMuleRDWSServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public IMuleRDWSServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public IMuleRDWSServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
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
            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfDocuments");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentUuid");
            qName2 = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfDocuments");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfDocumentVersion");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfMetadata");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.Metadata[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "Metadata");
            qName2 = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfMetadata");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ArrayOfSigner");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.Signer[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "Signer");
            qName2 = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "arrayOfSigner");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">AssertionResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CollatedDocumentsResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentRequest");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentDocumentWithoutSignerResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ContentSignerResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationDocumentUUIDResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">CreationSignerResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DocumentPlace");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">DraftDocumentsResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">EdictDocumentsResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">ExistDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">FilterResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">MetadataResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">PersonalDocumentsResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", ">SearchResponse");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "AlfrescoError");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.AlfrescoError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "ContentDocument");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.ContentDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentUuid");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "DocumentVersion");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.DocumentVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "EdictDocument");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.EdictDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "Metadata");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.Metadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:castellon:sigex:alfresco:type:v1.0.0", "Signer");
            cachedSerQNames.add(qName);
            cls = com.cv.xaloc.gse.bl.wsappclient.type.Signer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
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
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse updateDocumentRDWS(java.lang.String documentUuid, byte[] content) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "updateDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, content});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createDraftEdictDocumentRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String signed, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createDraftEdictDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, draftCode, signed, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse getSignerRDWS(java.lang.String signerUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getSignerRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {signerUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse replaceDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String signed, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "replaceDraftEdictRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, draftCode, signed, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse searchDocumentsRDWS(com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata, java.lang.String content) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "searchDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentPlace, arrayOfMetadata, content});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "deleteDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse searchFoldersRDWS(com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata, java.lang.String name) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "searchFoldersRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentPlace, arrayOfMetadata, name});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteFolderRDWS(java.lang.String folderUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "deleteFolderRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {folderUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse existDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "existDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentExpAndSignerRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, java.lang.String expNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createDocumentExpAndSignerRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entityLocal, orgUnit, procedure, expNumber, document, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse documentTransformRDWS(java.lang.String documentUuid, java.lang.String format) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "documentTransformRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, format});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createDraftDocumentRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createDraftDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident, entity, request, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse filterDocumentsRDWS(com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[] arrayOfDocuments, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "filterDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arrayOfDocuments, arrayOfMetadata});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse createSignerRDWS(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createSignerRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createEdictAssociatedDocumentRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createEdictAssociatedDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, edictArea, edictCode, contentDocumentRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteDocumentMetadata(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "deleteDocumentMetadata"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createTemplateDocumentRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createTemplateDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entityLocal, orgUnit, procedure, contentDocumentRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse getDocumentMetadata(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDocumentMetadata"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse copyDocumentRDWS(java.lang.String documentUuid, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "copyDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, document, documentPlace});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createCollatedDocumentRDWS(java.lang.String ident, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createCollatedDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident, document, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createAssociatedDocumentRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createAssociatedDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident, entity, request, document, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse renameFolderRDWS(java.lang.String documentUuid, java.lang.String name) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "renameFolderRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, name});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse getPersonalDocumentsRDWS(java.lang.String ident) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getPersonalDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getDiligenceEdictRDWS(java.lang.String edictCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDiligenceEdictRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {edictCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse publicDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String edictCode, java.lang.String edictArea, java.lang.String edictType, java.lang.String title) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "publicDraftEdictRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, draftCode, edictCode, edictArea, edictType, title});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentRegAndSignerRDWS(java.lang.String entityLocal, java.lang.String registerType, java.lang.String registerNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createDocumentRegAndSignerRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entityLocal, registerType, registerNumber, document, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "deleteDraftEdictRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, draftCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse unsubscribeEdictRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "unsubscribeEdictRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, edictArea, edictCode, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getEdictAssociatedDocumentsRDWS(java.lang.String edictCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getEdictAssociatedDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {edictCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse getDocumentWithoutContentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDocumentWithoutContentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse getTemplateDocumentsRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getTemplateDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entityLocal, orgUnit, procedure});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getEdictDocumentsRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getEdictDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, edictArea, edictCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion getDocumentVersionsRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDocumentVersionsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse searchEdictDocuments(java.lang.String entity, java.lang.String edictArea, java.lang.String edictType, java.lang.String title, java.lang.String content, java.lang.String startPublicationDate, java.lang.String endPublicationdate, java.lang.String unsubscribed) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "searchEdictDocuments"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, edictArea, edictType, title, content, startPublicationDate, endPublicationdate, unsubscribed});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse setDocumentMetadata(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "setDocumentMetadata"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, arrayOfMetadata});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse createSignerWithUuidRDWS(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createSignerWithUuidRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse getDocumentWithoutContentAndSignerRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDocumentWithoutContentAndSignerRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentExpRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, java.lang.String expNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createDocumentExpRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entityLocal, orgUnit, procedure, expNumber, document, contentDocumentRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse getCollatedDocumentsRDWS(java.lang.String ident) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getCollatedDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse getDraftDocumentsRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDraftDocumentsRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident, entity, request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDraftEdictRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entity, draftCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse moveDocumentRDWS(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "moveDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid, documentPlace});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse getDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "getDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {documentUuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentRegRDWS(java.lang.String entityLocal, java.lang.String registerType, java.lang.String registerNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createDocumentRegRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {entityLocal, registerType, registerNumber, document, contentDocumentRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createPersonalDocumentRDWS(java.lang.String ident, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://interfaces.muleRD.xaloc.cv.com/", "createPersonalDocumentRDWS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ident, document, contentDocumentRequest, arrayOfSigner});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
