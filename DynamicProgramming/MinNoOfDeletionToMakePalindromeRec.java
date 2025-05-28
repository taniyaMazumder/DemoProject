// Given a string . delete min no of char from that string that it can make palindrome
// Longest palindromic subsequence = 1/ (min no of deletion)
package DynamicProgramming;

public class MinNoOfDeletionToMakePalindromeRec {

	public static void main(String[] args) {
		String s = "agbcba";
		System.out.println(minDeletion(s));
	}

	static int minDeletion(String s) {
		StringBuffer sb = new StringBuffer(s);
		String t = sb.reverse().toString();
		return helper(s,t,s.length(),t.length());
	}

	private static int helper(String s, String t, int slength, int tlength) {
		// Base condition
		if(slength ==0 || tlength ==0) {
			return 0;
		}
		if(s.charAt(slength -1) == t.charAt(tlength -1)) { // agbcba here slength is 6 and LPS is abcbc = 5, min no of deletion = 6-5=1
			return  slength - (1+ helper(s,t,slength -1 ,tlength -1));
		}
		else {
			return  slength - (Math.max(helper(s,t,slength -1 ,tlength) , helper(s,t,slength ,tlength -1)));
		}
	}
	
}
