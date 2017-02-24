package es.novasoft.castellon.vfe.csv;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itextpdf.text.PageSize;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import es.novasoft.comun.constantes.Constantes;

public class GeneradorPDFcsv {

	public GeneradorPDFcsv() {

	}

	private static Log logger = LogFactory.getLog(GeneradorPDFcsv.class);
	private static String csv_text = null;
	private static String csv_recovery_url = null;

	public static OutputStream addCsv(InputStream in, String csvText, String csvRecoveryUrl) throws IOException, DocumentException {
		OutputStream baos = new ByteArrayOutputStream();
		PdfReader reader = new PdfReader(in);
		PdfStamper stamper = new PdfStamper(reader, baos);
		PdfContentByte over = null;

		BaseFont font = BaseFont.createFont("Helvetica", "Cp1252", false);
		int total = reader.getNumberOfPages() + 1;
		for (int i = 1; i < total; i++) {
			over = stamper.getOverContent(i);

			over.beginText();

			over.setFontAndSize(font, 5.0F);
			over.showTextAligned(0, csv_text + csvText, 5.0F, 12.0F, 0.0F);
			over.showTextAligned(0, csv_recovery_url + csvRecoveryUrl, 5.0F, 5.0F, 0.0F);
			over.endText();
		}
		stamper.close();

		return baos;
	}

	public static byte[] readFully(InputStream stream) {
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			int bytesRead;
			while ((bytesRead = stream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			logger.error("Error leyendo el inputStream: " + e.toString());
		}
		return baos.toByteArray();
	}

	public static byte[] pdfShrinkAddCsv(File in, String textCsv, String textUrl) throws Exception {
		try {
			csv_recovery_url = Constantes.getPropiedad("texto_url_csv");
			csv_text = Constantes.getPropiedad("texto_csv");
			InputStream in_data = new FileInputStream(in.getPath());
			PdfReader reader = new PdfReader(in_data);

			int n = reader.getNumberOfPages();
			Document document = new Document(com.lowagie.text.PageSize.A4);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			document.open();

			PdfContentByte directcontent = writer.getDirectContent();
			BaseFont font = BaseFont.createFont("Helvetica", "Cp1252", false);

			for (int i = 1; i <= n; i++) {
				PdfImportedPage page = writer.getImportedPage(reader, i);
				Image image = Image.getInstance(page);
				image.scaleAbsolute(PageSize.A4.getWidth() - 72.0F, PageSize.A4.getHeight() - 72.0F);
				image.setAbsolutePosition(36.0F, 36.0F);

				directcontent.addImage(image);
				directcontent.beginText();
				directcontent.setFontAndSize(font, 5.0F);
				directcontent.showTextAligned(0, csv_text + textCsv, 5.0F, 12.0F, 0.0F);
				directcontent.showTextAligned(0, csv_recovery_url + textUrl, 5.0F, 5.0F, 0.0F);
				directcontent.endText();
				document.newPage();
			}
			document.close();
			return baos.toByteArray();
		} catch (Exception ex) {
			logger.error("Exception inside CsvGenerator:: " + ex.getMessage());
			return null;
		}
	}

	public String getCsv_text() {
		return this.csv_text;
	}

	public void setCsv_text(String csv_text) {
		this.csv_text = csv_text;
	}

	public String getCsv_recovery_url() {
		return this.csv_recovery_url;
	}

	public void setCsv_recovery_url(String csv_recovery_url) {
		this.csv_recovery_url = csv_recovery_url;
	}
}
