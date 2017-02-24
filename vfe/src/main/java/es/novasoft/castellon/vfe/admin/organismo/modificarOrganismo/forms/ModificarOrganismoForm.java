package es.novasoft.castellon.vfe.admin.organismo.modificarOrganismo.forms;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import es.novasoft.castellon.vfe.business.objects.Organismo;
import es.novasoft.castellon.vfe.business.services.interfaz.OrganismoService;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.comun.utils.TemaVisualizar;
import es.novasoft.comun.validator.ValidatorUtils;

public class ModificarOrganismoForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Organismo organismo;

	private List<TemaVisualizar> listaTemas;

	private String opcion;

	private String imagenActual;

	private transient FormFile imagen;

	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	public ModificarOrganismoForm() {

		this.organismo = new Organismo();
	}

	public FormFile getImagen() {
		return imagen;
	}

	public void setImagen(FormFile imagen) {
		this.imagen = imagen;
	}

	/**
	 * Función para validar el alta de Organismo
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		String codigoAntiguo = (String) request.getSession().getAttribute(
				"codigoModificarOrganismoForm");

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

		List listaOrganismo2 = new ArrayList();

		try {
			listaOrganismo2 = organismoService.findByCodigo(organismo
					.getCodigo());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (organismo.getCodigo().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.codigo")));
		} else {
			if (!codigoAntiguo.equals(organismo.getCodigo())) {
				if (!listaOrganismo2.isEmpty()) {
					errors.add(null, new ActionMessage("errors.codigoRepetido",
							LenguajeUtil.getMensaje(request,
									"datosorganismo.codigo")));
				}
			}
			if (organismo.getCodigo().length() >= Constantes.TAMANIO_MAX)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.codigo")));
		}

		if (organismo.getNombre().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.nombre")));
		} else {
			if (organismo.getNombre().length() >= Constantes.TAMANIO_MAX_NOMBRE)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.nombre")));
		}

		if (organismo.getNombreVa().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.nombreVa")));
		} else {
			if (organismo.getNombreVa().length() >= Constantes.TAMANIO_MAX_NOMBRE)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.nombreVa")));
		}

		if (organismo.getDireccion().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.direccion")));
		} else {
			if (organismo.getDireccion().length() >= Constantes.TAMANIO_MAX)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.direccion")));
		}

		if (organismo.getDireccionVa().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.direccionVa")));
		} else {
			if (organismo.getDireccionVa().length() >= Constantes.TAMANIO_MAX)
				errors.add(null, new ActionMessage("errors.maxlength",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.direccionVa")));
		}

		if (organismo.getTelefono().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.telefono")));
		} else if (!ValidatorUtils.isTelefono(organismo.getTelefono(), true,
				true, "")) {
			errors.add(null, new ActionMessage("errors.telefono"));
		}

		if (organismo.getFax().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.fax")));
		} else if (!ValidatorUtils.isTelefono(organismo.getFax(), true, true,
				"")) {
			errors.add(null, new ActionMessage("errors.fax"));
		}

		if (organismo.getEmail().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.email")));
		} else if (!ValidatorUtils.isEmail(organismo.getEmail())) {
			errors.add(null, new ActionMessage("errors.email"));
		}

		if (organismo.getDominio().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.dominio")));
		}
		/*
		 * else if(!ValidatorUtils.isDominio(organismo.getDominio())){
		 * errors.add(null, new ActionMessage("errors.dominio")); }
		 */

		if (this.getOpcion().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.tema")));
		}

		if (imagen.getFileName().length() > 50) {
			errors.add(null, new ActionMessage("errors.imagenMaxlength", 50));
		} else {

			if (imagen.getFileName() != null) {
				if (imagen.getFileSize() >= Constantes.TAM_MAX_SIZE) {
					errors.add(null, new ActionMessage("errors.tamanioMaximo"));
				} else {
					if (!imagen.getFileName().trim().equals("")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length())
									.equals("bmp")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length())
									.equals("gif")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length())
									.equals("jpg")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length())
									.equals("gif")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length()).equals(
									"jpeg")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length())
									.equals("gif")
							&& !imagen.getFileName().subSequence(
									imagen.getFileName().length() - 3,
									imagen.getFileName().length())
									.equals("gif")) {
						errors.add(null, new ActionMessage(
								"errors.formatoImagen"));
					}
				}

			}
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	public List<TemaVisualizar> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<TemaVisualizar> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getImagenActual() {
		String imagen = "./img/escudo.png";
		if (organismo.getNombreImagen() != null) {
			imagen = "."
					+ Constantes.getPropiedad(Constantes.RUTA_IMAGENES_ESCUDOS)
					+ "/" + organismo.getCodigo() + "/"
					+ organismo.getNombreImagen();
		}
		imagenActual = imagen;
		return imagenActual;
	}

	public void setImagenActual(String imagenActual) {
		this.imagenActual = imagenActual;
	}

}
