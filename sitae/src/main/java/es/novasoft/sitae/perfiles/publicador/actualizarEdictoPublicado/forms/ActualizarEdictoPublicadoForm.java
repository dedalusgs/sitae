package es.novasoft.sitae.perfiles.publicador.actualizarEdictoPublicado.forms;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class ActualizarEdictoPublicadoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List listaTiposEdictos;

	private List listaCentros;

	private Integer opcionCentro;

	private Integer opcionTipoEdicto;

	private Edicto edicto;

	private String fechaPublicacion;

	private String fechaRetirada;

	private String tipoPublicacion;

	private Integer diasNaturalesDefecto;

	private Integer diasLaborablesDefecto;

	private Integer diasExposicion;

	private Boolean listaCorreo;

	private Boolean redesSociales;

	public String getFechaPublicacionPropuesta() {
		return fechaPublicacionPropuesta;
	}

	private Edicto edictoSust;

	public Edicto getEdictoSust() {
		return edictoSust;
	}

	public void setEdictoSust(Edicto edictoSust) {
		this.edictoSust = edictoSust;
	}

	private List<ObjetoEdictoVisualizar> listaEdictosRelacionados;

	public List<ObjetoEdictoVisualizar> getListaEdictosRelacionados() {
		return listaEdictosRelacionados;
	}

	public void setListaEdictosRelacionados(List<ObjetoEdictoVisualizar> listaEdictosRelacionados) {
		this.listaEdictosRelacionados = listaEdictosRelacionados;
	}

	public void setFechaPublicacionPropuesta(String fechaPublicacionPropuesta) {
		this.fechaPublicacionPropuesta = fechaPublicacionPropuesta;
	}

	private String fechaRedaccion;

	private String fechaPublicacionPropuesta;

	private String fechaRetiradaPropuesta;

	private String idEdicto;

	private FormFile pdf;

	public ActualizarEdictoPublicadoForm() {

		edicto = new Edicto();

	}

	public String getIdEdicto() {
		return idEdicto;
	}

	public void setIdEdicto(String idEdicto) {
		this.idEdicto = idEdicto;
	}

	public String getFechaRedaccion() {
		return fechaRedaccion;
	}

	public void setFechaRedaccion(String fechaRedaccion) {
		this.fechaRedaccion = fechaRedaccion;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getFechaRetirada() {
		return fechaRetirada;
	}

	public void setFechaRetirada(String fechaRetirada) {
		this.fechaRetirada = fechaRetirada;
	}

	public Integer getOpcionTipoEdicto() {
		return opcionTipoEdicto;
	}

	public void setOpcionTipoEdicto(Integer opcionTipoEdicto) {
		this.opcionTipoEdicto = opcionTipoEdicto;
	}

	public Integer getOpcionCentro() {
		return opcionCentro;
	}

	public void setOpcionCentro(Integer opcionCentro) {
		this.opcionCentro = opcionCentro;
	}

	public Edicto getEdicto() {
		return edicto;
	}

	public void setEdicto(Edicto edicto) {
		this.edicto = edicto;
	}

	public FormFile getPdf() {
		return pdf;
	}

	public void setPdf(FormFile pdf) {
		this.pdf = pdf;
	}

	public List getListaTiposEdictos() {
		return listaTiposEdictos;
	}

	public void setListaTiposEdictos(List listaTiposEdictos) {
		this.listaTiposEdictos = listaTiposEdictos;
	}

	public List getListaCentros() {
		return listaCentros;
	}

	public void setListaCentros(List listaCentros) {
		this.listaCentros = listaCentros;
	}

	public String getFechaRetiradaPropuesta() {
		return fechaRetiradaPropuesta;
	}

	public void setFechaRetiradaPropuesta(String fechaRetiradaPropuesta) {
		this.fechaRetiradaPropuesta = fechaRetiradaPropuesta;
	}

	/**
	 * Función para validar el alta de Organismo
	 */

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		List listaOrganismo;

		ActionErrors errors = new ActionErrors();

		if (edicto.getTitulo().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.titulo")));
		} else {
			if (edicto.getTitulo().length() >= Constantes.TAM_MAX_TITULO) {
				errors.add(null, new ActionMessage("errors.maxlength2", LenguajeUtil.getMensaje(request, "datosedicto.titulo"), "80"));
			}
		}

		if (edicto.getTituloVa().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.tituloVa")));
		} else {
			if (edicto.getTituloVa().length() >= Constantes.TAM_MAX_TITULO) {
				errors.add(null, new ActionMessage("errors.maxlength2", LenguajeUtil.getMensaje(request, "datosedicto.tituloVa"), "80"));
			}
		}

		if (fechaPublicacionPropuesta.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta")));
		} else {
			if ((!ValidatorUtils.validaFecha(fechaPublicacionPropuesta, LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta"), true))) {
				errors.add(null, new ActionMessage("errors.fecha_formato", LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta")));
			} else {
				long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
				Date fechaAyer = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
				if (FechasUtil.compareDates(FechasUtil.convertStringToDate(fechaPublicacionPropuesta, 0), fechaAyer)) {
					errors.add(null, new ActionMessage("errors.fecha_actual"));
				}
			}
		}

		if (fechaRetiradaPropuesta.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta")));
		} else {
			if ((!ValidatorUtils.validaFecha(fechaRetiradaPropuesta, LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), true))) {
				errors.add(null, new ActionMessage("errors.fecha_formato", LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta")));
			}
		}

		if (ValidatorUtils.validaFecha(fechaRetiradaPropuesta, LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), true)) {

			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
			Date fechaAyer = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
			if (FechasUtil.compareDates(FechasUtil.convertStringToDate(fechaRetiradaPropuesta, 0), fechaAyer)) {
				errors.add(null, new ActionMessage("errors.fecha_actual_propuesta_retirada"));
			}

		}

		if (ValidatorUtils.validaFecha(fechaRetiradaPropuesta, LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), true)
				&& ValidatorUtils.validaFecha(fechaPublicacionPropuesta, LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta"), true)) {

			if (FechasUtil.compareDates(FechasUtil.convertStringToDate(fechaRetiradaPropuesta, 0), FechasUtil.convertStringToDate(fechaPublicacionPropuesta, 0))) {
				errors.add(
						null,
						new ActionMessage("errors.fecha_exceso", LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), LenguajeUtil.getMensaje(request,
								"datosedicto.fechaPublicacionPropuesta")));
			}
		}

		if (getListaCorreo()) {
			String listaCorreos = this.getEdicto().getOtrosCorreos();
			if (listaCorreos != null && !listaCorreos.equals("")) {
				String[] correos = listaCorreos.split(";");
				for (int i = 0; i < correos.length; i++) {
					if (!ValidatorUtils.isEmail(correos[i])) {
						errors.add(null, new ActionMessage("errors.listaCorreoErronea"));
						i = correos.length;
					}
					;
				}
			}

		}
		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	public String getTipoPublicacion() {
		return tipoPublicacion;
	}

	public void setTipoPublicacion(String tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public Integer getDiasNaturalesDefecto() {
		return diasNaturalesDefecto;
	}

	public void setDiasNaturalesDefecto(Integer diasNaturalesDefecto) {
		this.diasNaturalesDefecto = diasNaturalesDefecto;
	}

	public Integer getDiasLaborablesDefecto() {
		return diasLaborablesDefecto;
	}

	public void setDiasLaborablesDefecto(Integer diasLaborablesDefecto) {
		this.diasLaborablesDefecto = diasLaborablesDefecto;
	}

	public Integer getDiasExposicion() {
		return diasExposicion;
	}

	public void setDiasExposicion(Integer diasExposicion) {
		this.diasExposicion = diasExposicion;
	}

	public Boolean getListaCorreo() {
		Boolean resultado = listaCorreo;
		if (listaCorreo != null) {
			resultado = listaCorreo;
		} else {
			if (edicto.getListaCorreo() != null) {
				if (edicto.getListaCorreo().equals("SI")) {
					resultado = Boolean.TRUE;

				} else {
					resultado = Boolean.FALSE;
				}
			} else {
				resultado = Boolean.FALSE;
			}
		}

		return resultado;
	}

	public void setListaCorreo(Boolean listaCorreo) {
		this.listaCorreo = listaCorreo;
		if (edicto != null) {
			if (listaCorreo) {
				edicto.setListaCorreo("SI");
			} else {
				edicto.setListaCorreo("NO");
			}
		}
	}

	public Boolean getRedesSociales() {
		Boolean resultado = redesSociales;
		if (redesSociales != null) {
			resultado = redesSociales;
		} else {
			if (edicto.getRedesSociales() != null) {
				if (edicto.getRedesSociales().equals("SI")) {
					resultado = Boolean.TRUE;

				} else {
					resultado = Boolean.FALSE;
				}
			} else {
				resultado = Boolean.FALSE;
			}
		}

		return resultado;

	}

	public void setRedesSociales(Boolean redesSociales) {
		this.redesSociales = redesSociales;
		if (edicto != null) {
			if (redesSociales) {
				edicto.setRedesSociales("SI");
			} else {
				edicto.setRedesSociales("NO");
			}
		}
	}
}