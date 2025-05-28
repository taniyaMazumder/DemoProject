package DynamicProgramming;

public class KnapsackMemoization {

	static int[][] t = new int[102][1002];
	static void memset(int[][] t , int init) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				t[i][j] = init;
			}
		}
	}
	public static void main(String[] args) {
		memset(t, -1);
		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int w = 7;
		System.out.println(knapsackMem(wt, val,w,wt.length -1));
	}
	public static int knapsackMem(int[] wt, int[] val, int w, int n) {
		if( n==0 || w==0) {
			return 0;
		}
		if(t[n][w] != -1) {
			return t[n][w];
		}
		if(wt[n-1] <=w) {
			return t[n][w] = Math.max(val[n-1] + knapsackMem(wt, val, w - wt[n-1],n-1), knapsackMem(wt, val, w ,n-1));
		} else {
			return t[n][w] = knapsackMem(wt, val, w ,n-1);
		}
	}
}
