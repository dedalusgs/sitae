package es.novasoft.sitae.perfiles.publico.muestraInformacionEdicto.actions;

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

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.perfiles.publico.muestraInformacionEdicto.forms.MuestraInformacionEdictoPublicoForm;

public class MuestraInformacionEdictoPublicoFrontAction extends ActionBase {

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
			RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);

			MuestraInformacionEdictoPublicoForm formulario = (MuestraInformacionEdictoPublicoForm) form;

			Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}

			Edicto edicto = new Edicto();

			String idEdicto = request.getParameter("idEdictoSeleccionado");

			if (idEdicto == null || idEdicto.equals("")) {

				idEdicto = formulario.getId();
			}
			if (idEdicto != null && !idEdicto.equals("")) {

				edicto = edictoService.findById(Integer.parseInt(idEdicto));

				if (edicto != null) {
					if (edicto.getRedactor() != null) {
						Usuario redactor = edicto.getRedactor();
						formulario.setNombreRedactor(redactor.getNombre() + " " + redactor.getApellido1() + " " + redactor.getApellido2());
						formulario.setFechaRedaccion(FechasUtil.convertDateToString(edicto.getFechaRedaccion(), 0));
					}

					if (edicto.getPublicador() != null) {

						Usuario publicador = edicto.getPublicador();
						formulario.setNombrePublicador(publicador.getNombre() + " " + publicador.getApellido1() + " " + publicador.getApellido2());

					}

					if (edicto.getDespublicador() != null) {

						Usuario despublicador = edicto.getDespublicador();
						formulario.setNombreDespublicador(despublicador.getNombre() + " " + despublicador.getApellido1() + " " + despublicador.getApellido2());

					}

					if (edicto.getSustituidoPor() != null) {

					}
					if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO || edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {

						formulario.setFechaPublicacion(FechasUtil.convertDateToString(edicto.getFechaPublicacion(), 0));
						formulario.setFechaPropuestaRetirada(FechasUtil.convertDateToString(edicto.getFechaRetiradaPropuesta(), 0));
						formulario.setFechaRetirada(FechasUtil.convertDateToString(edicto.getFechaRetirada(), 0));
					}
				} else {
					LOGGER.error("Error en MuestraInformacionEdictoPublicoFront al cargar el Edicto");
					return forward(request, mapping, ActionBase.ERROR_KEY);
				}

			} else {
				LOGGER.error("Error en MuestraInformacionEdictoPublicoFront al recibir idEdictoSeleccionado");
				return forward(request, mapping, ActionBase.ERROR_KEY);
			}

			formulario.setEdicto(edicto);
			formulario.setId(idEdicto);

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
				if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO || edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {
					listaEdictosRelacionados.add(objetoEdictoVisualizar);
				}
			}
			formulario.setListaEdictosRelacionados(listaEdictosRelacionados);
			request.setAttribute("MuestraInformacionEdictoPublicoForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionEdictoPublicoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
