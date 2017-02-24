package afirmaws.services.FirmaServidor;

public class FirmaProxy implements afirmaws.services.FirmaServidor.Firma {
  private String _endpoint = null;
  private afirmaws.services.FirmaServidor.Firma firma = null;
  
  public FirmaProxy() {
    _initFirmaProxy();
  }
  
  public FirmaProxy(String endpoint) {
    _endpoint = endpoint;
    _initFirmaProxy();
  }
  
  private void _initFirmaProxy() {
    try {
      firma = (new afirmaws.services.FirmaServidor.FirmaServiceLocator()).getFirmaServidor();
      if (firma != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)firma)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)firma)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (firma != null)
      ((javax.xml.rpc.Stub)firma)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public afirmaws.services.FirmaServidor.Firma getFirma() {
    if (firma == null)
      _initFirmaProxy();
    return firma;
  }
  
  public java.lang.String firmaServidor(java.lang.String in0) throws java.rmi.RemoteException{
    if (firma == null)
      _initFirmaProxy();
    return firma.firmaServidor(in0);
  }
  
  
}