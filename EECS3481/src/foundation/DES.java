package foundation;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class b31{
	public static void main(String[]args)throws Exception{

	byte[] Key = "CSE@YORK".getBytes();  
	byte[] IV  = CryptoTools.hexToBytes("4E51297B424F90D8");
	byte[] ct = CryptoTools.hexToBytes("B2ACD6ADF010DDC4");
	Cipher engine = Cipher.getInstance("DES/CBC/PKCS5Padding");
	AlgorithmParameterSpec aps = new IvParameterSpec(IV);
	//4E51297B424F90D8
	Key myKey = new SecretKeySpec(Key, "DES");
	engine.init(Cipher.DECRYPT_MODE, myKey, aps);
	byte[] back = engine.doFinal(ct);
	System.out.println(new String(back));
}
}