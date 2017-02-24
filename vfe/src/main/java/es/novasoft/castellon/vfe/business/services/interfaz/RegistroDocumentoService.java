package es.novasoft.castellon.vfe.business.services.interfaz;

import es.novasoft.castellon.vfe.business.objects.RegistroDocumento;
import es.novasoft.castellon.vfe.business.services.support.GenericService;

public interface RegistroDocumentoService extends GenericService<RegistroDocumento, Long> {
	public RegistroDocumento findRegistroDocumentoByCSV(String csv);

	public RegistroDocumento findRegistroDocumentoByIdRuta(String ruta);
}
