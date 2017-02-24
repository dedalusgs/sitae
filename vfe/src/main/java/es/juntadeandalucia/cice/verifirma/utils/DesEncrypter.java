
package es.juntadeandalucia.cice.verifirma.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.opencms.arrobafirma5.KitIntegracion.utils.Base64Coder;

// TODO: Auto-generated Javadoc
/**
 * The Class DesEncrypter.
 */
public class DesEncrypter {

	/** The ecipher. */
	private Cipher ecipher;
	
	/** The dcipher. */
	private Cipher dcipher;

	/**
	 * Instantiates a new des encrypter.
	 *
	 * @param key the key
	 * @throws Exception the exception
	 */
	public DesEncrypter(SecretKey key) throws Exception {
		ecipher = Cipher.getInstance("DES");
		dcipher = Cipher.getInstance("DES");
		ecipher.init(Cipher.ENCRYPT_MODE, key);
		dcipher.init(Cipher.DECRYPT_MODE, key);
	}

	/**
	 * Encrypt.
	 *
	 * @param str the str
	 * @return the string
	 * @throws Exception the exception
	 */
	public String encrypt(String str) throws Exception {
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);
		Base64Coder base64Coder = new Base64Coder();
		return new String(base64Coder.encodeBase64(enc), "UTF8");
	}

	/**
	 * Decrypt.
	 *
	 * @param str the str
	 * @return the string
	 * @throws Exception the exception
	 */
	public String decrypt(String str) throws Exception {
		Base64Coder base64Coder = new Base64Coder();
		byte[] dec = base64Coder.decodeBase64(str.getBytes());
		byte[] utf8 = dcipher.doFinal(dec);
		return new String(utf8, "UTF8");
	}
}
