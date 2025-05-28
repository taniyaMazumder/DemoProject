// Find out length of string 

package DynamicProgramming;

public class LongestCommonSequenceRecursion {

	public static void main(String[] args) {
		String s1= "abcde";
		String s2= "abce";
		System.out.println(longestCommonSubsequence(s1,s2));

	}
	static int findLengthLCS(String s1, String s2, int n, int m) {
		if(n ==0 || m ==0) {
			return 0;
		}
		if(s1.charAt(n -1) == s2.charAt(m -1)) {
			return 1+ findLengthLCS(s1,s2, n -1, m-1);
		}else {
			return Integer.max(findLengthLCS(s1,s2,n-1,m), findLengthLCS(s1,s2,n,m -1)) ;
		}
	}

	public static int longestCommonSubsequence(String text1, String text2) {
        
        return findLengthLCS(text1, text2, text1.length(), text2.length());
    }
}
