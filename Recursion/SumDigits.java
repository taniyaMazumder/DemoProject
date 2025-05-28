package Recursion;

public class SumDigits {

	public static void main(String[] args) {
		int n=1342;
		System.out.println(sumDigits(n));
		System.out.println(prodDigits(n));

	}
	// print sum of all digits
	static int sumDigits(int n) {
		if(n ==0) {
			return 0;
		}
		return (n%10) + sumDigits(n/10);
	}
	
	// print prod of all digits
	static int prodDigits(int n) {
		if(n %10 ==n) {
			return n;
		}
		return prodDigits(n/10) * (n%10);
	}

}
