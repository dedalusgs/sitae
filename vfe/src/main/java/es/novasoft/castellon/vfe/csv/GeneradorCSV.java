package es.novasoft.castellon.vfe.csv;

import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class GeneradorCSV {

	public GeneradorCSV() {

	}

	static String secret = "60e431591ee0b67f0d8a26aacbf5b77f8e0bc6213728c5140546040f0ee37f54";
	static String hmacalgo = "HMac-SHA256";
	static int csvSize = 32;

	public static String mkCSV(String docId, String signerID, byte[] useSeed) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		byte[] seed;

		if (useSeed != null) {
			seed = useSeed;
		} else {
			SecureRandom secureRandom = new SecureRandom();
			seed = new byte[4];
			secureRandom.nextBytes(seed);
		}
		Mac hmacSignerCSV = Mac.getInstance(hmacalgo, "BC");
		hmacSignerCSV.init(new SecretKeySpec(Hex.decode(secret), hmacalgo));
		hmacSignerCSV.reset();

		hmacSignerCSV.update(seed, 0, seed.length);
		hmacSignerCSV.update(signerID.getBytes(), 0, signerID.getBytes().length);
		hmacSignerCSV.update(docId.getBytes(), 0, docId.getBytes().length);
		byte[] hmacSigner = hmacSignerCSV.doFinal();

		String fullCsv = new String(Hex.encode(seed)) + new String(Hex.encode(hmacSigner));

		fullCsv = fullCsv.toUpperCase();
		String csv = "";
		int cont = 0;
		for (int i = fullCsv.length() - 1; i >= fullCsv.length() - csvSize + 1; i--) {
			csv = csv + ((cont % 8 == 0) && (cont > 0) ? "-" : "") + fullCsv.charAt(i);
			cont++;
		}

		return csv;
	}

	public static boolean checkCSV(String csv, String docId, String signerID) throws Exception {
		byte[] seed = Hex.decode(csv.trim().replace("-", "").substring(0, 8));

		return mkCSV(docId, signerID, seed).equals(csv);
	}

}
