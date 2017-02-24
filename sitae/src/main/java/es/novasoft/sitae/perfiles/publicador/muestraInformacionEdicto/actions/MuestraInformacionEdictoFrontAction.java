package es.novasoft.sitae.perfiles.publicador.muestraInformacionEdicto.actions;

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
import es.novasoft.comun.utils.BackButtonUtil;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.perfiles.publicador.muestraInformacionEdicto.forms.MuestraInformacionEdictoForm;

public class MuestraInformacionEdictoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			EdictoService edictoService = (EdictoService) Factory
					.getBean(ServiceConstants.EDICTO_BEAN_NAME);
			UsuarioService usuarioService = (UsuarioService) Factory
					.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
			RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory
					.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);

			MuestraInformacionEdictoForm formulario = (MuestraInformacionEdictoForm) form;

			Locale locale = (Locale) request.getSession().getAttribute(
					Globals.LOCALE_KEY);

			String lenguaje = "es";
			if (locale != null) {
				lenguaje = locale.getLanguage();
			}
			
			BackButtonUtil.setPathAnterior(mapping, request);
			
			String visualizar = request.getParameter("visualizar");

			formulario.setVisualizar(visualizar);

			Edicto edicto = new Edicto();

			// Obtengo el id del edicto
			String idEdicto = (String) request
					.getParameter("idEdictoSeleccionado");
			
			if (idEdicto == null || idEdicto.equals("")) {
				MuestraInformacionEdictoForm formularioSession = (MuestraInformacionEdictoForm) request.getSession().getAttribute("MuestraInformacionEdictoForm");
				idEdicto = formularioSession.getIdEdicto();
				formulario.setVisualizar("misPublicaciones");
			}
			
			if (idEdicto != null && !idEdicto.equals("")) {
				
				formulario.setIdEdicto(idEdicto);

				edicto = (Edicto) edictoService.findById(Integer
						.parseInt(idEdicto));

				String dniRedactor = edicto.getRedactor().getNumDocumento();
				Usuario redactor = (Usuario) usuarioService
						.findByNumeroDocumento(dniRedactor).get(0);
				formulario.setNombreRedactor(redactor.getNombre() + " "
						+ redactor.getApellido1() + " "
						+ redactor.getApellido2());
				formulario.setFechaRedaccion(FechasUtil.convertDateToString(
						edicto.getFechaRedaccion(), 0));
				formulario.setFechaUltimaModificacion(FechasUtil
						.convertDateToString(edicto
								.getFechaUltimaModificacion(), 0));

				formulario.setFechaPublicacionPropuesta(FechasUtil
						.convertDateToString(edicto
								.getFechaPublicacionPropuesta(), 0));
				formulario.setFechaRetiradaPropuesta(FechasUtil
						.convertDateToString(
								edicto.getFechaRetiradaPropuesta(), 0));

				int dias = (int) (FechasUtil.getDifferenceByDays(edicto
						.getFechaPublicacionPropuesta(), edicto
						.getFechaRetiradaPropuesta()));
				String tipoPublicacion;
				if (edicto.getTipoExposicion().equals(Edicto.TIPO_PUBLICACION_LABORABLES)) tipoPublicacion=" laborables";
				else tipoPublicacion=" naturales";
				
				formulario.setDiasPublicados(String.valueOf(edicto.getDiasExposicion())+tipoPublicacion);

				formulario.setFechaPublicacion("");
				formulario.setFechaRetirada("");
				formulario.setNombrePublicador("");

				if (edicto.getPublicador() != null) {

					String dniPublicador = edicto.getPublicador()
							.getNumDocumento();
					Usuario publicador = (Usuario) edicto.getPublicador();
					formulario.setNombrePublicador(publicador.getNombre() + " "
							+ publicador.getApellido1() + " "
							+ publicador.getApellido2());

				}

				if (edicto.getDespublicador() != null) {

					Usuario despublicador = (Usuario) edicto.getDespublicador();
					formulario.setNombreDespublicador(despublicador.getNombre()
							+ " " + despublicador.getApellido1() + " "
							+ despublicador.getApellido2());

				}

				if (edicto.getEstado().getIdEstado() == Constantes.PUBLICADO
						|| edicto.getEstado().getIdEstado() == Constantes.RETIRADO) {

					formulario.setFechaPublicacion(FechasUtil
							.convertDateToString(edicto.getFechaPublicacion(),
									0));
					formulario.setFechaRetirada(FechasUtil.convertDateToString(
							edicto.getFechaRetirada(), 0));
				}

			}

			formulario.setEdicto(edicto);

			formulario.setIdEdicto(idEdicto);
			/* Edictos Relacionados */
			List<RelacionEdictos> listaRelaciones = relacionEdictosService
					.findByEdicto(Integer.parseInt(idEdicto));
			Iterator it = listaRelaciones.iterator();
			List<Edicto> listaEdictos = new ArrayList();
			while (it.hasNext()) {
				RelacionEdictos relacionEdictosAux = (RelacionEdictos) it
						.next();

				if (!relacionEdictosAux.getEdicto1().getIdEdicto().equals(
						Integer.parseInt(idEdicto))) {
					listaEdictos.add(relacionEdictosAux.getEdicto1());
				}
				if (!relacionEdictosAux.getEdicto2().getIdEdicto().equals(
						Integer.parseInt(idEdicto))) {
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
					objetoEdictoVisualizar.setDescripcion(edicto
							.getDescripcionVa());
				} else {
					objetoEdictoVisualizar.setTitulo(edicto.getTitulo());
					objetoEdictoVisualizar.setDescripcion(edicto
							.getDescripcion());
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
				objetoEdictoVisualizar.setFechaRetirada(FechasUtil
						.convertDateToString(edicto.getFechaRetirada(), 0));
				objetoEdictoVisualizar.setFechaRetiradaPropuesta(FechasUtil
						.convertDateToString(
								edicto.getFechaRetiradaPropuesta(), 0));
				objetoEdictoVisualizar
						.setEstado(edicto.getEstado().getNombre());
				objetoEdictoVisualizar.setIdEstado(edicto.getEstado()
						.getIdEstado().toString());
				objetoEdictoVisualizar.setUrl(edicto.getUrl());
				objetoEdictoVisualizar.setPublicado(edicto.getEstado().getIdEstado() == Constantes.PUBLICADO);
				objetoEdictoVisualizar.setCodigo(edicto.getCodigo());
				listaEdictosRelacionados.add(objetoEdictoVisualizar);
			}
			formulario.setListaEdictosRelacionados(listaEdictosRelacionados);
			request.setAttribute("MuestraInformacionEdictoForm", formulario);
			request.getSession().setAttribute("MuestraInformacionEdictoForm",
					formulario);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en MuestraInformacionEdictoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}

}
