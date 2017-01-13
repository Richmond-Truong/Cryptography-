package foundation;

import util.CryptoTools;

public class A_Crypta {
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/MSG3.ct");
		int[] frq = CryptoTools.getFrequencies(ct);
		for(int i = 0; i < frq.length; i ++){
			System.out.println(i+ " "+ (double)frq[i]/ct.length);
		}
	}
}
