package Recursion;

public class Print1ToN {

	public static void main(String[] args) {
		int n=5;
		printAll(n);
	}
	// print 1,2,3,4,5
	static void print(int n) {
		if(n==0) {
			return;
		}
		print(n-1);
		System.out.println(n);
	}
	// print 5 4 3 2 1
		static void printRev(int n) {
			if(n==0) {
				return;
			}
			System.out.println(n);
			print(n-1);
		}
		
	// print 5 4 3 2 1 1 2 3 4 5
		static void printAll(int n) {
			if(n==0) {
			 return;
			}
			System.out.println(n);
			printAll(n-1);
			System.out.println(n);
		}
}
