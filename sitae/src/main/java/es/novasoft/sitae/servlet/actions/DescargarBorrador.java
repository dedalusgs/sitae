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
import java.util.Iterator;
import java.util.List;

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
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.forms.LoginCertificadoForm;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarBorrador extends DownloadAction {
	private final FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

		UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

		String codigo = request.getParameter("id");

		int id = Integer.parseInt(codigo);

		Edicto edicto = edictoService.findById(id);

		LoginCertificadoForm loginForm = (LoginCertificadoForm) request.getSession().getAttribute("LoginCertificadoForm");

		if (edicto != null && loginForm != null && comprobarPermisos(loginForm, edicto)) {
			FileService fileService = this.factoryFileServices.getService(edicto);

			byte[] pdf_adjunto = fileService.obtenerFichero(edicto.getPdfAdjuntoString());

			String contentType = "application/pdf";

			response.setHeader("Cache-Control", "cache");
			response.setHeader("Pragma", "cache");

			response.setHeader("Content-Disposition", ("attachment;filename=\"" + edicto.getNombrePdfAdjunto() + "\""));

			int longitud = pdf_adjunto.length;

			// especifico el tamaño
			response.setContentLength(longitud);

			return new ByteArrayStreamInfo(contentType, pdf_adjunto);
		}

		return null;
	}

	private boolean comprobarPermisos(LoginCertificadoForm loginForm, Edicto edicto) throws es.novasoft.comun.exceptions.ServiceException {
		// TODO Auto-generated method stub

		Estado estado = edicto.getEstado();
		Boolean permisosOk = false;
		switch (estado.getIdEstado()) {
		case Constantes.INICIADO:

			// Sólo puede acceder el redactor del Edicto
			if (edicto.getRedactor() != null && edicto.getRedactor().getIdUsuario().equals(loginForm.getUsuario().getIdUsuario())) {
				permisosOk = true;
			}
			break;
		case Constantes.PENDIENTE_VALIDACION:
		case Constantes.RECHAZADO_FIRMA:
		case Constantes.REVISION:
		case Constantes.PENDIENTE_FIRMA:
		case Constantes.RECHAZADO:
		case Constantes.PENDIENTE_PUBLICACION:
			// Puede acceder el redactor, los publicadores del área y los
			// adminLocales si el redactor es externo

			if (loginForm.isAdministradorLocal() && !permisosOk) {
				permisosOk = true;
			}

			if (edicto.getRedactor() != null && edicto.getRedactor().getIdUsuario().equals(loginForm.getUsuario().getIdUsuario())) {
				permisosOk = true;
			}

			if (edicto.getCentro() != null && !permisosOk) {
				RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

				List<RelacionUsuOrgCentroPerf> listaRelacion = relacionUsuOrgCentroPerfService.findByUsuario(loginForm.getUsuario().getNumDocumento());

				Iterator it = listaRelacion.iterator();

				while (it.hasNext() && !permisosOk) {
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it.next();
					if (relacionUsuOrgCentroPerf.getCentroProcedencia().getIdCentro().equals(edicto.getCentro().getIdCentro())) {
						permisosOk = true;
					}

				}
			}

			break;
		}
		return permisosOk;
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
