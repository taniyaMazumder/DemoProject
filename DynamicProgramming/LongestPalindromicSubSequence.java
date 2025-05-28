package DynamicProgramming;

public class LongestPalindromicSubSequence {

	public static void main(String[] args) {
		String a ="agbcba";
		System.out.println(palindromicPrintLCS(a));
   }
	// find length of LCS
	static int palindromicLCS(String a) {
		StringBuffer sb = new StringBuffer(a);
		
		String b = sb.reverse().toString();
		
		int n = a.length();
		int m = b.length();
		
		int[][] t = new int[n +1][m+1];
		//initialize 0th row, 0th col
		
		for (int i = 0; i < n +1; i++) {
			for(int j=0; j < m+1; j++) {
				if(i ==0 || j ==0) {
					t[i][j] = 0;
				}
			}
		}
		
		//logic for 1st row
		for (int i = 1; i < n +1; i++) {
			for(int j=1; j < m+1; j++) {
				if(a.charAt(i -1) == b.charAt(j -1)) {
					t[i][j] = 1+ t[i-1][j-1];  
				} else {
					t[i][j] = Math.max(t[i][j-1], t[i -1][j]) ;
				}
			}
		}
		return t[n][m];
	}
	// print LCS
	// code for print LCS
	static String palindromicPrintLCS(String a) {
		StringBuffer sb = new StringBuffer(a);
		
		String b = sb.reverse().toString();
		
		int n = a.length();
		int m = b.length();
		
		int[][] t = new int[n +1][m+1];
		//initialize 0th row, 0th col
		
		for (int i = 0; i < n +1; i++) {
			for(int j=0; j < m+1; j++) {
				if(i ==0 || j ==0) {
					t[i][j] = 0;
				}
			}
		}
		
		//logic for 1st row
		for (int i = 1; i < n +1; i++) {
			for(int j=1; j < m+1; j++) {
				if(a.charAt(i -1) == b.charAt(j -1)) {
					t[i][j] = 1+ t[i-1][j-1];  
				} else {
					t[i][j] = Math.max(t[i][j-1], t[i -1][j]) ;
				}
			}
		}
			int k =n; // row
			int l = m; // col
			StringBuffer sb2 = new StringBuffer();
			
			while(k >0 && l >0) {
				if(a.charAt(k -1) == b.charAt(l -1)) {
					sb2.append(String.valueOf(a.charAt(k-1)));
					k--;
					l--;
				} else {
					if(t[k][l-1] > t[k-1][l]) {
						l--;
					} else {
						k--;
					}
				}
			}
			String ans ="";
			// using stringbuilder
			ans = ans + sb2.reverse().toString();
			
			return ans;	
		}
}
