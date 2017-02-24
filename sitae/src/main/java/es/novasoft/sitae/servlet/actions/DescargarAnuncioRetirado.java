/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: InitDoAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.servlet.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;

import alfresco.sigex.castellon.ContentDocumentRequest;
import alfresco.sigex.castellon.ContentDocumentResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarAnuncioRetirado extends DownloadAction {
	private final FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

		String codigo = request.getParameter("codigo");

		Edicto edicto = (Edicto) edictoService.findByCodigo(codigo).get(0);

		if (edicto != null && edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {

			FileService fileService = this.factoryFileServices.getService(edicto);

			byte[] pdf_adjunto = fileService.obtenerFichero(edicto.getPdfAdjuntoString());

			String contentType = "application/pdf";

			response.setHeader("Cache-Control", "cache");
			response.setHeader("Pragma", "cache");

			response.setHeader("Content-Disposition", ("attachment;filename=\"" + edicto.getCodigo() + ".pdf\""));

			int longitud = pdf_adjunto.length;

			// especifico el tamaño
			response.setContentLength(longitud);

			return new ByteArrayStreamInfo(contentType, pdf_adjunto);

		}
		return null;
	}

	protected class ByteArrayStreamInfo implements StreamInfo {

		protected String contentType;
		protected byte[] bytes;

		public ByteArrayStreamInfo(String contentType, byte[] bytes) {
			this.contentType = contentType;
			this.bytes = bytes;
		}

		public String getContentType() {
			return contentType;
		}

		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(bytes);
		}
	}
}
