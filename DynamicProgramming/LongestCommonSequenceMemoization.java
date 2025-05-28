package DynamicProgramming;

public class LongestCommonSequenceMemoization {

	static int[][] t = new int[1002][1002];
	static void memset(int[][] t , int init) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				t[i][j] = init;
			}
		}
	}
	public static void main(String[] args) {
		memset(t, -1);
		String s1= "abcde";
		String s2= "abce";
		System.out.println(longestCommonSubsequenceMemoization(s1,s2));

	}
	static int findLengthLCS(String s1, String s2, int n, int m) {
		if(n ==0 || m ==0) {
			return 0;
		}
		if(t[n][m] != -1) {
			return t[n][m];
		}
		if(s1.charAt(n -1) == s2.charAt(m -1)) {
			return t[n][m] = 1+ findLengthLCS(s1,s2, n -1, m-1);
		}else {
			return t[n][m] = Integer.max(findLengthLCS(s1,s2,n-1,m), findLengthLCS(s1,s2,n,m -1)) ;
		}
	}

	public static int longestCommonSubsequenceMemoization(String text1, String text2) {
        
        return findLengthLCS(text1, text2, text1.length(), text2.length());
    }
}
