/*

 Empresa desarrolladora: GuadalTEL S.A.

 Autor: Junta de Andalucía

 Derechos de explotación propiedad de la Junta de Andalucía.

 Éste programa es software libre: usted tiene derecho a redistribuirlo y/o modificarlo bajo los términos de la Licencia EUPL European Public License publicada 
 por el organismo IDABC de la Comisión Europea, en su versión 1.0. o posteriores.

 Éste programa se distribuye de buena fe, pero SIN NINGUNA GARANTÍA, incluso sin las presuntas garantías implícitas de USABILIDAD o ADECUACIÓN A PROPÓSITO 
 CONCRETO. Para mas información consulte la Licencia EUPL European Public License.

 Usted recibe una copia de la Licencia EUPL European Public License junto con este programa, si por algún motivo no le es posible visualizarla, puede 
 consultarla en la siguiente URL: http://ec.europa.eu/idabc/servlets/Doc?id=31099

 You should have received a copy of the EUPL European Public License along with this program. If not, see http://ec.europa.eu/idabc/servlets/Doc?id=31096

 Vous devez avoir reçu une copie de la EUPL European Public License avec ce programme. Si non, voir http://ec.europa.eu/idabc/servlets/Doc?id=31205

 Sie sollten eine Kopie der EUPL European Public License zusammen mit diesem Programm. Wenn nicht, finden Sie da 
 http://ec.europa.eu/idabc/servlets/Doc?id=29919

 */

package es.juntadeandalucia.cice.verifirma.utils;

import java.util.HashMap;

public final class MimeType {

	private final String mimeTypes[][] = {
			{ "txt", "text/plain" },
			{ "html", "text/html" },
			{ "xhtml", "application/xhtml+xml" },
			{ "ps", "application/postscript" },
			{ "aiff", "audio/x-aiff" },
			{ "acp", "application/acp" },
			{ "au", "audio/basic" },
			{ "avi", "video/x-msvideo" },
			{ "asf", "video/x-ms-asf" },
			{ "wmv", "video/x-ms-wmv" },
			{ "wma", "video/x-ms-wma" },
			{ "avx", "video/x-rad-screenplay" },
			{ "bcpio", "application/x-bcpio" },
			{ "bin", "application/octet-stream" },
			{ "cdf", "application/x-netcdf" },
			{ "cer", "application/x-x509-ca-cert" },
			{ "cgm", "image/cgm" },
			{ "class", "application/java" },
			{ "cpio", "application/x-cpio" },
			{ "csh", "application/x-csh" },
			{ "css", "text/css" },
			{ "doc", "application/msword" },
			{ "xml", "text/xml" },
			{ "dvi", "application/x-dvi" },
			{ "etx", "text/x-setext" },
			{ "gif", "image/gif" },
			{ "gml", "application/sgml" },
			{ "gtar", "application/x-gtar" },
			{ "gzip", "application/x-gzip" },
			{ "hdf", "application/x-hdf" },
			{ "hqx", "application/mac-binhex40" },
			{ "ief", "image/ief" },
			{ "bmp", "image/bmp" },
			{ "jpg", "image/jpeg" },
			{ "js", "application/x-javascript" },
			{ "latex", "application/x-latex" },
			{ "man", "application/x-troff-man" },
			{ "me", "application/x-troff-me" },
			{ "ms", "application/x-troff-mes" },
			{ "mif", "application/x-mif" },
			{ "mpg", "video/mpeg" },
			{ "mp3", "audio/x-mpeg" },
			{ "mp4", "video/mp4" },
			{ "mpeg2", "video/mpeg2" },
			{ "mov", "video/quicktime" },
			{ "movie", "video/x-sgi-movie" },
			{ "oda", "application/oda" },
			{ "pbm", "image/x-portable-bitmap" },
			{ "pdf", "application/pdf" },
			{ "pgm", "image/x-portable-graymap" },
			{ "png", "image/png" },
			{ "pnm", "image/x-portable-anymap" },
			{ "ppm", "image/x-portable-pixmap" },
			{ "ppt", "application/vnd.powerpoint" },
			{ "ras", "image/x-cmu-raster" },
			{ "rgb", "image/x-rgb" },
			{ "tr", "application/x-troff" },
			{ "rtf", "application/rtf" },
			{ "rtx", "text/richtext" },
			{ "sgml", "text/sgml" },
			{ "sh", "application/x-sh" },
			{ "shar", "application/x-shar" },
			{ "src", "application/x-wais-source" },
			{ "sv4cpio", "application/x-sv4cpio" },
			{ "sv4crc", "application/x-sv4crc" },
			{ "swf", "application/x-shockwave-flash" },
			{ "tar", "application/x-tar" },
			{ "tcl", "application/x-tcl" },
			{ "tex", "application/x-tex" },
			{ "texinfo", "application/x-texinfo" },
			{ "tiff", "image/tiff" },
			{ "tsv", "text/tab-separated-values" },
			{ "ustar", "application/x-ustar" },
			{ "wav", "audio/x-wav" },
			{ "wrl", "x-world/x-vrml" },
			{ "xbm", "image/x-xbitmap" },
			{ "xls", "application/vnd.excel" },
			{ "xpm", "image/x-xpixmap" },
			{ "xwd", "image/x-xwindowdump" },
			{ "z", "application/x-compress" },
			{ "zip", "application/zip" },
			{ "dwg", "image/x-dwg" },
			{ "dwt", "image/x-dwt" },
			{ "msg", "message/rfc822" },
			{ "odt", "application/vnd.oasis.opendocument.text" },
			{ "ott", "application/vnd.oasis.opendocument.text-template" },
			{ "oth", "application/vnd.oasis.opendocument.text-web" },
			{ "odm", "application/vnd.oasis.opendocument.text-master" },
			{ "odg", "application/vnd.oasis.opendocument.graphics" },
			{ "otg", "application/vnd.oasis.opendocument.graphics-template" },
			{ "odp", "application/vnd.oasis.opendocument.presentation" },
			{ "otp", "application/vnd.oasis.opendocument.presentation-template" },
			{ "ods", "application/vnd.oasis.opendocument.spreadsheet" },
			{ "ots", "application/vnd.oasis.opendocument.spreadsheet-template" },
			{ "odc", "application/vnd.oasis.opendocument.chart" },
			{ "odf", "application/vnd.oasis.opendocument.formula" },
			{ "odb", "application/vnd.oasis.opendocument.database" },
			{ "odi", "application/vnd.oasis.opendocument.image" },
			{ "sxc", "application/vnd.sun.xml.calc" },
			{ "sxd", "application/vnd.sun.xml.draw" },
			{ "sxi", "application/vnd.sun.xml.impress" },
			{ "sxw", "application/vnd.sun.xml.writer" },
			{ "sda", "application/vnd.stardivision.draw" },
			{ "sdc", "application/vnd.stardivision.calc" },
			{ "sdd", "application/vnd.stardivision.impress" },
			{ "sdp", "application/vnd.stardivision.impress-packed" },
			{ "sds", "application/vnd.stardivision.chart" },
			{ "sdw", "application/vnd.stardivision.writer" },
			{ "sgl", "application/vnd.stardivision.writer-global" },
			{ "smf", "application/vnd.stardivision.math" } };

	private static final String DEFAULT_MIMETYPE = "application/octet-stream";
	private static HashMap<String, String> mimes = null;
	private static MimeType instance = null;

	private MimeType() {
		mimes = new HashMap<String, String>();
		for (int i = 0; i < mimeTypes.length; i++) {
			mimes.put(mimeTypes[i][0], mimeTypes[i][1]);
		}
	}

	public static MimeType getInstance() {
		if (instance == null) {
			instance = new MimeType();
		}
		return instance;
	}

	public String mimeTypeOf(String nameFile) {
		String extension = "";
		if (nameFile != null) {
			int i = nameFile.lastIndexOf(".");
			if (i >= 0) {
				extension = nameFile.substring(i + 1, nameFile.length());
			} else {
				extension = nameFile;
			}
		}
		if (mimes.containsKey(extension.toLowerCase())) {
			return (String) mimes.get(extension.toLowerCase());
		} else {
			return DEFAULT_MIMETYPE;
		}
	}

	public String extractFileFromPath(String path) {
		String archivo = "";
		if (path != null && !path.equals("")) {
			String separador = System.getProperty("file.separator");
			int i = path.lastIndexOf(separador);
			if (i > 0) {
				archivo = path.substring(i + 1, path.length());
			} else {
				archivo = path;
			}
		}
		return archivo;
	}

	public String extractNameWithOutExtension(String name) {
		String archivo = "";
		if (name != null && !name.equals("")) {
			int i = name.lastIndexOf('.');
			if (i > 0) {
				archivo = name.substring(0, i);
			} else {
				archivo = name;
			}
		}
		return archivo;
	}

	public String extractTypeFromExtension(String extension) {
		return mimes.get(extension);
	}

}
