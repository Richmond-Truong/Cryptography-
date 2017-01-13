package foundation;

import util.CryptoTools;

public class V_Crypta {

	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/Q12.ct");

		int[] frq = CryptoTools.getFrequencies(ct);
		int curMatch = 0, maxMatch = 0, curShift = 1, maxShift = 1;
		for (; curShift <= 20; curShift++) {
			for (int i = 0; i < ct.length - curShift; i++) {
				if (ct[i] == ct[i + curShift]) {
					curMatch++;
				}
			}
			if (curMatch > maxMatch) {
				maxMatch = curMatch;
				maxShift = curShift;
			}
			
			curMatch = 0;
		}
		char[] key = new char[maxShift];
		for (int p = 0; p < maxShift; p++) {
			int[] freq = new int[26];
			
			for (int i = p; i < ct.length; i += maxShift) {
				
				freq[ct[i] - 'A']++;
			}
			
			
			int lar = 0;
			int lari = 0;
			for (int i = 0; i < freq.length; i++) {
				
				if (freq[i] > lar) {
					lar = freq[i];
					lari = i;
				}
			}
			int shift = ('A' + lari) -'E';
			
			if(shift < 0){
				shift += 26;
			}
			shift += 'A';	
			
			key[p] = (char)shift;
		}
		System.out.println(key);
		byte[]pt = new byte[ct.length];
		for(int i = 0 ; i < ct.length; i ++){
			pt[i] = (byte)((ct[i] - 'A' - (key[i%maxShift] -'A')) % 26);
			if(pt[i] < 0){
				pt[i] += 26;
			}
			pt[i] += 'A';
		}
		CryptoTools.bytesToFile(pt, "data/test");
	
		System.out.println("max match =" + maxMatch + " shift = " + maxShift);
	}

}
