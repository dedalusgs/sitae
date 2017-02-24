/**
 * ValidacionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afirmaws.services.ValidarCertificado;

public interface ValidacionService extends javax.xml.rpc.Service {
    public java.lang.String getValidarCertificadoAddress();

    public afirmaws.services.ValidarCertificado.Validacion getValidarCertificado() throws javax.xml.rpc.ServiceException;

    public afirmaws.services.ValidarCertificado.Validacion getValidarCertificado(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
