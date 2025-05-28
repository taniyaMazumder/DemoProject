// There's a string array. Find out longest common prefix string from this array
// output is: print "gee"
package DynamicProgramming;

public class LongestCommonPrefix {

	public static void main(String[] args) {
//		String[] arr= {"geeksforgeeks", "geeks", "geek", "geezer"};
//		String[] arr= {"flower","flow","flight"};
		String[] arr= {"akanksha", "akaksha","akaaka","akadaka"};
		System.out.println(printLongestCommonSubstringPrefix(arr));

	}

	// Find out length of longest common prefix string
	// Intuition - Compare the characters in the first and last strings in the array. Since the array is sorted, common characters among the first and last element will be common among all the elements of the array.

	//2.1. If they are same, then append the character to the result.

	//2.2. Else, stop the comparison – result contains the longest common prefix among the strings in the array.
	static int findLengthLongestCommonSubstring(String[] str) {
		int ans =0;
		String first = str[0];
		int n = first.length();
		int m = str[str.length-1].length();
		int[][] t = new int[n+1][m+1];
			// starting from 2nd row
			
			for (int i = 1; i < n +1; i++) {
				for(int j=1; j < m+1; j++) {
					if(first.charAt(i-1) == str[str.length-1].charAt(j -1)) {
						t[i][j] = 1+ t[i -1][j - 1] ;
						 ans = Math.max(ans, t[i][j]);
					} else {
						t[i][j] = 0;
					}
				}
		}
		return ans;
	}
	// print the longest common prefix
	private static String printLongestCommonSubstringPrefix(String[] str) {
		// find LCS
	//	int ans =0;
		String first = str[0];
		String last = str[str.length -1];
		
		int n = first.length();
		int m = last.length();
		
		int[][] t = new int[n+1][m+1];
			// starting from 2nd row
			
			for (int i = 1; i < n +1; i++) {
				for(int j=1; j < m+1; j++) {
					if(first.charAt(i-1) == last.charAt(j -1)) {
						t[i][j] = 1+ t[i -1][j - 1] ;
					} else {
						t[i][j] = 0;
					}
				}
		}
		// code for print LCS
		
		int k = n;
		int l = m;
		
		StringBuffer sb = new StringBuffer();
		while(k>0 && l>0) {
			if(first.charAt(k-1) == last.charAt(l -1)) {
				sb.append(String.valueOf(first.charAt(k-1)));
				k--;
				l--;
			}
			else {
				if(t[k][l-1] > t[k-1][l]) {
					l--;
				} 
				
				else {
					k--;
				}
			}
		}
		String ans = "";
		ans = ans + sb.reverse().toString();
		return ans;
	}
}
