package DynamicProgramming;

public class MinInsertionDeletionLCS {

	public static void main(String[] args) {
		String s1= "heap";
		String s2= "pea";
		System.out.println(minInsertionDeletion(s1,s2));

	}
	public static int minInsertionDeletion(String X, String Y) {
        
	      //Your code here
	        int m = X.length();
	        int n = Y.length();
	        int t[][] = new int[m+1][n+1];
	        
	        for(int i =0; i<=m; i++)
	        {
	            for(int j =0; j<=n; j++)
	            {
	                if(i==0||j==0)
	                {
	                    t[i][j] = 0;
	                }
	            }
	        }
	        
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
	        
	        int deletion = m-t[m][n]; // a(length) - lcs = deletion
	        int insertion = n-t[m][n]; // b(length) - lcs = insertion
	        
	        return deletion + insertion;
	        
	    }

}
