package DynamicProgramming;

public class SCSRecursion {

	public static void main(String[] args) {
		String s1= "AGGTAB";
		String s2= "GXTXAYB";
		System.out.println(ShortestCommonSupersequenceRec(s1,s2,s1.length(),s2.length()));

	}
	public static int ShortestCommonSupersequenceRec(String X, String Y, int m , int n) {
 
		return (m+n) - lcs(X,Y,m,n);
		
	}
	private static int lcs(String x, String y, int m, int n) {
		if(m==0 || n==0) {
			return 0;
		}
		if(x.charAt(m-1) == y.charAt(n -1)) {
			return 1+ lcs(x,y,m-1,n-1);
		}
		else {
			return Math.max(lcs(x,y,m-1,n), lcs(x,y,m,n -1));
		}
	}
	
		
}
