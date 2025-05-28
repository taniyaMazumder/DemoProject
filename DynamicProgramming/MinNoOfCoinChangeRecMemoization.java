package DynamicProgramming;

public class MinNoOfCoinChangeRecMemoization {

	static int[][] t = new int[102][1002];
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 5;
	//	System.out.println(minNoOfCoinChange(coins, sum));
		System.out.println(minNoOfCoinChangeMemoization(coins, sum));
	}

	public static int minNoOfCoinChange(int[] coins, int sum) {
		return helper(coins,sum,coins.length);
	}

	private static int helper(int[] coins, int sum, int n) {
		// Base condition
		if(n==0 && sum>=0) {
			return Integer.MAX_VALUE -1;
		}
		if(n>0 && sum==0) {
			return 0;
		}
		if(n==1 && sum>=1) {
			if(sum % coins[0] ==0) {
				return sum / coins[0];
			} else {
				return Integer.MAX_VALUE -1;
			}
		}
		if(coins[n-1] <= sum) {
			return Math.min((1+ helper(coins,sum - coins[n-1] ,n)), helper(coins,sum ,n -1));
		}
		else {
			return helper(coins,sum ,n -1);
		}
	}
	// Memoization
	public static int minNoOfCoinChangeMemoization(int[] coins, int sum) {
		return helper2(coins,sum,coins.length);
	}

	private static int helper2(int[] coins, int sum, int n) {
		// Base condition
		if(n==0 && sum>=0) {
			return t[n][sum] = Integer.MAX_VALUE -1;
		}
		if(n>0 && sum==0) {
			return t[n][sum] = 0;
		}
		if(n==1 && sum>=1) {
			if(sum % coins[0] ==0) {
				return t[n][sum] = sum / coins[0];
			} else {
				return t[n][sum] = Integer.MAX_VALUE -1;
			}
		}
		if(coins[n-1] <= sum) {
			return t[n][sum] = Math.min((1+ helper(coins,sum - coins[n-1] ,n)), helper(coins,sum ,n -1));
		}
		else {
			return t[n][sum] = helper(coins,sum ,n -1);
		}
	}
}
