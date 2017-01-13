package foundation;

import util.CryptoTools;
import java.math.BigInteger;

public class A_Exhaustive {
	static int[]  nums = { 1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25 };
	public static int modInverse(int a)
    {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(26)).intValue();
    }
	public static byte decode(byte c, int a, int b)
    {
		
          return (byte)  ('A' + (modInverse(nums[a]) * ((c-'A') - b + 26) % 26));
    }
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/Q4.ct");
		
		int a = 0, b = 0;
		byte[] max = new byte[ct.length];
		double largest = 0;
		for (int j = 0 ; j < nums.length; j ++)  {
			
			for (int i = 0; i < 26; i++){
				double dot = 0;

				byte[] test2 = ct;
				
				byte[] dec = new byte[ct.length];
				
				for (int p = 0; p < test2.length; p++) {
					
					dec[p] = decode(test2[p],j,i);
				}
				
				int[] frq = CryptoTools.getFrequencies(dec);
				for (int p = 0; p < frq.length; p++) {	
				
					dot += frq[p] * CryptoTools.ENGLISH[p];
				}
				
				if(dot > largest){
					a = nums[j];
					b = i;
					largest = dot;
					max = dec;
					
				}
			
			}
			
		}
		CryptoTools.bytesToFile(max, "data/test");
		System.out.println(a + " " + b + " " + largest);
	}
	

}
