package es.novasoft.sitae.comun.utils;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.sitae.business.objects.Organismo;

public class UtilUrlWeb {

	private static String protocolo = Constantes.getPropiedad(Constantes.PROTOCOLO);

	private static String nombreApp = Constantes.getPropiedad(Constantes.NOMBRE_APP);

	public static String getUrlBase(Organismo organismo, String cadenaAdicional) {
		return protocolo + "://" + organismo.getDominio() + "/" + nombreApp + cadenaAdicional;
	}

}
