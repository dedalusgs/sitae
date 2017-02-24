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
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

import es.accv.fandango.services.CertificacionPublicacion.CertificacionPublicacionWSClient;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.ws.fandango.FandangoClient;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarInformeRevision extends DownloadAction {

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String certificadoDiligencia = "";

		EdictoService edictoService = (EdictoService) Factory
				.getBean(ServiceConstants.EDICTO_BEAN_NAME);

		String codigo = request.getParameter("codigo");

		Edicto edicto = (Edicto) edictoService.findByCodigo(codigo).get(0);

		if (edicto != null
				&& edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {
			String urlCertificado = edicto.getUrl();

			FandangoClient client = (FandangoClient) Factory
			.getBean(ServiceConstants.FANDANGO_BEAN_NAME);
			try {

				certificadoDiligencia = client
						.getPDFInformeRevisiones(urlCertificado);

				byte[] buf = new sun.misc.BASE64Decoder()
						.decodeBuffer(certificadoDiligencia);

				String contentType = "application/pdf";

				response.setHeader("Cache-Control", "cache");
				response.setHeader("Pragma", "cache");

				response.setHeader("Content-Disposition",
						("attachment;filename=\"Informe Revisiones - " + edicto
								.getCodigo())
								+ ".pdf\"");

				int longitud = buf.length;
//
//				// especifico el tamaño
				response.setContentLength(longitud);

				return new ByteArrayStreamInfo(contentType, buf);

			} catch (RemoteException e) {
				e.printStackTrace();
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
}
