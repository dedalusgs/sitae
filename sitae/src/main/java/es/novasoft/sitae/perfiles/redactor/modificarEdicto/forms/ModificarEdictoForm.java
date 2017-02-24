package es.novasoft.sitae.perfiles.redactor.modificarEdicto.forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.FileUtil;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;

public class ModificarEdictoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private List listaTiposEdictos;

	private List listaCentros;

	private Integer opcionCentro;

	private Integer opcionTipoEdicto;

	private Edicto edicto;

	private String fechaPublicacion;

	private String fechaRetirada;

	private String fechaRedaccion;

	private String diasPublicados;

	private List listaOrganismosExternos;

	private Integer opcionOrganismoExterno;

	private boolean seleccionadoOrganismoExterno;

	private FormFile pdf;

	private String id;

	private Edicto edictoSust;

	private String tipoPublicacion;

	private Integer diasNaturalesDefecto;

	private Integer diasLaborablesDefecto;
	private Boolean listaCorreo;

	private Boolean redesSociales;

	public Edicto getEdictoSust() {
		return edictoSust;
	}

	public void setEdictoSust(Edicto edictoSust) {
		this.edictoSust = edictoSust;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private List<ObjetoEdictoVisualizar> listaEdictosRelacionados;

	public List<ObjetoEdictoVisualizar> getListaEdictosRelacionados() {
		return listaEdictosRelacionados;
	}

	public void setListaEdictosRelacionados(List<ObjetoEdictoVisualizar> listaEdictosRelacionados) {
		this.listaEdictosRelacionados = listaEdictosRelacionados;
	}

	public ModificarEdictoForm() {

		edicto = new Edicto();

	}

	public String getDiasPublicados() {
		return diasPublicados;
	}

	public void setDiasPublicados(String diasPublicados) {
		this.diasPublicados = diasPublicados;
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
				errors.add(null, new ActionMessage("errors.maxlength2", LenguajeUtil.getMensaje(request, "datosedicto.titulo"), "1024"));
			}
		}

		if (edicto.getTituloVa().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.tituloVa")));
		} else {
			if (edicto.getTituloVa().length() >= Constantes.TAM_MAX_TITULO) {
				errors.add(null, new ActionMessage("errors.maxlength2", LenguajeUtil.getMensaje(request, "datosedicto.tituloVa"), "1024"));
			}
		}

		if (opcionCentro == -1) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.centroProcedencia")));
		}

		if (opcionTipoEdicto == -1) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.tipoEdicto")));
		}

		if (fechaPublicacion.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta")));
		} else {
			if ((!ValidatorUtils.validaFecha(fechaPublicacion, LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta"), true))) {
				errors.add(null, new ActionMessage("errors.fecha_formato", LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta")));
			}
		}

		if (fechaRetirada.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta")));
		} else {
			if ((!ValidatorUtils.validaFecha(fechaRetirada, LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), true))) {
				errors.add(null, new ActionMessage("errors.fecha_formato", LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta")));
			}
		}

		if (diasPublicados == null || diasPublicados.equals("")) {
			errors.add(null, new ActionMessage("errors.diasPublicacion"));
		}

		if (ValidatorUtils.validaFecha(fechaRetirada, LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), true)
				&& ValidatorUtils.validaFecha(fechaPublicacion, LenguajeUtil.getMensaje(request, "datosedicto.fechaPublicacionPropuesta"), true)) {

			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
			Date fechaAyer = new Date(new Date().getTime() - MILLIS_IN_A_DAY);

			if (FechasUtil.compareDates(FechasUtil.convertStringToDate(fechaRetirada, 0), FechasUtil.convertStringToDate(fechaPublicacion, 0))) {
				errors.add(
						null,
						new ActionMessage("errors.fecha_exceso", LenguajeUtil.getMensaje(request, "datosedicto.fechaRetiradaPropuesta"), LenguajeUtil.getMensaje(request,
								"datosedicto.fechaPublicacionPropuesta")));
			}

			if (FechasUtil.compareDates(FechasUtil.convertStringToDate(fechaPublicacion, 0), fechaAyer)) {
				errors.add(null, new ActionMessage("errors.fecha_actual"));
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

		try {
			if (pdf != null && pdf.getFileData() != null && pdf.getFileName() != null && !pdf.getFileName().trim().equals("")) {
				if (!pdf.getFileName().subSequence(pdf.getFileName().length() - 3, pdf.getFileName().length()).equals("pdf")) {
					errors.add(null, new ActionMessage("errors.formatoPdf"));
				} else {

					ServletContext contexto = this.getServlet().getServletContext();
					String rutaEdicto = contexto.getRealPath(Constantes.getPropiedad(Constantes.RUTA_EDICTOS));

					String nombreEdicto = pdf.getFileName();
					// PASO EL FICHERO ADJUNTO DE FORMFILE A FILE PARA PODER
					// ADJUNTARLO
					File doc2 = FileUtil.conversion(pdf, rutaEdicto, nombreEdicto);

					PdfReader reader = new PdfReader(doc2.getPath());
					AcroFields af = reader.getAcroFields();
					ArrayList names = af.getSignatureNames();
					if (names.isEmpty()) {

						errors.add(null, new ActionMessage("errors.pdfNoFirmado"));
					}
					doc2.delete();

				}
			}
		} catch (FileNotFoundException ex2) {
			Logger.getLogger(ModificarEdictoForm.class.getName()).log(Level.SEVERE, null, ex2);
			errors.add(null, new ActionMessage("errors.formatoPdf"));
		} catch (IOException ex2) {
			Logger.getLogger(ModificarEdictoForm.class.getName()).log(Level.SEVERE, null, ex2);
			errors.add(null, new ActionMessage("errors.formatoPdf"));
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	public List getListaOrganismosExternos() {
		return listaOrganismosExternos;
	}

	public void setListaOrganismosExternos(List listaOrganismosExternos) {
		this.listaOrganismosExternos = listaOrganismosExternos;
	}

	public Integer getOpcionOrganismoExterno() {
		return opcionOrganismoExterno;
	}

	public void setOpcionOrganismoExterno(Integer opcionOrganismoExterno) {
		this.opcionOrganismoExterno = opcionOrganismoExterno;
	}

	public boolean isSeleccionadoOrganismoExterno() {
		return seleccionadoOrganismoExterno;
	}

	public void setSeleccionadoOrganismoExterno(boolean seleccionadoOrganismoExterno) {
		this.seleccionadoOrganismoExterno = seleccionadoOrganismoExterno;
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