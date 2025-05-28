package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSequenceMemoization2 {

	public static void main(String[] args) {
		String s1= "abcde";
		String s2= "abce";
		int[][] t = new int[s1.length()+1][s2.length()+1];
		for(int[] matrix : t) {
			Arrays.fill(matrix, -1);
		}
	//	System.out.println(longestCommonSubsequenceMemoization(s1,s2));
		System.out.println(findLengthLCS(s1,s2,s1.length(),s2.length(),t));

	}

	static int findLengthLCS(String s1, String s2, int n, int m, int[][] t) {
		if(n ==0 || m ==0) {
			return 0;
		}
		if(t[n][m] != -1) {
			return t[n][m];
		}
		if(s1.charAt(n -1) == s2.charAt(m -1)) {
			return t[n][m] = 1+ findLengthLCS(s1,s2, n -1, m-1,t);
		}else {
			return t[n][m] = Integer.max(findLengthLCS(s1,s2,n-1,m,t), findLengthLCS(s1,s2,n,m -1,t)) ;
		}
	}

	public static int longestCommonSubsequenceMemoization(String text1, String text2) {
		int[][] t = new int[text1.length()+1][text2.length()+1];
        
        return findLengthLCS(text1, text2, text1.length(), text2.length(),t);
    }
}
