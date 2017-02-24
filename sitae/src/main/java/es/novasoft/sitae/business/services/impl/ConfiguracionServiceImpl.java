package es.novasoft.sitae.business.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.sitae.business.dao.interfaz.ConfiguracionDAO;
import es.novasoft.sitae.business.dao.support.GenericDao;
import es.novasoft.sitae.business.objects.Configuracion;
import es.novasoft.sitae.business.services.interfaz.ConfiguracionService;
import es.novasoft.sitae.business.services.support.GenericServiceImpl;

public class ConfiguracionServiceImpl extends GenericServiceImpl<Configuracion, String> implements ConfiguracionService {

	private static final Log log = LogFactory.getLog(ConfiguracionServiceImpl.class);

	private ConfiguracionDAO configuracionDAO;

	@Override
	public Log log() {

		return log;
	}

	@Override
	public Class<Configuracion> tipoClase() {
		return Configuracion.class;
	}

	@Override
	public GenericDao<Configuracion, String> getDao() {

		return configuracionDAO;
	}

	public ConfiguracionDAO getConfiguracionDAO() {
		return configuracionDAO;
	}

	public void setConfiguracionDAO(ConfiguracionDAO configuracionDao) {
		this.configuracionDAO = configuracionDao;
	}

	public String desencriptar(Configuracion conf) {
		return configuracionDAO.desencriptar(conf);
	}

}
