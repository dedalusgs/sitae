package es.novasoft.castellon.vfe.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

import es.novasoft.castellon.vfe.verificar.forms.VerificarForm;

/**
 * Servlet implementation class VerificarCodigoServlet
 */
public class DescargaDocumentoFirmadoServlet extends DownloadAction {
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(DescargaDocumentoFirmadoServlet.class);

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		VerificarForm formulario = (VerificarForm) form;
		// String codigo = request.getParameter("codigo");

		String nombreFichero = "firmado_" + formulario.getVerificador().getNombreFichero();

		byte[] pdf_adjunto = formulario.getVerificador().getDocumentoFirmado();

		String contentType = "application/pdf";

		response.setHeader("Cache-Control", "cache");
		response.setHeader("Pragma", "cache");

		response.setHeader("Content-Disposition", ("attachment;filename=\"" + nombreFichero + "\""));

		int longitud = pdf_adjunto.length;

		// especifico el tama�o
		response.setContentLength(longitud);

		return new ByteArrayStreamInfo(contentType, pdf_adjunto);
	}

	private static class ByteArrayStreamInfo implements StreamInfo {

		private String contentType;
		private byte[] bytes;

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
