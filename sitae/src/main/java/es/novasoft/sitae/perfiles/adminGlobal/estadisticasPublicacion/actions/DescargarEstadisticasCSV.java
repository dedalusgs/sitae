/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: InitDoAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.perfiles.adminGlobal.estadisticasPublicacion.actions;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;

import com.csvreader.CsvWriter;

import alfresco.sigex.castellon.ContentDocumentRequest;
import alfresco.sigex.castellon.ContentDocumentResponse;
import alfresco.sigex.castellon.IMuleRDWS;
import alfresco.sigex.castellon.IMuleRDWSServiceLocator;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Estado;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.objects.OrganismoExterno;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;
import es.novasoft.sitae.business.services.impl.CentroProcedenciaServiceImpl;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoExternoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;
import es.novasoft.sitae.login.forms.LoginCertificadoForm;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarEstadisticasCSV extends DownloadAction {
     
	private static Log log = LogFactory.getFactory().getInstance(
			DescargarEstadisticasCSV.class);
	
	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		EdictoService edictoService = (EdictoService) Factory
				.getBean(ServiceConstants.EDICTO_BEAN_NAME);

		OrganismoService organismoService = (OrganismoService) Factory
				.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		
		OrganismoExternoService organismoExternoService= (OrganismoExternoService)Factory.getBean(ServiceConstants.ORGANISMO_EXTERNO_SERVICIO_BEAN_NAME);
		try {
			
			
			String stringOrg=request.getParameter("org");
			String fechaInicio=request.getParameter("fechaInicio");
			String fechaFin=request.getParameter("fechaFin");
			byte[] ficheroCsv=null;
			List listadoOrgExternos=organismoExternoService.findAll();
			HashMap<Integer,OrganismoExterno> mapOrgExt=new HashMap<Integer,OrganismoExterno> ();
			
			for (Iterator<OrganismoExterno> i=listadoOrgExternos.iterator();i.hasNext();){
				OrganismoExterno aux=i.next();
				mapOrgExt.put(aux.getIdOrg(),aux);
				
			}
			if (stringOrg != null && !stringOrg.equals("")){
				
				Organismo organismo=organismoService.findById(Integer.parseInt(stringOrg));
				
				List resultado=edictoService.estadisticasCSVOrganismoExternosFechas(organismo, fechaInicio, fechaFin);
				
				
				
				ByteArrayOutputStream os_writer = new ByteArrayOutputStream();
				BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(os_writer));
				CsvWriter csvOutput = new CsvWriter(wtr , ',');
				;
				csvOutput.write("Area");
				csvOutput.write("Tipo");
				csvOutput.write("Org. Externo");
				csvOutput.write("Año");
				csvOutput.write("Mes");
				csvOutput.write("Cantidad");
				csvOutput.endRecord();
				
				for(Iterator iterador=resultado.iterator();iterador.hasNext();){
					
					Object[] us=(Object[])iterador.next();
					csvOutput.write(us[0].toString());
					csvOutput.write(us[5].toString());
					Integer idOrgExt=(Integer) us[6];
					if (idOrgExt!=null) {
						OrganismoExterno auxOrgExt= mapOrgExt.get(idOrgExt);
						csvOutput.write(auxOrgExt.getNombre());
					}else{
						csvOutput.write("Interno");
					}
					csvOutput.write(us[3].toString());
					csvOutput.write(us[4].toString());
					csvOutput.write(us[1].toString());
		     		csvOutput.endRecord();
				}
				
				csvOutput.flush();
				ficheroCsv=os_writer.toByteArray();
				csvOutput.close();
			}else{

				List resultado=edictoService.estadisticasCSVOrganismosExternosFechas( fechaInicio, fechaFin);
				ByteArrayOutputStream os_writer = new ByteArrayOutputStream();
				BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(os_writer));
				CsvWriter csvOutput = new CsvWriter(wtr , ',');
				
				csvOutput.write("Organismo");
				csvOutput.write("Area");
				csvOutput.write("Tipo");
				csvOutput.write("Org. Externo");
				csvOutput.write("Año");
				csvOutput.write("Mes");
				csvOutput.write("Cantidad");
				csvOutput.endRecord();
				
				for(Iterator iterador=resultado.iterator();iterador.hasNext();){
					Object[] us=(Object[])iterador.next();
					csvOutput.write(us[0].toString());
					csvOutput.write(us[3].toString());
					csvOutput.write(us[7].toString());
					Integer idOrgExt=(Integer) us[8];
					if (idOrgExt!=null) {
						OrganismoExterno auxOrgExt= mapOrgExt.get(idOrgExt);
						csvOutput.write(auxOrgExt.getNombre());
					}else{
						csvOutput.write("Interno");
					}
					csvOutput.write(us[5].toString());
					csvOutput.write(us[6].toString());
					csvOutput.write(us[1].toString());
					csvOutput.endRecord();
				}
				
				csvOutput.flush();
				ficheroCsv=os_writer.toByteArray();
				csvOutput.close();
				
				
				
				
			}
			
			
			
			String contentType = "text/csv";

				response.setHeader("Cache-Control", "cache");
				response.setHeader("Pragma", "cache");

				response.setHeader("Content-Disposition",
						("attachment;filename=\"estadisticas.csv\""));

				int longitud = ficheroCsv.length;

				// especifico el tamaño
				response.setContentLength(longitud);

				return new ByteArrayStreamInfo(contentType, ficheroCsv);
			
		} catch (Exception e) {
			log.error(e,e);
			throw e;
		}
		
	}

	
	protected class ByteArrayStreamInfo implements StreamInfo {

		protected String contentType;
		protected byte[] bytes;

		public ByteArrayStreamInfo(String contentType, byte[] bytes) {
			this.contentType = contentType;
			this.bytes = bytes;
		}

		public String getContentType() {
			return contentType;
		}

		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(bytes);
		}
	}
}
