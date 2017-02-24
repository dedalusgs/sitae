/**
 * 
 */
package es.novasoft.castellon.vfe.business.files;

import java.util.Iterator;
import java.util.List;

/**
 * @author dabel
 * 
 */
public class FactoryFileService {

	List<FileService> listadoFileService;

	public FileService getService(String urlDocumento) {

		String url = null;
		if (urlDocumento != null) {
			url = urlDocumento;
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
