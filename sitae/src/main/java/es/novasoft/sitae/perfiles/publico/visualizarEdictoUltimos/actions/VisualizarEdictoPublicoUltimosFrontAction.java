package es.novasoft.sitae.perfiles.publico.visualizarEdictoUltimos.actions;

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
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.perfiles.publico.visualizarEdictoUltimos.forms.VisualizarEdictoPublicoUltimosForm;

public class VisualizarEdictoPublicoUltimosFrontAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			VisualizarEdictoPublicoUltimosForm formulario = (VisualizarEdictoPublicoUltimosForm) form;
			String cifOrganismo = null;
			cifOrganismo = (String) request.getSession().getAttribute("cif");
			request.getSession().setAttribute("accionPublico", "inicio");

			Locale locale = (Locale) request.getSession().getAttribute(
					Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}
			formulario = rellenaFormulario(formulario, cifOrganismo, request,
					lenguaje);
			request.getSession().setAttribute(
					"VisualizarEdictoPublicoUltimosForm", formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en VisualizarEdictoPublicoUltimosFrontAction",
					e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

	public VisualizarEdictoPublicoUltimosForm rellenaFormulario(
			VisualizarEdictoPublicoUltimosForm formulario, String cif,
			HttpServletRequest request, String lenguaje) throws Exception {

		Organismo organismo = (Organismo) organismoService.findByCif(cif)
				.get(0);
		
		Integer diasCaducidad = Integer.parseInt(Constantes.getPropiedad("diasCaducidad"));
		
		List listaEdictos = edictoService
				.findByOrganismoEstadoOrderFechaPublicacion(organismo
						.getIdOrg(), Constantes.PUBLICADO, 1, 10, diasCaducidad);
		List listaPublicados = new ArrayList<ObjetoEdictoVisualizar>();
		Iterator it = listaEdictos.iterator();

		while (it.hasNext()) {
			Edicto edicto = (Edicto) it.next();
			ObjetoEdictoVisualizar objetoEdictoVisualizar = new ObjetoEdictoVisualizar();
			objetoEdictoVisualizar.setId(edicto.getIdEdicto());
			if (lenguaje.equals("va")) {
				objetoEdictoVisualizar.setTitulo(edicto.getTituloVa());
				objetoEdictoVisualizar
						.setDescripcion(edicto.getDescripcionVa());
			} else {
				objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
				objetoEdictoVisualizar.setDescripcion(edicto.getDescripcion());
			}
			if (edicto.getOrganismoExterno() != null
					&& edicto.getOrganismoExterno().getNombre() != null) {
				objetoEdictoVisualizar.setNombreCentro(edicto
						.getOrganismoExterno().getNombre());
			} else {
				objetoEdictoVisualizar.setNombreCentro(edicto.getCentro()
						.getNombre());
			}
			objetoEdictoVisualizar.setTipoEdicto(edicto.getTipoEdicto()
					.getNombre());
			objetoEdictoVisualizar.setFechaPublicacion(FechasUtil
					.convertDateToString(edicto.getFechaPublicacion(), 0));
			objetoEdictoVisualizar.setEstado(edicto.getEstado().getNombre());
			objetoEdictoVisualizar.setIdEstado(edicto.getEstado().getIdEstado()
					.toString());
			objetoEdictoVisualizar.setFechaRetirada(FechasUtil
					.convertDateToString(edicto.getFechaRetirada(),0));
			objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil
					.convertDateToString(edicto.getFechaRetiradaPropuesta(),0));
			objetoEdictoVisualizar.setUrl(edicto.getUrl());
			objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
			objetoEdictoVisualizar.setPublicado(true);
			listaPublicados.add(objetoEdictoVisualizar);
		}
		formulario.setListaPublicados(listaPublicados);
		return formulario;

	}
}
