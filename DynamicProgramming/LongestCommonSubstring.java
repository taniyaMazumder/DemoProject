package DynamicProgramming;

public class LongestCommonSubstring {

	public static void main(String[] args) {
//		String s1= "abcde";
//		String s2= "abfce";
		String s1= "cabbaak";
		String s2= "sabbaba";
//		System.out.println(findLengthLongestCommonSubstring(s1,s2));
		System.out.println(findLengthLongestCommonSubstring(s1,s2));

	}
	static int findLengthLongestCommonSubstring(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] t = new int[n+1][m+1];
		
		int ans =0;
		// starting from 2nd row
		
		for (int i = 1; i < n +1; i++) {
			for(int j=1; j < m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j -1)) {
					t[i][j] = 1+ t[i -1][j - 1] ;
					 ans = Math.max(ans, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
			
		}
		return ans;
	}

	// print substring
	static String printLongestCommonSubstring(String str1, String str2) {
		StringBuffer ans = new StringBuffer();
		int n = str1.length();
		int m = str2.length();
		
		int[][] t = new int[n+1][m+1];
		
		int ansLen =0;
		
		for (int i = 0; i < n +1; i++) {
			for(int j=0; j < m+1; j++) {
				if(i ==0 || j ==0) {
					t[i][j] = 0;
				}
			}
		}
		// starting from 2nd row
		
		for (int i = 1; i < n +1; i++) {
			for(int j=1; j < m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j -1)) {
					t[i][j] = 1+ t[i -1][j - 1] ;
					ansLen = Math.max(ansLen, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		int k = n;
		int l = m;
		
		while( k> 0 && l >0) {
			if(str1.charAt(k -1) == str2.charAt(l -1)) {
				ans.append(str1.charAt(k -1));
 				k--;
				l--;
			}
			else {
				if(t[k][l-1] > t[k-1][l]) {
//					if(!ans.isEmpty()) {
//						ans.deleteCharAt(0);
//					}
					l--;
				} else {
//					if(!ans.isEmpty()) {
//						ans.deleteCharAt(0);
//					}
					k--;
				}
			}
		}
		String final_ans ="";
		final_ans = final_ans + ans.reverse().toString();
		return final_ans;
	}
}
