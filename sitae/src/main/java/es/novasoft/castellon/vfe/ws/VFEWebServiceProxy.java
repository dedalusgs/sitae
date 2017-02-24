package es.novasoft.castellon.vfe.ws;

public class VFEWebServiceProxy implements es.novasoft.castellon.vfe.ws.VFEWebService {
  private String _endpoint = null;
  private es.novasoft.castellon.vfe.ws.VFEWebService vFEWebService = null;
  
  public VFEWebServiceProxy() {
    _initVFEWebServiceProxy();
  }
  
  public VFEWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initVFEWebServiceProxy();
  }
  
  private void _initVFEWebServiceProxy() {
    try {
      vFEWebService = (new es.novasoft.castellon.vfe.ws.VFEWebServiceServiceLocator()).getVFEWebService();
      if (vFEWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)vFEWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)vFEWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (vFEWebService != null)
      ((javax.xml.rpc.Stub)vFEWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public es.novasoft.castellon.vfe.ws.VFEWebService getVFEWebService() {
    if (vFEWebService == null)
      _initVFEWebServiceProxy();
    return vFEWebService;
  }
  
  public es.novasoft.castellon.vfe.ws.RespuestaRegistro eliminarRegistrarDocumento(es.novasoft.castellon.vfe.ws.PeticionRegistro peticion) throws java.rmi.RemoteException{
    if (vFEWebService == null)
      _initVFEWebServiceProxy();
    return vFEWebService.eliminarRegistrarDocumento(peticion);
  }
  
  public es.novasoft.castellon.vfe.ws.RespuestaRegistro registrarDocumento(es.novasoft.castellon.vfe.ws.PeticionRegistro peticion) throws java.rmi.RemoteException{
    if (vFEWebService == null)
      _initVFEWebServiceProxy();
    return vFEWebService.registrarDocumento(peticion);
  }
  
  public es.novasoft.castellon.vfe.ws.RespuestaDocumentoCSV obtenerDocumentoCSV(es.novasoft.castellon.vfe.ws.PeticionDocumentoCSV peticion) throws java.rmi.RemoteException{
    if (vFEWebService == null)
      _initVFEWebServiceProxy();
    return vFEWebService.obtenerDocumentoCSV(peticion);
  }
  
  
}