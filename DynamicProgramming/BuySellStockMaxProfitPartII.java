package DynamicProgramming;

import java.util.Arrays;

public class BuySellStockMaxProfitPartII {

	public static void main(String[] args) {
		int[] ar = {7,1,5,3,6,4};
		System.out.println(findMaxProftMemoization(ar));

	}

	static int findMaxProftRec(int[] prices) {
		int buy =1;
		return helper(prices, 0,buy );
	}

	private static int helper(int[] prices, int index, int buy) {
		// base condition
		if(index == prices.length) {
			return 0;
		}
		int maxProfit =0;
		if(buy ==1) {
			maxProfit = Math.max(-prices[index] + helper(prices, index+1, 0), helper(prices, index+1, 1));
		}
		else {
			maxProfit = Math.max(prices[index] + helper(prices, index+1, 1), helper(prices, index+1, 0));
		}
		return maxProfit;
	}
	// memoization
	static int[][] t = new int[1002][1002];
	static int findMaxProftMemoization(int[] prices) {
		for(int[] matrix: t) {
			Arrays.fill(matrix, -1);
		}
		int buy =1;
		return helper2(prices, 0,buy);
	}
	private static int helper2(int[] prices, int index, int buy) {
		// base condition
		if(index == prices.length) {
			return 0;
		}
		if(t[index][buy] != -1) {
			return t[index][buy];
		}
		int maxProfit =0;
		if(buy ==1) {
			maxProfit = Math.max(-prices[index] + helper2(prices, index+1, 0), helper2(prices, index+1, 1));
		}
		else {
			maxProfit = Math.max(prices[index] + helper2(prices, index+1, 1), helper2(prices, index+1, 0));
		}
		
		return t[index][buy] = maxProfit;
	}
	//Another way of Memorization
	static int[][] dp ;
    public int maxProfit(int[] prices) {
        int index =prices.length, buy =1; 
        dp = new int[index+1][buy+1];
        for(int[] matrix: dp){
            Arrays.fill(matrix, -1);
        }
        return helper(prices, 0, 1,dp);
    }
    int helper(int[] prices, int index, int buy,int[][] dp) {
		// base condition
		if(index == prices.length) {
			return 0;
		}
		if(t[index][buy] != -1) {
			return t[index][buy];
		}
		int maxProfit =0;
		if(buy ==1) {
			maxProfit = Math.max(-prices[index] + helper(prices, index+1, 0,dp), helper(prices, index+1, 1,dp));
		}
		else {
			maxProfit = Math.max(prices[index] + helper(prices, index+1, 1,dp), helper(prices, index+1, 0,dp));
		}
		
		return t[index][buy] = maxProfit;
    }
}
