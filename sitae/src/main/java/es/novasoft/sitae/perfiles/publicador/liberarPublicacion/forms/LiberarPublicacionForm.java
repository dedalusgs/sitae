package es.novasoft.sitae.perfiles.publicador.liberarPublicacion.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.FormBase;
import es.novasoft.comun.utils.LenguajeUtil;
import es.novasoft.sitae.business.objects.Edicto;

public class LiberarPublicacionForm extends FormBase {

	private static final long serialVersionUID = 1L;

	private Edicto edicto;

	private String idEdicto;

	private String motivos;

	public String getMotivos() {
		return motivos;
	}

	public void setMotivos(String motivos) {
		this.motivos = motivos;
	}

	public String getIdEdicto() {
		return idEdicto;
	}

	public void setIdEdicto(String idEdicto) {
		this.idEdicto = idEdicto;
	}

	public LiberarPublicacionForm() {
		this.edicto = new Edicto();

	}

	public Edicto getEdicto() {
		return edicto;
	}

	public void setEdicto(Edicto edicto) {
		this.edicto = edicto;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (this.motivos.equals("")) {
			errors.add(null, new ActionMessage("errors.required", LenguajeUtil
					.getMensaje(request, "datosedicto.motivos")));
		} else {
			if (this.motivos.length() >= Constantes.TAMANIO_MAX)
				errors.add(null,
						new ActionMessage("errors.maxlength", LenguajeUtil
								.getMensaje(request, "datosedicto.motivos")));
		}

		request.setAttribute("numeroErrores", errors.size());

		return errors;

	}
}
