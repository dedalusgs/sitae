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

import alfresco.sigex.castellon.EdictDocumentsResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import es.novasoft.castellon.vfe.ws.VFEUtil;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.ws.csv.ClienteTramitacionMuleCSV;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarDiligencia extends DownloadAction {

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

		String codigo = request.getParameter("codigo");

		Edicto edicto = (Edicto) edictoService.findByCodigo(codigo).get(0);

		if (edicto != null && edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {
			byte[] pdfDiligencia = null;

			String endpoint = Constantes.getPropiedad("endPointALFRESCO");

			try {
				// FactoryFileService factoryFileServices = (FactoryFileService)
				// Factory.getBean("FactoryFileServices");
				// FileService fileService =
				// factoryFileServices.getService(edicto);
				// pdfDiligencia =
				// fileService.obtenerFichero(edicto.getDiligenciaString());
				pdfDiligencia = VFEUtil.obtenerDiligenciaConPie(edicto);

				// IMuleRDWSServiceLocator locator = new
				// IMuleRDWSServiceLocator();
				// IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
				//
				// EdictDocumentsResponse resDiligencia =
				// WS.getDiligenceEdictRDWS(edicto.getCodigo());
				// String uuidDiligencia =
				// resDiligencia.getArrayOfDocuments(0).getUuid();
				// System.out.println("uuidDiligencia :" + uuidDiligencia);
				// ClienteTramitacionMuleCSV clienteCSV = new
				// ClienteTramitacionMuleCSV();
				// pdfDiligencia =
				// clienteCSV.adjuntarDocumentacion(edicto.getCentro().getOrganismo().getCodigo(),
				// uuidDiligencia);
				String contentType = "application/pdf";

				response.setHeader("Cache-Control", "cache");
				response.setHeader("Pragma", "cache");

				response.setHeader("Content-Disposition", ("attachment;filename=\"Diligencia - " + edicto.getCodigo()) + ".pdf\"");

				int longitud = pdfDiligencia.length;
				//
				// // especifico el tamaño
				response.setContentLength(longitud);

				return new ByteArrayStreamInfo(contentType, pdfDiligencia);
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
			return this.contentType;
		}

		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(this.bytes);
		}
	}
}
