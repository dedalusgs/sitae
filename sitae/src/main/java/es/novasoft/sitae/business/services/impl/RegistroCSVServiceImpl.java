package es.novasoft.sitae.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.dao.interfaz.RegistroCSVDAO;
import es.novasoft.sitae.business.dao.support.GenericDao;
import es.novasoft.sitae.business.objects.RegistroCSV;
import es.novasoft.sitae.business.services.interfaz.RegistroCSVService;
import es.novasoft.sitae.business.services.support.GenericServiceImpl;

public class RegistroCSVServiceImpl extends GenericServiceImpl<RegistroCSV, String> implements RegistroCSVService {
	private static final Log log = LogFactory.getLog(RegistroCSVServiceImpl.class);

	private RegistroCSVDAO registroCSVDAO;

	public RegistroCSVServiceImpl() {

	}

	@Override
	public Log log() {
		return log;
	}

	@Override
	public Class<RegistroCSV> tipoClase() {
		return RegistroCSV.class;

	}

	@Override
	public GenericDao<RegistroCSV, String> getDao() {
		return registroCSVDAO;
	}

	public RegistroCSVDAO getRegistroCSVDAO() {
		return registroCSVDAO;
	}

	public void setRegistroCSVDAO(RegistroCSVDAO registroCSVDAO) {
		this.registroCSVDAO = registroCSVDAO;
	}

	public RegistroCSV findBySourceDoc(String id) throws ServiceException {
		try {
			List<RegistroCSV> lista = registroCSVDAO.findByProperty("sourceDoc", id);
			if (!lista.isEmpty()) {
				return lista.get(0);

			} else {
				return null;
			}
		} catch (DAOException e) {
			log.error("Error al obtener sourceDoc BBDD", e);
			throw new ServiceException("Error al obtener sourceDoc BBDD");
		}

	}

}
