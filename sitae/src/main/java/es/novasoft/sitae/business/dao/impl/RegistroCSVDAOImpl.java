package es.novasoft.sitae.business.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.sitae.business.dao.interfaz.RegistroCSVDAO;
import es.novasoft.sitae.business.dao.support.GenericDaoImpl;
import es.novasoft.sitae.business.objects.RegistroCSV;

public class RegistroCSVDAOImpl extends GenericDaoImpl<RegistroCSV, String> implements RegistroCSVDAO {

	private static final Log log = LogFactory.getLog(RegistroCSVDAOImpl.class);

	@Override
	public Log log() {

		return log;
	}

	@Override
	public Class<RegistroCSV> tipoClase() {

		return RegistroCSV.class;
	}

}
