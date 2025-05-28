package DynamicProgramming;

public class PrintSCS {

	public static void main(String[] args) {
		String s1= "AGGTAB";
		String s2= "GXTXAYB";
		System.out.println(printShortestCommonSupersequence(s1,s2));

	}

public static String printShortestCommonSupersequence(String X, String Y) {
        
        int m = X.length();
        int n = Y.length();

        int t[][] = new int[m+1][n+1];
        
        
         for(int i =1; i<=m; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if(X.charAt(i-1) == Y.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        
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
}
