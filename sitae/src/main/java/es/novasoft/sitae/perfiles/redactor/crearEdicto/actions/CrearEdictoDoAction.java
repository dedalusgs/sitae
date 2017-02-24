package es.novasoft.sitae.perfiles.redactor.crearEdicto.actions;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

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
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.comun.utils.ObjetoEdictoVisualizar;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.files.FactoryFileService;
import es.novasoft.sitae.business.files.FileService;
import es.novasoft.sitae.business.objects.CentroProcedencia;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.RelacionEdictos;
import es.novasoft.sitae.business.objects.TipoEdicto;
import es.novasoft.sitae.business.objects.TipoFirma;
import es.novasoft.sitae.business.objects.Usuario;
import es.novasoft.sitae.business.objects.UsuarioFirmante;
import es.novasoft.sitae.business.services.interfaz.CentroProcedenciaService;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.EstadoService;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionEdictosService;
import es.novasoft.sitae.business.services.interfaz.TipoEdictoService;
import es.novasoft.sitae.business.services.interfaz.TipoFirmaService;
import es.novasoft.sitae.business.services.interfaz.UsuarioFirmanteService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.redactor.crearEdicto.forms.CrearEdictoForm;

public class CrearEdictoDoAction extends ActionBase {
	
	private static Log	     log	                     = LogFactory.getLog(CrearEdictoDoAction.class);
	
	EdictoService	         edictoService	             = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	CentroProcedenciaService	centroProcedenciaService	= (CentroProcedenciaService) Factory.getBean(ServiceConstants.CENTRO_PROCEDENCIA_SERVICIO_BEAN_NAME);
	
	OrganismoExternoService	 organismoExternoService	 = (OrganismoExternoService) Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
	
	TipoEdictoService	     tipoEdictoService	         = (TipoEdictoService) Factory.getBean(ServiceConstants.TIPO_EDICTO_BEAN_NAME);
	
	EstadoService	         estadoService	             = (EstadoService) Factory.getBean(ServiceConstants.ESTADO_BEAN_NAME);
	
	UsuarioService	         usuarioService	             = (UsuarioService) Factory.getBean(ServiceConstants.USUARIO_SERVICIO_BEAN_NAME);
	
	UsuarioFirmanteService	 usuarioFirmanteService	     = (UsuarioFirmanteService) Factory.getBean(ServiceConstants.USUARIO_FIRMANTE_SERVICIO_BEAN_NAME);
	
	OrganismoService	     organismoService	         = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	TipoFirmaService	     tipoFirmaService	         = (TipoFirmaService) Factory.getBean(ServiceConstants.TIPO_FIRMA_BEAN_NAME);
	
	FestivoService	         festivoService	             = (FestivoService) Factory.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);
	InputStream	             solicitud	                 = null;
	
	FactoryFileService	     factoryFileServices	     = (FactoryFileService) Factory.getBean("FactoryFileServices");
	
	Timestamp	             fechaDoc	                 = new Timestamp(System.currentTimeMillis());
	
	UsuarioAutentificado	 solicitante	             = null;
	
	protected ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		
		String forward = ActionBase.SUCCESS_KEY;
		
		// las dos fechas se cogende las variables fechas
		
		CrearEdictoForm formulario = (CrearEdictoForm) form;
		try {
			CentroProcedencia centro = centroProcedenciaService.findById(formulario.getOpcionCentro());
			formulario.getEdicto().setCentro(centro);
			
			TipoEdicto tipoEdicto = tipoEdictoService.findById(formulario.getOpcionTipoEdicto());
			formulario.getEdicto().setTipoEdicto(tipoEdicto);
			if (formulario.getOpcionOrganismoExterno() != -1) {
				OrganismoExterno organismoExterno = organismoExternoService.findById(new Integer(formulario.getOpcionOrganismoExterno()));
				formulario.getEdicto().setOrganismoExterno(organismoExterno);
			}
			TipoFirma tipoFirma = (TipoFirma) tipoFirmaService.findById(formulario.getOpcionTipoFirma());
			formulario.getEdicto().setSustituyeA(formulario.getEdictoSust());
			formulario.getEdicto().setTipoFirma(tipoFirma);
			if (tipoFirma.getIdTipoFirma() == TipoFirma.PORTAFIRMAS) {
				// portafirmas
				UsuarioFirmante usf = (UsuarioFirmante) usuarioFirmanteService.findById(formulario.getOpcionFirmantes());
				formulario.getEdicto().setFirmante(usf);
			}
			
			formulario.getEdicto().setEstado(estadoService.findById(Constantes.INICIADO));
			
			formulario.getEdicto().setFechaPublicacionPropuesta(FechasUtil.convertStringToDate(formulario.getFechaPublicacion(), 0));
			formulario.getEdicto().setFechaRetiradaPropuesta(FechasUtil.convertStringToDate(formulario.getFechaRetirada(), 0));
			Date fechaActual = new Date();
			formulario.getEdicto().setFechaUltimaModificacion(fechaActual);
			formulario.getEdicto().setFechaRedaccion(fechaActual);
			
			Usuario usuPubl = null;
			formulario.getEdicto().setPublicador(usuPubl);
			formulario.getEdicto().setDiasExposicion(Integer.parseInt((formulario.getDiasPublicados())));
			String cifOrganismo = (String) request.getSession().getAttribute("cif");
			Organismo organismo = (Organismo) organismoService.findByCif(cifOrganismo).get(0);
			formulario.getEdicto().setOrganismo(organismo);
			formulario.getEdicto().setTipoExposicion(formulario.getTipoPublicacion());
			
			String dni = (String) request.getSession().getAttribute("nif");
			Usuario redactor = (Usuario) usuarioService.findByNumeroDocumento(dni).get(0);
			formulario.getEdicto().setRedactor(redactor);
			edictoService.save(formulario.getEdicto());
			String nombreEdicto = formulario.getPdf().getFileName();
			formulario.getEdicto().setNombrePdfAdjunto(nombreEdicto);
			FileService fileService = this.factoryFileServices.getService(formulario.getEdicto());
			String ruta = fileService.guardarBorrador(formulario.getPdf().getFileData(), formulario.getEdicto());
			formulario.getEdicto().setPdfAdjunto(ruta);
			edictoService.attachDirty(formulario.getEdicto());
			
		} catch (IOException e) {
			e.printStackTrace();
			return mapping.findForward(ActionBase.ERROR_KEY);
		} catch (Exception ex) {
			ex.printStackTrace();
			
			log.error("ERROR:" + ex.getMessage());
			log.error("TRAZA:", ex);
			return mapping.findForward(ActionBase.ERROR_KEY);
		} finally {
			if (formulario.getEdicto() != null) {
				Edicto edictoOriginal = edictoService.findById(formulario.getEdicto().getIdEdicto());
				RelacionEdictosService relacionEdictosService = (RelacionEdictosService) Factory.getBean(ServiceConstants.RELACION_EDICTOS_BEAN_NAME);
				
				if (edictoOriginal != null && formulario.getListaEdictosRelacionados() != null) {
					// Adjuntamos las nuevas relaciones
					for (ObjetoEdictoVisualizar objetoEdicto : formulario.getListaEdictosRelacionados()) {
						Edicto edicto = edictoService.findById(objetoEdicto.getId());
						if (edicto != null) {
							RelacionEdictos relacion = new RelacionEdictos();
							relacion.setEdicto1(formulario.getEdicto());
							relacion.setEdicto2(edicto);
							relacionEdictosService.save(relacion);
						}
					}
				}
			}
			ResetForm.removeBean(mapping, request);
		}
		return mapping.findForward(forward);
	}
}
