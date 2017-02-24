/*******************************************************************************
 * Ruta al directorio de los instalables.                           	  	 *
 * Si no se establece, supone que estan en el mismo directorio que el HTML	 *

 * desde el que se carga el cliente.							 *
 * Las rutas absolutas deben comenzar por "file:///", "http://" o "https://"	 *
 * (por ejemplo, "file:///C:/ficheros", "http://www.mpr.es/ficheros",...)	 *
 * y las rutas relativas no pueden empezar por "/" (por ejemplo,			 *
 * "afirma/ficheros"). Se debe usar siempre el separador "/", nunca "\". 	 *

 * El fichero "version.properties" se toma de esta ruta.				 *
 ******************************************************************************/
var baseDownloadURL;

/*******************************************************************************
 * Ruta al directorio del instalador.							 *
 * Si no se establece, supone que esta en el mismo directorio que el HTML	 *

 * desde el que se carga el cliente.							 *
 * Si es una ruta absoluta debe comenzar por "file:///", "http://" o "https://"*
 * (por ejemplo, "file:///C:/Instalador", "http://www.mpr.es/instalador",...)	 *
 * y si es una ruta relativa no puede empezar por "/" (por ejemplo,		 *
 * "afirma/Instalador"). Se debe usar siempre el separador "/", nunca "\".	 *

 ******************************************************************************/
var base;

/*******************************************************************************
 * Algoritmo de firma. Puede ser 'SHA1withRSA', 'MD5withRSA' o, salvo que sea  *
 * firma XML, MD2withRSA. Se estable al llamar a configuraFirma en firma.js    *
 ******************************************************************************/
var signatureAlgorithm = 'SHA1withRSA'; // Valor por defecto

/*******************************************************************************
 * Formato de firma. Puede ser 'CMS', 'XADES', 'XMLDSIGN' o 'NONE'.            *
 * Se estable al llamar a configuraFirma en firma.js      				 *
 * Por defecto: CMS.										 *
 ******************************************************************************/
var signatureFormat = 'XADES'; // Valor por defecto

/*******************************************************************************
 * Mostrar los errores al usuario. Puede ser 'true' o 'false'.                 *
 * Se estable al llamar a configuraFirma en firma.js                           *
 * Por defecto: false.										 *
 ******************************************************************************/
var showErrors = 'true'; // Valor por defecto

/*******************************************************************************
 * Filtro de certificados (expresi�n que determina que certificados se le      *
 * permite elegir al usuario). Ver la documentaci�n.                           *
 * Se estable al llamar a configuraFirma en firma.js                           *
 *                                                                             *
 * Ejemplos:                                                                   *
 * - S?lo mostrar certificados de DNIe de firma:                               *
 * var certFilter = '{ISSUER.DN#MATCHES#{"CN=AC DNIE 00(1|2|3),OU=DNIE,'+      *
 *      'O=DIRECCION GENERAL DE LA POLICIA,C=ES"}&&{SUBJECT.DN#MATCHES#'+      *
 *      '{".*(FIRMA).*"}}}';                                                   *
 *                                                                             *
 * - S�lo mostrar certificados de la FNMT:                                     *
 * var certFilter = '{ISSUER.DN={"OU = FNMT Clase 2 CA,O= FNMT,C = ES"}}';     *
 *                                                                             *
 * - Mostrar todos los certificados menos el de validaci?n:                    *
 * var certFilter = '{SUBJECT.DN#NOT_MATCHES#{".*(AUTENTICACI�N).*"}}}'        *
 ******************************************************************************/
var certFilter; // Valor por defecto

/*******************************************************************************
 * Directorio donde se instalar� las librer�as del cliente                     *
 * Por defecto: USER_HOME/afirma.5/								 *
 ******************************************************************************/
var installDirectory;

/*******************************************************************************
 * Acci�n a realizar cuando durante la instalaci�n se detecten			 *
 * versiones antiguas del cliente (v2.4 y anteriores).				 *
 * Opciones disponibles:									 *
 * 	- 1: Preguntar al usuario.								 *
 *	- 2: No eliminar.										 *
 *	- 3: Eliminar sin preguntar.								 *
 * Por defecto: 1 (Preguntar al usuario).							 *
 ******************************************************************************/
var oldVersionsAction = 1;

/*******************************************************************************
 * Indica si se debe mostrar una advertencia a los usuarios de Mozilla Firefox *
 * en el momento de arrancar el cliente de firma. Ya que en los navegadores	 *
 * Mozilla los certificados de los tokens externos, como las tarjetas		 *
 * inteligentes, s�lo se mostrar�n si estaban insertados en el momento de abrir*
 * el almac�n, ser� necesario que los usuarios los mantengan insertados en sus *
 * correspondientes lectores desde el inicio de la aplicaci�n. Esta opci�n	 *
 * permite avisar a los usuarios para que act�en de esta forma. Las distintas	 *
 * opciones que se pueden indicar y los comportamientos asociados son los	 *
 * siguientes:											 *
 * 	- true: Mostrar advertencia.								 *
 *	- false: No mostrar advertencia.							 *
 * Por defecto: true (Mostrar advertencia).						 *
 ******************************************************************************/
var showMozillaSmartCardWarning = 'false';

/*******************************************************************************
 * Mostrar los certificados caducados en la listas de seleccion de		 *
 * certificados.						 					 *
 * Por defecto: 'true'.										 *
 ******************************************************************************/
var showExpiratedCertificates = 'true';

/*******************************************************************************
 * Construccion del cliente que se instalara cuando no se indique			 *
 * explicitamente.										 *
 * Los valores aceptados son:									 *
 *   - 'LITE':     Incluye los formatos de firma CMS y CADES.			 *
 *   - 'MEDIA':    Incluye los formatos de firma de la LITE + XMLDSIG y XADES. *
 *   - 'COMPLETA': Incluye los formatos de firma de la MEDIA + PDF.		 *
 * Por defecto: 'LITE'.										 *
 ******************************************************************************/
var defaultBuild = 'COMPLETA';

/*******************************************************************************
 * DEPRECADO. CADA DISTRIBUCION DEBE TENER SU DIRECTORIO DE INSTALACION PROPIO *
  ******************************************************************************/
//var distinctDistroDir;

