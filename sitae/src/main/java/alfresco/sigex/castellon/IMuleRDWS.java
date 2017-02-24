/**
 * IMuleRDWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package alfresco.sigex.castellon;

public interface IMuleRDWS extends java.rmi.Remote {
    public alfresco.sigex.castellon.AssertionResponse updateDocumentRDWS(java.lang.String documentUuid, byte[] content) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ContentSignerResponse getSignerRDWS(java.lang.String signerUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse createDraftEdictDocumentRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String signed, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse replaceDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String signed, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.SearchResponse searchDocumentsRDWS(alfresco.sigex.castellon.DocumentPlace documentPlace, alfresco.sigex.castellon.Metadata[] arrayOfMetadata, java.lang.String content) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse deleteDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.SearchResponse searchFoldersRDWS(alfresco.sigex.castellon.DocumentPlace documentPlace, alfresco.sigex.castellon.Metadata[] arrayOfMetadata, java.lang.String name) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse deleteFolderRDWS(java.lang.String folderUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ExistDocumentResponse existDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationResponse createDocumentExpAndSignerRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, java.lang.String expNumber, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ContentDocumentResponse documentTransformRDWS(java.lang.String documentUuid, java.lang.String format) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse createDraftDocumentRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.FilterResponse filterDocumentsRDWS(alfresco.sigex.castellon.DocumentUuid[] arrayOfDocuments, alfresco.sigex.castellon.Metadata[] arrayOfMetadata) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse createSignerRDWS(java.lang.String documentUuid, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse deleteDocumentMetadata(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse createEdictAssociatedDocumentRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.MetadataResponse getDocumentMetadata(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationResponse createTemplateDocumentRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationResponse copyDocumentRDWS(java.lang.String documentUuid, java.lang.String document, alfresco.sigex.castellon.DocumentPlace documentPlace) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse createCollatedDocumentRDWS(java.lang.String ident, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse createAssociatedDocumentRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse renameFolderRDWS(java.lang.String documentUuid, java.lang.String name) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.PersonalDocumentsResponse getPersonalDocumentsRDWS(java.lang.String ident) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse publicDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode, java.lang.String edictCode, java.lang.String edictArea, java.lang.String edictType, java.lang.String title) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.EdictDocumentsResponse getDiligenceEdictRDWS(java.lang.String edictCode) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse deleteDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationResponse createDocumentRegAndSignerRDWS(java.lang.String entityLocal, java.lang.String registerType, java.lang.String registerNumber, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse unsubscribeEdictRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.EdictDocumentsResponse getEdictAssociatedDocumentsRDWS(java.lang.String edictCode) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ContentDocumentResponse getDocumentWithoutContentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ContentDocumentWithoutSignerResponse getTemplateDocumentsRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.EdictDocumentsResponse getEdictDocumentsRDWS(java.lang.String entity, java.lang.String edictArea, java.lang.String edictCode) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ArrayOfDocumentVersion getDocumentVersionsRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.SearchResponse searchEdictDocuments(java.lang.String entity, java.lang.String edictArea, java.lang.String edictType, java.lang.String title, java.lang.String content, java.lang.String startPublicationDate, java.lang.String endPublicationdate, java.lang.String unsubscribed) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse setDocumentMetadata(java.lang.String documentUuid, alfresco.sigex.castellon.Metadata[] arrayOfMetadata) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ContentDocumentResponse getDocumentWithoutContentAndSignerRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationSignerResponse createSignerWithUuidRDWS(java.lang.String documentUuid, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.DraftDocumentsResponse getDraftDocumentsRDWS(java.lang.String ident, java.lang.String entity, java.lang.String request) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CollatedDocumentsResponse getCollatedDocumentsRDWS(java.lang.String ident) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationResponse createDocumentExpRDWS(java.lang.String entityLocal, java.lang.String orgUnit, java.lang.String procedure, java.lang.String expNumber, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.EdictDocumentsResponse getDraftEdictRDWS(java.lang.String entity, java.lang.String draftCode) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.AssertionResponse moveDocumentRDWS(java.lang.String documentUuid, alfresco.sigex.castellon.DocumentPlace documentPlace) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.ContentDocumentResponse getDocumentRDWS(java.lang.String documentUuid) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationResponse createDocumentRegRDWS(java.lang.String entityLocal, java.lang.String registerType, java.lang.String registerNumber, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest) throws java.rmi.RemoteException;
    public alfresco.sigex.castellon.CreationDocumentUUIDResponse createPersonalDocumentRDWS(java.lang.String ident, java.lang.String document, alfresco.sigex.castellon.ContentDocumentRequest contentDocumentRequest, alfresco.sigex.castellon.Signer[] arrayOfSigner) throws java.rmi.RemoteException;
}
