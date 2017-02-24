package es.novasoft.comun.utils;

public class AcentoUtil {
	public static String quitarAcentos(String cadena) {
		String result = cadena;
		try {
			if (result != null && !result.equals("")) {
				result = result.replace("á", "a");
				result = result.replace("é", "e");
				result = result.replace("í", "i");
				result = result.replace("ó", "o");
				result = result.replace("ú", "u");

				result = result.replace("à", "a");
				result = result.replace("è", "e");
				result = result.replace("ì", "i");
				result = result.replace("ò", "o");
				result = result.replace("ù", "u");

				result = result.replace("ä", "a");
				result = result.replace("ë", "e");
				result = result.replace("ï", "i");
				result = result.replace("ö", "o");
				result = result.replace("ü", "u");

				// PARA MAYUSCULAS
				result = result.replace("Á", "A");
				result = result.replace("É", "E");
				result = result.replace("Í", "I");
				result = result.replace("Ó", "O");
				result = result.replace("Ú", "U");

				result = result.replace("À", "A");
				result = result.replace("È", "E");
				result = result.replace("Ì", "I");
				result = result.replace("Ò", "O");
				result = result.replace("Ù", "U");

				result = result.replace("Ä", "A");
				result = result.replace("Ë", "E");
				result = result.replace("Ï", "I");
				result = result.replace("Ö", "O");
				result = result.replace("Ü", "U");
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
