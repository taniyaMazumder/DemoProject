package DynamicProgramming;

public class SequencePatternMatching {

	public static void main(String[] args) {
		String s1= "AXY";
		String s2 = "ADXCPY";
		System.out.println(isSubsequence(s1,s2));

	}
	public static boolean isSubsequence(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        if(n == 0){return true;}
        
        int t[][] = new int[n+1][m+1];
        
     // initialization of matrix t
     		for (int i = 0; i < n+1; i++) {
     			for (int j = 0; j < m+1; j++) {
     				if( i==0 || j==0) {
     					t[i][j] = 0;
     				}
     			}
     		}
        
        for(int i =1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        
        if(n == t[n][m]){
        	return true;
        }
        
        return false;
        
    }

}
