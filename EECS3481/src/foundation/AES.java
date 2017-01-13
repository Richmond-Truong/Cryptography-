package foundation;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class b21 {
	public static void main(String[]args)throws Exception{

		byte[] Key = CryptoTools.hexToBytes("9F0DCEDB322F3C6873F9256E01376BA4");  
		byte[] IV  = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
		byte[] ct = CryptoTools.hexToBytes("F38ADBA8A7B4CC613578355032205D50");
		Cipher engine = Cipher.getInstance("AES/CBC/PKCS5Padding");
		AlgorithmParameterSpec aps = new IvParameterSpec(IV);
		Key myKey = new SecretKeySpec(Key, "AES");
		engine.init(Cipher.DECRYPT_MODE, myKey, aps);
		byte[] back = engine.doFinal(ct);
		System.out.println(new String(back));
		
	}
}
