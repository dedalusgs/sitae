package es.novasoft.comun.utils;

public class AcentoUtil {
	public static String quitarAcentos(String cadena) {
		String result = cadena;
		try {
			if (result != null && !result.equals("")) {
				result = result.replace("�", "a");
				result = result.replace("�", "e");
				result = result.replace("�", "i");
				result = result.replace("�", "o");
				result = result.replace("�", "u");

				result = result.replace("�", "a");
				result = result.replace("�", "e");
				result = result.replace("�", "i");
				result = result.replace("�", "o");
				result = result.replace("�", "u");

				result = result.replace("�", "a");
				result = result.replace("�", "e");
				result = result.replace("�", "i");
				result = result.replace("�", "o");
				result = result.replace("�", "u");

				// PARA MAYUSCULAS
				result = result.replace("�", "A");
				result = result.replace("�", "E");
				result = result.replace("�", "I");
				result = result.replace("�", "O");
				result = result.replace("�", "U");

				result = result.replace("�", "A");
				result = result.replace("�", "E");
				result = result.replace("�", "I");
				result = result.replace("�", "O");
				result = result.replace("�", "U");

				result = result.replace("�", "A");
				result = result.replace("�", "E");
				result = result.replace("�", "I");
				result = result.replace("�", "O");
				result = result.replace("�", "U");
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
