package es.novasoft.sitae.perfiles.redactor.modificarEdicto.actions;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.FileUtil;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.perfiles.redactor.modificarEdicto.forms.ModificarEdictoForm;

public class ModificarEdictoDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

	TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);

	OrganismoExternoService organismoExternoService = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);

	FactoryFileService factoryFileServices = (FactoryFileService) Factory.getBean("FactoryFileServices");

	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModificarEdictoForm formulario = (ModificarEdictoForm) form;

		String s = ActionBase.ERROR_KEY;
		boolean nuevoDocumento = false;
		CentroProcedencia cp = new CentroProcedencia();
		TipoEdicto te = new TipoEdicto();

		try {
			formulario.getEdicto().setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(formulario.getFechaPublicacion(), 0));
			formulario.getEdicto().setFechaRetiradaPropuesta(FechasUtil.convertStringToDate(formulario.getFechaRetirada(), 0));

			Date fechaActual = new Date();
			formulario.getEdicto().setFechaUltimaModificacion(fechaActual);

			cp = centroProcedenciaService.findById(formulario.getOpcionCentro());
			formulario.getEdicto().setCentro(cp);

			te = tipoEdictoService.findById(formulario.getOpcionTipoEdicto());
			formulario.getEdicto().setTipoEdicto(te);
			formulario.getEdicto().setTipoExposicion(formulario.getTipoPublicacion());
			formulario.getEdicto().setDiasExposicion(Integer.parseInt(formulario.getDiasPublicados()));
			formulario.getEdicto().setSustituyeA(formulario.getEdictoSust());

			if (formulario.getOpcionOrganismoExterno() != -1) {
				OrganismoExterno organismoExterno = organismoExternoService.findById(new Integer(formulario.getOpcionOrganismoExterno()));
				formulario.getEdicto().setOrganismoExterno(organismoExterno);
			} else {
				formulario.getEdicto().setOrganismoExterno(null);
			}

			if (formulario.getPdf() != null && formulario.getPdf().getFileName() != null && !formulario.getPdf().getFileName().trim().equals("")) {
				// PASO EL FICHERO ADJUNTO DE FORMFILE A FILE PARA PODER
				// ADJUNTARLO
				String nombreEdicto = formulario.getPdf().getFileName();
				formulario.getEdicto().setNombrePdfAdjunto(nombreEdicto);
				FileService fileService = this.factoryFileServices.getService(formulario.getEdicto());
				String ruta = fileService.guardarBorrador(formulario.getPdf().getFileData(), formulario.getEdicto());
				formulario.getEdicto().setPdfAdjunto(ruta);

				nuevoDocumento = true;
			}

			if (formulario.getEdicto().getEstado().getIdEstado() == Constantes.INICIADO || formulario.getEdicto().getEstado().getIdEstado() == Constantes.PENDIENTE_VALIDACION || formulario.getEdicto().getEstado().getIdEstado() == Constantes.PENDIENTE_FIRMA || formulario.getEdicto().getEstado().getIdEstado() == Constantes.RECHAZADO || formulario.getEdicto().getEstado().getIdEstado() == Constantes.RECHAZADO_FIRMA) {
				if (nuevoDocumento) {
					edictoService.actualizar(formulario.getEdicto());
				} else {
					edictoService.attachDirty(formulario.getEdicto());
				}
				s = ActionBase.SUCCESS_KEY;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ModificarEdictoDoAction", e);
			return forward(request, mapping, s);
		}

		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
