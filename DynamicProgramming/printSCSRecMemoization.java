package DynamicProgramming;

import java.util.Arrays;

public class printSCSRecMemoization {

	public static void main(String[] args) {
		String s1= "AGGTAB";
		String s2= "GXTXAYB";
		System.out.println(printSCSRec(s1,s2));

	}

	public static String printSCSRec(String X, String Y) {
        
        int m = X.length();
        int n = Y.length();
        int t[][] = new int[m+1][n+1];
        
        for(int[] matrix : t) {
			Arrays.fill(matrix, -1);
		}
	    helper(X,Y,m,n,t);
	    
	    int i = X.length();
        int j = Y.length();
        
        String str = "";
        
        while(i>0 && j>0)
        {
            if(X.charAt(i-1) == Y.charAt(j-1))
            {
                str += X.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(t[i][j-1] > t[i-1][j])
                {
                    str += Y.charAt(j-1);
                    j--;
                }else{
                     str += X.charAt(i-1);
                     i--;
                }
            }
        }
        
        while(i>0)
        {
            str += X.charAt(i-1);
            i--;
        }
        while(j>0)
        {
            str += Y.charAt(j-1);
            j--;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        
        return sb.toString();
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
