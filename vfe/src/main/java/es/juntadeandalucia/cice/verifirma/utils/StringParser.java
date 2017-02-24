/*

 Empresa desarrolladora: GuadalTEL S.A.

 Autor: Junta de AndalucÃ­a

 Derechos de explotaciÃ³n propiedad de la Junta de AndalucÃ­a.

 Ã‰ste programa es software libre: usted tiene derecho a redistribuirlo y/o modificarlo bajo los tÃ©rminos de la Licencia EUPL European Public License publicada 
 por el organismo IDABC de la ComisiÃ³n Europea, en su versiÃ³n 1.0. o posteriores.

 Ã‰ste programa se distribuye de buena fe, pero SIN NINGUNA GARANTÃ�A, incluso sin las presuntas garantÃ­as implÃ­citas de USABILIDAD o ADECUACIÃ“N A PROPÃ“SITO 
 CONCRETO. Para mas informaciÃ³n consulte la Licencia EUPL European Public License.

 Usted recibe una copia de la Licencia EUPL European Public License junto con este programa, si por algÃºn motivo no le es posible visualizarla, puede 
 consultarla en la siguiente URL: http://ec.europa.eu/idabc/servlets/Doc?id=31099

 You should have received a copy of the EUPL European Public License along with this program. If not, see http://ec.europa.eu/idabc/servlets/Doc?id=31096

 Vous devez avoir reÃ§u une copie de la EUPL European Public License avec ce programme. Si non, voir http://ec.europa.eu/idabc/servlets/Doc?id=31205

 Sie sollten eine Kopie der EUPL European Public License zusammen mit diesem Programm. Wenn nicht, finden Sie da 
 http://ec.europa.eu/idabc/servlets/Doc?id=29919

 */

package es.juntadeandalucia.cice.verifirma.utils;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class StringParser.
 */
public final class StringParser {

	/** The instance. */
	private static StringParser instance = null;
	
	/** The Constant DEFAULT_SHORT_LENGTH. */
	public static final int DEFAULT_SHORT_LENGTH = 55;
	
	/** The Constant DOUBLE_PATTERN. */
	public static final String DOUBLE_PATTERN = "##############################";

	/**
	 * Instantiates a new string parser.
	 */
	private StringParser() {
	}

	/**
	 * Creates the instance.
	 */
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new StringParser();
		}
	}

	/**
	 * Gets the single instance of StringParser.
	 *
	 * @return single instance of StringParser
	 */
	public static StringParser getInstance() {
		if (instance == null)
			createInstance();
		return instance;
	}

	/**
	 * String to byte.
	 *
	 * @param number the number
	 * @return the byte
	 */
	private byte stringToByte(String number) {
		return (byte) Integer.parseInt(number.substring(2), 16);
	}

	/**
	 * Clave autenticacion string to byte.
	 *
	 * @param pass the pass
	 * @return the byte[]
	 */
	public byte[] claveAutenticacionStringToByte(String pass) {
		StringTokenizer token = new StringTokenizer(pass, ",");
		int f = token.countTokens();
		byte[] b = new byte[f];
		for (int i = 0; i < f; i++) {
			b[i] = stringToByte(token.nextToken());
		}
		return b;
	}

	/**
	 * Short string.
	 *
	 * @param charString the char string
	 * @param size the size
	 * @return the string
	 */
	public String shortString(String charString, int size) {
		String res = "";
		String sufix = "...";
		if (charString != null && !charString.equals("")
				&& charString.length() >= size) {
			res = charString.substring(0, size - sufix.length()) + sufix;
		} else
			res = charString;
		return res;
	}

	/**
	 * Short string.
	 *
	 * @param charString the char string
	 * @return the string
	 */
	public String shortString(String charString) {
		return shortString(charString, DEFAULT_SHORT_LENGTH);
	}

	/**
	 * First upper and rest lower case.
	 *
	 * @param charString the char string
	 * @return the string
	 */
	public String firstUpperAndRestLowerCase(String charString) {
		if (charString == null || charString.equals(""))
			return "";

		String[] charStrings = null;
		String res = "";
		charStrings = charString.split(" ");
		for (int i = 0; i < charStrings.length; i++) {
			if (charStrings[i].length() > 0) {
				res += charStrings[i].substring(0, 1).toUpperCase()
						+ charStrings[i].substring(1, charStrings[i].length())
								.toLowerCase();
				if (i < charStrings.length - 1) {
					res += " ";
				}
			}
		}
		return res;
	}

	/**
	 * Extract class name.
	 *
	 * @param s the s
	 * @return the string
	 */
	public String extractClassName(Class s) {
		if (s != null) {
			String className = s.getName();
			String packageName = s.getPackage().getName();
			if (className != null && !className.equals("")) {
				if (packageName != null && !packageName.equals("")) {
					return className.replaceFirst(packageName + ".", "");
				} else {
					return className;
				}
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * Parses the double.
	 *
	 * @param d the d
	 * @return the string
	 */
	public String parseDouble(double d) {
		DecimalFormat f = new DecimalFormat(DOUBLE_PATTERN);
		return f.format(d);
	}
}
