package es.novasoft.sitae.business.services.interfaz;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface PasswordService {

	/**
	 * Encrypts the supplied plaintext password with the default message digest
	 * MD5 algorithm.
	 */
	public String getEncryptedPassword(String plaintext)
			throws NoSuchAlgorithmException, UnsupportedEncodingException;

	/**
	 * Encrypts the supplied plaintext password with the supplied algorithm.
	 */
	public String getEncryptedPassword(String plaintext, String algorithm)
			throws NoSuchAlgorithmException, UnsupportedEncodingException;

}