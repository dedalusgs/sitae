package es.novasoft.sitae.login.constantes;

import java.util.ResourceBundle;

public class ConstantesFirma {

	private static ResourceBundle bundle = ResourceBundle
			.getBundle("configuracion");

	public static String getPropiedad(String propiedad) {
		return bundle.getString(propiedad);
	}

	/*-------------------------------------------*/
	/* CONSTANTES PENDIENTES DE SER CONFIGURADAS */
	/*-------------------------------------------*/

	public static final String CERTIFICADO_IP_SERVIDOR = "fachada";

	public static final String CERTIFICADO_ID_AUTENTICACION_FIRMA = "autenticacion";

	public static final String CERTIFICADO_TRIPLEDESKEY = "clave3DES";

	public static final String URL_FIRMA = "urlFirma";

	public static final String PRINCIPIO_METODO = "Fin de metodo";

	public static final String FIN_METODO = "Fin de metodo";

	public static final String SESSION_BEAN_FIRMA = "bean_firma";

	/*-------------------------------------------*/
	/* REDIRECCIONAMIENTOS */
	/*-------------------------------------------*/

	public static final String DIR_SOL_MOD_DAT_FIS = "ModDatFis";

}
