package Recursion;

public class FactorialRec {

	public static void main(String[] args) {
		int n=5;
		System.out.println(fact(n));
	}
	static int fact(int n) {
		// Base condition
		if(n <=1) {
			return 1;
		}
		return n * fact(n-1);
	}

}
