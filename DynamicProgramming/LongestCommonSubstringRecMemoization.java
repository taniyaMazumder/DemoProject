package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstringRecMemoization {

	public static void main(String[] args) {
		String s1= "cabbaak";
		String s2= "sabbaba";
		System.out.println(lcSubStringMemoization(s1,s2));
	}
	//static int ans =0;
	static int findLengthLCSRec(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		return helper(str1,str2,n,m,0);
		
	}

	private static int helper(String str1, String str2, int n, int m,int ans) {
		if(n==0 || m==0) {
			return ans;
		}
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
    		ans = helper(str1,str2,n-1,m-1,ans +1);
		} 
			return Math.max(ans, Math.max(helper(str1,str2, n-1,m,0), helper(str1,str2, n,m -1,0)));
	}
	
	static int lcSubStringMemoization(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] t = new int[n+1][m+1];
		for(int[] matrix : t) {
			Arrays.fill(matrix, -1);
		}
		return helperMemo(str1,str2,n,m,0,t);
	}
	private static int helperMemo(String str1, String str2, int n, int m, int res, int[][] t) {
		// Base condition
		if(n==0 || m==0) {
			return res;
		}
		if(t[n][m] != -1) {
			return t[n][m];
		}
		if(str1.charAt(n -1) == str2.charAt(m -1)) {
			t[n][m] = helperMemo(str1,str2,n-1,m-1,res +1,t);
		}
		return t[n][m] = Math.max(res, Math.max(helperMemo(str1,str2, n-1,m,0,t), helperMemo(str1,str2, n,m -1,0,t)));
	}
}
