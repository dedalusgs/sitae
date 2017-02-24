package es.novasoft.castellon.vfe.ws;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.sitae.business.objects.Edicto;

public class VFEUtil {
	static private Log	log	= LogFactory.getLog(VFEUtil.class);
	
	public VFEUtil() {
		super();
		
	}
	
	static public Boolean registrarDiligencia(Edicto edicto, String csv) {
		String rutaServiceVFE = Constantes.getPropiedad("ruta.ws.vfe");
		VFEWebServiceProxy service = new VFEWebServiceProxy(rutaServiceVFE);
		PeticionRegistro registro = new PeticionRegistro();
		if (edicto.getDiligencia() == null || edicto.getFirmaDiligencia() == null) {
			return false;
		}
		registro.setIdDocumento(edicto.getDiligenciaString());
		registro.setNombreDocumento("Diligencia_" + edicto.getCodigo() + ".pdf");
		registro.setIdFirma(edicto.getFirmaDiligenciaString());
		registro.setNombreFirma("firma_diligencia_" + edicto.getCodigo() + ".pdf");
		registro.setIdMunicipio(edicto.getOrganismo().getCodigo());
		registro.setTipoDocumento("DILIGENCIA");
		registro.setTipoFirma(edicto.getTipoFirmaDiligencia());
		if (csv != null) {
			registro.setCsv(csv);
		}
		
		String pass = Constantes.getPropiedad("password.vfe");
		String usuario = Constantes.getPropiedad("usuario.vfe");
		registro.setContrasenia(pass);
		registro.setUsuario(usuario);
		RespuestaRegistro respuesta = null;
		try {
			respuesta = service.registrarDocumento(registro);
		} catch (RemoteException e) {
			log.error("Error registrando diligencia. ", e);
			return false;
		}
		if (respuesta == null) {
			log.error("Error la respuesta del registro de la diligencia es null.");
			return false;
		}
		if (respuesta.getCodigoERROR().equals("OK")) {
			String csvRespuesta = respuesta.getCsv();
			log.info("Registro de Diligencia " + edicto.getCodigo() + " Correctamente. CSV:" + csvRespuesta);
			return true;
		} else {
			log.error("Se ha recibido un mensaje de Error. " + respuesta.getMensajeError());
			return false;
		}
		
	}
	
	public static byte[] obtenerDiligenciaConPie(Edicto edicto) {
		String rutaServiceVFE = Constantes.getPropiedad("ruta.ws.vfe");
		VFEWebServiceProxy service = new VFEWebServiceProxy(rutaServiceVFE);
		PeticionDocumentoCSV peticion = new PeticionDocumentoCSV();
		String pass = Constantes.getPropiedad("password.vfe");
		String usuario = Constantes.getPropiedad("usuario.vfe");
		peticion.setContrasenia(pass);
		peticion.setUsuario(usuario);
		peticion.setIdDocumento(edicto.getDiligenciaString());
		peticion.setIdAyto(edicto.getOrganismo().getCodigo());
		RespuestaDocumentoCSV respuesta = null;
		try {
			respuesta = service.obtenerDocumentoCSV(peticion);
		} catch (RemoteException e) {
			log.error("Error obteniendo diligencia con csv ", e);
			return null;
		}
		if (respuesta == null) {
			log.error("Error la respuesta de la obtención del documento con CSV.");
			return null;
		}
		if (respuesta.getCodigoERROR().equals("OK")) {
			byte[] documento = respuesta.getDocumento();
			log.info("Documentp con CSV de Diligencia " + edicto.getCodigo() + " obtenido correctamente");
			return documento;
		} else {
			log.error("Se ha recibido un mensaje de Error. " + respuesta.getMensajeError());
			return null;
		}
		
	}
}
