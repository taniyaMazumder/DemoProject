// Given a string and find longest Palindromic Substring 
// s= babad, then ans is "bab"
package DynamicProgramming;

public class PrintLongestPalindromicSubStringLeetCode {

	public static void main(String[] args) {
		String s= "aaaabbaa";
	//	System.out.println(bruteForce(s));
		System.out.println(palindromeSubstringDP(s));
	}
	
  // Find the length of Palindromic substring 
	static int findLengthPalindromicSubstring(String a) {
		StringBuffer sb = new StringBuffer(a);
		
		String b = sb.reverse().toString();
		
		int n = a.length();
		int m = b.length();
		int ansLen =0;
		int[][] t = new int[n +1][m+1];
		//initialize 0th row, 0th col
		
		for (int i = 0; i < n +1; i++) {
			for(int j=0; j < m+1; j++) {
				if(i ==0 || j ==0) {
					t[i][j] = 0;
				}
			}
		}
		
		//logic for 1st row
		for (int i = 1; i < n +1; i++) {
			for(int j=1; j < m+1; j++) {
				if(a.charAt(i-1) == b.charAt(j -1)) {
					t[i][j] = 1+ t[i -1][j - 1] ;
					ansLen = Math.max(ansLen, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return ansLen;
	}
//-------------------------------------------------------------------------------------------------------
	
	// brute force way to solve print substring
	// here TC- o(n^3)
	static int max =0; static int start =0, end =0;
	static String bruteForce(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if(helperPalindromCheck(s,i, j)) {
					if(j-i+1 > max) {
						max = j-i+1;
						start = i;
						end =j;
					}
				}
			}
		}
		return s.substring(start, end +1);
	}
	static boolean helperPalindromCheck(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
//-------------------------------------------------------------------------------------------------------
	// print the substring
	// using dp - TC- o(n^2)
	static String palindromeSubstringDP(String g) {
		int n = g.length();
		if(n ==1) {
			return g;
		}
		// dp[1][2] represents substring of s in range [1,2] inclusive is palindrome or not
		// 1 indicates palindrome in dp array and 0 represents not a palindrome
		int[][] t = new int[n][n];
		int start =0, end =0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j >=0; j--) {
				if(i == j) {
					t[i][j] = 1;
				}
				else if( i-j ==1) { // for substring of length 2 in upper triangular matrix
					if(g.charAt(i) == g.charAt(j)) {
						t[i][j] = 1;
					}
				}
				// check border character and substring inside current border indicated by i and j
				else if(g.charAt(i) == g.charAt(j) && t[i -1][j +1] ==1) {
					t[i][j] = 1;
				}
				// tracking maximum length for substring with index in s
				if (t[i][j] == 1 && i - j > end - start) {
					start = j;
					end = i;
				}
			}
		}
		return g.substring(start, end +1);
	}
// ---------------------------------------------------------------------------------------------------------------------
	// using Expand from centre approach - TC- O(n^2)
	
	// ex- bab
	static String palindromSubsUsingExpand(String t) {
		for (int i = 0; i < t.length(); i++) {
			// while string = "baab" then expand from i, i+1
			int evenLen = expandFromCentre(t,i,i+1);
			// while string = "bab" then expand from i, i
			int oddLen = expandFromCentre(t,i,i);
			int maxLen = Math.max(evenLen, oddLen);
			if(end - start < maxLen) {
				start = i -(maxLen -1)/2;
				System.out.println("start is:" +start);
				end = i +maxLen/2;
				System.out.println("end is:" +end);
			}
		}
		return t.substring(start, end +1);
	}

   private static int expandFromCentre(String t, int i, int j) {
		while(i >=0 && j<t.length() && t.charAt(i) == t.charAt(j)) {
			i--;
			j++;
		}
		System.out.println("window substring:" +(j-i-1));
		return j -i -1;
	
   }
	
}
