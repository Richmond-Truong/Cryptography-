package foundation;

import util.CryptoTools;

public class IC {

	public static void main(String[] args)throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/Q4.ct");
	 	int[] frq = CryptoTools.getFrequencies(ct);
	 	for(int i = 0; i< 26; i++){
	 		System.out.println((double)frq[i]/ct.length);
	 	}
	}

}
