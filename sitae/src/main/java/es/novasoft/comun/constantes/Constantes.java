package es.novasoft.comun.constantes;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.Configuracion;
import es.novasoft.sitae.business.services.interfaz.ConfiguracionService;

public class Constantes {

	public static HashMap<String, String> resourceBundleConfiguracion = null;
	/** Locale por defecto */
	public static final Locale VALENCIANO = new Locale("va", "ES");
	public static final Locale ESPANYOL = new Locale("es", "ES");
	public static final Locale INGLES = new Locale("en", "EN");

	public static final Locale LOCALE_POR_DEFECTO = ESPANYOL;

	/**
	 * Propertie de configuración
	 *
	 */

	public static final String RESOURCEBUNDLE = "configuracion";
	public static final String CODIGOSAYUNTAMIENTOS = "codigoAyuntamientos";
	/**
	 * SI
	 *
	 */

	public static final String MODE_LOGIN = "login";

	public static final String SI = "Si";

	public static final String S = "S";

	/**
	 * NO
	 */
	public static final String NO = "No";

	public static final String N = "N";

	/**
	 * CONSTANTES PERFILES
	 */

	public static final int ADMIN_GLOBAL = 1;

	public static final int ADMIN_LOCAL = 2;

	public static final int REDACTOR = 4;

	public static final int PUBLICADOR = 3;

	/**
	 * CONSTANTES FUNCIONALIDAD
	 */

	public static final int FUNCIONALIDAD_PUBLICACION = 5;

	/**
	 * CONSTANTES ESTADOS
	 */

	public static final int INICIADO = 1;

	public static final int PENDIENTE_VALIDACION = 2;

	public static final int RECHAZADO = 4;

	public static final int REVISION = 3;

	public static final int PUBLICADO = 5;

	public static final int RETIRADO = 6;

	public static final int PENDIENTE_FIRMA = 7;

	public static final int RECHAZADO_FIRMA = 8;

	public static final int PENDIENTE_PUBLICACION = 9;

	/**
	 * CONSTANTES NUMÉRICAS
	 */

	public static final int TAMANIO_MAX = 200;

	public static final Integer CERO_INT = 0;

	public static final Integer UNO_INT = 1;

	public static final Integer DOS_INT = 2;

	public static final Integer DIEZ_INT = 10;

	public static final Integer QUINCE_INT = 15;

	public static final Integer TAM_MAX_SIZE = 512000;

	public static final Integer TAM_MAX_TITULO = 1024;

	public static final Integer TAM_MAX_NUMEXP = 12;

	public static final int TAMANIO_MAX_DESCRIPCION = 256;

	public static final int TAMANIO_MAX_NOMBRE = 40;

	public static final int TAMANIO_MAX_NOMBRE_FESTIVO = 200;

	public static final Integer NUMERO_INICIAL_CONTADOR_EDICTO = 0;

	/**
	 * CONSTANTES
	 */
	public static final String FANDANGO_ACTIVO = "fandango.activo";

	public static final String RUTA_IMAGENES_ESCUDOS = "ruta_imagenes_escudos";

	public static final String RUTA_URL_ARANGI = "url_arangi_server";

	public static final String RUTA_EDICTOS = "ruta_edictos";

	public static final String RUTA_EDICTOS_ABSOLUTA = "ruta_edictos_absoluta";

	public static final String RUTA_PLANTILLA_DILIGENCIA = "ruta_plantilla_diligencia";

	public static final String RUTA_PLANTILLA_DILIGENCIA_ABSOLUTA = "ruta_plantilla_diligencia_absoluta";

	public static final String RUTA_PLANTILLA_ESTADISTICAS_ABSOLUTA = "ruta_plantilla_estadisticas_absoluta";

	public static final String RUTA_PLANTILLA_ESTADISTICAS_ABSOLUTA_ESCUDO = "ruta_plantilla_estadisticas_absoluta.escudo";

	public static final String RUTA_DILIGENCIAS_ABSOLUTA = "ruta_diligencias_absoluta";

	public static final String RUTA_DILIGENCIAS = "ruta_diligencias";

	public static final String ESCUDO = "escudo";

	public static final String USUARIO_PUBLICADOR = "publicador";

	public static final String USUARIO_REDACTOR = "redactor";

	/**
	 * Indica la pantalla con las pestañas del perfil respectivo
	 */

	public static final String PANTALLA_INICIO = "pantallaInicio";

	public static final String PANTALLA_PUBLICA = "pantallaPublica";

	/**
	 * Indica el comienzo de un método
	 */
	public static final String COMIENZA_METODO = "COMIENZA METODO ";

	/**
	 * Indica el final de un método
	 */
	public static final String TERMINA_METODO = "TERMINA METODO ";

	public static final String FIN_METODO = "TERMINA MÉTODO ";

	/**
	 * Forward de un Action a una acción correcta
	 */
	public static final String FORWARD_SUCCESS = "success";

	/**
	 * Indica el final de un método
	 */
	public static final String SUCCESS = "success";

	public static final String SUCCESS_2 = "success2";

	public static final String SUCCESS_3 = "success3";

	/**
	 * Indica el final de un método
	 */
	public static final String FAILURE = "failure";

	public static final String FAILURE_2 = "failure2";

	/**
	 * Forward de Action de entrada -> intranet
	 */
	public static final String FORWARD_INTRANET = "intranet";

	/**
	 * Forward de un Action a una acción erronea
	 */
	public static final String FORWARD_FAILURE = "failure";

	/**
	 * Forward de un Action a una acción cancelada
	 */
	public static final String FORWARD_CANCEL = "cancel";

	/**
	 * Forward de un Action por firma cancelada
	 */
	public static final String FORWARD_CANCEL_FIRMA = "cancelfirma";

	/**
	 * Forward de un Action por un acceso erroneo
	 */
	public static final String FORWARD_ERROR_ACCESO = "errorAcceso";

	/**
	 * Forward de un Action por un acceso erroneo
	 */
	public static final String FORWARD_ERROR_ACCESO_AUTENTICACION = "errorAutenticacion";

	/**
	 * Acción Crear
	 */
	public static final String ACCION_CREAR = "Crear";

	/**
	 * Acción Editar
	 */
	public static final String ACCION_EDITAR = "Editar";

	/**
	 * Extensión de los ficheros de propiedades.
	 */
	public static final String EXTENSION_PROPERTIES = ".properties";

	/**
	 * Extensión para los ficheros xml.
	 */
	public static final String EXTENSION_XML = ".xml";

	/**
	 * Path Real de la Aplicación
	 */
	public static final String CFG_APP_PATH = "appPath";

	/**
	 * Número de elementos a mostrar por página de los listados
	 */
	public static final String CFG_PAGESIZE = "5";

	/**
	 * Provincia por defecto en los combos
	 */
	public static final String CFG_PROVINCIA_DEFECTO = "provincia_defecto";

	/**
	 * Redireccion a la pantalla de Alta Usuario
	 */
	public static final String ALTA_USER = "altaUsuario";

	/*----------*/
	/* FORMATOS */
	/*----------*/

	/**
	 * Formato de fecha dd/MM/yyyy
	 */
	public static final String FORMATO_FECHA_dd_MM_yyyy = "dd/MM/yyyy";

	/**
	 * Formato de fecha dd-MM-yyyy
	 */
	public static final String FORMATO_FECHA_dd_MM_yyyy_con_guion = "dd-MM-yyyy";

	/**
	 * Formato de fecha yyyy/MM/dd
	 */
	public static final String FORMATO_FECHA_yyyy_MM_dd = "yyyy/MM/dd";

	/**
	 * Formato de fecha yyyy-MM-dd
	 */
	public static final String FORMATO_FECHA_yyyy_MM_dd_con_guion = "yyyy-MM-dd";

	/**
	 * Formato del edicto para generar claves
	 */

	public static final String EDICTO_FORMATO_GENERAR_EXPEDIENTE_PARAMETRO_1 = "EDICTO";

	public static final String EDICTO_FORMATO_GENERAR_EXPEDIENTE_SEPARADOR = "-";

	/*----------------------*/
	/* VARIABLES DE SESSION */
	/*----------------------*/

	public static final String CANTIDAD_DIAS_NATURALES = "diasNaturalesPordefecto";

	public static final String CANTIDAD_DIAS_LABORALES = "diasLaboralesPordefecto";

	/**
	 * Nombre de la variable de sesión donde se almacena el usuario
	 */
	public static final String SESSION_USUARIO = "usuario";

	/**
	 * Nombre de la variable de sesión donde se almacenará la dirección IP
	 * del puesto remoto
	 */
	public static final String SESSION_ADDR_IP = "direccion-IP";

	public static final String SESION_EXPIRADA_EXTRANET = "sesionexpiradaextranet";

	/*------------*/
	/* PARAMETROS */
	/*------------*/

	/**
	 * Nombre del parametro con el que se pasará como parámetro el ID de
	 * algún elemento
	 */
	public static final String PARAM_ID = "id";

	/**
	 * Nombre del parametro con el que se pasará como parámetro alguna acción
	 */
	public static final String PARAM_ACCION = "accion";

	/**
	 * Idioma por defecto de la aplicacion
	 */
	public static final String IDIOMA_POR_DEFECTO = "es";

	/**
	 * direcciona al forward de pagina de sesion expirada
	 *
	 */
	public static final String SESION_EXPIRADA = "sesionexpirada";

	/**
	 * Indica el final de un método
	 */
	public static final String SYSTEM_ERROR_KEY = "system_error";

	/**
	 * Indica el final de un método
	 */
	public static final String ERROR_REQUEST = "ErrorRequest";

	/**
	 * Indica el final de un método
	 */
	public static final String MESSAGE_REQUEST = "MessageRequest";

	/**
	 * Parámetro donde se almacena un mensaje para ser mostrado en una página
	 */
	public static final String PARAMETRO_MENSAJE = "mensaje";

	public static final String ACEGI_SECURITY_CONTEXT = "ACEGI_SECURITY_CONTEXT";

	public static final String PUERTA_TRASERA = "puertaTrasera";

	public static final String VERSION = "sitae.version";

	public static final String CAPTCHA_PUBLIC_KEY = "captcha.publicKey";

	public static final String CAPTCHA_PRIVATE_KEY = "captcha.privateKey";

	public static final String ADDTHIS_ID = "addthis.id";
	/*--------------------*/
	/* CONSTANTES ERROR */
	/*--------------------*/

	public static final String ERROR = "error";
	public static final String PROTOCOLO = "protocolo";
	public static final String NOMBRE_APP = "nombreApp";
	public static final String REVISABLE = "revisable";
	public static final String ALFRESCO_ACTIVO = "alfresco.activo";

	public static String getPropiedad(String key) {
		if (resourceBundleConfiguracion == null) {
			ConfiguracionService configuracionService = (ConfiguracionService) Factory.getBean(ServiceConstants.CONFIGURACION_NAME);
			List<Configuracion> listaParametros;
			try {
				listaParametros = configuracionService.findAll();
			} catch (ServiceException e) {
				throw new RuntimeException("Error al obtener el listado de configuracion");
			}
			resourceBundleConfiguracion = new HashMap<String, String>();
			for (Configuracion configuracion : listaParametros) {
				resourceBundleConfiguracion.put(configuracion.getParametro(), configuracionService.desencriptar(configuracion));
			}
		}

		return resourceBundleConfiguracion.get(key);

	}

	public static String getCodigoAyuntamiento(String nombreAyuntamiento) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(Constantes.CODIGOSAYUNTAMIENTOS);
		return resourceBundle.getString(nombreAyuntamiento);
	}

}
