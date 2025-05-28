package Recursion;

public class PalindromeRec {

	public static void main(String[] args) {
	//	System.out.println(checkPalindrome(32123));
		System.out.println(palindrome2("abcdba"));
	}

	static int reverseNumber2(int n) {
		int digits = (int) (Math.log10(n)+1);
		return helper(n,digits);
	}

	 static int helper(int n, int digits) {
		if(n %10 == n) {
			return n;
		}
		int rem = n %10;
		return rem * (int)(Math.pow(10, digits -1)) + helper(n/10, digits -1);
	}
	 
	static boolean checkPalindrome(int n) {
		return n == reverseNumber2(n);
	}
	
	// another way
	static boolean palindrome(String n) {
		
		if(n.length() ==0 || n.length() ==1) {
			return true;
		}
		if(n.charAt(0) == n.charAt(n.length() -1)) {
			return palindrome(n.substring(1, n.length() -1));
		} else {
			return false;
		}
	}
	static boolean palindrome2(String str) {
		return helper(str,0,str.length()-1);
	}

	private static boolean helper(String str, int start, int end) {
		if(str.length() ==0 || str.length() ==1 || start == end) {
			return true;
		}
		if(start >end) {
			return false;
		}
		if(str.charAt(start) == str.charAt(end)) {
			return helper(str.substring(start, end), start +1, end-1);
		}
		return false;
	}
	
	
}
