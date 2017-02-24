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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarAnuncio extends DownloadAction {
	private final FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		Log log = LogFactory.getFactory().getInstance(DescargarAnuncio.class);
		String codigo = request.getParameter("codigo");
		if (codigo.endsWith(".pdf")) {
			codigo = codigo.substring(0, codigo.length() - 4);
		}
		log.info("Se ha solicita la descarga del anuncio con código: " + codigo);
		List listaEdictos = edictoService.findByCodigo(codigo);

		if (listaEdictos != null && !listaEdictos.isEmpty()) {
			Edicto edicto = (Edicto) listaEdictos.get(0);

			if (edicto != null && edicto.getEstado().getIdEstado() != Constantes.RETIRADO) {

				FileService fileService = this.factoryFileServices.getService(edicto);

				byte[] pdf_adjunto = fileService.obtenerFichero(edicto.getPdfAdjuntoString());

				log.info("Anuncio con código: " + codigo + " recuperado con exito");
				String contentType = "application/pdf";
				response.setContentType(contentType);
				response.setHeader("Pragma", "public");
				response.setHeader("Cache-Control", "max-age=0");
				response.setHeader("Content-disposition", "attachment; filename=\"" + edicto.getCodigo() + ".pdf" + "\"");

				// response.setHeader("Cache-Control", "no-cache");
				// response.setHeader("Pragma", "no-cache");

				// response.setHeader("Content-Disposition",
				// ("inline;filename=\"" + edicto.getCodigo() + ".pdf\""));

				int longitud = pdf_adjunto.length;

				// especifico el tamaño
				// response.setContentLength(longitud);

				return new ByteArrayStreamInfo(contentType, pdf_adjunto);

			}
		}
		String f = ActionBase.ERROR_KEY;
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

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		StreamInfo info = getStreamInfo(mapping, form, request, response);
		String contentType = info.getContentType();
		InputStream stream = info.getInputStream();

		try {
			response.setContentType(contentType);
			copy(stream, response.getOutputStream());
		} finally {
			if (stream != null) {
				stream.close();
			}
			response.getOutputStream().flush();
			response.getOutputStream().close();

		}

		// Tell Struts that we are done with the response.
		return null;
	}
}
