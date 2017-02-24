package afirmaws.services.AlmacenarDocumento;

public class CustodiaProxy implements afirmaws.services.AlmacenarDocumento.Custodia {
  private String _endpoint = null;
  private afirmaws.services.AlmacenarDocumento.Custodia custodia = null;
  
  public CustodiaProxy() {
    _initCustodiaProxy();
  }
  
  public CustodiaProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustodiaProxy();
  }
  
  private void _initCustodiaProxy() {
    try {
      custodia = (new afirmaws.services.AlmacenarDocumento.CustodiaServiceLocator()).getAlmacenarDocumento();
      if (custodia != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)custodia)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)custodia)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (custodia != null)
      ((javax.xml.rpc.Stub)custodia)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public afirmaws.services.AlmacenarDocumento.Custodia getCustodia() {
    if (custodia == null)
      _initCustodiaProxy();
    return custodia;
  }
  
  public java.lang.String almacenarDocumento(java.lang.String in0) throws java.rmi.RemoteException{
    if (custodia == null)
      _initCustodiaProxy();
    return custodia.almacenarDocumento(in0);
  }
  
  
}