package DynamicProgramming;

import java.util.Arrays;

public class PrintLPalindromicSubStringLeetCode2 {

	public static void main(String[] args) {
		String s= "babad";
		System.out.println(findLengthLCSubstring(s));

	}
	
	// return length of longest common Palindromic subString
	
	static int findLengthLCSubstring(String str) {
		StringBuffer sb = new StringBuffer(str);
		String str2 = sb.reverse().toString();
		
		int n = str.length();
		int m = str2.length();
		
		return helper(str,str2,n,m,0);
		
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

	 // Print length of longest common Palindromic subString
	private static String palindromSubstring(String s) {
		StringBuffer sb = new StringBuffer(s);
		String p = sb.reverse().toString();
		
		int n = s.length();
        int m = p.length();
        int t[][] = new int[n+1][m+1];
        
        for(int[] matrix : t) {
			Arrays.fill(matrix, -1);
		}
        helperMemo(s,p,n,m,0,t);
	    
	    int i = s.length();
        int j = p.length();
        // start print LP Substring
        
        String str = "";
        while(i>0 && j>0) {
        	if(s.charAt(i -1) == p.charAt(j -1)) {
        		 str += s.charAt(i -1);
        		 i--;
        		 j--;
        	} else{
                if(t[i][j-1] > t[i-1][j])
                {
                    str += p.charAt(j-1);
                    j--;
                }else{
                     str += s.charAt(i-1);
                     i--;
                }
            }
        }
        
        while(i>0)
        {
            str += s.charAt(i-1);
            i--;
        }
        while(j>0)
        {
            str += p.charAt(j-1);
            j--;
        }
        StringBuffer sb2 = new StringBuffer();
        sb2.append(str);
        sb2.reverse();
        
        return sb2.toString();
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
