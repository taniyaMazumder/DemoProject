package Recursion;

public class kthGrammerRec {

	public static void main(String[] args) {
		int n = 1, k = 1;
		System.out.println(solve(n,k));

	}

	static int solve(int N, int K) {
		// Base Condition
		if(N==1 && K==1) {
			return 0;
		}
		int mid = ((int) Math.pow(2, N-1)) /2;
		if(K <=mid) {
			return solve(N-1,K);
		}
		else {
			return 1-solve(N-1, K-mid);
			
		}
	}
}
