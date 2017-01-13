package foundation;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class b23 {
	public static void main(String[]args)throws Exception{

		byte[] Key = "DO NOT TELL EVE!".getBytes();  
		byte[] IV  = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
		byte[] ct = CryptoTools.hexToBytes("3188073EA5DB3F5C05B6307B3595607135F5D4B22F2C3EB710AA31377F78B997");
		Cipher engine = Cipher.getInstance("AES/CBC/PKCS5Padding");
		AlgorithmParameterSpec aps = new IvParameterSpec(IV);
		Key myKey = new SecretKeySpec(Key, "AES");
		engine.init(Cipher.DECRYPT_MODE, myKey, aps);
		byte[] back = engine.doFinal(ct);
		System.out.println(new String(back));
		
	}
}
