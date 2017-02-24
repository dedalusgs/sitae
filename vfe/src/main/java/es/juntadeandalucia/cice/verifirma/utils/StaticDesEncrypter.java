package es.juntadeandalucia.cice.verifirma.utils;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class StaticDesEncrypter.
 */
public class StaticDesEncrypter {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(StaticDesEncrypter.class);

	/** The instance. */
	private static StaticDesEncrypter instance;

	/** The crypter. */
	private DesEncrypter crypter;

	/**
	 * Instantiates a new static des encrypter.
	 *
	 * @param clave the clave
	 * @throws Exception the exception
	 */
	public StaticDesEncrypter(String clave) throws Exception {
		byte[] claveEncode = StringParser.getInstance()
				.claveAutenticacionStringToByte(clave);
		DESKeySpec keyspec = new DESKeySpec(claveEncode);
		SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
		SecretKey k = kf.generateSecret(keyspec);
		crypter = new DesEncrypter(k);
	}

	/**
	 * Gets the single instance of StaticDesEncrypter.
	 *
	 * @param clave the clave
	 * @return single instance of StaticDesEncrypter
	 * @throws Exception the exception
	 */
	public static StaticDesEncrypter getInstance(String clave) throws Exception {
		if (instance == null)
			instance = new StaticDesEncrypter(clave);
		return instance;
	}

	/**
	 * Encode.
	 *
	 * @param s the s
	 * @return the string
	 */
	public String encode(String s) {
		try {
			return crypter.encrypt(s);
		} catch (Exception e) {
			LOGGER
					.error("Error encriptando '" + s + "'. Causa: "
							+ e.getMessage());
		}
		return null;
	}

	/**
	 * Decode.
	 *
	 * @param s the s
	 * @return the string
	 */
	public String decode(String s) {
		try {
			return crypter.decrypt(s);
		} catch (Exception e) {
			LOGGER.error("Error desencriptando '" + s + "'. Causa: "
					+ e.getMessage());
		}
		return null;
	}

}
