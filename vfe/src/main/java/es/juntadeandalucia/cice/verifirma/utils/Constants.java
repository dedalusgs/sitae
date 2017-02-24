package es.juntadeandalucia.cice.verifirma.utils;

// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {

	/** The Constant APP_PFIRMA_CODE. */
	public static final String APP_PFIRMA_CODE = "PFIRMA";
	
	/** The Constant UTF8. */
	public static final String UTF8 = "UTF-8";

	/*
	 * XHTML COMPONENT ID'S
	 */
	/** The Constant SERVER_TAB_ID. */
	public static final String SERVER_TAB_ID = "server";
	
	/** The Constant ADMIN_TAB_ID. */
	public static final String ADMIN_TAB_ID = "admin";

	/** The Constant C_YES. */
	public static final String C_YES = "S";
	
	/** The Constant C_NOT. */
	public static final String C_NOT = "N";

	/*
	 * number of elements per row
	 */
	/** The Constant N_ROWS_PER_TABLE. */
	public static final int N_ROWS_PER_TABLE = 10;
	
	/** The Constant N_ROWS_PER_TABLE_COMMENTS. */
	public static final int N_ROWS_PER_TABLE_COMMENTS = 4;

	/*
	 * C_HASH_ALG
	 */
	/** The Constant SHA1_ALG. */
	public static final String SHA1_ALG = "SHA1";

	/*
	 * C_TYPES
	 */

	// PF_ARCHIVOS
	/** The Constant C_TYPE_FILE_DB. */
	public static final String C_TYPE_FILE_DB = "BLOB";
	
	/** The Constant C_TYPE_FILE_PATH. */
	public static final String C_TYPE_FILE_PATH = "FICHERO";
	
	/** The Constant C_TYPE_FILE_DOE. */
	public static final String C_TYPE_FILE_DOE = "DOE";
	
	/** The Constant C_TYPE_FILE_ID. */
	public static final String C_TYPE_FILE_ID = "ID";
	
	/** The Constant C_TYPE_FILE_ALFRESCO. */
	public static final String C_TYPE_FILE_ALFRESCO = "ALFRESCO";
	
	/** The Constant BUFFER_SIZE. */
	public static final int BUFFER_SIZE = 1024;

	// PF_ETIQUETAS
	/** The Constant C_TYPE_TAG_USER. */
	public static final String C_TYPE_TAG_USER = "USUARIO";
	
	/** The Constant C_TYPE_TAG_STATE. */
	public static final String C_TYPE_TAG_STATE = "ESTADO";

	// PF_LINEAS_FIRMA
	/** The Constant C_TYPE_SIGNLINE_SIGN. */
	public static final String C_TYPE_SIGNLINE_SIGN = "FIRMA";
	
	/** The Constant C_TYPE_SIGNLINE_PASS. */
	public static final String C_TYPE_SIGNLINE_PASS = "VISTOBUENO";
	
	/** The Constant TYPE_CASCADE. */
	public static final String TYPE_CASCADE = "CASCADA";
	
	/** The Constant TYPE_FIRST_SIGNER. */
	public static final String TYPE_FIRST_SIGNER = "PRIMER FIRMANTE";
	
	/** The Constant TYPE_PARALLEL. */
	public static final String TYPE_PARALLEL = "PARALELA";

	// PF_PARAMETROS
	/** The Constant C_TYPE_PARAMETER_APPLICATION. */
	public static final String C_TYPE_PARAMETER_APPLICATION = "APLICACION";
	
	/** The Constant C_TYPE_PARAMETER_STYLE. */
	public static final String C_TYPE_PARAMETER_STYLE = "ESTILO";
	
	/** The Constant C_TYPE_PARAMETER_GLOBAL. */
	public static final String C_TYPE_PARAMETER_GLOBAL = "GLOBAL";
	
	/** The Constant C_TYPE_PARAMETER_SERVER. */
	public static final String C_TYPE_PARAMETER_SERVER = "SERVIDOR";
	
	/** The Constant C_TYPE_PARAMETER_CUSTODY. */
	public static final String C_TYPE_PARAMETER_CUSTODY = "CUSTODIA";
	
	/** The Constant C_PARAMETER_THEME. */
	public static final String C_PARAMETER_THEME = "ESTILO.TEMA";
	
	/** The Constant C_PARAMETER_INBOX_N_ROWS. */
	public static final String C_PARAMETER_INBOX_N_ROWS = "ESTILO.BANDEJA.NFILAS";
	
	/** The Constant C_PARAMETER_LANGUAGE. */
	public static final String C_PARAMETER_LANGUAGE = "ESTILO.IDIOMA";
	// TODO: mas adelante se mantendra a nivel de BBDD por aplicacion y
	// usuarios, ahora mismo se guardara a nivel de sesion
	/** The Constant C_PARAMETER_FONT_SIZE. */
	public static final String C_PARAMETER_FONT_SIZE = "ESTILO.LETRA.TAMANYO";
	
	/** The Constant C_PARAMETER_STORAGE_DB. */
	public static final String C_PARAMETER_STORAGE_DB = "BLOB";
	
	/** The Constant C_PARAMETER_STORAGE_INPUTCLASS. */
	public static final String C_PARAMETER_STORAGE_INPUTCLASS = "INPUTCLASS";
	
	/** The Constant C_PARAMETER_STORAGE_OUTPUTCLASS. */
	public static final String C_PARAMETER_STORAGE_OUTPUTCLASS = "OUTPUTCLASS";
	
	/** The Constant C_PARAMETER_STORAGE_SEPARATOR. */
	public static final String C_PARAMETER_STORAGE_SEPARATOR = ".";
	
	/** The Constant C_PARAMETER_WS_SECURITY_PASSWORD. */
	public static final String C_PARAMETER_WS_SECURITY_PASSWORD = "WS.SECURITY.PASS";
	
	/** The Constant C_PARAMETER_WS_SECURITY. */
	public static final String C_PARAMETER_WS_SECURITY = "WS.SECURITY";

	// Sign report parameters
	/** The Constant SIGNREPORT_TYPE_PARAM. */
	public static final String SIGNREPORT_TYPE_PARAM = "INFORME.TIPO";
	
	/** The Constant SIGNREPORT_3DESKEY_PARAM. */
	public static final String SIGNREPORT_3DESKEY_PARAM = "INFORME.CLAVE.3DES";
	
	/** The Constant SIGNREPORT_VERIFICATIONURL_PARAM. */
	public static final String SIGNREPORT_VERIFICATIONURL_PARAM = "INFORME.URL.VERIFICACION";
	
	/** The Constant SIGNREPORT_PARAM. */
	public static final String SIGNREPORT_PARAM = "INFORME.FIRMAPDF";
	
	/** The Constant SIGNREPORT_KEYSTORE_PARAM. */
	public static final String SIGNREPORT_KEYSTORE_PARAM = "INFORME.FIRMAPDF.KEYSTORE";
	
	/** The Constant SIGNREPORT_KEYSTOREPASS_PARAM. */
	public static final String SIGNREPORT_KEYSTOREPASS_PARAM = "INFORME.FIRMAPDF.KEYSTORE.PWD";
	
	/** The Constant SIGNREPORT_CERTALIAS_PARAM. */
	public static final String SIGNREPORT_CERTALIAS_PARAM = "INFORME.FIRMAPDF.CERT.ALIAS";
	
	/** The Constant SIGNREPORT_CERTPASSWORD_PARAM. */
	public static final String SIGNREPORT_CERTPASSWORD_PARAM = "INFORME.FIRMAPDF.CERT.PASSWORD";
	
	/** The Constant SIGNREPORT_ENCRYPT_PARAM. */
	public static final String SIGNREPORT_ENCRYPT_PARAM = "INFORME.CIFRADO";
	
	/** The Constant SIGNREPORT_ENCRYPT_PASSWORD_PARAM. */
	public static final String SIGNREPORT_ENCRYPT_PASSWORD_PARAM = "INFORME.CIFRADO.PASSWORD";

	// Notice parameters
	/** The Constant NOTICE_EMAIL_PARAM. */
	public static final String NOTICE_EMAIL_PARAM = "NOTIFICACION.CORREO";
	
	/** The Constant NOTICE_EMAIL_AUTH_PARAM. */
	public static final String NOTICE_EMAIL_AUTH_PARAM = "NOTIFICACION.CORREO.AUTH";
	
	/** The Constant NOTICE_EMAIL_USER_PARAM. */
	public static final String NOTICE_EMAIL_USER_PARAM = "NOTIFICACION.CORREO.USUARIO";
	
	/** The Constant NOTICE_EMAIL_PASS_PARAM. */
	public static final String NOTICE_EMAIL_PASS_PARAM = "NOTIFICACION.CORREO.CLAVE";
	
	/** The Constant NOTICE_EMAIL_NAME_PARAM. */
	public static final String NOTICE_EMAIL_NAME_PARAM = "NOTIFICACION.CORREO.NOMBRE";
	
	/** The Constant NOTICE_EMAIL_REMITTER_PARAM. */
	public static final String NOTICE_EMAIL_REMITTER_PARAM = "NOTIFICACION.CORREO.REMITENTE";
	
	/** The Constant NOTICE_SMTP_SERVER_PARAM. */
	public static final String NOTICE_SMTP_SERVER_PARAM = "NOTIFICACION.SMTP.SERVIDOR";
	
	/** The Constant NOTICE_SMTP_PORT_PARAM. */
	public static final String NOTICE_SMTP_PORT_PARAM = "NOTIFICACION.SMTP.PUERTO";

	// Proxy parameters
	/** The Constant PROXY_PARAM. */
	public static final String PROXY_PARAM = "PROXY";
	
	/** The Constant PROXY_SERVER_PARAM. */
	public static final String PROXY_SERVER_PARAM = "PROXY.SERVIDOR";
	
	/** The Constant PROXY_PORT_PARAM. */
	public static final String PROXY_PORT_PARAM = "PROXY.PUERTO";
	
	/** The Constant PROXY_AUTH_PARAM. */
	public static final String PROXY_AUTH_PARAM = "PROXY.AUTH";
	
	/** The Constant PROXY_USER_PARAM. */
	public static final String PROXY_USER_PARAM = "PROXY.USUARIO";
	
	/** The Constant PROXY_PASS_PARAM. */
	public static final String PROXY_PASS_PARAM = "PROXY.CLAVE";

	// Login parameters
	/** The Constant LOGIN_LDAP_PARAM. */
	public static final String LOGIN_LDAP_PARAM = "LOGIN.LDAP";
	
	/** The Constant LOGIN_DEBUG_PARAM. */
	public static final String LOGIN_DEBUG_PARAM = "LOGIN.DEBUG";
	
	/** The Constant LOGIN_LDAP_ID_PARAM. */
	public static final String LOGIN_LDAP_ID_PARAM = "LOGIN.LDAP.IDENTIFICADOR";
	
	/** The Constant LOGIN_LDAP_IDATTRIBUTE_PARAM. */
	public static final String LOGIN_LDAP_IDATTRIBUTE_PARAM = "USUARIO.LDAP.IDATRIBUTO";
	
	/** The Constant LOGIN_LDAP_URL_PARAM. */
	public static final String LOGIN_LDAP_URL_PARAM = "LOGIN.LDAP.URL";
	
	/** The Constant LOGIN_LDAP_BASEDN_PARAM. */
	public static final String LOGIN_LDAP_BASEDN_PARAM = "LOGIN.LDAP.BASEDN";
	
	/** The Constant LOGIN_LDAP_SEARCHBASE_PARAM. */
	public static final String LOGIN_LDAP_SEARCHBASE_PARAM = "LOGIN.LDAP.SEARCHBASE";

	// Custody parameters
	/** The Constant CUSTODY_TYPE. */
	public static final String CUSTODY_TYPE = "CUSTODIA.TIPO";
	
	/** The Constant CUSTODY_DESCRIPTION_PREFIX. */
	public static final String CUSTODY_DESCRIPTION_PREFIX = "custodyDescription";
	
	/** The Constant CUSTODY_DEFAULT_DESCRIPTION. */
	public static final String CUSTODY_DEFAULT_DESCRIPTION = "custodyDescriptionOTHER";
	
	/** The Constant CUSTODY_INPUTCLASS_DEFAULT_DESCRIPTION. */
	public static final String CUSTODY_INPUTCLASS_DEFAULT_DESCRIPTION = "custodyInputClassDescription";
	
	/** The Constant CUSTODY_OUTPUTCLASS_DEFAULT_DESCRIPTION. */
	public static final String CUSTODY_OUTPUTCLASS_DEFAULT_DESCRIPTION = "custodyOutputClassDescription";

	// Server parameters
	/** The Constant SERVER_APPLICATION_PARAM. */
	public static final String SERVER_APPLICATION_PARAM = "FIRMA.APLICACION";
	
	/** The Constant SERVER_SIGN_FORMAT_PARAM. */
	public static final String SERVER_SIGN_FORMAT_PARAM = "FIRMA.SIGNATURE.FORMAT";
	
	/** The Constant SERVER_SIGN_MODE_PARAM. */
	public static final String SERVER_SIGN_MODE_PARAM = "FIRMA.MODO";
	
	/** The Constant SERVER_SIGNATURE_TYPE_PARAM. */
	public static final String SERVER_SIGNATURE_TYPE_PARAM = "FIRMA.SIGNATURE.TYPE";
	
	/** The Constant SERVER_SIGNATURE_MODE_PARAM. */
	public static final String SERVER_SIGNATURE_MODE_PARAM = "FIRMA.SIGNATURE.MODE";
	
	/** The Constant SERVER_SIGN_TYPE_PARAM. */
	public static final String SERVER_SIGN_TYPE_PARAM = "FIRMA.TIPO";
	
	/** The Constant SERVER_SIGN_SERVER_CERT_ALIAS_PARAM. */
	public static final String SERVER_SIGN_SERVER_CERT_ALIAS_PARAM = "FIRMA.SERVER.CERT.ALIAS";
	
	/** The Constant SERVER_URL_PARAM. */
	public static final String SERVER_URL_PARAM = "FIRMA.URL";
	
	/** The Constant SERVER_MAPPING_PARAM. */
	public static final String SERVER_MAPPING_PARAM = "FIRMA.MAPPING";
	
	/** The Constant SERVER_MAPPING_IMPL_PARAM. */
	public static final String SERVER_MAPPING_IMPL_PARAM = "FIRMA.MAPPING.IMPL";
	
	/** The Constant SERVER_DEFAULT_KEYSTORE_PARAM. */
	public static final String SERVER_DEFAULT_KEYSTORE_PARAM = "FIRMA.TRUSTEDSTORE.DEFAULT";
	
	/** The Constant SERVER_KEYSTORE_PARAM. */
	public static final String SERVER_KEYSTORE_PARAM = "FIRMA.TRUSTEDSTORE";
	
	/** The Constant SERVER_KEYSTORE_PASS_PARAM. */
	public static final String SERVER_KEYSTORE_PASS_PARAM = "FIRMA.TRUSTEDSTORE.PASS";
	
	/** The Constant SERVER_SECURITY_MODE_PARAM. */
	public static final String SERVER_SECURITY_MODE_PARAM = "FIRMA.SECURITY.MODE";
	
	/** The Constant SERVER_SECURITY_USER_PARAM. */
	public static final String SERVER_SECURITY_USER_PARAM = "FIRMA.SECURITY.USER";
	
	/** The Constant SERVER_SECURITY_PASSWORD_PARAM. */
	public static final String SERVER_SECURITY_PASSWORD_PARAM = "FIRMA.SECURITY.PASSWORD";
	
	/** The Constant SERVER_SECURITY_PASSWORD_TYPE_PARAM. */
	public static final String SERVER_SECURITY_PASSWORD_TYPE_PARAM = "FIRMA.SECURITY.PASSWORD.TYPE";
	
	/** The Constant SERVER_SECURITY_KEYSTORE_PARAM. */
	public static final String SERVER_SECURITY_KEYSTORE_PARAM = "FIRMA.SECURITY.KEYSTORE";
	
	/** The Constant SERVER_SECURITY_KEYSTORE_TYPE_PARAM. */
	public static final String SERVER_SECURITY_KEYSTORE_TYPE_PARAM = "FIRMA.SECURITY.KEYSTORE.TYPE";
	
	/** The Constant SERVER_SECURITY_KEYSTORE_PASSWORD_PARAM. */
	public static final String SERVER_SECURITY_KEYSTORE_PASSWORD_PARAM = "FIRMA.SECURITY.KEYSTORE.PWD";
	
	/** The Constant SERVER_SECURITY_CERT_ALIAS_PARAM. */
	public static final String SERVER_SECURITY_CERT_ALIAS_PARAM = "FIRMA.SECURITY.CERT.ALIAS";
	
	/** The Constant SERVER_SECURITY_CERT_PASSWORD_PARAM. */
	public static final String SERVER_SECURITY_CERT_PASSWORD_PARAM = "FIRMA.SECURITY.CERT.PWD";
	//public static final String SERVER_AFIRMA5_MAPPING_PARAM = "FIRMA.AFIRMA5.MAPPING";
	//public static final String SERVER_AFIRMA5_MAPPING_AFIRMA5_PARAM = "FIRMA.AFIRMA5.MAPPING.AFIRMA5";
	/** The Constant SERVER_IMPL_PARAM. */
	public static final String SERVER_IMPL_PARAM = "FIRMA.IMPL";
	//public static final String SERVER_AFIRMA5_IMPL_PARAM = "FIRMA.IMPL.AFIRMA5";
	/** The Constant SERVER_HASH_ALGORITHM_PARAM. */
	public static final String SERVER_HASH_ALGORITHM_PARAM = "FIRMA.HASH.ALGORITHM";

	/** The Constant SERVER_JAAS_USER_PARAM. */
	public static final String SERVER_JAAS_USER_PARAM = "FIRMA.JAAS.USUARIO";
	
	/** The Constant SERVER_JAAS_PASSWORD_PARAM. */
	public static final String SERVER_JAAS_PASSWORD_PARAM = "FIRMA.JAAS.CLAVE";

	/** The Constant SERVER_URL_REQUEST_PARAM. */
	public static final String SERVER_URL_REQUEST_PARAM = "FIRMA.URL.REQUEST";
	
	/** The Constant SERVER_URL_START_PARAM. */
	public static final String SERVER_URL_START_PARAM = "FIRMA.URL.START";

	/** The Constant SERVER_AFIRMA5_MAPPING_AFIRMA5_VALUE. */
	public static final String SERVER_AFIRMA5_MAPPING_AFIRMA5_VALUE = "es.guadaltel.framework.authenticator.config.DefaultAfirmaMapping";
	
	/** The Constant SERVER_IMPL_AFIRMA5_VALUE. */
	public static final String SERVER_IMPL_AFIRMA5_VALUE = "es.guadaltel.framework.authenticator.impl.AfirmaAuthenticatorImpl";
	
	/** The Constant SERVER_IMPL_ZAIN_VALUE. */
	public static final String SERVER_IMPL_ZAIN_VALUE = "es.guadaltel.framework.authenticator.impl.ZainAuthenticatorImpl";
	
	/** The Constant SERVER_AFIRMA5_IMPL_VALUE. */
	public static final String SERVER_AFIRMA5_IMPL_VALUE = "es.guadaltel.framework.authenticator.impl.AfirmaAuthenticatorImpl";
	
	/** The Constant SERVER_AFIRMA5_MAPPING_IMPL_VALUE. */
	public static final String SERVER_AFIRMA5_MAPPING_IMPL_VALUE = "es.guadaltel.framework.authenticator.config.DefaultAfirmaMapping";
	
	/** The Constant SERVER_ZAIN_MAPPING_IMPL_VALUE. */
	public static final String SERVER_ZAIN_MAPPING_IMPL_VALUE = "es.guadaltel.framework.authenticator.config.DefaultZainMapping";

	/** The Constant SERVER_SECURITY_NONE. */
	public static final String SERVER_SECURITY_NONE = "None";
	
	/** The Constant SERVER_SECURITY_USERTOKEN. */
	public static final String SERVER_SECURITY_USERTOKEN = "UsernameToken";
	
	/** The Constant SERVER_SECURITY_BINARY. */
	public static final String SERVER_SECURITY_BINARY = "BinarySecurityToken";
	
	/** The Constant SERVER_SECURITY_USERTOKEN_PASSWORD_PLAIN. */
	public static final String SERVER_SECURITY_USERTOKEN_PASSWORD_PLAIN = "PasswordText";
	
	/** The Constant SERVER_SECURITY_USERTOKEN_PASSWORD_DIGEST. */
	public static final String SERVER_SECURITY_USERTOKEN_PASSWORD_DIGEST = "PasswordDigest";

	/** The Constant C_HASH_ALG_AFIRMA_SHA1. */
	public static final String C_HASH_ALG_AFIRMA_SHA1 = "SHA1WITHRSAENCRYPTION";
	
	/** The Constant C_HASH_ALG_ZAIN_SHA1. */
	public static final String C_HASH_ALG_ZAIN_SHA1 = "SHA-1";

	/** The Constant SERVER_SIGNATURE_TYPE_IMPLICIT_VALUE. */
	public static final String SERVER_SIGNATURE_TYPE_IMPLICIT_VALUE = "implicit";
	
	/** The Constant SERVER_SIGNATURE_TYPE_EXPLICIT_VALUE. */
	public static final String SERVER_SIGNATURE_TYPE_EXPLICIT_VALUE = "explicit";

	// Path of image used for report sign
	/** The Constant SIGNREPORT_IMAGE_PATH. */
	public static final String SIGNREPORT_IMAGE_PATH = "/theme/img/stamp_report.png";

	// ZIP Constants
	/** The Constant TEMP_FILE_PREFIX. */
	public static final String TEMP_FILE_PREFIX = "pfirma";
	
	/** The Constant ZIP_EXTENSION. */
	public static final String ZIP_EXTENSION = ".zip";

	// PF_USUARIOS
	/** The Constant C_TYPE_USER_JOB. */
	public static final String C_TYPE_USER_JOB = "CARGO";
	
	/** The Constant C_TYPE_USER_USER. */
	public static final String C_TYPE_USER_USER = "USUARIO";

	/** The Constant C_TYPE_SUBJECT_COMMENT. */
	public static final String C_TYPE_SUBJECT_COMMENT = "COMENTARIO";

	/** The Constant COPY_PROPERTY. */
	public static final String COPY_PROPERTY = "copy";

	/*
	 * Codes and descriptions
	 */

	// PF_PETICIONES_HISTORICO
	/** The Constant C_HISTORICREQUEST_REMITTER. */
	public static final String C_HISTORICREQUEST_REMITTER = "REMITENTE";
	
	/** The Constant C_HISTORICREQUEST_REMITTERNAME. */
	public static final String C_HISTORICREQUEST_REMITTERNAME = "REMITENTE.NOMBRE";
	
	/** The Constant C_HISTORICREQUEST_REMITTEREMAIL. */
	public static final String C_HISTORICREQUEST_REMITTEREMAIL = "REMITENTE.EMAIL";
	
	/** The Constant C_HISTORICREQUEST_REMITTERMOBILE. */
	public static final String C_HISTORICREQUEST_REMITTERMOBILE = "REMITENTE.MOVIL";
	
	/** The Constant C_HISTORICREQUEST_MODIFICATION. */
	public static final String C_HISTORICREQUEST_MODIFICATION = "PETICION.MODIFICIACION";
	
	/** The Constant D_HISTORICREQUEST_UNKNOW. */
	public static final String D_HISTORICREQUEST_UNKNOW = "DESCONOCIDO";

	// PF_FIRMAS
	/** The Constant SIGN_TYPE_BLOCK. */
	public static final String SIGN_TYPE_BLOCK = "BLOCK";
	
	/** The Constant SIGN_TYPE_SERVER. */
	public static final String SIGN_TYPE_SERVER = "SERVER";
	
	/** The Constant SIGN_SERVER_FORMAT_NONE. */
	public static final String SIGN_SERVER_FORMAT_NONE = "NINGUNO";
	
	/** The Constant SIGN_SERVER_FORMAT_PKCS7. */
	public static final String SIGN_SERVER_FORMAT_PKCS7 = "PKCS7";
	
	/** The Constant SIGN_SERVER_FORMAT_CMS. */
	public static final String SIGN_SERVER_FORMAT_CMS = "CMS";
	
	/** The Constant SIGN_SERVER_FORMAT_XADES. */
	public static final String SIGN_SERVER_FORMAT_XADES = "XADES";
	
	/** The Constant SIGN_SERVER_FORMAT_XADES_BES. */
	public static final String SIGN_SERVER_FORMAT_XADES_BES = "XADES-BES";
	
	/** The Constant SIGN_SERVER_FORMAT_XADES_T. */
	public static final String SIGN_SERVER_FORMAT_XADES_T = "XADES-T";
	
	/** The Constant SIGN_SERVER_FORMAT_CADES. */
	public static final String SIGN_SERVER_FORMAT_CADES = "CADES";
	
	/** The Constant SIGN_SERVER_FORMAT_XMLDSIG. */
	public static final String SIGN_SERVER_FORMAT_XMLDSIG = "XMLDSIG";
	
	/** The Constant SIGN_SERVER_FORMAT_ODF. */
	public static final String SIGN_SERVER_FORMAT_ODF = "ODF";
	
	/** The Constant SIGN_SERVER_FORMAT_PDF. */
	public static final String SIGN_SERVER_FORMAT_PDF = "PDF";
	
	/** The Constant SIGN_SERVER_FORMAT_OOXML. */
	public static final String SIGN_SERVER_FORMAT_OOXML = "OOXML";

	/** The Constant SIGN_SERVER_FORMAT_XADES_ENVELOPING_VALUE_ZAIN. */
	public static final String SIGN_SERVER_FORMAT_XADES_ENVELOPING_VALUE_ZAIN = "xades-sign-enveloping";

	/** The Constant SIGN_CLIENT_FORMAT_CMS_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_CMS_VALUE = "CMS/PKCS#7";
	
	/** The Constant SIGN_CLIENT_FORMAT_CADES_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_CADES_VALUE = "CAdES";
	
	/** The Constant SIGN_CLIENT_FORMAT_XADES_DETACHED_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_XADES_DETACHED_VALUE = "XAdES Detached";
	
	/** The Constant SIGN_CLIENT_FORMAT_XADES_ENVELOPED_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_XADES_ENVELOPED_VALUE = "XAdES Enveloped";
	
	/** The Constant SIGN_CLIENT_FORMAT_XADES_ENVELOPING_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_XADES_ENVELOPING_VALUE = "XAdES Enveloping";
	
	/** The Constant SIGN_CLIENT_FORMAT_XMLDSIG_DETACHED_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_XMLDSIG_DETACHED_VALUE = "XMLDSig Detached";
	
	/** The Constant SIGN_CLIENT_FORMAT_XMLDSIG_ENVELOPED_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_XMLDSIG_ENVELOPED_VALUE = "XMLDSig Enveloped";
	
	/** The Constant SIGN_CLIENT_FORMAT_XMLDSIG_ENVELOPING_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_XMLDSIG_ENVELOPING_VALUE = "XMLDSig Enveloping";
	
	/** The Constant SIGN_CLIENT_FORMAT_PDF_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_PDF_VALUE = "PDF";
	
	/** The Constant SIGN_CLIENT_FORMAT_ODF_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_ODF_VALUE = "ODF";
	
	/** The Constant SIGN_CLIENT_FORMAT_OOXML_VALUE. */
	public static final String SIGN_CLIENT_FORMAT_OOXML_VALUE = "OOXML";

	/** The Constant SIGN_EXTENSION_CMS. */
	public static final String SIGN_EXTENSION_CMS = "p7s";
	
	/** The Constant SIGN_EXTENSION_XADES. */
	public static final String SIGN_EXTENSION_XADES = "xades";
	
	/** The Constant SIGN_EXTENSION_CADES. */
	public static final String SIGN_EXTENSION_CADES = "cades";
	
	/** The Constant SIGN_EXTENSION_XMLDSIG. */
	public static final String SIGN_EXTENSION_XMLDSIG = "xmldsig";
	
	/** The Constant SIGN_EXTENSION_ODF. */
	public static final String SIGN_EXTENSION_ODF = "odf";
	
	/** The Constant SIGN_EXTENSION_PDF. */
	public static final String SIGN_EXTENSION_PDF = "pdf";
	
	/** The Constant SIGN_EXTENSION_OOXML. */
	public static final String SIGN_EXTENSION_OOXML = "ooxml";
	
	/** The Constant SIGN_MIMETYPE_PKCS7. */
	public static final String SIGN_MIMETYPE_PKCS7 = "application/pkcs7-signature";
	
	/** The Constant SIGN_MIMETYPE_XML. */
	public static final String SIGN_MIMETYPE_XML = "application/xml";
	
	/** The Constant SIGN_MIMETYPE_CADES. */
	public static final String SIGN_MIMETYPE_CADES = "application/octet-stream";
	
	/** The Constant SIGN_MIMETYPE_ODF. */
	public static final String SIGN_MIMETYPE_ODF = "application/vnd.oasis.opendocument.formula";
	
	/** The Constant SIGN_MIMETYPE_PDF. */
	public static final String SIGN_MIMETYPE_PDF = "application/pdf";
	
	/** The Constant SIGN_MIMETYPE_OOXML. */
	public static final String SIGN_MIMETYPE_OOXML = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

	/** The Constant SIGN_MODE_BLOCK. */
	public static final String SIGN_MODE_BLOCK = "BLOQUE";
	
	/** The Constant SIGN_MODE_MASSIVE. */
	public static final String SIGN_MODE_MASSIVE = "MASIVA";
	
	/** The Constant SIGN_HASH_SIGNATURE_MODE. */
	public static final String SIGN_HASH_SIGNATURE_MODE = "HASH";
	
	/** The Constant SIGN_BINARY_SIGNATURE_MODE. */
	public static final String SIGN_BINARY_SIGNATURE_MODE = "BINARIO";
	
	/** The Constant SIGN_HASH_PREFFIX. */
	public static final String SIGN_HASH_PREFFIX = "HASH:";
	
	/** The Constant SIGN_BINARY_PREFFIX. */
	public static final String SIGN_BINARY_PREFFIX = "BINARY:";
	
	/** The Constant SIGN_MULTISIGN_PREFFIX. */
	public static final String SIGN_MULTISIGN_PREFFIX = "MULTISIGN:";
	
	/** The Constant SIGN_FORMAT_SUFFIX. */
	public static final String SIGN_FORMAT_SUFFIX = ":";
	
	/** The Constant SIGN_FORMAT_DEFAULT. */
	public static final String SIGN_FORMAT_DEFAULT = "DEFAULT";
	
	/** The Constant MULTISIGN_JS_FUNCTION. */
	public static final String MULTISIGN_JS_FUNCTION = "firmaMasiva();";
	
	/** The Constant MULTISIGN_JS_FUNCTION_IDAZKI. */
	public static final String MULTISIGN_JS_FUNCTION_IDAZKI = "firmaMasivaIdazki();";
	
	/** The Constant BLOCK_SIGN_JS_FUNCTION. */
	public static final String BLOCK_SIGN_JS_FUNCTION = "firmaBloque();";
	
	/** The Constant SIGN_MASSIVE_ERROR. */
	public static final String SIGN_MASSIVE_ERROR = "#ERROR#";

	/** The Constant SIGN_SERVER_AFIRMA5. */
	public static final String SIGN_SERVER_AFIRMA5 = "afirma5";
	
	/** The Constant SIGN_SERVER_ZAIN. */
	public static final String SIGN_SERVER_ZAIN = "zain";
	
	/** The Constant SIGN_SERVER_BIT4ID. */
	public static final String SIGN_SERVER_BIT4ID = "bit4id";

	/** The Constant SIGN_SERVER_AFIRMA5_LABEL. */
	public static final String SIGN_SERVER_AFIRMA5_LABEL = "@firma";
	
	/** The Constant SIGN_SERVER_ZAIN_LABEL. */
	public static final String SIGN_SERVER_ZAIN_LABEL = "Zain";
	
	/** The Constant SIGN_SERVER_BIT4ID_LABEL. */
	public static final String SIGN_SERVER_BIT4ID_LABEL = "Bit4id";

	// PF_ETIQUETAS
	// states
	/** The Constant C_TAG_NEW. */
	public static final String C_TAG_NEW = "NUEVO";
	
	/** The Constant C_TAG_READ. */
	public static final String C_TAG_READ = "LEIDO";
	
	/** The Constant C_TAG_PRESIGNED. */
	public static final String C_TAG_PRESIGNED = "PREFIRMADO";
	
	/** The Constant C_TAG_NOTIFIED. */
	public static final String C_TAG_NOTIFIED = "NOTIFICADO";
	
	/** The Constant C_TAG_NO_NOTIFIED. */
	public static final String C_TAG_NO_NOTIFIED = "NO NOTIFI.";
	
	/** The Constant C_TAG_SIGNED. */
	public static final String C_TAG_SIGNED = "FIRMADO";
	
	/** The Constant C_TAG_AWAITING. */
	public static final String C_TAG_AWAITING = "EN ESPERA";
	
	/** The Constant C_TAG_REJECTED. */
	public static final String C_TAG_REJECTED = "DEVUELTO";
	
	/** The Constant C_TAG_ENQUEUED. */
	public static final String C_TAG_ENQUEUED = "ENCOLADO";
	
	/** The Constant C_TAG_EXPIRED. */
	public static final String C_TAG_EXPIRED = "CADUCADO";
	
	/** The Constant C_TAG_PASSED. */
	public static final String C_TAG_PASSED = "VISTOBUENO";

	// system
	/** The Constant C_TAG_SYSTEM_PASSED. */
	public static final String C_TAG_SYSTEM_PASSED = "TIPO.VISTOBUENO";
	
	/** The Constant C_TAG_SYSTEM_PRIVATE. */
	public static final String C_TAG_SYSTEM_PRIVATE = "TIPO.PRIVATE";

	/** The Constant TAG_DELETE_ASSOCIATED. */
	public static final String TAG_DELETE_ASSOCIATED = "labelAssociated";
	
	/** The Constant TAG_DELETE. */
	public static final String TAG_DELETE = "deleteLabel";

	// PF_TIPOS_DOCUMENTO
	/** The Constant C_DOCUMENTTYPE_GENERIC. */
	public static final String C_DOCUMENTTYPE_GENERIC = "GENERICO";

	// PF_PERFILES
	/** The Constant C_PROFILES_ACCESS. */
	public static final String C_PROFILES_ACCESS = "ACCESO";
	
	/** The Constant C_PROFILES_ADMIN. */
	public static final String C_PROFILES_ADMIN = "ADMIN";
	
	/** The Constant C_PROFILES_SIGN. */
	public static final String C_PROFILES_SIGN = "FIRMA";
	
	/** The Constant C_PROFILES_REDACTION. */
	public static final String C_PROFILES_REDACTION = "REDACCION";
	
	/** The Constant C_PROFILES_REDACTION_JOB. */
	public static final String C_PROFILES_REDACTION_JOB = "REDACCARGO";
	
	/** The Constant C_PROFILES_ADMIN_GEN. */
	public static final String C_PROFILES_ADMIN_GEN = "ADMIN.GEN";
	
	/** The Constant C_PROFILES_ADMIN_APL. */
	public static final String C_PROFILES_ADMIN_APL = "ADMIN.APL";
	
	/** The Constant C_PROFILES_ADMIN_SER. */
	public static final String C_PROFILES_ADMIN_SER = "ADMIN.SER";
	
	/** The Constant C_PROFILES_ADMIN_USU. */
	public static final String C_PROFILES_ADMIN_USU = "ADMIN.USU";
	
	/** The Constant C_PROFILES_ADMIN_CAR. */
	public static final String C_PROFILES_ADMIN_CAR = "ADMIN.CAR";
	
	/** The Constant C_PROFILES_ADMIN_PRO. */
	public static final String C_PROFILES_ADMIN_PRO = "ADMIN.PRO";
	
	/** The Constant C_PROFILES_ADMIN_EST. */
	public static final String C_PROFILES_ADMIN_EST = "ADMIN.EST";

	// PF_ACCIONES
	/** The Constant C_ACTIONS_WEB. */
	public static final String C_ACTIONS_WEB = "WEB";
	
	/** The Constant C_ACTIONS_PLSQL. */
	public static final String C_ACTIONS_PLSQL = "PLSQL";

	/*
	 * Notification
	 */
	/** The Constant SMS_NOTICE_PARAM. */
	public static final String SMS_NOTICE_PARAM = "NOTIFICACION.SMS";
	
	/** The Constant EMAIL_NOTICE. */
	public static final String EMAIL_NOTICE = "EMAIL";
	
	/** The Constant SMS_NOTICE. */
	public static final String SMS_NOTICE = "SMS";
	
	/** The Constant NOTICE. */
	public static final String NOTICE = "NOTICE";
	
	/** The Constant NOTICE_CONFIGURATION. */
	public static final String NOTICE_CONFIGURATION = "noticeConfiguration";
	
	/** The Constant NOTICE_MESSAGE. */
	public static final String NOTICE_MESSAGE = "noticeMessage";
	
	/** The Constant NOTICE_UNKNOWN_REMMITTER. */
	public static final String NOTICE_UNKNOWN_REMMITTER = "noticeUnknownRemmitter";

	/*
	 * Email api config constants
	 */
	/** The Constant MAIL_SERVER. */
	public static final String MAIL_SERVER = "mail.smtp.host";
	
	/** The Constant MAIL_SERVER_AUTH. */
	public static final String MAIL_SERVER_AUTH = "mail.smtp.auth";
	
	/** The Constant MAIL_NOTIFICATION_HEADER. */
	public static final String MAIL_NOTIFICATION_HEADER = "Disposition-Notification-To";
	
	/** The Constant MAIL_MIME_TYPE_HTML. */
	public static final String MAIL_MIME_TYPE_HTML = "text/html";
	
	/** The Constant MAIL_MIME_TYPE_PLAIN. */
	public static final String MAIL_MIME_TYPE_PLAIN = "text/plain";
	
	/** The Constant MAIL_RELATED_TYPE. */
	public static final String MAIL_RELATED_TYPE = "related";
	
	/** The Constant MAIL_ALTERNATIVE_TYPE. */
	public static final String MAIL_ALTERNATIVE_TYPE = "alternative";
	
	/** The Constant MAIL_STORE_TYPE. */
	public static final String MAIL_STORE_TYPE = "pop3";
	
	/** The Constant MAIL_FOLDER_TYPE. */
	public static final String MAIL_FOLDER_TYPE = "INBOX";
	
	/** The Constant MAIL_CONS_TRUE. */
	public static final String MAIL_CONS_TRUE = "true";
	
	/** The Constant MAIL_CONS_FALSE. */
	public static final String MAIL_CONS_FALSE = "false";
	
	/** The Constant MAIL_CONS_TRANPORT. */
	public static final String MAIL_CONS_TRANPORT = "smtp";
	
	/** The Constant MAIL_SERVER_PORT. */
	public static final String MAIL_SERVER_PORT = "mail.smtp.port";

	/*
	 * Notice text messages
	 */
	/** The Constant NOTICE_TEXT_HEADER. */
	public static final String NOTICE_TEXT_HEADER = "noticeTextHeader";
	
	/** The Constant NOTICE_READ. */
	public static final String NOTICE_READ = "requestRead";
	
	/** The Constant NOTICE_SIGNED. */
	public static final String NOTICE_SIGNED = "requestSigned";
	
	/** The Constant NOTICE_PASSED. */
	public static final String NOTICE_PASSED = "requestPassed";
	
	/** The Constant NOTICE_REJECTED. */
	public static final String NOTICE_REJECTED = "requestRejected";
	
	/** The Constant NOTICE_NOREPLY_TEXT. */
	public static final String NOTICE_NOREPLY_TEXT = "noticeNoReply";
	
	/** The Constant NOTICE_STATECHANGED_SUBJECT. */
	public static final String NOTICE_STATECHANGED_SUBJECT = "noticeStateChangedSubject";
	
	/** The Constant NOTICE_NEWCOMMENT_SUBJECT. */
	public static final String NOTICE_NEWCOMMENT_SUBJECT = "noticeNewCommentSubject";
	
	/** The Constant NOTICE_SIGNERADDED_SUBJECT. */
	public static final String NOTICE_SIGNERADDED_SUBJECT = "noticeSignerAddedSubject";
	
	/** The Constant NOTICE_NEWREQUEST_SUBJECT. */
	public static final String NOTICE_NEWREQUEST_SUBJECT = "noticeNewRequestSubject";
	
	/** The Constant NOTICE_STATECHANGED_TEXT. */
	public static final String NOTICE_STATECHANGED_TEXT = "noticeStateChangedTextBody";
	
	/** The Constant NOTICE_STATECHANGED_REJECTIONREASON_TEXT. */
	public static final String NOTICE_STATECHANGED_REJECTIONREASON_TEXT = "noticeStateChangedTextRejectionReason";
	
	/** The Constant NOTICE_NEWCOMMENT_TEXT. */
	public static final String NOTICE_NEWCOMMENT_TEXT = "noticeCommentTextBody";
	
	/** The Constant NOTICE_SIGNERADDED_TEXT. */
	public static final String NOTICE_SIGNERADDED_TEXT = "noticeSignerAddedTextBody";
	
	/** The Constant NOTICE_NEWREQUEST_TEXT. */
	public static final String NOTICE_NEWREQUEST_TEXT = "noticeNewRequestTextBody";

	/*
	 * Notice text vars
	 */
	/** The Constant NOTICE_STATE_VAR. */
	public static final String NOTICE_STATE_VAR = "$1";
	
	/** The Constant NOTICE_SUBJECT_VAR. */
	public static final String NOTICE_SUBJECT_VAR = "$2";
	
	/** The Constant NOTICE_SIGNER_VAR. */
	public static final String NOTICE_SIGNER_VAR = "$3";
	
	/** The Constant NOTICE_REFERENCE_VAR. */
	public static final String NOTICE_REFERENCE_VAR = "$4";
	
	/** The Constant NOTICE_REJECTIONREASON_VAR. */
	public static final String NOTICE_REJECTIONREASON_VAR = "$5";
	
	/** The Constant NOTICE_REMITTER_VAR. */
	public static final String NOTICE_REMITTER_VAR = "$6";
	
	/** The Constant NOTICE_USERWHOCOMMENT_VAR. */
	public static final String NOTICE_USERWHOCOMMENT_VAR = "$7";
	
	/** The Constant NOTICE_USERHISTORIC_VAR. */
	public static final String NOTICE_USERHISTORIC_VAR = "$8";
	
	/** The Constant NOTICE_JOBHISTORIC_VAR. */
	public static final String NOTICE_JOBHISTORIC_VAR = "$9";
	
	/** The Constant NOTICE_COMMENT_VAR. */
	public static final String NOTICE_COMMENT_VAR = "$10";

	/*
	 * Notice events
	 */
	/** The Constant NOTICE_EVENT_STATE_CHANGE. */
	public static final String NOTICE_EVENT_STATE_CHANGE = "stateChange";
	
	/** The Constant NOTICE_EVENT_NEW_COMMENT. */
	public static final String NOTICE_EVENT_NEW_COMMENT = "newComment";
	
	/** The Constant NOTICE_EVENT_SIGNER_ADDED. */
	public static final String NOTICE_EVENT_SIGNER_ADDED = "SignerAdded";
	
	/** The Constant NOTICE_EVENT_NEW_REQUEST. */
	public static final String NOTICE_EVENT_NEW_REQUEST = "newRequest";

	/*
	 * HISTORIC_REQUEST
	 */
	/** The Constant C_HISTORIC_REQUEST_REJECTED. */
	public static final String C_HISTORIC_REQUEST_REJECTED = "CAMBIO.DEVUELTO";
	
	/** The Constant C_HISTORIC_REQUEST_READ. */
	public static final String C_HISTORIC_REQUEST_READ = "CAMBIO.LEIDO";
	
	/** The Constant C_HISTORIC_REQUEST_PRESIGNED. */
	public static final String C_HISTORIC_REQUEST_PRESIGNED = "CAMBIO.PREFIRMA";
	
	/** The Constant C_HISTORIC_REQUEST_SIGNED. */
	public static final String C_HISTORIC_REQUEST_SIGNED = "CAMBIO.FIRMADO";
	
	/** The Constant C_HISTORIC_REQUEST_PASSED. */
	public static final String C_HISTORIC_REQUEST_PASSED = "CAMBIO.VISTOBUENO";
	
	/** The Constant C_HISTORIC_REQUEST_DOC_SIGNED. */
	public static final String C_HISTORIC_REQUEST_DOC_SIGNED = "CAMBIO.FIRMADODOC";
	
	/** The Constant PROP_HISTORIC_REQUEST_REJECTED. */
	public static final String PROP_HISTORIC_REQUEST_REJECTED = "historicRequestRejected";
	
	/** The Constant PROP_HISTORIC_REQUEST_READ. */
	public static final String PROP_HISTORIC_REQUEST_READ = "historicRequestRead";
	
	/** The Constant PROP_HISTORIC_REQUEST_PRESIGNED. */
	public static final String PROP_HISTORIC_REQUEST_PRESIGNED = "historicRequestPresigned";
	
	/** The Constant PROP_HISTORIC_REQUEST_SIGNED. */
	public static final String PROP_HISTORIC_REQUEST_SIGNED = "historicRequestSigned";
	
	/** The Constant PROP_HISTORIC_REQUEST_PASSED. */
	public static final String PROP_HISTORIC_REQUEST_PASSED = "historicRequestPassed";
	
	/** The Constant PROP_HISTORIC_REQUEST_DOC_SIGNED. */
	public static final String PROP_HISTORIC_REQUEST_DOC_SIGNED = "historicRequestDocSigned";

	/** The Constant HISTORIC_REQUEST_USER_VAR. */
	public static final String HISTORIC_REQUEST_USER_VAR = "$1";
	
	/** The Constant HISTORIC_REQUEST_JOB_VAR. */
	public static final String HISTORIC_REQUEST_JOB_VAR = "$2";
	
	/** The Constant HISTORIC_REQUEST_DOC_VAR. */
	public static final String HISTORIC_REQUEST_DOC_VAR = "$3";
	
	/** The Constant HISTORIC_REQUEST_VAR_SEPARATOR. */
	public static final String HISTORIC_REQUEST_VAR_SEPARATOR = ";";
	
	/** The Constant HISTORIC_REQUEST_VAR_EQUAL. */
	public static final String HISTORIC_REQUEST_VAR_EQUAL = "=";

	/*
	 * HASH
	 */
	/** The Constant C_HASH_ALFANUMERICS. */
	public static final char C_HASH_ALFANUMERICS[] = { 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9' };
	// Longitud por defecto de la cadena CHASH
	/** The Constant C_HASH_DEFAULTLENGTH. */
	public static final long C_HASH_DEFAULTLENGTH = 10;

	// Export
	/** The Constant EXPORT_XML_TYPE. */
	public static final String EXPORT_XML_TYPE = "xml";
	
	/** The Constant EXPORT_PDF_TYPE. */
	public static final String EXPORT_PDF_TYPE = "pdf";
	
	/** The Constant EXPORT_XLS_TYPE. */
	public static final String EXPORT_XLS_TYPE = "xls";
	
	/** The Constant EXPORT_CSV_TYPE. */
	public static final String EXPORT_CSV_TYPE = "csv";

	/** The Constant EXPORT_XML_MIME. */
	public static final String EXPORT_XML_MIME = "application/xml";
	
	/** The Constant EXPORT_PDF_MIME. */
	public static final String EXPORT_PDF_MIME = "application/pdf";
	
	/** The Constant EXPORT_XLS_MIME. */
	public static final String EXPORT_XLS_MIME = "application/vnd.ms-excel";
	
	/** The Constant EXPORT_CSV_MIME. */
	public static final String EXPORT_CSV_MIME = "text/html";

	// Signers tree
	/** The Constant PANEL_SIGNER_STYLE. */
	public static final String PANEL_SIGNER_STYLE = "input100";
	
	/** The Constant PANEL_SIGNER_CLIENT. */
	public static final String PANEL_SIGNER_CLIENT = "client";

	// application tree
	/** The Constant PANEL_APP_STYLE. */
	public static final String PANEL_APP_STYLE = "input100";
	
	/** The Constant PANEL_APP_CLIENT. */
	public static final String PANEL_APP_CLIENT = "client";

	// Messages properties names
	/** The Constant MESSAGES_ALL. */
	public static final String MESSAGES_ALL = "allTree";
	
	/** The Constant MESSAGES_TESTSTRING. */
	public static final String MESSAGES_TESTSTRING = "testString";

	// Request inbox
	/** The Constant MESSAGES_UNRESOLVED. */
	public static final String MESSAGES_UNRESOLVED = "unresolved";
	
	/** The Constant MESSAGES_AWAITING. */
	public static final String MESSAGES_AWAITING = "awaiting";
	
	/** The Constant MESSAGES_FINISHED. */
	public static final String MESSAGES_FINISHED = "finished";
	
	/** The Constant MESSAGES_SENT. */
	public static final String MESSAGES_SENT = "sent";
	
	/** The Constant MESSAGES_REDACTION. */
	public static final String MESSAGES_REDACTION = "redaction";

	/** The Constant TEMPLATE_FOLDER. */
	public static final String TEMPLATE_FOLDER = "/templates";
	
	/** The Constant TEMPLATE_FILE_NAME. */
	public static final String TEMPLATE_FILE_NAME = "mail_template.html";
	
	/** The Constant TEMPLATE_TITLE_VAR. */
	public static final String TEMPLATE_TITLE_VAR = "$$TITLE$$";
	
	/** The Constant TEMPLATE_DATE_VAR. */
	public static final String TEMPLATE_DATE_VAR = "$$DATE$$";
	
	/** The Constant TEMPLATE_MESSAGE_VAR. */
	public static final String TEMPLATE_MESSAGE_VAR = "$$MESSAGE$$";
	
	/** The Constant TEMPLATE_NOREPLY_VAR. */
	public static final String TEMPLATE_NOREPLY_VAR = "$$NOREPLY$$";

	// THEME
	/** The Constant THEME_DEFAULT. */
	public static final String THEME_DEFAULT = "default";
	
	/** The Constant THEME_SESSION. */
	public static final String THEME_SESSION = "session";
	
	/** The Constant THEME_USER. */
	public static final String THEME_USER = "user";
	
	/** The Constant THEME_FONTSIZE_DEFAULT. */
	public static final String THEME_FONTSIZE_DEFAULT = "11";
	
	/** The Constant THEME_ICONSIZE_DEFAULT. */
	public static final String THEME_ICONSIZE_DEFAULT = "16";
	
	/** The Constant THEME_ICONSIZE_TOUCH. */
	public static final String THEME_ICONSIZE_TOUCH = "32";
	
	/** The Constant THEME_FONTSIZE_MIN. */
	public static final String THEME_FONTSIZE_MIN = "10";
	
	/** The Constant THEME_FONTSIZE_TOUCH. */
	public static final String THEME_FONTSIZE_TOUCH = "14";
	
	/** The Constant THEME_FONTSIZE_MAX. */
	public static final String THEME_FONTSIZE_MAX = "20";
	// public static final String THEME_SKIN_DARKX = "darkX";
	// public static final String THEME_SKIN_BLUESKY = "blueSky";
	// public static final String THEME_SKIN_CLASSIC = "classic";
	// public static final String THEME_SKIN_WINE = "wine";
	// public static final String THEME_SKIN_DEEPMARINE = "deepMarine";
	// public static final String THEME_SKIN_EMERALTOWN = "emeraldTown";

	// REDACTION
	/** The Constant SIGNER_FILTER_ALL. */
	public static final String SIGNER_FILTER_ALL = "filterAll";
	
	/** The Constant SIGNER_FILTER_PEOPLE. */
	public static final String SIGNER_FILTER_PEOPLE = "filterPeople";
	
	/** The Constant SIGNER_FILTER_JOB. */
	public static final String SIGNER_FILTER_JOB = "filterJobs";
	
	/** The Constant SIGNER_FILTER_MOST_USED. */
	public static final String SIGNER_FILTER_MOST_USED = "filterMostUsed";

	// ACTION
	/** The Constant ACTION_PARAM_STATE. */
	public static final String ACTION_PARAM_STATE = "ESTADO";
	
	/** The Constant ACTION_PARAM_IDENTIFIER. */
	public static final String ACTION_PARAM_IDENTIFIER = "DNI";
	
	/** The Constant ACTION_PARAM_IDENTIFIER_2. */
	public static final String ACTION_PARAM_IDENTIFIER_2 = "EDNI";
	
	/** The Constant ACTION_PARAM_REQ_HASH. */
	public static final String ACTION_PARAM_REQ_HASH = "HASHPET";
	
	/** The Constant ACTION_PARAM_DOC_HASH. */
	public static final String ACTION_PARAM_DOC_HASH = "EHASH";
	
	/** The Constant ACTION_PARAM_EQUAL. */
	public static final String ACTION_PARAM_EQUAL = "=";
	
	/** The Constant ACTION_PARAM_QUOTE. */
	public static final String ACTION_PARAM_QUOTE = "'";
	
	/** The Constant ACTION_PARAM_POINTS. */
	public static final String ACTION_PARAM_POINTS = ":";

	// LOGIN LDAP
	/** The Constant LOGIN_LDAP_USER_VAR. */
	public static final String LOGIN_LDAP_USER_VAR = "$1";
	
	/** The Constant LOGIN_LDAP_SEPARATOR. */
	public static final String LOGIN_LDAP_SEPARATOR = "\\|";
	
	/** The Constant LOGIN_LDAP_REFERRAL_FOLLOW. */
	public static final String LOGIN_LDAP_REFERRAL_FOLLOW = "follow";

	// JOBS
	/** The Constant JOB_PRESIGN. */
	public static final String JOB_PRESIGN = "PREFIRMA";
	
	/** The Constant JOB_PRESIGN_EXPRESSION. */
	public static final String JOB_PRESIGN_EXPRESSION = "PREFIRMA.EXPRESION";
	
	/** The Constant JOB_ACTION. */
	public static final String JOB_ACTION = "ACTION";
	
	/** The Constant JOB_CLEANUP_TEMP. */
	public static final String JOB_CLEANUP_TEMP = "LIMPIEZA_TEMPORAL";

	/** The Constant MILISEC_BY_DAY. */
	public static final Long MILISEC_BY_DAY = 24 * 60 * 60 * 1000L;

	// signers tree
	/** The Constant SIGNERS_TREE_ICON16_JOB_PATH. */
	public static final String SIGNERS_TREE_ICON16_JOB_PATH = "/theme/img/icons_16/medal_silver.png";
	
	/** The Constant SIGNERS_TREE_ICON16_USER_PATH. */
	public static final String SIGNERS_TREE_ICON16_USER_PATH = "/theme/img/icons_16/login.png";
	
	/** The Constant SIGNERS_TREE_ICON32_JOB_PATH. */
	public static final String SIGNERS_TREE_ICON32_JOB_PATH = "/theme/img/icons_32/medal_silver.png";
	
	/** The Constant SIGNERS_TREE_ICON32_USER_PATH. */
	public static final String SIGNERS_TREE_ICON32_USER_PATH = "/theme/img/icons_32/login.png";

	// SQL TRANSLATE
	/** The Constant TRANSLATE_TARGET_SQL. */
	private static final String TRANSLATE_TARGET_SQL = "AEIOUNCAEIOU";
	
	/** The Constant TRANSLATE_SOURCE_SQL. */
	private static final String TRANSLATE_SOURCE_SQL = "Ã�Ã‰Ã�Ã“ÃšÃ‘Ã‡Ã„Ã‹Ã�Ã–Ãœ";
	
	/** The Constant TRANSLATE_SQL_END. */
	public static final String TRANSLATE_SQL_END = "),'"
			+ Constants.TRANSLATE_SOURCE_SQL + "','"
			+ Constants.TRANSLATE_TARGET_SQL + "')) like '%'||:search||'%' ";
	
	/** The Constant TRANSLATE_SQL_BEGIN. */
	public static final String TRANSLATE_SQL_BEGIN = "(translate(upper(";

	// JAVA TRANSLATE
	/** The Constant TRANSLATE_TARGET_A. */
	public static final String TRANSLATE_TARGET_A = "A";
	
	/** The Constant TRANSLATE_SOURCE_AT. */
	public static final String TRANSLATE_SOURCE_AT = "Ã�";
	
	/** The Constant TRANSLATE_SOURCE_AD. */
	public static final String TRANSLATE_SOURCE_AD = "Ã„";
	
	/** The Constant TRANSLATE_TARGET_E. */
	public static final String TRANSLATE_TARGET_E = "E";
	
	/** The Constant TRANSLATE_SOURCE_ET. */
	public static final String TRANSLATE_SOURCE_ET = "Ã‰";
	
	/** The Constant TRANSLATE_SOURCE_ED. */
	public static final String TRANSLATE_SOURCE_ED = "Ã‹";
	
	/** The Constant TRANSLATE_TARGET_I. */
	public static final String TRANSLATE_TARGET_I = "I";
	
	/** The Constant TRANSLATE_SOURCE_IT. */
	public static final String TRANSLATE_SOURCE_IT = "Ã�";
	
	/** The Constant TRANSLATE_SOURCE_ID. */
	public static final String TRANSLATE_SOURCE_ID = "Ã�";
	
	/** The Constant TRANSLATE_TARGET_O. */
	public static final String TRANSLATE_TARGET_O = "O";
	
	/** The Constant TRANSLATE_SOURCE_OT. */
	public static final String TRANSLATE_SOURCE_OT = "Ã“";
	
	/** The Constant TRANSLATE_SOURCE_OD. */
	public static final String TRANSLATE_SOURCE_OD = "Ã–";
	
	/** The Constant TRANSLATE_TARGET_U. */
	public static final String TRANSLATE_TARGET_U = "U";
	
	/** The Constant TRANSLATE_SOURCE_UT. */
	public static final String TRANSLATE_SOURCE_UT = "Ãš";
	
	/** The Constant TRANSLATE_SOURCE_UD. */
	public static final String TRANSLATE_SOURCE_UD = "Ãœ";
	
	/** The Constant TRANSLATE_TARGET_N. */
	public static final String TRANSLATE_TARGET_N = "N";
	
	/** The Constant TRANSLATE_SOURCE_N. */
	public static final String TRANSLATE_SOURCE_N = "Ã‘";
	
	/** The Constant TRANSLATE_TARGET_C. */
	public static final String TRANSLATE_TARGET_C = "C";
	
	/** The Constant TRANSLATE_SOURCE_C. */
	public static final String TRANSLATE_SOURCE_C = "Ã‡";

	// panel total values
	/** The Constant PANEL_ADM. */
	public static final String PANEL_ADM = "ADM";
	
	/** The Constant PANEL_CONF. */
	public static final String PANEL_CONF = "CONF";
	
	/** The Constant PANEL_REDACT. */
	public static final String PANEL_REDACT = "REDACT";
	
	/** The Constant PANEL_INBOX. */
	public static final String PANEL_INBOX = "INBOX";
	
	/** The Constant PANEL_REQ. */
	public static final String PANEL_REQ = "REQUEST";

	// BBDD POSTGRES
	/** The Constant ORACLEDB. */
	public static final String ORACLEDB = "oracle";

	/** The Constant UPLOAD_TEMP_EXTENSION. */
	public static final String UPLOAD_TEMP_EXTENSION = ".upload";

	// COOKIES
	// 1 week in seconds
	/** The Constant COOKIE_MAX_AGE. */
	public static final int COOKIE_MAX_AGE = 604800;
	
	/** The Constant COOKIE_USER_NAME. */
	public static final String COOKIE_USER_NAME = "pfirmaUserCookie";
	
	/** The Constant COOKIE_SECURITY_PATTERN_NAME. */
	public static final String COOKIE_SECURITY_PATTERN_NAME = "pfirmaSecurityPatternCookie";

	// server
	/** The Constant DNI_FIELD. */
	public final static String DNI_FIELD = "dni";
	
	/** The Constant SURNAME_FIELD. */
	public final static String SURNAME_FIELD = "apellidos";
	
	/** The Constant NAME_FIELD. */
	public final static String NAME_FIELD = "nombre";

	// WS-Security
	/** The Constant WS_SECURITY_HEADER_NS_URI. */
	public static final String WS_SECURITY_HEADER_NS_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
	
	/** The Constant WS_SECURITY_HEADER_LOCALPART. */
	public static final String WS_SECURITY_HEADER_LOCALPART = "Security";

	/** The Constant TEST. */
	public static final String TEST = "Test";
	
	/** The Constant TEST_URL. */
	public static final String TEST_URL = "http://www.google.com";
}
