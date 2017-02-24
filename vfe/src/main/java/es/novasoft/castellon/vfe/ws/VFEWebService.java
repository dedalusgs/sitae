package es.novasoft.castellon.vfe.ws;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.castellon.vfe.business.files.FactoryFileService;
import es.novasoft.castellon.vfe.business.files.FileService;
import es.novasoft.castellon.vfe.business.files.FileServiceException;
import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.objects.RegistroDocumento;
import es.novasoft.castellon.vfe.business.objects.Usuario;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.castellon.vfe.business.services.interfaz.RegistroDocumentoService;
import es.novasoft.castellon.vfe.business.services.interfaz.UsuarioService;
import es.novasoft.castellon.vfe.csv.GeneradorCSV;
import es.novasoft.castellon.vfe.csv.GeneradorPDFcsv;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;

public class VFEWebService implements IVFEWebService {
	private static final Log	log	= LogFactory.getLog(VFEWebService.class);
	
	public VFEWebService() {
		super();
	}
	
	private OrganismoService	     organismoService	         = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	private UsuarioService	         usuarioService	             = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	private FactoryFileService	     factoryFileServices	     = (FactoryFileService) Factory.getBean("FactoryFileServices");
	private RegistroDocumentoService	registroDocumentoService	= (RegistroDocumentoService) Factory.getBean("RegistroDocumentoService");
	
	public RespuestaRegistro registrarDocumento(PeticionRegistro peticion) {
		log.info("Peticion de Registro Iniciada");
		RespuestaRegistro respuesta = new RespuestaRegistro();
		
		Usuario usuario = null;
		try {
			usuario = usuarioService.findFromUser(peticion.getUsuario());
		} catch (ServiceException e1) {
			log.error(e1);
			respuesta.setCodigoERROR("ERR_09");
			respuesta.setMensajeError("Error, buscando usuario en BBDD");
			return respuesta;
		}
		
		if (usuario == null) {
			respuesta.setCodigoERROR("ERR_01");
			respuesta.setMensajeError("Error, el usuario indicado no existe");
			return respuesta;
		}
		if (!usuario.getPassword().equals(peticion.getContrasenia())) {
			respuesta.setCodigoERROR("ERR_01");
			respuesta.setMensajeError("Error, el usuario indicado no existe");
			return respuesta;
		}
		if (peticion.getIdDocumento() == null || peticion.getIdDocumento().equals("")) {
			respuesta.setCodigoERROR("ERR_02");
			respuesta.setMensajeError("Error, nNo se ha introducido identificador del documento principal");
			return respuesta;
		}
		
		FileService fileService = this.factoryFileServices.getService(peticion.getIdDocumento());
		if (fileService == null) {
			respuesta.setCodigoERROR("ERR_02");
			respuesta.setMensajeError("Error, no se puede determinar el lugar donde se almacena el documento a registrar");
			return respuesta;
		}
		try {
			log.info("Obtener documento ID " + peticion.getIdDocumento());
			byte[] ficheroFirmado = fileService.obtenerFichero(peticion.getIdDocumento());
			if (ficheroFirmado == null) {
				respuesta.setCodigoERROR("ERR_03");
				respuesta.setMensajeError("Error, no se puede obtener el documento indicado. Se anulará el registro del mismo");
				return respuesta;
			}
			log.info("Obtener documento Firma " + peticion.getIdFirma());
			byte[] firma = fileService.obtenerFichero(peticion.getIdFirma());
			if (firma == null) {
				respuesta.setCodigoERROR("ERR_04");
				respuesta.setMensajeError("Error, no se puede obtener el documento de firma. Se anulará el registro del documento");
				return respuesta;
			}
		} catch (FileServiceException e) {
			log.error("Error de lectura en el sistema de almacenamiento", e);
			respuesta.setCodigoERROR("ERR_11");
			respuesta.setMensajeError("Error, no se puede obtener documentos. Sistema externo no accesible. Se anulará el registro del documento");
			return respuesta;
		}
		if (peticion.getIdMunicipio() == null || peticion.getIdMunicipio().equals("")) {
			respuesta.setCodigoERROR("ERR_05");
			respuesta.setMensajeError("Error, No se ha especificado identificador de ayuntamiento. Se anulará el registro del documento");
			return respuesta;
			
		}
		List<Organismo> organismos;
		try {
			organismos = organismoService.findByCodigo(peticion.getIdMunicipio());
		} catch (ServiceException e1) {
			log.error(e1);
			respuesta.setCodigoERROR("ERR_09");
			respuesta.setMensajeError("Error, buscando organsimo en BBDD");
			return respuesta;
		}
		
		if (organismos.isEmpty()) {
			respuesta.setCodigoERROR("ERR_06");
			respuesta.setMensajeError("Error, El codigo de ayuntamiento indicado no existe. Se anulará el registro del documento");
			return respuesta;
		}
		if (peticion.getNombreDocumento() == null || peticion.getNombreDocumento().equals("")) {
			respuesta.setCodigoERROR("ERR_07");
			respuesta.setMensajeError("Error, No se ha especificado nombre del documento a registrar");
			return respuesta;
		}
		if (peticion.getNombreFirma() == null || peticion.getNombreFirma().equals("")) {
			respuesta.setCodigoERROR("ERR_08");
			respuesta.setMensajeError("Error, No se ha especificado nombre del documento de firma a registrar");
			return respuesta;
		}
		log.info("Creando registro " + peticion.getIdDocumento());
		RegistroDocumento registro = new RegistroDocumento();
		registro.setRutaFichero(peticion.getIdDocumento());
		registro.setRutaFirma(peticion.getIdFirma());
		registro.setFechaCreacion(new Date());
		registro.setNombreFichero(peticion.getNombreDocumento());
		registro.setNombreFirma(peticion.getNombreFirma());
		registro.setTipoFirma(peticion.getTipoFirma());
		registro.setCodAyto(peticion.getIdMunicipio());
		if (peticion.getCsv() == null || peticion.getCsv().equals("")) {
			String codigoCSV;
			try {
				
				codigoCSV = GeneradorCSV.mkCSV(peticion.getIdDocumento(), peticion.getNombreDocumento(), null);
				log.info("CSV Generado ");
			} catch (Exception e) {
				respuesta.setCodigoERROR("ERR_12");
				respuesta.setMensajeError("Error generando codigo CSV");
				log.error("Error generando codigo CSV", e);
				return respuesta;
			}
			registro.setCsv(codigoCSV);
		} else {
			
			registro.setCsv(peticion.getCsv());
		}
		RegistroDocumentoService registroDocumentoService = (RegistroDocumentoService) Factory.getBean("RegistroDocumentoService");
		
		try {
			registroDocumentoService.save(registro);
			log.info("Regristo Guardado ");
		} catch (ServiceException e) {
			respuesta.setCodigoERROR("ERR_13");
			respuesta.setMensajeError("Error al almacener registro CSV");
			log.error("Error al almacener registro CSV", e);
			return respuesta;
		}
		
		respuesta.setCsv(registro.getCsv());
		respuesta.setCodigoERROR("OK");
		return respuesta;
	}
	
	public RespuestaDocumentoCSV obtenerDocumentoCSV(PeticionDocumentoCSV peticion) {
		
		log.info("Peticion de Registro Iniciada");
		RespuestaDocumentoCSV respuesta = new RespuestaDocumentoCSV();
		FileService fileService = this.factoryFileServices.getService(peticion.getIdDocumento());
		
		Usuario usuario = null;
		try {
			usuario = usuarioService.findFromUser(peticion.getUsuario());
		} catch (ServiceException e1) {
			log.error(e1);
			respuesta.setCodigoERROR("ERR_09");
			respuesta.setMensajeError("Error, buscando usuario en BBDD");
			return respuesta;
		}
		
		if (usuario == null) {
			respuesta.setCodigoERROR("ERR_01");
			respuesta.setMensajeError("Error, el usuario indicado no existe");
			return respuesta;
		}
		if (!usuario.getPassword().equals(peticion.getContrasenia())) {
			respuesta.setCodigoERROR("ERR_01");
			respuesta.setMensajeError("Error, la contraseña es incorrecta");
			return respuesta;
		}
		RegistroDocumento registro = null;
		if (peticion.getCsv() == null || peticion.getCsv().equals("")) {
			if (peticion.getIdDocumento() == null || peticion.getIdDocumento().equalsIgnoreCase("")) {
				respuesta.setCodigoERROR("ERR_02");
				respuesta.setMensajeError("Error, no se ha indicado código CSV, ni identificador o ruta del documento");
				return respuesta;
			} else {
				registro = registroDocumentoService.findRegistroDocumentoByIdRuta(peticion.getIdDocumento());
				if (registro == null) {
					respuesta.setCodigoERROR("ERR_06");
					respuesta.setMensajeError("Error, no se encuentra el documento indicado");
					return respuesta;
				}
			}
		} else {
			registro = registroDocumentoService.findRegistroDocumentoByCSV(peticion.getCsv());
			if (registro == null) {
				respuesta.setCodigoERROR("ERR_06");
				respuesta.setMensajeError("Error, no se encuentra el código CSV indicado");
				return respuesta;
				
			}
		}
		if (peticion.getIdAyto() == null || peticion.getIdAyto().equals("")) {
			respuesta.setCodigoERROR("ERR_03");
			respuesta.setMensajeError("Error, no se ha indicado código de Ayto");
			return respuesta;
		}
		
		if (!registro.getCodAyto().equalsIgnoreCase(peticion.getIdAyto())) {
			respuesta.setCodigoERROR("ERR_07");
			respuesta.setMensajeError("Error, el documento solicitado no concuerda con el ayuntamiento indicado");
			return respuesta;
			
		}
		List<Organismo> organismos;
		try {
			organismos = organismoService.findByCodigo(peticion.getIdAyto());
		} catch (ServiceException e1) {
			log.error(e1);
			respuesta.setCodigoERROR("ERR_08");
			respuesta.setMensajeError("Error, buscando organsimo en BBDD");
			return respuesta;
		}
		Organismo org = null;
		if (organismos.isEmpty()) {
			respuesta.setCodigoERROR("ERR_09");
			respuesta.setMensajeError("Error, El codigo de ayuntamiento indicado no existe. Se anulará el registro del documento");
			return respuesta;
		} else {
			org = organismos.get(0);
		}
		
		File documento;
		try {
			documento = fileService.obtenerFicheroFile(registro.getRutaFichero());
		} catch (FileServiceException e) {
			respuesta.setCodigoERROR("ERR_10");
			respuesta.setMensajeError("Error, Se ha producido un error obteniendo fichero");
			return respuesta;
		}
		
		byte[] documentoCsv;
		try {
			documentoCsv = GeneradorPDFcsv.pdfShrinkAddCsv(documento, registro.getCsv(), "https://" + org.getDominio() + "/vfe");
		} catch (Exception e) {
			respuesta.setCodigoERROR("ERR_11");
			respuesta.setMensajeError("Error, al generar el documento con CSV");
			return respuesta;
		}
		
		if (documentoCsv == null) {
			respuesta.setCodigoERROR("ERR_12");
			respuesta.setMensajeError("Error, No se ha podido al generar el documento con CSV");
			return respuesta;
			
		}
		
		respuesta.setDocumento(documentoCsv);
		respuesta.setCodigoERROR("OK");
		return respuesta;
		
	}
	
	public RespuestaRegistro eliminarRegistrarDocumento(PeticionRegistro peticion) {
		
		return null;
	}
	
}
