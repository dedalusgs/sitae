package es.novasoft.comun.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.constantes.Constantes;

public class GeneradorClavesUtil {

	private static Log log = LogFactory.getLog(GeneradorClavesUtil.class);

	public static String generarClaveEdictoCodigo(String codigoOrganismo,
			String anyoFechaActual, String contEdicto) throws Exception {

		StringBuffer sbClave = new StringBuffer();
		;

		try {

			sbClave = sbClave
					.append(Constantes.EDICTO_FORMATO_GENERAR_EXPEDIENTE_PARAMETRO_1); // EDICTO
			sbClave = sbClave
					.append(Constantes.EDICTO_FORMATO_GENERAR_EXPEDIENTE_SEPARADOR); // -
			sbClave = sbClave.append(codigoOrganismo); // Codigo de Municipio
			sbClave = sbClave
					.append(Constantes.EDICTO_FORMATO_GENERAR_EXPEDIENTE_SEPARADOR);// -
			sbClave = sbClave.append(anyoFechaActual); // Fecha
			sbClave = sbClave
					.append(Constantes.EDICTO_FORMATO_GENERAR_EXPEDIENTE_SEPARADOR);// -
			sbClave = sbClave.append(contEdicto); // Fecha
		} catch (Exception te) {
			log.error("Se ha producido un error al generar la clave");
			return null;
		}
		return sbClave.toString();
	}

}
