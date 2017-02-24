/**
 *
 */
package es.novasoft.comun.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author dabel
 *
 */
public class HashUtil {
    
    public final static String salt = "f#sitae@V)Hu^%Hgfds";
    
    public static String calcularSHA1(byte[] archivo) {
	
	MessageDigest messageDigest;
	try {
	    messageDigest = MessageDigest.getInstance("SHA-256");
	    
	    messageDigest.update(archivo);
	    
	    byte[] resumen = messageDigest.digest();
	    
	    // get the hash value as byte array
	    byte[] hash = messageDigest.digest();
	    
	    return byteArray2Hex(resumen);
	} catch (NoSuchAlgorithmException e) {
	    return null;
	}
    }
    
    private static String byteArray2Hex(byte[] hash) {
	StringBuffer sb = new StringBuffer("");
	for (int i = 0; i < hash.length; i++) {
	    sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
	}
	return sb.toString();
    }
    
    public static Boolean validarHashSHA1(byte[] archivo, String hash) {
	String hashArchivo = calcularSHA1(archivo);
	return hashArchivo.equals(hash);
	
    }
    
    public static String calcularSHAString(String password) {
	MessageDigest digest;
	byte[] hash = null;
	try {
	    digest = MessageDigest.getInstance("SHA-256");
	    password = password + HashUtil.salt;
	    hash = digest.digest(password.getBytes("UTF-8"));
	} catch (NoSuchAlgorithmException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return byteArray2Hex(hash);
    }
    
    public static Boolean validarHashSHA1(String password, String hash) {
	String hashArchivo = calcularSHAString(password);
	return hashArchivo.equals(hash);
	
    }
    
}
