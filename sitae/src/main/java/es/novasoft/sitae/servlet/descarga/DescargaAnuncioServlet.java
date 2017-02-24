package es.novasoft.sitae.servlet.descarga;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;

import alfresco.sigex.castellon.ContentDocumentRequest;
import alfresco.sigex.castellon.ContentDocumentResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.EdictoService;

public class DescargaAnuncioServlet extends HttpServlet {

	public DescargaAnuncioServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

			String codigo = request.getParameter("codigo");
			if (codigo.endsWith(".pdf")) {
				codigo = codigo.substring(0, codigo.length() - 4);
			}

			List listaEdictos = edictoService.findByCodigo(codigo);

			if (listaEdictos != null && !listaEdictos.isEmpty()) {
				Edicto edicto = (Edicto) listaEdictos.get(0);

				if (edicto != null && edicto.getEstado().getIdEstado() != Constantes.RETIRADO) {

					byte[] pdf_adjunto = edicto.getPdfAdjunto();

					String documentUuid = new String(pdf_adjunto, "ISO8859-1");
					String endpoint = Constantes.getPropiedad("endPointALFRESCO");

					IMuleRDWSServiceLocator locator = new IMuleRDWSServiceLocator();
					IMuleRDWS WS = locator.getIMuleRDWSPort(new URL(endpoint));
					ContentDocumentRequest contentDocumentRequest = new ContentDocumentRequest();
					ContentDocumentResponse contentDocumentResponse = new ContentDocumentResponse();
					contentDocumentRequest.setMimeType("pdf");
					contentDocumentRequest.setName(edicto.getCodigo());
					contentDocumentRequest.setContent(edicto.getPdfAdjunto());
					contentDocumentResponse = WS.getDocumentRDWS(documentUuid);
					pdf_adjunto = Base64.decode(contentDocumentResponse.getContent());

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

					response.setContentLength(longitud);
					response.setContentType(contentType);
					response.getOutputStream().write(pdf_adjunto);
					response.getOutputStream().flush();
				}
			}
		} catch (ServiceException e) {

			e.printStackTrace();
		} catch (Base64DecodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (javax.xml.rpc.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
