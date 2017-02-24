package es.novasoft.sitae.perfiles.publicador.actualizarEdictoPublicado.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.BackButtonUtil;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.utils.RellenaFormularioActionUtil;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.perfiles.publicador.actualizarEdictoPublicado.forms.ActualizarEdictoPublicadoForm;
import es.novasoft.sitae.perfiles.publicador.muestraInformacionEdicto.forms.MuestraInformacionEdictoForm;

public class ActualizarEdictoPublicadoFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

			RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);

			/*
			 * if (isCancelled(request)){ return mapping.findForward("Volver");
			 * }
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

			ActualizarEdictoPublicadoForm formulario = (ActualizarEdictoPublicadoForm) form;
			if (request.getAttribute("reload") != null && request.getAttribute("reload").equals("true")) {
				formulario = (ActualizarEdictoPublicadoForm) request.getSession().getAttribute("ActualizarEdictoPublicadoForm");
			}
			MuestraInformacionEdictoForm formulario2 = (MuestraInformacionEdictoForm) request.getSession().getAttribute("MuestraInformacionEdictoForm");

			Edicto edicto = new Edicto();
			Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}
			// Recupero de la session el cif del organismo para obtener los
			// centros de procedencia y los tipos de edictos
			String cifOrganismo = (String) request.getSession().getAttribute("cif");

			// Obtengo el id del edicto
			String idEdicto = request.getParameter("idEdictoSeleccionado");
			if (idEdicto == null) {
				idEdicto = formulario2.getIdEdicto();
			}

			if (request.getAttribute("numeroErrores") == null) {

				BackButtonUtil.setPathAnterior(mapping, request);

				formulario.setIdEdicto(idEdicto);

				if (idEdicto != null && !idEdicto.equals("")) {

					edicto = edictoService.findById(Integer.parseInt(idEdicto));

					List listaTiposEdictos = RellenaFormularioActionUtil.RellenaTiposEdictos(cifOrganismo);
					formulario.setListaTiposEdictos(listaTiposEdictos);

					formulario.setOpcionCentro(edicto.getCentro().getIdCentro());
					formulario.setOpcionTipoEdicto(edicto.getTipoEdicto().getidTipoEdicto());

					formulario.setFechaPublicacionPropuesta(FechasUtil.convertDateToString(edicto.getFechaPublicacionPropuesta(), FechasUtil.typeSdfDate));
					formulario.setFechaRetiradaPropuesta(FechasUtil.convertDateToString(edicto.getFechaRetiradaPropuesta(), FechasUtil.typeSdfDate));
					formulario.setDiasExposicion(edicto.getDiasExposicion());
					formulario.setTipoPublicacion(edicto.getTipoExposicion());
					formulario.setEdictoSust(edicto.getSustituyeA());
					formulario.setEdicto(edicto);

				}

			}

			request.getSession().setAttribute("listaTiposEdictos", formulario.getListaTiposEdictos());
			request.getSession().setAttribute("listaCentros", formulario.getListaCentros());
			/* Edictos Relacionados */
			List<RelacionEdictos> listaRelaciones = relacionEdictosService.findByEdicto(Integer.parseInt(idEdicto));
			Iterator it = listaRelaciones.iterator();
			List<Edicto> listaEdictos = new ArrayList();
			while (it.hasNext()) {
				RelacionEdictos relacionEdictosAux = (RelacionEdictos) it.next();

				if (!relacionEdictosAux.getEdicto1().getIdEdicto().equals(Integer.parseInt(idEdicto))) {
					listaEdictos.add(relacionEdictosAux.getEdicto1());
				}
				if (!relacionEdictosAux.getEdicto2().getIdEdicto().equals(Integer.parseInt(idEdicto))) {
					listaEdictos.add(relacionEdictosAux.getEdicto2());
				}
			}

			List listaEdictosRelacionados = new ArrayList<ObjetoEdictoVisualizar>();
			it = listaEdictos.iterator();
			while (it.hasNext()) {
				edicto = (Edicto) it.next();
				ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
				objetoEdictoVisualizar.setId(edicto.getIdEdicto());
				if (lenguaje.equals("va")) {
					objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
					objetoEdictoVisualizar.setDescripcion(edicto.getDescripcionVa());
				} else {
					objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
					objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
				}

				if (edicto.getOrganismoExterno() != null && edicto.getOrganismoExterno().getNombre() != null) {
					objetoEdictoVisualizar.setNombreCentro(edicto.getOrganismoExterno().getNombre());
				} else {
					objetoEdictoVisualizar.setNombreCentro(edicto.getCentro().getNombre());
				}
				objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto().getNombre());
				objetoEdictoVisualizar.setFechaPublicacion(FechasUtil.convertDateToString(edicto.getFechaPublicacion(), 0));
				objetoEdictoVisualizar.setFechaRetirada(FechasUtil.convertDateToString(edicto.getFechaRetirada(), 0));
				objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil.convertDateToString(edicto.getFechaRetiradaPropuesta(), 0));
				objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
				objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado().toString());
				objetoEdictoVisualizar.setUrl(edicto.getUrl());
				objetoEdictoVisualizar.setPublicado(true);
				objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
				listaEdictosRelacionados.add(objetoEdictoVisualizar);
			}
			formulario.setListaEdictosRelacionados(listaEdictosRelacionados);
			request.setAttribute("ActualizarEdictoPublicadoForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ActualizarEdictoPublicadoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
