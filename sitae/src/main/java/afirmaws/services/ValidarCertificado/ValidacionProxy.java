package afirmaws.services.ValidarCertificado;

public class ValidacionProxy implements afirmaws.services.ValidarCertificado.Validacion {
  private String _endpoint = null;
  private afirmaws.services.ValidarCertificado.Validacion validacion = null;
  
  public ValidacionProxy() {
    _initValidacionProxy();
  }
  
  public ValidacionProxy(String endpoint) {
    _endpoint = endpoint;
    _initValidacionProxy();
  }
  
  private void _initValidacionProxy() {
    try {
      validacion = (new afirmaws.services.ValidarCertificado.ValidacionServiceLocator()).getValidarCertificado();
      if (validacion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)validacion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)validacion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (validacion != null)
      ((javax.xml.rpc.Stub)validacion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public afirmaws.services.ValidarCertificado.Validacion getValidacion() {
    if (validacion == null)
      _initValidacionProxy();
    return validacion;
  }
  
  public java.lang.String validarCertificado(java.lang.String in0) throws java.rmi.RemoteException{
    if (validacion == null)
      _initValidacionProxy();
    return validacion.validarCertificado(in0);
  }
  
  
}