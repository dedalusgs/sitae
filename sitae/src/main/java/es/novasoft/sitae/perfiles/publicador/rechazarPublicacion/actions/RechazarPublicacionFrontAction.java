package es.novasoft.sitae.perfiles.publicador.rechazarPublicacion.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.publicador.muestraInformacionEdicto.forms.MuestraInformacionEdictoForm;
import es.novasoft.sitae.perfiles.publicador.rechazarPublicacion.forms.RechazarPublicacionForm;

public class RechazarPublicacionFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			UsuarioAutentificado ciudadano = null;

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver"); }
			 * 
			 * LOGGER.debug("INICIO DEL METODO"); //Información que se obtiene
			 * del certificado digital //Se comprueba que se ha accedido de
			 * manera correcta Utils util = new Utils(); if
			 * (!util.usuarioAutenticado(request)){ return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); } else{
			 * //Información que se obtiene del certificado digital ciudadano =
			 * obtenerUsuario(request);
			 * 
			 * if(ciudadano==null) return
			 * mapping.findForward(Constantes.FORWARD_ERROR_ACCESO); }
			 */

			RechazarPublicacionForm formulario = (RechazarPublicacionForm) form;
			MuestraInformacionEdictoForm formulario2 = (MuestraInformacionEdictoForm) request
					.getSession().getAttribute("MuestraInformacionEdictoForm");

			Edicto edicto = new Edicto();

			if (request.getAttribute("numeroErrores") == null) {

				// Obtengo el id del edicto
				String idEdicto = (String) request
						.getParameter("idEdictoSeleccionado");
				if (idEdicto == null) {
					idEdicto = formulario2.getIdEdicto();
				}

				formulario.setIdEdicto(idEdicto);

			}

			request.setAttribute("RechazarPublicacionForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en RechazarPublicacionFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
