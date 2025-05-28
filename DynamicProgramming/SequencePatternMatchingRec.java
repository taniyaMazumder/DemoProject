package DynamicProgramming;

public class SequencePatternMatchingRec {

	public static void main(String[] args) {
		String s1= "AXY";
		String s2 = "ADXCPY";
		System.out.println(isSubsequence(s1,s2));

	}

public static boolean isSubsequence(String s1, String s2) {
        int res= helper(s1,s2,s1.length(),s2.length());
        if(s1.length() == res) {
        	return true;
        } else {
        	return false;
        }
   }

private static int helper(String s1, String s2, int n, int m) {
	if(n==0 || m==0) {
		return 0;
	}
	
	if(s1.charAt(n-1) == s2.charAt(m-1)) {
		return 1+ helper(s1,s2,n-1,m-1);
	}
	else {
		return Integer.max(helper(s1,s2,n-1,m), helper(s1,s2,n,m -1)) ;
	}
	
}
}
