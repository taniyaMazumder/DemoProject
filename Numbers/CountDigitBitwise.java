package Numbers;

public class CountDigitBitwise {

	public static void main(String[] args) {
		int n = 3456890;
		int base =10;
		
		int digit = (int) (Math.log(n) / Math.log(base)) +1;
		
		System.out.println(digit);

	}

}
