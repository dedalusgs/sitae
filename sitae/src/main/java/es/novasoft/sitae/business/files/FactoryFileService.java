/**
 * 
 */
package es.novasoft.sitae.business.files;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.converters.StringArrayConverter;

import es.novasoft.sitae.business.objects.Edicto;

/**
 * @author dabel
 * 
 */
public class FactoryFileService {

	List<FileService> listadoFileService;

	public FileService getService(Edicto edicto) {

		String url = null;
		if (edicto.getPdfAdjunto() != null) {
			url = edicto.getPdfAdjunto().toString();
		}
		FileService fileService = null;
		for (Iterator<FileService> iterator = this.listadoFileService.iterator(); iterator.hasNext() && (fileService == null);) {
			FileService fileServiceAux = iterator.next();
			if (fileServiceAux.checkPatron(url)) {
				fileService = fileServiceAux;
			}

		}
		if (fileService == null || url == null) {
			String patron = "default";
			for (Iterator<FileService> iterator = this.listadoFileService.iterator(); iterator.hasNext() && (fileService == null);) {
				FileService fileServiceAux = iterator.next();
				if (fileServiceAux.checkPatron(patron)) {
					fileService = fileServiceAux;
				}

			}
		}
		return fileService;
	}

	public List<FileService> getListadoFileService() {
		return this.listadoFileService;
	}

	public void setListadoFileService(List<FileService> listadoFileService) {
		this.listadoFileService = listadoFileService;
	}

}
