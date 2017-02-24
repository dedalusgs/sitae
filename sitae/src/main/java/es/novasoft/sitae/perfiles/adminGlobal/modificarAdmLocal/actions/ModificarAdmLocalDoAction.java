package es.novasoft.sitae.perfiles.adminGlobal.modificarAdmLocal.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.adminGlobal.modificarAdmLocal.forms.ModificarAdmLocalForm;

public class ModificarAdmLocalDoAction extends ActionBase {

	UsuarioService usuarioService = (UsuarioService) Factory
			.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

	RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory
			.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Usuario usuario = new Usuario();
		ModificarAdmLocalForm formulario = (ModificarAdmLocalForm) form;

		try {

			List listaUsuarios = new ArrayList();
			usuario = formulario.getUsuario();
			// OBTENEMOS DE LA SESSION EL DNI QUE TENIAMOS ANTERIORMENTE POR SI
			// SE HA CAMBIADO
			String dni = (String) request.getSession().getAttribute("DNI");

			// COMPROBAMOS QUE MODIFICAMOS EL DNI, EN CUYO CASO TAMBIEN TENEMOS
			// QUE MODIFICAR LA TABLA REL_USU_ORG ...

			String administradorGlobal = (String) request
					.getParameter("administradorGlobal");

			List listaRelacionUsuOrgCentroPerf = relacionUsuOrgCentroPerfService
					.findByUsuPerf(dni, String.valueOf(Constantes.ADMIN_GLOBAL));

			boolean esAdminstrador = false;

			if (!listaRelacionUsuOrgCentroPerf.isEmpty()) {
				esAdminstrador = true;
			}

			if ((administradorGlobal == null || administradorGlobal.equals(""))
					&& esAdminstrador) {
				if (!listaRelacionUsuOrgCentroPerf.isEmpty()) {
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) listaRelacionUsuOrgCentroPerf
							.get(0);
					relacionUsuOrgCentroPerfService
							.delete(relacionUsuOrgCentroPerf);
				}
			}

			if ((administradorGlobal != null && !administradorGlobal.equals(""))
					&& !esAdminstrador) {
				RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
				String cif = (String) request.getSession().getAttribute("cif");
				relacionUsuOrgCentroPerf.setOrganismo(cif);
				relacionUsuOrgCentroPerf.setUsuario(usuario.getNumDocumento());
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(new Integer(Constantes.ADMIN_GLOBAL));
				relacionUsuOrgCentroPerf.setPerfil(perfil);
				relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);

			}

			if (!dni.equals(usuario.getNumDocumento())) {
				listaUsuarios = relacionUsuOrgCentroPerfService
						.findByUsuario(dni);
				Iterator it = listaUsuarios.iterator();
				while (it.hasNext()) {
					RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = (RelacionUsuOrgCentroPerf) it
							.next();
					relacionUsuOrgCentroPerf.setUsuario(usuario
							.getNumDocumento());
					relacionUsuOrgCentroPerfService
							.attachDirty(relacionUsuOrgCentroPerf);
				}
			}

			usuarioService.attachDirty(usuario);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarOrganismoDoAction", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
