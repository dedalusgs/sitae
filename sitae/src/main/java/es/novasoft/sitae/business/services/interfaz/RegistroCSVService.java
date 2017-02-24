package es.novasoft.sitae.business.services.interfaz;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.RegistroCSV;
import es.novasoft.sitae.business.services.support.GenericService;

public interface RegistroCSVService extends GenericService<RegistroCSV, String> {

	public RegistroCSV findBySourceDoc(String id) throws ServiceException;
}
