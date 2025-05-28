package DynamicProgramming;

public class RodCutting {

	public static void main(String[] args) {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		int N = 8;
		System.out.println(rodCutting(prices, N));

	}

	public static int rodCutting(int[] prices, int n) {
		int w = prices.length;
        int wt[] = new int[w];
        
        for(int i =0; i<n; i++){wt[i] = i+1;}
        
		int[][] t = new int[n+1][w+1];
		// initialize 0 and 1
		// initialize 0th row
		for (int i = 0; i < w +1; i++) {
			t[0][i] = 0;
		}
		// initialize 0th col
		for (int i = 0; i < n +1; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if(wt[i-1] <=j) {
					t[i][j] = Math.max(prices[i-1] + t[i][j - wt[i-1]] , t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
}
