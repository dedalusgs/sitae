package es.novasoft.castellon.vfe.business.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.castellon.vfe.business.dao.interfaz.RegistroDocumentoDAO;
import es.novasoft.castellon.vfe.business.dao.support.GenericDao;
import es.novasoft.castellon.vfe.business.objects.RegistroDocumento;
import es.novasoft.castellon.vfe.business.services.interfaz.RegistroDocumentoService;
import es.novasoft.castellon.vfe.business.services.support.GenericServiceImpl;
import es.novasoft.comun.exceptions.DAOException;

public class RegistroDocumentoServiceImpl extends GenericServiceImpl<RegistroDocumento, Long> implements RegistroDocumentoService {
	private static Log log = LogFactory.getFactory().getInstance(RegistroDocumentoServiceImpl.class);

	private RegistroDocumentoDAO dao = null;

	public RegistroDocumentoServiceImpl() {

	}

	@Override
	public Log log() {

		return log;
	}

	@Override
	public GenericDao<RegistroDocumento, Long> getDao() {

		return dao;
	}

	public void setRegistroDocumentoDao(RegistroDocumentoDAO dao) {
		this.dao = dao;
	}

	public RegistroDocumentoDAO getRegistroDocumentoDao() {
		return this.dao;
	}

	@Override
	public Class<RegistroDocumento> tipoClase() {

		return RegistroDocumento.class;
	}

	public RegistroDocumento findRegistroDocumentoByCSV(String csv) {

		try {
			List<RegistroDocumento> lista = dao.findByProperty("csv", csv);
			if (!lista.isEmpty()) {
				return lista.get(0);
			} else {
				return null;
			}
		} catch (DAOException e) {
			log.error("Error buscando CSV", e);
			return null;
		}
	}

	public RegistroDocumento findRegistroDocumentoByIdRuta(String ruta) {

		try {
			List<RegistroDocumento> lista = dao.findByProperty("rutaFichero", ruta);
			if (!lista.isEmpty()) {
				return lista.get(0);
			} else {
				return null;
			}
		} catch (DAOException e) {
			log.error("Error buscando CSV", e);
			return null;
		}
	}

}
