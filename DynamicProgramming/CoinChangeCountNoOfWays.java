 package DynamicProgramming;

public class CoinChangeCountNoOfWays {

	public static void main(String[] args) {
		int[] coins = {1,1,2,3};
		int sum = 5;
		System.out.println(noOfWaysCount(coins, sum));

	}

	public static int noOfWaysCount(int[] coins, int sum) {
		int n = coins.length;
        
        
		int[][] t = new int[n+1][sum+1];
		// initialize 0 and 1
		// initialize 0th row
		for (int i = 0; i < sum +1; i++) {
			t[0][i] = 0;
		}
		// initialize 0th col
		for (int i = 0; i < n +1; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(coins[i-1] <=j) {
					t[i][j] = t[i][j - coins[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}
}
