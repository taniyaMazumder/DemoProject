package DynamicProgramming;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		String s1= "AABEBCDD";
		System.out.println(repeatingLongestCommonSubsequence(s1));

	}

	static int repeatingLongestCommonSubsequence(String s1) {
		int n = s1.length();
        int m = n;
		int[][] t = new int[n+1][m+1];
		
		// initialization of matrix t
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < m+1; j++) {
				if( i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}
		for(int i=1;i< n+1;i++) {
			for (int j = 1; j < m+1; j++) {
				if(s1.charAt(i -1) == s1.charAt(j -1) && i != j) {
					t[i][j] = 1+ t[i -1][j-1];
				}else {
					t[i][j] = Integer.max(t[i-1][j], t[i][j-1]) ;
				}
			}
		}
		
		return t[n][m];
	}

	

}
