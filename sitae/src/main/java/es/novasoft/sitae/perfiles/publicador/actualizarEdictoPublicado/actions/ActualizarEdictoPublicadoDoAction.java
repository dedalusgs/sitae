package es.novasoft.sitae.perfiles.publicador.actualizarEdictoPublicado.actions;

import java.util.Date;

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
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.perfiles.publicador.actualizarEdictoPublicado.forms.ActualizarEdictoPublicadoForm;

public class ActualizarEdictoPublicadoDoAction extends ActionBase {

	EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);

	CentroProcedenciaService centroProcedenciaService = (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

	TipoEdictoService tipoEdictoService = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);

	@Override
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActualizarEdictoPublicadoForm formulario = (ActualizarEdictoPublicadoForm) form;

		String s = ActionBase.ERROR_KEY;

		try {

			formulario.getEdicto().setFechaRetiradaPropuesta(FechasUtil.convertStringToDate(formulario.getFechaRetiradaPropuesta(), 0));

			formulario.getEdicto().setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(formulario.getFechaPublicacionPropuesta(), 0));
			formulario.getEdicto().setTipoExposicion(formulario.getTipoPublicacion());
			formulario.getEdicto().setDiasExposicion(formulario.getDiasExposicion());
			Date fechaActual = new Date();
			formulario.getEdicto().setFechaUltimaModificacion(fechaActual);
			formulario.getEdicto().setSustituyeA(formulario.getEdictoSust());

			if (formulario.getEdicto().getEstado().getIdEstado() == Constantes.REVISION || formulario.getEdicto().getEstado().getIdEstado() == Constantes.PENDIENTE_PUBLICACION) {
				edictoService.attachDirty(formulario.getEdicto());

				s = ActionBase.SUCCESS_KEY;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en ActualizarEdictoPublicadoDoAction", e);
			return forward(request, mapping, s);
		}

		return forward(request, mapping, s);
	}
}
