package es.novasoft.comun.utils;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	public static byte[] toArrayByte(String cadena) {
		try {
			return cadena.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String toString(byte[] array) {
		try {
			return new String(array, "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			return null;
		}
	}
}
