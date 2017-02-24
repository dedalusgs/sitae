package es.novasoft.sitae.ws.csv;

import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.client.Stub;
import org.apache.commons.logging.Log;
import org.apache.xml.security.utils.Base64;
import org.opencms.main.CmsLog;

import com.cv.xaloc.gse.bl.wsappclient.type.ContentDocumentResponse;
import com.cv.xaloc.muleCSV.create.interfaces.CSVCreationWSDL;
import com.cv.xaloc.muleCSV.create.interfaces.CSVCreationWSDLServiceLocator;

import es.novasoft.comun.constantes.Constantes;

public class ClienteTramitacionMuleCSV {

	public ClienteTramitacionMuleCSV()
    {
        endpoint = null;
        timeout = null;
        secServer = null;
        secServer = new CSVCreationWSDLServiceLocator();
        endpoint = Constantes.getPropiedad("endpoint5");
        timeout = Constantes.getPropiedad("timeout5");

        if(endpoint != null)
            secServer.setCSVCreationWSDLPortEndpointAddress((new StringBuilder(String.valueOf(endpoint))).append("/CreateDocumentCsvSN").toString());
        if(timeout == null || timeout.equals(""))
            timeout = "45000";
    }

    public byte[] adjuntarDocumentacion(String entidadLocal, String idDocumento)
        throws Exception
    {
        String textoError = "";
        boolean hayError = false;
        byte resultado[] = (byte[])null;
        CSVCreationWSDL service = secServer.getCSVCreationWSDLPort(new URL(secServer.getCSVCreationWSDLPortAddress()));
        ((Stub)service).setTimeout(Integer.parseInt(timeout));
        try
        {
            ContentDocumentResponse contentDocumentResponse = service.createDocumentCsvSN(entidadLocal, idDocumento);
            if(contentDocumentResponse == null)
            {
                hayError = true;
                textoError = "Objeto xmlRespuesta devuelto por getDocumentRDWS es nulo.";
            } else
            if(contentDocumentResponse.getErrors() != null)
            {
                hayError = true;
                textoError = (new StringBuilder("Error al obtener el documento ")).append(idDocumento).toString();
                for(int i = 0; i < contentDocumentResponse.getErrors().length; i++)
                    textoError = (new StringBuilder(String.valueOf(textoError))).append("\n").append(contentDocumentResponse.getErrors()[i]).toString();

            } else
            {
                byte tmpDocumento[] = contentDocumentResponse.getContent();
                resultado = Base64.decode(tmpDocumento);
            }
        }
        catch(RemoteException e)
        {
            e.printStackTrace();
        }
        if(resultado != null && !hayError)
            return resultado;
        else
            throw new Exception(textoError);
    }

    private String endpoint;
    String timeout;
    CSVCreationWSDLServiceLocator secServer;
    private static final Log LOG = CmsLog.getLog(es.novasoft.sitae.ws.csv.ClienteTramitacionMuleCSV.class);

}
