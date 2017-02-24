package es.novasoft.sitae.business.dao.interfaz;

import es.novasoft.sitae.business.dao.support.GenericDao;
import es.novasoft.sitae.business.objects.Configuracion;

public interface ConfiguracionDAO extends GenericDao<Configuracion, String> {

	public String desencriptar(Configuracion conf);

}
