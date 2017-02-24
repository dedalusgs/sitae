package es.novasoft.sitae.perfiles.adminLocal.crearUsuarios.actions;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.HashUtil;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Perfil;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.PerfilService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioExternoService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.crearUsuarios.forms.CrearUsuariosForm;

public class CrearUsuariosDoAction extends ActionBase {

    private static Log	      log			     = LogFactory.getLog(CrearUsuariosDoAction.class);

    UsuarioService		  usuarioService		  = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);

    UsuarioExternoService	   usuarioExternoService	   = (UsuarioExternoService) Factory.getBean(ServiceConstants.USUARIO_EXTERNO_SERVICIO_BEAN_NAME);

    RelacionUsuOrgCentroPerfService relacionUsuOrgCentroPerfService = (RelacionUsuOrgCentroPerfService) Factory.getBean(ServiceConstants.REL_USU_ORG_CENTRO_PERF_BEAN_NAME);

    CentroProcedenciaService	centroProcedenciaService	= (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);

    PerfilService		   perfilService		   = (PerfilService) Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);

    OrganismoService		organismoService		= (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);

    Timestamp		       fechaDoc			= new Timestamp(System.currentTimeMillis());

    UsuarioAutentificado	    solicitante		     = null;

    protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException {

	String forward = ActionBase.SUCCESS_KEY;

	// CODIGO QUE COMPRUBA EL CANCELAR
	if (isCancelled(request)) {
	    // Elimina los forms anticuados
	    ResetForm.removeBean(mapping, request);
	    return forward(request, mapping, ActionBase.CANCEL_KEY);
	}

	String statusBusqueda = (String) request.getSession().getAttribute("statusBusqueda");
	if (statusBusqueda.equals("S")) {
	    request.getSession().setAttribute("statusBusqueda", "N");
	    return forward(request, mapping, ActionBase.SUCCESS_KEY_2);
	}

	try {

	    CrearUsuariosForm formulario = (CrearUsuariosForm) form;

	    RelacionUsuOrgCentroPerf relacionUsuOrgCentroPerf = new RelacionUsuOrgCentroPerf();
	    Perfil perfil = this.perfilService.findById(formulario.getOpcionPerfil());

	    if (!formulario.getUsuario().isInterno()) {
		String numDocumento = formulario.getUsuario().getNumDocumento().toUpperCase();
		formulario.getUsuario().setNumDocumento(numDocumento);
	    }
	    // Creamos un redactor
	    if (formulario.getOpcionPerfil().equals(Constantes.REDACTOR)) {
		relacionUsuOrgCentroPerf.setCentroProcedencia(null);
		relacionUsuOrgCentroPerf.setPerfil(perfil);
		relacionUsuOrgCentroPerf.setOrganismo(formulario.getCif());
		relacionUsuOrgCentroPerf.setUsuario(formulario.getUsuario().getNumDocumento());

	    } else {
		// Creamos un publicador
		CentroProcedencia centroProcedencia = this.centroProcedenciaService.findById(formulario.getOpcionCentro());
		relacionUsuOrgCentroPerf.setCentroProcedencia(centroProcedencia);
		relacionUsuOrgCentroPerf.setPerfil(perfil);
		relacionUsuOrgCentroPerf.setOrganismo(formulario.getCif());
		relacionUsuOrgCentroPerf.setUsuario(formulario.getUsuario().getNumDocumento());

	    }
	    List usuarios = this.usuarioService.findByNumeroDocumento(formulario.getUsuario().getNumDocumento());

	    if (formulario.getUsuario().isInterno()) {
		// formulario.getUsuario().setNombre(
		// formulario.getUsuario().getNumDocumento());
		formulario.getUsuario().setApellido1(" ");
		formulario.getUsuario().setApellido2(" ");
		formulario.getUsuario().setTelefono(" ");
	    }
	    if (usuarios.isEmpty()) {
		this.usuarioService.save(formulario.getUsuario());
		this.relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);
	    } else {
		this.usuarioService.attachDirty(formulario.getUsuario());
		this.relacionUsuOrgCentroPerfService.save(relacionUsuOrgCentroPerf);
	    }

	    if (formulario.getUsuario().isInterno()) {
		guardarUsuarioExterno(formulario);
	    }
	    request.setAttribute("nifSeleccionado", formulario.getUsuario().getNumDocumento());
	    request.setAttribute("perfilSeleccionado", perfil.getIdPerfil());
	} catch (Exception ex) {

	    ex.printStackTrace();
	    log.error("ERROR:" + ex.getMessage());
	    return mapping.findForward(ActionBase.ERROR_KEY);

	} finally {
	    ResetForm.removeBean(mapping, request);
	}
	return mapping.findForward(forward);
    }

    /**
     * Guardar usuario externo.
     *
     * @param formulario
     *            the formulario
     * @throws ServiceException
     */
    private void guardarUsuarioExterno(CrearUsuariosForm formulario) throws ServiceException {
	formulario.getUsuarioExterno().setPassword(HashUtil.calcularSHAString(formulario.getUsuarioExterno().getPassword()));
	formulario.getUsuarioExterno().setUsu(formulario.getUsuario().getNumDocumento());
	formulario.getUsuario().setIdUsuario(formulario.getUsuario().getIdUsuario() + 1);
	this.usuarioExternoService.save(formulario.getUsuarioExterno());
    }
}
