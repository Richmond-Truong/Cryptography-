package foundation;

import util.CryptoTools;

public class C_Encrypt {
	public static void main(String[] args) throws Exception{
		byte[] pt = CryptoTools.fileToBytes("data/MSG1.pt");
		byte[] cpt = CryptoTools.clean(pt);
		CryptoTools.bytesToFile(cpt, "data/MSG1.clean");
		byte[] ct = new byte[cpt.length];
		for(int i = 0 ; i < cpt.length; i ++){
			ct[i] = (byte)((cpt[i] - 'A' + 19) % 26 + 'A');
		}
		CryptoTools.bytesToFile(ct, "data/MSG1.ct");
		System.out.println(CryptoTools.getMD5(ct));
		System.out.println(CryptoTools.getIC(ct));
		//System.out.println(pt);
		//System.out.println(cpt);
		
	}
}
