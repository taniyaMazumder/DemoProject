package DynamicProgramming;

public class LongestCommonSequenceTopDown {

	public static void main(String[] args) {
		String s1= "abcde";
		String s2= "abce";
		System.out.println(longestCommonSubsequenceTopDown(s1,s2));

	}

	static int findLengthLCS(String s1, String s2, int n, int m) {
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
				if(s1.charAt(i -1) == s2.charAt(j -1)) {
					t[i][j] = 1+ t[i -1][j-1];
				}else {
					t[i][j] = Integer.max(t[i-1][j], t[i][j-1]) ;
				}
			}
		}
		
		return t[n][m];
	}

	public static int longestCommonSubsequenceTopDown(String text1, String text2) {
        
        return findLengthLCS(text1, text2, text1.length(), text2.length());
    }
}
