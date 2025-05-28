package DynamicProgramming;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int w = 7;
		System.out.println(unboundedKnapsack(wt, val,w,wt.length -1));
	}
	public static int unboundedKnapsack(int[] wt, int[] val, int w, int n) {
		int[][] t = new int[n+1][w+1];
		
		// initialization of matrix t
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				if( i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if(wt[i-1] <=j) {
					t[i][j] = Math.max(val[i-1] + t[i][j - wt[i-1]] , t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}

}
