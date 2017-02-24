package es.novasoft.castellon.vfe.verificar.ws.pfirma;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

public class FirmaUtil {

	public static byte[] obtenerDocumentoPortafirmas(byte[] ficheroEntrada,
			String transaccion, String fecha, String servidor,
			String nombreFirmante) throws Exception {
		byte vectorBytes[] = null;

		BaseFont helvetica = BaseFont.createFont("Helvetica", "Cp1252", false);
		// Fuente de letra que se elige para la firma
		Font fontArial = new Font(helvetica, 9F, 0);
		Font fontArial8 = new Font(helvetica, 8F, 0);
		Font fontArial10 = new Font(helvetica, 10F, 0);
		Font fontArialBold = new Font(helvetica, 9F, 1);
		Font fontArialBoldNot = new Font(helvetica, 8F, 1);
		Font fontArialBoldInd = new Font(helvetica, 7F, 1);
		Font fontArialBoldWhite = new Font(helvetica, 9F, 1, new Color(255,
				255, 255));
		Font fontArialCursiva = new Font(helvetica, 9F, 2);
		Font fontArialSub = new Font(helvetica, 10F, 4);
		Font fontArialSub9 = new Font(helvetica, 9F, 4);
		Font fontArialBold10 = new Font(helvetica, 10F, 1);
		Font fontArialBold12 = new Font(helvetica, 12F, 1);
		int NumColumns = 1;
		Phrase frase = new Phrase();
		PdfPCell celda = new PdfPCell(frase);
		Document document = null;
		document = new Document();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, buffer);
		document.addCreationDate();
		document.addProducer();
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		Barcode128 code128 = new Barcode128();
		code128.setCode(transaccion);
		com.lowagie.text.Image imagenS = code128.createImageWithBarcode(cb,
				null, null);
		Phrase phraseImagenS = new Phrase(new Chunk(imagenS, 0.0F, 0.0F));
		// Indica que contará la tabla con una fila, donde se puede añadir una
		// celda
		PdfPTable datatableCodigo = new PdfPTable(1);
		int headerwidthDataTableCodigo[] = { 100 };
		// Establece el ancho relativo de la tabla.
		datatableCodigo.setWidths(headerwidthDataTableCodigo);
		datatableCodigo.setSpacingBefore(0.0F);
		datatableCodigo.setSpacingAfter(0.0F);
		// Establece el porcentaje de ancho que la tabla del codigo de la firma
		// ocupan en la página.
		datatableCodigo.setWidthPercentage(100F);
		datatableCodigo.getDefaultCell().setBorderWidth(0.0F);
		celda = new PdfPCell(phraseImagenS);
		// Establece la alineación horizontal de la tabla relativa a la página.
		celda.setHorizontalAlignment(1);
		// Establece la alineación vertical de la tabla relativa a la página.
		celda.setVerticalAlignment(5);
		// Altura del rectangulo que lleva el codigo de la firma
		celda.setFixedHeight(40F);
		datatableCodigo.addCell(celda);


		// Para quitarle la altura a la página que por defecto es de un A4.
		float correccion = 100F;
		float altura = PageSize.A4.height() - correccion;
		// Indica que contará la tabla con una fila, donde se pueden añadir
		// hasta 1 celdas (solicitud dentro)
		PdfPTable datatableBorde = new PdfPTable(1);
		int headerwidthDataTableBorde[] = { 100 };
		datatableBorde.setWidths(headerwidthDataTableBorde);
		// Delimita el espacio que se deja antes de la tabla para firmar
		datatableBorde.setSpacingBefore(0.0F);
		// Delimita el espacio que se deja tras la tabla donde está la solicitud
		// para firmar
		datatableBorde.setSpacingAfter(-74.0F);
		// Establece el porcentaje de ancho que la tabla que rodea la solicitud
		// en la página.
		datatableBorde.setWidthPercentage(100F);
		datatableBorde.getDefaultCell().setBorderWidth(0.0F);
		celda = new PdfPCell();
		// Poniendo el setBorder a 0 en cada celda, se elimina la cuadricula que
		// rodea el PDF
		 celda.setBorder(0);
		celda.setHorizontalAlignment(1);
		celda.setVerticalAlignment(5);
		// Altura del marco que lleva dentro la solicitud
		celda.setFixedHeight(altura);
		datatableBorde.addCell(celda);

		PdfReader reader = null;

		try {
			reader = new PdfReader(ficheroEntrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int n = reader.getNumberOfPages();
		int i = 0;
		int p = 0;
		while (i < n) {
			i++;
			// Desplaza el contenido del PDF
			double fEscala = 0.59999999999999998D;
			// dx y dy mueven el contenido del PDF en las coordenadas x e y
			float dx = 60F;
			float dy = 165F;
			Rectangle rect = reader.getPageSizeWithRotation(i);
			float factorx = (PageSize.A4.width() / rect.width())
					* (float) Math.sqrt(fEscala);
			float factory = (PageSize.A4.height() / rect.height())
					* (float) Math.sqrt(fEscala);
			float factor = factorx >= factory ? factory : factorx;
			com.lowagie.text.pdf.PdfImportedPage page = writer.getImportedPage(
					reader, i);
			cb.addTemplate(page, factor, 0.0F, 0.0F, factor, dx, dy);
			cb.setRGBColorStroke(192, 192, 192);
			cb.stroke();
			// Indica que contará la tabla con una fila, donde se pueden añadir
			// hasta 5 celdas
			PdfPTable datatableCabecera = new PdfPTable(5);
			// Define el ancho de los campos Fecha y Hora, Página y sus
			// resultados
			int headerwidthsDatatableCabecera[] = {20, 30, 30, 20, 20 };
			datatableCabecera.setWidths(headerwidthsDatatableCabecera);
			datatableCabecera.setSpacingBefore(0.0F);
			datatableCabecera.setSpacingAfter(0.0F);
			// Establece el porcentaje de ancho que la tabla que indica, fecha,
			// hora, codigo... en la página.
			datatableCabecera.setWidthPercentage(100F);
			datatableCabecera.getDefaultCell().setBorderWidth(0.0F);

			Phrase fraseCodigo = new Phrase();
			fraseCodigo.add(new Chunk("Código Seguro de verificación:"+transaccion+ ". Permite la verificación de la integridad de una",fontArial8));
			fraseCodigo.add(Chunk.NEWLINE);
			fraseCodigo.add(new Chunk("copia de este documento electrónico en la dirección: " + servidor+"vfe" ,fontArial8));
			fraseCodigo.add(Chunk.NEWLINE);
			fraseCodigo.add(new Chunk("Este documento incorpora firma electrónica reconocida de acuerdo a la Ley 59/2003, de 19 de diciembre, de firma electrónica",fontArial8));
					
			celda = new PdfPCell(fraseCodigo);
			celda.setPaddingBottom(5F);
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(5);
			datatableCabecera.addCell(celda);

			celda = new PdfPCell(new Phrase("FIRMADO POR", fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);

			celda = new PdfPCell(new Phrase(nombreFirmante, fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(2);
			datatableCabecera.addCell(celda);
			
			celda = new PdfPCell(new Phrase("FECHA", fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);
			
			celda = new PdfPCell(new Phrase(fecha, fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setHorizontalAlignment(1);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);
			
			celda = new PdfPCell(new Phrase("ID. FIRMA", fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);
			celda = new PdfPCell(new Phrase(servidor, fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);

			celda = new PdfPCell(new Phrase(transaccion, fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);

			celda = new PdfPCell(new Phrase("P\301GINA", fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);
			celda = new PdfPCell(new Phrase(i + " / " + n, fontArial8));
			celda.setHorizontalAlignment(1);
			celda.setVerticalAlignment(4);
			celda.setColspan(1);
			datatableCabecera.addCell(celda);
			
			document.add(datatableBorde);

			document.add(datatableCabecera);
			document.add(datatableCodigo);
			document.newPage();
		}
		document.close();
		vectorBytes = buffer.toByteArray();
		return vectorBytes;
	}

}
