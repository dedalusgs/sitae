package es.novasoft.sitae.perfiles.publicador.darBajaPublicacion.actions;

import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import alfresco.sigex.castellon.ContentDocumentRequest;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.comun.utils.UtilPublicar;
import es.novasoft.sitae.comun.utils.UtilRedesSociales;
import es.novasoft.sitae.perfiles.publicador.darBajaPublicacion.forms.DarBajaPublicacionForm;

public class DarBajaPublicacionDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	UsuarioService usuarioService = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	EstadoService estadoService = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		DarBajaPublicacionForm formulario = (DarBajaPublicacionForm) form;

		// Recupero de la session el cif del organismo para obtener los centros
		// de procedencia y los tipos de edictos
		String cifOrganismo = (String) request.getSession().getAttribute("cif");

		Organismo organismo = (Organismo) organismoService.findByCif(cifOrganismo).get(0);

		Edicto edicto = new Edicto();

		String s = ActionBase.ERROR_KEY;

		try {

			String idEdicto = formulario.getIdEdicto();

			if (idEdicto != null && !idEdicto.equals("")) {

				edicto = edictoService.findById(Integer.valueOf(idEdicto));

				if (edicto.getEstado().getIdEstado().equals(Constantes.PUBLICADO)) {

					boolean bajaCorrecta = UtilPublicar.bajaPublicacion(edicto);

					if (bajaCorrecta) {
						String dni = (String) request.getSession().getAttribute("nif");
						Usuario usuario = (Usuario) usuarioService.findByNumeroDocumento(dni).get(0);
						edicto.setDespublicador(usuario);
						// Guardar
						edictoService.attachDirty(edicto);
						log.info("El anuncio se ha dado de baja en BBDD.");
						if (!bajaCorrecta) {
							log.error("Se ha producido un error al realizar la baja en Fandango. Será necesario realizar la baja del certificado manualmente desde el panel de administración de  Fandango.");
							log.info("El anuncio se ha dado de baja aunque ha fallado la baja de Fandango.");
							UtilPublicar.notificarErrorDuranteBaja(edicto, "No se ha podido realizar la baja del certificado de exposición de Fandango. \n No obstante el servicio se ha dado de baja en el sistema por lo que habrá que dar la baja del certificado a mano desde el panel de administración de Fandango.");
							UtilPublicar.notificarBajaPublicacion(edicto, formulario.getMotivos(), formulario.getMotivosVa());
							s = ActionBase.ERROR_KEY_2;
						} else {

							log.info("La baja se del anuncio se ha realizado correctamente. " + edicto.getCodigo());
							UtilPublicar.notificarBajaPublicacion(edicto, formulario.getMotivos(), formulario.getMotivosVa());
							s = ActionBase.SUCCESS_KEY;
						}

					}

				} else {
					s = ActionBase.ERROR_KEY_2;
				}

			} else {
				s = ActionBase.ERROR_KEY_2;
			}

		} catch (Exception e) {
			s = ActionBase.ERROR_KEY_2;

			log.error("Error en DarBajaPublicacionDoAction", e);
			return forward(request, mapping, s);
		}

		return forward(request, mapping, s);
	}

}
