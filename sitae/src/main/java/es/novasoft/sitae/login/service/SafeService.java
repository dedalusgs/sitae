package es.novasoft.sitae.login.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cv.xaloc.cliente.safe.data.directo.GetInformacionWSRequest;
import com.cv.xaloc.cliente.safe.data.directo.GetInformacionWSResponse;
import com.cv.xaloc.cliente.safe.data.directo.ObjectFactory;
import com.cv.xaloc.cliente.safe.services.ClienteSAFEService;

import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.utils.OrganismoVisualizar;

public class SafeService {

	private String urlSafeBus;

	Log log = LogFactory.getLog(SafeService.class);

	public SafeService() {

	}

	public String getUrlSafeBus() {
		return urlSafeBus;
	}

	public void setUrlSafeBus(String urlSafeBus) {
		urlSafeBus = urlSafeBus;
	}

	public String validarCertificadoNIF(OrganismoVisualizar entidad, String token) {

		Log log = LogFactory.getLog(SafeService.class);
		String idEntidad = entidad.getCodigo();
		ClienteSAFEService clienteSafe = (ClienteSAFEService) Factory.getBean("clienteSAFE");
		try {

			ObjectFactory of = new ObjectFactory();
			GetInformacionWSRequest request2 = of.createGetInformacionWSRequest();
			request2.setToken(token);

			GetInformacionWSResponse ret = clienteSafe.getInformacion(idEntidad, request2);

			if (ret != null) {
				return ret.getNif();
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error("error Servicio Safe", e);
			return null;
		}

	}

}
