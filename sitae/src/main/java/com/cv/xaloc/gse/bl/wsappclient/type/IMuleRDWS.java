/**
 * IMuleRDWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cv.xaloc.gse.bl.wsappclient.type;

public interface IMuleRDWS extends java.rmi.Remote {
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse updateDocumentRDWS(java.lang.String documentUuid, byte[] content) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ContentSignerResponse getSignerRDWS(java.lang.String signerUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createDraftEdictDocumentRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String signed, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse replaceDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String signed, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse searchDocumentsRDWS(com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata, java.lang.String content) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse searchFoldersRDWS(com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata, java.lang.String name) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteFolderRDWS(java.lang.String folderUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ExistDocumentResponse existDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentExpAndSignerRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, java.lang.String expNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse documentTransformRDWS(java.lang.String documentUuid, java.lang.String format) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createDraftDocumentRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.FilterResponse filterDocumentsRDWS(com.cv.xaloc.gse.bl.wsappclient.type.DocumentUuid[] arrayOfDocuments, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse createSignerRDWS(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteDocumentMetadata(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createEdictAssociatedDocumentRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.MetadataResponse getDocumentMetadata(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createTemplateDocumentRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse copyDocumentRDWS(java.lang.String documentUuid, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createCollatedDocumentRDWS(java.lang.String ident, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createAssociatedDocumentRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse renameFolderRDWS(java.lang.String documentUuid, java.lang.String name) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.PersonalDocumentsResponse getPersonalDocumentsRDWS(java.lang.String ident) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse publicDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String edictCode, java.lang.String edictArea, java.lang.String edictType, java.lang.String title) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getDiligenceEdictRDWS(java.lang.String edictCode) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse deleteDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentRegAndSignerRDWS(java.lang.String entityLocal, java.lang.String registerType, java.lang.String registerNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse unsubscribeEdictRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getEdictAssociatedDocumentsRDWS(java.lang.String edictCode) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse getDocumentWithoutContentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentWithoutSignerResponse getTemplateDocumentsRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getEdictDocumentsRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ArrayOfDocumentVersion getDocumentVersionsRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.SearchResponse searchEdictDocuments(java.lang.String entity, java.lang.String edictArea, java.lang.String edictType, java.lang.String title, java.lang.String content, java.lang.String startPublicationDate, java.lang.String endPublicationdate, java.lang.String unsubscribed) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse setDocumentMetadata(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.Metadata[] arrayOfMetadata) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse getDocumentWithoutContentAndSignerRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationSignerResponse createSignerWithUuidRDWS(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.DraftDocumentsResponse getDraftDocumentsRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CollatedDocumentsResponse getCollatedDocumentsRDWS(java.lang.String ident) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentExpRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, java.lang.String expNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.EdictDocumentsResponse getDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.AssertionResponse moveDocumentRDWS(java.lang.String documentUuid, com.cv.xaloc.gse.bl.wsappclient.type.DocumentPlace documentPlace) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse getDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationResponse createDocumentRegRDWS(java.lang.String entityLocal, java.lang.String registerType, java.lang.String registerNumber, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public com.cv.xaloc.gse.bl.wsappclient.type.CreationDocumentUUIDResponse createPersonalDocumentRDWS(java.lang.String ident, java.lang.String document, com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentRequest contentDocumentRequest, com.cv.xaloc.gse.bl.wsappclient.type.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
}
