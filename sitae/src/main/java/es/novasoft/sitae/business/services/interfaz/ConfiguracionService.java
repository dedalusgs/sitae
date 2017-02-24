package es.novasoft.sitae.business.services.interfaz;

import es.novasoft.sitae.business.objects.Configuracion;
import es.novasoft.sitae.business.services.support.GenericService;

public interface ConfiguracionService extends GenericService<Configuracion, String> {
	public String desencriptar(Configuracion conf);
}
