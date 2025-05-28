package DynamicProgramming;

public class CoinChangeCountNoOfWaysRecMemoization {

	static int[][] t = new int[102][1002];
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 5;
	//	System.out.println(noOfWaysCountRec(coins, sum));
		System.out.println(noOfWaysCountMemoization(coins, sum));

	}
	public static int noOfWaysCountRec(int[] coins, int sum) {
		 return helper(coins, sum, coins.length);
	}
	private static int helper(int[] coins, int sum, int n) {
		// Base condition
		if(n>=0 && sum ==0) {
			return 1;
		}
		if(n==0 && sum >0) {
			return 0;
		}
		if(coins[n-1] <= sum) {
			return helper(coins,sum - coins[n-1], n) + helper(coins,sum, n -1);
		}
		else {
			return helper(coins,sum, n -1);
		}
	}
	// memoization
	public static int noOfWaysCountMemoization(int[] coins, int sum) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				t[i][j] =-1;
			}
		}
		 return helper2(coins, sum, coins.length);
	}
	private static int helper2(int[] coins, int sum, int n) {
		if(n>=0 && sum ==0) {
			return t[n][sum] = 1;
		}
		if(n==0 && sum >0) {
			return t[n][sum] = 0;
		}
		if(t[n][sum] != -1) {
			return t[n][sum];
		}
		else {
			if(coins[n-1] <= sum) {
				return t[n][sum] = helper(coins,sum - coins[n-1], n) + helper(coins,sum, n -1);
			}
			else {
				return t[n][sum] = helper(coins,sum, n -1);
			}
		}
		
	}
}
