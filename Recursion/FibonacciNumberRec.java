 package Recursion;

public class FibonacciNumberRec {
	public static void main(String[] args) {
		int n=7;
		System.out.println(fibo(n));
	}
	static int fibo(int n) {
		// Base condition
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fibo(n -1) + fibo(n-2);
	}
}
