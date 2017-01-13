package foundation;

import util.CryptoTools;

public class C_Exhaustive {

	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/Q4.ct");
		double larg = 0;
		int largi = 0;
		for(int i = 0; i < 26; i++){
			byte[] test = new byte[ct.length];
			double dot = 0;
			for(int j = 0 ; j < ct.length;j++){
				test[j] = (byte)((ct[j] - 'A' + i) % 26 + 'A');
			}
			
			int[] frq = CryptoTools.getFrequencies(test);
			for(int p = 0; p < frq.length; p++){
				dot += (frq[p] * CryptoTools.ENGLISH[p]);
			}
			if(i == 15){
				CryptoTools.bytesToFile(test, "data/MSG2.pt");
			}
			if(dot > larg){
				larg = dot;
				largi = i;
			}
			System.out.println(i + " " + dot);
		}
		System.out.println(largi + " " + larg);

	}

}
