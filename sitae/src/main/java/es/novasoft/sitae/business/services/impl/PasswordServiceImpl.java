package es.novasoft.sitae.business.services.impl;

/* PasswordServiceImpl.java
 * Created on 17 September 2003, 12:51
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import es.novasoft.sitae.business.services.interfaz.PasswordService;

/**
 * Class that takes a plain-text user supplied password, and applies a one-way
 * message digest algorithm to generate an encrypted password that will be
 * compared against an already encrypted password record, most likely held in a
 * database. This class will typically be used by a servlet or struts action
 * class that needs to enforce programmatic security.
 * 
 * @author Andrew Murphy
 */
public class PasswordServiceImpl implements PasswordService {

	// The 3 message digest algorithms (one-way hash algorithms) supported
	// by Tomcat
	public static final String MESSAGEDIGEST_SHA = "SHA";

	public static final String MESSAGEDIGEST_MD2 = "MD2";

	public static final String MESSAGEDIGEST_MD5 = "MD5"; // default

	private static PasswordService instance;

	/** Private modifier to prevent instantiation */
	private PasswordServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.bomberos.business.services.intranet.impl.PasswordService#getEncryptedPassword(java.lang.String)
	 */
	public synchronized String getEncryptedPassword(String plaintext)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return getEncryptedPassword(plaintext, MESSAGEDIGEST_MD5);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.novasoft.bomberos.business.services.intranet.impl.PasswordService#getEncryptedPassword(java.lang.String,
	 *      java.lang.String)
	 */
	public synchronized String getEncryptedPassword(String plaintext,
			String algorithm) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
			md.update(plaintext.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException nsae) {
			throw nsae;
		} catch (UnsupportedEncodingException uee) {
			throw uee;
		}
		return (new BigInteger(1, md.digest())).toString(16);
	}

	/**
	 * Utilises the Singleton pattern as there is no need to create separate
	 * instances
	 */
	public static synchronized PasswordService getInstance() {
		if (instance == null)
			instance = new PasswordServiceImpl();
		return instance;
	}

	/**
	 * Example implementation
	 */
	// public static void main(String[] args) {
	// String plaintext = "mypassword";
	// PasswordService pws = PasswordServiceImpl.getInstance();
	// try {
	// String passwordHash = pws.getEncryptedPassword(plaintext);
	// System.out.println(passwordHash);
	// } catch (NoSuchAlgorithmException e) {
	// System.out.println(e.getMessage());
	// } catch (UnsupportedEncodingException ue) {}
	// }
}