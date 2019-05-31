package utils;

/**
 * @author C5249742
 *
 */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class PassCrypt {

	public static final String AES = "AES";
	public static final String KEY = "F21E2A7FB6C68037FAEAA55222E320F7";

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
	
	public static String generateKey (String value) throws Exception {
		
		KeyGenerator keyGen = KeyGenerator.getInstance(PassCrypt.AES);
        keyGen.init(128);
        SecretKey sk = keyGen.generateKey();
        String sKey = byteArrayToHexString(sk.getEncoded());
        return sKey;
	}
	
	public static String encrypt(String value) throws Exception {

		byte[] bytekey = hexStringToByteArray(PassCrypt.KEY);
		SecretKeySpec sks = new SecretKeySpec(bytekey, PassCrypt.AES);
		Cipher cipher = Cipher.getInstance(PassCrypt.AES);
		cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
		byte[] encrypted = cipher.doFinal(value.getBytes());
		String sEncryptedValue = byteArrayToHexString(encrypted);
		return sEncryptedValue;
	}

	public static String decrypt(String value) throws Exception {

		byte[] bytekey = hexStringToByteArray(PassCrypt.KEY);
		SecretKeySpec sks = new SecretKeySpec(bytekey, PassCrypt.AES);
		Cipher cipher = Cipher.getInstance(PassCrypt.AES);
		cipher.init(Cipher.DECRYPT_MODE, sks);
		byte[] decrypted = cipher.doFinal(hexStringToByteArray(value));
		String sOriginalValue = new String(decrypted);
		return sOriginalValue;
	}
	
	
}
