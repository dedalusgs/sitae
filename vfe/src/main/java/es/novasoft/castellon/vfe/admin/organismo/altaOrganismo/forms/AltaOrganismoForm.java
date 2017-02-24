package es.novasoft.castellon.vfe.admin.organismo.altaOrganismo.forms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

// TODO: Auto-generated Javadoc
/**
 * The Class AltaOrganismoForm.
 */
public class AltaOrganismoForm extends FormBase {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The organismo. */
	private Organismo organismo;

	/** The lista temas. */
	private List<TemaVisualizar> listaTemas;

	/** The opcion. */
	private String opcion;

	/** The imagen. */
	private transient FormFile imagen;

	/**
	 * Gets the organismo.
	 *
	 * @return the organismo
	 */
	public Organismo getOrganismo() {
		return organismo;
	}

	/**
	 * Sets the organismo.
	 *
	 * @param organismo the new organismo
	 */
	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	/**
	 * Instantiates a new alta organismo form.
	 */
	public AltaOrganismoForm() {
		this.organismo = new Organismo();

	}

	/**
	 * Gets the imagen.
	 *
	 * @return the imagen
	 */
	public FormFile getImagen() {
		return imagen;
	}

	/**
	 * Sets the imagen.
	 *
	 * @param imagen the new imagen
	 */
	public void setImagen(FormFile imagen) {
		this.imagen = imagen;
	}

	/**
	 * Función para validar el alta de Organismo.
	 *
	 * @param mapping the mapping
	 * @param request the request
	 * @return the action errors
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

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

		ActionErrors errors = new ActionErrors();

		if (organismo.getCodigo().equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosorganismo.codigo")));
		} else {
			if (!listaOrganismo2.isEmpty()) {
				errors.add(null, new ActionMessage("errors.codigoRepetido",
						LenguajeUtil.getMensaje(request,
								"datosorganismo.codigo")));
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
			if (imagen.getFileSize() == 0) {
				errors.add(null, new ActionMessage("errors.escudo"));
			} else {
				// COMPROBAMOS QUE SEA MENOS DE 500KB
				if (imagen.getFileSize() >= Constantes.TAM_MAX_SIZE) {
					errors.add(null, new ActionMessage("errors.tamanioMaximo"));
				} else {

					try {
						if (imagen != null
								&& imagen.getFileData() != null
								&& imagen.getFileName() != null
								&& !imagen.getFileName().trim().equals("")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"bmp")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"gif")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"jpg")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"gif")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"jpeg")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"gif")
								&& !imagen.getFileName().subSequence(
										imagen.getFileName().length() - 3,
										imagen.getFileName().length()).equals(
										"gif")) {
							errors.add(null, new ActionMessage(
									"errors.formatoImagen"));
						}
					} catch (FileNotFoundException ex2) {
						Logger.getLogger(AltaOrganismoForm.class.getName())
								.log(Level.SEVERE, null, ex2);
						errors.add(null, new ActionMessage(
								"errors.formatoImagen"));
					} catch (IOException ex2) {
						Logger.getLogger(AltaOrganismoForm.class.getName())
								.log(Level.SEVERE, null, ex2);
						errors.add(null, new ActionMessage(
								"errors.formatoImagen"));
					}
				}
			}
		}
		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}

	/**
	 * Gets the lista temas.
	 *
	 * @return the lista temas
	 */
	public List<TemaVisualizar> getListaTemas() {
		return listaTemas;
	}

	/**
	 * Sets the lista temas.
	 *
	 * @param listaTemas the new lista temas
	 */
	public void setListaTemas(List<TemaVisualizar> listaTemas) {
		this.listaTemas = listaTemas;
	}

	/**
	 * Gets the opcion.
	 *
	 * @return the opcion
	 */
	public String getOpcion() {
		return opcion;
	}

	/**
	 * Sets the opcion.
	 *
	 * @param opcion the new opcion
	 */
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

}
