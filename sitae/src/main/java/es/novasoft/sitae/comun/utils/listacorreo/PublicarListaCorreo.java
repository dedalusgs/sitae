package es.novasoft.sitae.comun.utils.listacorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.MailUtils;
import es.novasoft.comun.validator.ValidatorUtils;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.InteresadoService;

public class PublicarListaCorreo implements Runnable {
	private static final Log	log	= LogFactory.getLog(PublicarListaCorreo.class);
	private final Edicto	 edicto;
	
	public PublicarListaCorreo(Edicto edicto) {
		this.edicto = edicto;
	}
	
	public void run() {
		try {
			
			InteresadoService interesadoService = (InteresadoService) Factory.getBean(ServiceConstants.INTERESADO_BEAN_NAME);
			EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
			Organismo organismo = edicto.getOrganismo();
			log.info("[LISTA CORREO]Notificando a lista de correo  del organismo: " + edicto.getOrganismo().getNombre());
			List<Interesado> interesados = interesadoService.findAllByOrg(organismo);
			ArrayList<String> interesadosCorreos = new ArrayList<String>();
			for (Interesado interesado : interesados) {
				interesadosCorreos.add(interesado.getEmail());
			}
			if (edicto.getOtrosCorreos() != null && !edicto.getOtrosCorreos().equals("")) {
				String[] otrosInteresados = edicto.getOtrosCorreos().split(";");
				for (int i = 0; i < otrosInteresados.length; i++) {
					if (ValidatorUtils.isEmail(otrosInteresados[i])) {
						interesadosCorreos.add(otrosInteresados[i]);
					}
				}
			}
			
			MailUtils correo = new MailUtils();
			
			ResourceBundle manejadorMensajes = ResourceBundle.getBundle("mailconfig");
			String asunto = manejadorMensajes.getString("asuntoNotificacionLista");
			String mensajeNotificacionLista1 = manejadorMensajes.getString("mensajeNotificacionLista1");
			String mensajeNotificacionLista2 = manejadorMensajes.getString("mensajeNotificacionLista2");
			String mensajeNotificacionLista3 = manejadorMensajes.getString("mensajeNotificacionLista3");
			String mensajeNotificacionLista4 = manejadorMensajes.getString("mensajeNotificacionLista4");
			String mensajeNotificacionLista5 = manejadorMensajes.getString("mensajeNotificacionLista5");
			String mensajeBaja3 = manejadorMensajes.getString("mensajeConfirmacionAlta3");
			
			String mensajeNotificacionLista1Va = manejadorMensajes.getString("mensajeNotificacionLista1Va");
			String mensajeNotificacionLista2Va = manejadorMensajes.getString("mensajeNotificacionLista2Va");
			String mensajeNotificacionLista3Va = manejadorMensajes.getString("mensajeNotificacionLista3Va");
			String mensajeNotificacionLista4Va = manejadorMensajes.getString("mensajeNotificacionLista4Va");
			String mensajeNotificacionLista5Va = manejadorMensajes.getString("mensajeNotificacionLista5Va");
			String mensajeBaja3Va = manejadorMensajes.getString("mensajeConfirmacionAlta3Va");
			
			String baseUrl = Constantes.getPropiedad(Constantes.PROTOCOLO) + "://" + organismo.getDominio() + "/" + Constantes.getPropiedad(Constantes.NOMBRE_APP);
			String urlEdicto = baseUrl + "/MuestraInformacionEdictoPublicoFrontAction.do?idEdictoSeleccionado=" + edicto.getIdEdicto();
			String urlBajaServicio = baseUrl + "/BajaSuscripcionFront.do?grupoNavegacion=5&servicioNavegacion=-5";
			
			StringBuffer mensajeTotal = new StringBuffer();
			mensajeTotal.append("<html><head><style>* {font-family: Verdana} </style></head><body>");
			
			mensajeTotal.append("<p>" + organismo.getNombre() + ". " + mensajeNotificacionLista1 + "</p>");
			mensajeTotal.append("<p>" + mensajeNotificacionLista2 + " <b>" + edicto.getTitulo() + "</b><br/>");
			mensajeTotal.append(mensajeNotificacionLista3 + " <b>" + edicto.getDescripcion() + "</b></p>");
			mensajeTotal.append("<p>" + mensajeNotificacionLista4 + "</p>");
			mensajeTotal.append("<p><a href='" + urlEdicto + "' >" + urlEdicto + "</a></p>");
			mensajeTotal.append("<p style='font-size: 70%'>" + mensajeNotificacionLista5 + "</p>");
			mensajeTotal.append("<br/>");
			mensajeTotal.append(mensajeBaja3 + "<a href='" + urlBajaServicio + "' >" + urlBajaServicio + "</a>");
			mensajeTotal.append("<br/><hr/>");
			
			mensajeTotal.append("<p>" + organismo.getNombreVa() + ". " + mensajeNotificacionLista1Va + "</p>");
			mensajeTotal.append("<p>" + mensajeNotificacionLista2Va + " <b>" + edicto.getTituloVa() + "</b><br/>");
			mensajeTotal.append(mensajeNotificacionLista3Va + " <b>" + edicto.getDescripcionVa() + "</b></p>");
			mensajeTotal.append("<p>" + mensajeNotificacionLista4Va + "</p>");
			mensajeTotal.append("<p><a href='" + urlEdicto + "' >" + urlEdicto + "</a></p>");
			mensajeTotal.append("<p style='font-size: 70%'>" + mensajeNotificacionLista5Va + "</p>");
			mensajeTotal.append("<br/>");
			mensajeTotal.append(mensajeBaja3Va + urlBajaServicio);
			
			mensajeTotal.append("</body></html>");
			
			int resultado = correo.notificarListaCorreosCOculta(null, null, interesadosCorreos, asunto, mensajeTotal.toString());
			if (resultado == 0) {
				log.error("Error al notificar Lista de Correo");
			}
		} catch (Exception e) {
			log.error("Se ha producido un error Notificando a interesados de la lista de correo", e);
		}
		
	}
}
