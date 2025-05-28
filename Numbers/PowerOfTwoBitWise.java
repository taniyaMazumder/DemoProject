package Numbers;

public class PowerOfTwoBitWise {

	public static void main(String[] args) {
		int a = 32;
		System.out.println(checkPowerOfTwo(a));

	}

	private static boolean checkPowerOfTwo(int a) {
		
		int count =0;
		while(a >0) {
			a = a >> 1;
			if((a & 1) ==1) {
				count++;
			}
		}
		return count ==1;
		
//		return (a &(a-1)) ==0;
	}

}
