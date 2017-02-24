package es.novasoft.castellon.vfe.business.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.castellon.vfe.business.dao.interfaz.RegistroDocumentoDAO;
import es.novasoft.castellon.vfe.business.dao.support.GenericDaoImpl;
import es.novasoft.castellon.vfe.business.objects.RegistroDocumento;

public class RegistroDocumentoDAOImpl extends GenericDaoImpl<RegistroDocumento, Long> implements RegistroDocumentoDAO {

	private static final Log log = LogFactory.getLog(RegistroDocumentoDAOImpl.class);

	public RegistroDocumentoDAOImpl() {
		super();

	}

	@Override
	public Log log() {

		return log;
	}

	@Override
	public Class<RegistroDocumento> tipoClase() {

		return RegistroDocumento.class;
	}

}
