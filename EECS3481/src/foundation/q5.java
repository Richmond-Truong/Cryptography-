package foundation;

import util.CryptoTools;

public class q5 {

	public static void main(String[] args)throws Exception {
		byte[] ct1 = CryptoTools.hexToBytes("3D48044D420E5446411541054204131C");
		byte[] ct2 = CryptoTools.hexToBytes("284C0D4D5400425E4803410652040E1C");
		byte[] p1p = xor(ct1,ct2);
		byte[] drag = "bottle".getBytes();
		for(int i = 0 ; i < p1p.length-drag.length;i++){
			byte[] tmp = new byte[drag.length];
			for(int p = 0; p < drag.length; p++){
				tmp[p] = p1p[i+p];
			}
			System.out.println(new String(xor(tmp,drag)));
		}

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
