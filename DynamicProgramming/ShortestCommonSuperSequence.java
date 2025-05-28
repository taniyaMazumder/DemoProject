package DynamicProgramming;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String s1= "AGGTAB";
		String s2= "GXTXAYB";
		System.out.println(shortestSubSeq(s1,s2));

	}

	private static int shortestSubSeq(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] t = new int[n+1][m+1];
		// initialization of matrix t
				for (int i = 0; i < n+1; i++) {
					for (int j = 0; j < m+1; j++) {
						if( i==0 || j==0) {
							t[i][j] = 0;
						}
					}
				}
		// find LCS
				for(int i=1;i< n+1;i++) {
					for (int j = 1; j < m+1; j++) {
						if(str1.charAt(i -1) == str2.charAt(j -1)) {
							t[i][j] = 1+ t[i -1][j-1];
						}else {
							t[i][j] = Math.max(t[i-1][j], t[i][j-1]) ;
						}
					}
				}
		return (n +m) - t[n][m];
	}
}
