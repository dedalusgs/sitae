package es.novasoft.sitae.business.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.sitae.business.dao.interfaz.PublicacionRedesSocialesDAO;
import es.novasoft.sitae.business.dao.support.GenericDaoImpl;
import es.novasoft.sitae.business.objects.PublicacionRedesSociales;

public class PublicacionesRedesSocialesDAOImpl extends GenericDaoImpl<PublicacionRedesSociales, Long> implements PublicacionRedesSocialesDAO {

	public PublicacionesRedesSocialesDAOImpl() {
		super();
	}

	private static final Log log = LogFactory.getLog(PublicacionesRedesSocialesDAOImpl.class);

	@Override
	public Log log() {

		return log;
	}

	@Override
	public Class<PublicacionRedesSociales> tipoClase() {

		return PublicacionRedesSociales.class;
	}

}
