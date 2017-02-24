package es.novasoft.sitae.business.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.sitae.business.dao.interfaz.PublicacionRedesSocialesDAO;
import es.novasoft.sitae.business.dao.support.GenericDao;
import es.novasoft.sitae.business.objects.PublicacionRedesSociales;
import es.novasoft.sitae.business.services.interfaz.PublicacionRedesSocialesService;
import es.novasoft.sitae.business.services.support.GenericServiceImpl;

public class PublicacionRedesSocialesServiceImpl extends GenericServiceImpl<PublicacionRedesSociales, Long> implements PublicacionRedesSocialesService {

	private static final Log log = LogFactory.getLog(PublicacionRedesSocialesServiceImpl.class);

	private PublicacionRedesSocialesDAO publicacionRedesSocialesDAO;

	@Override
	public Log log() {

		return log;
	}

	@Override
	public Class<PublicacionRedesSociales> tipoClase() {

		return PublicacionRedesSociales.class;
	}

	@Override
	public GenericDao<PublicacionRedesSociales, Long> getDao() {

		return publicacionRedesSocialesDAO;
	}

	public PublicacionRedesSocialesDAO getPublicacionRedesSocialesDAO() {
		return publicacionRedesSocialesDAO;
	}

	public void setPublicacionRedesSocialesDAO(PublicacionRedesSocialesDAO publicacionRedesSocialesDAO) {
		this.publicacionRedesSocialesDAO = publicacionRedesSocialesDAO;
	}

}
