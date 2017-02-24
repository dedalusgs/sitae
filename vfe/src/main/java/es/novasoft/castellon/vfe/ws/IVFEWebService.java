package es.novasoft.castellon.vfe.ws;

import java.rmi.Remote;

public interface IVFEWebService extends Remote {

	public RespuestaRegistro registrarDocumento(PeticionRegistro peticion);

	public RespuestaDocumentoCSV obtenerDocumentoCSV(PeticionDocumentoCSV peticion);

	public RespuestaRegistro eliminarRegistrarDocumento(PeticionRegistro peticion);

}
