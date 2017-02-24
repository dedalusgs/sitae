/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: Constantes.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.comun.constantes;

import java.util.Locale;
import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class Constantes.
 */
public class Constantes {

	/** Locale por defecto */
	public static final Locale VALENCIANO = new Locale("va", "ES");
	public static final Locale ESPANYOL = new Locale("es", "ES");
	public static final Locale INGLES = new Locale("en", "EN");

	public static final Locale LOCALE_POR_DEFECTO = ESPANYOL;

	/** Propertie de configuración. */

	public static final String RESOURCEBUNDLE = "configuracion";

	public static final String RESOURCEBUNDLE_VALIDACION = "resources";

	/** The Constant CODIGOSAYUNTAMIENTOS. */
	public static final String CODIGOSAYUNTAMIENTOS = "codigoAyuntamientos";

	/** SI. */

	public static final String MODE_LOGIN = "login";

	/** The Constant SI. */
	public static final String SI = "Si";

	/** The Constant S. */
	public static final String S = "S";

	/** NO. */
	public static final String NO = "No";

	/** The Constant N. */
	public static final String N = "N";

	/** CONSTANTES PERFILES. */

	public static final int ADMIN_GLOBAL = 1;

	/** The Constant ADMIN_LOCAL. */
	public static final int ADMIN_LOCAL = 2;

	/** The Constant REDACTOR. */
	public static final int REDACTOR = 4;

	/** The Constant PUBLICADOR. */
	public static final int PUBLICADOR = 3;

	/** CONSTANTES FUNCIONALIDAD. */

	public static final int FUNCIONALIDAD_PUBLICACION = 5;

	/** CONSTANTES ESTADOS. */

	public static final int INICIADO = 1;

	/** The Constant PENDIENTE_VALIDACION. */
	public static final int PENDIENTE_VALIDACION = 2;

	/** The Constant RECHAZADO. */
	public static final int RECHAZADO = 4;

	/** The Constant REVISION. */
	public static final int REVISION = 3;

	/** The Constant PUBLICADO. */
	public static final int PUBLICADO = 5;

	/** The Constant RETIRADO. */
	public static final int RETIRADO = 6;

	/** The Constant PENDIENTE_FIRMA. */
	public static final int PENDIENTE_FIRMA = 7;

	/** The Constant RECHAZADO_FIRMA. */
	public static final int RECHAZADO_FIRMA = 8;

	public static final int PENDIENTE_PUBLICACION = 9;

	/** CONSTANTES NUMÉRICAS. */

	public static final int TAMANIO_MAX = 200;

	/** The Constant CERO_INT. */
	public static final Integer CERO_INT = 0;

	/** The Constant UNO_INT. */
	public static final Integer UNO_INT = 1;

	/** The Constant DOS_INT. */
	public static final Integer DOS_INT = 2;

	/** The Constant DIEZ_INT. */
	public static final Integer DIEZ_INT = 10;

	/** The Constant QUINCE_INT. */
	public static final Integer QUINCE_INT = 15;

	/** The Constant TAM_MAX_SIZE. */
	public static final Integer TAM_MAX_SIZE = 512000;

	/** The Constant TAM_MAX_TITULO. */
	public static final Integer TAM_MAX_TITULO = 1024;

	/** The Constant TAM_MAX_NUMEXP. */
	public static final Integer TAM_MAX_NUMEXP = 12;

	/** The Constant TAMANIO_MAX_DESCRIPCION. */
	public static final int TAMANIO_MAX_DESCRIPCION = 256;

	/** The Constant TAMANIO_MAX_NOMBRE. */
	public static final int TAMANIO_MAX_NOMBRE = 40;

	/** The Constant TAMANIO_MAX_NOMBRE. */
	public static final int TAMANIO_MAX_ORGANISMO_EXT = 40;

	/** The Constant NUMERO_INICIAL_CONTADOR_EDICTO. */
	public static final Integer NUMERO_INICIAL_CONTADOR_EDICTO = 0;

	/** CONSTANTES. */

	public static final String RUTA_IMAGENES_ESCUDOS = "ruta_imagenes_escudos";
	public static final String RUTA_URL_ARANGI = "url_arangi_server";

	/** The Constant RUTA_EDICTOS. */
	public static final String RUTA_EDICTOS = "ruta_edictos";

	/** The Constant RUTA_PLANTILLA_DILIGENCIA. */
	public static final String RUTA_PLANTILLA_DILIGENCIA = "ruta_plantilla_diligencia";

	/** The Constant RUTA_DILIGENCIAS. */
	public static final String RUTA_DILIGENCIAS = "ruta_diligencias";

	public static final String RUTA_PLANTILLA_DILIGENCIA_ABSOLUTA = "ruta_plantilla_diligencia_absoluta";
	public static final String RUTA_DILIGENCIAS_ABSOLUTA = "ruta_diligencias_absoluta";
	public static final String RUTA_EDICTOS_ABSOLUTA = "ruta_edictos_absoluta";

	/** The Constant ESCUDO. */
	public static final String ESCUDO = "escudo";

	/** The Constant USUARIO_PUBLICADOR. */
	public static final String USUARIO_PUBLICADOR = "publicador";

	/** The Constant USUARIO_REDACTOR. */
	public static final String USUARIO_REDACTOR = "redactor";

	/** Indica la pantalla con las pestañas del perfil respectivo. */

	public static final String PANTALLA_INICIO = "pantallaInicio";

	/** The Constant PANTALLA_PUBLICA. */
	public static final String PANTALLA_PUBLICA = "pantallaPublica";

	/** Indica el comienzo de un método. */
	public static final String COMIENZA_METODO = "COMIENZA METODO ";

	/** Indica el final de un método. */
	public static final String TERMINA_METODO = "TERMINA METODO ";

	/** The Constant FIN_METODO. */
	public static final String FIN_METODO = "TERMINA MÉTODO ";

	/** Forward de un Action a una acción correcta. */
	public static final String FORWARD_SUCCESS = "success";

	/** Indica el final de un método. */
	public static final String SUCCESS = "success";

	/** The Constant SUCCESS_2. */
	public static final String SUCCESS_2 = "success2";

	/** Indica el final de un método. */
	public static final String FAILURE = "failure";

	/** The Constant FAILURE_2. */
	public static final String FAILURE_2 = "failure2";

	/** Forward de Action de entrada -> intranet. */
	public static final String FORWARD_INTRANET = "intranet";

	/** Forward de un Action a una acción erronea. */
	public static final String FORWARD_FAILURE = "failure";

	/** Forward de un Action a una acción cancelada. */
	public static final String FORWARD_CANCEL = "cancel";

	/** Forward de un Action por firma cancelada. */
	public static final String FORWARD_CANCEL_FIRMA = "cancelfirma";

	/** Forward de un Action por un acceso erroneo. */
	public static final String FORWARD_ERROR_ACCESO = "errorAcceso";

	/** Forward de un Action por un acceso erroneo. */
	public static final String FORWARD_ERROR_ACCESO_AUTENTICACION = "errorAutenticacion";

	/** Acción Crear. */
	public static final String ACCION_CREAR = "Crear";

	/** Acción Editar. */
	public static final String ACCION_EDITAR = "Editar";

	/**
	 * Extensión de los ficheros de propiedades.
	 */
	public static final String EXTENSION_PROPERTIES = ".properties";

	/**
	 * Extensión para los ficheros xml.
	 */
	public static final String EXTENSION_XML = ".xml";

	/** Redireccion a la pantalla de Alta Usuario. */
	public static final String ALTA_USER = "altaUsuario";

	/*----------*/
	/* FORMATOS */
	/*----------*/

	/** Formato de fecha dd/MM/yyyy. */
	public static final String FORMATO_FECHA_DD_MM_YYYY = "dd/MM/yyyy";

	/** Formato de fecha dd-MM-yyyy. */
	public static final String FORMATO_FECHA_DD_MM_YYYY_CON_GUION = "dd-MM-yyyy";

	/** Formato de fecha yyyy/MM/dd. */
	public static final String FORMATO_FECHA_YYYY_MM_DD = "yyyy/MM/dd";

	/** Formato de fecha yyyy-MM-dd. */
	public static final String FORMATO_FECHA_YYYY_MM_DD_CON_GUION = "yyyy-MM-dd";

	/** Formato del edicto para generar claves. */

	public static final String EDICTO_FORMATO_GENERAR_EXPEDIENTE_PARAMETRO_1 = "ANUNCIO";

	/** The Constant EDICTO_FORMATO_GENERAR_EXPEDIENTE_SEPARADOR. */
	public static final String EDICTO_FORMATO_GENERAR_EXPEDIENTE_SEPARADOR = "-";

	/*----------------------*/
	/* VARIABLES DE SESSION */
	/*----------------------*/

	/** Nombre de la variable de sesión donde se almacena el usuario. */
	public static final String SESSION_USUARIO = "usuario";

	/**
	 * Nombre de la variable de sesión donde se almacenará la dirección IP
	 * del puesto remoto.
	 */
	public static final String SESSION_ADDR_IP = "direccion-IP";

	/** The Constant SESION_EXPIRADA_EXTRANET. */
	public static final String SESION_EXPIRADA_EXTRANET = "sesionexpiradaextranet";

	/*------------*/
	/* PARAMETROS */
	/*------------*/

	/**
	 * Nombre del parametro con el que se pasará como parámetro el ID de
	 * algún elemento.
	 */
	public static final String PARAM_ID = "id";

	/**
	 * Nombre del parametro con el que se pasará como parámetro alguna
	 * acción.
	 */
	public static final String PARAM_ACCION = "accion";

	/** Idioma por defecto de la aplicacion. */
	public static final String IDIOMA_POR_DEFECTO = "es";

	/** direcciona al forward de pagina de sesion expirada. */
	public static final String SESION_EXPIRADA = "sesionexpirada";

	/** Indica el final de un método. */
	public static final String SYSTEM_ERROR_KEY = "system_error";

	/** Indica el final de un método. */
	public static final String ERROR_REQUEST = "ErrorRequest";

	/** Indica el final de un método. */
	public static final String MESSAGE_REQUEST = "MessageRequest";

	/**
	 * Parámetro donde se almacena un mensaje para ser mostrado en una página.
	 */
	public static final String PARAMETRO_MENSAJE = "mensaje";

	/** The Constant ACEGI_SECURITY_CONTEXT. */
	public static final String ACEGI_SECURITY_CONTEXT = "ACEGI_SECURITY_CONTEXT";

	/*--------------------*/
	/* CONSTANTES ERROR */
	/*--------------------*/

	/** The Constant ERROR. */
	public static final String ERROR = "error";

	public static final String SUCCESS_3 = "success3";

	/** Bloqueado */
	public static final String LOOKED = "bloqueado";

	/**
	 * Gets the propiedad.
	 * 
	 * @param key
	 *            the key
	 * @return the propiedad
	 */
	public static String getPropiedad(String key) {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle(Constantes.RESOURCEBUNDLE);
		return resourceBundle.getString(key);
	}

	/**
	 * Gets the codigo ayuntamiento.
	 * 
	 * @param nombreAyuntamiento
	 *            the nombre ayuntamiento
	 * @return the codigo ayuntamiento
	 */
	public static String getCodigoAyuntamiento(String nombreAyuntamiento) {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle(Constantes.CODIGOSAYUNTAMIENTOS);
		return resourceBundle.getString(nombreAyuntamiento);
	}

	/**
	 * Gets the codigo ayuntamiento.
	 * 
	 * @param nombreAyuntamiento
	 *            the nombre ayuntamiento
	 * @return the codigo ayuntamiento
	 */
	public static String getMensajeValidacion(String key) {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle(Constantes.RESOURCEBUNDLE_VALIDACION);
		return resourceBundle.getString(key);
	}
}
