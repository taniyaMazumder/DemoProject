package DynamicProgramming;

import java.util.Arrays;

public class PrintLCSRecMemoization {

	public static void main(String[] args) {
		String s1= "XMJYAUZ";
		String s2= "MZJAWXU";
		System.out.println(printLCSMemo(s1,s2));

	}

	private static String printLCSMemo(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] t = new int[n+1][m+1];
		
		for(int[] matrix : t) {
			Arrays.fill(matrix, -1);
		}
	  helper(str1,str2,n,m,t);
	  int k=n;
	  int l= m;
	  
	  StringBuilder sb = new StringBuilder();
	  
	  while(k>0 && l>0) {
		  if(str1.charAt(k -1) == str2.charAt(l-1)) {
			  sb.append(String.valueOf(str1.charAt(k -1)));
			  k--;
			  l--;
		  } else {
			  if(str1.charAt(k-1) > str2.charAt(l -1)) {
				  k--;
			 } else {
				 l--;
			 }
		  }
	  }
	  String ans ="";
	  
	  ans = ans + sb.reverse().toString();
	  return ans;
}

	private static int helper(String str1, String str2, int n, int m, int[][] t) {
		if(n ==0 || m ==0) {
			return 0;
		}
		if(t[n][m] != -1) {
			return t[n][m];
		}
		if(str1.charAt(n -1) == str2.charAt(m -1)) {
			return t[n][m] = 1+ helper(str1,str2, n -1, m-1,t);
		}else {
			return t[n][m] = Integer.max(helper(str1,str2,n-1,m,t), helper(str1,str2,n,m -1,t)) ;
		}
	}
}
