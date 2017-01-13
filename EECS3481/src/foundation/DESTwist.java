package foundation;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class b32 {
	public static void main(String[]args)throws Exception{

		byte[] Key = CryptoTools.hexToBytes("6B79466F724D4F50");  
		byte[] IV  = CryptoTools.hexToBytes("6976466F724D4F50");
		byte[] ct1 = CryptoTools.hexToBytes("437DBAB5607137A5");
		byte[] ct2 = CryptoTools.hexToBytes("CFC1031114634087");
		Cipher engine = Cipher.getInstance("DES/ECB/NoPadding");
		//AlgorithmParameterSpec aps = new IvParameterSpec(IV);
		Key myKey = new SecretKeySpec(Key, "DES");
		engine.init(Cipher.DECRYPT_MODE, myKey);
		byte[] back = engine.doFinal(ct1);
		byte[] back2 = engine.doFinal(ct2);
		byte[] back3 = xor(IV,back);
		byte[] back4 = xor(ct1,back2);
		System.out.println(new String(back3));
		System.out.println(new String(back4));
		
	}
	private static byte[] xor(byte[] x, byte[] y) throws Exception
	{
		if (x.length != y.length) throw new Exception("Lengths Mismatch!");
		byte[] result = new byte[x.length];
		
		for (int i = 0; i < x.length; i++)
		{
			result[i] = (byte) (~x[i] ^ y[i]);
		}
		return result; 
	}
}
