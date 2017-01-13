package foundation;

import util.CryptoTools;

public class OTP_Crypta {

	public static void main(String[] args) throws Exception {
		byte[] ct1 = CryptoTools.hexToBytes("0A4F0C08003503492F247442105B5757");
		byte[] ct2 = CryptoTools.hexToBytes("5E2769286B507A69494B066252343579");
		byte[] ct3 = CryptoTools.hexToBytes("170708454B1116002A2E2111725F5000");
		byte[] k2 = new byte[ct1.length];
		k2 = xor(ct1,ct2);
	    byte[] pt = xor(k2,ct3);
	    CryptoTools.bytesToFile(pt, "data/OTP.ct");
		
	}
	private static byte[] xor(byte[] x, byte[] y) throws Exception
	{
		if (x.length != y.length) throw new Exception("Lengths Mismatch!");
		byte[] result = new byte[x.length];
		
		for (int i = 0; i < x.length; i++)
		{
			result[i] = (byte) (x[i] ^ y[i]);
		}
		return result; 
	}
}
