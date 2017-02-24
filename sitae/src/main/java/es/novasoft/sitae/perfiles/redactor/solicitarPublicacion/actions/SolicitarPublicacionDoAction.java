package es.novasoft.sitae.perfiles.redactor.solicitarPublicacion.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;

import alfresco.sigex.castellon.ContentDocumentRequest;
import alfresco.sigex.castellon.ContentDocumentResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.UtilPublicar;

public class SolicitarPublicacionDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	EstadoService estadoService = (EstadoService) Factory
			.getBean(ServiceConstants.ESTADO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Edicto edicto = new Edicto();
		String s = ActionBase.ERROR_KEY;

		

			String idEdicto = (String) request
					.getParameter("idEdictoSeleccionado");

			if (idEdicto != null && !idEdicto.equals("")) {

				edicto = edictoService.findById(Integer.valueOf(idEdicto));


					Estado estado = estadoService
							.findById(Constantes.PENDIENTE_VALIDACION);
					if (edicto.getEstado().getIdEstado()
							.equals(Constantes.INICIADO)
							|| edicto.getEstado().getIdEstado().equals(
									Constantes.RECHAZADO)
							|| edicto.getEstado().getIdEstado().equals(
									Constantes.RECHAZADO_FIRMA)) {
						UtilPublicar.notificarSolicitudPublicacion(edicto);
						edicto.setEstado(estado);
						edictoService.attachDirty(edicto);
						s = ActionBase.SUCCESS_KEY;
						Date fechaActual = new Date();
						edicto.setFechaUltimaModificacion(fechaActual);
					}else s = ActionBase.ERROR_KEY_2;

			} else {
					s = ActionBase.ERROR_KEY_2;
			}

		return forward(request, mapping, s);
	}
}
