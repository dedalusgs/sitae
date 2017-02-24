/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: InitDoAction.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
package es.novasoft.sitae.perfiles.adminGlobal.estadisticasPublicacion.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.comun.utils.UtilImageChart;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDoAction.
 */
public class DescargarEstadisticasPDF extends DownloadAction {
	
	private static Log	log	= LogFactory.getFactory().getInstance(DescargarEstadisticasPDF.class);
	
	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EdictoService edictoService = (EdictoService) Factory.getBean(ServiceConstants.EDICTO_BEAN_NAME);
		
		OrganismoService organismoService = (OrganismoService) Factory.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
		try {
			
			String stringOrg = request.getParameter("org");
			String fechaInicio = request.getParameter("fechaInicio");
			String fechaFin = request.getParameter("fechaFin");
			
			String rutaPlantilla = Constantes.getPropiedad(Constantes.RUTA_PLANTILLA_ESTADISTICAS_ABSOLUTA);
			PdfReader reader = new PdfReader(rutaPlantilla);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Organismo organismo = null;
			if (stringOrg != null && !stringOrg.equals("")) {
				organismo = organismoService.findById(new Integer(stringOrg));
				
			} else {
				String cif = (String) request.getSession().getAttribute("cif");
				organismo = (Organismo) organismoService.findByCif(cif).get(Constantes.CERO_INT);
			}
			
			String rutaEscudo = Constantes.getPropiedad(Constantes.RUTA_PLANTILLA_ESTADISTICAS_ABSOLUTA_ESCUDO);
			
			HashMap<String, String> campos = new HashMap<String, String>();
			campos.put("organismo", "Diputació de Castelló");
			campos.put("domicilio", "");
			campos.put("telefono", "");
			campos.put("email", "");
			campos.put("rangoFechas", fechaInicio + " - " + fechaFin);
			
			campos.put("organismo2", "Diputació de Castelló");
			campos.put("domicilio2", "");
			campos.put("telefono2", "");
			campos.put("email2", "");
			campos.put("rangoFechas2", fechaInicio + " - " + fechaFin);
			
			// Creo la salida
			PdfStamper stamp = new PdfStamper(reader, stream);
			
			// Relleno los campos
			AcroFields formPDF = stamp.getAcroFields();
			
			// Relleno de la imagen del escudo
			java.util.List<AcroFields.FieldPosition> photograph = formPDF.getFieldPositions("escudo");
			if (photograph != null && photograph.size() > 0) {
				Rectangle rect = photograph.get(0).position;
				
				Image img = Image.getInstance(rutaEscudo);
				// Image img = Image.getInstance(rutaEscudo);
				img.scaleToFit(rect.getWidth(), rect.getHeight());
				img.scaleToFit(rect.getWidth(), rect.getHeight());
				img.setBorder(2);
				img.setAbsolutePosition(rect.getLeft() + (rect.getWidth() - img.getScaledWidth()), rect.getTop() - (rect.getHeight()));
				PdfContentByte cb = stamp.getOverContent((int) photograph.get(0).page);
				cb.addImage(img);
			}
			
			photograph = formPDF.getFieldPositions("escudo2");
			if (photograph != null && photograph.size() > 0) {
				Rectangle rect = photograph.get(0).position;
				
				Image img = Image.getInstance(rutaEscudo);
				// Image img = Image.getInstance(rutaEscudo);
				img.scaleToFit(rect.getWidth(), rect.getHeight());
				img.scaleToFit(rect.getWidth(), rect.getHeight());
				img.setBorder(2);
				img.setAbsolutePosition(rect.getLeft() + (rect.getWidth() - img.getScaledWidth()), rect.getTop() - (rect.getHeight()));
				PdfContentByte cb = stamp.getOverContent((int) photograph.get(0).page);
				cb.addImage(img);
			}
			String urlImagen = UtilImageChart.generarURLEstadisticasPublicacion(stringOrg, fechaInicio, fechaFin, false);
			ByteArrayOutputStream imageArray = UtilImageChart.generarImagen(urlImagen);
			
			photograph = formPDF.getFieldPositions("estadisticasImagen");
			if (photograph != null && photograph.size() > 0) {
				Rectangle rect = photograph.get(0).position;
				Image img = Image.getInstance(imageArray.toByteArray());
				
				img.scalePercent(new Float(76.4));
				img.setAbsolutePosition(rect.getLeft(), rect.getTop() - img.getScaledHeight());
				PdfContentByte cb = stamp.getOverContent((int) photograph.get(0).page);
				cb.addImage(img);
			}
			urlImagen = UtilImageChart.generarURLEstadisticasPublicacionOrgExter(stringOrg, fechaInicio, fechaFin, false);
			imageArray = UtilImageChart.generarImagen(urlImagen);
			
			photograph = formPDF.getFieldPositions("estadisticasProcedenciaImagen");
			if (photograph != null && photograph.size() > 0) {
				Rectangle rect = photograph.get(0).position;
				Image img = Image.getInstance(imageArray.toByteArray());
				
				img.scalePercent(new Float(76.4));
				img.setAbsolutePosition(rect.getLeft(), rect.getTop() - img.getScaledHeight());
				PdfContentByte cb = stamp.getOverContent((int) photograph.get(0).page);
				cb.addImage(img);
			}
			// Recorremos el el map para poder rellenar el pdf
			
			Set<String> claves = campos.keySet();
			
			Iterator<String> iterator = claves.iterator();
			
			while (iterator.hasNext()) {
				
				String clave = iterator.next();
				
				String valorAtributo = campos.get(clave);
				
				formPDF.setField(clave, valorAtributo);
				
			}
			
			// Cerrampos la apertura del fichero y de la plantilla
			
			stamp.setFormFlattening(true);
			stamp.close();
			reader.consolidateNamedDestinations();
			stream.close();
			
			/*
			 * return new FileInputStream(f); Document document= new Document();
			 * ByteArrayOutputStream byteArrayOutputStream = new
			 * ByteArrayOutputStream(); PdfWriter
			 * writer=PdfWriter.getInstance(document, byteArrayOutputStream);
			 * document.open(); Paragraph p = new Paragraph();
			 * p.setAlignment(Paragraph.ALIGN_CENTER); p.setFont(new
			 * Font(Font.HELVETICA, 24f, Font.UNDEFINED, new CMYKColor(0.9f,
			 * 0.7f, 0.4f, 0.1f))); p.setSpacingAfter(10f);
			 * p.add("ESTADÍSTICAS DE PUBLICACIÓN"); document.add(p); String
			 * urlImagen =
			 * UtilImageChart.generarURLEstadisticasPublicacion(stringOrg,
			 * fechaInicio, fechaFin); ByteArrayOutputStream
			 * imageArray=UtilImageChart.generarImagen(urlImagen); //URL
			 * serverURL = new URL(request.getScheme() +
			 * "://"+request.getServerName
			 * ()+":"+Integer.toString(request.getServerPort
			 * ())+request.getContextPath()+"/"+ urlImagen); Image img1 =
			 * Image.getInstance(imageArray.toByteArray());
			 * img1.setAlignment(Image.ALIGN_CENTER); img1.scalePercent(80,80);
			 * document.add(img1); document.close();
			 */
			byte[] arrayByte = stream.toByteArray();
			
			String contentType = "application/pdf";
			
			response.setHeader("Cache-Control", "cache");
			response.setHeader("Pragma", "cache");
			response.setHeader("Content-Disposition", ("attachment;filename=\"estadisticas.pdf\""));
			
			int longitud = arrayByte.length;
			
			// especifico el tamaño
			response.setContentLength(longitud);
			
			return new ByteArrayStreamInfo(contentType, arrayByte);
			
		} catch (Exception e) {
			log.error(e, e);
			throw e;
		}
		
	}
	
	protected class ByteArrayStreamInfo implements StreamInfo {
		
		protected String	contentType;
		protected byte[]	bytes;
		
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
